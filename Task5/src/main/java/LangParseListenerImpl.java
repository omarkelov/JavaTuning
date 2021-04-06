import antlr.LangParser.AssignmentStatementContext;
import antlr.LangParser.BinaryArithmeticContext;
import antlr.LangParser.BinaryArithmeticSignContext;
import antlr.LangParser.BinaryLogicContext;
import antlr.LangParser.BinaryLogicSignContext;
import antlr.LangParser.CodeBlockContext;
import antlr.LangParser.CodeContext;
import antlr.LangParser.ComparisonContext;
import antlr.LangParser.ComparisonSignContext;
import antlr.LangParser.DeclarationStatementContext;
import antlr.LangParser.EmptyLineContext;
import antlr.LangParser.GotoExpressionContext;
import antlr.LangParser.GotoStatementContext;
import antlr.LangParser.IfStatementContext;
import antlr.LangParser.IfclauseContext;
import antlr.LangParser.IntAssignmentContext;
import antlr.LangParser.IntDeclarationContext;
import antlr.LangParser.IntLiteralContext;
import antlr.LangParser.LabelDeclarationContext;
import antlr.LangParser.LabelStatementContext;
import antlr.LangParser.MinusExpressionContext;
import antlr.LangParser.NegationContext;
import antlr.LangParser.NonEmptyLineContext;
import antlr.LangParser.ParenExpressionContext;
import antlr.LangParser.PrintArithmeticContext;
import antlr.LangParser.PrintLogicalContext;
import antlr.LangParser.PrintStatementContext;
import antlr.LangParser.PrintStrStatementContext;
import antlr.LangParser.PrintStringContext;
import antlr.LangParser.PrintstrContext;
import antlr.LangParser.StringAssignmentContext;
import antlr.LangParser.StringDeclarationContext;
import antlr.LangParser.StringLiteralContext;
import antlr.LangParser.VarReferenceContext;
import antlr.LangParserListener;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import static org.objectweb.asm.ClassWriter.COMPUTE_FRAMES;
import static org.objectweb.asm.ClassWriter.COMPUTE_MAXS;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_STATIC;
import static org.objectweb.asm.Opcodes.ACC_SUPER;
import static org.objectweb.asm.Opcodes.ALOAD;
import static org.objectweb.asm.Opcodes.ASTORE;
import static org.objectweb.asm.Opcodes.GETSTATIC;
import static org.objectweb.asm.Opcodes.GOTO;
import static org.objectweb.asm.Opcodes.IADD;
import static org.objectweb.asm.Opcodes.IAND;
import static org.objectweb.asm.Opcodes.ICONST_0;
import static org.objectweb.asm.Opcodes.ICONST_1;
import static org.objectweb.asm.Opcodes.IDIV;
import static org.objectweb.asm.Opcodes.IFEQ;
import static org.objectweb.asm.Opcodes.IFNE;
import static org.objectweb.asm.Opcodes.IF_ICMPEQ;
import static org.objectweb.asm.Opcodes.IF_ICMPGE;
import static org.objectweb.asm.Opcodes.IF_ICMPGT;
import static org.objectweb.asm.Opcodes.IF_ICMPLE;
import static org.objectweb.asm.Opcodes.IF_ICMPLT;
import static org.objectweb.asm.Opcodes.IF_ICMPNE;
import static org.objectweb.asm.Opcodes.ILOAD;
import static org.objectweb.asm.Opcodes.IMUL;
import static org.objectweb.asm.Opcodes.INTEGER;
import static org.objectweb.asm.Opcodes.INVOKEVIRTUAL;
import static org.objectweb.asm.Opcodes.IOR;
import static org.objectweb.asm.Opcodes.IREM;
import static org.objectweb.asm.Opcodes.ISTORE;
import static org.objectweb.asm.Opcodes.ISUB;
import static org.objectweb.asm.Opcodes.RETURN;
import static org.objectweb.asm.Opcodes.V15;

public class LangParseListenerImpl implements LangParserListener {

    private final ClassWriter classWriter;
    private final MethodVisitor methodVisitor;

    private final Stack<Label> labels = new Stack<>();
    private final Map<Integer, Label> declaredLabelMap = new HashMap<>();

    private final Map<CodeContext, Set<String>> localVariableMap = new HashMap<>();
    private final Map<String, Integer> localVariableNameMap = new HashMap<>();
    private final Map<Integer, Object> varTypeMap = new HashMap<>();
    private final Stack<CodeContext> codeBlocks = new Stack<>();
    private final Stack<Object> stackTypes = new Stack<>();

    public LangParseListenerImpl(String className) {
        classWriter = new ClassWriter(COMPUTE_MAXS | COMPUTE_FRAMES);
        classWriter.visit(V15, ACC_PUBLIC | ACC_SUPER, className, null, "java/lang/Object", null);
        classWriter.visitSource(className + ".java", null);

        methodVisitor = classWriter.visitMethod(ACC_PUBLIC | ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
        methodVisitor.visitCode();
    }

    public byte[] getByteCode() {
        return classWriter.toByteArray();
    }

    @Override
    public void enterCode(CodeContext ctx) {
        codeBlocks.push(ctx);
        localVariableMap.put(ctx, new HashSet<>());
    }

    @Override
    public void exitCode(CodeContext ctx) {
        codeBlocks.pop();
        localVariableMap.remove(ctx);
        if (codeBlocks.empty()) {
            methodVisitor.visitInsn(RETURN);
            methodVisitor.visitMaxs(0, 0);
            methodVisitor.visitEnd();
            classWriter.visitEnd();
        }
    }

    @Override
    public void enterCodeBlock(CodeBlockContext ctx) {
        Label falseLabel = new Label();
        methodVisitor.visitJumpInsn(IFEQ, falseLabel);
        stackTypes.pop();

        labels.push(falseLabel);
    }

    @Override
    public void exitCodeBlock(CodeBlockContext ctx) {}

    @Override
    public void enterIfclause(IfclauseContext ctx) {}

    @Override
    public void exitIfclause(IfclauseContext ctx) {
        Label falseLabel = labels.pop();
        methodVisitor.visitLabel(falseLabel);
        methodVisitor.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
    }

    @Override
    public void enterLabelDeclaration(LabelDeclarationContext ctx) {
        int index = Integer.parseInt(ctx.INTLIT().toString());
        Label label;
        if (declaredLabelMap.containsKey(index)) {
            label = declaredLabelMap.get(index);
        } else {
            label = new Label();
            declaredLabelMap.put(index, label);
        }
        methodVisitor.visitLabel(label);

        visitFrame();
    }

    @Override
    public void exitLabelDeclaration(LabelDeclarationContext ctx) {}

    @Override
    public void enterNonEmptyLine(NonEmptyLineContext ctx) {}

    @Override
    public void exitNonEmptyLine(NonEmptyLineContext ctx) {}

    @Override
    public void enterEmptyLine(EmptyLineContext ctx) {}

    @Override
    public void exitEmptyLine(EmptyLineContext ctx) {}

    @Override
    public void enterIntDeclaration(IntDeclarationContext ctx) {}

    @Override
    public void exitIntDeclaration(IntDeclarationContext ctx) {}

    @Override
    public void enterStringDeclaration(StringDeclarationContext ctx) {}

    @Override
    public void exitStringDeclaration(StringDeclarationContext ctx) {}

    @Override
    public void enterIntAssignment(IntAssignmentContext ctx) {}

    @Override
    public void exitIntAssignment(IntAssignmentContext ctx) {
        int number;
        if (localVariableNameMap.containsKey(ctx.getChild(0).getText())) {
            number = localVariableNameMap.get(ctx.getChild(0).getText());
        } else {
            number = localVariableNameMap.keySet().size();
            localVariableNameMap.put(ctx.getChild(0).getText(), number);
            localVariableMap.get(codeBlocks.peek()).add(ctx.getChild(0).getText());
        }
        methodVisitor.visitVarInsn(ISTORE, number);
        stackTypes.pop();
        varTypeMap.put(number, Opcodes.INTEGER);
    }

    @Override
    public void enterStringAssignment(StringAssignmentContext ctx) {}

    @Override
    public void exitStringAssignment(StringAssignmentContext ctx) {
        int number;
        if (localVariableNameMap.containsKey(ctx.getChild(0).getText())) {
            number = localVariableNameMap.get(ctx.getChild(0).getText());
        } else {
            number = localVariableNameMap.keySet().size();
            localVariableNameMap.put(ctx.getChild(0).getText(), number);
            localVariableMap.get(codeBlocks.peek()).add(ctx.getChild(0).getText());
        }
        methodVisitor.visitVarInsn(ASTORE, number);
        stackTypes.pop();
        varTypeMap.put(number, "java/lang/String");
    }

    @Override
    public void enterPrintString(PrintStringContext ctx) {
        methodVisitor.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        stackTypes.push("java/io/PrintStream");
    }

    @Override
    public void exitPrintString(PrintStringContext ctx) {
        methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
        stackTypes.pop();
        stackTypes.pop();
    }

    @Override
    public void enterPrintArithmetic(PrintArithmeticContext ctx) {
        methodVisitor.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        stackTypes.push("java/io/PrintStream");
    }

    @Override
    public void exitPrintArithmetic(PrintArithmeticContext ctx) {
        methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
        stackTypes.pop();
        stackTypes.pop();
    }

    @Override
    public void enterPrintLogical(PrintLogicalContext ctx) {
        methodVisitor.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        stackTypes.push("java/io/PrintStream");
    }

    @Override
    public void exitPrintLogical(PrintLogicalContext ctx) {
        methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Z)V", false);
        stackTypes.pop();
        stackTypes.pop();
    }

    @Override
    public void enterPrintstr(PrintstrContext ctx) {
        if (!localVariableNameMap.containsKey(ctx.ID().getText())) {
            throw new IllegalStateException("Unknown variable: " + ctx.ID().getText());
        }
        int index = localVariableNameMap.get(ctx.ID().getText());
        methodVisitor.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        methodVisitor.visitVarInsn(ALOAD, index);
        methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
    }

    @Override
    public void exitPrintstr(PrintstrContext ctx) {}

    @Override
    public void enterGotoExpression(GotoExpressionContext ctx) {
        int index = Integer.parseInt(ctx.INTLIT().toString());

        Label label;
        if (declaredLabelMap.containsKey(index)) {
            label = declaredLabelMap.get(index);
        } else {
            label = new Label();
            declaredLabelMap.put(index, label);
        }
        methodVisitor.visitJumpInsn(GOTO, label);
        methodVisitor.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
    }

    @Override
    public void exitGotoExpression(GotoExpressionContext ctx) {}

    @Override
    public void enterBinaryArithmetic(BinaryArithmeticContext ctx) {}

    @Override
    public void exitBinaryArithmetic(BinaryArithmeticContext ctx) {
        methodVisitor.visitInsn(switch (ctx.children.get(2).getText()) {
            case "+" -> IADD;
            case "-" -> ISUB;
            case "/" -> IDIV;
            case "*" -> IMUL;
            case "%" -> IREM;
            default -> throw new IllegalStateException("Illegal value: " + ctx.children.get(2).getText());
        });
        stackTypes.pop();
    }

    @Override
    public void enterIntLiteral(IntLiteralContext ctx) {
        methodVisitor.visitLdcInsn(Integer.parseInt(ctx.getText()));
        stackTypes.push(INTEGER);
    }

    @Override
    public void exitIntLiteral(IntLiteralContext ctx) {}

    @Override
    public void enterVarReference(VarReferenceContext ctx) {
        if (!localVariableNameMap.containsKey(ctx.ID().toString())) {
            throw new IllegalStateException("Local variable not declared: " + ctx.ID().toString());
        }
        methodVisitor.visitVarInsn(ILOAD, localVariableNameMap.get(ctx.ID().toString()));
        stackTypes.push(varTypeMap.get(localVariableNameMap.get(ctx.ID().toString())));
    }

    @Override
    public void exitVarReference(VarReferenceContext ctx) {}

    @Override
    public void enterParenExpression(ParenExpressionContext ctx) {}

    @Override
    public void exitParenExpression(ParenExpressionContext ctx) {}

    @Override
    public void enterMinusExpression(MinusExpressionContext ctx) {}

    @Override
    public void exitMinusExpression(MinusExpressionContext ctx) {}

    @Override
    public void enterStringLiteral(StringLiteralContext ctx) {
        methodVisitor.visitLdcInsn(ctx.STRINGLIT().toString().substring(1, ctx.STRINGLIT().toString().length() - 1));
        stackTypes.push("java/lang/String");
    }

    @Override
    public void exitStringLiteral(StringLiteralContext ctx) {}

    @Override
    public void enterComparison(ComparisonContext ctx) {}

    @Override
    public void exitComparison(ComparisonContext ctx) {
        Label trueLabel = new Label();
        Label falseLabel = new Label();
        methodVisitor.visitJumpInsn(
            switch (ctx.children.get(1).getText()) {
                case ">" -> IF_ICMPGT;
                case "<" -> IF_ICMPLT;
                case "==" -> IF_ICMPEQ;
                case "!=" -> IF_ICMPNE;
                case ">=" -> IF_ICMPGE;
                case "<=" -> IF_ICMPLE;
                default -> throw new IllegalStateException("Illegal value: " + ctx.children.get(1).getText());
            }, trueLabel);
        stackTypes.pop();
        stackTypes.pop();

        methodVisitor.visitInsn(ICONST_0);

        methodVisitor.visitJumpInsn(GOTO, falseLabel);
        methodVisitor.visitLabel(trueLabel);

        visitFrame();

        methodVisitor.visitInsn(ICONST_1);
        methodVisitor.visitLabel(falseLabel);
        stackTypes.push(INTEGER);

        visitFrame();
    }

    @Override
    public void enterBinaryLogic(BinaryLogicContext ctx) {}

    @Override
    public void exitBinaryLogic(BinaryLogicContext ctx) {
        Label trueLabel = new Label();
        Label falseLabel = new Label();
        methodVisitor.visitInsn(
            switch (ctx.children.get(2).getText()) {
                case "&&" -> IAND;
                case "||" -> IOR;
                default -> throw new IllegalStateException("Illegal value: " + ctx.children.get(2).getText());
            });
        stackTypes.pop();

        methodVisitor.visitJumpInsn(IFNE, trueLabel);
        stackTypes.pop();


        methodVisitor.visitInsn(ICONST_0);

        methodVisitor.visitJumpInsn(GOTO, falseLabel);
        methodVisitor.visitLabel(trueLabel);

        visitFrame();

        methodVisitor.visitInsn(ICONST_1);
        methodVisitor.visitLabel(falseLabel);
        stackTypes.push(INTEGER);

        visitFrame();
    }

    @Override
    public void enterNegation(NegationContext ctx) {}

    @Override
    public void exitNegation(NegationContext ctx) {
        Label trueLabel = new Label();
        Label falseLabel = new Label();
        methodVisitor.visitJumpInsn(IFEQ, trueLabel);
        stackTypes.pop();

        methodVisitor.visitInsn(ICONST_0);

        methodVisitor.visitJumpInsn(GOTO, falseLabel);
        methodVisitor.visitLabel(trueLabel);

        visitFrame();

        methodVisitor.visitInsn(ICONST_1);
        methodVisitor.visitLabel(falseLabel);
        stackTypes.push(INTEGER);

        visitFrame();
    }

    @Override
    public void enterAssignmentStatement(AssignmentStatementContext ctx) {}

    @Override
    public void exitAssignmentStatement(AssignmentStatementContext ctx) {}

    @Override
    public void enterDeclarationStatement(DeclarationStatementContext ctx) {}

    @Override
    public void exitDeclarationStatement(DeclarationStatementContext ctx) {}

    @Override
    public void enterPrintStatement(PrintStatementContext ctx) {}

    @Override
    public void exitPrintStatement(PrintStatementContext ctx) {}

    @Override
    public void enterPrintStrStatement(PrintStrStatementContext ctx) {}

    @Override
    public void exitPrintStrStatement(PrintStrStatementContext ctx) {}

    @Override
    public void enterGotoStatement(GotoStatementContext ctx) {}

    @Override
    public void exitGotoStatement(GotoStatementContext ctx) {}

    @Override
    public void enterIfStatement(IfStatementContext ctx) {}

    @Override
    public void exitIfStatement(IfStatementContext ctx) {}

    @Override
    public void enterLabelStatement(LabelStatementContext ctx) {}

    @Override
    public void exitLabelStatement(LabelStatementContext ctx) {}

    @Override
    public void enterBinaryArithmeticSign(BinaryArithmeticSignContext ctx) {}

    @Override
    public void exitBinaryArithmeticSign(BinaryArithmeticSignContext ctx) {}

    @Override
    public void enterComparisonSign(ComparisonSignContext ctx) {}

    @Override
    public void exitComparisonSign(ComparisonSignContext ctx) {}

    @Override
    public void enterBinaryLogicSign(BinaryLogicSignContext ctx) {}

    @Override
    public void exitBinaryLogicSign(BinaryLogicSignContext ctx) {}

    @Override
    public void visitTerminal(TerminalNode node) {}

    @Override
    public void visitErrorNode(ErrorNode node) {}

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {}

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {}

    private void visitFrame() {
        methodVisitor.visitFrame(
            Opcodes.F_FULL,
            varTypeMap.size(),
            varTypeMap.keySet().stream().map(varTypeMap::get).toArray(),
            stackTypes.size(),
            stackTypes.toArray()
        );
    }
}
