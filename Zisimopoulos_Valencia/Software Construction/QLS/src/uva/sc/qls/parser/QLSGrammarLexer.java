// Generated from QLSGrammar.g4 by ANTLR 4.5
package uva.sc.qls.parser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({ "all", "warnings", "unchecked", "unused", "cast" })
public class QLSGrammarLexer extends Lexer {
	static {
		RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION);
	}

	protected static final DFA[]					_decisionToDFA;
	protected static final PredictionContextCache	_sharedContextCache	= new PredictionContextCache();
	public static final int							T__0				= 1,
			T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7,
			T__7 = 8, T__8 = 9, T__9 = 10, T__10 = 11, T__11 = 12, T__12 = 13,
			T__13 = 14, T__14 = 15, T__15 = 16, T__16 = 17, T__17 = 18,
			T__18 = 19, T__19 = 20, T__20 = 21, T__21 = 22, T__22 = 23,
			T__23 = 24, T__24 = 25, T__25 = 26, T__26 = 27, BOOLEAN = 28,
			TRUE = 29, FALSE = 30, ID = 31, COLORENCODE = 32, NUMBER = 33,
			STRING = 34, COMMENT = 35, WS = 36;
	public static String[]							modeNames			= { "DEFAULT_MODE" };

	public static final String[]					ruleNames			= { "T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", "T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", "T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", "T__25", "T__26", "BOOLEAN", "TRUE", "FALSE", "ID", "COLORENCODE", "NUMBER", "STRING", "COMMENT", "WS" };

	private static final String[]					_LITERAL_NAMES		= { null, "'stylesheet'", "'page'", "'{'", "'}'", "'section'", "'question'", "'widget'", "'('", "','", "')'", "'default'", "'width:'", "'font:'", "'fontsize:'", "'color:'", "'boolean'", "'number'", "'string'", "'checkbox'", "'spinbox'", "'radio'", "'\"Arial\"'", "'\"Times New Roman\"'", "'\"Bazooka\"'", "'\"Book Antiqua\"'", "'\"Courier\"'", "'\"Dialog\"'" };
	private static final String[]					_SYMBOLIC_NAMES		= { null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "BOOLEAN", "TRUE", "FALSE", "ID", "COLORENCODE", "NUMBER", "STRING", "COMMENT", "WS" };
	public static final Vocabulary					VOCABULARY			= new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[]					tokenNames;
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

	public QLSGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
	}

	@Override
	public String getGrammarFileName() {
		return "QLSGrammar.g4";
	}

	@Override
	public String[] getRuleNames() {
		return ruleNames;
	}

	@Override
	public String getSerializedATN() {
		return _serializedATN;
	}

	@Override
	public String[] getModeNames() {
		return modeNames;
	}

	@Override
	public ATN getATN() {
		return _ATN;
	}

	public static final String	_serializedATN	= "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2&\u0180\b\1\4\2\t" + "\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13" + "\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22" + "\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31" + "\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!" + "\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2" + "\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3" + "\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t" + "\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r" + "\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3" + "\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3" + "\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3" + "\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3" + "\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3" + "\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3" + "\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3" + "\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3" + "\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3" + "\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3" + "\34\3\35\3\35\5\35\u0119\n\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36" + "\3\36\3\36\3\36\3\36\5\36\u0127\n\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37" + "\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u0138\n\37\3 \3 \7 \u013c" + "\n \f \16 \u013f\13 \3!\3!\3!\3!\3!\3!\3!\3!\3\"\6\"\u014a\n\"\r\"\16" + "\"\u014b\3\"\3\"\7\"\u0150\n\"\f\"\16\"\u0153\13\"\3\"\3\"\6\"\u0157\n" + "\"\r\"\16\"\u0158\3\"\6\"\u015c\n\"\r\"\16\"\u015d\5\"\u0160\n\"\3#\3" + "#\3#\3#\7#\u0166\n#\f#\16#\u0169\13#\3#\3#\3$\3$\3$\3$\7$\u0171\n$\f$" + "\16$\u0174\13$\3$\3$\3$\3$\3%\6%\u017b\n%\r%\16%\u017c\3%\3%\3\u0172\2" + "&\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20" + "\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37" + "= ?!A\"C#E$G%I&\3\2\b\5\2C\\aac|\6\2\62;C\\aac|\4\2\62;CH\3\2\62;\5\2" + "\f\f\17\17$$\5\2\13\f\17\17\"\"\u018f\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2" + "\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2" + "\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3" + "\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3" + "\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65" + "\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3" + "\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\3K\3\2\2\2\5V\3\2\2" + "\2\7[\3\2\2\2\t]\3\2\2\2\13_\3\2\2\2\rg\3\2\2\2\17p\3\2\2\2\21w\3\2\2" + "\2\23y\3\2\2\2\25{\3\2\2\2\27}\3\2\2\2\31\u0085\3\2\2\2\33\u008c\3\2\2" + "\2\35\u0092\3\2\2\2\37\u009c\3\2\2\2!\u00a3\3\2\2\2#\u00ab\3\2\2\2%\u00b2" + "\3\2\2\2\'\u00b9\3\2\2\2)\u00c2\3\2\2\2+\u00ca\3\2\2\2-\u00d0\3\2\2\2" + "/\u00d8\3\2\2\2\61\u00ea\3\2\2\2\63\u00f4\3\2\2\2\65\u0103\3\2\2\2\67" + "\u010d\3\2\2\29\u0118\3\2\2\2;\u0126\3\2\2\2=\u0137\3\2\2\2?\u0139\3\2" + "\2\2A\u0140\3\2\2\2C\u015f\3\2\2\2E\u0161\3\2\2\2G\u016c\3\2\2\2I\u017a" + "\3\2\2\2KL\7u\2\2LM\7v\2\2MN\7{\2\2NO\7n\2\2OP\7g\2\2PQ\7u\2\2QR\7j\2" + "\2RS\7g\2\2ST\7g\2\2TU\7v\2\2U\4\3\2\2\2VW\7r\2\2WX\7c\2\2XY\7i\2\2YZ" + "\7g\2\2Z\6\3\2\2\2[\\\7}\2\2\\\b\3\2\2\2]^\7\177\2\2^\n\3\2\2\2_`\7u\2" + "\2`a\7g\2\2ab\7e\2\2bc\7v\2\2cd\7k\2\2de\7q\2\2ef\7p\2\2f\f\3\2\2\2gh" + "\7s\2\2hi\7w\2\2ij\7g\2\2jk\7u\2\2kl\7v\2\2lm\7k\2\2mn\7q\2\2no\7p\2\2" + "o\16\3\2\2\2pq\7y\2\2qr\7k\2\2rs\7f\2\2st\7i\2\2tu\7g\2\2uv\7v\2\2v\20" + "\3\2\2\2wx\7*\2\2x\22\3\2\2\2yz\7.\2\2z\24\3\2\2\2{|\7+\2\2|\26\3\2\2" + "\2}~\7f\2\2~\177\7g\2\2\177\u0080\7h\2\2\u0080\u0081\7c\2\2\u0081\u0082" + "\7w\2\2\u0082\u0083\7n\2\2\u0083\u0084\7v\2\2\u0084\30\3\2\2\2\u0085\u0086" + "\7y\2\2\u0086\u0087\7k\2\2\u0087\u0088\7f\2\2\u0088\u0089\7v\2\2\u0089" + "\u008a\7j\2\2\u008a\u008b\7<\2\2\u008b\32\3\2\2\2\u008c\u008d\7h\2\2\u008d" + "\u008e\7q\2\2\u008e\u008f\7p\2\2\u008f\u0090\7v\2\2\u0090\u0091\7<\2\2" + "\u0091\34\3\2\2\2\u0092\u0093\7h\2\2\u0093\u0094\7q\2\2\u0094\u0095\7" + "p\2\2\u0095\u0096\7v\2\2\u0096\u0097\7u\2\2\u0097\u0098\7k\2\2\u0098\u0099" + "\7|\2\2\u0099\u009a\7g\2\2\u009a\u009b\7<\2\2\u009b\36\3\2\2\2\u009c\u009d" + "\7e\2\2\u009d\u009e\7q\2\2\u009e\u009f\7n\2\2\u009f\u00a0\7q\2\2\u00a0" + "\u00a1\7t\2\2\u00a1\u00a2\7<\2\2\u00a2 \3\2\2\2\u00a3\u00a4\7d\2\2\u00a4" + "\u00a5\7q\2\2\u00a5\u00a6\7q\2\2\u00a6\u00a7\7n\2\2\u00a7\u00a8\7g\2\2" + "\u00a8\u00a9\7c\2\2\u00a9\u00aa\7p\2\2\u00aa\"\3\2\2\2\u00ab\u00ac\7p" + "\2\2\u00ac\u00ad\7w\2\2\u00ad\u00ae\7o\2\2\u00ae\u00af\7d\2\2\u00af\u00b0" + "\7g\2\2\u00b0\u00b1\7t\2\2\u00b1$\3\2\2\2\u00b2\u00b3\7u\2\2\u00b3\u00b4" + "\7v\2\2\u00b4\u00b5\7t\2\2\u00b5\u00b6\7k\2\2\u00b6\u00b7\7p\2\2\u00b7" + "\u00b8\7i\2\2\u00b8&\3\2\2\2\u00b9\u00ba\7e\2\2\u00ba\u00bb\7j\2\2\u00bb" + "\u00bc\7g\2\2\u00bc\u00bd\7e\2\2\u00bd\u00be\7m\2\2\u00be\u00bf\7d\2\2" + "\u00bf\u00c0\7q\2\2\u00c0\u00c1\7z\2\2\u00c1(\3\2\2\2\u00c2\u00c3\7u\2" + "\2\u00c3\u00c4\7r\2\2\u00c4\u00c5\7k\2\2\u00c5\u00c6\7p\2\2\u00c6\u00c7" + "\7d\2\2\u00c7\u00c8\7q\2\2\u00c8\u00c9\7z\2\2\u00c9*\3\2\2\2\u00ca\u00cb" + "\7t\2\2\u00cb\u00cc\7c\2\2\u00cc\u00cd\7f\2\2\u00cd\u00ce\7k\2\2\u00ce" + "\u00cf\7q\2\2\u00cf,\3\2\2\2\u00d0\u00d1\7$\2\2\u00d1\u00d2\7C\2\2\u00d2" + "\u00d3\7t\2\2\u00d3\u00d4\7k\2\2\u00d4\u00d5\7c\2\2\u00d5\u00d6\7n\2\2" + "\u00d6\u00d7\7$\2\2\u00d7.\3\2\2\2\u00d8\u00d9\7$\2\2\u00d9\u00da\7V\2" + "\2\u00da\u00db\7k\2\2\u00db\u00dc\7o\2\2\u00dc\u00dd\7g\2\2\u00dd\u00de" + "\7u\2\2\u00de\u00df\7\"\2\2\u00df\u00e0\7P\2\2\u00e0\u00e1\7g\2\2\u00e1" + "\u00e2\7y\2\2\u00e2\u00e3\7\"\2\2\u00e3\u00e4\7T\2\2\u00e4\u00e5\7q\2" + "\2\u00e5\u00e6\7o\2\2\u00e6\u00e7\7c\2\2\u00e7\u00e8\7p\2\2\u00e8\u00e9" + "\7$\2\2\u00e9\60\3\2\2\2\u00ea\u00eb\7$\2\2\u00eb\u00ec\7D\2\2\u00ec\u00ed" + "\7c\2\2\u00ed\u00ee\7|\2\2\u00ee\u00ef\7q\2\2\u00ef\u00f0\7q\2\2\u00f0" + "\u00f1\7m\2\2\u00f1\u00f2\7c\2\2\u00f2\u00f3\7$\2\2\u00f3\62\3\2\2\2\u00f4" + "\u00f5\7$\2\2\u00f5\u00f6\7D\2\2\u00f6\u00f7\7q\2\2\u00f7\u00f8\7q\2\2" + "\u00f8\u00f9\7m\2\2\u00f9\u00fa\7\"\2\2\u00fa\u00fb\7C\2\2\u00fb\u00fc" + "\7p\2\2\u00fc\u00fd\7v\2\2\u00fd\u00fe\7k\2\2\u00fe\u00ff\7s\2\2\u00ff" + "\u0100\7w\2\2\u0100\u0101\7c\2\2\u0101\u0102\7$\2\2\u0102\64\3\2\2\2\u0103" + "\u0104\7$\2\2\u0104\u0105\7E\2\2\u0105\u0106\7q\2\2\u0106\u0107\7w\2\2" + "\u0107\u0108\7t\2\2\u0108\u0109\7k\2\2\u0109\u010a\7g\2\2\u010a\u010b" + "\7t\2\2\u010b\u010c\7$\2\2\u010c\66\3\2\2\2\u010d\u010e\7$\2\2\u010e\u010f" + "\7F\2\2\u010f\u0110\7k\2\2\u0110\u0111\7c\2\2\u0111\u0112\7n\2\2\u0112" + "\u0113\7q\2\2\u0113\u0114\7i\2\2\u0114\u0115\7$\2\2\u01158\3\2\2\2\u0116" + "\u0119\5;\36\2\u0117\u0119\5=\37\2\u0118\u0116\3\2\2\2\u0118\u0117\3\2" + "\2\2\u0119:\3\2\2\2\u011a\u011b\7v\2\2\u011b\u011c\7t\2\2\u011c\u011d" + "\7w\2\2\u011d\u0127\7g\2\2\u011e\u011f\7V\2\2\u011f\u0120\7T\2\2\u0120" + "\u0121\7W\2\2\u0121\u0127\7G\2\2\u0122\u0123\7V\2\2\u0123\u0124\7t\2\2" + "\u0124\u0125\7w\2\2\u0125\u0127\7g\2\2\u0126\u011a\3\2\2\2\u0126\u011e" + "\3\2\2\2\u0126\u0122\3\2\2\2\u0127<\3\2\2\2\u0128\u0129\7h\2\2\u0129\u012a" + "\7c\2\2\u012a\u012b\7n\2\2\u012b\u012c\7u\2\2\u012c\u0138\7g\2\2\u012d" + "\u012e\7H\2\2\u012e\u012f\7C\2\2\u012f\u0130\7N\2\2\u0130\u0131\7U\2\2" + "\u0131\u0138\7G\2\2\u0132\u0133\7H\2\2\u0133\u0134\7c\2\2\u0134\u0135" + "\7n\2\2\u0135\u0136\7u\2\2\u0136\u0138\7g\2\2\u0137\u0128\3\2\2\2\u0137" + "\u012d\3\2\2\2\u0137\u0132\3\2\2\2\u0138>\3\2\2\2\u0139\u013d\t\2\2\2" + "\u013a\u013c\t\3\2\2\u013b\u013a\3\2\2\2\u013c\u013f\3\2\2\2\u013d\u013b" + "\3\2\2\2\u013d\u013e\3\2\2\2\u013e@\3\2\2\2\u013f\u013d\3\2\2\2\u0140" + "\u0141\7%\2\2\u0141\u0142\t\4\2\2\u0142\u0143\t\4\2\2\u0143\u0144\t\4" + "\2\2\u0144\u0145\t\4\2\2\u0145\u0146\t\4\2\2\u0146\u0147\t\4\2\2\u0147" + "B\3\2\2\2\u0148\u014a\t\5\2\2\u0149\u0148\3\2\2\2\u014a\u014b\3\2\2\2" + "\u014b\u0149\3\2\2\2\u014b\u014c\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u0151" + "\7\60\2\2\u014e\u0150\t\5\2\2\u014f\u014e\3\2\2\2\u0150\u0153\3\2\2\2" + "\u0151\u014f\3\2\2\2\u0151\u0152\3\2\2\2\u0152\u0160\3\2\2\2\u0153\u0151" + "\3\2\2\2\u0154\u0156\7\60\2\2\u0155\u0157\t\5\2\2\u0156\u0155\3\2\2\2" + "\u0157\u0158\3\2\2\2\u0158\u0156\3\2\2\2\u0158\u0159\3\2\2\2\u0159\u0160" + "\3\2\2\2\u015a\u015c\t\5\2\2\u015b\u015a\3\2\2\2\u015c\u015d\3\2\2\2\u015d" + "\u015b\3\2\2\2\u015d\u015e\3\2\2\2\u015e\u0160\3\2\2\2\u015f\u0149\3\2" + "\2\2\u015f\u0154\3\2\2\2\u015f\u015b\3\2\2\2\u0160D\3\2\2\2\u0161\u0167" + "\7$\2\2\u0162\u0166\n\6\2\2\u0163\u0164\7$\2\2\u0164\u0166\7$\2\2\u0165" + "\u0162\3\2\2\2\u0165\u0163\3\2\2\2\u0166\u0169\3\2\2\2\u0167\u0165\3\2" + "\2\2\u0167\u0168\3\2\2\2\u0168\u016a\3\2\2\2\u0169\u0167\3\2\2\2\u016a" + "\u016b\7$\2\2\u016bF\3\2\2\2\u016c\u016d\7\61\2\2\u016d\u016e\7\61\2\2" + "\u016e\u0172\3\2\2\2\u016f\u0171\13\2\2\2\u0170\u016f\3\2\2\2\u0171\u0174" + "\3\2\2\2\u0172\u0173\3\2\2\2\u0172\u0170\3\2\2\2\u0173\u0175\3\2\2\2\u0174" + "\u0172\3\2\2\2\u0175\u0176\7\f\2\2\u0176\u0177\3\2\2\2\u0177\u0178\b$" + "\2\2\u0178H\3\2\2\2\u0179\u017b\t\7\2\2\u017a\u0179\3\2\2\2\u017b\u017c" + "\3\2\2\2\u017c\u017a\3\2\2\2\u017c\u017d\3\2\2\2\u017d\u017e\3\2\2\2\u017e" + "\u017f\b%\2\2\u017fJ\3\2\2\2\20\2\u0118\u0126\u0137\u013d\u014b\u0151" + "\u0158\u015d\u015f\u0165\u0167\u0172\u017c\3\b\2\2";
	public static final ATN		_ATN			= new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}