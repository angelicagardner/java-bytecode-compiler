// Generated from /Users/mnktech/Documents/School/4DV507/main/src/main/java/ag223pi/dv507/a2/OFP.g4 by ANTLR 4.8

package ag223pi.dv507.a4;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({ "all", "warnings", "unchecked", "unused", "cast" })
public class OFPLexer extends Lexer {
	static {
		RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION);
	}

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
	public static final int T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7, T__7 = 8, T__8 = 9,
			T__9 = 10, T__10 = 11, BOOLEAN = 12, CHAR = 13, FLOAT = 14, INT = 15, IF = 16, ELSE_IF = 17, ELSE = 18,
			MAIN = 19, NEW = 20, RETURN = 21, STRING = 22, VOID = 23, WHILE = 24, ASSIGN = 25, GT = 26, LT = 27,
			EQUAL = 28, ADD = 29, SUB = 30, MUL = 31, DIV = 32, SINGLE_Q = 33, DOUBLE_Q = 34, SEMICOLON = 35,
			INTEGER_LITERAL = 36, FLOAT_LITERAL = 37, BOOLEAN_LITERAL = 38, CHAR_LITERAL = 39, STRING_LITERAL = 40,
			IDENTIFIER = 41, WS = 42, LINE_COMMENT = 43;
	public static String[] channelNames = { "DEFAULT_TOKEN_CHANNEL", "HIDDEN" };

	public static String[] modeNames = { "DEFAULT_MODE" };

	private static String[] makeRuleNames() {
		return new String[] { "T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", "T__9", "T__10",
				"BOOLEAN", "CHAR", "FLOAT", "INT", "IF", "ELSE_IF", "ELSE", "MAIN", "NEW", "RETURN", "STRING", "VOID",
				"WHILE", "ASSIGN", "GT", "LT", "EQUAL", "ADD", "SUB", "MUL", "DIV", "SINGLE_Q", "DOUBLE_Q", "SEMICOLON",
				"INTEGER_LITERAL", "FLOAT_LITERAL", "BOOLEAN_LITERAL", "CHAR_LITERAL", "STRING_LITERAL", "IDENTIFIER",
				"WS", "LINE_COMMENT" };
	}

	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] { null, "'{'", "'}'", "'('", "')'", "','", "'['", "']'", "'println'", "'print'", "'.'",
				"'length'", "'bool'", "'char'", "'float'", "'int'", "'if'", "'else if'", "'else'", "'main'", "'new'",
				"'return'", "'string'", "'void'", "'while'", "'='", "'>'", "'<'", "'=='", "'+'", "'-'", "'*'", "'/'",
				"'''", "'\"'", "';'" };
	}

	private static final String[] _LITERAL_NAMES = makeLiteralNames();

	private static String[] makeSymbolicNames() {
		return new String[] { null, null, null, null, null, null, null, null, null, null, null, null, "BOOLEAN", "CHAR",
				"FLOAT", "INT", "IF", "ELSE_IF", "ELSE", "MAIN", "NEW", "RETURN", "STRING", "VOID", "WHILE", "ASSIGN",
				"GT", "LT", "EQUAL", "ADD", "SUB", "MUL", "DIV", "SINGLE_Q", "DOUBLE_Q", "SEMICOLON", "INTEGER_LITERAL",
				"FLOAT_LITERAL", "BOOLEAN_LITERAL", "CHAR_LITERAL", "STRING_LITERAL", "IDENTIFIER", "WS",
				"LINE_COMMENT" };
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

	public OFPLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
	}

	@Override
	public String getGrammarFileName() {
		return "OFP.g4";
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
	public String[] getChannelNames() {
		return channelNames;
	}

	@Override
	public String[] getModeNames() {
		return modeNames;
	}

	@Override
	public ATN getATN() {
		return _ATN;
	}

	public static final String _serializedATN = "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2-\u014f\b\1\4\2\t"
			+ "\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"
			+ "\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"
			+ "\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"
			+ "\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"
			+ "\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"
			+ ",\t,\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3"
			+ "\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3"
			+ "\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17"
			+ "\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22"
			+ "\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24"
			+ "\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27"
			+ "\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31"
			+ "\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\37"
			+ "\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\5%\u00dd\n%\3%\6%\u00e0\n%\r"
			+ "%\16%\u00e1\3%\7%\u00e5\n%\f%\16%\u00e8\13%\3%\5%\u00eb\n%\3&\5&\u00ee"
			+ "\n&\3&\3&\6&\u00f2\n&\r&\16&\u00f3\3&\7&\u00f7\n&\f&\16&\u00fa\13&\5&"
			+ "\u00fc\n&\3&\3&\6&\u0100\n&\r&\16&\u0101\3&\3&\3&\3&\3&\5&\u0109\n&\3"
			+ "&\3&\3&\7&\u010e\n&\f&\16&\u0111\13&\3&\6&\u0114\n&\r&\16&\u0115\3&\7"
			+ "&\u0119\n&\f&\16&\u011c\13&\5&\u011e\n&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3"
			+ "\'\3\'\5\'\u0129\n\'\3(\3(\3(\3(\5(\u012f\n(\3(\3(\3)\3)\6)\u0135\n)\r"
			+ ")\16)\u0136\3)\3)\3*\6*\u013c\n*\r*\16*\u013d\3+\6+\u0141\n+\r+\16+\u0142"
			+ "\3+\3+\3,\3,\7,\u0149\n,\f,\16,\u014c\13,\3,\3,\2\2-\3\3\5\4\7\5\t\6\13"
			+ "\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"
			+ "\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'"
			+ "M(O)Q*S+U,W-\3\2\6\4\2C\\c|\13\2\"#*+..\60\60<<??AAC\\c|\5\2\13\f\17\17"
			+ "\"\"\4\2\f\f\17\17\2\u0164\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"
			+ "\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"
			+ "\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3"
			+ "\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2"
			+ "\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67"
			+ "\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2"
			+ "\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2"
			+ "\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\3Y\3\2\2\2\5[\3\2\2\2\7]"
			+ "\3\2\2\2\t_\3\2\2\2\13a\3\2\2\2\rc\3\2\2\2\17e\3\2\2\2\21g\3\2\2\2\23"
			+ "o\3\2\2\2\25u\3\2\2\2\27w\3\2\2\2\31~\3\2\2\2\33\u0083\3\2\2\2\35\u0088"
			+ "\3\2\2\2\37\u008e\3\2\2\2!\u0092\3\2\2\2#\u0095\3\2\2\2%\u009d\3\2\2\2"
			+ "\'\u00a2\3\2\2\2)\u00a7\3\2\2\2+\u00ab\3\2\2\2-\u00b2\3\2\2\2/\u00b9\3"
			+ "\2\2\2\61\u00be\3\2\2\2\63\u00c4\3\2\2\2\65\u00c6\3\2\2\2\67\u00c8\3\2"
			+ "\2\29\u00ca\3\2\2\2;\u00cd\3\2\2\2=\u00cf\3\2\2\2?\u00d1\3\2\2\2A\u00d3"
			+ "\3\2\2\2C\u00d5\3\2\2\2E\u00d7\3\2\2\2G\u00d9\3\2\2\2I\u00ea\3\2\2\2K"
			+ "\u011d\3\2\2\2M\u0128\3\2\2\2O\u012a\3\2\2\2Q\u0132\3\2\2\2S\u013b\3\2"
			+ "\2\2U\u0140\3\2\2\2W\u0146\3\2\2\2YZ\7}\2\2Z\4\3\2\2\2[\\\7\177\2\2\\"
			+ "\6\3\2\2\2]^\7*\2\2^\b\3\2\2\2_`\7+\2\2`\n\3\2\2\2ab\7.\2\2b\f\3\2\2\2"
			+ "cd\7]\2\2d\16\3\2\2\2ef\7_\2\2f\20\3\2\2\2gh\7r\2\2hi\7t\2\2ij\7k\2\2"
			+ "jk\7p\2\2kl\7v\2\2lm\7n\2\2mn\7p\2\2n\22\3\2\2\2op\7r\2\2pq\7t\2\2qr\7"
			+ "k\2\2rs\7p\2\2st\7v\2\2t\24\3\2\2\2uv\7\60\2\2v\26\3\2\2\2wx\7n\2\2xy"
			+ "\7g\2\2yz\7p\2\2z{\7i\2\2{|\7v\2\2|}\7j\2\2}\30\3\2\2\2~\177\7d\2\2\177"
			+ "\u0080\7q\2\2\u0080\u0081\7q\2\2\u0081\u0082\7n\2\2\u0082\32\3\2\2\2\u0083"
			+ "\u0084\7e\2\2\u0084\u0085\7j\2\2\u0085\u0086\7c\2\2\u0086\u0087\7t\2\2"
			+ "\u0087\34\3\2\2\2\u0088\u0089\7h\2\2\u0089\u008a\7n\2\2\u008a\u008b\7"
			+ "q\2\2\u008b\u008c\7c\2\2\u008c\u008d\7v\2\2\u008d\36\3\2\2\2\u008e\u008f"
			+ "\7k\2\2\u008f\u0090\7p\2\2\u0090\u0091\7v\2\2\u0091 \3\2\2\2\u0092\u0093"
			+ "\7k\2\2\u0093\u0094\7h\2\2\u0094\"\3\2\2\2\u0095\u0096\7g\2\2\u0096\u0097"
			+ "\7n\2\2\u0097\u0098\7u\2\2\u0098\u0099\7g\2\2\u0099\u009a\7\"\2\2\u009a"
			+ "\u009b\7k\2\2\u009b\u009c\7h\2\2\u009c$\3\2\2\2\u009d\u009e\7g\2\2\u009e"
			+ "\u009f\7n\2\2\u009f\u00a0\7u\2\2\u00a0\u00a1\7g\2\2\u00a1&\3\2\2\2\u00a2"
			+ "\u00a3\7o\2\2\u00a3\u00a4\7c\2\2\u00a4\u00a5\7k\2\2\u00a5\u00a6\7p\2\2"
			+ "\u00a6(\3\2\2\2\u00a7\u00a8\7p\2\2\u00a8\u00a9\7g\2\2\u00a9\u00aa\7y\2"
			+ "\2\u00aa*\3\2\2\2\u00ab\u00ac\7t\2\2\u00ac\u00ad\7g\2\2\u00ad\u00ae\7"
			+ "v\2\2\u00ae\u00af\7w\2\2\u00af\u00b0\7t\2\2\u00b0\u00b1\7p\2\2\u00b1,"
			+ "\3\2\2\2\u00b2\u00b3\7u\2\2\u00b3\u00b4\7v\2\2\u00b4\u00b5\7t\2\2\u00b5"
			+ "\u00b6\7k\2\2\u00b6\u00b7\7p\2\2\u00b7\u00b8\7i\2\2\u00b8.\3\2\2\2\u00b9"
			+ "\u00ba\7x\2\2\u00ba\u00bb\7q\2\2\u00bb\u00bc\7k\2\2\u00bc\u00bd\7f\2\2"
			+ "\u00bd\60\3\2\2\2\u00be\u00bf\7y\2\2\u00bf\u00c0\7j\2\2\u00c0\u00c1\7"
			+ "k\2\2\u00c1\u00c2\7n\2\2\u00c2\u00c3\7g\2\2\u00c3\62\3\2\2\2\u00c4\u00c5"
			+ "\7?\2\2\u00c5\64\3\2\2\2\u00c6\u00c7\7@\2\2\u00c7\66\3\2\2\2\u00c8\u00c9"
			+ "\7>\2\2\u00c98\3\2\2\2\u00ca\u00cb\7?\2\2\u00cb\u00cc\7?\2\2\u00cc:\3"
			+ "\2\2\2\u00cd\u00ce\7-\2\2\u00ce<\3\2\2\2\u00cf\u00d0\7/\2\2\u00d0>\3\2"
			+ "\2\2\u00d1\u00d2\7,\2\2\u00d2@\3\2\2\2\u00d3\u00d4\7\61\2\2\u00d4B\3\2"
			+ "\2\2\u00d5\u00d6\7)\2\2\u00d6D\3\2\2\2\u00d7\u00d8\7$\2\2\u00d8F\3\2\2"
			+ "\2\u00d9\u00da\7=\2\2\u00daH\3\2\2\2\u00db\u00dd\5=\37\2\u00dc\u00db\3"
			+ "\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00df\3\2\2\2\u00de\u00e0\4\63;\2\u00df"
			+ "\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2"
			+ "\2\2\u00e2\u00e6\3\2\2\2\u00e3\u00e5\7\62\2\2\u00e4\u00e3\3\2\2\2\u00e5"
			+ "\u00e8\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00eb\3\2"
			+ "\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00eb\7\62\2\2\u00ea\u00dc\3\2\2\2\u00ea"
			+ "\u00e9\3\2\2\2\u00ebJ\3\2\2\2\u00ec\u00ee\5=\37\2\u00ed\u00ec\3\2\2\2"
			+ "\u00ed\u00ee\3\2\2\2\u00ee\u00fb\3\2\2\2\u00ef\u00fc\7\62\2\2\u00f0\u00f2"
			+ "\4\63;\2\u00f1\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f3"
			+ "\u00f4\3\2\2\2\u00f4\u00f8\3\2\2\2\u00f5\u00f7\4\62;\2\u00f6\u00f5\3\2"
			+ "\2\2\u00f7\u00fa\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9"
			+ "\u00fc\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fb\u00ef\3\2\2\2\u00fb\u00f1\3\2"
			+ "\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00ff\7\60\2\2\u00fe\u0100\4\62;\2\u00ff"
			+ "\u00fe\3\2\2\2\u0100\u0101\3\2\2\2\u0101\u00ff\3\2\2\2\u0101\u0102\3\2"
			+ "\2\2\u0102\u011e\3\2\2\2\u0103\u0104\7\62\2\2\u0104\u0105\7\60\2\2\u0105"
			+ "\u0106\7\62\2\2\u0106\u011e\7\62\2\2\u0107\u0109\5=\37\2\u0108\u0107\3"
			+ "\2\2\2\u0108\u0109\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u010b\7\62\2\2\u010b"
			+ "\u010f\7\60\2\2\u010c\u010e\7\62\2\2\u010d\u010c\3\2\2\2\u010e\u0111\3"
			+ "\2\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0113\3\2\2\2\u0111"
			+ "\u010f\3\2\2\2\u0112\u0114\4\63;\2\u0113\u0112\3\2\2\2\u0114\u0115\3\2"
			+ "\2\2\u0115\u0113\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u011a\3\2\2\2\u0117"
			+ "\u0119\7\62\2\2\u0118\u0117\3\2\2\2\u0119\u011c\3\2\2\2\u011a\u0118\3"
			+ "\2\2\2\u011a\u011b\3\2\2\2\u011b\u011e\3\2\2\2\u011c\u011a\3\2\2\2\u011d"
			+ "\u00ed\3\2\2\2\u011d\u0103\3\2\2\2\u011d\u0108\3\2\2\2\u011eL\3\2\2\2"
			+ "\u011f\u0120\7v\2\2\u0120\u0121\7t\2\2\u0121\u0122\7w\2\2\u0122\u0129"
			+ "\7g\2\2\u0123\u0124\7h\2\2\u0124\u0125\7c\2\2\u0125\u0126\7n\2\2\u0126"
			+ "\u0127\7u\2\2\u0127\u0129\7g\2\2\u0128\u011f\3\2\2\2\u0128\u0123\3\2\2"
			+ "\2\u0129N\3\2\2\2\u012a\u012e\5C\"\2\u012b\u012f\t\2\2\2\u012c\u012f\3"
			+ "\2\2\2\u012d\u012f\7A\2\2\u012e\u012b\3\2\2\2\u012e\u012c\3\2\2\2\u012e"
			+ "\u012d\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u0131\5C\"\2\u0131P\3\2\2\2\u0132"
			+ "\u0134\5E#\2\u0133\u0135\t\3\2\2\u0134\u0133\3\2\2\2\u0135\u0136\3\2\2"
			+ "\2\u0136\u0134\3\2\2\2\u0136\u0137\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u0139"
			+ "\5E#\2\u0139R\3\2\2\2\u013a\u013c\t\2\2\2\u013b\u013a\3\2\2\2\u013c\u013d"
			+ "\3\2\2\2\u013d\u013b\3\2\2\2\u013d\u013e\3\2\2\2\u013eT\3\2\2\2\u013f"
			+ "\u0141\t\4\2\2\u0140\u013f\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0140\3\2"
			+ "\2\2\u0142\u0143\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0145\b+\2\2\u0145"
			+ "V\3\2\2\2\u0146\u014a\7%\2\2\u0147\u0149\n\5\2\2\u0148\u0147\3\2\2\2\u0149"
			+ "\u014c\3\2\2\2\u014a\u0148\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u014d\3\2"
			+ "\2\2\u014c\u014a\3\2\2\2\u014d\u014e\b,\2\2\u014eX\3\2\2\2\27\2\u00dc"
			+ "\u00e1\u00e6\u00ea\u00ed\u00f3\u00f8\u00fb\u0101\u0108\u010f\u0115\u011a"
			+ "\u011d\u0128\u012e\u0136\u013d\u0142\u014a\3\b\2\2";
	public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}