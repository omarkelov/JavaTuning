// Generated from LangParser.g4 by ANTLR 4.9.2
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LangParser}.
 */
public interface LangParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LangParser#code}.
	 * @param ctx the parse tree
	 */
	void enterCode(LangParser.CodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#code}.
	 * @param ctx the parse tree
	 */
	void exitCode(LangParser.CodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#codeBlock}.
	 * @param ctx the parse tree
	 */
	void enterCodeBlock(LangParser.CodeBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#codeBlock}.
	 * @param ctx the parse tree
	 */
	void exitCodeBlock(LangParser.CodeBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#ifclause}.
	 * @param ctx the parse tree
	 */
	void enterIfclause(LangParser.IfclauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#ifclause}.
	 * @param ctx the parse tree
	 */
	void exitIfclause(LangParser.IfclauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#labelDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLabelDeclaration(LangParser.LabelDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#labelDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLabelDeclaration(LangParser.LabelDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nonEmptyLine}
	 * labeled alternative in {@link LangParser#line}.
	 * @param ctx the parse tree
	 */
	void enterNonEmptyLine(LangParser.NonEmptyLineContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nonEmptyLine}
	 * labeled alternative in {@link LangParser#line}.
	 * @param ctx the parse tree
	 */
	void exitNonEmptyLine(LangParser.NonEmptyLineContext ctx);
	/**
	 * Enter a parse tree produced by the {@code emptyLine}
	 * labeled alternative in {@link LangParser#line}.
	 * @param ctx the parse tree
	 */
	void enterEmptyLine(LangParser.EmptyLineContext ctx);
	/**
	 * Exit a parse tree produced by the {@code emptyLine}
	 * labeled alternative in {@link LangParser#line}.
	 * @param ctx the parse tree
	 */
	void exitEmptyLine(LangParser.EmptyLineContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intDeclaration}
	 * labeled alternative in {@link LangParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterIntDeclaration(LangParser.IntDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intDeclaration}
	 * labeled alternative in {@link LangParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitIntDeclaration(LangParser.IntDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringDeclaration}
	 * labeled alternative in {@link LangParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterStringDeclaration(LangParser.StringDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringDeclaration}
	 * labeled alternative in {@link LangParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitStringDeclaration(LangParser.StringDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intAssignment}
	 * labeled alternative in {@link LangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterIntAssignment(LangParser.IntAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intAssignment}
	 * labeled alternative in {@link LangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitIntAssignment(LangParser.IntAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringAssignment}
	 * labeled alternative in {@link LangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterStringAssignment(LangParser.StringAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringAssignment}
	 * labeled alternative in {@link LangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitStringAssignment(LangParser.StringAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printString}
	 * labeled alternative in {@link LangParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrintString(LangParser.PrintStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printString}
	 * labeled alternative in {@link LangParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrintString(LangParser.PrintStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printArithmetic}
	 * labeled alternative in {@link LangParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrintArithmetic(LangParser.PrintArithmeticContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printArithmetic}
	 * labeled alternative in {@link LangParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrintArithmetic(LangParser.PrintArithmeticContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printLogical}
	 * labeled alternative in {@link LangParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrintLogical(LangParser.PrintLogicalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printLogical}
	 * labeled alternative in {@link LangParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrintLogical(LangParser.PrintLogicalContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#printstr}.
	 * @param ctx the parse tree
	 */
	void enterPrintstr(LangParser.PrintstrContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#printstr}.
	 * @param ctx the parse tree
	 */
	void exitPrintstr(LangParser.PrintstrContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#gotoExpression}.
	 * @param ctx the parse tree
	 */
	void enterGotoExpression(LangParser.GotoExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#gotoExpression}.
	 * @param ctx the parse tree
	 */
	void exitGotoExpression(LangParser.GotoExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryArithmetic}
	 * labeled alternative in {@link LangParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryArithmetic(LangParser.BinaryArithmeticContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryArithmetic}
	 * labeled alternative in {@link LangParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryArithmetic(LangParser.BinaryArithmeticContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intLiteral}
	 * labeled alternative in {@link LangParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void enterIntLiteral(LangParser.IntLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intLiteral}
	 * labeled alternative in {@link LangParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void exitIntLiteral(LangParser.IntLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varReference}
	 * labeled alternative in {@link LangParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void enterVarReference(LangParser.VarReferenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varReference}
	 * labeled alternative in {@link LangParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void exitVarReference(LangParser.VarReferenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpression}
	 * labeled alternative in {@link LangParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void enterParenExpression(LangParser.ParenExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpression}
	 * labeled alternative in {@link LangParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void exitParenExpression(LangParser.ParenExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code minusExpression}
	 * labeled alternative in {@link LangParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void enterMinusExpression(LangParser.MinusExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code minusExpression}
	 * labeled alternative in {@link LangParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void exitMinusExpression(LangParser.MinusExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link LangParser#stringExpression}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(LangParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link LangParser#stringExpression}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(LangParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparison}
	 * labeled alternative in {@link LangParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void enterComparison(LangParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparison}
	 * labeled alternative in {@link LangParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void exitComparison(LangParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryLogic}
	 * labeled alternative in {@link LangParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryLogic(LangParser.BinaryLogicContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryLogic}
	 * labeled alternative in {@link LangParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryLogic(LangParser.BinaryLogicContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negation}
	 * labeled alternative in {@link LangParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void enterNegation(LangParser.NegationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negation}
	 * labeled alternative in {@link LangParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void exitNegation(LangParser.NegationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignmentStatement}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStatement(LangParser.AssignmentStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignmentStatement}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStatement(LangParser.AssignmentStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declarationStatement}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationStatement(LangParser.DeclarationStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declarationStatement}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationStatement(LangParser.DeclarationStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printStatement}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(LangParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printStatement}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(LangParser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printStrStatement}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStrStatement(LangParser.PrintStrStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printStrStatement}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStrStatement(LangParser.PrintStrStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code gotoStatement}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterGotoStatement(LangParser.GotoStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code gotoStatement}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitGotoStatement(LangParser.GotoStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifStatement}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(LangParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStatement}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(LangParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code labelStatement}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterLabelStatement(LangParser.LabelStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code labelStatement}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitLabelStatement(LangParser.LabelStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#binaryArithmeticSign}.
	 * @param ctx the parse tree
	 */
	void enterBinaryArithmeticSign(LangParser.BinaryArithmeticSignContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#binaryArithmeticSign}.
	 * @param ctx the parse tree
	 */
	void exitBinaryArithmeticSign(LangParser.BinaryArithmeticSignContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#comparisonSign}.
	 * @param ctx the parse tree
	 */
	void enterComparisonSign(LangParser.ComparisonSignContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#comparisonSign}.
	 * @param ctx the parse tree
	 */
	void exitComparisonSign(LangParser.ComparisonSignContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#binaryLogicSign}.
	 * @param ctx the parse tree
	 */
	void enterBinaryLogicSign(LangParser.BinaryLogicSignContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#binaryLogicSign}.
	 * @param ctx the parse tree
	 */
	void exitBinaryLogicSign(LangParser.BinaryLogicSignContext ctx);
}