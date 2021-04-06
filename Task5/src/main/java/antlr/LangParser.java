// Generated from LangParser.g4 by ANTLR 4.9.2
package antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NEWLINE=1, WS=2, LCURLY=3, RCURLY=4, PRINT=5, PRINTSTR=6, GOTO=7, FOR=8, 
		WHILE=9, IF=10, ELSE=11, INTTYPE=12, STRINGTYPE=13, PLUS=14, MINUS=15, 
		ASTERISK=16, DIVISION=17, PERCENT=18, ASSIGN=19, LPAREN=20, RPAREN=21, 
		NOT=22, GREATER=23, LESS=24, EQUAL=25, NOTEQUAL=26, GREATEROREQ=27, LESSOREQ=28, 
		LABEL=29, AND=30, OR=31, INTLIT=32, STRINGLIT=33, UNTERMINATEDSTRING=34, 
		ID=35;
	public static final int
		RULE_code = 0, RULE_codeBlock = 1, RULE_ifclause = 2, RULE_labelDeclaration = 3, 
		RULE_line = 4, RULE_varDeclaration = 5, RULE_assignment = 6, RULE_print = 7, 
		RULE_printstr = 8, RULE_gotoExpression = 9, RULE_arithmeticExpression = 10, 
		RULE_stringExpression = 11, RULE_logicalExpression = 12, RULE_statement = 13, 
		RULE_binaryArithmeticSign = 14, RULE_comparisonSign = 15, RULE_binaryLogicSign = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"code", "codeBlock", "ifclause", "labelDeclaration", "line", "varDeclaration", 
			"assignment", "print", "printstr", "gotoExpression", "arithmeticExpression", 
			"stringExpression", "logicalExpression", "statement", "binaryArithmeticSign", 
			"comparisonSign", "binaryLogicSign"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'{'", "'}'", "'print'", "'printstr'", "'goto'", "'for'", 
			"'while'", "'if'", "'else'", "'int'", "'string'", "'+'", "'-'", "'*'", 
			"'/'", "'%'", "'='", "'('", "')'", "'!'", "'>'", "'<'", "'=='", "'!='", 
			"'>='", "'<='", "':'", "'&&'", "'||'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NEWLINE", "WS", "LCURLY", "RCURLY", "PRINT", "PRINTSTR", "GOTO", 
			"FOR", "WHILE", "IF", "ELSE", "INTTYPE", "STRINGTYPE", "PLUS", "MINUS", 
			"ASTERISK", "DIVISION", "PERCENT", "ASSIGN", "LPAREN", "RPAREN", "NOT", 
			"GREATER", "LESS", "EQUAL", "NOTEQUAL", "GREATEROREQ", "LESSOREQ", "LABEL", 
			"AND", "OR", "INTLIT", "STRINGLIT", "UNTERMINATEDSTRING", "ID"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "LangParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class CodeContext extends ParserRuleContext {
		public LineContext lines;
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public CodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_code; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).enterCode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).exitCode(this);
		}
	}

	public final CodeContext code() throws RecognitionException {
		CodeContext _localctx = new CodeContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_code);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(34);
				((CodeContext)_localctx).lines = line();
				}
				}
				setState(37); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEWLINE) | (1L << PRINT) | (1L << PRINTSTR) | (1L << GOTO) | (1L << IF) | (1L << INTTYPE) | (1L << STRINGTYPE) | (1L << INTLIT) | (1L << ID))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CodeBlockContext extends ParserRuleContext {
		public TerminalNode LCURLY() { return getToken(LangParser.LCURLY, 0); }
		public TerminalNode NEWLINE() { return getToken(LangParser.NEWLINE, 0); }
		public CodeContext code() {
			return getRuleContext(CodeContext.class,0);
		}
		public TerminalNode RCURLY() { return getToken(LangParser.RCURLY, 0); }
		public CodeBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_codeBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).enterCodeBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).exitCodeBlock(this);
		}
	}

	public final CodeBlockContext codeBlock() throws RecognitionException {
		CodeBlockContext _localctx = new CodeBlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_codeBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			match(LCURLY);
			setState(40);
			match(NEWLINE);
			setState(41);
			code();
			setState(42);
			match(RCURLY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfclauseContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(LangParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(LangParser.LPAREN, 0); }
		public LogicalExpressionContext logicalExpression() {
			return getRuleContext(LogicalExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LangParser.RPAREN, 0); }
		public CodeBlockContext codeBlock() {
			return getRuleContext(CodeBlockContext.class,0);
		}
		public IfclauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifclause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).enterIfclause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).exitIfclause(this);
		}
	}

	public final IfclauseContext ifclause() throws RecognitionException {
		IfclauseContext _localctx = new IfclauseContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_ifclause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(IF);
			setState(45);
			match(LPAREN);
			setState(46);
			logicalExpression();
			setState(47);
			match(RPAREN);
			setState(48);
			codeBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LabelDeclarationContext extends ParserRuleContext {
		public TerminalNode INTLIT() { return getToken(LangParser.INTLIT, 0); }
		public TerminalNode LABEL() { return getToken(LangParser.LABEL, 0); }
		public LabelDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labelDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).enterLabelDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).exitLabelDeclaration(this);
		}
	}

	public final LabelDeclarationContext labelDeclaration() throws RecognitionException {
		LabelDeclarationContext _localctx = new LabelDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_labelDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(INTLIT);
			setState(51);
			match(LABEL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LineContext extends ParserRuleContext {
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
	 
		public LineContext() { }
		public void copyFrom(LineContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EmptyLineContext extends LineContext {
		public TerminalNode NEWLINE() { return getToken(LangParser.NEWLINE, 0); }
		public EmptyLineContext(LineContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).enterEmptyLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).exitEmptyLine(this);
		}
	}
	public static class NonEmptyLineContext extends LineContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(LangParser.NEWLINE, 0); }
		public TerminalNode EOF() { return getToken(LangParser.EOF, 0); }
		public NonEmptyLineContext(LineContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).enterNonEmptyLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).exitNonEmptyLine(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_line);
		int _la;
		try {
			setState(57);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRINT:
			case PRINTSTR:
			case GOTO:
			case IF:
			case INTTYPE:
			case STRINGTYPE:
			case INTLIT:
			case ID:
				_localctx = new NonEmptyLineContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(53);
				statement();
				setState(54);
				_la = _input.LA(1);
				if ( !(_la==EOF || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case NEWLINE:
				_localctx = new EmptyLineContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(56);
				match(NEWLINE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDeclarationContext extends ParserRuleContext {
		public VarDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclaration; }
	 
		public VarDeclarationContext() { }
		public void copyFrom(VarDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StringDeclarationContext extends VarDeclarationContext {
		public TerminalNode STRINGTYPE() { return getToken(LangParser.STRINGTYPE, 0); }
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public StringDeclarationContext(VarDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).enterStringDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).exitStringDeclaration(this);
		}
	}
	public static class IntDeclarationContext extends VarDeclarationContext {
		public TerminalNode INTTYPE() { return getToken(LangParser.INTTYPE, 0); }
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public IntDeclarationContext(VarDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).enterIntDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).exitIntDeclaration(this);
		}
	}

	public final VarDeclarationContext varDeclaration() throws RecognitionException {
		VarDeclarationContext _localctx = new VarDeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_varDeclaration);
		try {
			setState(63);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTTYPE:
				_localctx = new IntDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				match(INTTYPE);
				setState(60);
				assignment();
				}
				break;
			case STRINGTYPE:
				_localctx = new StringDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(61);
				match(STRINGTYPE);
				setState(62);
				assignment();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	 
		public AssignmentContext() { }
		public void copyFrom(AssignmentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StringAssignmentContext extends AssignmentContext {
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(LangParser.ASSIGN, 0); }
		public StringExpressionContext stringExpression() {
			return getRuleContext(StringExpressionContext.class,0);
		}
		public StringAssignmentContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).enterStringAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).exitStringAssignment(this);
		}
	}
	public static class IntAssignmentContext extends AssignmentContext {
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(LangParser.ASSIGN, 0); }
		public ArithmeticExpressionContext arithmeticExpression() {
			return getRuleContext(ArithmeticExpressionContext.class,0);
		}
		public IntAssignmentContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).enterIntAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).exitIntAssignment(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_assignment);
		try {
			setState(71);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new IntAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				match(ID);
				setState(66);
				match(ASSIGN);
				setState(67);
				arithmeticExpression();
				}
				break;
			case 2:
				_localctx = new StringAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				match(ID);
				setState(69);
				match(ASSIGN);
				setState(70);
				stringExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrintContext extends ParserRuleContext {
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
	 
		public PrintContext() { }
		public void copyFrom(PrintContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrintLogicalContext extends PrintContext {
		public TerminalNode PRINT() { return getToken(LangParser.PRINT, 0); }
		public LogicalExpressionContext logicalExpression() {
			return getRuleContext(LogicalExpressionContext.class,0);
		}
		public PrintLogicalContext(PrintContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).enterPrintLogical(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).exitPrintLogical(this);
		}
	}
	public static class PrintStringContext extends PrintContext {
		public TerminalNode PRINT() { return getToken(LangParser.PRINT, 0); }
		public StringExpressionContext stringExpression() {
			return getRuleContext(StringExpressionContext.class,0);
		}
		public PrintStringContext(PrintContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).enterPrintString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).exitPrintString(this);
		}
	}
	public static class PrintArithmeticContext extends PrintContext {
		public TerminalNode PRINT() { return getToken(LangParser.PRINT, 0); }
		public ArithmeticExpressionContext arithmeticExpression() {
			return getRuleContext(ArithmeticExpressionContext.class,0);
		}
		public PrintArithmeticContext(PrintContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).enterPrintArithmetic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).exitPrintArithmetic(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_print);
		try {
			setState(79);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new PrintStringContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				match(PRINT);
				setState(74);
				stringExpression();
				}
				break;
			case 2:
				_localctx = new PrintArithmeticContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				match(PRINT);
				setState(76);
				arithmeticExpression();
				}
				break;
			case 3:
				_localctx = new PrintLogicalContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(77);
				match(PRINT);
				setState(78);
				logicalExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrintstrContext extends ParserRuleContext {
		public TerminalNode PRINTSTR() { return getToken(LangParser.PRINTSTR, 0); }
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
		public PrintstrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printstr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).enterPrintstr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).exitPrintstr(this);
		}
	}

	public final PrintstrContext printstr() throws RecognitionException {
		PrintstrContext _localctx = new PrintstrContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_printstr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(PRINTSTR);
			setState(82);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GotoExpressionContext extends ParserRuleContext {
		public TerminalNode GOTO() { return getToken(LangParser.GOTO, 0); }
		public TerminalNode INTLIT() { return getToken(LangParser.INTLIT, 0); }
		public GotoExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gotoExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).enterGotoExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).exitGotoExpression(this);
		}
	}

	public final GotoExpressionContext gotoExpression() throws RecognitionException {
		GotoExpressionContext _localctx = new GotoExpressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_gotoExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(GOTO);
			setState(85);
			match(INTLIT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArithmeticExpressionContext extends ParserRuleContext {
		public ArithmeticExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmeticExpression; }
	 
		public ArithmeticExpressionContext() { }
		public void copyFrom(ArithmeticExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MinusExpressionContext extends ArithmeticExpressionContext {
		public TerminalNode MINUS() { return getToken(LangParser.MINUS, 0); }
		public ArithmeticExpressionContext arithmeticExpression() {
			return getRuleContext(ArithmeticExpressionContext.class,0);
		}
		public MinusExpressionContext(ArithmeticExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).enterMinusExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).exitMinusExpression(this);
		}
	}
	public static class IntLiteralContext extends ArithmeticExpressionContext {
		public TerminalNode INTLIT() { return getToken(LangParser.INTLIT, 0); }
		public IntLiteralContext(ArithmeticExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).enterIntLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).exitIntLiteral(this);
		}
	}
	public static class BinaryArithmeticContext extends ArithmeticExpressionContext {
		public TerminalNode LPAREN() { return getToken(LangParser.LPAREN, 0); }
		public List<ArithmeticExpressionContext> arithmeticExpression() {
			return getRuleContexts(ArithmeticExpressionContext.class);
		}
		public ArithmeticExpressionContext arithmeticExpression(int i) {
			return getRuleContext(ArithmeticExpressionContext.class,i);
		}
		public BinaryArithmeticSignContext binaryArithmeticSign() {
			return getRuleContext(BinaryArithmeticSignContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LangParser.RPAREN, 0); }
		public BinaryArithmeticContext(ArithmeticExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).enterBinaryArithmetic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).exitBinaryArithmetic(this);
		}
	}
	public static class ParenExpressionContext extends ArithmeticExpressionContext {
		public TerminalNode LPAREN() { return getToken(LangParser.LPAREN, 0); }
		public ArithmeticExpressionContext arithmeticExpression() {
			return getRuleContext(ArithmeticExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LangParser.RPAREN, 0); }
		public ParenExpressionContext(ArithmeticExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).enterParenExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).exitParenExpression(this);
		}
	}
	public static class VarReferenceContext extends ArithmeticExpressionContext {
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
		public VarReferenceContext(ArithmeticExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).enterVarReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).exitVarReference(this);
		}
	}

	public final ArithmeticExpressionContext arithmeticExpression() throws RecognitionException {
		ArithmeticExpressionContext _localctx = new ArithmeticExpressionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_arithmeticExpression);
		try {
			setState(101);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new BinaryArithmeticContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(87);
				match(LPAREN);
				setState(88);
				arithmeticExpression();
				setState(89);
				binaryArithmeticSign();
				setState(90);
				arithmeticExpression();
				setState(91);
				match(RPAREN);
				}
				break;
			case 2:
				_localctx = new IntLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(93);
				match(INTLIT);
				}
				break;
			case 3:
				_localctx = new VarReferenceContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(94);
				match(ID);
				}
				break;
			case 4:
				_localctx = new ParenExpressionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(95);
				match(LPAREN);
				setState(96);
				arithmeticExpression();
				setState(97);
				match(RPAREN);
				}
				break;
			case 5:
				_localctx = new MinusExpressionContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(99);
				match(MINUS);
				setState(100);
				arithmeticExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringExpressionContext extends ParserRuleContext {
		public StringExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringExpression; }
	 
		public StringExpressionContext() { }
		public void copyFrom(StringExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StringLiteralContext extends StringExpressionContext {
		public TerminalNode STRINGLIT() { return getToken(LangParser.STRINGLIT, 0); }
		public StringLiteralContext(StringExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).exitStringLiteral(this);
		}
	}

	public final StringExpressionContext stringExpression() throws RecognitionException {
		StringExpressionContext _localctx = new StringExpressionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_stringExpression);
		try {
			_localctx = new StringLiteralContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(STRINGLIT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LogicalExpressionContext extends ParserRuleContext {
		public LogicalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalExpression; }
	 
		public LogicalExpressionContext() { }
		public void copyFrom(LogicalExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NegationContext extends LogicalExpressionContext {
		public TerminalNode NOT() { return getToken(LangParser.NOT, 0); }
		public TerminalNode LPAREN() { return getToken(LangParser.LPAREN, 0); }
		public LogicalExpressionContext logicalExpression() {
			return getRuleContext(LogicalExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LangParser.RPAREN, 0); }
		public NegationContext(LogicalExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).enterNegation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).exitNegation(this);
		}
	}
	public static class ComparisonContext extends LogicalExpressionContext {
		public List<ArithmeticExpressionContext> arithmeticExpression() {
			return getRuleContexts(ArithmeticExpressionContext.class);
		}
		public ArithmeticExpressionContext arithmeticExpression(int i) {
			return getRuleContext(ArithmeticExpressionContext.class,i);
		}
		public ComparisonSignContext comparisonSign() {
			return getRuleContext(ComparisonSignContext.class,0);
		}
		public ComparisonContext(LogicalExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).enterComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).exitComparison(this);
		}
	}
	public static class BinaryLogicContext extends LogicalExpressionContext {
		public TerminalNode LPAREN() { return getToken(LangParser.LPAREN, 0); }
		public List<LogicalExpressionContext> logicalExpression() {
			return getRuleContexts(LogicalExpressionContext.class);
		}
		public LogicalExpressionContext logicalExpression(int i) {
			return getRuleContext(LogicalExpressionContext.class,i);
		}
		public BinaryLogicSignContext binaryLogicSign() {
			return getRuleContext(BinaryLogicSignContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LangParser.RPAREN, 0); }
		public BinaryLogicContext(LogicalExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).enterBinaryLogic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).exitBinaryLogic(this);
		}
	}

	public final LogicalExpressionContext logicalExpression() throws RecognitionException {
		LogicalExpressionContext _localctx = new LogicalExpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_logicalExpression);
		try {
			setState(120);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new ComparisonContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(105);
				arithmeticExpression();
				setState(106);
				comparisonSign();
				setState(107);
				arithmeticExpression();
				}
				break;
			case 2:
				_localctx = new BinaryLogicContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(109);
				match(LPAREN);
				setState(110);
				logicalExpression();
				setState(111);
				binaryLogicSign();
				setState(112);
				logicalExpression();
				setState(113);
				match(RPAREN);
				}
				break;
			case 3:
				_localctx = new NegationContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(115);
				match(NOT);
				setState(116);
				match(LPAREN);
				setState(117);
				logicalExpression();
				setState(118);
				match(RPAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DeclarationStatementContext extends StatementContext {
		public VarDeclarationContext varDeclaration() {
			return getRuleContext(VarDeclarationContext.class,0);
		}
		public DeclarationStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).enterDeclarationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).exitDeclarationStatement(this);
		}
	}
	public static class PrintStatementContext extends StatementContext {
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public PrintStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).enterPrintStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).exitPrintStatement(this);
		}
	}
	public static class AssignmentStatementContext extends StatementContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public AssignmentStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).enterAssignmentStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).exitAssignmentStatement(this);
		}
	}
	public static class IfStatementContext extends StatementContext {
		public IfclauseContext ifclause() {
			return getRuleContext(IfclauseContext.class,0);
		}
		public IfStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).exitIfStatement(this);
		}
	}
	public static class PrintStrStatementContext extends StatementContext {
		public PrintstrContext printstr() {
			return getRuleContext(PrintstrContext.class,0);
		}
		public PrintStrStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).enterPrintStrStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).exitPrintStrStatement(this);
		}
	}
	public static class GotoStatementContext extends StatementContext {
		public GotoExpressionContext gotoExpression() {
			return getRuleContext(GotoExpressionContext.class,0);
		}
		public GotoStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).enterGotoStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).exitGotoStatement(this);
		}
	}
	public static class LabelStatementContext extends StatementContext {
		public LabelDeclarationContext labelDeclaration() {
			return getRuleContext(LabelDeclarationContext.class,0);
		}
		public LabelStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).enterLabelStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).exitLabelStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_statement);
		try {
			setState(129);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new AssignmentStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				assignment();
				}
				break;
			case INTTYPE:
			case STRINGTYPE:
				_localctx = new DeclarationStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(123);
				varDeclaration();
				}
				break;
			case PRINT:
				_localctx = new PrintStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(124);
				print();
				}
				break;
			case PRINTSTR:
				_localctx = new PrintStrStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(125);
				printstr();
				}
				break;
			case GOTO:
				_localctx = new GotoStatementContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(126);
				gotoExpression();
				}
				break;
			case IF:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(127);
				ifclause();
				}
				break;
			case INTLIT:
				_localctx = new LabelStatementContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(128);
				labelDeclaration();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BinaryArithmeticSignContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(LangParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(LangParser.MINUS, 0); }
		public TerminalNode ASTERISK() { return getToken(LangParser.ASTERISK, 0); }
		public TerminalNode DIVISION() { return getToken(LangParser.DIVISION, 0); }
		public TerminalNode PERCENT() { return getToken(LangParser.PERCENT, 0); }
		public BinaryArithmeticSignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryArithmeticSign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).enterBinaryArithmeticSign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).exitBinaryArithmeticSign(this);
		}
	}

	public final BinaryArithmeticSignContext binaryArithmeticSign() throws RecognitionException {
		BinaryArithmeticSignContext _localctx = new BinaryArithmeticSignContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_binaryArithmeticSign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << ASTERISK) | (1L << DIVISION) | (1L << PERCENT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComparisonSignContext extends ParserRuleContext {
		public TerminalNode EQUAL() { return getToken(LangParser.EQUAL, 0); }
		public TerminalNode NOTEQUAL() { return getToken(LangParser.NOTEQUAL, 0); }
		public TerminalNode GREATER() { return getToken(LangParser.GREATER, 0); }
		public TerminalNode GREATEROREQ() { return getToken(LangParser.GREATEROREQ, 0); }
		public TerminalNode LESS() { return getToken(LangParser.LESS, 0); }
		public TerminalNode LESSOREQ() { return getToken(LangParser.LESSOREQ, 0); }
		public ComparisonSignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisonSign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).enterComparisonSign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).exitComparisonSign(this);
		}
	}

	public final ComparisonSignContext comparisonSign() throws RecognitionException {
		ComparisonSignContext _localctx = new ComparisonSignContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_comparisonSign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GREATER) | (1L << LESS) | (1L << EQUAL) | (1L << NOTEQUAL) | (1L << GREATEROREQ) | (1L << LESSOREQ))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BinaryLogicSignContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(LangParser.AND, 0); }
		public TerminalNode OR() { return getToken(LangParser.OR, 0); }
		public BinaryLogicSignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryLogicSign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).enterBinaryLogicSign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).exitBinaryLogicSign(this);
		}
	}

	public final BinaryLogicSignContext binaryLogicSign() throws RecognitionException {
		BinaryLogicSignContext _localctx = new BinaryLogicSignContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_binaryLogicSign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			_la = _input.LA(1);
			if ( !(_la==AND || _la==OR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3%\u008c\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\6\2&\n\2\r\2\16\2\'\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\5\6<\n\6\3\7\3\7\3\7\3\7\5\7B\n\7\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\5\bJ\n\b\3\t\3\t\3\t\3\t\3\t\3\t\5\tR\n\t\3\n\3\n\3\n\3"+
		"\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\5\fh\n\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\5\16{\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\5\17\u0084\n\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\2\2\23\2\4\6\b\n\f"+
		"\16\20\22\24\26\30\32\34\36 \"\2\6\3\3\3\3\3\2\20\24\3\2\31\36\3\2 !\2"+
		"\u008c\2%\3\2\2\2\4)\3\2\2\2\6.\3\2\2\2\b\64\3\2\2\2\n;\3\2\2\2\fA\3\2"+
		"\2\2\16I\3\2\2\2\20Q\3\2\2\2\22S\3\2\2\2\24V\3\2\2\2\26g\3\2\2\2\30i\3"+
		"\2\2\2\32z\3\2\2\2\34\u0083\3\2\2\2\36\u0085\3\2\2\2 \u0087\3\2\2\2\""+
		"\u0089\3\2\2\2$&\5\n\6\2%$\3\2\2\2&\'\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(\3"+
		"\3\2\2\2)*\7\5\2\2*+\7\3\2\2+,\5\2\2\2,-\7\6\2\2-\5\3\2\2\2./\7\f\2\2"+
		"/\60\7\26\2\2\60\61\5\32\16\2\61\62\7\27\2\2\62\63\5\4\3\2\63\7\3\2\2"+
		"\2\64\65\7\"\2\2\65\66\7\37\2\2\66\t\3\2\2\2\678\5\34\17\289\t\2\2\29"+
		"<\3\2\2\2:<\7\3\2\2;\67\3\2\2\2;:\3\2\2\2<\13\3\2\2\2=>\7\16\2\2>B\5\16"+
		"\b\2?@\7\17\2\2@B\5\16\b\2A=\3\2\2\2A?\3\2\2\2B\r\3\2\2\2CD\7%\2\2DE\7"+
		"\25\2\2EJ\5\26\f\2FG\7%\2\2GH\7\25\2\2HJ\5\30\r\2IC\3\2\2\2IF\3\2\2\2"+
		"J\17\3\2\2\2KL\7\7\2\2LR\5\30\r\2MN\7\7\2\2NR\5\26\f\2OP\7\7\2\2PR\5\32"+
		"\16\2QK\3\2\2\2QM\3\2\2\2QO\3\2\2\2R\21\3\2\2\2ST\7\b\2\2TU\7%\2\2U\23"+
		"\3\2\2\2VW\7\t\2\2WX\7\"\2\2X\25\3\2\2\2YZ\7\26\2\2Z[\5\26\f\2[\\\5\36"+
		"\20\2\\]\5\26\f\2]^\7\27\2\2^h\3\2\2\2_h\7\"\2\2`h\7%\2\2ab\7\26\2\2b"+
		"c\5\26\f\2cd\7\27\2\2dh\3\2\2\2ef\7\21\2\2fh\5\26\f\2gY\3\2\2\2g_\3\2"+
		"\2\2g`\3\2\2\2ga\3\2\2\2ge\3\2\2\2h\27\3\2\2\2ij\7#\2\2j\31\3\2\2\2kl"+
		"\5\26\f\2lm\5 \21\2mn\5\26\f\2n{\3\2\2\2op\7\26\2\2pq\5\32\16\2qr\5\""+
		"\22\2rs\5\32\16\2st\7\27\2\2t{\3\2\2\2uv\7\30\2\2vw\7\26\2\2wx\5\32\16"+
		"\2xy\7\27\2\2y{\3\2\2\2zk\3\2\2\2zo\3\2\2\2zu\3\2\2\2{\33\3\2\2\2|\u0084"+
		"\5\16\b\2}\u0084\5\f\7\2~\u0084\5\20\t\2\177\u0084\5\22\n\2\u0080\u0084"+
		"\5\24\13\2\u0081\u0084\5\6\4\2\u0082\u0084\5\b\5\2\u0083|\3\2\2\2\u0083"+
		"}\3\2\2\2\u0083~\3\2\2\2\u0083\177\3\2\2\2\u0083\u0080\3\2\2\2\u0083\u0081"+
		"\3\2\2\2\u0083\u0082\3\2\2\2\u0084\35\3\2\2\2\u0085\u0086\t\3\2\2\u0086"+
		"\37\3\2\2\2\u0087\u0088\t\4\2\2\u0088!\3\2\2\2\u0089\u008a\t\5\2\2\u008a"+
		"#\3\2\2\2\n\';AIQgz\u0083";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}