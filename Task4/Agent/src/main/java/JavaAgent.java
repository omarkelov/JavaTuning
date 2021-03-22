import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

public class JavaAgent {
    public static void premain(String agentArgs, Instrumentation instrumentation) throws ClassNotFoundException, UnmodifiableClassException {
        Class<?> clazz = Class.forName("TransactionProcessor");

        instrumentation.addTransformer(new TransactionProcessorTransformer(clazz), true);
        instrumentation.retransformClasses(clazz);

        System.out.println("Loaded classes: " + instrumentation.getAllLoadedClasses().length);
    }
}
