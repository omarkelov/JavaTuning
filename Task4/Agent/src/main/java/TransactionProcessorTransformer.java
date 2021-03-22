import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import javassist.expr.ExprEditor;
import javassist.expr.MethodCall;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;

public class TransactionProcessorTransformer implements ClassFileTransformer {

    private final Class<?> clazz;

    public TransactionProcessorTransformer(Class<?> clazz) {
        this.clazz = clazz;
    }

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain, byte[] classfileBuffer)
    {
        if (!className.equals(clazz.getName().replaceAll("\\.", "/"))) {
            return classfileBuffer;
        }

        byte[] byteCode = classfileBuffer;
        if (loader.equals(clazz.getClassLoader())) {
            try {
                ClassPool classPool = ClassPool.getDefault();
                CtClass ctClass = classPool.get(clazz.getName());

                CtMethod ctMethodProcessTransaction = ctClass.getDeclaredMethod("processTransaction");
                ctMethodProcessTransaction.insertBefore("txNum += 99;");

                CtMethod ctMethodMain = ctClass.getDeclaredMethod("main");
                ctMethodMain.addLocalVariable("max", CtClass.longType);
                ctMethodMain.addLocalVariable("min", CtClass.longType);
                ctMethodMain.addLocalVariable("sum", CtClass.longType);
                ctMethodMain.addLocalVariable("count", CtClass.longType);
                ctMethodMain.insertBefore(
                    "min = Long.MAX_VALUE;" +
                        "max = sum = count = 0;"
                );
                ctMethodMain.insertAfter(
                    "System.out.println(\"Max: \" + max);" +
                        "System.out.println(\"Min: \" + min);" +
                        "System.out.println(\"Average: \" + (sum / count));"
                );
                ctMethodMain.instrument(new ExprEditor() {
                    public void edit(MethodCall methodCall) throws CannotCompileException {
                        if (methodCall.getClassName().equals(clazz.getName()) &&
                            methodCall.getMethodName().equals("processTransaction"))
                        {
                            methodCall.replace(
                                "long startTime = System.currentTimeMillis();" +
                                    "tp.processTransaction(i);" +
                                    "long time = System.currentTimeMillis() - startTime;" +
                                    "if (time > max) max = time;" +
                                    "if (time < min) min = time;" +
                                    "sum += time;" +
                                    "count++;"
                            );
                        }
                    }
                });

                byteCode = ctClass.toBytecode();
                ctClass.detach();
            } catch (NotFoundException | CannotCompileException | IOException e) {
                e.printStackTrace();
            }
        }

        return byteCode;
    }
}
