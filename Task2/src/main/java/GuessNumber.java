import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.objectweb.asm.ClassWriter.COMPUTE_FRAMES;
import static org.objectweb.asm.ClassWriter.COMPUTE_MAXS;

public class GuessNumber implements Opcodes {
    public static void main(String[] args) throws IOException {
        ClassWriter classWriter = new ClassWriter(COMPUTE_MAXS | COMPUTE_FRAMES);

        classWriter.visit(V15, ACC_PUBLIC, "GuessNumber", null, "java/lang/Object", null);

        MethodVisitor methodVisitor = classWriter.visitMethod(ACC_PUBLIC | ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
        methodVisitor.visitCode();

        // int var1 = ThreadLocalRandom.current().nextInt(1, 101);
        methodVisitor.visitMethodInsn(INVOKESTATIC, "java/util/concurrent/ThreadLocalRandom", "current", "()Ljava/util/concurrent/ThreadLocalRandom;", false);
        methodVisitor.visitInsn(ICONST_1);
        methodVisitor.visitIntInsn(BIPUSH, 101);
        methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/util/concurrent/ThreadLocalRandom", "nextInt", "(II)I", false);
        methodVisitor.visitVarInsn(ISTORE, 1);

        // Scanner var2 = new Scanner(System.in);
        methodVisitor.visitTypeInsn(NEW, "java/util/Scanner");
        methodVisitor.visitInsn(DUP);
        methodVisitor.visitFieldInsn(GETSTATIC, "java/lang/System", "in", "Ljava/io/InputStream;");
        methodVisitor.visitMethodInsn(INVOKESPECIAL, "java/util/Scanner", "<init>", "(Ljava/io/InputStream;)V", false);
        methodVisitor.visitVarInsn(ASTORE, 2);

        // System.out.println("I've thought a number, try to guess!");
        methodVisitor.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        methodVisitor.visitLdcInsn("I've thought a number, try to guess!");
        methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);

        // while(var2.hasNextInt()) {
        Label label0 = new Label();
        methodVisitor.visitLabel(label0);
        methodVisitor.visitFrame(Opcodes.F_APPEND,2, new Object[] {Opcodes.INTEGER, "java/util/Scanner"}, 0, null);
        methodVisitor.visitVarInsn(ALOAD, 2);
        methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/util/Scanner", "hasNextInt", "()Z", false);

        // int var3 = var2.nextInt();
        Label label1 = new Label();
        methodVisitor.visitJumpInsn(IFEQ, label1);
        methodVisitor.visitVarInsn(ALOAD, 2);
        methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/util/Scanner", "nextInt", "()I", false);
        methodVisitor.visitVarInsn(ISTORE, 3);

        // if (var1 == var3) {
        methodVisitor.visitVarInsn(ILOAD, 1);
        methodVisitor.visitVarInsn(ILOAD, 3);
        Label label2 = new Label();
        methodVisitor.visitJumpInsn(IF_ICMPNE, label2);

        // System.out.println("Exactly! Good bye!");
        methodVisitor.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        methodVisitor.visitLdcInsn("Exactly! Good bye!");
        methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);

        // break;
        methodVisitor.visitJumpInsn(GOTO, label1);

        // if (var1 > var3) {
        methodVisitor.visitLabel(label2);
        methodVisitor.visitFrame(Opcodes.F_APPEND,1, new Object[] {Opcodes.INTEGER}, 0, null);
        methodVisitor.visitVarInsn(ILOAD, 1);
        methodVisitor.visitVarInsn(ILOAD, 3);
        Label label3 = new Label();
        methodVisitor.visitJumpInsn(IF_ICMPLE, label3);

        // System.out.println("Greater");
        methodVisitor.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        methodVisitor.visitLdcInsn("Greater");
        methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
        Label label4 = new Label();
        methodVisitor.visitJumpInsn(GOTO, label4);

        // System.out.println("Lower");
        methodVisitor.visitLabel(label3);
        methodVisitor.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
        methodVisitor.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        methodVisitor.visitLdcInsn("Lower");
        methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
        methodVisitor.visitLabel(label4);

        methodVisitor.visitFrame(Opcodes.F_CHOP,1, null, 0, null);
        methodVisitor.visitJumpInsn(GOTO, label0);
        methodVisitor.visitLabel(label1);
        methodVisitor.visitFrame(Opcodes.F_SAME, 0, null, 0, null);

        // var2.close();
        methodVisitor.visitVarInsn(ALOAD, 2);
        methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/util/Scanner", "close", "()V", false);

        methodVisitor.visitInsn(RETURN);
        methodVisitor.visitMaxs(0, 0);
        methodVisitor.visitEnd();

        classWriter.visitEnd();

        Files.write(Paths.get("GuessNumber.class"), classWriter.toByteArray());
    }
}
