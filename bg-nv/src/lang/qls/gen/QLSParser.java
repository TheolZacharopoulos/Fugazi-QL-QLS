// Generated from /Users/bore/Projects/SoftwareConstruction/many-ql/bg-nv/src/lang/qls/syntax/QLS.g4 by ANTLR 4.5
package lang.qls.gen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QLSParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, QuestionType=23, Boolean=24, 
		WidgetType=25, Color=26, Integer=27, Decimal=28, IntOrDec=29, String=30, 
		Identifier=31, Comment=32, LineComment=33, WS=34;
	public static final int
		RULE_stylesheet = 0, RULE_page = 1, RULE_statement = 2, RULE_section = 3, 
		RULE_question = 4, RULE_defaultStmt = 5, RULE_stylesheetRule = 6, RULE_widgetValue = 7;
	public static final String[] ruleNames = {
		"stylesheet", "page", "statement", "segment", "question", "defaultStmt",
		"stylesheetRule", "widgetValue"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'stylesheet'", "'{'", "'}'", "'page'", "'segment'", "'question'",
		"'default'", "'width'", "':'", "'fontsize'", "'font'", "'color'", "'widget'", 
		"'slider'", "'('", "','", "')'", "'spinbox'", "'textbox'", "'radio'", 
		"'checkbox'", "'dropdown'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, "QuestionType", 
		"Boolean", "WidgetType", "Color", "Integer", "Decimal", "IntOrDec", "String", 
		"Identifier", "Comment", "LineComment", "WS"
	};
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
	@NotNull
	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "QLS.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public QLSParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StylesheetContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(QLSParser.Identifier, 0); }
		public List<PageContext> page() {
			return getRuleContexts(PageContext.class);
		}
		public PageContext page(int i) {
			return getRuleContext(PageContext.class,i);
		}
		public StylesheetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stylesheet; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitStylesheet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StylesheetContext stylesheet() throws RecognitionException {
		StylesheetContext _localctx = new StylesheetContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_stylesheet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16); 
			match(T__0);
			setState(17); 
			match(Identifier);
			setState(18); 
			match(T__1);
			setState(20); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(19); 
				page();
				}
				}
				setState(22); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__3 );
			setState(24); 
			match(T__2);
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

	public static class PageContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(QLSParser.Identifier, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public PageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_page; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitPage(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PageContext page() throws RecognitionException {
		PageContext _localctx = new PageContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_page);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26); 
			match(T__3);
			setState(27); 
			match(Identifier);
			setState(28); 
			match(T__1);
			setState(30); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(29); 
				statement();
				}
				}
				setState(32); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6))) != 0) );
			setState(34); 
			match(T__2);
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
		public SectionContext section() {
			return getRuleContext(SectionContext.class,0);
		}
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public DefaultStmtContext defaultStmt() {
			return getRuleContext(DefaultStmtContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(39);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(36); 
				section();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(37); 
				question();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 3);
				{
				setState(38); 
				defaultStmt();
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

	public static class SectionContext extends ParserRuleContext {
		public TerminalNode String() { return getToken(QLSParser.String, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public SectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_section; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitSection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SectionContext section() throws RecognitionException {
		SectionContext _localctx = new SectionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_section);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41); 
			match(T__4);
			setState(42); 
			match(String);
			setState(43); 
			match(T__1);
			setState(45); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(44); 
				statement();
				}
				}
				setState(47); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6))) != 0) );
			setState(49); 
			match(T__2);
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

	public static class QuestionContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(QLSParser.Identifier, 0); }
		public List<StylesheetRuleContext> stylesheetRule() {
			return getRuleContexts(StylesheetRuleContext.class);
		}
		public StylesheetRuleContext stylesheetRule(int i) {
			return getRuleContext(StylesheetRuleContext.class,i);
		}
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_question);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51); 
			match(T__5);
			setState(52); 
			match(Identifier);
			setState(61);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(53); 
				match(T__1);
				setState(55); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(54); 
					stylesheetRule();
					}
					}
					setState(57); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12))) != 0) );
				setState(59); 
				match(T__2);
				}
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

	public static class DefaultStmtContext extends ParserRuleContext {
		public TerminalNode QuestionType() { return getToken(QLSParser.QuestionType, 0); }
		public List<StylesheetRuleContext> stylesheetRule() {
			return getRuleContexts(StylesheetRuleContext.class);
		}
		public StylesheetRuleContext stylesheetRule(int i) {
			return getRuleContext(StylesheetRuleContext.class,i);
		}
		public DefaultStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitDefaultStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefaultStmtContext defaultStmt() throws RecognitionException {
		DefaultStmtContext _localctx = new DefaultStmtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_defaultStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63); 
			match(T__6);
			setState(64); 
			match(QuestionType);
			setState(65); 
			match(T__1);
			setState(67); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(66); 
				stylesheetRule();
				}
				}
				setState(69); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12))) != 0) );
			setState(71); 
			match(T__2);
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

	public static class StylesheetRuleContext extends ParserRuleContext {
		public Token label;
		public TerminalNode Integer() { return getToken(QLSParser.Integer, 0); }
		public TerminalNode String() { return getToken(QLSParser.String, 0); }
		public TerminalNode Color() { return getToken(QLSParser.Color, 0); }
		public WidgetValueContext widgetValue() {
			return getRuleContext(WidgetValueContext.class,0);
		}
		public StylesheetRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stylesheetRule; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitStylesheetRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StylesheetRuleContext stylesheetRule() throws RecognitionException {
		StylesheetRuleContext _localctx = new StylesheetRuleContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_stylesheetRule);
		try {
			setState(87);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(73); 
				((StylesheetRuleContext)_localctx).label = match(T__7);
				setState(74); 
				match(T__8);
				setState(75); 
				match(Integer);
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(76); 
				((StylesheetRuleContext)_localctx).label = match(T__9);
				setState(77); 
				match(T__8);
				setState(78); 
				match(Integer);
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 3);
				{
				setState(79); 
				((StylesheetRuleContext)_localctx).label = match(T__10);
				setState(80); 
				match(T__8);
				setState(81); 
				match(String);
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 4);
				{
				setState(82); 
				((StylesheetRuleContext)_localctx).label = match(T__11);
				setState(83); 
				match(T__8);
				setState(84); 
				match(Color);
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 5);
				{
				setState(85); 
				((StylesheetRuleContext)_localctx).label = match(T__12);
				setState(86); 
				widgetValue();
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

	public static class WidgetValueContext extends ParserRuleContext {
		public Token label;
		public Token min;
		public Token max;
		public Token step;
		public Token yesText;
		public Token noText;
		public List<TerminalNode> IntOrDec() { return getTokens(QLSParser.IntOrDec); }
		public TerminalNode IntOrDec(int i) {
			return getToken(QLSParser.IntOrDec, i);
		}
		public List<TerminalNode> String() { return getTokens(QLSParser.String); }
		public TerminalNode String(int i) {
			return getToken(QLSParser.String, i);
		}
		public WidgetValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_widgetValue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitWidgetValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WidgetValueContext widgetValue() throws RecognitionException {
		WidgetValueContext _localctx = new WidgetValueContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_widgetValue);
		try {
			setState(121);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(89); 
				((WidgetValueContext)_localctx).label = match(T__13);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(90); 
				((WidgetValueContext)_localctx).label = match(T__13);
				setState(91); 
				match(T__14);
				setState(92); 
				((WidgetValueContext)_localctx).min = match(IntOrDec);
				setState(93); 
				match(T__15);
				setState(94); 
				((WidgetValueContext)_localctx).max = match(IntOrDec);
				setState(95); 
				match(T__15);
				setState(96); 
				((WidgetValueContext)_localctx).step = match(IntOrDec);
				setState(97); 
				match(T__16);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(98); 
				((WidgetValueContext)_localctx).label = match(T__17);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(99); 
				((WidgetValueContext)_localctx).label = match(T__17);
				setState(100); 
				match(T__14);
				setState(101); 
				((WidgetValueContext)_localctx).min = match(IntOrDec);
				setState(102); 
				match(T__15);
				setState(103); 
				((WidgetValueContext)_localctx).max = match(IntOrDec);
				setState(104); 
				match(T__15);
				setState(105); 
				((WidgetValueContext)_localctx).step = match(IntOrDec);
				setState(106); 
				match(T__16);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(107); 
				((WidgetValueContext)_localctx).label = match(T__18);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(108); 
				((WidgetValueContext)_localctx).label = match(T__19);
				setState(109); 
				match(T__14);
				setState(110); 
				((WidgetValueContext)_localctx).yesText = match(String);
				setState(111); 
				match(T__15);
				setState(112); 
				((WidgetValueContext)_localctx).noText = match(String);
				setState(113); 
				match(T__16);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(114); 
				((WidgetValueContext)_localctx).label = match(T__20);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(115); 
				((WidgetValueContext)_localctx).label = match(T__21);
				setState(116); 
				match(T__14);
				setState(117); 
				((WidgetValueContext)_localctx).yesText = match(String);
				setState(118); 
				match(T__15);
				setState(119); 
				((WidgetValueContext)_localctx).noText = match(String);
				setState(120); 
				match(T__16);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3$~\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3\2\6\2\27"+
		"\n\2\r\2\16\2\30\3\2\3\2\3\3\3\3\3\3\3\3\6\3!\n\3\r\3\16\3\"\3\3\3\3\3"+
		"\4\3\4\3\4\5\4*\n\4\3\5\3\5\3\5\3\5\6\5\60\n\5\r\5\16\5\61\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\6\6:\n\6\r\6\16\6;\3\6\3\6\5\6@\n\6\3\7\3\7\3\7\3\7\6\7F"+
		"\n\7\r\7\16\7G\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\5\bZ\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\5\t|\n\t\3\t\2\2\n\2\4\6\b\n\f\16\20\2\2\u0088\2\22\3\2\2\2\4\34"+
		"\3\2\2\2\6)\3\2\2\2\b+\3\2\2\2\n\65\3\2\2\2\fA\3\2\2\2\16Y\3\2\2\2\20"+
		"{\3\2\2\2\22\23\7\3\2\2\23\24\7!\2\2\24\26\7\4\2\2\25\27\5\4\3\2\26\25"+
		"\3\2\2\2\27\30\3\2\2\2\30\26\3\2\2\2\30\31\3\2\2\2\31\32\3\2\2\2\32\33"+
		"\7\5\2\2\33\3\3\2\2\2\34\35\7\6\2\2\35\36\7!\2\2\36 \7\4\2\2\37!\5\6\4"+
		"\2 \37\3\2\2\2!\"\3\2\2\2\" \3\2\2\2\"#\3\2\2\2#$\3\2\2\2$%\7\5\2\2%\5"+
		"\3\2\2\2&*\5\b\5\2\'*\5\n\6\2(*\5\f\7\2)&\3\2\2\2)\'\3\2\2\2)(\3\2\2\2"+
		"*\7\3\2\2\2+,\7\7\2\2,-\7 \2\2-/\7\4\2\2.\60\5\6\4\2/.\3\2\2\2\60\61\3"+
		"\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\63\3\2\2\2\63\64\7\5\2\2\64\t\3\2"+
		"\2\2\65\66\7\b\2\2\66?\7!\2\2\679\7\4\2\28:\5\16\b\298\3\2\2\2:;\3\2\2"+
		"\2;9\3\2\2\2;<\3\2\2\2<=\3\2\2\2=>\7\5\2\2>@\3\2\2\2?\67\3\2\2\2?@\3\2"+
		"\2\2@\13\3\2\2\2AB\7\t\2\2BC\7\31\2\2CE\7\4\2\2DF\5\16\b\2ED\3\2\2\2F"+
		"G\3\2\2\2GE\3\2\2\2GH\3\2\2\2HI\3\2\2\2IJ\7\5\2\2J\r\3\2\2\2KL\7\n\2\2"+
		"LM\7\13\2\2MZ\7\35\2\2NO\7\f\2\2OP\7\13\2\2PZ\7\35\2\2QR\7\r\2\2RS\7\13"+
		"\2\2SZ\7 \2\2TU\7\16\2\2UV\7\13\2\2VZ\7\34\2\2WX\7\17\2\2XZ\5\20\t\2Y"+
		"K\3\2\2\2YN\3\2\2\2YQ\3\2\2\2YT\3\2\2\2YW\3\2\2\2Z\17\3\2\2\2[|\7\20\2"+
		"\2\\]\7\20\2\2]^\7\21\2\2^_\7\37\2\2_`\7\22\2\2`a\7\37\2\2ab\7\22\2\2"+
		"bc\7\37\2\2c|\7\23\2\2d|\7\24\2\2ef\7\24\2\2fg\7\21\2\2gh\7\37\2\2hi\7"+
		"\22\2\2ij\7\37\2\2jk\7\22\2\2kl\7\37\2\2l|\7\23\2\2m|\7\25\2\2no\7\26"+
		"\2\2op\7\21\2\2pq\7 \2\2qr\7\22\2\2rs\7 \2\2s|\7\23\2\2t|\7\27\2\2uv\7"+
		"\30\2\2vw\7\21\2\2wx\7 \2\2xy\7\22\2\2yz\7 \2\2z|\7\23\2\2{[\3\2\2\2{"+
		"\\\3\2\2\2{d\3\2\2\2{e\3\2\2\2{m\3\2\2\2{n\3\2\2\2{t\3\2\2\2{u\3\2\2\2"+
		"|\21\3\2\2\2\13\30\")\61;?GY{";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}