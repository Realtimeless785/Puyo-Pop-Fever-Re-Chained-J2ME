package puyo;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.Random;
import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;
import javax.microedition.media.Player;
import javax.microedition.media.control.VolumeControl;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;

public final class a extends Canvas implements Runnable {
    private boolean a = false;
    private int b = 100;
    private int sfxType = 2;
    private int puyoSkinsType = 3;
    private int voiceLangType = 0;
    private int difficultyType = 2;	
    private int ingameBgColorType = 1;	
    private String leftSoftkeyText;
    private String rightSoftkeyText;
    private Image leftSoftkeyImage;
    private Image rightSoftkeyImage;
    private Image leftSoftkeyLargeImage;
    private Image leftSoftkeyLargeImageE90;
    private Image rightSoftkeyLargeImage;
    private Image saveIcon;
    private byte e;
    private Image f;
    private Image g;
    private int[][] splashRGB = new int[2][];
    private int[] splashRGBw = new int[2];
    private int[] splashRGBh = new int[2];
    private int h;
    private String[][] runrunOpeningString = new String[][]{{"いつかの時代･･･", "どこかの世界...", "", "ステキな魔導師", "になることを夢みる", "ひとりの女の", "子がいました"}, {"彼女の名前は  アミティ", "今日も今日とて", "お勉強です..."}};
    private String[][][] runrunManzaiString = new String[][][]{{{"はぁい、 みなさぁん ", "フィーバーの仕組は", "理解できましたか?"}, {"な、なんとなく· · ·"}, {"じゃあ、さっそく ", "クラスの人と ", "れんしゅうね"}, {"よ、よろしく· · ·"}}, {{"みなさぁん、 フィーバー", "のコツは イーバーのコツ", "はわかりましたか?"}, {"なあるほどぉ ", "· · ·フて やっぱり ", "よく わかんないや"}, {"· · ·まぁ、 ともかく れんしゅ", "うするのが イチバンね こんどは ", "相手をかえてみましょう"}, {"じゃあ、", "オイラとやるだな"}}, {{"先生! あたし、", "なんだか わかったよ", "うな気がする"}, {"それはよかったわ!"}, {"じゃあ そろそろ", "テストだにゃ"}, {"え? テスト!?"}, {"そうね ホントにここ", "までわかったかど"}, {"うか 先生が ためし", "てあげます"}}};
    private String[][] runrunEndingString = new String[][]{{"やったーっ! ", "先生に勝ったーっ!!"}, {"よくできました! ", "じゃあ、次は· · ·"}, {"え? まだあるのぉ!?"}, {"「わくわくコース」", "でまってますよ!"}};
    private String[][] wakuwakuOpeningString = new String[][]{{"こんにちは!", "あたしアミティ!!", "ステキな魔導師", "になるために魔導学校", "で勉強中なの!", "でも今日は、のんき", "に勉強なんて している"}, {"場合じゃないみた", "い というのも、", "アコール先生の", "大切な 飛翔のが", "なくなったらしいの!", "それて、みつけてき", "た人には 何かごほうび"}, {"があるって", "いうから", "みんな、", "はりきってるのよ...", "もちろん、", "あたしもね!"}};
    private String[][][] wakuwakuManzaiString = new String[][][]{{{"さんたちは、", "アミティさん"}, {"やあ ラフィーナ! ", "キミも 杖を探", "しに行くの?"}, {"ええ、もちろんそうよ"}, {"じゃあ、", "いっしょに行こうか!"}, {"· · ·何を ネボケたこと", "を おっしゃってますの?"}, {"ホエ?"}, {"ライバルは 少ない", "ほうが いいに", "決まってるでしょう!"}, {"あなたには、ここで ", "オネンネし", "ていただきますわ!"}}, {{"チェ〜〜〜ック!!"}, {"おわぁ〜〜〜つ! ", "ビックリしたあ"}, {"ちょっと、そこの ", "マッサ〜〜〜い", "かっこうした ア · ナ · タ!"}, {"ムカ! ", "ダサいとは失礼な!"}, {"あーら、ダサいもの", "をダサいって 言って ", "何がいけないのかしら?"}, {"ムカムカ!! ", "ちょっと、おこっち", "ゃったぞぉ~!"}, {"おーっほっほっほ! ", "くやしかったらアタ ", "シとぶよぶよ勝負よ!"}}, {{"あれ?", "リテルじゃない"}, {"ア、アミさん· · ·"}, {"ま、まさかキミまで· · ·"}, {"ご、ごめんなさい· · ·", "私も、 その、あの· · ·"}, {"いや、あやまられて", "も 困るんだけど· · ·"}, {"じゃあ、あの ", "お手やわらかに", "おねがいします"}, {"こ、こちらこそ· · · ", "(なぁんか調子", "くるうなぁ· · ·)"}}, {{"ケロケローッ!"}, {"イャーーーーッ!!"}, {"ケロケローッ!"}, {"も、もしかして ", "なんか怒ってる?"}}, {{"やあ、アミティ ", "キミも杖探しかい?"}, {"そうだよ、 クルーク でも、", "まだ材がどこにあるのか ", "ぜーんぜんわからないんだ"}, {"ふっふふ· · ·", "実はね アミティ"}, {"ボクはもう、ボクのグレイ", "トな 魔法で飛翔の杖のありか", "を つきとめているのさ!"}, {"な、なんだって!?"}, {"あとはとりに行くだけ· · · ", "· · ·そうだなあ キミ", "にも教えてあげようか?"}, {"ホント!"}, {"あぁ、ただしボクとの ", "ぶよぶよ勝負", "に勝てたらね!!"}}, {{"フ、", "フラガー ーッ!!"}, {"うわぁーーっ!", "ビックリしたぁ!"}, {"「つつハトオサナーイ!」", "· · ·と、言ってるにょ"}, {"「ココヲトオリタイナ", "ラぷよぷよ勝負ダー!」 ", "· · ·と、 言ってるにょ"}, {"あ、そうなんだ", "じゃあ、", "しょうがないね!"}, {"ランガラ", "ンガフ", "ガガーーーッ!!"}, {"「セイセイドウドウ", "2タイデ ショウブ", "ダーッ!」"}, {"· · ·と、言ってるにょ"}, {"どこが正々堂々", "なんだよっ!"}}, {{"やぁ、こんにちは!", "ぼくはアルル", "よろしくね"}, {"あたしはアミティ ", "よろしく!"}, {"ここは、どこ?"}, {"へ?"}, {"いやぁ、いつものようにぶよぶよ", "勝負してたんだけど気がついたら", " ここにいたんだ"}, {"ぜんぜん知らないところだし· · ·", "どうも 魔法の失敗のせいで", "とばされちゃったみたいだね"}, {"ふ~ん · · ·じゃあ、", "もう一回失敗したら", "元に戻れるかも?"}, {"なるほど!! じゃあ、", "さっそく", "ぶよぶよ勝負だね"}, {"うーん· · · やっぱり", "そうなるのかぁ"}}, {{"よくきたにゃ~、", "アミティ· · ·"}, {"ム、この感じ...", "クライマックス", "の予感!"}, {"オマエの探しているのは", "この金のオ かにゃ? それと", "もこの曲のオノかにゃ?"}, {"へ? いや、あたしの探し", "ているのは 先生の", "飛翔のなんだけど· · ·"}, {"にゃはははは!"}, {"よかろう", "たしかに飛翔の", "はここにある!· · ·"}, {"しかし、だだ", "さはやれんにゃ~"}, {"ぶよぶよ勝負!", "だね のぞむところだ!!"}}};
    private String[][] wakuwakuEndingString = new String[][]{{""}, {""}};
    private String[][] haraharaOpeningString = new String[][]{{""}};
    private String[][][] haraharaManzaiString = new String[][][]{{{""}}};
    private String[][][] tutorialString = new String[][][]{{{"おはようございます今日", "はぷよぷよフィーバー", "の選び方 を、"}, {"みんなでお", "勉強しましょう"}}, {{"ぷよは2匹だけじ", "ゃなく最大4匹も いっ", "しょに落ちてくるわ"}, {"ぷよは左右に動かしたり", "回転させた りできるけど、", "4匹いっしょになっ "}, {"た大きいぶよは、回転せ", "ずに色が変わるの· · · ", "フシギね"}}, {{"同じ色のぶよが上下左", "右に4匹以 上つなが", "ると消えてしまうの"}, {"このとき相手におじ", "ゃまぷよを送る ", "ことができるわ"}}, {{"ぷよが連続して消え", "るのが連鎖 いっぱい", "連鎖"}, {"をするとおじゃまぷよ ", "もいっぱいれるのよ"}}, {{"相手が迷惑ぷよを送っ", "てきても冷静さを失", "わないように。"}, {"相手の迷惑ぷよを", "自分のぷよで無効にす", "ることができます。"}, {"これを相殺といいます。"}, {"相殺後、迷惑ぷよ", "が落ちなくなりました。", "あきらめてはいけない。"}}, {{"相殺すると、", "フィーバーモード", "が始まります· · ·"}, {"フィーバーゲージ", "が満タンになった時。"}}, {{"フィーバーモードでは、", "迷惑ぷよがしばら", "く落ちません。"}}, {{"さらに良いのは、", "チェーンぷよがドロ", "ップし続けることです· · ·"}, {"他の後。", "かっこいいでしょ？"}, {"そして何があっ", "ても落ち続ける。うまく", "やればやるほど· · ·"}, {"チェーンを大き", "くします。もちろん、", "フィーバーモードでも· · ·"}, {"それでもチェーンを", "作ったり、迷惑なぷよ", "を相手に送ったりします"}}, {{"真ん中の2列が上まで", "埋まってしま うと、", "ゲームオーバーよ"}}, {{"そして、それはそれです。", "幸運を！"}}};
    private String[][] menuDescString = new String[][]{{"SINGLEPUYOPOP"}, {"ENDLESSFEVER"}, {"RUNRUN"}, {"WAKUWAKU"}, {"OPTION"}, {"TUTORIAL"}, {"SOUND"}, {"RANKING"}, {"ABOUT"}, {"DEBUG MENU"}};
    private String[][] aboutString = new String[][]{{"ぷよぷよフィーバー", "Re:れんさ", "", "Ver. 2.01_ja_JP (0000)", "リリース", "", "(C) SEGA"}};
    private int puyoMainGUI;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private byte[] w;
    private boolean x;
    private Thread y;
    private Display z;
    private long A;
    private long B;
    private int C;
    private Random D = new Random();
    private int E;
    private int F;
    private int G;
    private int H;
    private int optionMenuBase1;
    private int J;
    private int mainMenuBase;
    private int debugMenuBase = 0;
    private int debugMainMenuBase = 0;
    private int townMapBase = 0;
    private int townMapMenuBase = 0;
    private int townMapOptionBase1 = 0;
    private int townMapOptionBase2 = 0;
    private int townMapOptionBase3 = 0;
    private int endingManzaiBase = 0;
    private int fadeCode = 0;
    private int amtIdleTime = 0;
    private int loadAnimTime = 0;
    private int loadTime = 0;
    private int saveTime = 0;
    private int refreshTime = 0;
    private int soundOptionMenu;
    private int aboutOptionMenu;
    private int N;
    private boolean vibSetting;
    private boolean puyoSkinChangeFlag;
    private boolean bgColorChangeFlag;
    private boolean fadeFlag;
    private boolean debugModeFlag;
    private boolean TownmapDisabledFlag;
    private boolean TownmapSecondaryMap;
    private boolean TownmapSinglePuyoPopEntraceFlag;
    private boolean TownmapStageSelFlag;
    private boolean TownmapStageSelEntranceFlag;
    private boolean RunRunStageSelUnlockedFlag;
    private boolean WakuWakuStageSelUnlockedFlag;
    private boolean HaraHaraStageSelUnlockedFlag;
    private boolean FirstBootFlag;
    private boolean loadedFlag;
    private boolean sfxDisabledFlag;
    private boolean gameError;
    private boolean saveFlag;
    private boolean mainMenu;
    private boolean P;
    private boolean Q;
    private boolean[] R = new boolean[3];
    private int[] S = new int[3];
    private int[] T = new int[3];
    private int[] U = new int[3];
    private int[] V = new int[3];
    private int[] W = new int[3];
    private boolean X;
    private boolean[] Y = new boolean[2];
    private boolean[] Z = new boolean[2];
    private boolean[] aa = new boolean[2];
    private boolean[] ab = new boolean[2];
    private boolean[] ac = new boolean[2];
    private boolean[] ad = new boolean[2];
    private boolean ae;
    private boolean af;
    private boolean ag;
    private int ah;
    private int aj;
    private Font ak;
    private int hDW;
    private int hDH;
    private int an;
    private int ao;
    private int menuBaseC;
    private int aq;
    private int displayWidth;
    private int displayHeight;
    private int displayWidthSplash;
    private int currentDisplayWidth;
    private int at;
    private int au;
    private int av;
    private byte aw;
    private byte singlePuyoPopBase;
    private byte ay;
    private int[] az = new int[2];
    private int[] aA = new int[2];
    private int[] aB = new int[2];
    private int[] aC = new int[2];
    private int[] aD = new int[2];
    private int[] aE = new int[2];
    private int[] aF = new int[2];
    private int[] aG = new int[2];
    private int[] aH = new int[2];
    private byte[] aI = new byte[2];
    private byte[] aJ = new byte[2];
    private byte[][] aK = new byte[2][2];
    private byte[] aL = new byte[2];
    private int[] aM = new int[2];
    private int[] aN = new int[2];
    private byte[][] aO = new byte[2][9];
    private byte[][] aP = new byte[2][9];
    private byte[][] aQ = new byte[2][9];
    private byte[][][] aR = new byte[2][2][9];
    private int[] aS = new int[2];
    private int[] aT = new int[2];
    private int[][] aU = new int[2][2];
    private int[][] aV = new int[2][2];
    private int[] aW = new int[2];
    private int[] aX = new int[2];
    private int[] aY = new int[2];
    private int[] aZ = new int[2];
    private byte[] ba = new byte[2];
    private byte[][] bb = new byte[2][84];
    private byte[][] bc = new byte[2][84];
    private byte[][] bd = new byte[2][84];
    private byte[][] be = new byte[2][84];
    private int[] bf = new int[2];
    private int[][] bg = new int[2][84];
    private boolean[] bh = new boolean[2];
    private boolean[][] bi = new boolean[2][84];
    private int[] bj = new int[2];
    private byte[][] bk = new byte[2][84];
    private byte[][] bl = new byte[2][84];
    private byte[][] bm = new byte[2][84];
    private int[][] bn = new int[2][6];
    private byte[] bo = new byte[2];
    private int[][] bp = new int[2][84];
    private boolean[][] bq = new boolean[2][84];
    private int br;
    private boolean bs;
    private int bt;
    private int[] bu = new int[2];
    private boolean[][] bv = new boolean[2][5];
    private int[] bw = new int[2];
    private int[] bx = new int[2];
    private int[] by = new int[2];
    private int[] bz = new int[2];
    private int[] bA = new int[2];
    private int[] bB = new int[2];
    private int[] bC = new int[2];
    private int[] bD = new int[2];
    private int[] bE = new int[2];
    private int bF;
    private int bG;
    private int bH;
    private int bI;
    private int bJ;
    private int bK;
    private byte bL;
    private int bM;
    private int bN;
    private int bO;
    private int bP;
    private int bQ;
    private int bR;
    private byte bS;
    private int bT;
    private int[] characterBase = new int[2];
    private int[] bV = new int[2];
    private int[] bW = new int[2];
    private int[] bX = new int[2];
    private boolean[] bY = new boolean[2];
    private boolean[] bZ = new boolean[2];
    private boolean[] ca = new boolean[2];
    private int[] cb = new int[2];
    private boolean[] cc = new boolean[2];
    private int cd;
    private int[] ce = new int[2];
    private int[][][] cf = new int[3][5][3];
    private byte cg;
    private int[] ch = new int[2];
    private int[] ci = new int[2];
    private int[] cj = new int[2];
    private int[] ck = new int[2];
    private int[] cl = new int[2];
    private int[] cm = new int[2];
    private int[][] cn = new int[2][3];
    private int[][] co = new int[2][6];
    private int cp;
    private int[] cq = new int[2];
    private int[] cr = new int[2];
    private int[] cs = new int[2];
    private int[] ct = new int[2];
    private int[] cu = new int[2];
    private int[] cv = new int[2];
    private int[] cw = new int[2];
    private int[] cx = new int[2];
    private int[] cy = new int[2];
    private int[] cz = new int[2];
    private int[] cA = new int[2];
    private int[] cB = new int[2];
    private int[] cC = new int[2];
    private int[] cD = new int[2];
    private byte[] cE = new byte[2];
    private byte[][] cF = new byte[2][84];
    private byte[][] cG = new byte[2][84];
    private boolean[] cH = new boolean[2];
    private boolean[] cI = new boolean[84];
    private byte[] cJ = new byte[84];
    private byte[] cK = new byte[2];
    private byte[] cL = new byte[2];
    private int[] cM = new int[2];
    private int[] cN = new int[2];
    private byte[] cO = new byte[2];
    private byte[] cP = new byte[2];
    private byte[] cQ = new byte[2];
    private byte[] cR = new byte[2];
    private boolean[] cS = new boolean[2];
    private byte[] cT = new byte[2];
    private int[] cU = new int[2];
    private byte[] cV = new byte[2];
    private boolean[] cW = new boolean[2];
    private boolean cX;
    private boolean cY;
    private boolean[][] cZ = new boolean[2][2];
    private int[][] da = new int[2][2];
    private int[][] db = new int[2][17];
    private boolean[][] dc = new boolean[2][17];
    private byte[][] dd = new byte[2][17];
    private byte[][] de = new byte[2][17];
    private byte[][] df = new byte[2][17];
    private boolean[] dg = new boolean[2];
    private byte[] dh = new byte[2];
    private byte[][] di = new byte[2][6];
    private boolean[] winCondition = new boolean[2];
    private Player bgmPlayer;
    private Player puyoMove;
    private Player puyoRotate;
    private Player puyoDrop;
    private Player chain1;
    private Player chain2;
    private Player chain3;
    private Player chain4;
    private Player chain5;
    private Player chain6;
    private Player chain7;
    private Player nuisanceLight;
    private Player nuisanceHeavy;
    private Player pauseSound;
    private Player allClear;
    private Player feverEntry;
    private Player feverExit;
    private Player startMatch;
    private Player manzaiType;
    private Player amtTitleVoice;
    private Player amtStartVoice;
    private Player amtContinueVoice;
    private Player amtFevClearVoice;
    private Player amtFevMissVoice;
    private Player amtWinVoice;
    private Player amtLoseVoice;
    private Player amtTitleVoiceEN;
    private Player amtStartVoiceEN;
    private Player amtContinueVoiceEN;
    private Player amtFevClearVoiceEN;
    private Player amtFevMissVoiceEN;
    private Player amtWinVoiceEN;
    private Player amtLoseVoiceEN;
    private Player menuChoose;
    private Player menuSelect;
    private Player menuBack;
    private Player menuUnavailable;
    private Player ding;
    private byte dl;
    private boolean dm;
    private byte[] dn = new byte[2];
    private byte[][] uwu = new byte[2][4];
    private byte[][] dp = new byte[2][4];
    private byte[] dq = new byte[2];
    private int dr;
    private byte ds;
    private boolean dt;
    private int[] du = new int[2];
    private byte[] dv = new byte[2];
    private boolean dw;
    private byte dx;
    private byte dy;
    private boolean dz = false;
    private int dA;
    private byte dB;
    private int optionMenuBase2;
    private int dD;
    private boolean menu;
    private int dF;
    private int dG;
    private byte dH;
    private byte dI;
    private boolean dJ;
    private byte dK;
    private String[] bgmSound = new String[]{"/bgm/bgm00_title.mid", "/bgm/bgm01_menu.mid", "/bgm/bgm03_opening.mid", "/bgm/bgm04_manzai1.mid", "/bgm/bgm10_taisen1.mid", "/bgm/bgm11_taisen2.mid", "/bgm/bgm12_taisen3.mid", "/bgm/bgm13_taisen4.mid", "/bgm/bgm14_pinch.mid", "/bgm/bgm15_fever.mid", "/bgm/bgm18_clear.mid", "/bgm/bgm19_lose.mid", "/bgm/bgm05_manzai2.mid"};
    private static final int[][] dM = new int[][]{{15098980, 15790300}, {15098980, 15790300}, {15098980, 15790300}};
    private static final byte[] dN = new byte[]{0, 3, 2, 5, 1, 4};
    private static final short[] dO = new short[]{5, 138};
    private static final byte[][] dP = new byte[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static final byte[] dQ = new byte[]{1, 2, 0, 3};
    private static final byte[][] dR = new byte[][]{{1, 0}, {2, 0}, {2, 1}, {1, 1}};
    private static final short[] puyoDifficultyEasy = new short[]{6, 12, 20, 26, 32, 40, 48, 54, 60, 68, 76, 82, 90, 98, 104, 112};
    private static final short[] puyoDifficultyNormal = new short[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 128};
    private static final short[] puyoDifficultyHard = new short[]{16, 24, 32, 40, 48, 52, 64, 72, 80, 96, 104, 112, 128, 136, 160, 192};
    private static final short[] puyoDifficultyVeryHard = new short[]{24, 32, 40, 52, 64, 72, 80, 96, 104, 112, 128, 136, 160, 192, 224, 254};
    private static final short[] dT = new short[]{8, 8, 9, 9, 10, 10, 12, 12, 16, 16, 10, 10, 11, 11, 12, 12, 14, 14, 32, 32, 16, 16, 32, 32, 52, 52, 64, 64, 96, 96, 32, 32, 48, 48, 52, 52, 64, 64, 96, 96, 48, 48, 64, 64, 96, 96, 128, 128, 128, 128, 64, 64, 96, 96, 128, 128, 128, 128, 142, 142, 96, 96, 128, 128, 128, 128, 128, 128, 160, 160, 128, 128, 140, 140, 160, 160, 192, 192, 224, 224, 128, 128, 160, 160, 192, 192, 224, 224, 254, 254, 160, 160, 192, 192, 224, 224, 254, 254, 254, 254};
    private static final byte[][] dU = new byte[][]{{3, 4}, {3, 3}, {4, 4}, {3, 3}, {3, 3}, {3, 3}, {4, 4}, {4, 4}, {4, 4}, {5, 4}, {5, 4}, {3, 3}};
    private static final byte[] dV = new byte[]{4, 4, 5, 4, 4, 4, 5, 5, 5, 6, 7, 4, 4, 4, 5, 5, 5, 6, 7};
    private Image[] puyoGraphics = new Image[28];
    private Image mainBg;
    private Image loadBg;
    private Image dimBg;
    private Image exitBg;
    private Image msgWindow1;
    private Image msgWindow2;
    private Image pCardWindow;
    private Image optMenuSel;
    private Image optMenuSelHigh;
    private Image pauseMenuSel;
    private Image pauseMenuSelHigh;
    private Image townmapMainBg1;
    private Image townmapMainBg2;
    private Image townmapOptionBg;
    private Image townmapSinglePuyoPopBg;
    private Image townmapWindowLarge;
    private Image townmapWindowSmall;
    private Image townmapSchoolBgAkr;
    private Image townmapTownHallBgAkr;
    private Image townmapTownHallBgRei;
    private Image townmapPlaygroundBgArr;
    private Image townmapTowerBgHhd;
    private Image townmapStgSelBgRunRun;
    private Image townmapStgSelBgWakuWaku;
    private Image townmapStgSelBgHaraHara;
    private Image townmapMsgWindow;
    private Image townmapMsgWindowLarge;
    private Image townmapBarHigh;
    private Image townmapBar;
    private Image townmapMainArrLeft;
    private Image townmapMainArrRight;
    private Image townmapPopupSchool;
    private Image townmapPopupShop;
    private Image townmapPopupTownHall;
    private Image townmapPopupTower;
    private Image townmapPopupMuseum;
    private Image townmapPopupPlayground;
    private Image townmapCourseSelRunRun;
    private Image townmapCourseSelRunRunHigh;
    private Image townmapCourseSelWakuWaku;
    private Image townmapCourseSelWakuWakuHigh;
    private Image townmapCourseSelHaraHara;
    private Image townmapCourseSelHaraHaraHigh;
    private Image townmapStageSelHighlight;
    private Image wakuwakuEdBkg1;
    private Image wakuwakuEdBkg2;
    private Image wakuwakuEdBkg3;
    private Image amtIdle1;
    private Image amtIdle2;
    private Image amtIdle3;
    private Image amtIdle4;
    private Image amtIdle5;
    private Image loadAnim1;
    private Image loadAnim2;
    private Image loadAnim3;
    private Image loadAnim4;
    private Image loadAnim5;
    private Image loadAnim6;
    private Image loadAnim7;
    private Image loadAnim8;
    private Image loadAnim9;
    private Image loadAnim10;
    private Image loadAnim11;
    private Image loadAnim12;
    private Image puyoPreviewGummy;
    private Image puyoPreviewAqua;
    private Image puyoPreviewRetro;
    private Image puyoPreviewFever;
    private Image puyoPreviewClassic;
    private Image wipeFrame1;
    private Image wipeFrame2;
    private Image wipeFrame3;
    private Image wipeFrame4;
    private Image wipeFrame5;
    private Image wipeFrame6;
    private Image padlockIcon;
    private Image firstBootBg;
    private static final String[] charGUI = new String[]{"char/tp_amt", "char/tp_kob", "char/tp_krk", "char/tp_ker", "char/tp_rdl", "char/tp_rfn", "char/tp_trt", "char/tp_akr", "char/tp_frk", "char/tp_arr", "char/tp_ppi", "char/tp_ppi2", "char/tp_frk2"};
    private static final String[] puyoDropset = new String[]{"drop3ez", "drop4ez", "", "drop3", "drop4", "drop5", "drop3f", "drop4f", "drop5f"};
    private static final String[][] tutorialMenuGUI = new String[][]{{"tutorial/tu0", "tutorial/tu1", "tutorial/tu2", "tutorial/tu3_e", "tutorial/tu4", "tutorial/tu5", "tutorial/tu6", "tutorial/tu7", "tutorial/tut"}, {"tu0", "tu1", "tu2", "tu3_f", "tu4_f", "tu5_f", "tu6", "tu7", "tut"}, {"tu0", "tu1", "tu2", "tu3_i", "tu4_i", "tu5_i", "tu6", "tu7", "tut"}, {"tu0", "tu1", "tu2", "tu3_g", "tu4_g", "tu5_g", "tu6", "tu7", "tut"}, {"tu0", "tu1", "tu2", "tu3_s", "tu4_s", "tu5_s", "tu6", "tu7", "tut"}};
    private static final String[] puyoMainBgGUI1 = new String[]{"bg/bg1", "bg/bg_fev", "main/top1", "main/fev1", "main/ttlbg", "bg/bg0_pink"};
    private static final String[] puyoMainBgGUI2 = new String[]{"bg/bg1", "bg/bg_fev", "main/top2", "main/fev2", "main/ttlbg", "bg/bg0_blue"};
    private static final String[] puyoMainBgGUI3 = new String[]{"bg/bg1", "bg/bg_fev", "main/top3", "main/fev3", "main/ttlbg", "bg/bg0_orange"};
    private static final String[] puyoMainBgGUI4 = new String[]{"bg/bg1", "bg/bg_fev_og", "main/top4", "main/fev4", "main/ttlbg", "bg/bg0_og"};
    private static final String[] menuTextSptGUI1 = new String[]{"main/ttlz0.png"};
    private static final String[] menuTextSptGUI2 = new String[]{"main/ttlz1.png"};
    private static final String[] puyoMainSptGUI1 = new String[]{"main/puyofever_s_e1.png", "", "", "", ""};
    private static final String[] puyoMainSptGUI2 = new String[]{"main/puyofever_s_e2.png", "", "", "", ""};
    private static final String[] puyoMainSptGUI3 = new String[]{"main/puyofever_s_e3.png", "", "", "", ""};
    private static final String[] puyoMainSptGUI4 = new String[]{"main/puyofever_s_e4.png", "", "", "", ""};
    private static final String[] puyoTtlLogo = new String[]{"main/logo_e.png", "", "", "", ""};
    private static final String[] puyoTtlLogoBeta = new String[]{"main/logo_beta_e.png", "", "", "", ""};
    private static final String[] openingBg = new String[]{"opening/op_bg_e.png", "", "", "", ""};
    private static final String[] ingameTextSptGUI = new String[]{"main/scr_e.png", "", "", "", ""};
    private static final String[] endingBg = new String[]{"ending/ed_e.png", "", "", "", ""};
    private static byte[][] manzaiPosition = new byte[][]{{2, 0, 2, 1}, {2, 0, 2, 1}, {0, 1, 2, 0, 1, 1}, {1, 0, 1, 0, 1, 0, 1, 1}, {1, 0, 1, 0, 1, 0, 1}, {0, 1, 0, 1, 0, 1, 0}, {1, 0, 1, 0}, {1, 0, 1, 1, 0, 1, 0, 1}, {1, 0, 2, 2, 0, 1, 2, 2, 0}, {1, 0, 1, 0, 1, 1, 0, 1, 0}, {1, 0, 1, 0, 1, 1, 1, 0}, {0, 1, 0, 1, 0, 1, 0, 0}};
    private static byte[][] endingPosition = new byte[][]{{0, 1, 0, 1}, {0, 2, 0, 2, 2, 0, 1, 2, 2, 2, 0, 2, 0}};
    private static final byte[] ek = new byte[]{1, 2, 3, 4, 5, 6, 8};
    private static final byte[] el = new byte[]{2, 4, 8, 16, 16, 16};
    private static final short[][] em = new short[][]{{24, 32}, {24, 32}, {16, 32}, {16, 32}, {12, 32}, {12, 32}, {8, 32}, {8, 32}, {6, 32}, {6, 32}, {4, 32}, {4, 32}, {3, 32}, {2, 32}, {2, 32}, {2, 32}, {3, 64}, {1, 32}, {1, 32}, {1, 32}, {3, 128}, {3, 128}, {1, 64}, {1, 64}, {3, 256}, {3, 256}, {1, 128}};
    private static final short[] en = new short[]{720, 360, 180, 30, 6, 1, 0};
    private static final short[][][] eo = new short[][][]{{{4, 4}, {12, 10}, {24, 18}, {32, 22}, {48, 30}, {96, 48}, {160, 80}, {240, 120}, {320, 160}, {400, 240}, {500, 280}, {600, 288}, {700, 342}, {800, 400}, {900, 440}, {999, 480}, {999, 520}, {999, 560}, {999, 600}, {999, 640}, {999, 680}, {999, 720}, {999, 760}, {999, 800}}, {{4, 4}, {11, 11}, {22, 20}, {30, 25}, {45, 34}, {91, 55}, {153, 92}, {230, 139}, {309, 186}, {388, 281}, {488, 329}, {588, 339}, {693, 405}, {796, 476}, {900, 526}, {999, 576}, {999, 624}, {999, 672}, {999, 720}, {999, 768}, {999, 816}, {999, 864}, {999, 912}, {999, 960}}, {{4, 4}, {11, 9}, {24, 16}, {34, 20}, {53, 27}, {110, 43}, {188, 72}, {288, 108}, {392, 144}, {500, 216}, {638, 252}, {780, 259}, {945, 308}, {999, 360}, {999, 396}, {999, 432}, {999, 468}, {999, 504}, {999, 540}, {999, 576}, {999, 612}, {999, 648}, {999, 684}, {999, 720}}, {{4, 4}, {13, 10}, {25, 18}, {33, 21}, {49, 29}, {96, 46}, {158, 76}, {235, 113}, {310, 150}, {384, 223}, {475, 259}, {564, 266}, {644, 313}, {728, 364}, {810, 398}, {890, 432}, {968, 468}, {999, 504}, {999, 540}, {999, 576}, {999, 612}, {999, 648}, {999, 684}, {999, 720}}, {{4, 3}, {13, 8}, {26, 14}, {35, 18}, {53, 24}, {106, 38}, {176, 64}, {264, 96}, {352, 128}, {440, 192}, {550, 224}, {660, 230}, {770, 274}, {880, 320}, {990, 352}, {999, 384}, {999, 416}, {999, 448}, {999, 480}, {999, 512}, {999, 544}, {999, 576}, {999, 608}, {999, 640}}, {{4, 4}, {11, 9}, {24, 17}, {33, 20}, {51, 28}, {106, 46}, {179, 76}, {274, 115}, {371, 154}, {472, 233}, {600, 273}, {732, 282}, {882, 337}, {999, 396}, {999, 438}, {999, 480}, {999, 520}, {999, 560}, {999, 600}, {999, 640}, {999, 680}, {999, 720}, {999, 760}, {999, 800}}, {{4, 4}, {13, 10}, {25, 18}, {33, 21}, {49, 29}, {96, 46}, {158, 76}, {235, 113}, {310, 150}, {384, 223}, {475, 259}, {564, 266}, {644, 313}, {728, 364}, {810, 398}, {890, 432}, {968, 468}, {999, 504}, {999, 540}, {999, 576}, {999, 612}, {999, 648}, {999, 684}, {999, 720}}, {{4, 4}, {11, 10}, {24, 18}, {33, 21}, {51, 29}, {106, 46}, {179, 76}, {274, 113}, {371, 150}, {472, 223}, {600, 259}, {732, 266}, {882, 313}, {999, 364}, {999, 398}, {999, 432}, {999, 468}, {999, 504}, {999, 540}, {999, 576}, {999, 612}, {999, 648}, {999, 684}, {999, 720}}, {{4, 4}, {13, 11}, {25, 19}, {32, 22}, {47, 29}, {91, 46}, {150, 75}, {221, 110}, {290, 145}, {356, 214}, {438, 245}, {516, 250}, {581, 290}, {652, 332}, {720, 359}, {785, 384}, {847, 416}, {888, 448}, {999, 480}, {999, 512}, {999, 544}, {999, 576}, {999, 608}, {999, 640}}, {{4, 4}, {12, 10}, {24, 18}, {33, 21}, {50, 29}, {101, 46}, {169, 76}, {254, 113}, {341, 150}, {428, 223}, {538, 259}, {648, 266}, {763, 313}, {876, 364}, {990, 398}, {999, 432}, {999, 468}, {999, 504}, {999, 540}, {999, 576}, {999, 612}, {999, 648}, {999, 684}, {999, 720}}, {{4, 5}, {11, 12}, {22, 22}, {29, 26}, {43, 36}, {86, 58}, {144, 96}, {216, 144}, {288, 192}, {360, 288}, {450, 336}, {540, 346}, {630, 410}, {720, 480}, {810, 528}, {900, 576}, {990, 624}, {999, 672}, {999, 720}, {999, 768}, {999, 816}, {999, 864}, {999, 912}, {999, 960}}};
    private static final byte[][] ep = new byte[][]{{0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 1, 0, 0, 0, 3}, {0, 0, 0, 0, 1, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 3}, {0, 0, 1, 0, 1, 0, 2, 0, 1, 0, 2, 0, 1, 0, 0, 3}, {0, 0, 0, 1, 0, 0, 0, 3, 0, 0, 0, 2, 0, 0, 0, 3}, {0, 0, 0, 1, 0, 0, 2, 0, 0, 1, 0, 0, 2, 0, 0, 3}, {0, 0, 1, 0, 0, 2, 0, 0, 0, 1, 0, 0, 1, 0, 0, 3}, {0, 0, 1, 0, 0, 2, 0, 1, 0, 0, 2, 0, 0, 1, 0, 3}, {0, 1, 0, 1, 0, 1, 0, 2, 0, 1, 0, 1, 0, 1, 0, 3}, {0, 0, 1, 0, 0, 1, 0, 2, 0, 1, 0, 1, 0, 1, 0, 3}, new byte[16], {0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 2, 0, 2, 0, 3}};
    private short[][] eq = new short[2][84];
    private static final short[][][] er = new short[][][]{{{2, 1, 0, 0, 1, 2}, {3, 1, 0, 0, 1, 3}, {4, 2, 0, 0, 2, 4}, {6, 4, 1, 1, 4, 6}, {9, 8, 4, 4, 8, 9}, {12, 11, 9, 9, 11, 12}, {14, 13, 10, 10, 13, 14}, {17, 15, 13, 13, 15, 17}, {20, 17, 15, 15, 17, 20}, {24, 21, 18, 18, 21, 24}, {28, 24, 22, 22, 24, 28}, {32, 30, 27, 27, 30, 32}, {36, 34, 32, 32, 34, 36}, {40, 38, 36, 36, 38, 40}}, {{2, 1, 0, 0, 1, 2}, {3, 1, 0, 0, 1, 3}, {4, 3, 0, 0, 3, 4}, {5, 4, 1, 1, 4, 5}, {8, 5, 2, 2, 5, 8}, {30, 30, 20, 20, 40, 40}, {30, 30, 20, 20, 40, 40}, {30, 30, 20, 20, 40, 40}, {70, 71, 60, 61, 80, 81}, {73, 72, 63, 62, 83, 82}, {74, 75, 64, 65, 84, 85}, {110, 111, 100, 101, 120, 121}, {113, 112, 103, 102, 123, 122}, {114, 115, 104, 105, 124, 125}}, {{2, 1, 0, 0, 1, 2}, {3, 1, 0, 0, 1, 3}, {4, 2, 0, 0, 2, 4}, {5, 4, 1, 1, 4, 5}, {9, 8, 3, 3, 8, 9}, {12, 11, 5, 5, 10, 12}, {14, 12, 7, 7, 12, 14}, {17, 16, 8, 8, 16, 17}, {19, 18, 9, 9, 18, 19}, {21, 21, 10, 10, 21, 21}, {23, 23, 12, 12, 23, 23}, {25, 25, 15, 15, 25, 25}, {28, 27, 17, 17, 27, 28}, {32, 30, 20, 20, 30, 32}}, {{2, 1, 0, 0, 1, 2}, {3, 1, 0, 0, 1, 3}, {40, 2, 0, 0, 1, 100}, {42, 4, 1, 1, 2, 102}, {44, 6, 3, 3, 80, 104}, {46, 8, 5, 5, 82, 106}, {48, 10, 9, 9, 84, 108}, {50, 14, 13, 13, 86, 110}, {52, 16, 15, 15, 88, 112}, {54, 18, 17, 17, 90, 114}, {56, 19, 19, 19, 92, 116}, {58, 22, 21, 21, 94, 118}, {60, 27, 27, 27, 96, 120}, {62, 30, 30, 30, 98, 122}}, {{2, 1, 0, 0, 1, 2}, {3, 1, 0, 0, 1, 3}, {18, 6, 0, 0, 1, 2}, {20, 18, 1, 1, 2, 3}, {22, 21, 2, 2, 3, 5}, {24, 23, 3, 3, 5, 7}, {26, 25, 4, 5, 7, 9}, {28, 27, 5, 7, 9, 11}, {30, 29, 7, 9, 11, 13}, {33, 32, 10, 11, 13, 15}, {36, 34, 13, 13, 15, 17}, {40, 38, 20, 15, 17, 19}, {45, 42, 23, 20, 19, 20}, {50, 46, 26, 24, 22, 21}}, {{2, 1, 0, 0, 1, 2}, {3, 1, 0, 0, 1, 3}, {16, 2, 0, 0, 2, 16}, {21, 4, 1, 1, 4, 21}, {23, 6, 3, 3, 6, 23}, {25, 8, 5, 5, 8, 25}, {27, 21, 7, 7, 21, 27}, {30, 23, 8, 8, 23, 30}, {32, 25, 9, 9, 25, 32}, {35, 28, 10, 10, 28, 35}, {40, 30, 12, 12, 30, 40}, {45, 32, 15, 15, 32, 45}, {48, 35, 17, 17, 35, 48}, {50, 40, 20, 20, 40, 50}}, {{2, 1, 0, 0, 1, 2}, {3, 1, 0, 0, 1, 3}, {4, 2, 0, 0, 2, 4}, {5, 5, 1, 1, 5, 5}, {9, 9, 3, 3, 9, 9}, {12, 12, 9, 9, 12, 12}, {14, 14, 10, 10, 14, 14}, {17, 17, 13, 13, 17, 17}, {19, 19, 15, 15, 19, 19}, {21, 21, 17, 17, 21, 21}, {23, 23, 19, 19, 23, 23}, {30, 30, 30, 30, 30, 30}, {40, 40, 40, 40, 40, 40}, {50, 50, 50, 50, 50, 50}}, {{2, 1, 0, 0, 1, 2}, {3, 1, 0, 0, 1, 3}, {20, 2, 0, 0, 2, 20}, {24, 4, 1, 1, 4, 24}, {28, 8, 3, 3, 8, 28}, {32, 11, 9, 9, 11, 32}, {36, 13, 10, 10, 13, 36}, {40, 15, 13, 13, 15, 40}, {44, 17, 15, 15, 17, 44}, {48, 19, 17, 17, 19, 48}, {52, 21, 19, 19, 21, 52}, {56, 23, 21, 21, 23, 56}, {60, 25, 23, 23, 25, 60}, {64, 27, 25, 25, 27, 64}}, {{1, 1, 0, 0, 1, 1}, {2, 1, 0, 0, 1, 2}, {3, 2, 0, 0, 2, 3}, {4, 3, 1, 1, 3, 4}, {5, 5, 4, 4, 5, 5}, {6, 6, 6, 6, 6, 6}, {7, 7, 7, 7, 7, 7}, {8, 8, 8, 8, 8, 8}, {9, 9, 9, 9, 9, 9}, {40, 40, 10, 10, 40, 40}, {60, 60, 13, 13, 60, 60}, {80, 80, 15, 15, 80, 80}, {100, 100, 17, 17, 100, 100}, {120, 120, 20, 20, 120, 120}}, {{2, 1, 0, 0, 1, 2}, {3, 1, 0, 0, 1, 3}, {8, 2, 0, 0, 2, 8}, {10, 4, 1, 1, 4, 10}, {13, 8, 3, 3, 8, 13}, {17, 11, 9, 9, 11, 17}, {19, 13, 10, 10, 13, 19}, {21, 15, 13, 13, 15, 21}, {23, 17, 15, 15, 17, 23}, {25, 19, 17, 17, 19, 25}, {27, 21, 19, 19, 21, 27}, {30, 24, 21, 21, 24, 30}, {35, 30, 25, 25, 30, 35}, {40, 35, 30, 30, 35, 40}}, {{2, 1, 0, 0, 1, 2}, {3, 1, 0, 0, 1, 3}, {20, 2, 0, 0, 2, 20}, {24, 4, 1, 1, 4, 24}, {28, 8, 3, 3, 8, 28}, {32, 16, 9, 9, 16, 32}, {36, 24, 10, 10, 24, 36}, {40, 30, 13, 13, 30, 40}, {80, 81, 15, 15, 60, 61}, {83, 82, 17, 17, 63, 62}, {84, 85, 19, 19, 64, 65}, {120, 121, 20, 20, 100, 101}, {123, 122, 22, 22, 103, 102}, {124, 125, 24, 24, 104, 105}}};
    private byte[] es = new byte[4992];
    private Puyo et;
    private static final int[][][] rankingDefaultHighScores = new int[][][]{{{30000, 3, 180}, {25000, 2, 144}, {20000, 2, 108}, {15000, 1, 72}, {10000, 1, 36}}, {{50000, 7, 252}, {40000, 6, 216}, {30000, 5, 180}, {20000, 4, 144}, {10000, 3, 108}}, {{500000, 12, 252}, {400000, 11, 216}, {300000, 10, 180}, {200000, 9, 144}, {100000, 8, 108}}};
    private int ev = 0;
    private static final byte[] ew = new byte[]{0, 1, 2, 0, 1, 3, 0, 1, 4};
    private int[] ex = new int[6];
    private byte tutorialBase1;
    private byte tutorialBase2;
    private long eA = 0L;
    private boolean eB;
    private int eC;
    private int eD;
    private int eE;
    private int eF;
    private String[][] singlePuyoPopManzaiBase;
    private static final byte[][] eH = new byte[][]{{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    private static final int[] eI = new int[]{1000, 5000, 10000, 1000, 3000, 5000, 10000, 20000, 30000, 50000, 100000, 1000, 3000, 5000, 10000, 20000, 30000, 50000, 100000};
    private static final short[] eJ = new short[]{0, 0, 1, 1, 2, 2};
    private static final short[] eK = new short[]{0, 64, 0, 64, 0, 64};
    private static final int[] eL = new int[]{0, 16, 27, 36, 42, 50, 56, 64};
    private static final byte[] eM = new byte[]{0, 3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36, 39, 42, 45, 48, 51, 54, 57, 59, 62, 65, 67, 70, 73, 75, 78, 80, 82, 85, 87, 89, 91, 94, 96, 98, 100, 102, 103, 105, 107, 108, 110, 112, 113, 114, 116, 117, 118, 119, 120, 121, 122, 123, 123, 124, 125, 125, 126, 126, 126, 126, 126, 126, 126, 126, 126, 126, 126, 125, 125, 124, 123, 123, 122, 121, 120, 119, 118, 117, 116, 114, 113, 112, 110, 108, 107, 105, 103, 102, 100, 98, 96, 94, 91, 89, 87, 85, 82, 80, 78, 75, 73, 70, 67, 65, 62, 59, 57, 54, 51, 48, 45, 42, 39, 36, 33, 30, 27, 24, 21, 18, 15, 12, 9, 6, 3, 0, -3, -6, -9, -12, -15, -18, -21, -24, -27, -30, -33, -36, -39, -42, -45, -48, -51, -54, -57, -59, -62, -65, -67, -70, -73, -75, -78, -80, -82, -85, -87, -89, -91, -94, -96, -98, -100, -102, -103, -105, -107, -108, -110, -112, -113, -114, -116, -117, -118, -119, -120, -121, -122, -123, -123, -124, -125, -125, -126, -126, -126, -126, -126, -126, -126, -126, -126, -126, -126, -125, -125, -124, -123, -123, -122, -121, -120, -119, -118, -117, -116, -114, -113, -112, -110, -108, -107, -105, -103, -102, -100, -98, -96, -94, -91, -89, -87, -85, -82, -80, -78, -75, -73, -70, -67, -65, -62, -59, -57, -54, -51, -48, -45, -42, -39, -36, -33, -30, -27, -24, -21, -18, -15, -12, -9, -6, -3, 0};

    public a(Puyo var1) {
        this.et = var1;

        this.displayWidthSplash += this.getWidth();

        try {
			if (this.displayWidthSplash >= 480) {
                this.f = Image.createImage("/splash/rtl_logo_large.png");
			} else if (this.displayWidthSplash == 352) {
                this.f = Image.createImage("/splash/rtl_logo_large.png");
			} else {
                this.f = Image.createImage("/splash/rtl_logo.png");
			}
			
            this.splashRGBw[0] = this.f.getWidth();
            this.splashRGBh[0] = this.f.getHeight();
            this.splashRGB[0] = new int[this.splashRGBw[0] * this.splashRGBh[0]];
            this.f.getRGB(this.splashRGB[0], 0, this.splashRGBw[0], 0, 0, this.splashRGBw[0], this.splashRGBh[0]);
            this.f = null;
        } catch (Exception var4) {
        }

        try {
			if (this.displayWidthSplash >= 480) {
                this.g = Image.createImage("/splash/sega_sonic_logo_large.png");
			} else if (this.displayWidthSplash == 352) {
                this.g = Image.createImage("/splash/sega_sonic_logo_large.png");
			} else {
                this.g = Image.createImage("/splash/sega_sonic_logo.png");
			}
			
            this.splashRGBw[1] = this.g.getWidth();
            this.splashRGBh[1] = this.g.getHeight();
            this.splashRGB[1] = new int[this.splashRGBw[1] * this.splashRGBh[1]];
            this.g.getRGB(this.splashRGB[1], 0, this.splashRGBw[1], 0, 0, this.splashRGBw[1], this.splashRGBh[1]);
            this.g = null;
        } catch (Exception var3) {
        }

        this.y = new Thread(this);
        this.y.start();
    }

    private int a(String var1, byte[] var2) {
        int var3 = 0;

        try {
            DataInputStream var5;
            int var6;
            for(var5 = new DataInputStream(this.getClass().getResourceAsStream("/" + var1)); (var6 = var5.read(var2, var3, var2.length - var3)) != -1 && var6 != 0; var3 += var6) {
            }

            var5.close();
        } catch (Exception var6) {
            var6.printStackTrace();
        }

        return var3;
    }

    private void puyoFever(String var1, int var2) {
        try {
            this.puyoGraphics[var2] = null;
            int var5 = this.a(var1, this.w);
            this.puyoGraphics[var2] = Image.createImage(this.w, 0, var5);
        } catch (Exception var4) {
			this.gameError = true;
			this.E = 44;
            var4.printStackTrace();
        }

    }

    protected final void keyPressed(int var1) {
        switch(var1) {
        case -50:
        case -21:
        case -6:
            this.ev |= 32;
            return;
        case -22:
        case -7:
        case 8:
            this.ev |= 64;
            return;
        case 10:
        case 53:
            this.ev |= 16;
            return;
        case 46:
        case 50:
        case 58:
        case 87:
        case 119:
            this.ev |= 1;
            return;
        case 52:
        case 65:
        case 97:
            this.ev |= 2;
            return;
        case 54:
        case 68:
        case 100:
            this.ev |= 8;
            return;
        case 56:
        case 83:
        case 115:
            this.ev |= 4;
            return;
        default:
            switch(this.getGameAction(var1)) {
            case 1:
                this.ev |= 1;
                return;
            case 2:
                this.ev |= 2;
                return;
            case 5:
                this.ev |= 8;
            case 3:
            case 4:
            case 7:
            default:
                return;
            case 6:
                this.ev |= 4;
                return;
            case 8:
                this.ev |= 16;
            }
        }
    }

    protected final void keyReleased(int var1) {
        switch(var1) {
        case -50:
        case -21:
        case -6:
            this.ev &= -33;
            return;
        case -22:
        case -7:
        case 8:
            this.ev &= -65;
            return;
        case 10:
        case 53:
            this.ev &= -17;
            return;
        case 46:
        case 50:
        case 58:
        case 87:
        case 119:
            this.ev &= -2;
            return;
        case 52:
        case 65:
        case 97:
            this.ev &= -3;
            return;
        case 54:
        case 68:
        case 100:
            this.ev &= -9;
            return;
        case 56:
        case 83:
        case 115:
            this.ev &= -5;
            return;
        default:
            switch(this.getGameAction(var1)) {
            case 1:
                this.ev &= -2;
                return;
            case 2:
                this.ev &= -3;
                return;
            case 5:
                this.ev &= -9;
            case 3:
            case 4:
            case 7:
            default:
                return;
            case 6:
                this.ev &= -5;
                return;
            case 8:
                this.ev &= -17;
            }
        }
    }

    private void a() {
        this.t = this.ev;
        this.s = ~this.u & this.t;
        this.u = this.t;
        if (this.E != 10) {
            if ((this.t & this.u & 8) != 0) {
                this.v += this.C;
                if (this.v > 400) {
                    this.s |= 8;
                    this.v = 0;
                    return;
                }
            } else if ((this.t & this.u & 2) != 0) {
                this.v += this.C;
                if (this.v > 400) {
                    this.s |= 2;
                    this.v = 0;
                }
            }
        }

    }

    private void setSoftkeyText(String var1, String var2) {
        this.leftSoftkeyText = var1;
        this.rightSoftkeyText = var2;
    }

    private void b() {
        this.characterBase[0] = 0;
        if (this.dm) {
            this.puyoFever(charGUI[this.characterBase[0]] + ".png", 25);
        }

        if (this.br > 0) {
            this.cr[1] = this.singlePuyoPopBase + 1;
            this.characterBase[1] = this.c(1, this.cr[1]);
            if (this.dm) {
                this.puyoFever(charGUI[this.characterBase[1]] + ".png", 26);
                byte var1;
                if (this.singlePuyoPopBase == 2) {
                    var1 = 11;
                } else if (this.singlePuyoPopBase == 8) {
                    var1 = 12;
                } else {
                    var1 = 7;
                }

                this.puyoFever(charGUI[var1] + ".png", 27);
            }
        }

        this.dm = false;
    }

    private void c() {
        this.bF = 0;
        this.bG = 0;
        this.bE[0] = -1;
        this.bE[1] = -1;
        this.cb[0] = 0;
        this.cb[1] = 0;
        this.bH = 0;
        this.bI = 0;
    }

    private void d() {
        this.cg = -1;

        for(int var1 = 0; var1 < 5; ++var1) {
            if (this.bK > this.cf[this.aw][var1][0]) {
                if (var1 == 0) {
                    this.R[this.aw] = true;
                }

                this.cg = (byte)var1;

                for(int var2 = 4; var2 > var1; --var2) {
                    for(int var3 = 0; var3 < 3; ++var3) {
                        this.cf[this.aw][var2][var3] = this.cf[this.aw][var2 - 1][var3];
                    }
                }

                this.cf[this.aw][var1][0] = this.bK;
                this.cf[this.aw][var1][1] = this.bP;
                this.cf[this.aw][var1][2] = this.bJ;
                return;
            }
        }

    }

    private void e() {
        this.a(dV[this.singlePuyoPopBase]);
    }

    private void f() {
        if (this.aw == 2) {
            if (!this.cX && this.bX[0] < 10000) {
                this.cX = true;
                this.a(8);
            }

            if (this.cX && this.bX[0] >= 15000) {
                this.cX = false;
                this.a(9);
                return;
            }
        } else if (!this.bY[0] && !this.bY[1]) {
            int var1 = 0;

            for(int var2 = 0; var2 < 6; ++var2) {
                var1 += this.di[0][var2];
            }

            if (this.cY) {
                this.cY = false;
                this.e();
            }

            if (!this.cX) {
                if (var1 < 18) {
                    this.cX = true;
                    this.a(8);
                    return;
                }
            } else if (var1 > 30) {
                this.cX = false;
                this.e();
            }
        } else if (!this.cY) {
            this.cY = true;
            this.a(9);
            return;
        }

    }

    private void g() {
        this.i();
        this.G = 5;
        this.ag = true;
        if (this.sfxType == 1 || this.sfxType == 2) {
            try {
                ((VolumeControl)this.pauseSound.getControl("VolumeControl")).setLevel(this.b);
                this.pauseSound.start();
            } catch (Exception var2) {
                var2.printStackTrace();
            }
        }

        this.setSoftkeyText("レジュメ", "終了");
        this.z.vibrate(0);
    }

    private void h() {
        int var1;
        if (this.G == 4) {
            this.cd += this.C;

            for(var1 = 0; var1 < 2; ++var1) {
                if (this.bY[var1]) {
                    int[] var10000 = this.bX;
                    var10000[var1] -= this.C;
                    if (this.bX[var1] < 0) {
                        this.bX[var1] = 0;
                    }
                }
            }
        }

        switch(this.G) {
        case 0:
            this.H = 0;
            if (this.aw == 2) {
                this.G = 1;
                this.c();
                this.a(9);
            } else {
                this.G = 2;
            }
            break;
        case 1:
            if ((this.s & 1) != 0) {
                if (this.sfxType == 1 || this.sfxType == 2) {
                    try {
                        ((VolumeControl)this.menuChoose.getControl("VolumeControl")).setLevel(this.b);
                        this.menuChoose.start();
                    } catch (Exception var10) {
                        var10.printStackTrace();
                    }
                }

                --this.singlePuyoPopBase;
                if (this.singlePuyoPopBase < 0) {
                    this.singlePuyoPopBase = 2;
                }
            } else if ((this.s & 4) != 0) {
                if (this.sfxType == 1 || this.sfxType == 2) {
                    try {
                        ((VolumeControl)this.menuChoose.getControl("VolumeControl")).setLevel(this.b);
                        this.menuChoose.start();
                    } catch (Exception var9) {
                        var9.printStackTrace();
                    }
                }

                ++this.singlePuyoPopBase;
                if (this.singlePuyoPopBase > 2) {
                    this.singlePuyoPopBase = 0;
                }
            } else if ((this.s & 16) != 0) {
                if (this.sfxType == 1 || this.sfxType == 2) {
                    try {
                        ((VolumeControl)this.menuSelect.getControl("VolumeControl")).setLevel(this.b);
                        this.menuSelect.start();
                    } catch (Exception var8) {
                        var8.printStackTrace();
                    }
                }

                this.ah = 0;
                this.G = 2;
                this.bo[0] = (byte)(3 + this.singlePuyoPopBase);
                switch(this.singlePuyoPopBase) {
                case 0:
                    this.singlePuyoPopBase = 1;
                    this.bB[0] = 0;
                    break;
                case 1:
                    this.singlePuyoPopBase = 5;
                    this.bB[0] = 50000;
                    break;
                case 2:
                    this.singlePuyoPopBase = 10;
                    this.bB[0] = 100000;
                }

                this.cE[0] = this.singlePuyoPopBase;
                this.a(puyoDropset[this.bo[0] - 3 + this.aw * 3] + ".dat", this.es);

                for(var1 = 0; var1 < 2; ++var1) {
                    this.b(0);
                }

                this.m(0);
            }
            break;
        case 2:
            this.ah += this.C;
            if (this.ah >= 1200) {
                if (this.sfxType == 1 || this.sfxType == 2) {
                    try {
                        ((VolumeControl)this.startMatch.getControl("VolumeControl")).setLevel(this.b);
                        this.startMatch.start();
                    } catch (Exception var7) {
                        var7.printStackTrace();
                    }
                }

                this.ah = 0;
                this.G = 3;
            }
            break;
        case 3:
            this.ah += this.C;
            if (this.ah >= 500) {
                this.ah = 0;
                this.G = 4;
                this.setSoftkeyText("", "");
                this.setSoftkeyText("休憩", "");
                if (this.aw != 2) {
                    this.e();
                }
            }

            this.Y[0] = this.Y[1] = true;
            break;
        case 4:
            for(var1 = 0; var1 < this.br; ++var1) {
                this.ch[var1] = this.cj[var1] + this.ck[var1];
                this.ci[var1] = this.cl[var1];
            }

            for(var1 = 0; var1 < this.br; ++var1) {
                this.n(var1);
            }

            for(var1 = 0; var1 < this.br; ++var1) {
                if (this.ch[var1] != this.cj[var1] + this.ck[var1] || this.ci[var1] != this.cl[var1]) {
                    this.ab[var1] = true;
                }
            }

            if (!this.Q) {
                this.f();
            }

            if (!this.Q) {
                if (this.winCondition[0]) {
                    this.a(11);
                    this.az[0] = 9;
                    this.az[1] = 16;
                    if (this.sfxType == 1 || this.sfxType == 2) {
						if (this.voiceLangType == 0) {
                            try {
                                ((VolumeControl)this.amtLoseVoice.getControl("VolumeControl")).setLevel(this.b);
                                this.amtLoseVoice.start();
                            } catch (Exception var) {
                                var.printStackTrace();
                            }
						} else if (this.voiceLangType == 1) {
                            try {
                                ((VolumeControl)this.amtLoseVoiceEN.getControl("VolumeControl")).setLevel(this.b);
                                this.amtLoseVoiceEN.start();
                            } catch (Exception var) {
                                var.printStackTrace();
                            }
						}
                    }

                    if (this.TownmapStageSelFlag) {
                        this.setSoftkeyText("リトライ", "終了");
                    } else {
                        this.setSoftkeyText("リトライ", "終了");
                    }

                    this.Q = true;
                } else if (this.winCondition[1]) {
                    this.a(10);
                    this.az[0] = 16;
                    this.az[1] = 9;
                    if (this.sfxType == 1 || this.sfxType == 2) {
						if (this.voiceLangType == 0) {
                            try {
                                ((VolumeControl)this.amtWinVoice.getControl("VolumeControl")).setLevel(this.b);
                                this.amtWinVoice.start();
                            } catch (Exception var) {
                                var.printStackTrace();
                            }
						} else if (this.voiceLangType == 1) {
                            try {
                                ((VolumeControl)this.amtWinVoiceEN.getControl("VolumeControl")).setLevel(this.b);
                                this.amtWinVoiceEN.start();
                            } catch (Exception var) {
                                var.printStackTrace();
                            }
						}
                    }

                    if (this.TownmapStageSelFlag) {
                        this.setSoftkeyText("リトライ", "終了");
                    } else {
                        this.setSoftkeyText("次へ", "");
                    }

                    this.Q = true;
                }

                if (this.Q) {
                    this.ah = 0;
                    this.bF += this.bB[0];
                    this.bB[0] = 0;
                    if (this.aw == 2) {
                        this.bI += this.cd;
                        this.bP = this.bE[0] + 1;
                        this.bJ = this.bI / 1000;
                        this.bT = (this.singlePuyoPopBase + 1) * 500;
                        if (this.bJ < 200) {
                            this.bN = this.bJ * 50;
                        } else if (this.bJ < 400) {
                            this.bN = this.bJ * 100 - 10000;
                        } else if (this.bJ < 750) {
                            this.bN = this.bJ * 200 - '썐';
                        } else {
                            this.bN = 100000;
                        }

                        if (this.bP == 0) {
                            this.bQ = 0;
                        } else if (this.bP == 1) {
                            this.bQ = 24240;
                        } else if (this.bP <= 6) {
                            this.bQ = this.bP * 1000;
                        } else if (this.bP <= 10) {
                            this.bQ = this.bP * 2000 - 6000;
                        } else {
                            this.bQ = this.bP * 4000 - 26000;
                        }

                        this.bQ <<= 1;
                        if (this.cb[0] == 0) {
                            this.bR = 0;
                        } else if (this.cb[0] <= 8) {
                            this.bR = this.cb[0] * 500;
                        } else if (this.cb[0] <= 16) {
                            this.bR = this.cb[0] * 1000 - 4000;
                        } else if (this.cb[0] <= 24) {
                            this.bR = this.cb[0] * 1500 - 12000;
                        } else if (this.cb[0] <= 36) {
                            this.bR = this.cb[0] * 2000 - 24000;
                        } else {
                            this.bR = 50000;
                        }

                        this.bR <<= 1;
                        this.bK = this.bF + this.bT + this.bN + this.bQ + this.bR;
                        this.d();
                        this.u();
                    }

                    if (this.vibSetting){
                        this.z.vibrate(1200);
                    }
                }

                if ((this.s & 32) != 0) {
                    this.g();
				} else if ((this.s & 64) != 0) {
					if (this.debugModeFlag) {
                        this.bV[0] = 7;
                        this.bX[0] = 60000;
					}
                }
            }
            break;
        case 5:
            if ((this.s & 32) != 0) {
                this.G = 4;
                this.ag = false;
                this.X = true;
                this.Y[0] = true;
                this.Y[1] = true;
                this.Z[0] = true;
                this.Z[1] = true;
                this.aa[0] = true;
                this.aa[1] = true;
                if (this.Q) {
                    this.setSoftkeyText("リトライ", "終了");
                } else {
                    this.setSoftkeyText("休憩", "");
                }

                this.j();
                if (this.sfxType == 1 || this.sfxType == 2) {
                    try {
                        ((VolumeControl)this.menuSelect.getControl("VolumeControl")).setLevel(this.b);
                        this.menuSelect.start();
                    } catch (Exception var4) {
                        var4.printStackTrace();
                    }
                }
            } else if ((this.s & 16) != 0) {
                if (this.debugModeFlag) {
                    if (this.TownmapStageSelFlag) {
                        this.TownmapStageSelFlag = false;
                    }

                    this.E = 69;
                }
            } else if ((this.s & 64) != 0) {
                this.ag = false;
                if (this.TownmapDisabledFlag) {
                    this.F = 1;
                } else if (this.TownmapStageSelFlag) {
                    this.TownmapStageSelFlag = false;
                    this.TownmapSinglePuyoPopEntraceFlag = true;
                    this.optionMenuBase2 = 0;
					this.fadeFlag = true;
                    this.fadeCode = 14;
                    this.E = 46;
                } else {
                    this.optionMenuBase2 = 0;
					this.fadeFlag = true;
                    this.fadeCode = 1;
                    this.E = 46;
                }

                this.j();
            }
            break;
        case 6:
            if ((this.s & 32) == 0 && (this.s & 16) == 0) {
                if ((this.s & 64) != 0 && this.TownmapStageSelFlag) {
                    this.i();
                    this.winCondition[1] = false;
                    this.az[1] = 0;
                    if (this.TownmapDisabledFlag) {
                        this.F = 1;
                    } else if (this.TownmapStageSelFlag) {
                        this.TownmapStageSelFlag = false;
                        this.TownmapSinglePuyoPopEntraceFlag = true;
                        this.optionMenuBase2 = 0;
					    this.fadeFlag = true;
                        this.fadeCode = 14;
                        this.E = 46;
                    } else {
                        this.optionMenuBase2 = 0;
					    this.fadeFlag = true;
                        this.fadeCode = 1;
                        this.E = 46;
                    }
                }
            } else {
                this.i();
                if (this.TownmapStageSelFlag) {
                    this.i();
                    this.F = 2;
                } else {
                    if (this.aw == 0) {
                        if (this.singlePuyoPopBase == 2) {
                            this.optionMenuBase2 = 0;
					        this.fadeFlag = true;
                            this.fadeCode = 23;
                            this.E = 46;
                        } else {
                            this.optionMenuBase2 = 0;
							this.fadeFlag = true;
                            this.fadeCode = 19;
                            this.E = 46;
                            ++this.singlePuyoPopBase;
                        }
                    } else if (this.aw == 1) {
                        if (this.singlePuyoPopBase == 10) {
                            this.optionMenuBase2 = 0;
							this.fadeFlag = true;
                            this.fadeCode = 27;
                            this.E = 46;
                        } else {
                            this.optionMenuBase2 = 0;
							this.fadeFlag = true;
                            this.fadeCode = 19;
                            this.E = 46;
                            ++this.singlePuyoPopBase;
                        }
                    } else if (this.aw == 3) {
                        if (this.singlePuyoPopBase == 18) {
                            this.optionMenuBase2 = 0;
							this.fadeFlag = true;
                            this.fadeCode = 27;
                            this.E = 46;
                        } else {
                            this.optionMenuBase2 = 0;
							this.fadeFlag = true;
                            this.fadeCode = 19;
                            this.E = 46;
                            ++this.singlePuyoPopBase;
                        }
                    }

                    this.winCondition[1] = false;
                    this.az[1] = 0;
                    if (this.aw != 2) {
                        this.bI += this.cd;
                    }
                }
            }
            break;
        case 7:
            if ((this.s & 32) != 0) {
                if (this.sfxType == 1 || this.sfxType == 2) {
					if (this.voiceLangType == 0) {
                        try {
                            ((VolumeControl)this.amtContinueVoice.getControl("VolumeControl")).setLevel(this.b);
                            this.amtContinueVoice.start();
                        } catch (Exception var) {
                            var.printStackTrace();
                        }
					} else if (this.voiceLangType == 1) {
                        try {
                            ((VolumeControl)this.amtContinueVoiceEN.getControl("VolumeControl")).setLevel(this.b);
                            this.amtContinueVoiceEN.start();
                        } catch (Exception var) {
                            var.printStackTrace();
                        }
					}
                }

                this.i();
                if (!this.TownmapStageSelFlag) {
                    ++this.bH;
                }

                this.F = 2;
            } else if ((this.s & 16) != 0) {
                if (this.debugModeFlag) {
                    this.E = 69;
                }
            } else if ((this.s & 64) != 0) {
                if (this.TownmapStageSelFlag) {
                    if (this.TownmapDisabledFlag) {
                        this.F = 1;
                    } else if (this.TownmapStageSelFlag) {
                        this.TownmapStageSelFlag = false;
                        this.TownmapSinglePuyoPopEntraceFlag = true;
                        this.optionMenuBase2 = 0;
						this.fadeFlag = true;
                        this.fadeCode = 14;
                        this.E = 46;
                    } else {
                        this.optionMenuBase2 = 0;
						this.fadeFlag = true;
                        this.fadeCode = 1;
                        this.E = 46;
                    }
                } else {
                    this.i();
                    if (this.aw != 2) {
                        this.bI += this.cd;
                    }

                    this.optionMenuBase2 = 0;
					this.fadeFlag = true;
                    this.fadeCode = 20;
                    this.E = 46;
                }
            }
            break;
        case 8:
            this.optionMenuBase2 += this.C;
            if (this.optionMenuBase2 >= 200) {
                this.setSoftkeyText("次へ", "");
                if (this.aw == 2) {
                    this.F = 11;
                    this.a(1);
                } else {
                    this.F = 9;
                }
            }
        }

        if (this.G == 7 || this.G == 6) {
            this.ah += this.C;
            if (this.ah >= 2000) {
                this.ah = 0;
            }

            this.dF = 0;
            this.dG = 5 * o((this.ah << 8) / 2000) / 127;
            this.dH = (byte)(6 * o((this.ah << 8) / 2000 + 64) / 127);
            this.dI = (byte)(-Math.abs(5 * o((this.ah << 8) / 2000) / 127));
        }

    }

    private void a(int var1) {
        if (this.mainMenu) {
            if (this.h != var1) {
                if (this.bgmPlayer != null) {
                    this.bgmPlayer.close();
                    this.bgmPlayer = null;
                }

                InputStream var2 = Runtime.getRuntime().getClass().getResourceAsStream(this.bgmSound[var1]);

                try {
                    this.bgmPlayer = Manager.createPlayer(var2, "audio/midi");
                } catch (Exception var7) {
                    var7.printStackTrace();
                }

                try {
                    this.bgmPlayer.realize();
                } catch (Exception var6) {
                    var6.printStackTrace();
                }

                if (var1 != 0 && var1 != 10 && var1 != 11) {
                    this.bgmPlayer.setLoopCount(-1);
                }
            }

            try {
                this.bgmPlayer.setMediaTime(0L);
            } catch (Exception var5) {
                var5.printStackTrace();
            }

            ((VolumeControl)this.bgmPlayer.getControl("VolumeControl")).setLevel(this.b);

            try {
                this.bgmPlayer.start();
            } catch (MediaException var4) {
                var4.printStackTrace();
            }

            this.h = var1;
        }

    }

    private void i() {
        try {
            if (this.bgmPlayer != null) {
                this.bgmPlayer.stop();
                return;
            }
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    private void j() {
        if (this.mainMenu && this.h >= 0) {
            this.a(this.h);
        }

    }

    private void k() {
        if (this.ds >= 0) {
            this.ds = -1;
        }

    }

    private void l() {
        this.menu = true;

        for(int var1 = 0; var1 < 9; ++var1) {
            this.puyoGraphics[var1 + 16] = null;
        }

        this.puyoGraphics[7] = null;
        this.puyoFever("main/ttlbg.png", 7);
    }

    private void m() {
        this.menu = true;

        for(int var1 = 0; var1 < 9; ++var1) {
            this.puyoGraphics[var1 + 16] = null;
        }

        if (this.aw == 3) {
            this.puyoGraphics[7] = null;
            this.puyoFever("opening/op_bg_e.png", 7);
        } else if (this.aw == 1) {
            this.puyoGraphics[7] = null;
            this.puyoFever("opening/op_bg_w.png", 7);
        } else if (this.aw == 0) {
            this.puyoGraphics[7] = null;
            this.puyoFever(openingBg[this.puyoMainGUI], 7);
        }
    }

    private void n() {
        this.menu = true;

        for(int var1 = 0; var1 < 9; ++var1) {
            this.puyoGraphics[var1 + 16] = null;
        }

        this.puyoGraphics[7] = null;
        this.puyoFever(endingBg[this.puyoMainGUI], 7);
    }

    private void loadBGColor() {
        a var1 = this;
        if (this.ingameBgColorType == 1) {
            for(int var2 = 0; var2 < puyoMainBgGUI1.length; ++var2) {
                var1.puyoFever(puyoMainBgGUI1[var2] + ".png", var2 + 3);
            }
        } else if (this.ingameBgColorType == 2) {
            for(int var2 = 0; var2 < puyoMainBgGUI2.length; ++var2) {
                var1.puyoFever(puyoMainBgGUI2[var2] + ".png", var2 + 3);
            }
        } else if (this.ingameBgColorType == 3) {
            for(int var2 = 0; var2 < puyoMainBgGUI3.length; ++var2) {
                var1.puyoFever(puyoMainBgGUI3[var2] + ".png", var2 + 3);
            }
        } else if (this.ingameBgColorType == 4) {
            for(int var2 = 0; var2 < puyoMainBgGUI4.length; ++var2) {
                var1.puyoFever(puyoMainBgGUI4[var2] + ".png", var2 + 3);
            }
		}

        if (this.ingameBgColorType == 1) {
            this.puyoFever(puyoMainSptGUI1[this.puyoMainGUI], 10);
        } else if (this.ingameBgColorType == 2) {
            this.puyoFever(puyoMainSptGUI2[this.puyoMainGUI], 10);
        } else if (this.ingameBgColorType == 3) {
            this.puyoFever(puyoMainSptGUI3[this.puyoMainGUI], 10);
        } else if (this.ingameBgColorType == 4) {
            this.puyoFever(puyoMainSptGUI4[this.puyoMainGUI], 10);
        }
    }

    private void o() {
        switch(this.dx) {
        case 0:
            this.e = 0;
            this.repaint();
            this.serviceRepaints();

            this.p();
            this.e = 2;
            this.repaint();
            this.serviceRepaints();
        case 1:
            a var1 = this;
            if (this.ingameBgColorType == 1) {
                for(int var2 = 0; var2 < puyoMainBgGUI1.length; ++var2) {
                    var1.puyoFever(puyoMainBgGUI1[var2] + ".png", var2 + 3);
                }
            } else if (this.ingameBgColorType == 2) {
                for(int var2 = 0; var2 < puyoMainBgGUI2.length; ++var2) {
                    var1.puyoFever(puyoMainBgGUI2[var2] + ".png", var2 + 3);
                }
            } else if (this.ingameBgColorType == 3) {
                for(int var2 = 0; var2 < puyoMainBgGUI3.length; ++var2) {
                    var1.puyoFever(puyoMainBgGUI3[var2] + ".png", var2 + 3);
                }
            } else if (this.ingameBgColorType == 4) {
                for(int var2 = 0; var2 < puyoMainBgGUI4.length; ++var2) {
                    var1.puyoFever(puyoMainBgGUI4[var2] + ".png", var2 + 3);
                }
			}
			
            ++this.dx;
            this.e = 4;
            this.repaint();
            this.serviceRepaints();

            if (!this.dw) {
                if (this.puyoSkinsType == 5) {
                    this.puyoFever("skin/rg_L2_classic.png", 0);
                    this.puyoFever("skin/by_L2_classic.png", 1);
                    this.puyoFever("skin/pj_L2_classic.png", 2);
                } else if (this.puyoSkinsType == 4) {
                    this.puyoFever("skin/rg_L2_gummy.png", 0);
                    this.puyoFever("skin/by_L2_gummy.png", 1);
                    this.puyoFever("skin/pj_L2_gummy.png", 2);
                } else if (this.puyoSkinsType == 3) {
                    this.puyoFever("skin/rg_L2_aqua.png", 0);
                    this.puyoFever("skin/by_L2_aqua.png", 1);
                    this.puyoFever("skin/pj_L2_aqua.png", 2);
                } else if (this.puyoSkinsType == 2) {
                    this.puyoFever("skin/rg_L2_retro.png", 0);
                    this.puyoFever("skin/by_L2_retro.png", 1);
                    this.puyoFever("skin/pj_L2_retro.png", 2);
                } else if (this.puyoSkinsType == 1) {
                    this.puyoFever("skin/rg_L2_fever.png", 0);
                    this.puyoFever("skin/by_L2_fever.png", 1);
                    this.puyoFever("skin/pj_L2_fever.png", 2);
                }

                this.dw = true;
            }

            this.e = 6;
            this.repaint();
            this.serviceRepaints();

            if (!this.loadedFlag) {
                try {
                    this.loadBg = Image.createImage("/load/loadbg.png");
                    this.loadAnim1 = Image.createImage("/load/loadanim1.png");
                    this.loadAnim2 = Image.createImage("/load/loadanim2.png");
                    this.loadAnim3 = Image.createImage("/load/loadanim3.png");
                    this.loadAnim4 = Image.createImage("/load/loadanim4.png");
                    this.loadAnim5 = Image.createImage("/load/loadanim5.png");
                    this.loadAnim6 = Image.createImage("/load/loadanim6.png");
                    this.loadAnim7 = Image.createImage("/load/loadanim7.png");
                    this.loadAnim8 = Image.createImage("/load/loadanim8.png");
                    this.loadAnim9 = Image.createImage("/load/loadanim9.png");
                    this.loadAnim10 = Image.createImage("/load/loadanim10.png");
                    this.loadAnim11 = Image.createImage("/load/loadanim11.png");
                    this.loadAnim12 = Image.createImage("/load/loadanim12.png");
                } catch (Exception var) {
					this.gameError = true;
					this.E = 44;
                }
            }

            this.e = 8;
            this.repaint();
            this.serviceRepaints();

            this.e = 9;
            this.repaint();
            this.serviceRepaints();

            if (this.displayWidth <= 240 && this.displayHeight <= 260) {
                this.E = 45;
			} else if (this.gameError) {
				this.E = 44;
            } else if (this.loadedFlag) {
				if (this.sfxDisabledFlag) {
				    this.E = 58;
				} else {
                    this.E = 57;
				}
            } else {
                this.E = 48;
            }
        default:
            this.e = 9;
        }
    }

    private void p() {
        this.puyoGraphics[11] = null;
        this.puyoGraphics[13] = null;
        this.puyoGraphics[14] = null;
        this.puyoGraphics[10] = null;
        this.puyoGraphics[12] = null;
        this.puyoFever(puyoTtlLogo[this.puyoMainGUI], 11);
        this.puyoFever(menuTextSptGUI1[this.puyoMainGUI], 13);
        this.puyoFever(menuTextSptGUI2[this.puyoMainGUI], 14);
        if (this.ingameBgColorType == 1) {
            this.puyoFever(puyoMainSptGUI1[this.puyoMainGUI], 10);
        } else if (this.ingameBgColorType == 2) {
            this.puyoFever(puyoMainSptGUI2[this.puyoMainGUI], 10);
        } else if (this.ingameBgColorType == 3) {
            this.puyoFever(puyoMainSptGUI3[this.puyoMainGUI], 10);
        } else if (this.ingameBgColorType == 4) {
            this.puyoFever(puyoMainSptGUI4[this.puyoMainGUI], 10);
        }
        this.puyoFever(ingameTextSptGUI[this.puyoMainGUI], 12);
    }

    private void a(byte[] var1, int var2, int var3) {
        var2 = var2 *= 96;
        byte[] var6 = new byte[6];

        int var4;
        for(var4 = 0; var4 < 6; ++var4) {
            this.ex[var4] = var1[var2];
            ++var2;
        }

        var2 += 2;
        var6[0] = 0;

        int var5;
        label62:
        for(var5 = 1; var5 < this.bo[var3] + 1; ++var5) {
            boolean var9 = true;

            while(true) {
                while(true) {
                    if (!var9) {
                        continue label62;
                    }

                    var6[var5] = (byte)(1 + Math.abs(this.D.nextInt()) % this.bo[var3]);
                    var9 = false;

                    for(int var7 = 1; var7 < var5; ++var7) {
                        if (var6[var7] == var6[var5]) {
                            var9 = true;
                            break;
                        }
                    }
                }
            }
        }

        for(var5 = 0; var5 < 84; ++var5) {
            this.be[var3][var5] = 0;
        }

        for(var5 = 0; var5 < 12; ++var5) {
            for(var4 = 0; var4 < 6; ++var4) {
                this.be[var3][var4 + var5 * 6] = var6[var1[var2]];
                ++var2;
            }
        }

        this.bf[var3] = 13;
    }

    private void q() {
        boolean var1 = false;
        if ((this.s & 16) == 0 && (this.s & 32) == 0) {
            if ((this.s & 64) != 0) {
                --this.tutorialBase2;
                if (this.tutorialBase2 < 0) {
                    --this.tutorialBase1;
                    if (this.tutorialBase1 < 0) {
                        if (this.sfxType == 1 || this.sfxType == 2) {
                            try {
                                ((VolumeControl)this.menuBack.getControl("VolumeControl")).setLevel(this.b);
                                this.menuBack.start();
                            } catch (Exception var3) {
                                var3.printStackTrace();
                            }
                        }

                        this.tutorialBase1 = 0;
                        if (this.TownmapDisabledFlag) {
                            this.E = 4;
                            this.menu = true;
                            this.optionMenuBase1 = -1;
                            this.setSoftkeyText("", "戻る");
                            this.l();
                            this.puyoGraphics[7] = null;
                            this.puyoFever("testmap.png", 7);
                        } else {
                            this.setSoftkeyText("", "戻る");
                            this.optionMenuBase2 = 0;
							this.fadeFlag = true;
                            this.fadeCode = 2;
                            this.E = 46;
                        }

                        return;
                    }

                    for(int var2 = this.tutorialString[this.tutorialBase1].length - 1; var2 >= 0; --var2) {
                        if (this.tutorialString[this.tutorialBase1][var2][0] != null) {
                            this.tutorialBase2 = (byte)var2;
                            return;
                        }
                    }
                }
            }
        } else {
            ++this.tutorialBase2;
            if (this.tutorialBase2 > (byte)(this.tutorialString[this.tutorialBase1].length - 1)) {
                var1 = true;
            } else if (this.tutorialString[this.tutorialBase1][this.tutorialBase2][0] == null) {
                var1 = true;
            }

            if (var1) {
                ++this.tutorialBase1;
                if (this.tutorialBase1 < 10) {
                    this.tutorialBase2 = 0;
                    return;
                }

                if (this.sfxType == 1 || this.sfxType == 2) {
                    try {
                        ((VolumeControl)this.menuSelect.getControl("VolumeControl")).setLevel(this.b);
                        this.menuSelect.start();
                    } catch (Exception var4) {
                        var4.printStackTrace();
                    }
                }

                this.tutorialBase1 = 8;
                if (this.TownmapDisabledFlag) {
                    this.E = 4;
                    this.menu = true;
                    this.optionMenuBase1 = -1;
                    this.setSoftkeyText("", "戻る");
                    this.l();
                    this.puyoGraphics[7] = null;
                    this.puyoFever("testmap.png", 7);
                } else {
                    this.setSoftkeyText("", "戻る");
                    this.optionMenuBase2 = 0;
					this.fadeFlag = true;
                    this.fadeCode = 2;
                    this.E = 46;
                }

                return;
            }
        }

    }

    private void a(Graphics var1) {
        String[] var2 = this.tutorialString[this.tutorialBase1][this.tutorialBase2];
        this.c(var1);
        var1.drawImage(this.puyoGraphics[24], this.hDW, this.menuBaseC, 17);
        if (this.tutorialBase1 > 0) {
            boolean var3 = false;
            if (this.tutorialBase1 < 9) {
                var1.drawImage(this.puyoGraphics[16 + this.tutorialBase1 - 1], this.an + 15, this.menuBaseC + 30, 20);
            } else {
                var1.drawImage(this.puyoGraphics[23], this.an + 15, this.menuBaseC + 30, 20);
            }
        }

        var1.setColor(16777215);

        for(int var4 = 0; var4 < var2.length; ++var4) {
            if (var2[var4] != null) {
                var1.drawString(var2[var4], this.av, this.menuBaseC + 140 + var4 * 32, 20);
            }
        }

    }

    public final void run() {
        this.w = new byte[100000];
        this.z = Display.getDisplay(this.et);
        this.ak = Font.getDefaultFont();

        try {
            Thread.sleep(500L);
        } catch (Exception var37) {
        }

        this.displayWidth = this.getWidth();
        this.displayHeight = this.getHeight();
        this.currentDisplayWidth = this.getWidth();
        this.hDW = this.getWidth() >> 1;
        this.hDH = this.getHeight() >> 1;
        this.an = this.hDW - 120;
        this.ao = this.hDW + 120;
        this.menuBaseC = this.hDH - 130;
        this.aq = this.hDH + 130;
        this.at = this.ak.charWidth('a') << 1;
        this.au = this.ak.getHeight();
        this.av = this.hDW - this.at * 9 / 2;
        this.t();
        this.dB = -1;
        this.h = -1;
        this.soundOptionMenu = -1;
        this.aboutOptionMenu = -1;
        this.N = -1;
        this.t = 0;
        a var1 = this;
        this.a = true;
        this.eA = 0L;

        try {
            this.leftSoftkeyLargeImage = Image.createImage("/soft_left_large.png");
            this.leftSoftkeyLargeImageE90 = Image.createImage("/soft_left_large_e90.png");
            this.rightSoftkeyLargeImage = Image.createImage("/soft_right_large.png");
            this.leftSoftkeyImage = Image.createImage("/soft_left.png");
            this.rightSoftkeyImage = Image.createImage("/soft_right.png");
            this.mainBg = Image.createImage("/mainbg.png");
            this.saveIcon = Image.createImage("/saveicon.png");
        } catch (Exception var) {
			this.gameError = true;
        }

        while(true) {
            var1.a();
            if ((var1.s & 64) != 0) {
                if (!this.debugModeFlag) {
                    this.debugModeFlag = false;
                }
            } else if ((var1.s & 32) != 0 || (var1.s & 16) != 0) {
                var1.eA += 2000L;
            } else if ((var1.s & 2) != 0 && (var1.s & 8) != 0) {
                if (!this.sfxDisabledFlag) {
                    this.sfxDisabledFlag = true;
                }
            }

            var1.eA += 100L;
            if (var1.eA > 4000L) {
                var1.a = false;
                this.x = false;
                this.A = this.B = System.currentTimeMillis();

                while(true) {
                    int var2;
                    if (this.F != -1) {
                        var1 = this;
                        this.setSoftkeyText("", "");
                        this.z.vibrate(0);
                        switch(this.F) {
                        case 1:
                            this.f = null;
                            this.g = null;
                            this.splashRGB = (int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])null))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))));
                            System.gc();
                            this.dy = 0;
                            this.optionMenuBase2 = 0;
                            this.menu = false;
                            this.dz = false;
                            this.dA = 0;
                            this.i();
                            this.setSoftkeyText("スタート", "終了");
                            this.l();
                            break;
                        case 2:
                            a var3 = this;
                            this.dt = false;
                            this.ah = 0;
                            this.G = 0;
                            this.Q = false;
                            this.ag = false;
                            this.X = true;
                            this.cX = false;
                            this.cY = false;
                            this.cr[0] = -1;
                            this.bY[1] = false;

                            for(int var4 = 0; var4 < var3.br; ++var4) {
                                var3.az[var4] = 0;
                                var3.aC[var4] = 0;
                                var3.ba[var4] = 1;
                                var3.aL[var4] = 0;
                                if (var3.aw == 2) {
                                    var3.ce[var4] = 3;
                                } else {
                                    var3.ce[var4] = 5;
                                }

                                var3.bB[var4] = 0;
                                var3.cj[var4] = 0;
                                var3.ck[var4] = 0;
                                var3.cl[var4] = 0;
                                var3.cd = 0;
                                var3.dn[var4] = 0;
                                var3.cc[var4] = false;
                                var3.bZ[var4] = false;
                                var2 = var3.an;
                                int var5 = var3.menuBaseC;
                                byte var6;
                                if (var4 == 0) {
                                    var2 += 78;
                                    var5 += 28;
                                    var6 = 10;
                                } else {
                                    var2 += 161;
                                    var5 += 28;
                                    var6 = -10;
                                }

                                var3.aU[var4][0] = var2;
                                var3.aV[var4][0] = var5;
                                var3.aU[var4][1] = var2 + var6;
                                var3.aV[var4][1] = var5 + 20;
                                if (var3.aw != 2) {
                                    var3.bo[var4] = dU[var3.singlePuyoPopBase][var4];
                                    if (var4 == 0) {
                                        var3.a(puyoDropset[var3.bo[0] - 3 + var3.aw * 3] + ".dat", var3.es);
                                    }

                                    var3.bY[var4] = false;
                                    if (var3.aw == 0 && var4 == 0) {
                                        var3.bV[var4] = 3;
                                    } else {
                                        var3.bV[var4] = 0;
                                    }

                                    var3.bX[var4] = 15000;

                                    for(var2 = 0; var2 < 2; ++var2) {
                                        var3.b(var4);
                                    }

                                    var3.m(var4);
                                } else {
                                    var3.bY[var4] = true;
                                    var3.bV[var4] = 7;
                                    var3.bX[var4] = 60000;

                                    for(var2 = 0; var2 < 84; ++var2) {
                                        var3.bb[var4][var2] = 0;
                                    }

                                    var3.singlePuyoPopBase = 1;
                                }

                                for(var2 = 0; var2 < 84; ++var2) {
                                    var3.bm[var4][var2] = 0;
                                }

                                var3.j(var4);
                            }

                            var3.cp = 0;
                            var3.dr = 30;
                            if (var3.aw != 2) {
                                var3.cE[0] = var3.cE[1];
                            }

                            var3.cj[1] = 0;
                            var3.ck[1] = 0;
                            if (var3.aw == 2) {
                                var3.bZ[0] = true;
                            }

                            var3.cX = false;
                            var3.cY = false;
                            break;
                        case 3:
						    if (this.aw == 0) {
                                this.a(12);
							} else if (this.aw == 1) {
                                this.a(2);
							}
							
                            this.setSoftkeyText("次へ", "");
                            this.dl = endingPosition[this.aw][0];
                            if (this.aw == 0) {
                                this.singlePuyoPopManzaiBase = this.runrunEndingString;
                            } else {
                                this.singlePuyoPopManzaiBase = this.wakuwakuEndingString;
                                this.puyoFever(charGUI[11] + ".png", 26);
                            }

                            this.dK = 1;
                            this.s();
                            this.bY[0] = this.bY[1] = false;
                            if (this.sfxType == 1 || this.sfxType == 2) {
                                try {
                                    this.manzaiType = Manager.createPlayer(this.getClass().getResourceAsStream("/se/se19_manzaitype.wav"), "audio/x-wav");
                                    this.manzaiType.realize();
                                    ((VolumeControl)this.manzaiType.getControl("VolumeControl")).setLevel(this.b);
                                    this.manzaiType.start();
                                } catch (Exception var19) {
                                    var19.printStackTrace();
                                }
                            }
                            break;
                        case 4:
                            this.menu = false;
                            this.a(1);
                            if (this.mainMenu) {
                                this.setSoftkeyText("♪ O", "戻る");
                            } else {
                                this.setSoftkeyText("♪ X", "戻る");
                            }

                            this.mainMenuBase = -1;
                            this.puyoGraphics[7] = null;
                            this.puyoFever("testmap.png", 7);
                            break;
                        case 5:
                            this.setSoftkeyText("次へ", "戻る");

                            for(var2 = 0; var2 < 9; ++var2) {
                                var1.puyoGraphics[var2 + 16] = null;
                            }

                            var1.puyoGraphics[7] = null;
                            var1.puyoGraphics[7] = null;

                            for(var2 = 0; var2 < tutorialMenuGUI[var1.puyoMainGUI].length; ++var2) {
                                var1.puyoFever(tutorialMenuGUI[var1.puyoMainGUI][var2] + ".png", var2 + 16);
                            }

                            var1.tutorialBase1 = var1.tutorialBase2 = 0;
                            break;
                        case 6:
                            if (this.R[this.aw]) {
                                this.setSoftkeyText("OK", "戻る");
                            } else {
                                this.setSoftkeyText("", "戻る");
                            }

                            this.aj = 0;
                            break;
                        case 7:
                            this.ds = -1;
                            this.a(2);
                            this.setSoftkeyText("次へ", "");
                            this.m();
                            this.eD = 0;
                            this.eF = 0;
                            this.eC = 0;
                            this.eB = false;
                            if (this.aw == 0) {
                                this.singlePuyoPopManzaiBase = this.runrunOpeningString;
                            } else if (this.aw == 1) {
                                this.singlePuyoPopManzaiBase = this.wakuwakuOpeningString;
                            } else if (this.aw == 3) {
                                this.singlePuyoPopManzaiBase = this.haraharaOpeningString;
                            }

                            this.c();
                            break;
                        case 8:
							if (this.aw == 0) {
                                this.puyoGraphics[3] = null;
                                this.puyoFever("bg/bg1.png", 3);
							} else if (this.aw == 1) {
								if (this.singlePuyoPopBase == 3) {
                                    this.puyoGraphics[3] = null;
                                    this.puyoFever("bg/bg2.png", 3);
								} else if (this.singlePuyoPopBase == 4) {
                                    this.puyoGraphics[3] = null;
                                    this.puyoFever("bg/bg3.png", 3);
								} else if (this.singlePuyoPopBase == 5) {
                                    this.puyoGraphics[3] = null;
                                    this.puyoFever("bg/bg3.png", 3);
								} else if (this.singlePuyoPopBase == 6) {
                                    this.puyoGraphics[3] = null;
                                    this.puyoFever("bg/bg4.png", 3);
								} else if (this.singlePuyoPopBase == 7) {
                                    this.puyoGraphics[3] = null;
                                    this.puyoFever("bg/bg5.png", 3);
								} else if (this.singlePuyoPopBase == 8) {
                                    this.puyoGraphics[3] = null;
                                    this.puyoFever("bg/bg6.png", 3);
								} else if (this.singlePuyoPopBase == 9) {
                                    this.puyoGraphics[3] = null;
                                    this.puyoFever("bg/bg7.png", 3);
								} else if (this.singlePuyoPopBase == 10) {
                                    this.puyoGraphics[3] = null;
                                    this.puyoFever("bg/bg8.png", 3);
								}
							}

                            if (this.aw == 0) {
                                if (this.singlePuyoPopBase == 2) {
                                    this.a(12);
                                } else if (this.singlePuyoPopBase == 1) {
                                    this.a(3);
                                } else if (this.singlePuyoPopBase == 0) {
                                    this.a(3);
                                }
                            } else if (this.aw == 1) {
                                if (this.singlePuyoPopBase == 10) {
                                    this.a(12);
                                } else if (this.singlePuyoPopBase == 9) {
                                    this.a(3);
                                } else if (this.singlePuyoPopBase == 8) {
                                    this.a(12);
                                } else if (this.singlePuyoPopBase == 7) {
                                    this.a(12);
                                } else if (this.singlePuyoPopBase == 6) {
                                    this.a(3);
                                } else if (this.singlePuyoPopBase == 5) {
                                    this.a(3);
                                } else if (this.singlePuyoPopBase == 4) {
                                    this.a(12);
                                } else if (this.singlePuyoPopBase == 3) {
                                    this.a(12);
                                }
                            }

                            this.setSoftkeyText("スタート", "");
                            this.dm = true;
                            this.b();
                            this.bY[0] = false;
                            this.bY[1] = false;

                            if (this.aw == 3) {
                                if (this.singlePuyoPopBase == 11) {
                                    this.puyoFever("char/tp_rfn.png", 25);
                                    this.puyoFever("char/tp_ono.png", 26);
                                } else if (this.singlePuyoPopBase == 12) {
                                    this.puyoFever("char/tp_rfn.png", 25);
                                    this.puyoFever("char/tp_krk.png", 26);
                                } else if (this.singlePuyoPopBase == 13) {
                                    this.puyoFever("char/tp_rfn.png", 25);
                                    this.puyoFever("char/tp_skn.png", 26);
                                } else if (this.singlePuyoPopBase == 14) {
                                    this.puyoFever("char/tp_rfn.png", 25);
                                    this.puyoFever("char/tp_trt.png", 26);
                                } else if (this.singlePuyoPopBase == 15) {
                                    this.puyoFever("char/tp_rfn.png", 25);
                                    this.puyoFever("char/tp_yuc.png", 26);
                                } else if (this.singlePuyoPopBase == 16) {
                                    this.puyoFever("char/tp_rfn.png", 25);
                                    this.puyoFever("char/tp_hhd.png", 26);
                                } else if (this.singlePuyoPopBase == 17) {
                                    this.puyoFever("char/tp_rfn.png", 25);
                                    this.puyoFever("char/tp_akr.png", 26);
                                } else if (this.singlePuyoPopBase == 18) {
                                    this.puyoFever("char/tp_rfn.png", 25);
                                    this.puyoFever("char/tp_ppi.png", 26);
                                } else if (this.singlePuyoPopBase == 19) {
                                    this.puyoFever("char/tp_rfn.png", 25);
                                    this.puyoFever("char/tp_kbc.png", 26);
                                    this.puyoFever("char/tp_akr.png", 27);
                                }
                            }

                            if (this.aw == 0) {
                                this.singlePuyoPopManzaiBase = this.runrunManzaiString[this.singlePuyoPopBase];
                            } else if (this.aw == 1) {
                                this.singlePuyoPopManzaiBase = this.wakuwakuManzaiString[this.singlePuyoPopBase - 3];
                            } else if (this.aw == 3) {
                                this.singlePuyoPopManzaiBase = this.haraharaManzaiString[this.singlePuyoPopBase - 11];
                            }

                            this.dK = 0;
                            this.optionMenuBase2 = 0;
                            break;
                        case 9:
                            this.bP = this.bE[0] + 1;
                            this.bJ = this.bI / 1000;
                            if (this.aw == 0) {
                                this.bL = this.singlePuyoPopBase;
                            } else if (this.aw == 1) {
                                this.bL = (byte)(this.singlePuyoPopBase - 3);
                            } else if (this.aw == 3) {
                                this.bL = (byte)(this.singlePuyoPopBase - 11);
                            }

                            if (this.winCondition[0]) {
                                if (this.bL == 0) {
                                    this.bM = 0;
                                } else {
                                    this.bM = eI[this.singlePuyoPopBase - 1];
                                }
                            } else {
                                ++this.bL;
                                this.bM = eI[this.singlePuyoPopBase];
                            }

                            if (this.aw == 0) {
                                if (this.bJ < 100) {
                                    this.bN = 10000;
                                } else if (this.bJ < 350) {
                                    this.bN = 14000 - this.bJ * 40;
                                } else {
                                    this.bN = 0;
                                }
                            } else if (this.bJ < 200) {
                                this.bN = 100000;
                            } else if (this.bJ < 500) {
                                this.bN = 140000 - this.bJ * 200;
                            } else if (this.bJ < 900) {
                                this.bN = 90000 - this.bJ * 100;
                            } else {
                                this.bN = 0;
                            }

                            if (this.winCondition[0]) {
                                this.bN /= 10;
                            }

                            if (this.bG == 0) {
                                if (this.winCondition[0]) {
                                    this.bO = 0;
                                } else {
                                    this.bO = 24240;
                                }
                            } else if (this.bG <= 4) {
                                this.bO = this.bG * 2500;
                            } else if (this.bG <= 8) {
                                this.bO = this.bG * 5000 - 10000;
                            } else if (this.bG <= 14) {
                                this.bO = this.bG * 10000 - '썐';
                            } else {
                                this.bO = 100000;
                            }

                            if (this.bP == 0) {
                                this.bQ = 0;
                            } else if (this.bP == 1) {
                                if (this.winCondition[0]) {
                                    this.bQ = 0;
                                } else {
                                    this.bQ = 24240;
                                }
                            } else if (this.bP <= 4) {
                                this.bQ = this.bP * 2500;
                            } else if (this.bP <= 8) {
                                this.bQ = this.bP * 5000 - 10000;
                            } else if (this.bP <= 12) {
                                this.bQ = this.bP * 7500 - 30000;
                            } else if (this.bP <= 15) {
                                this.bQ = this.bP * 10000 - '';
                            } else {
                                this.bQ = 100000;
                            }

                            if (this.cb[0] == 0) {
                                this.bR = 0;
                            } else if (this.cb[0] <= 4) {
                                this.bR = this.cb[0] * 2500;
                            } else if (this.cb[0] <= 8) {
                                this.bR = this.cb[0] * 5000 - 10000;
                            } else if (this.cb[0] <= 12) {
                                this.bR = this.cb[0] * 7500 - 30000;
                            } else if (this.cb[0] <= 15) {
                                this.bR = this.cb[0] * 10000 - '';
                            } else {
                                this.bR = 100000;
                            }

                            if (this.bH <= 3) {
                                this.bS = (byte)(100 - this.bH * 20);
                            } else {
                                this.bS = 20;
                            }

                            this.bK = (this.bF + this.bM + this.bN + this.bO + this.bQ + this.bR) * this.bS / 100;
                            this.d();
                            this.u();
                            this.a(1);
                            this.setSoftkeyText("次へ", "");
                            this.puyoGraphics[7] = null;
                            this.puyoFever("main/rankbg.png", 7);
                            break;
                        case 10:
                            this.m();
                            this.cg = -1;
                            this.setSoftkeyText("", "戻る");
                            this.puyoGraphics[7] = null;
                            this.puyoFever("main/rankbg.png", 7);
                            break;
                        case 11:
                            this.setSoftkeyText("次へ", "");
                            this.puyoGraphics[7] = null;
                            this.puyoFever("main/rankbg.png", 7);
                            break;
                        case 12:
                            this.setSoftkeyText("次へ", "");
                            this.n();
                            this.dD = 0;
                            this.optionMenuBase2 = 0;
                            break;
                        case 13:
                            this.dx = 0;
                        case 14:
                        case 18:
                        default:
                            break;
                        case 15:
                            this.H = 0;
                            this.ah = 0;
                            this.setSoftkeyText("", "");
                            break;
                        case 16:
                            this.setSoftkeyText("开始游戏", "");
                            break;
                        case 17:
                            this.N = this.puyoMainGUI;
                            this.menu = false;
                        }

                        var1.E = var1.F;
                        var1.F = -1;
                        var1.X = true;
                    }

                    this.a();
                    this.A = System.currentTimeMillis();
                    this.C = (int)(this.A - this.B);
                    if (this.C < 45) {
                        try {
                            Thread.sleep((long)(45 - this.C));
                        } catch (InterruptedException var18) {
                            var18.printStackTrace();
                        }

                        this.C = 45;
                    }

                    this.B = System.currentTimeMillis();
                    if (this.af) {
                        this.C = 0;
                        this.af = false;
                        if (this.E == 2 && this.G == 4) {
                            this.g();
                        }

                        if (!this.ag) {
                            this.j();
                        }
                    }

                    this.bt += this.C;
                    if (this.bt >= 300) {
                        this.bt = 0;
                        if (this.bs) {
                            this.bs = false;
                        } else {
                            this.bs = true;
                        }
                    }

                    label985:
                    switch(this.E) {
                    case 0:
                        this.F = 13;
                        break;
                    case 1:
                        switch(this.dy) {
                        case 0:
                            this.optionMenuBase2 += this.C;
                            if (this.optionMenuBase2 >= 200) {
                                ++this.dy;
                                this.dJ = false;
                            }
                            break label985;
                        case 1:
                            if (this.mainMenu && !this.dJ) {
                                this.a(0);
                            }

                            if ((this.sfxType == 1 || this.sfxType == 2) && !this.dJ) {
								if (this.voiceLangType == 0) {
                                    try {
                                        ((VolumeControl)this.amtTitleVoice.getControl("VolumeControl")).setLevel(this.b);
                                        this.amtTitleVoice.start();
                                    } catch (Exception var) {
                                        var.printStackTrace();
                                    }
								} else if (this.voiceLangType == 1) {
                                    try {
                                        ((VolumeControl)this.amtTitleVoiceEN.getControl("VolumeControl")).setLevel(this.b);
                                        this.amtTitleVoiceEN.start();
                                    } catch (Exception var) {
                                        var.printStackTrace();
                                    }
								}
                            }

                            if (!this.dJ) {
                                this.dJ = true;
                            }

                            if ((this.s & 16) == 0 && (this.s & 32) == 0) {
                                if ((this.s & 64) != 0) {
                                    if (this.sfxType == 1 || this.sfxType == 2) {
                                        try {
                                            ((VolumeControl)this.menuBack.getControl("VolumeControl")).setLevel(this.b);
                                            this.menuBack.start();
                                        } catch (Exception var16) {
                                            var16.printStackTrace();
                                        }
                                    }

                                    if (this.mainMenu) {
                                        this.i();
                                    }

                                    this.E = 86;
                                }
                            } else {
                                this.dA = 0;
                                this.dz = false;
                                this.i();
                                ++this.dy;
                                this.optionMenuBase2 = 0;
                                if (this.sfxType == 1 || this.sfxType == 2) {
									if (this.voiceLangType == 0) {
                                        try {
                                            ((VolumeControl)this.amtStartVoice.getControl("VolumeControl")).setLevel(this.b);
                                            this.amtStartVoice.start();
                                        } catch (Exception var) {
                                          var.printStackTrace();
                                        }
							  		} else if (this.voiceLangType == 1) {
                                        try {
                                            ((VolumeControl)this.amtStartVoiceEN.getControl("VolumeControl")).setLevel(this.b);
                                            this.amtStartVoiceEN.start();
                                        } catch (Exception var) {
                                          var.printStackTrace();
                                        }
									}
                                }

                                if (this.TownmapDisabledFlag) {
                                    this.dy = 2;
                                    this.optionMenuBase2 = 0;
                                } else {
                                    this.optionMenuBase2 = 0;
									this.fadeFlag = true;
                                    this.fadeCode = 1;
                                    this.E = 46;
                                }
                            }

                            this.dA += this.C;
                            if (this.dA >= 30000) {
                                this.dA = 0;
                                ++this.dB;
                                if (this.dB >= ew.length) {
                                    this.dB = 0;
                                }

                                if (this.TownmapDisabledFlag) {
                                    this.dy = 2;
                                    this.optionMenuBase2 = 0;
                                } else {
                                    this.optionMenuBase2 = 0;
									this.fadeFlag = true;
                                    this.fadeCode = 1;
                                    this.E = 46;
                                }
                            }
                            break label985;
                        case 2:
                            this.optionMenuBase2 += this.C;
                            if (this.optionMenuBase2 >= 200) {
                                this.dA = 0;
                                this.dz = false;
                                if (this.TownmapDisabledFlag) {
                                    this.F = 4;
                                } else {
                                    this.optionMenuBase2 = 0;
									this.fadeFlag = true;
                                    this.fadeCode = 1;
                                    this.E = 46;
                                }
                            }
                            break label985;
                        }
                    case 2:
                        this.h();
                        break;
                    case 3:
                        switch(this.dK) {
                        case 0:
                            this.optionMenuBase2 += this.C;
                            if (this.optionMenuBase2 >= 200) {
                                ++this.dK;
                                this.s();
                                this.dl = endingPosition[this.aw][0];
                            }
                            break label985;
                        case 1:
                            if (!this.a(this.singlePuyoPopManzaiBase) && (this.s & 32) == 0) {
                                this.dl = endingPosition[this.aw][this.eC];
                            } else {
                                if (this.aw == 1) {
                                    this.optionMenuBase2 = 0;
									this.fadeFlag = true;
                                    this.fadeCode = 21;
                                    this.E = 46;
                                } else {
				    				if (!this.RunRunStageSelUnlockedFlag) {
                                        if (this.sfxType == 1 || this.sfxType == 2) {
                                            try {
                                                ((VolumeControl)this.ding.getControl("VolumeControl")).setLevel(this.b);
                                                this.ding.start();
                                            } catch (Exception var) {
                                                var.printStackTrace();
                                            }
                                        }
                                        this.E = 111;
	    							} else {
                                        this.optionMenuBase2 = 0;
										this.fadeFlag = true;
                                        this.fadeCode = 20;
                                        this.E = 46;
					    			}
                                }

                                this.k();
                            }
                        default:
                            break label985;
                        }
                    case 4:
                        if (this.menu) {
                            this.optionMenuBase2 += this.C;
                            if (this.optionMenuBase2 >= 200) {
                                if (this.optionMenuBase1 != -1) {
                                    this.F = this.optionMenuBase1;
                                }

                                this.menu = false;
                                this.optionMenuBase2 = 0;
                            }
                        } else if (this.mainMenuBase == -1) {
                            if ((this.s & 1) != 0) {
                                --this.J;
                                if (this.J < 0) {
                                    this.J = 2;
                                }
                            } else if ((this.s & 4) != 0) {
                                ++this.J;
                                if (this.J >= 3) {
                                    this.J = 0;
                                }
                            } else if ((this.s & 16) == 0) {
                                if ((this.s & 64) != 0) {
                                    this.F = 1;
                                } else if ((this.s & 32) != 0 && this.mainMenu) {
                                    this.setSoftkeyText("♪ X", "戻る");
                                    this.mainMenu = false;
                                    this.u();
                                    this.i();
                                } else if ((this.s & 32) != 0 && !this.mainMenu) {
                                    this.setSoftkeyText("♪ O", "戻る");
                                    this.mainMenu = true;
                                    this.u();
                                    this.a(1);
                                }
                            } else {
                                switch(this.J) {
                                case 0:
                                    this.mainMenuBase = 0;
                                    this.setSoftkeyText("", "戻る");
                                    break label985;
                                case 1:
                                    this.optionMenuBase1 = 2;
                                    this.aw = 2;
                                    this.menu = true;
                                    this.optionMenuBase2 = 0;
                                    this.repaint();
                                    this.serviceRepaints();
                                    this.br = 1;
                                    this.singlePuyoPopBase = 1;
                                    this.dm = true;
                                    this.b();
                                    break label985;
                                case 2:
                                    this.mainMenuBase = 0;
                                    this.setSoftkeyText("", "戻る");
                                }
                            }
                        } else if (this.J == 2) {
                            if (this.soundOptionMenu == -1 && this.aboutOptionMenu == -1 && this.N == -1) {
                                if ((this.s & 1) != 0) {
                                    --this.mainMenuBase;
                                    if (this.mainMenuBase < 0) {
                                        this.mainMenuBase = 4;
                                    }
                                } else if ((this.s & 4) != 0) {
                                    ++this.mainMenuBase;
                                    if (this.mainMenuBase > 4) {
                                        this.mainMenuBase = 0;
                                    }
                                } else if ((this.s & 16) > 0) {
                                    switch(this.mainMenuBase) {
                                    case 0:
                                        this.optionMenuBase1 = 5;
                                        this.menu = true;
                                        this.optionMenuBase2 = 0;
                                        break label985;
                                    case 1:
                                        this.soundOptionMenu = 0;
                                        this.setSoftkeyText("変化", "戻る");
                                        break label985;
                                    case 2:
                                        this.optionMenuBase1 = 10;
                                        this.menu = true;
                                        this.optionMenuBase2 = 0;
                                        break label985;
                                    case 3:
                                        this.aboutOptionMenu = 0;
                                        this.setSoftkeyText("次へ", "戻る");
                                        break label985;
                                    case 4:
                                        if (this.debugModeFlag) {
                                            if (this.mainMenu) {
                                                this.i();
                                            }

                                            this.E = 69;
                                        }
                                    }
                                } else if ((this.s & 64) != 0) {
                                    this.mainMenuBase = -1;
                                    if (this.mainMenu) {
                                        this.setSoftkeyText("♪ O", "戻る");
                                    } else {
                                        this.setSoftkeyText("♪ X", "戻る");
                                    }
                                }
                            } else if (this.soundOptionMenu != -1) {
                                if ((this.s & 1) != 0) {
                                    --this.soundOptionMenu;
                                    if (this.soundOptionMenu < 0) {
                                        this.soundOptionMenu = 1;
                                    }
                                } else if ((this.s & 4) != 0) {
                                    ++this.soundOptionMenu;
                                    if (this.soundOptionMenu > 1) {
                                        this.soundOptionMenu = 0;
                                    }
                                } else if ((this.s & 16) == 0 && (this.s & 32) == 0) {
                                    if ((this.s & 64) != 0) {
                                        this.setSoftkeyText("", "戻る");
                                        this.soundOptionMenu = -1;
                                        this.u();
                                    }
                                } else if (this.soundOptionMenu == 0) {
                                    if (!this.mainMenu) {
                                        this.mainMenu = true;
                                        this.a(1);
                                    } else {
                                        this.mainMenu = false;
                                        this.i();
                                    }
                                } else {
                                    this.i();
                                    switch(this.b) {
                                    case 60:
                                        this.b = 20;
                                        break;
                                    case 100:
                                        this.b = 60;
                                        break;
                                    default:
                                        this.b = 100;
                                    }

                                    this.a(1);
                                }
                            } else if (this.aboutOptionMenu == -1) {
                                if (this.N != -1) {
                                    this.r();
                                    this.menu = false;
                                }
                            } else if ((this.s & 64) != 0) {
                                --this.aboutOptionMenu;
                                if (this.aboutOptionMenu < 0) {
                                    this.aboutOptionMenu = -1;
                                    this.setSoftkeyText("", "戻る");
                                }
                            } else {
                                if ((this.s & 16) == 0 && (this.s & 32) == 0) {
                                    break;
                                }

                                ++this.aboutOptionMenu;
                                if (this.aboutOptionMenu > this.aboutString.length - 1) {
                                    this.aboutOptionMenu = -1;
                                    this.setSoftkeyText("", "戻る");
                                }
                            }
                        } else if (this.J == 0) {
                            if ((this.s & 1) != 0) {
                                --this.mainMenuBase;
                                if (this.mainMenuBase < 0) {
                                    this.mainMenuBase = 1;
                                }
                            } else if ((this.s & 4) != 0) {
                                ++this.mainMenuBase;
                                if (this.mainMenuBase > 1) {
                                    this.mainMenuBase = 0;
                                }
                            } else if ((this.s & 16) != 0) {
                                this.menu = true;
                                this.optionMenuBase2 = 0;
                                this.repaint();
                                this.serviceRepaints();
                                switch(this.mainMenuBase) {
                                case 0:
                                    this.optionMenuBase1 = 7;
                                    this.aw = 0;
                                    this.br = 2;
                                    this.singlePuyoPopBase = 0;
                                    break label985;
                                case 1:
                                    this.optionMenuBase1 = 7;
                                    this.aw = 1;
                                    this.br = 2;
                                    this.singlePuyoPopBase = 3;
                                }
                            } else if ((this.s & 64) != 0) {
                                this.mainMenuBase = -1;
                                if (this.mainMenu) {
                                    this.setSoftkeyText("♪ O", "戻る");
                                } else {
                                    this.setSoftkeyText("♪ X", "戻る");
                                }
                            }
                        }
                        break;
                    case 5:
                        this.q();
                    case 6:
                    case 14:
                    default:
                        break;
                    case 7:
                        String[][] var13 = this.singlePuyoPopManzaiBase;
                        boolean var14 = false;
                        if (!this.eB) {
                            this.eD += this.C;
                            if (this.eD >= 1000) {
                                this.eD = 0;
                                ++this.eF;
                                if (this.eF > var13[this.eC].length - 1) {
                                    this.eB = true;
                                }
                            }
                        }

                        if ((this.s & 16) != 0) {
                            if (!this.eB) {
                                this.eB = true;
                            } else {
                                this.eD = 0;
                                this.eF = 0;
                                ++this.eC;
                                if (this.eC > var13.length - 1) {
                                    var14 = true;
                                } else {
                                    this.eB = false;
                                }
                            }
                        }

                        if (var14 || (this.s & 32) != 0) {
                            this.optionMenuBase2 = 0;
							this.fadeFlag = true;
                            this.fadeCode = 19;
                            this.E = 46;
                        }
                        break;
                    case 8:
                        switch(this.dK) {
                        case 0:
                            this.optionMenuBase2 += this.C;
                            if (this.optionMenuBase2 < 200) {
                                break label985;
                            }

                            ++this.dK;
                            this.s();
                            this.dl = manzaiPosition[this.singlePuyoPopBase][0];
                            if (this.sfxType == 1 || this.sfxType == 2) {
                                try {
                                    this.manzaiType = Manager.createPlayer(this.getClass().getResourceAsStream("/se/se19_manzaitype.wav"), "audio/x-wav");
                                    this.manzaiType.realize();
                                    ((VolumeControl)this.manzaiType.getControl("VolumeControl")).setLevel(this.b);
                                    this.manzaiType.start();
                                } catch (Exception var) {
                                    var.printStackTrace();
                                }
                            }
                            break label985;
                        case 1:
                            if (!this.a(this.singlePuyoPopManzaiBase) && (this.s & 32) == 0) {
                                this.dl = manzaiPosition[this.singlePuyoPopBase][this.eC];
                            } else {
                                if (this.mainMenu) {
                                    this.i();
                                }

                                if (this.sfxType == 1 || this.sfxType == 2) {
                                    try {
                                        ((VolumeControl)this.menuSelect.getControl("VolumeControl")).setLevel(this.b);
                                        this.menuSelect.start();
                                    } catch (Exception var) {
                                        var.printStackTrace();
                                    }
                                }

                                this.F = 2;
                                this.h = -1;
                                this.k();
                            }
                        default:
                            break label985;
                        }
                    case 9:
                        if ((this.s & 16) == 0 && (this.s & 32) == 0) {
                            break;
                        }

                        if (this.sfxType == 1 || this.sfxType == 2) {
                            try {
                                ((VolumeControl)this.menuSelect.getControl("VolumeControl")).setLevel(this.b);
                                this.menuSelect.start();
                            } catch (Exception var12) {
                                var12.printStackTrace();
                            }
                        }

                        this.F = 11;
                        break;
                    case 10:
                        if ((this.s & 2) != 0) {
                            --this.aw;
                            if (this.sfxType == 1 || this.sfxType == 2) {
                                try {
                                    ((VolumeControl)this.menuChoose.getControl("VolumeControl")).setLevel(this.b);
                                    this.menuChoose.start();
                                } catch (Exception var11) {
                                    var11.printStackTrace();
                                }
                            }

                            if (this.aw < 0) {
                                this.aw = 2;
                            }
                        } else if ((this.s & 8) != 0) {
                            ++this.aw;
                            if (this.sfxType == 1 || this.sfxType == 2) {
                                try {
                                    ((VolumeControl)this.menuChoose.getControl("VolumeControl")).setLevel(this.b);
                                    this.menuChoose.start();
                                } catch (Exception var10) {
                                    var10.printStackTrace();
                                }
                            }

                            if (this.aw > 2) {
                                this.aw = 0;
                            }
                        } else {
                            if ((this.s & 64) == 0) {
                                break;
                            }

                            if (this.sfxType == 1 || this.sfxType == 2) {
                                try {
                                    ((VolumeControl)this.menuBack.getControl("VolumeControl")).setLevel(this.b);
                                    this.menuBack.start();
                                } catch (Exception var9) {
                                    var9.printStackTrace();
                                }
                            }

                            this.setSoftkeyText("", "戻る");
                            if (this.TownmapDisabledFlag) {
                                this.E = 4;
                                this.menu = true;
                                this.optionMenuBase1 = -1;
                                this.l();
                                this.puyoGraphics[7] = null;
                                this.puyoFever("testmap.png", 7);
                            } else {
                                this.optionMenuBase2 = 0;
								this.fadeFlag = true;
                                this.fadeCode = 3;
                                this.E = 46;
                            }
                        }
                        break;
                    case 11:
                        if ((this.s & 16) == 0 && (this.s & 32) == 0) {
                            break;
                        }

                        if (this.sfxType == 1 || this.sfxType == 2) {
                            try {
                                ((VolumeControl)this.menuSelect.getControl("VolumeControl")).setLevel(this.b);
                                this.menuSelect.start();
                            } catch (Exception var8) {
                                var8.printStackTrace();
                            }
                        }

                        if (this.TownmapDisabledFlag) {
                            this.F = 1;
                        } else {
                            this.optionMenuBase2 = 0;
							this.fadeFlag = true;
                            this.fadeCode = 1;
                            this.E = 46;
                        }
                        break;
                    case 12:
                        switch(this.dD) {
                        case 0:
                            this.optionMenuBase2 += this.C;
                            if (this.optionMenuBase2 >= 200) {
                                ++this.dD;
                            }
                            break label985;
                        case 1:
                            if ((this.s & 16) != 0 || (this.s & 32) != 0) {
                                ++this.dD;
								if (!this.WakuWakuStageSelUnlockedFlag) {
                                    if (this.sfxType == 1 || this.sfxType == 2) {
                                        try {
                                            ((VolumeControl)this.ding.getControl("VolumeControl")).setLevel(this.b);
                                            this.ding.start();
                                        } catch (Exception var) {
                                            var.printStackTrace();
                                        }
                                    }
                                    this.E = 112;
								} else {
                                    this.optionMenuBase2 = 0;
									this.fadeFlag = true;
                                    this.fadeCode = 22;
                                    this.E = 46;
								}
                            }
                            break label985;
                        case 2:
                            this.optionMenuBase2 += this.C;
                            if (this.optionMenuBase2 >= 200) {
                                this.m();
                                this.F = 9;
                            }
                        default:
                            break label985;
                        }
                    case 13:
                        this.o();
                        --this.r;
                        if (this.r <= 0) {
                            this.r = 0;
                        } else if (this.r == 99) {
                            this.F = 17;
                        }

                        this.u();
                        break;
                    case 15:
                        var1 = this;
                        switch(this.H) {
                        case 0:
                            this.ah += this.C;
                            if (this.ah >= 1000) {
                                ++this.H;
                                this.setSoftkeyText("连接", "終了");
                            }
                            break label985;
                        case 1:
                            if ((this.s & 64) != 0) {
                                this.F = 1;
                            } else if ((this.s & 32) != 0) {
                                try {
                                    var1.et.platformRequest("http://live.vodafone.com/games");
                                } catch (ConnectionNotFoundException var7) {
                                }
                            } else if ((this.s & 16) != 0) {
                                this.et.a();
                            }
                        default:
                            break label985;
                        }
                    case 16:
                        this.F = 1;
                        break;
                    case 17:
                        if (this.r() == -1) {
                            this.FirstBootFlag = true;
                            this.vibSetting = true;	
					        if (this.sfxDisabledFlag) {
                                this.sfxType = 3;
							} else {
                                this.sfxType = 2;
							}
							this.difficultyType = 2;
							this.puyoSkinsType = 3;
							this.voiceLangType = 0;
							this.ingameBgColorType = 1;
							this.loadBGColor();
                            this.puyoFever(puyoMainSptGUI1[this.puyoMainGUI], 10);
                            this.RunRunStageSelUnlockedFlag = false;
							this.WakuWakuStageSelUnlockedFlag = false;
							this.HaraHaraStageSelUnlockedFlag = false;
                            this.dw = false;
                            if (!this.dw) {
                                if (this.puyoSkinsType == 3) {
                                    this.puyoFever("skin/rg_L2_aqua.png", 0);
                                    this.puyoFever("skin/by_L2_aqua.png", 1);
                                    this.puyoFever("skin/pj_L2_aqua.png", 2);
                                }

                                this.dw = true;
                            }

							this.u();
            				if (this.displayWidth <= 240 && this.displayHeight <= 260) {
            				    this.E = 45;
            				} else if (this.gameError) {
            				    this.E = 44;
            				} else if (this.loadedFlag) {
            				    if (this.sfxDisabledFlag) {
            				        this.E = 58;
            				    } else {
            				        this.E = 56;
            				    }
            				} else {
                				this.E = 48;
            				}
                        }
                    }

                    if (this.G != 4) {
                        this.X = true;
                    }

                    if (this.X) {
                        this.Y[0] = true;
                        this.Y[1] = true;
                        this.aa[0] = true;
                        this.aa[1] = true;
                    }

                    for(var2 = 0; var2 < 2; ++var2) {
                        if (this.Y[var2]) {
                            this.Z[var2] = true;
                        }
                    }

                    if (this.F == -1) {
                        this.repaint();
                        this.serviceRepaints();
                    }

                    while(true) {
                        Thread.yield();
                        if (!this.ae) {
                            break;
                        }
                    }
                }
            }

            try {
                Thread.sleep(50L);
            } catch (InterruptedException var21) {
                var21.printStackTrace();
            }

            var1.repaint();
            var1.serviceRepaints();
        }
    }

    private void b(Graphics var1) {
        this.c(var1);
        if (this.puyoGraphics[7] != null) {
            var1.drawImage(this.mainBg, this.hDW, this.hDH, 3);
            var1.drawImage(this.puyoGraphics[7], this.hDW, this.hDH, 3);
        }

    }

    private void c(Graphics var1) {
        var1.setColor(0);
        var1.fillRect(0, 0, this.displayWidth, this.displayHeight);
        var1.drawImage(this.mainBg, this.hDW, this.hDH, 3);
    }

    private static void a(Graphics var0, int var1, int var2, int var3, int var4, int var5) {
        var3 -= var1;
        var4 -= var2;
        var0.setColor(dM[var5][0]);
        var0.fillRoundRect(var1, var2, var3, var4, 24, 24);
        var0.setColor(dM[var5][1]);
        var0.fillRoundRect(var1 + 2, var2 + 2, var3 - 4, var4 - 4, 31, 31);
    }

    private int r() {
        this.puyoMainGUI = this.N = 0;
        this.u();
        this.menu = true;
        this.repaint();
        this.serviceRepaints();
        this.p();
        this.N = -1;
        return this.N;
    }

    private void s() {
        this.eD = 0;
        this.eE = 0;
        this.eF = 0;
        this.eC = 0;
        this.eB = false;
    }

    private boolean a(String[][] var1) {
        boolean var2 = false;
        boolean var3 = false;
        if (!this.eB) {
            this.eD += this.C;
            if (this.eD >= 30) {
                this.eD = 0;
                ++this.eE;
                if (var1[this.eC][this.eF] == null) {
                    var3 = true;
                } else if (this.eE > var1[this.eC][this.eF].length() - 1) {
                    var3 = true;
                }

                if (var3) {
                    this.eE = 0;
                    ++this.eF;
                    if (this.eF > var1[this.eC].length - 1) {
                        if (this.sfxType == 1 || this.sfxType == 2) {
                            try {
                                this.manzaiType.stop();
                            } catch (Exception var7) {
                                var7.printStackTrace();
                            }
                        }

                        this.eB = true;
                        this.k();
                    }
                }
            }
        }

        if ((this.s & 16) != 0) {
            if (!this.eB) {
                if (this.sfxType == 1 || this.sfxType == 2) {
                    try {
                        this.manzaiType.stop();
                    } catch (Exception var6) {
                        var6.printStackTrace();
                    }
                }

                this.eB = true;
                this.k();
            } else {
                this.eD = 0;
                this.eE = 0;
                this.eF = 0;
                ++this.eC;
                var3 = false;
                if (this.eC > var1.length - 1) {
                    var3 = true;
                } else if (var1[this.eC][0] == null) {
                    var3 = true;
                }

                if (var3) {
                    var2 = true;
                    this.k();
                } else {
                    if (this.sfxType == 1 || this.sfxType == 2) {
                        try {
                            this.manzaiType = Manager.createPlayer(this.getClass().getResourceAsStream("/se/se19_manzaitype.wav"), "audio/x-wav");
                            this.manzaiType.realize();
                            ((VolumeControl)this.manzaiType.getControl("VolumeControl")).setLevel(this.b);
                            this.manzaiType.start();
                        } catch (Exception var5) {
                            var5.printStackTrace();
                        }
                    }

                    this.eB = false;
                }
            }
        }

        return var2;
    }

    private void d(Graphics var1) {
        this.X = true;
        this.Y[0] = true;
        this.Y[1] = true;
        this.aa[0] = true;
        this.aa[1] = true;
        switch(this.dK) {
        case 0:
            this.c(var1);
            return;
        case 1:
            this.f(var1);
            this.a(var1, 0);
            this.a(var1, 1);
            var1.drawImage(this.puyoGraphics[25], this.an, this.menuBaseC + 8, 20);
            byte var2;
            switch(this.dl) {
            case 0:
            default:
                if (this.aw == 0) {
                    if (this.singlePuyoPopBase == 2) {
                        var2 = 26;
                    } else {
                        var2 = 27;
                    }
                    break;
                } else if (this.E != 3) {
                    var2 = 26;
                    break;
                }
            case 2:
                var2 = 27;
                break;
            case 1:
                var2 = 26;
            }

            var1.drawImage(this.puyoGraphics[var2], this.ao, this.menuBaseC + 8, 24);
            int var3 = this.menuBaseC + 65;
            a(var1, this.an, var3, this.an + 240, this.menuBaseC + 180, 2);
            int var10;
            if (this.dl == 0) {
                var10 = this.an + 44 - 8;
                var1.setColor(0);
            } else {
                var10 = this.an + 183;
                var1.setColor(17286);
            }

            int var6 = this.menuBaseC + 53;
            var1.drawRegion(this.puyoGraphics[10], 93, 96, 13, 14, 0, var10, var6, 20);
            boolean var7 = true;
            String[][] var5 = this.singlePuyoPopManzaiBase;
            Graphics var4 = var1;
            a var11 = this;
            int var8 = (111 - 3 * this.au) / 4;
            int var9 = var3 + 2 + var8;
            if (this.eB) {
                this.eF = var5[this.eC].length;
            } else if (var5[this.eC][this.eF] != null) {
                var1.drawSubstring(var5[this.eC][this.eF], 0, this.eE, this.av, var9 + (var8 + this.au) * this.eF, 20);
            }

            for(var3 = 0; var3 < var11.eF; ++var3) {
                if (var5[var11.eC][var3] != null) {
                    var4.drawString(var5[var11.eC][var3], var11.av, var9 + (var8 + var11.au) * var3, 20);
                }
            }
        default:
        }
    }

    private void e(Graphics var1) {
        var1.drawRegion(this.puyoGraphics[5], 91, 0, 57, 29, 0, this.an + 91, this.menuBaseC, 20);
    }

    private void f(Graphics var1) {
        if (this.X) {
			if (this.ingameBgColorType == 1) {
                var1.setColor(16639461);
                var1.fillRect(0, 0, this.displayWidth, this.displayHeight);
			} else if (this.ingameBgColorType == 2) {
                var1.setColor(14741995);
                var1.fillRect(0, 0, this.displayWidth, this.displayHeight);
			} else if (this.ingameBgColorType == 3) {
                var1.setColor(16508866);
                var1.fillRect(0, 0, this.displayWidth, this.displayHeight);
			} else if (this.ingameBgColorType == 4) {
                var1.setColor(16777128);
                var1.fillRect(0, 0, this.displayWidth, this.displayHeight);
			}
			
			var1.drawImage(this.mainBg, this.hDW, this.hDH, 3);
        }

        int var2;
        for(var2 = 0; var2 < 2; ++var2) {
            if (this.aa[var2]) {
                if (this.ingameBgColorType == 1) {
                    var1.setColor(11622577);
                } else if (this.ingameBgColorType == 2) {
                    var1.setColor(4153515);
                } else if (this.ingameBgColorType == 3) {
                    var1.setColor(12276558);
                } else if (this.ingameBgColorType == 4) {
                    var1.setColor(10053124);
                }
                var1.fillRect(this.an + var2 * 120, this.menuBaseC + 8, 120, 65);
            }
        }

        int var3;
        for(var2 = 0; var2 < 2; ++var2) {
            if (this.Y[var2]) {
                var3 = this.an + dO[var2];
                if (this.bY[var2]) {
                    var1.setColor(0);
                    var1.fillRect(var3 - 1, this.menuBaseC + 83, 99, 168);
                    boolean var5 = false;
                    var1.drawImage(this.puyoGraphics[4], var3, this.menuBaseC + 83 + 28, 20);
                } else {
                    byte var4;
                    if (var2 != 0 && this.aw == 2) {
                        var4 = 8;
                    } else {
                        var4 = 3;
                    }

                    var1.drawImage(this.puyoGraphics[var4], var3 - 1, this.menuBaseC + 83, 20);
                }
            }
        }

        this.e(var1);
        var3 = this.aq - 30 + 17;
        var2 = this.hDW;
        var1.drawRegion(this.puyoGraphics[10], 202, 134, 33, 50, 0, var2, var3, 33);
    }

    private void a(Graphics var1, int var2) {
        var1.drawRegion(this.puyoGraphics[5], var2 * 120, 0, 120, 83, 0, this.an + var2 * 120, this.menuBaseC, 20);
        this.b(var1, var2);
    }

    private void a(Graphics var1, int var2, int var3) {
        var1.drawRegion(this.puyoGraphics[12], 84, 107, 10, 11, 0, var2, var3, 20);
    }

    private void b(Graphics var1, int var2, int var3) {
        var1.drawRegion(this.puyoGraphics[12], 92, 82, 8, 14, 0, var2, var3, 20);
    }

    private void c(Graphics var1, int var2, int var3) {
        var1.drawRegion(this.puyoGraphics[12], 84, 82, 8, 14, 0, var2, var3, 20);
    }

    private void a(Graphics var1, int var2, int var3, int var4) {
        int var5 = var2 - 21;
        this.d(var1, var5, var3, var4 / 60);
        this.c(var1, var5, var3);
        this.a(var1, var2, var3, var4 % 60, 2);
    }

    private void d(Graphics var1, int var2, int var3) {
        var1.drawRegion(this.puyoGraphics[13], 0, 48, 112, 24, 0, var2, var3, 17);
    }

    private void e(Graphics var1, int var2, int var3) {
        var1.drawRegion(this.puyoGraphics[13], 0, 72, 112, 24, 0, var2, var3, 17);
    }

    private void b(Graphics var1, int var2, int var3, int var4) {
        var1.drawRegion(this.puyoGraphics[14], 4, 0 + var4 * 24, 76, 24, 0, var2, var3, 17);
    }

    private void f(Graphics var1, int var2, int var3) {
        var1.drawRegion(this.puyoGraphics[12], 0, 42, 84, 14, 0, var2, var3, 20);
    }

    private void g(Graphics var1, int var2, int var3) {
        var1.drawRegion(this.puyoGraphics[12], 0, 56, 84, 14, 0, var2, var3, 20);
    }

    private void h(Graphics var1, int var2, int var3) {
        var1.drawRegion(this.puyoGraphics[12], 0, 84, 84, 14, 0, var2, var3, 20);
    }

    private void i(Graphics var1, int var2, int var3) {
        var1.drawRegion(this.puyoGraphics[12], 84, 26, 44, 14, 0, var2, var3, 20);
    }

    private void j(Graphics var1, int var2, int var3) {
        var1.drawRegion(this.puyoGraphics[12], 84, 13, 44, 13, 0, var2, var3, 20);
    }

    private void k(Graphics var1, int var2, int var3) {
        var1.drawRegion(this.puyoGraphics[12], 84, 0, 44, 13, 0, var2, var3, 20);
    }

    private void l(Graphics var1, int var2, int var3) {
        var1.drawRegion(this.puyoGraphics[12], 0, 70, 84, 14, 0, var2, var3, 20);
    }

    private void m(Graphics var1, int var2, int var3) {
        var1.drawRegion(this.puyoGraphics[10], 205, 0, 80, 54, 0, var2, var3, 6);
    }

    private void n(Graphics var1, int var2, int var3) {
        var1.drawRegion(this.puyoGraphics[10], 125, 54, 80, 80, 0, var2, var3, 6);
    }

    private void o(Graphics var1, int var2, int var3) {
        var1.drawRegion(this.puyoGraphics[10], 0, 115, 107, 18, 0, var2, var3, 20);
    }

    private void p(Graphics var1, int var2, int var3) {
        var1.drawRegion(this.puyoGraphics[10], 0, 182, 114, 30, 0, var2, var3, 17);
    }

    private void q(Graphics var1, int var2, int var3) {
        var1.drawRegion(this.puyoGraphics[10], 0, 152, 114, 30, 0, var2, var3, 17);
    }

    private void c(Graphics var1, int var2, int var3, int var4) {
        var1.drawRegion(this.puyoGraphics[12], 84 + (var4 % 5 << 3), 54 + var4 / 5 * 14, 8, 14, 0, var2, var3, 20);
    }

    private void d(Graphics var1, int var2, int var3, int var4) {
        int var5 = var4;
        int var6 = 0;

        int var7;
        for(var7 = 1; var5 >= 10; ++var7) {
            var5 /= 10;
        }

        var5 = var4;

        for(int var8 = 0; var8 < var7; ++var8) {
            var4 = var5 % 10;
            var6 += 7;
            this.c(var1, var2 - var6, var3, var4);
            if (var5 > 0) {
                var5 /= 10;
            }
        }

    }

    private void a(Graphics var1, int var2, int var3, int var4, int var5) {
        var4 = var4;
        int var6 = 0;

        for(int var7 = 0; var7 < var5; ++var7) {
            var6 += 7;
            this.c(var1, var2 - var6, var3, var4 % 10);
            if (var4 > 0) {
                var4 /= 10;
            }
        }

    }

    public final void paint(Graphics var1) {
        byte j = 1;

        try {
            if (this.a) {
                var1.setColor(16777215);
                var1.fillRect(0, 0, this.displayWidth, this.displayHeight);

                int i = (int)(this.eA % 2000L);
                if (i > 1000) {
                    i = 2000 - i;
                }

                int alpha;
                if (i <= 500) {
                    alpha = 255 * i / 500 << 24;
                } else {
                    alpha = -16777216;
                }

                if (this.eA < 2000L) {
                    j = 1;
                } else if (this.eA < 4000L) {
                    j = 0;
                }

                for(i = 0; i < this.splashRGB[j].length; ++i) {
                    int[] var46 = this.splashRGB[j];
                    var46[i] &= 16777215;
                    var46 = this.splashRGB[j];
                    var46[i] |= alpha;
                }

                var1.drawRGB(this.splashRGB[j], 0, this.splashRGBw[j], this.hDW - this.splashRGBw[j] / 2, this.hDH - this.splashRGBh[j] / 2, this.splashRGBw[j], this.splashRGBh[j], true);
				if (this.sfxDisabledFlag) {
            	    var1.setColor(14638686);
                    var1.drawString("[！] SE無効", this.hDW - 100, this.hDH - 115, 20);
				}
                return;
            }

            if (this.af) {
                return;
            }

            a var2;
            Graphics var3;
            int var4;
            int var6;
            int var7;
            int var8;
            int var9;
            boolean var10;
            int var11;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            byte var21;
            int var24;
            byte var25;
            int var33;
            boolean var28;
            Graphics var30;
            a var44;
            Graphics var46;
            boolean var42;
            label4905:
            switch(this.E) {
            case 1:
                switch(this.dy) {
                case 0:
                case 2:
                    this.c(var1);
                    break label4905;
                case 1:
                    this.b(var1);
                    if (this.puyoGraphics[11] != null) {
                        var1.drawImage(this.puyoGraphics[11], this.hDW, this.menuBaseC + 10, 17);
                    }

                    short var41 = 188;
                    if (this.bs) {
                        var1.drawRegion(this.puyoGraphics[13], 0, 99, 160, 21, 0, this.hDW, this.menuBaseC + var41, 17);
                    }

                    var7 = this.menuBaseC + 238;
                    var6 = this.hDW;
                    var1.drawRegion(this.puyoGraphics[14], 0, 126, 128, 18, 0, var6, var7, 17);
                default:
                    break label4905;
                }
            case 2:
                var3 = var1;
                var2 = this;
                if (this.G == 8) {
                    this.c(var1);
                } else {
                    this.f(var1);
                    var8 = this.bX[0] / 10 % 100;
                    var9 = this.bX[0] / 1000;

                    for(var4 = 0; var4 < var2.br; ++var4) {
                        var28 = false;
                        boolean var34 = false;
                        if (var2.Y[var4] || var2.bW[var4] != var2.bV[var4]) {
                            var2.c(var3, var4);
                        }

                        if (!var2.ag && var2.G >= 2) {
                            if (var2.az[var4] == 3 && var2.Z[var4]) {
                                if (!var2.Y[var4]) {
                                    var7 = var4;
                                    var30 = var3;
                                    var44 = var2;
                                    var11 = 0;

                                    label5053:
                                    while(true) {
                                        if (var11 >= 3) {
                                            var7 = var4;
                                            var30 = var3;
                                            var44 = var2;

                                            for(var12 = 0; var12 < 6; ++var12) {
                                                for(var13 = 0; var13 < 14; ++var13) {
                                                    var11 = var12 + var13 * 6;
                                                    if (var44.bq[var7][var11]) {
                                                        var44.g(var30, var7, var12, var13);
                                                    }
                                                }
                                            }

                                            var7 = var4;
                                            var30 = var3;
                                            var44 = var2;
                                            var13 = 0;

                                            while(true) {
                                                if (var13 >= 6) {
                                                    break label5053;
                                                }

                                                for(var14 = 2; var14 < 14; ++var14) {
                                                    var11 = var13 + var14 * 6;
                                                    if ((var12 = var44.bp[var7][var11]) != 0) {
                                                        var44.b(var30, var12, 0, var44.an + dO[var7] + (var13 << 4) + 8, var44.menuBaseC + 55 + var14 * 14 + 7);
                                                    }
                                                }

                                                ++var13;
                                            }
                                        }

                                        for(var12 = 0; var12 < 3; ++var12) {
                                            if (var44.aO[var7][var11 + var12 * 3] != 0) {
                                                var44.g(var30, var7, var44.aW[var7] - 1 + var11, var44.aX[var7] - 1 + var12);
                                            }
                                        }

                                        ++var11;
                                    }
                                }

                                if (var2.aT[var4] >= var2.menuBaseC + 55 + 14) {
                                    var2.a(var3, var2.aJ[var4], var2.aM[var4], var2.aS[var4], var2.aT[var4], var2.aP[var4]);
                                }

                                if (var2.aZ[var4] <= 2) {
                                    var2.b(var3, var4);
                                }
                            }

                            if (var2.Y[var4] || var2.ac[var4] || var2.ad[var4]) {
                                var17 = var4;
                                var46 = var3;
                                var44 = var2;
                                Graphics var43 = var3;

                                for(var14 = 0; var14 < 6; ++var14) {
                                    if (var44.ac[var17] && var44.bn[var17][var14] == 1) {
                                        var33 = var14;
                                        var7 = var17;
                                        var30 = var43;
                                        a var38 = var44;

                                        for(var11 = 0; var11 < 14; ++var11) {
                                            if (var38.bb[var7][var33 + var11 * 6] != 0) {
                                                var38.g(var30, var7, var33, var11);
                                            }
                                        }
                                    }

                                    for(var24 = 2; var24 < 14; ++var24) {
                                        var33 = var14 + var24 * 6;
                                        byte var35 = var44.bb[var17][var33];
                                        if (var44.ad[var17] && (var44.bc[var17][var33] != var44.bb[var17][var33] || var44.bl[var17][var33] != var44.bk[var17][var33])) {
                                            var44.g(var43, var17, var14, var24);
                                        }

                                        if (var35 != 0) {
                                            var42 = true;
                                            byte var18 = var44.bk[var17][var33];
                                            boolean var48;
                                            if ((var44.az[var17] == 5 || var44.az[var17] == 11 || var44.az[var17] == 18) && var44.bn[var17][var14] == 1) {
                                                if (var17 == 0) {
                                                    var33 = o((var44.aC[var17] << 7) / 200);
                                                    var11 = 512 - var33 * 512 / 3 / 127;
                                                    var11 = var11 * 14 / 512;
                                                    var7 = 196 - (13 - var24) * var11 - (var11 >> 1);
                                                } else {
                                                    var48 = false;
                                                    var7 = var24 * 14 + 7;
                                                }
                                            } else if (var44.az[var17] == 6 && var44.bg[var17][var33] == 1) {
                                                var18 = 23;
                                                var48 = false;
                                                var7 = var24 * 14 + 7;
                                            } else if (var44.az[var17] == 7 && var44.bg[var17][var33] == 1) {
                                                var48 = false;
                                                var7 = var24 * 14 + 7;
                                                var18 = 24;
                                                if (var17 == 1) {
                                                    var44.g(var43, var17, var14, var24);
                                                }
                                            } else if (var44.az[var17] != 9 && var44.az[var17] != 21) {
                                                var48 = false;
                                                var7 = var24 * 14 + 7;
                                                if (var44.ad[var17] && var44.bc[var17][var33] == var44.bb[var17][var33] && var44.bl[var17][var33] == var44.bk[var17][var33]) {
                                                    var42 = false;
                                                }
                                            } else {
                                                var48 = false;
                                                var7 = var24 * 14 + 7 + var44.aC[var17] * 14 * 14 / 1000;
                                            }

                                            if (var42 || var44.Y[var17]) {
                                                var33 = var44.an + dO[var17] + (var14 << 4) + 8;
                                                var11 = var44.menuBaseC + 55 + var7;
                                                if (var7 <= 196) {
                                                    var44.b(var46, var35, var18, var33, var11);
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                            if (var2.aa[var4]) {
                                var17 = var4;
                                var46 = var3;
                                var44 = var2;

                                for(var24 = 1; var24 >= 0; --var24) {
                                    byte var45;
                                    if ((var45 = var44.aK[var17][var24]) == 0) {
                                        var25 = 24;
                                    } else {
                                        var25 = 32;
                                    }

                                    var44.a(var46, var45, 0, var44.aU[var17][var24] - var25, var44.aV[var17][var24] - 14, var44.aR[var17][var24]);
                                }
                            }
                        }

                        if (var2.aa[var4]) {
                            var2.a(var3, var4);
                            if (var4 == 0) {
                                var3.drawImage(var2.puyoGraphics[25], var2.an, var2.menuBaseC + 8, 20);
                            } else {
                                var3.drawImage(var2.puyoGraphics[26], var2.ao, var2.menuBaseC + 8, 24);
                            }
                        }

                        if (var2.ab[var4]) {
                            var2.b(var3, var4);
                        }

                        if (var2.Y[var4] || var2.ac[var4]) {
                            var7 = var2.menuBaseC + 251;
							if (this.ingameBgColorType == 1) {
                                var3.setColor(16639461);
							} else if (this.ingameBgColorType == 2) {
                                var3.setColor(14741995);
							} else if (this.ingameBgColorType == 3) {
                                var3.setColor(16508866);
							} else if (this.ingameBgColorType == 4) {
							    var3.setColor(16777128);
							}
                            var3.fillRect(var2.an + var4 * 120, var7, 120, 16);
                        }
                    }

                    if (var2.br == 1 && var2.X) {
                        var2.a(var3, 1);
                        var2.c(var3, 1);
                    }

                    var2.e(var3);
                    var2.a(var3, var2.an + 147, var2.menuBaseC + 10, var2.bF + var2.bB[0], 8);
                    if (var2.aw == 2 && var2.G >= 2) {
                        var6 = var2.an + 100;
                        var7 = var2.menuBaseC + 30;
                        if (this.ingameBgColorType == 1) {
                            var3.setColor(16639461);
                        } else if (this.ingameBgColorType == 2) {
                            var3.setColor(14741995);
                        } else if (this.ingameBgColorType == 3) {
                            var3.setColor(16508866);
						} else if (this.ingameBgColorType == 4) {
							var3.setColor(16777128);
                        }
                        var3.fillRect(var6, var7, 34, 16);
                        var2.k(var3, var6, var7);
                        var2.a(var3, var2.an + 140, var7, var2.singlePuyoPopBase, 2);
                    }

                    var6 = var2.an + 117;
                    var7 = var2.menuBaseC + 215;
                    var24 = var2.menuBaseC + 185 + 17;
                    var17 = var2.hDW;
                    var3.drawRegion(var2.puyoGraphics[12], 84, 96, 20, 11, 0, var17, var24, 17);
                    var2.a(var3, var6 + 1, var7, var9, 2);
                    var2.c(var3, var6, var7);
                    var2.a(var3, var6 + 19, var7, var8, 2);
                    var24 = var7 + 17;
                    var17 = var2.hDW;
                    var3.drawRegion(var2.puyoGraphics[12], 104, 96, 16, 16, 0, var17, var24 - 2, 17);

                    int var10002;
                    for(var4 = 0; var4 < var2.br; ++var4) {
                        if (var2.G == 4) {
                            if (var2.bY[var4] && (var2.az[var4] == 20 || var2.az[var4] == 17) && var2.bZ[var4]) {
                                var10002 = var2.an + 9 + dO[var4];
                                var24 = var2.menuBaseC + 83 + 10;
                                var3.drawRegion(var2.puyoGraphics[10], 0, 0, 80, 28, 0, var10002, var24, 20);
                            }

                            if (!var2.bY[var4] && (var2.az[var4] == 20 || var2.az[var4] == 17) || var2.bY[var4] && var2.az[var4] == 21) {
                                if (var2.cc[var4]) {
                                    var10002 = var2.an + 5 + dO[var4];
                                    var24 = var2.menuBaseC + 83 + 10;
                                    var3.drawRegion(var2.puyoGraphics[10], 125, 0, 80, 54, 0, var10002, var24, 20);
                                }

                                if (var4 == 0 && var2.bY[0] && var2.dt) {
                                    var10002 = var2.an + 30;
                                    var24 = var2.menuBaseC + 133;
                                    var3.drawRegion(var2.puyoGraphics[10], 152, 134, 50, 94, 0, var10002, var24, 20);
                                }
                            }

                            if (var4 == 0 && var2.az[var4] == 7) {
                                var7 = 0;
                                var6 = 0;

                                for(var14 = 0; var14 < var2.dq[var4]; ++var14) {
                                    if ((var33 = var2.uwu[var4][var14] + 1) > 4) {
                                        var33 = 4;
                                    }

                                    if ((var11 = var2.dp[var4][var14] + 1) < 2) {
                                        var11 = 2;
                                    }

                                    if (var11 > 12) {
                                        var11 = 12;
                                    }

                                    var6 += var2.uwu[var4][var14];
                                    var7 += var2.dp[var4][var14];
                                    if (var2.aC[var4] < 66) {
                                        var21 = 0;
                                    } else if (var2.aC[var4] < 133) {
                                        var21 = 1;
                                    } else {
                                        var21 = 2;
                                    }

                                    var10002 = var2.an + dO[var4] + (var33 << 4);
                                    var24 = var2.menuBaseC + 55 + var11 * 14;
                                    var3.drawRegion(var2.puyoGraphics[10], 93, var21 * 32, 32, 32, 0, var10002, var24, 20);
                                }

                                var6 /= var2.dq[var4];
                                var7 /= var2.dq[var4];
                                if ((var33 = var6 + 1) < 2) {
                                    var33 = 2;
                                }

                                if (var33 > 4) {
                                    var33 = 4;
                                }

                                if ((var11 = var7 - 3) < 2) {
                                    var11 = 2;
                                }

                                var12 = var2.an + dO[var4] + (var33 << 4) - 3;
                                var13 = var2.menuBaseC + 55 + var11 * 14;
                                var2.d(var3, var12, var13, var2.bu[var4] + 1);
                                var2.j(var3, var12, var13);
                            }
                        }
                    }

                    switch(var2.G) {
                    case 1:
                        var10002 = var2.an + 10;
                        var24 = var2.menuBaseC + 100;
                        var3.drawRegion(var2.puyoGraphics[10], 235, 126, 48, 128, 0, var10002, var24, 20);
                        var10002 = var2.an + 60;
                        var24 = var2.menuBaseC + 110 + var2.singlePuyoPopBase * 45;
                        var3.drawRegion(var2.puyoGraphics[10], 152, 228, 34, 22, 0, var10002, var24, 20);
                        break label4905;
                    case 2:
                        var4 = 0;

                        while(true) {
                            if (var4 >= var2.br) {
                                break label4905;
                            }

                            var10002 = var2.an + 9 + dO[var4];
                            var24 = var2.hDH + 30;
                            var3.drawRegion(var2.puyoGraphics[10], 0, 28, 80, 28, 0, var10002, var24, 20);
                            ++var4;
                        }
                    case 3:
                        for(var4 = 0; var4 < var2.br; ++var4) {
                            var10002 = var2.an + 5 + dO[var4];
                            var24 = var2.hDH + 30;
                            var3.drawRegion(var2.puyoGraphics[10], 0, 87, 85, 28, 0, var10002, var24, 20);
                        }
                    case 4:
                    default:
                        break label4905;
                    case 5:
                        var24 = var2.hDH + 30;
                        var17 = var2.hDW;
                        var3.drawRegion(var2.puyoGraphics[10], 0, 56, 92, 31, 0, var17, var24, 3);
                        break label4905;
                    case 6:
                        var2.m(var3, var2.an + 8 + dO[0] + var2.dH, var2.hDH + 30 + var2.dI);
                        if (var2.br == 2) {
                            var2.n(var3, var2.an + 8 + dO[1], var2.hDH + 30 + 4 + var2.dG);
                        }
                        break label4905;
                    case 7:
                        var10002 = var2.an + 20;
                        var24 = var2.menuBaseC + 165;
                        var3.drawRegion(var2.puyoGraphics[10], 212, 61, 63, 64, 0, var10002, var24, 20);
                        var2.n(var3, var2.an + 8 + dO[0], var2.hDH + var2.dG);
                        if (var2.br == 2) {
                            var2.m(var3, var2.an + 8 + dO[1] + var2.dH, var2.hDH + 30 + var2.dI);
                        } else {
                            var17 = var2.an + 137;
                            var24 = var2.menuBaseC + 85;
                            var6 = (var33 = var2.an + 225) - 50;
                            var3.drawRegion(var2.puyoGraphics[12], 0, 98, 84, 14, 0, var17, var24, 20);
                            var24 += 15;
                            var7 = var24 + 1;
                            var2.d(var3, var33, var24, var2.bF);
                            var2.a(var3, var33, var7);
                            var24 += 15;
                            var7 = var24 + 1;
                            var2.k(var3, var17, var24);
                            var2.d(var3, var6, var24, var2.singlePuyoPopBase);
                            var2.d(var3, var33, var24, var2.bT);
                            var2.b(var3, var6, var24);
                            var2.a(var3, var33, var7);
                            var24 += 15;
                            var2.h(var3, var17, var24);
                            var24 += 15;
                            var7 = var24 + 1;
                            var2.a(var3, var6, var24, var2.bJ);
                            var2.d(var3, var33, var24, var2.bN);
                            var2.b(var3, var6, var24);
                            var2.a(var3, var33, var7);
                            var24 += 15;
                            var2.l(var3, var17, var24);
                            var24 += 15;
                            var7 = var24 + 1;
                            var2.d(var3, var6, var24, var2.bP);
                            var2.d(var3, var33, var24, var2.bQ);
                            var2.b(var3, var6, var24);
                            var2.a(var3, var33, var7);
                            var24 += 15;
                            var2.g(var3, var17, var24);
                            var24 += 15;
                            var7 = var24 + 1;
                            var2.d(var3, var6, var24, var2.cb[0]);
                            var2.d(var3, var33, var24, var2.bR);
                            var2.b(var3, var6, var24);
                            var2.a(var3, var33, var7);
                            var24 += 15;
                            var2.f(var3, var17, var24);
                            var24 += 15;
                            var7 = var24 + 1;
                            var2.d(var3, var33, var24, var2.bK);
                            var2.a(var3, var33, var7);
                        }
                    }
                }
                break;
            case 3:
                this.d(var1);
                break;
            case 4:
                var3 = var1;
                var2 = this;
                if (this.menu) {
                    this.c(var1);
                    break;
                } else {
                    this.c(var1);
                    this.b(var1);
                    var24 = 0;
                    var25 = 0;
                    if (this.J == 2 && this.mainMenuBase != -1) {
                        var25 = 32;
                    }

                    a var36;
                    String[] var31;
                    if (this.mainMenuBase == -1) {
                        a(var1, this.an + 8, this.menuBaseC + 130 + var25, this.an + 240 - 8, this.menuBaseC + 260 - 8, 0);

                        for(var7 = 0; var7 < 3; ++var7) {
                            var4 = var2.menuBaseC + 24 + var7 * 32;
                            if (var7 == var2.J) {
                                var2.p(var3, var2.hDW, var4 - 3);
                            } else {
                                var2.q(var3, var2.hDW, var4 - 3);
                            }

                            switch(var7) {
                            case 0:
                                var2.e(var3, var2.hDW, var4);
                                break;
                            case 1:
                                var2.d(var3, var2.hDW, var4);
                                break;
                            case 2:
                                var11 = var2.hDW;
                                var3.drawRegion(var2.puyoGraphics[14], 0, 48, 64, 24, 0, var11, var4, 17);
                            }
                        }

                        if (var2.J == 2) {
                            var24 = 4;
                        } else {
                            var24 = var2.J;
                        }
                    } else if (this.J == 0) {
                        a(var1, this.an + 8, this.menuBaseC + 130 + var25, this.an + 240 - 8, this.menuBaseC + 260 - 8, 0);

                        for(var7 = 0; var7 < 2; ++var7) {
                            var4 = var2.menuBaseC + 36 + var7 * 32;
                            if (var7 == var2.mainMenuBase) {
                                var2.p(var3, var2.hDW, var4 - 3);
                            } else {
                                var2.q(var3, var2.hDW, var4 - 3);
                            }

                            var2.b(var3, var2.hDW, var4, var7);
                        }

                        var24 = 2 + var2.mainMenuBase;
                    } else if (this.J == 2) {
                        if (this.soundOptionMenu == -1 && this.aboutOptionMenu == -1 && this.N == -1) {
                            a(var1, this.an + 8, this.menuBaseC + 130 + var25, this.an + 240 - 8, this.menuBaseC + 260 - 8, 1);

                            for(var7 = 0; var7 <= 4; ++var7) {
                                var4 = var2.menuBaseC + 16 + var7 * 28;
                                if (var7 == var2.mainMenuBase) {
                                    var2.p(var3, var2.hDW, var4 - 3);
                                } else {
                                    var2.q(var3, var2.hDW, var4 - 3);
                                }

                                switch(var7) {
                                case 0:
                                    var11 = var2.hDW;
                                    var3.drawRegion(var2.puyoGraphics[13], 0, 24, 112, 24, 0, var11, var4, 17);
                                    break;
                                case 1:
                                    var11 = var2.hDW;
                                    var3.drawRegion(var2.puyoGraphics[14], 64, 48, 64, 24, 0, var11, var4, 17);
                                    break;
                                case 2:
                                    var11 = var2.hDW;
                                    var3.drawRegion(var2.puyoGraphics[13], 64, 96, 64, 24, 0, var11, var4, 17);
                                    break;
                                case 3:
                                    var11 = var2.hDW;
                                    var3.drawRegion(var2.puyoGraphics[13], 0, 96, 64, 24, 0, var11, var4, 17);
                                    break;
                                case 4:
                                    var11 = var2.hDW;
                                    var3.drawRegion(var2.puyoGraphics[14], 0, 120, 124, 24, 0, var11, var4, 17);
                                }
                            }

                            var24 = 5 + var2.mainMenuBase;
                        } else if (this.soundOptionMenu != -1) {
                            a(var1, this.an + 8, this.menuBaseC + 130 + var25, this.an + 240 - 8, this.menuBaseC + 260 - 8, 1);

                            for(var7 = 0; var7 < 2; ++var7) {
                                var4 = var2.menuBaseC + 36 + var7 * 32;
                                if (var7 == var2.soundOptionMenu) {
                                    var2.p(var3, var2.hDW, var4 - 3);
                                } else {
                                    var2.q(var3, var2.hDW, var4 - 3);
                                }

                                if (var2.mainMenu) {
                                    var12 = var2.menuBaseC + 36;
                                    var11 = var2.hDW;
                                    var3.drawRegion(var2.puyoGraphics[14], 64, 48, 64, 24, 0, var11 - 20, var12, 17);
                                    var3.drawRegion(var2.puyoGraphics[14], 80, 72, 27, 24, 0, var11 + 20, var12, 17);
                                } else {
                                    var12 = var2.menuBaseC + 36;
                                    var11 = var2.hDW;
                                    var3.drawRegion(var2.puyoGraphics[14], 64, 48, 64, 24, 0, var11 - 20, var12, 17);
                                    var3.drawRegion(var2.puyoGraphics[14], 17, 72, 27, 24, 0, var11 + 20, var12, 17);
                                }

                                int var10003 = var2.menuBaseC + 36 + 30;
                                var13 = var2.b;
                                var11 = var2.hDW;
                                var3.drawRegion(var2.puyoGraphics[14], 0, 94, 42, 26, 0, var11 - 20, var10003, 17);
                                switch(var13) {
                                case 20:
                                    var3.drawRegion(var2.puyoGraphics[14], 100, 94, 27, 26, 0, var11 + 20, var10003, 17);
                                    break;
                                case 60:
                                    var3.drawRegion(var2.puyoGraphics[14], 73, 94, 27, 26, 0, var11 + 20, var10003, 17);
                                    break;
                                default:
                                    var3.drawRegion(var2.puyoGraphics[14], 46, 94, 27, 26, 0, var11 + 20, var10003, 17);
                                }
                            }

                            var24 = 5 + var2.mainMenuBase;
                        } else if (this.aboutOptionMenu != -1) {
                            a(var1, this.an + 8, this.menuBaseC + 8, this.an + 240 - 8, this.menuBaseC + 260 - 8, 1);
                            var1.setColor(4802947);
                            var31 = this.aboutString[this.aboutOptionMenu];

                            for(var8 = 0; var8 < var31.length; ++var8) {
                                if (var31[var8] != null) {
                                    var3.drawString(var31[var8], var2.hDW, var2.menuBaseC + 16 + var8 * 30, 17);
                                }
                            }

                            var24 = 5 + var2.mainMenuBase;
                        } else if (this.N != -1) {
                            var46 = var1;
                            var36 = this;

                            for(var11 = 0; var11 < 5; ++var11) {
                                var12 = var36.menuBaseC + 16 + var11 * 28;
                                if (var11 == var36.N) {
                                    var36.p(var46, var36.hDW, var12 - 3);
                                } else {
                                    var36.q(var46, var36.hDW, var12 - 3);
                                }

                                var15 = var36.hDW;
                                var46.drawRegion(var36.puyoGraphics[9], 0, var11 * 24, 111, 24, 0, var15, var12, 17);
                            }

                            var24 = 5 + this.mainMenuBase;
                        }
                    }

                    if (var2.aboutOptionMenu != -1) {
                        break;
                    }

                    var46 = var3;
                    var36 = var2;
                    var3.setColor(35752);
                    var14 = (var31 = var2.menuDescString[var24]).length;
                    var15 = var25 + 130;
                    var16 = (252 - var15 - 4 - var14 * var2.au) / (var14 + 1);
                    var17 = 0;

                    while(true) {
                        if (var17 >= var31.length) {
                            break label4905;
                        }

                        if (var31[var17] != null) {
                            var46.drawString(var31[var17], var36.av, var36.menuBaseC + var15 + 2 + var16 + (var16 + var36.au) * var17, 20);
                        }

                        ++var17;
                    }
                }
            case 5:
                this.a(var1);
                break;
            case 6:
                var8 = (160 - 6 * this.au) / 7;
                var9 = this.menuBaseC + 80 + 2 + var8;
                a(var1, this.an + 16, this.menuBaseC + 80, this.an + 240 - 16, this.menuBaseC + 244, 0);
                var1.setColor(0);
                if (this.R[this.aw]) {
                    int var10000 = var8 + this.au;
                    var1.drawString(" l b g   [ N  ", this.hDW, var9 + 0, 17);
                    var1.drawString(" ڑ    ܂  B", this.hDW, var9 + var8 + this.au, 17);
                    var1.drawString("  낵   ł    H", this.hDW, var9 + (var8 + this.au << 1), 17);
                    if (this.T[this.aw] == 0) {
                        var1.drawString("   ʂ͖  o ^ ł ", this.hDW, var9 + (var8 + this.au << 2), 17);
                    } else {
                        var1.drawString(this.S[this.aw] + "/" + this.T[this.aw] + "/" + this.U[this.aw] + "    ", this.hDW, var9 + (var8 + this.au << 2), 17);
                        var1.drawString(this.W[this.aw] + " l  " + this.V[this.aw] + "  ", this.hDW, var9 + (var8 + this.au) * 5, 17);
                    }
                } else {
                    var1.drawString(" K  _   ɒB    ", this.hDW, var9 + var8 + this.au, 17);
                    var1.drawString("   Ȃ    ߃A b v", this.hDW, var9 + (var8 + this.au << 1), 17);
                    var1.drawString("   [ h ł  ܂   ", this.hDW, var9 + (var8 + this.au) * 3, 17);
                }
                break;
            case 7:
                this.c(var1);
                var1.drawImage(this.mainBg, this.hDW, this.hDH, 3);
                var1.drawImage(this.puyoGraphics[7], this.hDW, this.hDH, 3);
                var10 = false;
                var9 = 16250789;
                var28 = true;
                var7 = this.menuBaseC;
                String[][] var23 = this.singlePuyoPopManzaiBase;
                var30 = var1;
                var44 = this;
                var12 = (256 - 7 * this.au) / 8;
                var13 = var7 + 2 + var12;
                if (this.eB) {
                    this.eF = var23[this.eC].length;
                }

                var14 = 0;

                while(true) {
                    if (var14 >= var44.eF) {
                        break label4905;
                    }

                    var16 = var44.hDW;
                    var17 = var13 + (var12 + var44.au) * var14;
                    var30.setColor(0);

                    for(var15 = 0; var15 < 4; ++var15) {
                        if (var23[var44.eC][var14] != null) {
                            var30.drawString(var23[var44.eC][var14], var16 + eH[var15][0], var17 + eH[var15][1], 17);
                        }
                    }

                    var30.setColor(var9);
                    if (var23[var44.eC][var14] != null) {
                        var30.drawString(var23[var44.eC][var14], var16, var17, 17);
                    }

                    ++var14;
                }
            case 8:
                this.d(var1);
                break;
            case 9:
                var3 = var1;
                var2 = this;
                var4 = this.an + 12;
                var6 = this.an + 160 - 14;
                var7 = this.an + 240 - 16;
                var8 = this.an + 160 - 7;
                boolean var27 = false;
                this.c(var1);
                var1.drawImage(this.mainBg, this.hDW, this.hDH, 3);
                var1.drawImage(this.puyoGraphics[7], this.hDW, this.hDH, 3);
                byte var29;
                switch(this.aw) {
                case 0:
                default:
                    var29 = 2;
                    break;
                case 1:
                    var29 = 0;
                }

                a(var1, this.an + 8, this.menuBaseC + 64, this.an + 240 - 8, this.menuBaseC + 260 - 8, var29);
                var1.setColor(dM[var29][0]);
                var24 = this.menuBaseC + 104;

                for(var33 = 0; var33 < 2; ++var33) {
                    var3.drawLine(var2.an + 10, var24 + var33, var2.ao - 10, var24 + var33);
                }

                var24 = var2.menuBaseC + 208;

                for(var33 = 0; var33 < 2; ++var33) {
                    var3.drawLine(var2.an + 10, var24 + var33, var2.ao - 10, var24 + var33);
                }

                var3.setStrokeStyle(1);

                for(var33 = 0; var33 < 5; ++var33) {
                    var24 = var2.menuBaseC + 127 + (var33 << 4);
                    var3.drawLine(var2.an + 10, var24, var2.ao - 10, var24);
                }

                var3.setStrokeStyle(0);
                var2.e(var3, var2.hDW, var2.menuBaseC + 8);
                var2.b(var3, var2.hDW, var2.menuBaseC + 32, var2.aw);
                var24 = var2.menuBaseC + 88;
                var2.i(var3, var4, var24);
                var2.d(var3, var7, var24, var2.bF);
                var24 = var2.menuBaseC + 112;
                var3.drawRegion(var2.puyoGraphics[12], 0, 28, 84, 14, 0, var4, var24, 20);
                var2.d(var3, var6, var24, var2.bL);
                var2.d(var3, var7, var24, var2.bM);
                var2.b(var3, var8, var24);
                var24 = var2.menuBaseC + 128;
                var2.h(var3, var4, var24);
                var2.a(var3, var6, var24, var2.bJ);
                var2.d(var3, var7, var24, var2.bN);
                var2.b(var3, var8, var24);
                var24 = var2.menuBaseC + 144;
                var3.drawRegion(var2.puyoGraphics[12], 0, 14, 84, 14, 0, var4, var24, 20);
                var2.d(var3, var6, var24, var2.bG);
                var2.d(var3, var7, var24, var2.bO);
                var2.b(var3, var8, var24);
                var24 = var2.menuBaseC + 160;
                var2.l(var3, var4, var24);
                var2.d(var3, var6, var24, var2.bP);
                var2.d(var3, var7, var24, var2.bQ);
                var2.b(var3, var8, var24);
                var24 = var2.menuBaseC + 176;
                var2.g(var3, var4, var24);
                var2.d(var3, var6, var24, var2.cb[0]);
                var2.d(var3, var7, var24, var2.bR);
                var2.b(var3, var8, var24);
                var24 = var2.menuBaseC + 192;
                var3.drawRegion(var2.puyoGraphics[12], 0, 0, 84, 14, 0, var4, var24, 20);
                var2.d(var3, var6, var24, var2.bH);
                var2.d(var3, var7 - 21, var24, var2.bS / 100);
                var13 = var7 - 21;
                var3.drawRegion(var2.puyoGraphics[12], 108, 82, 8, 14, 0, var13, var24, 20);
                var2.a(var3, var7, var24, var2.bS % 100, 2);
                var3.drawRegion(var2.puyoGraphics[12], 100, 82, 8, 14, 0, var8, var24, 20);
                var24 = var2.menuBaseC + 216;
                var2.f(var3, var4, var24);
                var2.d(var3, var7, var24, var2.bK);
                break;
            case 10:
            case 11:
                var3 = var1;
                var2 = this;
                var42 = false;
                var6 = this.an + 24 + 7;
                var7 = this.an + 100;
                var8 = this.an + 140;
                var9 = this.an + 240 - 35;
                this.c(var1);
                var1.drawImage(this.mainBg, this.hDW, this.hDH, 3);
                var1.drawImage(this.puyoGraphics[7], this.hDW, this.hDH, 3);
                switch(this.aw) {
                case 0:
                default:
                    var21 = 2;
                    break;
                case 1:
                    var21 = 0;
                    break;
                case 2:
                    var21 = 1;
                }

                a(var1, this.an + 8, this.menuBaseC + 64, this.an + 240 - 8, this.menuBaseC + 260 - 8, var21);
                var4 = this.menuBaseC + 20;
                if (this.aw == 2) {
                    this.d(var1, this.hDW, var4);
                } else {
                    this.e(var1, this.hDW, this.menuBaseC + 8);
                    this.b(var1, this.hDW, this.menuBaseC + 32, this.aw);
                }

                if (this.E == 10) {
                    var14 = this.hDW - 80;
                    var1.drawRegion(this.puyoGraphics[13], 112, 0, 16, 24, 0, var14, var4, 17);
                    var14 = this.hDW + 80;
                    var1.drawRegion(this.puyoGraphics[13], 112, 24, 16, 24, 0, var14, var4, 17);
                }

                var1.setColor(dM[var21][0]);
                var4 = this.menuBaseC + 104;

                for(var11 = 0; var11 < 2; ++var11) {
                    var3.drawLine(var2.an + 10, var4 + var11, var2.ao - 10, var4 + var11);
                }

                var4 = var2.menuBaseC + 208;

                for(var11 = 0; var11 < 2; ++var11) {
                    var3.drawLine(var2.an + 10, var4 + var11, var2.ao - 10, var4 + var11);
                }

                var3.setStrokeStyle(1);

                for(var11 = 0; var11 < 4; ++var11) {
                    var4 = var2.menuBaseC + 133 + (var11 << 4);
                    var3.drawLine(var2.an + 10, var4, var2.ao - 10, var4);
                }

                var3.setStrokeStyle(0);
                var4 = var2.menuBaseC + 80;
                var14 = var2.an + 20;
                var3.drawRegion(var2.puyoGraphics[12], 84, 40, 44, 14, 0, var14, var4, 20);
                var2.i(var3, var2.an + 72, var4);
                var2.j(var3, var2.an + 125, var4);
                var14 = var2.an + 168;
                var3.drawRegion(var2.puyoGraphics[12], 0, 112, 84, 14, 0, var14, var4, 20);
                var11 = 0;

                while(true) {
                    if (var11 >= 5) {
                        break label4905;
                    }

                    if (var2.cg == var11) {
                        var10 = var2.bs;
                    } else {
                        var10 = true;
                    }

                    var4 = var2.menuBaseC + 112 + 8 + (var11 << 4);
                    if (var10) {
                        var2.d(var3, var6, var4, var11 + 1);
                        var2.c(var3, var2.an + 40, var4);
                        var2.d(var3, var7, var4, var2.cf[var2.aw][var11][0]);
                        var2.a(var3, var7, var4 + 3);
                        var2.d(var3, var8, var4, var2.cf[var2.aw][var11][1]);
                        var2.a(var3, var9, var4, var2.cf[var2.aw][var11][2]);
                    }

                    ++var11;
                }
            case 12:
                this.c(var1);
                if (this.dD == 1) {
                    var1.drawImage(this.mainBg, this.hDW, this.hDH, 3);
                    var1.drawImage(this.puyoGraphics[7], this.hDW, this.hDH, 3);
                }
                break;
            case 13:
            case 17:
                this.c(var1);
                var1.setColor(0);
                var1.fillRect(0, 0, this.displayWidth, this.displayHeight);
                var1.drawImage(this.mainBg, this.hDW, this.hDH, 3);
                break;
            case 14:
                this.a(var1, (String)null);
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            default:
                break;
            case 44:
                var1.setColor(0);
                var1.fillRect(this.hDW - this.hDW - 0, this.hDH - 130, 854, 260);
                var1.setColor(7286575);
                var1.fillRect(this.hDW - 101, this.hDH - 110, 208, 227);
                var1.setColor(14638686);
                var1.fillRect(this.hDW - 105, this.hDH - 115, 210, 230);
                var1.setColor(15790300);
                var1.fillRect(this.hDW - 101, this.hDH - 111, 202, 222);
                var1.setColor(14638686);
                var1.fillRect(this.hDW - 101, this.hDH - 111, 202, 33);
                var1.setColor(15707822);
                var1.fillRect(this.hDW - 99, this.hDH - 109, 25, 25);
                var1.setColor(16777215);
                var1.fillRect(this.hDW - 98, this.hDH - 108, 23, 23);
                var1.setColor(14638686);
                var1.drawString("!", this.hDW - 87 , this.hDH - 84, 33);
                var1.setColor(16777215);
                var1.drawString("ERROR", this.hDW - 66 , this.hDH - 84, 36);
                var1.setColor(6375051);
                var1.drawString("ゲームはできません", this.hDW, this.hDH - 33, 33);
                var1.drawString("続けるからエラーが", this.hDW, this.hDH - 3, 33);
                var1.drawString("発生したロード中", this.hDW, this.hDH + 27, 33);
                var1.drawString("ゲームデータです。", this.hDW, this.hDH + 57, 33);
                var1.drawString("", this.hDW, this.hDH + 87, 33);
                this.setSoftkeyText("", "");
                if ((this.s & 64) != 0) {
                    this.et.a();
                }
                break;
            case 45:
                var1.setColor(2368548);
                var1.fillRect(this.hDW - this.hDW - 0, this.hDH - 130, 854, 260);
                var1.setColor(16777215);
                var1.drawString("このゲームではあ", this.hDW, this.hDH - 63, 33);
                var1.drawString("りませんと連携", this.hDW, this.hDH - 33, 33);
                var1.drawString("このデバイスを下げる", this.hDW, this.hDH - 3, 33);
                var1.drawString("240x320以上", this.hDW, this.hDH + 27, 33);
                var1.drawString("(QVGA) 解像度。", this.hDW, this.hDH + 57, 33);
                var1.drawString("OK を押して終了します。", this.hDW, this.hDH + 87, 33);
                this.setSoftkeyText("", "");
                if ((this.s & 16) != 0) {
                    this.et.a();
                } else if ((this.s & 32) != 0) {
                    if (this.debugModeFlag) {
                        this.setSoftkeyText("", "");
                        this.E = 48;
                    }
                }
                break;
            case 46:
				if (this.fadeFlag) {
			        this.setSoftkeyText("", "");
				}

                this.optionMenuBase2 += 50;
                if (this.optionMenuBase2 >= 50) {
                    var1.drawImage(this.wipeFrame1, this.hDW, this.hDH, 3);
                }

                if (this.optionMenuBase2 >= 100) {
                    var1.drawImage(this.wipeFrame2, this.hDW, this.hDH, 3);
                }

                if (this.optionMenuBase2 >= 150) {
                    var1.drawImage(this.wipeFrame3, this.hDW, this.hDH, 3);
                }

                if (this.optionMenuBase2 >= 200) {
                    var1.drawImage(this.wipeFrame4, this.hDW, this.hDH, 3);
                }

                if (this.optionMenuBase2 >= 250) {
                    var1.drawImage(this.wipeFrame5, this.hDW, this.hDH, 3);
                }

                if (this.optionMenuBase2 >= 300) {
                    var1.drawImage(this.wipeFrame6, this.hDW, this.hDH, 3);
                }

                if (this.optionMenuBase2 >= 350) {
					this.fadeFlag = false;
                    var1.setColor(0);
					if (this.fadeCode == 24) {
                        var1.setColor(0);
                        var1.fillRect(0, 0, this.displayWidth, this.displayHeight);
					} else {
                        var1.setColor(0);
                        var1.fillRect(0, 0, this.displayWidth, this.displayHeight);
                        var1.drawImage(this.mainBg, this.hDW, this.hDH, 3);
					}
                }

                if (this.optionMenuBase2 >= 400) {
                    switch(this.fadeCode) {
                    case 1:
                        this.townMapMenuBase = 0;
                        this.townMapOptionBase1 = 0;
                        this.townMapOptionBase2 = 0;
                        this.townMapOptionBase3 = 0;
                        if (!this.FirstBootFlag) {
                            this.a(1);
                            if (this.TownmapSecondaryMap) {
                                this.E = 95;
                            } else {
                                this.E = 94;
                            }
                        } else {
                            this.a(2);
                            this.E = 105;
                        }
                        break;
                    case 2:
                        this.E = 96;
                        break;
                    case 3:
                        this.E = 97;
                        break;
                    case 4:
                        this.setSoftkeyText("次へ", "");
                        this.optionMenuBase1 = 7;
                        this.menu = true;
                        this.aw = 0;
                        this.br = 2;
                        this.optionMenuBase2 = 0;
                        this.singlePuyoPopBase = 0;
                        this.F = 7;
                        break;
                    case 5:
                        this.setSoftkeyText("次へ", "");
                        this.optionMenuBase1 = 7;
                        this.menu = true;
                        this.aw = 1;
                        this.br = 2;
                        this.optionMenuBase2 = 0;
                        this.singlePuyoPopBase = 3;
                        this.F = 7;
                        break;
                    case 6:
                        this.optionMenuBase1 = 2;
                        this.menu = true;
                        this.aw = 2;
                        this.br = 1;
                        this.optionMenuBase2 = 0;
                        this.singlePuyoPopBase = 1;
                        this.dm = true;
                        this.b();
                        this.F = 2;
                        break;
                    case 7:
                        this.puyoGraphics[3] = null;
                        this.puyoFever("bg/bg9.png", 3);
                        this.optionMenuBase1 = 2;
                        this.menu = true;
                        this.aw = 0;
                        this.br = 1;
                        this.optionMenuBase2 = 0;
                        this.singlePuyoPopBase = 9;
                        this.dm = true;
                        this.b();
                        this.F = 2;
                        break;
                    case 8:
                        if (this.TownmapSinglePuyoPopEntraceFlag && this.mainMenu) {
                            this.a(2);
                        }

                        this.TownmapSinglePuyoPopEntraceFlag = false;
                        this.E = 96;
                        break;
                    case 9:
                        this.E = 97;
                        break;
                    case 10:
                        this.E = 98;
                        break;
                    case 11:
                        this.E = 99;
                        break;
                    case 12:
                        if (this.TownmapSinglePuyoPopEntraceFlag && this.mainMenu) {
                            this.a(1);
                        }

                        this.TownmapSinglePuyoPopEntraceFlag = false;
                        this.E = 94;
                        break;
                    case 13:
                        this.E = 95;
                        break;
                    case 14:
                        if (this.TownmapSinglePuyoPopEntraceFlag && this.mainMenu) {
                            this.a(2);
                        }

                        if (this.TownmapSinglePuyoPopEntraceFlag) {
                            this.TownmapSinglePuyoPopEntraceFlag = false;
                        }

                        this.townMapOptionBase3 = 0;
                        this.E = 101;
                        break;
                    case 15:
                        this.E = 100;
                        break;
                    case 16:
                        this.F = 5;
                        break;
                    case 17:
                        this.F = 10;
                        break;
                    case 18:
                        this.setSoftkeyText("スタート", "終了");
                        this.F = 1;
                        break;
                    case 19:
                        this.F = 8;
                        break;
                    case 20:
                        this.setSoftkeyText("次へ", "");
                        if (this.aw == 2) {
                            this.F = 11;
                            this.a(1);
                        } else {
                            this.F = 9;
                        }
                        break;
                    case 21:
                        this.setSoftkeyText("次へ", "");
                        this.F = 12;
                        break;
                    case 22:
                        this.setSoftkeyText("次へ", "");
                        this.F = 9;
                        break;
                    case 23:
                        this.F = 3;
                        break;
                    case 24:
                        this.et.a();
                        break;
                    case 25:
                        if (this.TownmapSinglePuyoPopEntraceFlag && this.mainMenu) {
                            this.a(1);
                        }

                        if (this.TownmapSinglePuyoPopEntraceFlag) {
                            this.TownmapSinglePuyoPopEntraceFlag = false;
                        }

                        this.E = 106;
                        break;
                    case 26:
                        if (this.TownmapSinglePuyoPopEntraceFlag && this.mainMenu) {
                            this.a(1);
                        }

                        if (this.TownmapSinglePuyoPopEntraceFlag) {
                            this.TownmapSinglePuyoPopEntraceFlag = false;
                        }

                        this.E = 107;
                        break;
                    case 27:
                        this.a(2);
                        this.E = 108;
                        break;
                    case 28:
                        this.setSoftkeyText("", "");
                        this.F = 13;
                        break;
                    }

                    this.fadeCode = 0;
                }
                break;
            case 47:
            case 48:
                var1.drawImage(this.mainBg, this.hDW, this.hDH, 3);
                this.loadAnimTime += 50;
                this.loadTime += 25;
                var1.drawImage(this.loadBg, this.hDW, this.hDH, 3);
                if (this.debugModeFlag) {
					if (this.loadTime <= 375) {
            	        var1.setColor(16777215);
                	    var1.drawString("DEBUG MODE", this.hDW - 100, this.hDH - 115, 20);
					} else if (this.loadTime <= 750) {
            	        var1.setColor(16777215);
                	    var1.drawString("LOAD MAIN (1/2)", this.hDW - 100, this.hDH - 115, 20);
					} else if (this.loadTime <= 1150) {
            	        var1.setColor(16777215);
                	    var1.drawString("LOAD MAIN (2/2)", this.hDW - 100, this.hDH - 115, 20);
					} else if (this.loadTime <= 1550) {
            	        var1.setColor(16777215);
                	    var1.drawString("LOAD TOWNMAP (1/3)", this.hDW - 100, this.hDH - 115, 20);
					} else if (this.loadTime <= 1950) {
            	        var1.setColor(16777215);
                	    var1.drawString("LOAD TOWNMAP (2/3)", this.hDW - 100, this.hDH - 115, 20);
					} else if (this.loadTime <= 2350) {
            	        var1.setColor(16777215);
                	    var1.drawString("LOAD TOWNMAP (3/3)", this.hDW - 100, this.hDH - 115, 20);
					} else if (this.loadTime <= 2750) {
            	        var1.setColor(16777215);
                	    var1.drawString("LOAD STAGESEL (1/2)", this.hDW - 100, this.hDH - 115, 20);
					} else if (this.loadTime <= 3150) {
            	        var1.setColor(16777215);
                	    var1.drawString("LOAD STAGESEL (2/2)", this.hDW - 100, this.hDH - 115, 20);
					} else if (this.loadTime <= 3550) {
            	        var1.setColor(16777215);
                	    var1.drawString("LOAD WIPEFRAME", this.hDW - 100, this.hDH - 115, 20);
					} else if (this.loadTime <= 3950) {
            	        var1.setColor(16777215);
                	    var1.drawString("LOAD PUYOPREVIEW", this.hDW - 100, this.hDH - 115, 20);
					} else if (this.loadTime <= 4350) {
            	        var1.setColor(16777215);
						if (this.sfxDisabledFlag) {
                	        var1.drawString("[!] SE LOAD ERROR", this.hDW - 100, this.hDH - 115, 20);
                	        var1.drawString("オーディオ非対応", this.hDW - 100, this.hDH - 90, 20);
					    } else {
                	        var1.drawString("LOAD MENU_SE", this.hDW - 100, this.hDH - 115, 20);
						}
					} else if (this.loadTime <= 4750) {
            	        var1.setColor(16777215);
                	    var1.drawString("LOAD INGAME_SE", this.hDW - 100, this.hDH - 115, 20);
					} else if (this.loadTime <= 5150) {
            	        var1.setColor(16777215);
                	    var1.drawString("LOAD PUYO_SE", this.hDW - 100, this.hDH - 115, 20);
					} else if (this.loadTime <= 5550) {
            	        var1.setColor(16777215);
                	    var1.drawString("LOAD CHAIN_SE (1/2)", this.hDW - 100, this.hDH - 115, 20);
					} else if (this.loadTime <= 5950) {
            	        var1.setColor(16777215);
                	    var1.drawString("LOAD CHAIN_SE (2/2)", this.hDW - 100, this.hDH - 115, 20);
					} else if (this.loadTime <= 6350) {
            	        var1.setColor(16777215);
						if (this.sfxDisabledFlag) {
                	        var1.drawString("[!] SE LOAD ERROR", this.hDW - 100, this.hDH - 115, 20);
                	        var1.drawString("オーディオ非対応", this.hDW - 100, this.hDH - 90, 20);
					    } else {
                	        var1.drawString("LOAD VOICE_JP", this.hDW - 100, this.hDH - 115, 20);
						}
					} else if (this.loadTime <= 6750) {
            	        var1.setColor(16777215);
						if (this.sfxDisabledFlag) {
                	        var1.drawString("[!] SE LOAD ERROR", this.hDW - 100, this.hDH - 115, 20);
                	        var1.drawString("オーディオ非対応", this.hDW - 100, this.hDH - 90, 20);
					    } else {
                	        var1.drawString("LOAD VOICE_EN", this.hDW - 100, this.hDH - 115, 20);
						}
					} else if (this.loadTime >= 6750) {
            	        var1.setColor(16777215);
						if (this.sfxDisabledFlag) {
                	        var1.drawString("[!] SE LOAD ERROR", this.hDW - 100, this.hDH - 115, 20);
                	        var1.drawString("オーディオ非対応", this.hDW - 100, this.hDH - 90, 20);
					    } else {
                	        var1.drawString("LOAD VOICE_EN", this.hDW - 100, this.hDH - 115, 20);
						}
					}
                }

                if (this.loadAnimTime > 0) {
                    if (this.loadAnimTime > 100) {
                        if (this.loadAnimTime > 200) {
                            if (this.loadAnimTime > 300) {
                                if (this.loadAnimTime > 400) {
                                    if (this.loadAnimTime > 500) {
                                        if (this.loadAnimTime > 600) {
                                            if (this.loadAnimTime > 700) {
                                                if (this.loadAnimTime > 800) {
                                                    if (this.loadAnimTime > 900) {
                                                        if (this.loadAnimTime > 1000) {
                                                            if (this.loadAnimTime > 1100) {
                                                                if (this.loadAnimTime > 1200) {
                                                                    if (this.loadAnimTime >= 1200) {
                                                                        var1.drawImage(this.loadAnim12, this.hDW + 92, this.hDH + 103, 3);
                                                                    }
                                                                } else {
                                                                    var1.drawImage(this.loadAnim12, this.hDW + 92, this.hDH + 103, 3);
                                                                }
                                                            } else {
                                                                var1.drawImage(this.loadAnim11, this.hDW + 92, this.hDH + 103, 3);
                                                            }
                                                        } else {
                                                            var1.drawImage(this.loadAnim10, this.hDW + 92, this.hDH + 103, 3);
                                                        }
                                                    } else {
                                                        var1.drawImage(this.loadAnim9, this.hDW + 92, this.hDH + 103, 3);
                                                    }
                                                } else {
                                                    var1.drawImage(this.loadAnim8, this.hDW + 92, this.hDH + 103, 3);
                                                }
                                            } else {
                                                var1.drawImage(this.loadAnim7, this.hDW + 92, this.hDH + 103, 3);
                                            }
                                        } else {
                                            var1.drawImage(this.loadAnim6, this.hDW + 92, this.hDH + 103, 3);
                                        }
                                    } else {
                                        var1.drawImage(this.loadAnim5, this.hDW + 92, this.hDH + 103, 3);
                                    }
                                } else {
                                    var1.drawImage(this.loadAnim4, this.hDW + 92, this.hDH + 103, 3);
                                }
                            } else {
                                var1.drawImage(this.loadAnim3, this.hDW + 92, this.hDH + 103, 3);
                            }
                        } else {
                            var1.drawImage(this.loadAnim2, this.hDW + 92, this.hDH + 103, 3);
                        }
                    } else {
                        var1.drawImage(this.loadAnim1, this.hDW + 92, this.hDH + 103, 3);
                    }
                } else {
                    var1.drawImage(this.loadAnim1, this.hDW + 92, this.hDH + 103, 3);
                }

                if (this.loadAnimTime >= 1200) {
                    this.loadAnimTime = 0;
                }

            if (!this.loadedFlag) {
                if (this.loadTime == 400) {
                    try {
                        this.dimBg = Image.createImage("/main/dim_black.png");
                        this.firstBootBg = Image.createImage("/main/firstboot.png");
                        this.exitBg = Image.createImage("/opening/op_bg_e.png");
                        this.wakuwakuEdBkg1 = Image.createImage("/ending/wakuwaku_ed_1.png");
                        this.wakuwakuEdBkg2 = Image.createImage("/ending/wakuwaku_ed_2.png");
                        this.wakuwakuEdBkg3 = Image.createImage("/ending/wakuwaku_ed_3.png");
                    } catch (Exception var) {
						this.E = 44;
                    }
                }

                if (this.loadTime == 800) {
                    try {
                        this.msgWindow1 = Image.createImage("/main/msgbox1.png");
                        this.msgWindow2 = Image.createImage("/main/msgbox2.png");
                        this.pauseMenuSel = Image.createImage("/main/pause_menu_selection.png");
                        this.pauseMenuSelHigh = Image.createImage("/main/pause_menu_selection_highlight.png");
                        this.optMenuSel = Image.createImage("/main/option_menu_selection.png");
                        this.optMenuSelHigh = Image.createImage("/main/option_menu_selection_highlight.png");
                    } catch (Exception var) {
						this.E = 44;
                    }
                }

                if (this.loadTime == 1200) {
                    try {
                        this.townmapMainBg1 = Image.createImage("/townmap/townmap_bg1.png");
                        this.townmapMainBg2 = Image.createImage("/townmap/townmap_bg2.png");
                        this.townmapSchoolBgAkr = Image.createImage("/townmap/school_bg_akr.png");
                        this.townmapTownHallBgAkr = Image.createImage("/townmap/townhall_bg_akr.png");
                        this.townmapTownHallBgRei = Image.createImage("/townmap/townhall_bg_rei.png");
                        this.townmapPlaygroundBgArr = Image.createImage("/townmap/square_bg_arr.png");
                        this.townmapTowerBgHhd = Image.createImage("/townmap/tower_bg_hhd.png");
                        this.townmapOptionBg = Image.createImage("/townmap/option_bg.png");
                        this.townmapSinglePuyoPopBg = Image.createImage("/townmap/singlepuyopop_bg.png");
                    } catch (Exception var) {
						this.E = 44;
                    }
                }

                if (this.loadTime == 1600) {
                    try {
                        this.padlockIcon = Image.createImage("/townmap/padlock.png");
                        this.pCardWindow = Image.createImage("/townmap/p_card_window.png");
                        this.townmapWindowLarge = Image.createImage("/townmap/townmap_window_large.png");
                        this.townmapWindowSmall = Image.createImage("/townmap/townmap_window_small.png");
                        this.townmapBarHigh = Image.createImage("/townmap/bar_01.png");
                        this.townmapBar = Image.createImage("/townmap/bar_02.png");
                        this.townmapMsgWindow = Image.createImage("/townmap/msg_window.png");
                        this.townmapMsgWindowLarge = Image.createImage("/townmap/msg_window_large.png");
                        this.townmapMainArrLeft = Image.createImage("/townmap/townmap_arrow_left.png");
                        this.townmapMainArrRight = Image.createImage("/townmap/townmap_arrow_right.png");
                    } catch (Exception var) {
						this.E = 44;
                    }
                }

                if (this.loadTime == 2000) {
                    try {
                        this.townmapPopupSchool = Image.createImage("/townmap/popup_school.png");
                        this.townmapPopupShop = Image.createImage("/townmap/popup_shop.png");
                        this.townmapPopupTownHall = Image.createImage("/townmap/popup_townhall.png");
                        this.townmapPopupTower = Image.createImage("/townmap/popup_tower.png");
                        this.townmapPopupMuseum = Image.createImage("/townmap/popup_museum.png");
                        this.townmapPopupPlayground = Image.createImage("/townmap/popup_playground.png");
                        this.townmapCourseSelRunRun = Image.createImage("/townmap/coursesel_runrun.png");
                        this.townmapCourseSelRunRunHigh = Image.createImage("/townmap/coursesel_runrun_highlight.png");
                        this.townmapCourseSelWakuWaku = Image.createImage("/townmap/coursesel_wakuwaku.png");
                        this.townmapCourseSelWakuWakuHigh = Image.createImage("/townmap/coursesel_wakuwaku_highlight.png");
                        this.townmapCourseSelHaraHara = Image.createImage("/townmap/coursesel_harahara.png");
                        this.townmapCourseSelHaraHaraHigh = Image.createImage("/townmap/coursesel_harahara_highlight.png");
                    } catch (Exception var) {
						this.E = 44;
                    }
                }

                if (this.loadTime == 2400) {
                    try {
                        this.townmapStgSelBgRunRun = Image.createImage("/townmap/stagesel_runrun.png");
                        this.townmapStgSelBgWakuWaku = Image.createImage("/townmap/stagesel_wakuwaku.png");
                        this.townmapStgSelBgHaraHara = Image.createImage("/townmap/stagesel_harahara.png");
                    } catch (Exception var) {
						this.E = 44;
                    }
                }

                if (this.loadTime == 2800) {
                    try {
                        this.townmapStageSelHighlight = Image.createImage("/townmap/stagesel_highlight.png");
                        this.amtIdle1 = Image.createImage("/townmap/amt_1.png");
                        this.amtIdle2 = Image.createImage("/townmap/amt_2.png");
                        this.amtIdle3 = Image.createImage("/townmap/amt_3.png");
                        this.amtIdle4 = Image.createImage("/townmap/amt_4.png");
                        this.amtIdle5 = Image.createImage("/townmap/amt_5.png");
                    } catch (Exception var) {
						this.E = 44;
                    }
                }

                if (this.loadTime == 3200) {
                    try {
                        this.wipeFrame1 = Image.createImage("/wipe/wipe1.png");
                        this.wipeFrame2 = Image.createImage("/wipe/wipe2.png");
                        this.wipeFrame3 = Image.createImage("/wipe/wipe3.png");
                        this.wipeFrame4 = Image.createImage("/wipe/wipe4.png");
                        this.wipeFrame5 = Image.createImage("/wipe/wipe5.png");
                        this.wipeFrame6 = Image.createImage("/wipe/wipe6.png");
                    } catch (Exception var) {
						this.E = 44;
                    }
                }

                if (this.loadTime == 3600) {
                    try {
                        this.puyoPreviewGummy = Image.createImage("/skin/puyopreview_gummy.png");
                        this.puyoPreviewAqua = Image.createImage("/skin/puyopreview_aqua.png");
                        this.puyoPreviewRetro = Image.createImage("/skin/puyopreview_retro.png");
                        this.puyoPreviewFever = Image.createImage("/skin/puyopreview_fever.png");
                        this.puyoPreviewClassic = Image.createImage("/skin/puyopreview_classic.png");
                    } catch (Exception var) {
						this.E = 44;
                    }
                }
				
                if (this.loadTime == 4000) {
                    if (this.sfxDisabledFlag) {
						this.sfxType = 3;
						this.loadTime = 6400;
					}
                }
				
				if (!this.sfxDisabledFlag) {
                if (this.loadTime == 4000) {
                    try {
                        this.menuChoose = Manager.createPlayer(this.getClass().getResourceAsStream("/se/se17_menu_choose.wav"), "audio/x-wav");
                        this.menuChoose.realize();
                        this.menuChoose.prefetch();
                    } catch (Exception var) {
						this.sfxType = 3;
						this.sfxDisabledFlag = true;
						this.loadTime = 6400;
                        var.printStackTrace();
                    }
					
                    try {
                        this.menuSelect = Manager.createPlayer(this.getClass().getResourceAsStream("/se/se16_menu_select.wav"), "audio/x-wav");
                        this.menuSelect.realize();
                        this.menuSelect.prefetch();
                        this.menuBack = Manager.createPlayer(this.getClass().getResourceAsStream("/se/se18_menu_back.wav"), "audio/x-wav");
                        this.menuBack.realize();
                        this.menuBack.prefetch();
                        this.menuUnavailable = Manager.createPlayer(this.getClass().getResourceAsStream("/se/se29_unavailable.wav"), "audio/x-wav");
                        this.menuUnavailable.realize();
                        this.menuUnavailable.prefetch();
                        this.ding = Manager.createPlayer(this.getClass().getResourceAsStream("/se/se28_ding.wav"), "audio/x-wav");
                        this.ding.realize();
                        this.ding.prefetch();
                    } catch (Exception var) {
                        var.printStackTrace();
                    }
                }

                if (this.loadTime == 4400) {
                    try {
                        this.allClear = Manager.createPlayer(this.getClass().getResourceAsStream("/se/se12_allclear.wav"), "audio/x-wav");
                        this.allClear.realize();
                        this.allClear.prefetch();
                        this.feverEntry = Manager.createPlayer(this.getClass().getResourceAsStream("/se/se13_fever.wav"), "audio/x-wav");
                        this.feverEntry.realize();
                        this.feverEntry.prefetch();
                        this.feverExit = Manager.createPlayer(this.getClass().getResourceAsStream("/se/se26_switch.wav"), "audio/x-wav");
                        this.feverExit.realize();
                        this.feverExit.prefetch();
                        this.pauseSound = Manager.createPlayer(this.getClass().getResourceAsStream("/se/se15_pause.wav"), "audio/x-wav");
                        this.pauseSound.realize();
                        this.pauseSound.prefetch();
                        this.startMatch = Manager.createPlayer(this.getClass().getResourceAsStream("/se/se14_start.wav"), "audio/x-wav");
                        this.startMatch.realize();
                        this.startMatch.prefetch();
                    } catch (Exception var) {
                        var.printStackTrace();
                    }
                }

                if (this.loadTime == 4800) {
                    try {
                        this.puyoMove = Manager.createPlayer(this.getClass().getResourceAsStream("/se/se07_puyo1.wav"), "audio/x-wav");
                        this.puyoMove.realize();
                        this.puyoMove.prefetch();
                        this.puyoRotate = Manager.createPlayer(this.getClass().getResourceAsStream("/se/se08_puyo2.wav"), "audio/x-wav");
                        this.puyoRotate.realize();
                        this.puyoRotate.prefetch();
                        this.puyoDrop = Manager.createPlayer(this.getClass().getResourceAsStream("/se/se09_puyo3.wav"), "audio/x-wav");
                        this.puyoDrop.realize();
                        this.puyoDrop.prefetch();
                        this.nuisanceLight = Manager.createPlayer(this.getClass().getResourceAsStream("/se/se10_puyo4.wav"), "audio/x-wav");
                        this.nuisanceLight.realize();
                        this.nuisanceLight.prefetch();
                        this.nuisanceHeavy = Manager.createPlayer(this.getClass().getResourceAsStream("/se/se11_puyo5.wav"), "audio/x-wav");
                        this.nuisanceHeavy.realize();
                        this.nuisanceHeavy.prefetch();
                    } catch (Exception var) {
                        var.printStackTrace();
                    }
                }

                if (this.loadTime == 5200) {
                    try {
                        this.chain1 = Manager.createPlayer(this.getClass().getResourceAsStream("/se/se00_chain1.wav"), "audio/x-wav");
                        this.chain1.realize();
                        this.chain1.prefetch();
                        this.chain2 = Manager.createPlayer(this.getClass().getResourceAsStream("/se/se01_chain2.wav"), "audio/x-wav");
                        this.chain2.realize();
                        this.chain2.prefetch();
                        this.chain3 = Manager.createPlayer(this.getClass().getResourceAsStream("/se/se02_chain3.wav"), "audio/x-wav");
                        this.chain3.realize();
                        this.chain3.prefetch();
                        this.chain4 = Manager.createPlayer(this.getClass().getResourceAsStream("/se/se03_chain4.wav"), "audio/x-wav");
                        this.chain4.realize();
                        this.chain4.prefetch();
                    } catch (Exception var) {
                        var.printStackTrace();
                    }
                }

                if (this.loadTime == 5600) {
                    try {
                        this.chain5 = Manager.createPlayer(this.getClass().getResourceAsStream("/se/se04_chain5.wav"), "audio/x-wav");
                        this.chain5.realize();
                        this.chain5.prefetch();
                        this.chain6 = Manager.createPlayer(this.getClass().getResourceAsStream("/se/se05_chain6.wav"), "audio/x-wav");
                        this.chain6.realize();
                        this.chain6.prefetch();
                        this.chain7 = Manager.createPlayer(this.getClass().getResourceAsStream("/se/se06_chain7.wav"), "audio/x-wav");
                        this.chain7.realize();
                        this.chain7.prefetch();
                    } catch (Exception var) {
                        var.printStackTrace();
                    }
                }

                if (this.loadTime == 6000) {
                    try {
                        this.amtTitleVoice = Manager.createPlayer(this.getClass().getResourceAsStream("/se/se20_amt_title.wav"), "audio/x-wav");
                        this.amtTitleVoice.realize();
                        this.amtTitleVoice.prefetch();
                        this.amtStartVoice = Manager.createPlayer(this.getClass().getResourceAsStream("/se/se21_amt_start.wav"), "audio/x-wav");
                        this.amtStartVoice.realize();
                        this.amtStartVoice.prefetch();
                        this.amtContinueVoice = Manager.createPlayer(this.getClass().getResourceAsStream("/se/se27_amt_continue.wav"), "audio/x-wav");
                        this.amtContinueVoice.realize();
                        this.amtContinueVoice.prefetch();
                        this.amtFevClearVoice = Manager.createPlayer(this.getClass().getResourceAsStream("/se/se24_amt_fevclear.wav"), "audio/x-wav");
                        this.amtFevClearVoice.realize();
                        this.amtFevClearVoice.prefetch();
                        this.amtFevMissVoice = Manager.createPlayer(this.getClass().getResourceAsStream("/se/se25_amt_fevmiss.wav"), "audio/x-wav");
                        this.amtFevMissVoice.realize();
                        this.amtFevMissVoice.prefetch();
                        this.amtWinVoice = Manager.createPlayer(this.getClass().getResourceAsStream("/se/se22_amt_win.wav"), "audio/x-wav");
                        this.amtWinVoice.realize();
                        this.amtWinVoice.prefetch();
                        this.amtLoseVoice = Manager.createPlayer(this.getClass().getResourceAsStream("/se/se23_amt_lose.wav"), "audio/x-wav");
                        this.amtLoseVoice.realize();
                        this.amtLoseVoice.prefetch();
                    } catch (Exception var) {
                        var.printStackTrace();
                    }
                }

                if (this.loadTime == 6400) {
                    try {
                        this.amtTitleVoiceEN = Manager.createPlayer(this.getClass().getResourceAsStream("/se/se20_amt_title_e.wav"), "audio/x-wav");
                        this.amtTitleVoiceEN.realize();
                        this.amtTitleVoiceEN.prefetch();
                        this.amtStartVoiceEN = Manager.createPlayer(this.getClass().getResourceAsStream("/se/se21_amt_start_e.wav"), "audio/x-wav");
                        this.amtStartVoiceEN.realize();
                        this.amtStartVoiceEN.prefetch();
                        this.amtContinueVoiceEN = Manager.createPlayer(this.getClass().getResourceAsStream("/se/se27_amt_continue_e.wav"), "audio/x-wav");
                        this.amtContinueVoiceEN.realize();
                        this.amtContinueVoiceEN.prefetch();
                        this.amtFevClearVoiceEN = Manager.createPlayer(this.getClass().getResourceAsStream("/se/se24_amt_fevclear_e.wav"), "audio/x-wav");
                        this.amtFevClearVoiceEN.realize();
                        this.amtFevClearVoiceEN.prefetch();
                        this.amtFevMissVoiceEN = Manager.createPlayer(this.getClass().getResourceAsStream("/se/se25_amt_fevmiss_e.wav"), "audio/x-wav");
                        this.amtFevMissVoiceEN.realize();
                        this.amtFevMissVoiceEN.prefetch();
                        this.amtWinVoiceEN = Manager.createPlayer(this.getClass().getResourceAsStream("/se/se22_amt_win_e.wav"), "audio/x-wav");
                        this.amtWinVoiceEN.realize();
                        this.amtWinVoiceEN.prefetch();
                        this.amtLoseVoiceEN = Manager.createPlayer(this.getClass().getResourceAsStream("/se/se23_amt_lose_e.wav"), "audio/x-wav");
                        this.amtLoseVoiceEN.realize();
                        this.amtLoseVoiceEN.prefetch();
                    } catch (Exception var) {
                        var.printStackTrace();
                    }
                }
			    }
            }

                if (this.loadTime == 6800) {
					this.loadedFlag = true;
					if (this.sfxDisabledFlag) {
					    this.E = 58;
					} else if (this.FirstBootFlag) {
					    this.E = 56;
					} else {
                        this.E = 57;
					}
                }

                break;
            case 49:
            case 50:
                var1.drawImage(this.dimBg, this.hDW, this.hDH, 3);
                var1.drawImage(this.msgWindow2, this.hDW, this.hDH, 3);
                var1.setColor(6375051);
                var1.drawString("このモードは", this.hDW, this.hDH - 60, 33);
                var1.drawString("利用できません。", this.hDW, this.hDH - 30, 33);
                var1.drawString("", this.hDW, this.hDH + 0, 33);
                var1.drawString("近日公開。", this.hDW, this.hDH + 30, 33);
                var1.drawImage(this.pauseMenuSelHigh, this.hDW, this.hDH + 64, 3);
                var1.setColor(16777215);
                var1.drawString("OK", this.hDW, this.hDH + 77, 33);
                this.setSoftkeyText("", "");
                if ((this.s & 16) != 0) {
                    if (this.TownmapSecondaryMap) {
                        this.E = 95;
                    } else {
                        this.E = 94;
                    }
                }
                break;
            case 51:
                var1.drawImage(this.dimBg, this.hDW, this.hDH, 3);
                var1.drawImage(this.msgWindow2, this.hDW, this.hDH, 3);
                var1.setColor(6375051);
                var1.drawString("このモードは", this.hDW, this.hDH - 60, 33);
                var1.drawString("利用できません。", this.hDW, this.hDH - 30, 33);
                var1.drawString("", this.hDW, this.hDH + 0, 33);
                var1.drawString("近日公開。", this.hDW, this.hDH + 30, 33);
                var1.drawImage(this.pauseMenuSelHigh, this.hDW, this.hDH + 64, 3);
                var1.setColor(16777215);
                var1.drawString("OK", this.hDW, this.hDH + 77, 33);
                this.setSoftkeyText("", "");
                if ((this.s & 16) != 0) {
                    this.E = 97;
                }
                break;
            case 52:
                var1.drawImage(this.dimBg, this.hDW, this.hDH, 3);
                var1.drawImage(this.msgWindow2, this.hDW, this.hDH, 3);
                var1.setColor(6375051);
                var1.drawString("このモードは", this.hDW, this.hDH - 60, 33);
                var1.drawString("利用できません。", this.hDW, this.hDH - 30, 33);
                var1.drawString("", this.hDW, this.hDH + 0, 33);
                var1.drawString("近日公開。", this.hDW, this.hDH + 30, 33);
                var1.drawImage(this.pauseMenuSelHigh, this.hDW, this.hDH + 64, 3);
                var1.setColor(16777215);
                var1.drawString("OK", this.hDW, this.hDH + 77, 33);
                this.setSoftkeyText("", "");
                if ((this.s & 16) != 0) {
                    this.E = 98;
                }
                break;
            case 53:
                var1.drawImage(this.dimBg, this.hDW, this.hDH, 3);
                var1.drawImage(this.msgWindow2, this.hDW, this.hDH, 3);
                var1.setColor(6375051);
                var1.drawString("このモードは", this.hDW, this.hDH - 60, 33);
                var1.drawString("利用できません。", this.hDW, this.hDH - 30, 33);
                var1.drawString("", this.hDW, this.hDH + 0, 33);
                var1.drawString("近日公開。", this.hDW, this.hDH + 30, 33);
                var1.drawImage(this.pauseMenuSelHigh, this.hDW, this.hDH + 64, 3);
                var1.setColor(16777215);
                var1.drawString("OK", this.hDW, this.hDH + 77, 33);
                this.setSoftkeyText("", "");
                if ((this.s & 16) != 0) {
                    this.E = 98;
                }
                break;
            case 54:
                var1.drawImage(this.dimBg, this.hDW, this.hDH, 3);
                var1.drawImage(this.msgWindow2, this.hDW, this.hDH, 3);
                var1.setColor(6375051);
                var1.drawString("このモードは", this.hDW, this.hDH - 60, 33);
                var1.drawString("利用できません。", this.hDW, this.hDH - 30, 33);
                var1.drawString("", this.hDW, this.hDH + 0, 33);
                var1.drawString("近日公開。", this.hDW, this.hDH + 30, 33);
                var1.drawImage(this.pauseMenuSelHigh, this.hDW, this.hDH + 64, 3);
                var1.setColor(16777215);
                var1.drawString("OK", this.hDW, this.hDH + 77, 33);
                this.setSoftkeyText("", "");
                if ((this.s & 16) != 0) {
                    this.E = 99;
                }
                break;
            case 55:
                var1.drawImage(this.dimBg, this.hDW, this.hDH, 3);
                var1.drawImage(this.msgWindow2, this.hDW, this.hDH, 3);
                var1.setColor(6375051);
                var1.drawString("このモードは", this.hDW, this.hDH - 60, 33);
                var1.drawString("利用できません。", this.hDW, this.hDH - 30, 33);
                var1.drawString("", this.hDW, this.hDH + 0, 33);
                var1.drawString("近日公開。", this.hDW, this.hDH + 30, 33);
                var1.drawImage(this.pauseMenuSelHigh, this.hDW, this.hDH + 64, 3);
                var1.setColor(16777215);
                var1.drawString("OK", this.hDW, this.hDH + 77, 33);
                this.setSoftkeyText("", "");
                if ((this.s & 16) != 0) {
                    this.E = 99;
                }
                break;
            case 56:
                var1.drawImage(this.mainBg, this.hDW, this.hDH, 3);
                var1.drawImage(this.firstBootBg, this.hDW, this.hDH, 3);
                var1.drawImage(this.dimBg, this.hDW, this.hDH, 3);
                var1.drawImage(this.msgWindow1, this.hDW, this.hDH, 3);
                var1.drawImage(this.optMenuSel, this.hDW, this.hDH - 46, 3);
                var1.drawImage(this.optMenuSel, this.hDW, this.hDH - 16, 3);
                var1.drawImage(this.optMenuSel, this.hDW, this.hDH + 14, 3);
                var1.drawImage(this.optMenuSel, this.hDW, this.hDH + 44, 3);
                if (this.townMapOptionBase2 == 0) {
                    var1.drawImage(this.optMenuSelHigh, this.hDW, this.hDH - 46, 3);
                } else if (this.townMapOptionBase2 == 1) {
                    var1.drawImage(this.optMenuSelHigh, this.hDW, this.hDH - 16, 3);
                } else if (this.townMapOptionBase2 == 2) {
                    var1.drawImage(this.optMenuSelHigh, this.hDW, this.hDH + 14, 3);
                } else if (this.townMapOptionBase2 == 3) {
                    var1.drawImage(this.optMenuSelHigh, this.hDW, this.hDH + 44, 3);
                }

                var1.setColor(2406101);
                var1.drawString("サウンド", this.hDW - 74, this.hDH - 100, 20);
                var1.drawString("サウンド", this.hDW - 72, this.hDH - 100, 20);
                var1.drawString("サウンド", this.hDW - 73, this.hDH - 101, 20);
                var1.drawString("サウンド", this.hDW - 73, this.hDH - 99, 20);
                var1.drawString("サウンド", this.hDW - 72, this.hDH - 98, 20);
                var1.drawString("サウンド", this.hDW - 71, this.hDH - 98, 20);
                var1.setColor(16777215);
                var1.drawString("サウンド", this.hDW - 73, this.hDH - 100, 20);
                if (this.townMapOptionBase2 == 0) {
                    var1.setColor(16777215);
                } else {
                    var1.setColor(6375051);
                }

                var1.drawString("BGM", this.hDW - 75, this.hDH - 58, 20);
                if (this.mainMenu) {
                    var1.drawString("オン", this.hDW + 78, this.hDH - 58, 24);
                } else {
                    var1.drawString("オフ", this.hDW + 78, this.hDH - 58, 24);
                }

                if (this.townMapOptionBase2 == 1) {
					if (this.sfxDisabledFlag) {
					    var1.setColor(8631739);
					} else {
                        var1.setColor(16777215);
					}
                } else {
					if (this.sfxDisabledFlag) {
					    var1.setColor(8631739);
					} else {
                        var1.setColor(6375051);
					}
                }

                var1.drawString("SE", this.hDW - 75, this.hDH - 28, 20);
                if (this.sfxType == 3) {
                    var1.drawString("オフ", this.hDW + 78, this.hDH - 28, 24);
                } else if (this.sfxType == 2) {
                    var1.drawString("部分的", this.hDW + 78, this.hDH - 28, 24);
                } else if (this.sfxType == 1) {
                    var1.drawString("満杯", this.hDW + 78, this.hDH - 28, 24);
                }

                if (this.townMapOptionBase2 == 2) {
					if (this.sfxDisabledFlag) {
					    var1.setColor(8631739);
					} else {
                        var1.setColor(16777215);
					}
                } else {
					if (this.sfxDisabledFlag) {
					    var1.setColor(8631739);
					} else {
                        var1.setColor(6375051);
					}
                }

                var1.drawString("声", this.hDW - 75, this.hDH + 2, 20);
                if (this.voiceLangType == 0) {
                    var1.drawString("日本", this.hDW + 78, this.hDH + 2, 24);
                } else if (this.voiceLangType == 1) {
                    var1.drawString("英語", this.hDW + 78, this.hDH + 2, 24);
                }

                if (this.townMapOptionBase2 == 3) {
                    var1.setColor(16777215);
                } else {
                    var1.setColor(6375051);
                }

                var1.drawString("音量", this.hDW - 75, this.hDH + 32, 20);
                if (this.b == 20) {
                    var1.drawString("低い", this.hDW + 78, this.hDH + 32, 24);
                } else if (this.b == 60) {
                    var1.drawString("中くらい", this.hDW + 78, this.hDH + 32, 24);
                } else if (this.b == 100) {
                    var1.drawString("高い", this.hDW + 78, this.hDH + 32, 24);
                }

                var1.setColor(2406101);
                if (this.townMapOptionBase2 == 0) {
                    var1.drawString("背景音楽", this.hDW - 85, this.hDH + 67, 20);
                } else if (this.townMapOptionBase2 == 1) {
					if (this.sfxDisabledFlag) {
                        var1.setColor(14638686);
                        var1.drawString("[！] 無効", this.hDW - 85, this.hDH + 67, 20);
					} else {
                        var1.drawString("効果音の種類", this.hDW - 85, this.hDH + 67, 20);
					}
                } else if (this.townMapOptionBase2 == 2) {
					if (this.sfxDisabledFlag) {
                        var1.setColor(14638686);
                        var1.drawString("[！] 無効", this.hDW - 85, this.hDH + 67, 20);
					} else {
                        var1.drawString("音声言語", this.hDW - 85, this.hDH + 67, 20);
					}
                } else if (this.townMapOptionBase2 == 3) {
                    var1.drawString("音量", this.hDW - 85, this.hDH + 67, 20);
                }
				
				if (this.sfxDisabledFlag && this.townMapOptionBase2 == 1) {
                    this.setSoftkeyText("", "戻る");
				} else if (this.sfxDisabledFlag && this.townMapOptionBase2 == 2) {
                    this.setSoftkeyText("", "戻る");
				} else {
                    this.setSoftkeyText("変化", "戻る");
				}
	
                if ((this.s & 1) != 0) {
                    --this.townMapOptionBase2;
                    if (this.townMapOptionBase2 < 0) {
                        this.townMapOptionBase2 = 3;
                    }
                } else if ((this.s & 4) != 0) {
                    ++this.townMapOptionBase2;
                    if (this.townMapOptionBase2 > 3) {
                        this.townMapOptionBase2 = 0;
                    }
                } else if ((this.s & 16) == 0 && (this.s & 32) == 0) {
                    if ((this.s & 64) != 0) {
                        this.optionMenuBase2 = 0;
                        this.townMapOptionBase2 = 0;
                        this.u();
                        if (this.debugModeFlag) {
                            this.E = 70;
                        } else {
                            this.optionMenuBase2 = 0;
							this.fadeFlag = true;
                            this.fadeCode = 18;
                            this.E = 46;
                        }
                    }
                } else {
                    switch(this.townMapOptionBase2) {
                    case 0:
                        if (this.mainMenu) {
                            this.mainMenu = false;
                        } else {
                            this.mainMenu = true;
                        }
                        break label4905;
                    case 1:
					    if (!this.sfxDisabledFlag) {
                            switch(this.sfxType) {
                            case 2:
                                this.sfxType = 1;
                                break label4905;
                            case 3:
                                this.sfxType = 2;
                                break label4905;
                            default:
                                this.sfxType = 3;
                                break label4905;
                            }
						}
						
						break;
                    case 2:
					    if (!this.sfxDisabledFlag) {
                            switch(this.voiceLangType) {
                            case 1:
                                this.voiceLangType = 0;
                                break label4905;
                            default:
                                this.voiceLangType = 1;
                                break label4905;
                            }
						}
						
						break;
                    case 3:
                        this.i();
                        switch(this.b) {
                        case 60:
                            this.b = 20;
                            break label4905;
                        case 100:
                            this.b = 60;
                            break label4905;
                        default:
                            this.b = 100;
                        }
                    }
                }
                break;
            case 57:
                var1.drawImage(this.mainBg, this.hDW, this.hDH, 3);
                var1.drawImage(this.firstBootBg, this.hDW, this.hDH, 3);
                var1.drawImage(this.dimBg, this.hDW, this.hDH, 3);
                var1.drawImage(this.msgWindow1, this.hDW, this.hDH, 3);
                var1.setColor(2406101);
                var1.drawString("サウンド", this.hDW - 74, this.hDH - 100, 20);
                var1.drawString("サウンド", this.hDW - 72, this.hDH - 100, 20);
                var1.drawString("サウンド", this.hDW - 73, this.hDH - 101, 20);
                var1.drawString("サウンド", this.hDW - 73, this.hDH - 99, 20);
                var1.drawString("サウンド", this.hDW - 72, this.hDH - 98, 20);
                var1.drawString("サウンド", this.hDW - 71, this.hDH - 98, 20);
                var1.setColor(16777215);
                var1.drawString("サウンド", this.hDW - 73, this.hDH - 100, 20);
                var1.setColor(6375051);
                var1.drawString("あなたはしたいですか", this.hDW, this.hDH - 45, 33);
                var1.drawString("BGMを有効にする音？", this.hDW, this.hDH - 20, 33);
                var1.drawString("", this.hDW, this.hDH + 5, 33);
                var1.setColor(2406101);
                var1.drawString("(OK/5キーを押す", this.hDW, this.hDH + 40, 33);
                var1.drawString("変更するには", this.hDW, this.hDH + 65, 33);
                var1.drawString("サウンド設定）。", this.hDW, this.hDH + 90, 33);
                this.setSoftkeyText("はい", "いいえ");
                if ((this.s & 16) != 0) {
                    this.E = 56;
                } else if ((this.s & 32) != 0) {
                    this.mainMenu = true;
                    if (this.debugModeFlag) {
                        this.E = 70;
                    } else {
                        this.optionMenuBase2 = 0;
						this.fadeFlag = true;
                        this.fadeCode = 18;
                        this.E = 46;
                    }
                } else if ((this.s & 64) != 0) {
                    this.mainMenu = false;
                    if (this.debugModeFlag) {
                        this.E = 70;
                    } else {
                        this.optionMenuBase2 = 0;
						this.fadeFlag = true;
                        this.fadeCode = 18;
                        this.E = 46;
                    }
                }
                break;
            case 58:
                var1.drawImage(this.mainBg, this.hDW, this.hDH, 3);
                var1.drawImage(this.firstBootBg, this.hDW, this.hDH, 3);
                var1.drawImage(this.dimBg, this.hDW, this.hDH, 3);
                var1.drawImage(this.msgWindow1, this.hDW, this.hDH, 3);
                var1.setColor(2406101);
                var1.drawString("サウンド", this.hDW - 74, this.hDH - 100, 20);
                var1.drawString("サウンド", this.hDW - 72, this.hDH - 100, 20);
                var1.drawString("サウンド", this.hDW - 73, this.hDH - 101, 20);
                var1.drawString("サウンド", this.hDW - 73, this.hDH - 99, 20);
                var1.drawString("サウンド", this.hDW - 72, this.hDH - 98, 20);
                var1.drawString("サウンド", this.hDW - 71, this.hDH - 98, 20);
                var1.setColor(16777215);
                var1.drawString("サウンド", this.hDW - 73, this.hDH - 100, 20);
                var1.setColor(14638686);
                var1.drawString("お使いのデバイスは", this.hDW, this.hDH - 45, 33);
                var1.drawString("互換性がありません", this.hDW, this.hDH - 20, 33);
                var1.drawString("これを選択した状態で", this.hDW, this.hDH + 5, 33);
                var1.drawString("SEオーディオ タイプ。", this.hDW, this.hDH + 30, 33);
                var1.setColor(2406101);
                var1.drawString("（SEは無効です）", this.hDW, this.hDH + 55, 33);		
                var1.drawImage(this.pauseMenuSelHigh, this.hDW, this.hDH + 77, 3);
                var1.setColor(16777215);
                var1.drawString("OK", this.hDW, this.hDH + 90, 33);
                this.setSoftkeyText("", "");
                if ((this.s & 16) != 0) {
					if (this.FirstBootFlag) {
					    this.E = 56;
					} else {
                        this.E = 57;
					}
                }
                break;
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
                this.E = 70;
                break;
            case 70:
                var1.setColor(16777215);
                var1.fillRect(this.hDW - this.hDW - 0, this.hDH - 130, 854, 260);
                var1.setColor(34797);
                var1.drawString("LSK / OK: 選ぶ", 20, 67, 36);
                var1.setColor(2406101);
				if (this.debugMainMenuBase == 0) {
                	var1.drawString(">", 20, 97, 36);
				} else if (this.debugMainMenuBase == 1) {
                	var1.drawString(">", 20, 127, 36);
				} else if (this.debugMainMenuBase == 2) {
                	var1.drawString(">", 20, 157, 36);
				} else if (this.debugMainMenuBase == 3) {
                	var1.drawString(">", 20, 187, 36);
				} else if (this.debugMainMenuBase == 4) {
                	var1.drawString(">", 20, 217, 36);
				}

				if (this.debugMainMenuBase == 0) {
                	var1.setColor(2406101);
				} else {
					var1.setColor(0);
				}
                var1.drawString("ゲームメニュー", 45, 97, 36);
				
				if (this.debugMainMenuBase == 1) {
                	var1.setColor(2406101);
				} else {
					var1.setColor(0);
				}
                var1.drawString("サウンドオプション", 45, 127, 36);
				
				if (this.debugMainMenuBase == 2) {
                	var1.setColor(2406101);
				} else {
					var1.setColor(0);
				}
                var1.drawString("について", 45, 157, 36);
				
				if (this.debugMainMenuBase == 3) {
                	var1.setColor(2406101);
				} else {
					var1.setColor(0);
				}
                var1.drawString("終了", 45, 187, 36);

                var1.setColor(14638686);
                var1.drawString("RSK: タイトル", 223, 253, 40);
                var1.setColor(5159168);
                var1.drawString("Ver. 2.01_ja_JP (0000)", 223, 283, 40);
                this.setSoftkeyText("", "");
                if ((this.s & 1) != 0) {
                    --this.debugMainMenuBase;
                    if (this.debugMainMenuBase < 0) {
                        this.debugMainMenuBase = 3;
                    }
                } else if ((this.s & 4) != 0) {
                    ++this.debugMainMenuBase;
                    if (this.debugMainMenuBase > 3) {
                        this.debugMainMenuBase = 0;
                    }
                } else if ((this.s & 16) != 0 || (this.s & 32) != 0) {
					switch(this.debugMainMenuBase) {
					case 0:
						this.debugMenuBase = 0;
						this.E = 88;
						break;
					case 1:
						this.E = 56;
						break;
					case 2:
						this.E = 81;
						break;
					case 3:
						this.E = 86;
						break;
					}
                } else if ((this.s & 64) != 0) {
					var1.setColor(0);
					var1.fillRect(this.hDW - this.hDW - 0, this.hDH - 130, 854, 260);
					var1.drawImage(this.mainBg, this.hDW, this.hDH, 3);
					this.debugMainMenuBase = 0;
                    this.setSoftkeyText("スタート", "終了");
                    this.F = 1;
                }
                break;
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
                var1.setColor(16777215);
                var1.fillRect(this.hDW - this.hDW - 0, this.hDH - 130, 854, 260);
                var1.setColor(1203050);
                var1.fillRect(this.hDW - 101, this.hDH - 110, 208, 227);
                var1.setColor(2406101);
                var1.fillRect(this.hDW - 105, this.hDH - 115, 210, 230);
                var1.setColor(15790300);
                var1.fillRect(this.hDW - 101, this.hDH - 111, 202, 222);
                var1.setColor(2406101);
                var1.fillRect(this.hDW - 101, this.hDH - 111, 202, 33);
                var1.setColor(9624554);
                var1.fillRect(this.hDW - 99, this.hDH - 109, 25, 25);
                var1.setColor(16777215);
                var1.fillRect(this.hDW - 98, this.hDH - 108, 23, 23);
                var1.setColor(2406101);
                var1.drawString("i", this.hDW - 87 , this.hDH - 84, 33);
                var1.setColor(16777215);
                var1.drawString("について", this.hDW - 66 , this.hDH - 84, 36);
                var1.setColor(6375051);
                var1.drawString("ぷよぷよフィーバー", this.hDW, this.hDH - 33, 33);
                var1.drawString("Re:れんさ", this.hDW, this.hDH - 3, 33);
                var1.drawString("Ver. 2.01_ja_JP (0000)", this.hDW, this.hDH + 27, 33);
                var1.drawString("リリース", this.hDW, this.hDH + 57, 33);
                var1.drawString("(C) SEGA", this.hDW, this.hDH + 87, 33);
                this.setSoftkeyText("", "戻る");
                if ((this.s & 64) != 0) {
                    this.E = 70;
                }
                break;
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
                if (this.debugModeFlag) {
                    var1.setColor(16777215);
                    var1.fillRect(this.hDW - this.hDW - 0, this.hDH - 130, 854, 260);
                } else {
                    var1.drawImage(this.dimBg, this.hDW, this.hDH, 3);
                }

                var1.drawImage(this.msgWindow1, this.hDW, this.hDH, 3);
                var1.drawImage(this.pauseMenuSel, this.hDW, this.hDH + 44, 3);
                var1.drawImage(this.pauseMenuSel, this.hDW, this.hDH + 74, 3);
                var1.setColor(2406101);
                var1.drawString("終了", this.hDW - 74, this.hDH - 100, 20);
                var1.drawString("終了", this.hDW - 72, this.hDH - 100, 20);
                var1.drawString("終了", this.hDW - 73, this.hDH - 101, 20);
                var1.drawString("終了", this.hDW - 73, this.hDH - 99, 20);
                var1.drawString("終了", this.hDW - 72, this.hDH - 98, 20);
                var1.drawString("終了", this.hDW - 71, this.hDH - 98, 20);
                var1.setColor(16777215);
                var1.drawString("終了", this.hDW - 73, this.hDH - 100, 20);
                var1.setColor(6375051);
                var1.drawString("本当にゲーム", this.hDW, this.hDH - 45, 33);
                var1.drawString("を終了しますか？", this.hDW, this.hDH - 15, 33);
                var1.drawString("", this.hDW, this.hDH + 15, 33);
                var1.drawImage(this.pauseMenuSelHigh, this.hDW, this.hDH + 44, 3);
                var1.setColor(16777215);
                var1.drawString("はい", this.hDW, this.hDH + 57, 33);
                var1.setColor(6375051);
                var1.drawString("いいえ", this.hDW, this.hDH + 87, 33);
                this.setSoftkeyText("", "");
                if ((this.s & 1) != 0) {
                    if (!this.debugModeFlag && (this.sfxType == 1 || this.sfxType == 2)) {
                        try {
                            ((VolumeControl)this.menuChoose.getControl("VolumeControl")).setLevel(this.b);
                            this.menuChoose.start();
                        } catch (Exception var100) {
                            var100.printStackTrace();
                        }
                    }

                    this.E = 87;
                } else {
                    if ((this.s & 4) == 0) {
                        if ((this.s & 16) != 0) {
                            this.optionMenuBase2 = 0;
							this.fadeFlag = true;
                            this.fadeCode = 24;
                            this.E = 46;
                        }
                        break;
                    }

                    if (!this.debugModeFlag && (this.sfxType == 1 || this.sfxType == 2)) {
                        try {
                            ((VolumeControl)this.menuChoose.getControl("VolumeControl")).setLevel(this.b);
                            this.menuChoose.start();
                        } catch (Exception var101) {
                            var101.printStackTrace();
                        }
                    }

                    this.E = 87;
                }
                break;
            case 87:
                if (this.debugModeFlag) {
                    var1.setColor(16777215);
                    var1.fillRect(this.hDW - this.hDW - 0, this.hDH - 130, 854, 260);
                } else {
                    var1.drawImage(this.dimBg, this.hDW, this.hDH, 3);
                }

                var1.drawImage(this.msgWindow1, this.hDW, this.hDH, 3);
                var1.drawImage(this.pauseMenuSel, this.hDW, this.hDH + 44, 3);
                var1.drawImage(this.pauseMenuSel, this.hDW, this.hDH + 74, 3);
                var1.setColor(2406101);
                var1.drawString("終了", this.hDW - 74, this.hDH - 100, 20);
                var1.drawString("終了", this.hDW - 72, this.hDH - 100, 20);
                var1.drawString("終了", this.hDW - 73, this.hDH - 101, 20);
                var1.drawString("終了", this.hDW - 73, this.hDH - 99, 20);
                var1.drawString("終了", this.hDW - 72, this.hDH - 98, 20);
                var1.drawString("終了", this.hDW - 71, this.hDH - 98, 20);
                var1.setColor(16777215);
                var1.drawString("終了", this.hDW - 73, this.hDH - 100, 20);
                var1.setColor(6375051);
                var1.drawString("本当にゲーム", this.hDW, this.hDH - 45, 33);
                var1.drawString("を終了しますか？", this.hDW, this.hDH - 15, 33);
                var1.drawString("", this.hDW, this.hDH + 15, 33);
                var1.drawImage(this.pauseMenuSelHigh, this.hDW, this.hDH + 74, 3);
                var1.drawString("はい", this.hDW, this.hDH + 57, 33);
                var1.setColor(16777215);
                var1.drawString("いいえ", this.hDW, this.hDH + 87, 33);
                this.setSoftkeyText("", "");
                if ((this.s & 1) != 0) {
                    if (!this.debugModeFlag && (this.sfxType == 1 || this.sfxType == 2)) {
                        try {
                            ((VolumeControl)this.menuChoose.getControl("VolumeControl")).setLevel(this.b);
                            this.menuChoose.start();
                        } catch (Exception var98) {
                            var98.printStackTrace();
                        }
                    }

                    this.E = 86;
                } else {
                    if ((this.s & 4) == 0) {
                        if ((this.s & 16) != 0) {
                            if (this.debugModeFlag) {
                                this.E = 70;
                            } else {
                                this.optionMenuBase2 = 0;
								this.fadeFlag = true;
                                this.fadeCode = 18;
                                this.E = 46;
                            }
                        }
                        break;
                    }

                    if (!this.debugModeFlag && (this.sfxType == 1 || this.sfxType == 2)) {
                        try {
                            ((VolumeControl)this.menuChoose.getControl("VolumeControl")).setLevel(this.b);
                            this.menuChoose.start();
                        } catch (Exception var99) {
                            var99.printStackTrace();
                        }
                    }

                    this.E = 86;
                }
                break;
            case 88:
                var1.setColor(16777215);
                var1.fillRect(this.hDW - this.hDW - 0, this.hDH - 130, 854, 260);
                var1.setColor(1203050);
                var1.fillRect(this.hDW - 101, this.hDH - 110, 208, 227);
                var1.setColor(2406101);
                var1.fillRect(this.hDW - 105, this.hDH - 115, 210, 230);
                var1.setColor(15790300);
                var1.fillRect(this.hDW - 101, this.hDH - 111, 202, 222);
                var1.setColor(2406101);
                var1.fillRect(this.hDW - 101, this.hDH - 111, 202, 33);
                var1.setColor(9624554);
                var1.fillRect(this.hDW - 99, this.hDH - 109, 25, 25);
                var1.setColor(16777215);
                var1.fillRect(this.hDW - 98, this.hDH - 108, 23, 23);
                var1.setColor(2406101);
                var1.drawString("i", this.hDW - 87 , this.hDH - 84, 33);
                var1.setColor(16777215);
                var1.drawString("ゲームメニュー", this.hDW - 66 , this.hDH - 84, 36);

                if (this.debugMenuBase == 0) {
                    var1.setColor(2406101);
                    var1.drawString("MENU", 70, 117, 36);
                } else {
                    var1.setColor(6375051);
                    var1.drawString("MENU", 70, 117, 36);
                }

                if (this.debugMenuBase == 1) {
                    var1.setColor(2406101);
                    var1.drawString("TOWNMAP", 70, 147, 36);
                } else {
                    var1.setColor(6375051);
                    var1.drawString("TOWNMAP", 70, 147, 36);
                }

                if (this.debugMenuBase == 2) {
                    var1.setColor(2406101);
                    var1.drawString("OPENING", 70, 177, 36);
                } else {
                    var1.setColor(6375051);
                    var1.drawString("OPENING", 70, 177, 36);
                }

                if (this.debugMenuBase == 3) {
                    var1.setColor(2406101);
                    var1.drawString("ENDING", 70, 207, 36);
                } else {
                    var1.setColor(6375051);
                    var1.drawString("ENDING", 70, 207, 36);
                }

                if (this.debugMenuBase == 4) {
                    var1.setColor(2406101);
                    var1.drawString("MANZAI", 70, 237, 36);
                } else {
                    var1.setColor(6375051);
                    var1.drawString("MANZAI", 70, 237, 36);
                }

                var1.setColor(14638686);
                var1.drawString("OK: 選ぶ", 207, 257, 40);
                this.setSoftkeyText("", "戻る");
                if ((this.s & 1) != 0) {
                    --this.debugMenuBase;
                    if (this.debugMenuBase < 0) {
                        this.debugMenuBase = 4;
                    }

                    this.E = 88;
                } else if ((this.s & 4) != 0) {
                    ++this.debugMenuBase;
                    if (this.debugMenuBase > 4) {
                        this.debugMenuBase = 0;
                    }

                    this.E = 88;
                } else if ((this.s & 16) != 0) {
                    var1.setColor(16777215);
                    var1.fillRect(this.hDW - this.hDW - 0, this.hDH - 130, 854, 260);
                    switch(this.debugMenuBase) {
                    case 0:
                        this.F = 4;
                        break label4905;
                    case 1:
                        this.E = 94;
                        break label4905;
                    case 2:
                        this.setSoftkeyText("次へ", "");
                        this.F = 7;
                        break label4905;
                    case 3:
					    if (this.aw == 1) {
							this.a(2);
                            this.E = 108;
						} else {
                            this.F = 3;
						}
                        break label4905;
                    case 4:
                        this.F = 8;
                    }
                } else if ((this.s & 64) != 0) {
                    this.E = 70;
                    this.debugMenuBase = 0;
                }
                break;
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
                var1.setColor(0);
                var1.fillRect(this.hDW - 120, 30, 240, 260);
                var1.drawImage(this.mainBg, this.hDW, this.hDH, 3);
                var1.drawImage(this.townmapMainBg1, this.hDW, this.hDH, 3);
                if (this.townMapBase == 0) {
                    var1.drawImage(this.townmapPopupSchool, this.hDW - 11, this.hDH - 58, 3);
                } else if (this.townMapBase == 1) {
                    var1.drawImage(this.townmapPopupShop, this.hDW - 17, this.hDH - 14, 3);
                } else if (this.townMapBase == 2) {
                    var1.drawImage(this.townmapPopupTownHall, this.hDW + 37, this.hDH + 18, 3);
                }

                var1.drawImage(this.townmapMainArrRight, this.hDW + 105, this.hDH - 80, 3);
                var1.drawImage(this.padlockIcon, this.hDW + 100, this.hDH - 23, 3);
                if (this.townMapBase == 0) {
                    var1.drawImage(this.townmapWindowLarge, this.hDW, this.hDH + 90, 3);
                    var1.setColor(16777215);
                    var1.drawString("から始まる物語", this.hDW - 100, this.hDH + 64, 20);
                    var1.drawString("ここ！", this.hDW - 100, this.hDH + 91, 20);
                } else if (this.townMapBase == 1) {
                    var1.drawImage(this.townmapWindowLarge, this.hDW, this.hDH + 90, 3);
                    var1.setColor(16777215);
                    var1.drawString("この地図は利用でき", this.hDW - 100, this.hDH + 64, 20);
                    var1.drawString("ません。近日公開。", this.hDW - 100, this.hDH + 91, 20);
                } else if (this.townMapBase == 2) {
                    var1.drawImage(this.townmapWindowSmall, this.hDW, this.hDH + 100, 3);
                    var1.setColor(16777215);
                    var1.drawString("設定を変更します。", this.hDW - 100, this.hDH + 87, 20);
                }

                if (this.mainMenu) {
                    this.setSoftkeyText("♪ O", "戻る");
                } else {
                    this.setSoftkeyText("♪ X", "戻る");
                }

                if ((this.s & 1) != 0) {
                    if (this.sfxType == 1 || this.sfxType == 2) {
                        try {
                            ((VolumeControl)this.menuChoose.getControl("VolumeControl")).setLevel(this.b);
                            this.menuChoose.start();
                        } catch (Exception var92) {
                            var92.printStackTrace();
                        }
                    }

                    --this.townMapBase;
                    if (this.townMapBase < 0) {
                        this.townMapBase = 2;
                    }
                } else if ((this.s & 4) != 0) {
                    if (this.sfxType == 1 || this.sfxType == 2) {
                        try {
                            ((VolumeControl)this.menuChoose.getControl("VolumeControl")).setLevel(this.b);
                            this.menuChoose.start();
                        } catch (Exception var93) {
                            var93.printStackTrace();
                        }
                    }

                    ++this.townMapBase;
                    if (this.townMapBase > 2) {
                        this.townMapBase = 0;
                    }
                } else if ((this.s & 8) != 0) {
                    if (this.sfxType == 1 || this.sfxType == 2) {
                        try {
                            ((VolumeControl)this.menuChoose.getControl("VolumeControl")).setLevel(this.b);
                            this.menuChoose.start();
                        } catch (Exception var94) {
                            var94.printStackTrace();
                        }
                    }

                    this.TownmapSecondaryMap = true;
                    this.E = 95;
                } else if ((this.s & 16) == 0) {
                    if ((this.s & 32) != 0) {
                        if (this.mainMenu) {
                            this.mainMenu = false;
                            this.u();
                            this.i();
                        } else {
                            this.mainMenu = true;
                            this.u();
                            this.a(1);
                        }

                        this.E = 94;
                    } else if ((this.s & 64) != 0) {
                        if (this.debugModeFlag) {
                            if (this.mainMenu) {
                                this.i();
                            }

                            this.E = 70;
                        } else {
                            this.optionMenuBase2 = 0;
							this.fadeFlag = true;
                            this.fadeCode = 18;
                            this.E = 46;
                        }
                    }
                } else {
                    switch(this.townMapBase) {
                    case 0:
                        if (this.sfxType == 1 || this.sfxType == 2) {
                            try {
                                ((VolumeControl)this.menuSelect.getControl("VolumeControl")).setLevel(this.b);
                                this.menuSelect.start();
                            } catch (Exception var97) {
                                var97.printStackTrace();
                            }
                        }

                        if (this.mainMenu) {
                            this.i();
                        }

                        this.TownmapSinglePuyoPopEntraceFlag = true;
                        this.optionMenuBase2 = 0;
						this.fadeFlag = true;
                        this.fadeCode = 8;
                        this.E = 46;
                        break label4905;
                    case 1:
                        if (this.sfxType == 1 || this.sfxType == 2) {
                            try {
                                ((VolumeControl)this.menuUnavailable.getControl("VolumeControl")).setLevel(this.b);
                                this.menuUnavailable.start();
                            } catch (Exception var96) {
                                var96.printStackTrace();
                            }
                        }

                        this.E = 50;
                        break label4905;
                    case 2:
                        if (this.sfxType == 1 || this.sfxType == 2) {
                            try {
                                ((VolumeControl)this.menuSelect.getControl("VolumeControl")).setLevel(this.b);
                                this.menuSelect.start();
                            } catch (Exception var95) {
                                var95.printStackTrace();
                            }
                        }

                        this.optionMenuBase2 = 0;
						this.fadeFlag = true;
                        this.fadeCode = 9;
                        this.E = 46;
                    }
                }
                break;
            case 95:
                var1.setColor(0);
                var1.fillRect(this.hDW - 120, 30, 240, 260);
                var1.drawImage(this.mainBg, this.hDW, this.hDH, 3);
                var1.drawImage(this.townmapMainBg2, this.hDW, this.hDH, 3);
                if (this.townMapBase == 0) {
                    var1.drawImage(this.townmapPopupTower, this.hDW + 54, this.hDH - 54, 3);
                } else if (this.townMapBase == 1) {
                    var1.drawImage(this.townmapPopupMuseum, this.hDW + 39, this.hDH + 8, 3);
                } else if (this.townMapBase == 2) {
                    var1.drawImage(this.townmapPopupPlayground, this.hDW + 66, this.hDH + 29, 3);
                }

                var1.drawImage(this.townmapMainArrLeft, this.hDW - 67, this.hDH - 80, 3);
                var1.drawImage(this.padlockIcon, this.hDW - 68, this.hDH - 6, 3);
                if (this.townMapBase == 0) {
                    var1.drawImage(this.townmapWindowLarge, this.hDW, this.hDH + 90, 3);
                    var1.setColor(16777215);
                    var1.drawString("無限のゲームをプレイ", this.hDW - 100, this.hDH + 64, 20);
                    var1.drawString("モード。", this.hDW - 100, this.hDH + 91, 20);
                } else if (this.townMapBase == 1) {
                    var1.drawImage(this.townmapWindowLarge, this.hDW, this.hDH + 90, 3);
                    var1.setColor(16777215);
                    var1.drawString("この地図は利用でき", this.hDW - 100, this.hDH + 64, 20);
                    var1.drawString("ません。近日公開。", this.hDW - 100, this.hDH + 91, 20);
                } else if (this.townMapBase == 2) {
                    var1.drawImage(this.townmapWindowSmall, this.hDW, this.hDH + 100, 3);
                    var1.setColor(16777215);
                    var1.drawString("フリーバトルをプレイ。", this.hDW - 100, this.hDH + 87, 20);
                }

                if (this.mainMenu) {
                    this.setSoftkeyText("♪ O", "戻る");
                } else {
                    this.setSoftkeyText("♪ X", "戻る");
                }

                if ((this.s & 1) != 0) {
                    if (this.sfxType == 1 || this.sfxType == 2) {
                        try {
                            ((VolumeControl)this.menuChoose.getControl("VolumeControl")).setLevel(this.b);
                            this.menuChoose.start();
                        } catch (Exception var86) {
                            var86.printStackTrace();
                        }
                    }

                    --this.townMapBase;
                    if (this.townMapBase < 0) {
                        this.townMapBase = 2;
                    }
                } else if ((this.s & 2) != 0) {
                    if (this.sfxType == 1 || this.sfxType == 2) {
                        try {
                            ((VolumeControl)this.menuChoose.getControl("VolumeControl")).setLevel(this.b);
                            this.menuChoose.start();
                        } catch (Exception var87) {
                            var87.printStackTrace();
                        }
                    }

                    this.TownmapSecondaryMap = false;
                    this.E = 94;
                } else if ((this.s & 4) != 0) {
                    if (this.sfxType == 1 || this.sfxType == 2) {
                        try {
                            ((VolumeControl)this.menuChoose.getControl("VolumeControl")).setLevel(this.b);
                            this.menuChoose.start();
                        } catch (Exception var88) {
                            var88.printStackTrace();
                        }
                    }

                    ++this.townMapBase;
                    if (this.townMapBase > 2) {
                        this.townMapBase = 0;
                    }
                } else if ((this.s & 16) == 0) {
                    if ((this.s & 32) != 0) {
                        if (this.mainMenu) {
                            this.mainMenu = false;
                            this.u();
                            this.i();
                        } else {
                            this.mainMenu = true;
                            this.u();
                            this.a(1);
                        }

                        this.E = 95;
                    } else if ((this.s & 64) != 0) {
                        if (this.debugModeFlag) {
                            if (this.mainMenu) {
                                this.i();
                            }

                            this.E = 70;
                        } else {
                            this.optionMenuBase2 = 0;
							this.fadeFlag = true;
                            this.fadeCode = 18;
                            this.E = 46;
                        }
                    }
                } else {
                    switch(this.townMapBase) {
                    case 0:
                        if (this.sfxType == 1 || this.sfxType == 2) {
                            try {
                                ((VolumeControl)this.menuSelect.getControl("VolumeControl")).setLevel(this.b);
                                this.menuSelect.start();
                            } catch (Exception var91) {
                                var91.printStackTrace();
                            }
                        }

                        this.optionMenuBase2 = 0;
						this.fadeFlag = true;
                        this.fadeCode = 10;
                        this.E = 46;
                        break label4905;
                    case 1:
                        if (this.sfxType == 1 || this.sfxType == 2) {
                            try {
                                ((VolumeControl)this.menuUnavailable.getControl("VolumeControl")).setLevel(this.b);
                                this.menuUnavailable.start();
                            } catch (Exception var90) {
                                var90.printStackTrace();
                            }
                        }
						
                        this.E = 50;
                        break label4905;
                    case 2:
                        if (this.sfxType == 1 || this.sfxType == 2) {
                            try {
                                ((VolumeControl)this.menuSelect.getControl("VolumeControl")).setLevel(this.b);
                                this.menuSelect.start();
                            } catch (Exception var89) {
                                var89.printStackTrace();
                            }
                        }

                        this.optionMenuBase2 = 0;
						this.fadeFlag = true;
                        this.fadeCode = 11;
                        this.E = 46;
                    }
                }
                break;
            case 96:
                var1.setColor(0);
                var1.fillRect(this.hDW - 120, 30, 240, 260);
                var1.drawImage(this.mainBg, this.hDW, this.hDH, 3);
                var1.drawImage(this.townmapSchoolBgAkr, this.hDW, this.hDH, 3);
                var1.drawImage(this.townmapMsgWindow, this.hDW, this.hDH + 76, 3);
                var1.drawImage(this.townmapBar, this.hDW - 129, this.hDH - 74, 3);
                var1.drawImage(this.townmapBar, this.hDW - 129, this.hDH - 47, 3);
                if (this.townMapMenuBase == 0) {
                    var1.drawImage(this.townmapBarHigh, this.hDW - 121, this.hDH - 74, 3);
                } else if (this.townMapMenuBase == 1) {
                    var1.drawImage(this.townmapBarHigh, this.hDW - 121, this.hDH - 47, 3);
                }

                var1.setColor(6440844);
                var1.drawString("ひとりでぶよぶよ", this.hDW + 1, this.hDH - 87, 24);
                var1.drawString("ひとりでぶよぶよ", this.hDW + 4, this.hDH - 87, 24);
                var1.drawString("ひとりでぶよぶよ", this.hDW + 2, this.hDH - 88, 24);
                var1.drawString("ひとりでぶよぶよ", this.hDW + 2, this.hDH - 86, 24);
                var1.drawString("ひとりでぶよぶよ", this.hDW + 4, this.hDH - 85, 24);
                var1.drawString("ひとりでぶよぶよ", this.hDW + 3, this.hDH - 85, 24);
                var1.setColor(16777215);
                var1.drawString("ひとりでぶよぶよ", this.hDW + 2, this.hDH - 87, 24);
                var1.setColor(6440844);
                var1.drawString("ルールせつめい", this.hDW + 1, this.hDH - 60, 24);
                var1.drawString("ルールせつめい", this.hDW + 4, this.hDH - 60, 24);
                var1.drawString("ルールせつめい", this.hDW + 2, this.hDH - 61, 24);
                var1.drawString("ルールせつめい", this.hDW + 2, this.hDH - 59, 24);
                var1.drawString("ルールせつめい", this.hDW + 4, this.hDH - 58, 24);
                var1.drawString("ルールせつめい", this.hDW + 3, this.hDH - 58, 24);
                var1.setColor(16777215);
                var1.drawString("ルールせつめい", this.hDW + 2, this.hDH - 60, 24);
                if (this.townMapMenuBase == 0) {
                    var1.setColor(16777215);
                    var1.drawString("アコール", this.hDW - 106, this.hDH + 31, 20);
                    var1.drawString("通して勉強できます", this.hDW - 91, this.hDH + 55, 20);
                    var1.drawString("との冒険", this.hDW - 91, this.hDH + 76, 20);
                    var1.drawString("先生と友達。", this.hDW - 91, this.hDH + 97, 20);
                } else if (this.townMapMenuBase == 1) {
                    var1.setColor(16777215);
                    var1.drawString("アコール", this.hDW - 106, this.hDH + 31, 20);
                    var1.drawString("ここで勉強できます", this.hDW - 91, this.hDH + 55, 20);
                    var1.drawString("遊び方", this.hDW - 91, this.hDH + 76, 20);
                    var1.drawString("ぷよぷよフィーバー。", this.hDW - 91, this.hDH + 97, 20);
                }

                this.setSoftkeyText("", "戻る");
                if ((this.s & 1) != 0) {
                    if (this.sfxType == 1 || this.sfxType == 2) {
                        try {
                            ((VolumeControl)this.menuChoose.getControl("VolumeControl")).setLevel(this.b);
                            this.menuChoose.start();
                        } catch (Exception var82) {
                            var82.printStackTrace();
                        }
                    }

                    --this.townMapMenuBase;
                    if (this.townMapMenuBase < 0) {
                        this.townMapMenuBase = 1;
                    }
                } else if ((this.s & 4) != 0) {
                    if (this.sfxType == 1 || this.sfxType == 2) {
                        try {
                            ((VolumeControl)this.menuChoose.getControl("VolumeControl")).setLevel(this.b);
                            this.menuChoose.start();
                        } catch (Exception var83) {
                            var83.printStackTrace();
                        }
                    }

                    ++this.townMapMenuBase;
                    if (this.townMapMenuBase > 1) {
                        this.townMapMenuBase = 0;
                    }
                } else if ((this.s & 16) != 0) {
                    if (this.sfxType == 1 || this.sfxType == 2) {
                        try {
                            ((VolumeControl)this.menuSelect.getControl("VolumeControl")).setLevel(this.b);
                            this.menuSelect.start();
                        } catch (Exception var84) {
                            var84.printStackTrace();
                        }
                    }

                    switch(this.townMapMenuBase) {
                    case 0:
                        this.optionMenuBase2 = 0;
						this.fadeFlag = true;
                        this.fadeCode = 14;
                        this.E = 46;
                        break label4905;
                    case 1:
                        this.optionMenuBase2 = 0;
						this.fadeFlag = true;
                        this.fadeCode = 16;
                        this.E = 46;
                    }
                } else {
                    if ((this.s & 64) == 0) {
                        break;
                    }

                    if (this.sfxType == 1 || this.sfxType == 2) {
                        try {
                            ((VolumeControl)this.menuBack.getControl("VolumeControl")).setLevel(this.b);
                            this.menuBack.start();
                        } catch (Exception var85) {
                            var85.printStackTrace();
                        }
                    }

                    if (this.mainMenu) {
                        this.i();
                    }

                    this.TownmapSinglePuyoPopEntraceFlag = true;
                    this.optionMenuBase2 = 0;
                    this.townMapMenuBase = 0;
					this.fadeFlag = true;
                    this.fadeCode = 12;
                    this.E = 46;
                }
                break;
            case 97:
                var1.setColor(0);
                var1.fillRect(this.hDW - 120, 30, 240, 260);
                var1.drawImage(this.mainBg, this.hDW, this.hDH, 3);
                var1.drawImage(this.townmapTownHallBgRei, this.hDW, this.hDH, 3);
                var1.drawImage(this.townmapMsgWindow, this.hDW, this.hDH + 76, 3);
                var1.drawImage(this.townmapBar, this.hDW - 129, this.hDH - 74, 3);
                var1.drawImage(this.townmapBar, this.hDW - 129, this.hDH - 47, 3);
                var1.drawImage(this.townmapBar, this.hDW - 129, this.hDH - 20, 3);
                var1.drawImage(this.townmapBar, this.hDW - 129, this.hDH + 7, 3);
                if (this.townMapMenuBase == 0) {
                    var1.drawImage(this.townmapBarHigh, this.hDW - 121, this.hDH - 74, 3);
                } else if (this.townMapMenuBase == 1) {
                    var1.drawImage(this.townmapBarHigh, this.hDW - 121, this.hDH - 47, 3);
                } else if (this.townMapMenuBase == 2) {
                    var1.drawImage(this.townmapBarHigh, this.hDW - 121, this.hDH - 20, 3);
                } else if (this.townMapMenuBase == 3) {
                    var1.drawImage(this.townmapBarHigh, this.hDW - 121, this.hDH + 7, 3);
                }

                var1.drawImage(this.padlockIcon, this.hDW - 107, this.hDH - 20, 3);
                var1.drawImage(this.padlockIcon, this.hDW - 107, this.hDH + 7, 3);
                var1.setColor(6440844);
                var1.drawString("オプション", this.hDW + 1, this.hDH - 87, 24);
                var1.drawString("オプション", this.hDW + 4, this.hDH - 87, 24);
                var1.drawString("オプション", this.hDW + 2, this.hDH - 88, 24);
                var1.drawString("オプション", this.hDW + 2, this.hDH - 86, 24);
                var1.drawString("オプション", this.hDW + 4, this.hDH - 85, 24);
                var1.drawString("オプション", this.hDW + 3, this.hDH - 85, 24);
                var1.setColor(16777215);
                var1.drawString("オプション", this.hDW + 2, this.hDH - 87, 24);
                var1.setColor(6440844);
                var1.drawString("ランキング", this.hDW + 1, this.hDH - 60, 24);
                var1.drawString("ランキング", this.hDW + 4, this.hDH - 60, 24);
                var1.drawString("ランキング", this.hDW + 2, this.hDH - 61, 24);
                var1.drawString("ランキング", this.hDW + 2, this.hDH - 59, 24);
                var1.drawString("ランキング", this.hDW + 4, this.hDH - 58, 24);
                var1.drawString("ランキング", this.hDW + 3, this.hDH - 58, 24);
                var1.setColor(16777215);
                var1.drawString("ランキング", this.hDW + 2, this.hDH - 60, 24);
                var1.setColor(7237230);
                var1.drawString("エクストラ", this.hDW + 1, this.hDH - 33, 24);
                var1.drawString("エクストラ", this.hDW + 4, this.hDH - 33, 24);
                var1.drawString("エクストラ", this.hDW + 2, this.hDH - 34, 24);
                var1.drawString("エクストラ", this.hDW + 2, this.hDH - 32, 24);
                var1.drawString("エクストラ", this.hDW + 4, this.hDH - 31, 24);
                var1.drawString("エクストラ", this.hDW + 3, this.hDH - 31, 24);
                var1.setColor(16777215);
                var1.drawString("エクストラ", this.hDW + 2, this.hDH - 33, 24);
                var1.setColor(7237230);
                var1.drawString("クレジット", this.hDW + 1, this.hDH - 6, 24);
                var1.drawString("クレジット", this.hDW + 4, this.hDH - 6, 24);
                var1.drawString("クレジット", this.hDW + 2, this.hDH - 7, 24);
                var1.drawString("クレジット", this.hDW + 2, this.hDH - 5, 24);
                var1.drawString("クレジット", this.hDW + 4, this.hDH - 4, 24);
                var1.drawString("クレジット", this.hDW + 3, this.hDH - 4, 24);
                var1.setColor(16777215);
                var1.drawString("クレジット", this.hDW + 2, this.hDH - 6, 24);
                if (this.townMapMenuBase == 0) {
                    var1.setColor(16777215);
                    var1.drawString("レイくん", this.hDW - 106, this.hDH + 31, 20);
                    var1.drawString("ここで変更できます", this.hDW - 91, this.hDH + 55, 20);
                    var1.drawString("ゲームの設定。", this.hDW - 91, this.hDH + 76, 20);
                    var1.drawString("", this.hDW - 91, this.hDH + 97, 20);
                } else if (this.townMapMenuBase == 1) {
                    var1.setColor(16777215);
                    var1.drawString("レイくん", this.hDW - 106, this.hDH + 31, 20);
                    var1.drawString("ここで見ることができます", this.hDW - 91, this.hDH + 55, 20);
                    var1.drawString("のスコアランキング", this.hDW - 91, this.hDH + 76, 20);
                    var1.drawString("各モード。", this.hDW - 91, this.hDH + 97, 20);
                } else if (this.townMapMenuBase == 2) {
                    var1.setColor(16777215);
                    var1.drawString("レイくん", this.hDW - 106, this.hDH + 31, 20);
                    var1.drawString("ここで見ることができます", this.hDW - 91, this.hDH + 55, 20);
                    var1.drawString("追加モード。", this.hDW - 91, this.hDH + 76, 20);
                    var1.drawString("", this.hDW - 91, this.hDH + 97, 20);
                } else if (this.townMapMenuBase == 3) {
                    var1.setColor(16777215);
                    var1.drawString("レイくん", this.hDW - 106, this.hDH + 31, 20);
                    var1.drawString("ここで見ることができます", this.hDW - 91, this.hDH + 55, 20);
                    var1.drawString("スタッフクレジット。", this.hDW - 91, this.hDH + 76, 20);
                    var1.drawString("", this.hDW - 91, this.hDH + 97, 20);
                }

                this.setSoftkeyText("", "戻る");
                if ((this.s & 1) != 0) {
                    if (this.sfxType == 1 || this.sfxType == 2) {
                        try {
                            ((VolumeControl)this.menuChoose.getControl("VolumeControl")).setLevel(this.b);
                            this.menuChoose.start();
                        } catch (Exception var75) {
                            var75.printStackTrace();
                        }
                    }

                    --this.townMapMenuBase;
                    if (this.townMapMenuBase < 0) {
                        this.townMapMenuBase = 3;
                    }
                } else if ((this.s & 4) != 0) {
                    if (this.sfxType == 1 || this.sfxType == 2) {
                        try {
                            ((VolumeControl)this.menuChoose.getControl("VolumeControl")).setLevel(this.b);
                            this.menuChoose.start();
                        } catch (Exception var76) {
                            var76.printStackTrace();
                        }
                    }

                    ++this.townMapMenuBase;
                    if (this.townMapMenuBase > 3) {
                        this.townMapMenuBase = 0;
                    }
                } else if ((this.s & 16) != 0) {
                    switch(this.townMapMenuBase) {
                    case 0:
                        if (this.sfxType == 1 || this.sfxType == 2) {
                            try {
                                ((VolumeControl)this.menuSelect.getControl("VolumeControl")).setLevel(this.b);
                                this.menuSelect.start();
                            } catch (Exception var80) {
                                var80.printStackTrace();
                            }
                        }

                        this.optionMenuBase2 = 0;
						this.fadeFlag = true;
                        this.fadeCode = 15;
                        this.E = 46;
                        break label4905;
                    case 1:
                        if (this.sfxType == 1 || this.sfxType == 2) {
                            try {
                                ((VolumeControl)this.menuSelect.getControl("VolumeControl")).setLevel(this.b);
                                this.menuSelect.start();
                            } catch (Exception var79) {
                                var79.printStackTrace();
                            }
                        }

                        this.optionMenuBase2 = 0;
						this.fadeFlag = true;
                        this.fadeCode = 17;
                        this.E = 46;
                        break label4905;
                    case 2:
                        if (this.sfxType == 1 || this.sfxType == 2) {
                            try {
                                ((VolumeControl)this.menuUnavailable.getControl("VolumeControl")).setLevel(this.b);
                                this.menuUnavailable.start();
                            } catch (Exception var78) {
                                var78.printStackTrace();
                            }
                        }

                        this.E = 51;
                        break label4905;
                    case 3:
                        if (this.sfxType == 1 || this.sfxType == 2) {
                            try {
                                ((VolumeControl)this.menuUnavailable.getControl("VolumeControl")).setLevel(this.b);
                                this.menuUnavailable.start();
                            } catch (Exception var77) {
                                var77.printStackTrace();
                            }
                        }
						
                        this.E = 51;
                    }
                } else {
                    if ((this.s & 64) == 0) {
                        break;
                    }

                    if (this.sfxType == 1 || this.sfxType == 2) {
                        try {
                            ((VolumeControl)this.menuBack.getControl("VolumeControl")).setLevel(this.b);
                            this.menuBack.start();
                        } catch (Exception var81) {
                            var81.printStackTrace();
                        }
                    }

                    this.optionMenuBase2 = 0;
                    this.townMapMenuBase = 0;
					this.fadeFlag = true;
                    this.fadeCode = 12;
                    this.E = 46;
                }
                break;
            case 98:
                var1.setColor(0);
                var1.fillRect(this.hDW - 120, 30, 240, 260);
                var1.drawImage(this.mainBg, this.hDW, this.hDH, 3);
                var1.drawImage(this.townmapTowerBgHhd, this.hDW, this.hDH, 3);
                var1.drawImage(this.townmapMsgWindow, this.hDW, this.hDH + 76, 3);
                var1.drawImage(this.townmapBar, this.hDW - 129, this.hDH - 74, 3);
                var1.drawImage(this.townmapBar, this.hDW - 129, this.hDH - 47, 3);
                var1.drawImage(this.townmapBar, this.hDW - 129, this.hDH - 20, 3);
                if (this.townMapMenuBase == 0) {
                    var1.drawImage(this.townmapBarHigh, this.hDW - 121, this.hDH - 74, 3);
                } else if (this.townMapMenuBase == 1) {
                    var1.drawImage(this.townmapBarHigh, this.hDW - 121, this.hDH - 47, 3);
                } else if (this.townMapMenuBase == 2) {
                    var1.drawImage(this.townmapBarHigh, this.hDW - 121, this.hDH - 20, 3);
                }

                var1.setColor(6440844);
                var1.drawString("とことんフィーバー", this.hDW + 1, this.hDH - 87, 24);
                var1.drawString("とことんフィーバー", this.hDW + 4, this.hDH - 87, 24);
                var1.drawString("とことんフィーバー", this.hDW + 2, this.hDH - 88, 24);
                var1.drawString("とことんフィーバー", this.hDW + 2, this.hDH - 86, 24);
                var1.drawString("とことんフィーバー", this.hDW + 4, this.hDH - 85, 24);
                var1.drawString("とことんフィーバー", this.hDW + 3, this.hDH - 85, 24);
                var1.setColor(16777215);
                var1.drawString("とことんフィーバー", this.hDW + 2, this.hDH - 87, 24);
                var1.setColor(7237230);
                var1.drawString("とことんタスク", this.hDW + 1, this.hDH - 60, 24);
                var1.drawString("とことんタスク", this.hDW + 4, this.hDH - 60, 24);
                var1.drawString("とことんタスク", this.hDW + 2, this.hDH - 61, 24);
                var1.drawString("とことんタスク", this.hDW + 2, this.hDH - 59, 24);
                var1.drawString("とことんタスク", this.hDW + 4, this.hDH - 58, 24);
                var1.drawString("とことんタスク", this.hDW + 3, this.hDH - 58, 24);
                var1.setColor(16777215);
                var1.drawString("とことんタスク", this.hDW + 2, this.hDH - 60, 24);
                var1.setColor(7237230);
                var1.drawString("とことんぷよぷよ", this.hDW + 1, this.hDH - 33, 24);
                var1.drawString("とことんぷよぷよ", this.hDW + 4, this.hDH - 33, 24);
                var1.drawString("とことんぷよぷよ", this.hDW + 2, this.hDH - 34, 24);
                var1.drawString("とことんぷよぷよ", this.hDW + 2, this.hDH - 32, 24);
                var1.drawString("とことんぷよぷよ", this.hDW + 4, this.hDH - 31, 24);
                var1.drawString("とことんぷよぷよ", this.hDW + 3, this.hDH - 31, 24);
                var1.setColor(16777215);
                var1.drawString("とことんぷよぷよ", this.hDW + 2, this.hDH - 33, 24);
				
                var1.drawImage(this.padlockIcon, this.hDW - 107, this.hDH - 47, 3);
                var1.drawImage(this.padlockIcon, this.hDW - 107, this.hDH - 20, 3);
				
                if (this.townMapMenuBase == 0) {
                    var1.setColor(16777215);
                    var1.drawString("Hhw. Bird", this.hDW - 106, this.hDH + 31, 20);
                    var1.drawString("エンドレスフィーバーをプレイ", this.hDW - 91, this.hDH + 55, 20);
                    var1.drawString("制限時間内に！", this.hDW - 91, this.hDH + 76, 20);
                    var1.drawString("", this.hDW - 91, this.hDH + 97, 20);
                } else if (this.townMapMenuBase == 1) {
                    var1.setColor(16777215);
                    var1.drawString("Hhw. Bird", this.hDW - 106, this.hDH + 31, 20);
                    var1.drawString("\"タスクぷよ\"！", this.hDW - 91, this.hDH + 55, 20);
                    var1.drawString("どこまで解けるか", this.hDW - 91, this.hDH + 76, 20);
                    var1.drawString("制限時間内？", this.hDW - 91, this.hDH + 97, 20);
                } else if (this.townMapMenuBase == 2) {
                    var1.setColor(16777215);
                    var1.drawString("Hhw. Bird", this.hDW - 106, this.hDH + 31, 20);
                    var1.drawString("とことんぷよぷよ！", this.hDW - 91, this.hDH + 55, 20);
                    var1.drawString("ぴょんぴょんぴょんぴょんぷよぷよ", this.hDW - 91, this.hDH + 76, 20);
                    var1.drawString("できなくなるまで！", this.hDW - 91, this.hDH + 97, 20);
                }

                this.setSoftkeyText("", "戻る");
                if ((this.s & 1) != 0) {
                    if (this.sfxType == 1 || this.sfxType == 2) {
                        try {
                            ((VolumeControl)this.menuChoose.getControl("VolumeControl")).setLevel(this.b);
                            this.menuChoose.start();
                        } catch (Exception var69) {
                            var69.printStackTrace();
                        }
                    }

                    --this.townMapMenuBase;
                    if (this.townMapMenuBase < 0) {
                        this.townMapMenuBase = 2;
                    }
                } else if ((this.s & 4) != 0) {
                    if (this.sfxType == 1 || this.sfxType == 2) {
                        try {
                            ((VolumeControl)this.menuChoose.getControl("VolumeControl")).setLevel(this.b);
                            this.menuChoose.start();
                        } catch (Exception var70) {
                            var70.printStackTrace();
                        }
                    }

                    ++this.townMapMenuBase;
                    if (this.townMapMenuBase > 2) {
                        this.townMapMenuBase = 0;
                    }
                } else if ((this.s & 16) != 0) {
                    switch(this.townMapMenuBase) {
                    case 0:
                        if (this.sfxType == 1 || this.sfxType == 2) {
                            try {
                                ((VolumeControl)this.menuSelect.getControl("VolumeControl")).setLevel(this.b);
                                this.menuSelect.start();
                            } catch (Exception var73) {
                                var73.printStackTrace();
                            }
                        }

                        this.optionMenuBase2 = 0;
						this.fadeFlag = true;
                        this.fadeCode = 6;
                        this.E = 46;
                        break label4905;
                    case 1:
                        if (this.sfxType == 1 || this.sfxType == 2) {
                            try {
                                ((VolumeControl)this.menuUnavailable.getControl("VolumeControl")).setLevel(this.b);
                                this.menuUnavailable.start();
                            } catch (Exception var72) {
                                var72.printStackTrace();
                            }
                        }
					
                        this.E = 52;
                        break label4905;
                    case 2:
                        if (this.sfxType == 1 || this.sfxType == 2) {
                            try {
                                ((VolumeControl)this.menuUnavailable.getControl("VolumeControl")).setLevel(this.b);
                                this.menuUnavailable.start();
                            } catch (Exception var72) {
                                var72.printStackTrace();
                            }
                        }

                        this.E = 53;
                    }
                } else {
                    if ((this.s & 64) == 0) {
                        break;
                    }

                    if (this.sfxType == 1 || this.sfxType == 2) {
                        try {
                            ((VolumeControl)this.menuBack.getControl("VolumeControl")).setLevel(this.b);
                            this.menuBack.start();
                        } catch (Exception var74) {
                            var74.printStackTrace();
                        }
                    }

                    this.optionMenuBase2 = 0;
                    this.townMapMenuBase = 0;
					this.fadeFlag = true;
                    this.fadeCode = 13;
                    this.E = 46;
                }
                break;
            case 99:
                var1.setColor(0);
                var1.fillRect(this.hDW - 120, 30, 240, 260);
                var1.drawImage(this.mainBg, this.hDW, this.hDH, 3);
                var1.drawImage(this.townmapPlaygroundBgArr, this.hDW, this.hDH, 3);
                var1.drawImage(this.townmapMsgWindow, this.hDW, this.hDH + 76, 3);
                var1.drawImage(this.townmapBar, this.hDW - 129, this.hDH - 74, 3);
                var1.drawImage(this.townmapBar, this.hDW - 129, this.hDH - 47, 3);
                var1.drawImage(this.townmapBar, this.hDW - 129, this.hDH - 20, 3);
                if (this.townMapMenuBase == 0) {
                    var1.drawImage(this.townmapBarHigh, this.hDW - 121, this.hDH - 74, 3);
                } else if (this.townMapMenuBase == 1) {
                    var1.drawImage(this.townmapBarHigh, this.hDW - 121, this.hDH - 47, 3);
                } else if (this.townMapMenuBase == 2) {
                    var1.drawImage(this.townmapBarHigh, this.hDW - 121, this.hDH - 20, 3);
                }

                var1.drawImage(this.padlockIcon, this.hDW - 107, this.hDH - 74, 3);
                var1.drawImage(this.padlockIcon, this.hDW - 107, this.hDH - 47, 3);
                var1.drawImage(this.padlockIcon, this.hDW - 107, this.hDH - 20, 3);
                var1.setColor(7237230);
                var1.drawString("無料プレイ", this.hDW + 1, this.hDH - 87, 24);
                var1.drawString("無料プレイ", this.hDW + 4, this.hDH - 87, 24);
                var1.drawString("無料プレイ", this.hDW + 2, this.hDH - 88, 24);
                var1.drawString("無料プレイ", this.hDW + 2, this.hDH - 86, 24);
                var1.drawString("無料プレイ", this.hDW + 4, this.hDH - 85, 24);
                var1.drawString("無料プレイ", this.hDW + 3, this.hDH - 85, 24);
                var1.setColor(16777215);
                var1.drawString("無料プレイ", this.hDW + 2, this.hDH - 87, 24);
                var1.setColor(7237230);
                var1.drawString("みんなぷよぷよ", this.hDW + 1, this.hDH - 60, 24);
                var1.drawString("みんなぷよぷよ", this.hDW + 4, this.hDH - 60, 24);
                var1.drawString("みんなぷよぷよ", this.hDW + 2, this.hDH - 61, 24);
                var1.drawString("みんなぷよぷよ", this.hDW + 2, this.hDH - 59, 24);
                var1.drawString("みんなぷよぷよ", this.hDW + 4, this.hDH - 58, 24);
                var1.drawString("みんなぷよぷよ", this.hDW + 3, this.hDH - 58, 24);
                var1.setColor(16777215);
                var1.drawString("みんなぷよぷよ", this.hDW + 2, this.hDH - 60, 24);
                var1.setColor(7237230);
                var1.drawString("インターネット", this.hDW + 1, this.hDH - 33, 24);
                var1.drawString("インターネット", this.hDW + 4, this.hDH - 33, 24);
                var1.drawString("インターネット", this.hDW + 2, this.hDH - 34, 24);
                var1.drawString("インターネット", this.hDW + 2, this.hDH - 32, 24);
                var1.drawString("インターネット", this.hDW + 4, this.hDH - 31, 24);
                var1.drawString("インターネット", this.hDW + 3, this.hDH - 31, 24);
                var1.setColor(16777215);
                var1.drawString("インターネット", this.hDW + 2, this.hDH - 33, 24);
                if (this.townMapMenuBase == 0) {
                    var1.setColor(16777215);
                    var1.drawString("アルル", this.hDW - 106, this.hDH + 31, 20);
                    var1.drawString("任意の相手と対戦する", this.hDW - 91, this.hDH + 55, 20);
                    var1.drawString("好きな相手。", this.hDW - 91, this.hDH + 76, 20);
                    var1.drawString("", this.hDW - 91, this.hDH + 97, 20);
                } else if (this.townMapMenuBase == 1) {
                    var1.setColor(16777215);
                    var1.drawString("アルル", this.hDW - 106, this.hDH + 31, 20);
                    var1.drawString("2 プレイヤー マッチをプレイする", this.hDW - 91, this.hDH + 55, 20);
                    var1.drawString("あなたの友達と", this.hDW - 91, this.hDH + 76, 20);
                    var1.drawString("Bluetooth™の使用", this.hDW - 91, this.hDH + 97, 20);
                } else if (this.townMapMenuBase == 2) {
                    var1.setColor(16777215);
                    var1.drawString("アルル", this.hDW - 106, this.hDH + 31, 20);
                    var1.drawString("と試合をする", this.hDW - 91, this.hDH + 55, 20);
                    var1.drawString("友達がオンライン。", this.hDW - 91, this.hDH + 76, 20);
                    var1.drawString("", this.hDW - 91, this.hDH + 97, 20);
                }

                this.setSoftkeyText("", "戻る");
                if ((this.s & 1) != 0) {
                    if (this.sfxType == 1 || this.sfxType == 2) {
                        try {
                            ((VolumeControl)this.menuChoose.getControl("VolumeControl")).setLevel(this.b);
                            this.menuChoose.start();
                        } catch (Exception var63) {
                            var63.printStackTrace();
                        }
                    }

                    --this.townMapMenuBase;
                    if (this.townMapMenuBase < 0) {
                        this.townMapMenuBase = 2;
                    }
                } else if ((this.s & 4) != 0) {
                    if (this.sfxType == 1 || this.sfxType == 2) {
                        try {
                            ((VolumeControl)this.menuChoose.getControl("VolumeControl")).setLevel(this.b);
                            this.menuChoose.start();
                        } catch (Exception var64) {
                            var64.printStackTrace();
                        }
                    }

                    ++this.townMapMenuBase;
                    if (this.townMapMenuBase > 2) {
                        this.townMapMenuBase = 0;
                    }
                } else if ((this.s & 16) != 0) {
                    switch(this.townMapMenuBase) {
                    case 0:
                        if (this.sfxType == 1 || this.sfxType == 2) {
                            try {
                                ((VolumeControl)this.menuUnavailable.getControl("VolumeControl")).setLevel(this.b);
                                this.menuUnavailable.start();
                            } catch (Exception var67) {
                                var67.printStackTrace();
                            }
                        }

                        this.E = 55;
                        break label4905;
                    case 1:
                        if (this.sfxType == 1 || this.sfxType == 2) {
                            try {
                                ((VolumeControl)this.menuUnavailable.getControl("VolumeControl")).setLevel(this.b);
                                this.menuUnavailable.start();
                            } catch (Exception var66) {
                                var66.printStackTrace();
                            }
                        }
						
                        this.E = 54;
                        break label4905;
                    case 2:
                        if (this.sfxType == 1 || this.sfxType == 2) {
                            try {
                                ((VolumeControl)this.menuUnavailable.getControl("VolumeControl")).setLevel(this.b);
                                this.menuUnavailable.start();
                            } catch (Exception var65) {
                                var65.printStackTrace();
                            }
                        }
						
                        this.E = 54;
                    }
                } else {
                    if ((this.s & 64) == 0) {
                        break;
                    }

                    if (this.sfxType == 1 || this.sfxType == 2) {
                        try {
                            ((VolumeControl)this.menuBack.getControl("VolumeControl")).setLevel(this.b);
                            this.menuBack.start();
                        } catch (Exception var68) {
                            var68.printStackTrace();
                        }
                    }

                    this.optionMenuBase2 = 0;
                    this.townMapMenuBase = 0;
					this.fadeFlag = true;
                    this.fadeCode = 13;
                    this.E = 46;
                }
                break;
            case 100:
                var1.setColor(0);
                var1.fillRect(this.hDW - 120, 30, 240, 260);
                var1.drawImage(this.mainBg, this.hDW, this.hDH, 3);
                var1.drawImage(this.townmapOptionBg, this.hDW, this.hDH, 3);
                var1.drawImage(this.townmapWindowLarge, this.hDW, this.hDH + 90, 3);
                var1.drawImage(this.townmapBar, this.hDW - 129, this.hDH - 74, 3);
                var1.drawImage(this.townmapBar, this.hDW - 129, this.hDH - 47, 3);
                var1.drawImage(this.townmapBar, this.hDW - 129, this.hDH - 20, 3);
                var1.drawImage(this.townmapBar, this.hDW - 129, this.hDH + 7, 3);
                var1.drawImage(this.townmapBar, this.hDW - 129, this.hDH + 34, 3);

                if (this.townMapOptionBase1 == 0) {
                    var1.drawImage(this.townmapBarHigh, this.hDW - 121, this.hDH - 74, 3);
                } else if (this.townMapOptionBase1 == 1) {
                    var1.drawImage(this.townmapBarHigh, this.hDW - 121, this.hDH - 47, 3);
                } else if (this.townMapOptionBase1 == 2) {
                    var1.drawImage(this.townmapBarHigh, this.hDW - 121, this.hDH - 20, 3);
                } else if (this.townMapOptionBase1 == 3) {
                    var1.drawImage(this.townmapBarHigh, this.hDW - 121, this.hDH + 7, 3);
                } else if (this.townMapOptionBase1 == 4) {
                    var1.drawImage(this.townmapBarHigh, this.hDW - 121, this.hDH + 34, 3);
                }
				
                var1.setColor(6440844);
                var1.drawString("ゲームプレイ", this.hDW + 1, this.hDH - 87, 24);
                var1.drawString("ゲームプレイ", this.hDW + 4, this.hDH - 87, 24);
                var1.drawString("ゲームプレイ", this.hDW + 2, this.hDH - 88, 24);
                var1.drawString("ゲームプレイ", this.hDW + 2, this.hDH - 86, 24);
                var1.drawString("ゲームプレイ", this.hDW + 4, this.hDH - 85, 24);
                var1.drawString("ゲームプレイ", this.hDW + 3, this.hDH - 85, 24);
                var1.setColor(16777215);
                var1.drawString("ゲームプレイ", this.hDW + 2, this.hDH - 87, 24);
                var1.setColor(6440844);
                var1.drawString("困難", this.hDW + 1, this.hDH - 60, 24);
                var1.drawString("困難", this.hDW + 4, this.hDH - 60, 24);
                var1.drawString("困難", this.hDW + 2, this.hDH - 61, 24);
                var1.drawString("困難", this.hDW + 2, this.hDH - 59, 24);
                var1.drawString("困難", this.hDW + 4, this.hDH - 58, 24);
                var1.drawString("困難", this.hDW + 3, this.hDH - 58, 24);
                var1.setColor(16777215);
                var1.drawString("困難", this.hDW + 2, this.hDH - 60, 24);
                var1.setColor(6440844);
                var1.drawString("サウンド", this.hDW + 1, this.hDH - 33, 24);
                var1.drawString("サウンド", this.hDW + 4, this.hDH - 33, 24);
                var1.drawString("サウンド", this.hDW + 2, this.hDH - 34, 24);
                var1.drawString("サウンド", this.hDW + 2, this.hDH - 32, 24);
                var1.drawString("サウンド", this.hDW + 4, this.hDH - 31, 24);
                var1.drawString("サウンド", this.hDW + 3, this.hDH - 31, 24);
                var1.setColor(16777215);
                var1.drawString("サウンド", this.hDW + 2, this.hDH - 33, 24);
                var1.setColor(6440844);
                var1.drawString("ぷよ", this.hDW + 1, this.hDH - 6, 24);
                var1.drawString("ぷよ", this.hDW + 4, this.hDH - 6, 24);
                var1.drawString("ぷよ", this.hDW + 2, this.hDH - 7, 24);
                var1.drawString("ぷよ", this.hDW + 2, this.hDH - 5, 24);
                var1.drawString("ぷよ", this.hDW + 4, this.hDH - 4, 24);
                var1.drawString("ぷよ", this.hDW + 3, this.hDH - 4, 24);
                var1.setColor(16777215);
                var1.drawString("ぷよ", this.hDW + 2, this.hDH - 6, 24);
                var1.setColor(6440844);
                var1.drawString("について", this.hDW + 1, this.hDH + 21, 24);
                var1.drawString("について", this.hDW + 4, this.hDH + 21, 24);
                var1.drawString("について", this.hDW + 2, this.hDH + 20, 24);
                var1.drawString("について", this.hDW + 2, this.hDH + 22, 24);
                var1.drawString("について", this.hDW + 4, this.hDH + 23, 24);
                var1.drawString("について", this.hDW + 3, this.hDH + 23, 24);
                var1.setColor(16777215);
                var1.drawString("について", this.hDW + 2, this.hDH + 21, 24);

                if (this.townMapOptionBase1 == 0) {
                    var1.setColor(16777215);
                    var1.drawString("変更", this.hDW - 100, this.hDH + 64, 20);
                    var1.drawString("ゲームの設定。", this.hDW - 100, this.hDH + 91, 20);
                } else if (this.townMapOptionBase1 == 1) {
                    var1.setColor(16777215);
                    var1.drawString("変更", this.hDW - 100, this.hDH + 64, 20);
                    var1.drawString("ゲームの難易度。", this.hDW - 100, this.hDH + 91, 20);
                } else if (this.townMapOptionBase1 == 2) {
                    var1.setColor(16777215);
                    var1.drawString("変更", this.hDW - 100, this.hDH + 64, 20);
                    var1.drawString("サウンド設定。", this.hDW - 100, this.hDH + 91, 20);
                } else if (this.townMapOptionBase1 == 3) {
                    var1.setColor(16777215);
                    var1.drawString("変更", this.hDW - 100, this.hDH + 64, 20);
                    var1.drawString("ぷよスタイル。", this.hDW - 100, this.hDH + 91, 20);
                } else if (this.townMapOptionBase1 == 4) {
                    var1.setColor(16777215);
                    var1.drawString("ぷよぷよフィーバー", this.hDW - 100, this.hDH + 64, 20);
                    var1.drawString("について。", this.hDW - 100, this.hDH + 91, 20);
                }

				if (this.debugModeFlag) {
                    this.setSoftkeyText("DEBUG", "戻る");
				} else {
                    this.setSoftkeyText("", "戻る");
				}
                if ((this.s & 1) != 0) {
                    if (this.sfxType == 1 || this.sfxType == 2) {
                        try {
                            ((VolumeControl)this.menuChoose.getControl("VolumeControl")).setLevel(this.b);
                            this.menuChoose.start();
                        } catch (Exception var55) {
                            var55.printStackTrace();
                        }
                    }

                    --this.townMapOptionBase1;
                    if (this.townMapOptionBase1 < 0) {
                        this.townMapOptionBase1 = 4;
                    }
                } else if ((this.s & 4) != 0) {
                    if (this.sfxType == 1 || this.sfxType == 2) {
                        try {
                            ((VolumeControl)this.menuChoose.getControl("VolumeControl")).setLevel(this.b);
                            this.menuChoose.start();
                        } catch (Exception var56) {
                            var56.printStackTrace();
                        }
                    }

                    ++this.townMapOptionBase1;
                    if (this.townMapOptionBase1 > 4) {
                        this.townMapOptionBase1 = 0;
                    }
                } else if ((this.s & 16) != 0) {
                    switch(this.townMapOptionBase1) {
                    case 0:
                        if (this.sfxType == 1 || this.sfxType == 2) {
                            try {
                                ((VolumeControl)this.menuSelect.getControl("VolumeControl")).setLevel(this.b);
                                this.menuSelect.start();
                            } catch (Exception var) {
                                var.printStackTrace();
                            }
                        }

                        this.E = 113;
                        break label4905;
                    case 1:
                        if (this.sfxType == 1 || this.sfxType == 2) {
                            try {
                                ((VolumeControl)this.menuSelect.getControl("VolumeControl")).setLevel(this.b);
                                this.menuSelect.start();
                            } catch (Exception var) {
                                var.printStackTrace();
                            }
                        }

                        if (this.difficultyType == 1) {
                            this.townMapOptionBase2 = 1;
                        } else if (this.difficultyType == 2) {
                            this.townMapOptionBase2 = 2;
                        } else if (this.difficultyType == 3) {
                            this.townMapOptionBase2 = 3;
                        } else if (this.difficultyType == 4) {
                            this.townMapOptionBase2 = 4;
                        }

                        this.E = 114;
                        break label4905;
                    case 2:
                        if (this.sfxType == 1 || this.sfxType == 2) {
                            try {
                                ((VolumeControl)this.menuSelect.getControl("VolumeControl")).setLevel(this.b);
                                this.menuSelect.start();
                            } catch (Exception var) {
                                var.printStackTrace();
                            }
                        }

                        this.E = 102;
                        break label4905;
                    case 3:
                        if (this.sfxType == 1 || this.sfxType == 2) {
                            try {
                                ((VolumeControl)this.menuSelect.getControl("VolumeControl")).setLevel(this.b);
                                this.menuSelect.start();
                            } catch (Exception var) {
                                var.printStackTrace();
                            }
                        }

                        if (this.puyoSkinsType == 1) {
                            this.townMapOptionBase2 = 1;
                        } else if (this.puyoSkinsType == 2) {
                            this.townMapOptionBase2 = 2;
                        } else if (this.puyoSkinsType == 3) {
                            this.townMapOptionBase2 = 3;
                        } else if (this.puyoSkinsType == 4) {
                            this.townMapOptionBase2 = 4;
                        } else if (this.puyoSkinsType == 5) {
                            this.townMapOptionBase2 = 5;
                        }

                        this.E = 103;
                        break label4905;
                    case 4:
                        if (this.sfxType == 1 || this.sfxType == 2) {
                            try {
                                ((VolumeControl)this.menuSelect.getControl("VolumeControl")).setLevel(this.b);
                                this.menuSelect.start();
                            } catch (Exception var) {
                                var.printStackTrace();
                            }
                        }

                        this.E = 104;
                        break label4905;
                    }
                } else if ((this.s & 32) != 0) {
					if (this.debugModeFlag) {
                        if (this.sfxType == 1 || this.sfxType == 2) {
                            try {
                                ((VolumeControl)this.menuSelect.getControl("VolumeControl")).setLevel(this.b);
                                this.menuSelect.start();
                            } catch (Exception var) {
                                var.printStackTrace();
                            }
                        }

                        if (this.mainMenu) {
                            this.i();
                        }

                        this.E = 70;
					}
                } else if ((this.s & 64) != 0) {
                    if (this.sfxType == 1 || this.sfxType == 2) {
                        try {
                            ((VolumeControl)this.menuBack.getControl("VolumeControl")).setLevel(this.b);
                            this.menuBack.start();
                        } catch (Exception var) {
                            var.printStackTrace();
                        }
                    }

                    this.optionMenuBase2 = 0;
                    this.townMapOptionBase1 = 0;
					this.fadeFlag = true;
                    this.fadeCode = 9;
                    this.E = 46;
                }
                break;
            case 101:
                var1.setColor(0);
                var1.fillRect(this.hDW - 120, 30, 240, 260);
                var1.drawImage(this.mainBg, this.hDW, this.hDH, 3);
                var1.drawImage(this.townmapSinglePuyoPopBg, this.hDW, this.hDH, 3);
                var1.drawImage(this.townmapMsgWindowLarge, this.hDW, this.hDH + 76, 3);
                var1.drawImage(this.townmapCourseSelRunRun, this.hDW - 55, this.hDH - 33, 3);
                var1.drawImage(this.townmapCourseSelWakuWaku, this.hDW - 1, this.hDH - 33, 3);
                var1.drawImage(this.townmapCourseSelHaraHara, this.hDW + 53, this.hDH - 33, 3);
                if (this.townMapOptionBase1 == 0) {
                    var1.drawImage(this.townmapCourseSelRunRunHigh, this.hDW - 55, this.hDH - 33, 3);
                } else if (this.townMapOptionBase1 == 1) {
                    var1.drawImage(this.townmapCourseSelWakuWakuHigh, this.hDW - 1, this.hDH - 33, 3);
                } else if (this.townMapOptionBase1 == 2) {
                    var1.drawImage(this.townmapCourseSelHaraHaraHigh, this.hDW + 53, this.hDH - 33, 3);
                }

                var1.drawImage(this.padlockIcon, this.hDW + 72, this.hDH - 84, 3);
                if (this.townMapOptionBase1 == 0) {
                    var1.setColor(16777215);
                    var1.drawString("研修コース初心者。", this.hDW - 100, this.hDH + 36, 20);
                    var1.drawString("(3段階)", this.hDW - 100, this.hDH + 63, 20);
                    var1.drawString("", this.hDW - 100, this.hDH + 90, 20);
                } else if (this.townMapOptionBase1 == 1) {
                    var1.setColor(16777215);
                    var1.drawString("中級コース学んだ者", this.hDW - 100, this.hDH + 36, 20);
                    var1.drawString("ルール。 (8段階)", this.hDW - 100, this.hDH + 63, 20);
                    var1.drawString("", this.hDW - 100, this.hDH + 90, 20);
                } else if (this.townMapOptionBase1 == 2) {
                    var1.setColor(16777215);
                    var1.drawString("そんな方のための上級", this.hDW - 100, this.hDH + 36, 20);
                    var1.drawString("コース満足できない人", this.hDW - 100, this.hDH + 63, 20);
                    var1.drawString("わくわくコース付き。", this.hDW - 100, this.hDH + 90, 20);
                }

                this.setSoftkeyText("", "戻る");
                if ((this.s & 2) != 0) {
                    if (this.sfxType == 1 || this.sfxType == 2) {
                        try {
                            ((VolumeControl)this.menuChoose.getControl("VolumeControl")).setLevel(this.b);
                            this.menuChoose.start();
                        } catch (Exception var49) {
                            var49.printStackTrace();
                        }
                    }

                    --this.townMapOptionBase1;
                    if (this.townMapOptionBase1 < 0) {
                        this.townMapOptionBase1 = 0;
                    }
                } else if ((this.s & 8) != 0) {
                    if (this.sfxType == 1 || this.sfxType == 2) {
                        try {
                            ((VolumeControl)this.menuChoose.getControl("VolumeControl")).setLevel(this.b);
                            this.menuChoose.start();
                        } catch (Exception var50) {
                            var50.printStackTrace();
                        }
                    }

                    ++this.townMapOptionBase1;
                    if (this.townMapOptionBase1 > 2) {
                        this.townMapOptionBase1 = 2;
                    }
                } else if ((this.s & 16) != 0) {
                    switch(this.townMapOptionBase1) {
                    case 0:
                        if (this.sfxType == 1 || this.sfxType == 2) {
                            try {
                                ((VolumeControl)this.menuSelect.getControl("VolumeControl")).setLevel(this.b);
                                this.menuSelect.start();
                            } catch (Exception var53) {
                                var53.printStackTrace();
                            }
                        }

                        if (this.mainMenu) {
                            this.i();
                        }

                        if (!this.RunRunStageSelUnlockedFlag) {
                            this.optionMenuBase2 = 0;
							this.fadeFlag = true;
                            this.fadeCode = 4;
                            this.E = 46;
                        } else {
                            this.optionMenuBase2 = 0;
                            this.TownmapSinglePuyoPopEntraceFlag = true;
							this.fadeFlag = true;
                            this.fadeCode = 25;
                            this.E = 46;
                        }
                        break label4905;
                    case 1:
                        if (this.sfxType == 1 || this.sfxType == 2) {
                            try {
                                ((VolumeControl)this.menuSelect.getControl("VolumeControl")).setLevel(this.b);
                                this.menuSelect.start();
                            } catch (Exception var52) {
                                var52.printStackTrace();
                            }
                        }

                        if (this.mainMenu) {
                            this.i();
                        }

                        if (!this.WakuWakuStageSelUnlockedFlag) {
                            this.optionMenuBase2 = 0;
							this.fadeFlag = true;
                            this.fadeCode = 5;
                            this.E = 46;
                        } else {
                            this.optionMenuBase2 = 0;
                            this.TownmapSinglePuyoPopEntraceFlag = true;
							this.fadeFlag = true;
                            this.fadeCode = 26;
                            this.E = 46;
                        }
                        break label4905;
                    case 2:
                        if (this.sfxType == 1 || this.sfxType == 2) {
                            try {
                                ((VolumeControl)this.menuUnavailable.getControl("VolumeControl")).setLevel(this.b);
                                this.menuUnavailable.start();
                            } catch (Exception var51) {
                                var51.printStackTrace();
                            }
                        }
                    }
                } else {
                    if ((this.s & 64) == 0) {
                        break;
                    }

                    if (this.sfxType == 1 || this.sfxType == 2) {
                        try {
                            ((VolumeControl)this.menuBack.getControl("VolumeControl")).setLevel(this.b);
                            this.menuBack.start();
                        } catch (Exception var54) {
                            var54.printStackTrace();
                        }
                    }

                    this.optionMenuBase2 = 0;
                    this.townMapOptionBase1 = 0;
					this.fadeFlag = true;
                    this.fadeCode = 8;
                    this.E = 46;
                }
                break;
            case 102:
                var1.drawImage(this.dimBg, this.hDW, this.hDH, 3);
                var1.drawImage(this.msgWindow1, this.hDW, this.hDH, 3);
                var1.drawImage(this.optMenuSel, this.hDW, this.hDH - 46, 3);
                var1.drawImage(this.optMenuSel, this.hDW, this.hDH - 16, 3);
                var1.drawImage(this.optMenuSel, this.hDW, this.hDH + 14, 3);
                var1.drawImage(this.optMenuSel, this.hDW, this.hDH + 44, 3);
                if (this.townMapOptionBase2 == 0) {
                    var1.drawImage(this.optMenuSelHigh, this.hDW, this.hDH - 46, 3);
                } else if (this.townMapOptionBase2 == 1) {
                    var1.drawImage(this.optMenuSelHigh, this.hDW, this.hDH - 16, 3);
                } else if (this.townMapOptionBase2 == 2) {
                    var1.drawImage(this.optMenuSelHigh, this.hDW, this.hDH + 14, 3);
                } else if (this.townMapOptionBase2 == 3) {
                    var1.drawImage(this.optMenuSelHigh, this.hDW, this.hDH + 44, 3);
                }

                var1.setColor(2406101);
                var1.drawString("サウンド", this.hDW - 74, this.hDH - 100, 20);
                var1.drawString("サウンド", this.hDW - 72, this.hDH - 100, 20);
                var1.drawString("サウンド", this.hDW - 73, this.hDH - 101, 20);
                var1.drawString("サウンド", this.hDW - 73, this.hDH - 99, 20);
                var1.drawString("サウンド", this.hDW - 72, this.hDH - 98, 20);
                var1.drawString("サウンド", this.hDW - 71, this.hDH - 98, 20);
                var1.setColor(16777215);
                var1.drawString("サウンド", this.hDW - 73, this.hDH - 100, 20);
                if (this.townMapOptionBase2 == 0) {
                    var1.setColor(16777215);
                } else {
                    var1.setColor(6375051);
                }

                var1.drawString("BGM", this.hDW - 75, this.hDH - 58, 20);
                if (this.mainMenu) {
                    var1.drawString("オン", this.hDW + 78, this.hDH - 58, 24);
                } else {
                    var1.drawString("オフ", this.hDW + 78, this.hDH - 58, 24);
                }

                if (this.townMapOptionBase2 == 1) {
					if (this.sfxDisabledFlag) {
					    var1.setColor(8631739);
					} else {
                        var1.setColor(16777215);
					}
                } else {
					if (this.sfxDisabledFlag) {
					    var1.setColor(8631739);
					} else {
                        var1.setColor(6375051);
					}
                }

                var1.drawString("SE", this.hDW - 75, this.hDH - 28, 20);
                if (this.sfxType == 3) {
                    var1.drawString("オフ", this.hDW + 78, this.hDH - 28, 24);
                } else if (this.sfxType == 2) {
                    var1.drawString("部分的", this.hDW + 78, this.hDH - 28, 24);
                } else if (this.sfxType == 1) {
                    var1.drawString("満杯", this.hDW + 78, this.hDH - 28, 24);
                }

                if (this.townMapOptionBase2 == 2) {
					if (this.sfxDisabledFlag) {
					    var1.setColor(8631739);
					} else {
                        var1.setColor(16777215);
					}
                } else {
					if (this.sfxDisabledFlag) {
					    var1.setColor(8631739);
					} else {
                        var1.setColor(6375051);
					}
                }

                var1.drawString("声", this.hDW - 75, this.hDH + 2, 20);
                if (this.voiceLangType == 0) {
                    var1.drawString("日本", this.hDW + 78, this.hDH + 2, 24);
                } else if (this.voiceLangType == 1) {
                    var1.drawString("英語", this.hDW + 78, this.hDH + 2, 24);
                }

                if (this.townMapOptionBase2 == 3) {
                    var1.setColor(16777215);
                } else {
                    var1.setColor(6375051);
                }

                var1.drawString("音量", this.hDW - 75, this.hDH + 32, 20);
                if (this.b == 20) {
                    var1.drawString("低い", this.hDW + 78, this.hDH + 32, 24);
                } else if (this.b == 60) {
                    var1.drawString("中くらい", this.hDW + 78, this.hDH + 32, 24);
                } else if (this.b == 100) {
                    var1.drawString("高い", this.hDW + 78, this.hDH + 32, 24);
                }

                var1.setColor(2406101);
                if (this.townMapOptionBase2 == 0) {
                    var1.drawString("背景音楽", this.hDW - 85, this.hDH + 67, 20);
                } else if (this.townMapOptionBase2 == 1) {
					if (this.sfxDisabledFlag) {
                        var1.setColor(14638686);
                        var1.drawString("[！] 無効", this.hDW - 85, this.hDH + 67, 20);
					} else {
                        var1.drawString("効果音の種類", this.hDW - 85, this.hDH + 67, 20);
					}
                } else if (this.townMapOptionBase2 == 2) {
					if (this.sfxDisabledFlag) {
                        var1.setColor(14638686);
                        var1.drawString("[！] 無効", this.hDW - 85, this.hDH + 67, 20);
					} else {
                        var1.drawString("音声言語", this.hDW - 85, this.hDH + 67, 20);
					}
                } else if (this.townMapOptionBase2 == 3) {
                    var1.drawString("音量", this.hDW - 85, this.hDH + 67, 20);
                }
				
				if (this.sfxDisabledFlag && this.townMapOptionBase2 == 1) {
                    this.setSoftkeyText("", "戻る");
				} else if (this.sfxDisabledFlag && this.townMapOptionBase2 == 2) {
                    this.setSoftkeyText("", "戻る");
				} else {
                    this.setSoftkeyText("変化", "戻る");
				}
				
                if ((this.s & 1) != 0) {
                    --this.townMapOptionBase2;
                    if (this.townMapOptionBase2 < 0) {
                        this.townMapOptionBase2 = 3;
                    }
                } else if ((this.s & 4) != 0) {
                    ++this.townMapOptionBase2;
                    if (this.townMapOptionBase2 > 3) {
                        this.townMapOptionBase2 = 0;
                    }
                } else if ((this.s & 16) == 0 && (this.s & 32) == 0) {
                    if ((this.s & 64) != 0) {
                        this.optionMenuBase2 = 0;
                        this.townMapOptionBase2 = 0;
                        this.u();
                        this.E = 100;
                    }
                } else {
                    switch(this.townMapOptionBase2) {
                    case 0:
                        if (this.mainMenu) {
                            this.mainMenu = false;
                            this.i();
                        } else {
                            this.mainMenu = true;
                            this.a(1);
                        }
                        break label4905;
                    case 1:
					    if (!this.sfxDisabledFlag) {
                            switch(this.sfxType) {
                            case 2:
                                this.sfxType = 1;
                                break label4905;
                            case 3:
                                this.sfxType = 2;
                                break label4905;
                            default:
                                this.sfxType = 3;
                                break label4905;
                            }
						}
						
						break;
                    case 2:
					    if (!this.sfxDisabledFlag) {
                            switch(this.voiceLangType) {
                            case 1:
                                this.voiceLangType = 0;
                                break label4905;
                            default:
                                this.voiceLangType = 1;
                                break label4905;
                            }
						}
						
						break;
                    case 3:
                        this.i();
                        switch(this.b) {
                        case 60:
                            this.b = 20;
                            this.a(1);
                            break label4905;
                        case 100:
                            this.b = 60;
                            this.a(1);
                            break label4905;
                        default:
                            this.b = 100;
                            this.a(1);
                        }
                    }
                }
                break;
            case 103:
                var1.drawImage(this.dimBg, this.hDW, this.hDH, 3);
                var1.drawImage(this.msgWindow1, this.hDW, this.hDH, 3);
                if (this.puyoSkinsType == 1) {
                    var1.drawImage(this.puyoPreviewFever, this.hDW, this.hDH + 14, 3);
                } else if (this.puyoSkinsType == 2) {
                    var1.drawImage(this.puyoPreviewRetro, this.hDW, this.hDH + 14, 3);
                } else if (this.puyoSkinsType == 3) {
                    var1.drawImage(this.puyoPreviewAqua, this.hDW, this.hDH + 14, 3);
                } else if (this.puyoSkinsType == 4) {
                    var1.drawImage(this.puyoPreviewGummy, this.hDW, this.hDH + 14, 3);
                } else if (this.puyoSkinsType == 5) {
                    var1.drawImage(this.puyoPreviewClassic, this.hDW, this.hDH + 14, 3);
                }

                var1.setColor(2406101);
                var1.drawString("ぷよ", this.hDW - 74, this.hDH - 100, 20);
                var1.drawString("ぷよ", this.hDW - 72, this.hDH - 100, 20);
                var1.drawString("ぷよ", this.hDW - 73, this.hDH - 101, 20);
                var1.drawString("ぷよ", this.hDW - 73, this.hDH - 99, 20);
                var1.drawString("ぷよ", this.hDW - 72, this.hDH - 98, 20);
                var1.drawString("ぷよ", this.hDW - 71, this.hDH - 98, 20);
                var1.setColor(16777215);
                var1.drawString("ぷよ", this.hDW - 73, this.hDH - 100, 20);
                var1.setColor(6375051);
                var1.drawString("ぷよぷよの設定方法", this.hDW, this.hDH - 70, 17);
                var1.drawString("見えます：", this.hDW, this.hDH - 42, 17);
                var1.drawString("↑", this.hDW - 60, this.hDH + 47, 17);
                var1.drawString("↓", this.hDW + 60, this.hDH + 47, 17);
                if (this.puyoSkinsType == 5) {
                    if (this.townMapOptionBase2 == 5) {
                        var1.drawImage(this.pauseMenuSelHigh, this.hDW, this.hDH + 60, 3);
                    } else {
                        var1.drawImage(this.pauseMenuSel, this.hDW, this.hDH + 60, 3);
                    }
                } else if (this.puyoSkinsType == 4) {
                    if (this.townMapOptionBase2 == 4) {
                        var1.drawImage(this.pauseMenuSelHigh, this.hDW, this.hDH + 60, 3);
                    } else {
                        var1.drawImage(this.pauseMenuSel, this.hDW, this.hDH + 60, 3);
                    }
                } else if (this.puyoSkinsType == 3) {
                    if (this.townMapOptionBase2 == 3) {
                        var1.drawImage(this.pauseMenuSelHigh, this.hDW, this.hDH + 60, 3);
                    } else {
                        var1.drawImage(this.pauseMenuSel, this.hDW, this.hDH + 60, 3);
                    }
                } else if (this.puyoSkinsType == 2) {
                    if (this.townMapOptionBase2 == 2) {
                        var1.drawImage(this.pauseMenuSelHigh, this.hDW, this.hDH + 60, 3);
                    } else {
                        var1.drawImage(this.pauseMenuSel, this.hDW, this.hDH + 60, 3);
                    }
                } else if (this.puyoSkinsType == 1) {
                    if (this.townMapOptionBase2 == 1) {
                        var1.drawImage(this.pauseMenuSelHigh, this.hDW, this.hDH + 60, 3);
                    } else {
                        var1.drawImage(this.pauseMenuSel, this.hDW, this.hDH + 60, 3);
                    }
                }

                if (this.puyoSkinsType == 5) {
                    if (this.townMapOptionBase2 == 5) {
                        var1.setColor(16777215);
                    } else {
                        var1.setColor(6375051);
                    }

                    var1.drawString("古典", this.hDW, this.hDH + 47, 17);
                } else if (this.puyoSkinsType == 4) {
                    if (this.townMapOptionBase2 == 4) {
                        var1.setColor(16777215);
                    } else {
                        var1.setColor(6375051);
                    }

                    var1.drawString("グミ", this.hDW, this.hDH + 47, 17);
                } else if (this.puyoSkinsType == 3) {
                    if (this.townMapOptionBase2 == 3) {
                        var1.setColor(16777215);
                    } else {
                        var1.setColor(6375051);
                    }

                    var1.drawString("アクア", this.hDW, this.hDH + 47, 17);
                } else if (this.puyoSkinsType == 2) {
                    if (this.townMapOptionBase2 == 2) {
                        var1.setColor(16777215);
                    } else {
                        var1.setColor(6375051);
                    }

                    var1.drawString("レトロ", this.hDW, this.hDH + 47, 17);
                } else if (this.puyoSkinsType == 1) {
                    if (this.townMapOptionBase2 == 1) {
                        var1.setColor(16777215);
                    } else {
                        var1.setColor(6375051);
                    }

                    var1.drawString("フィーバー", this.hDW, this.hDH + 47, 17);
                }

                if (this.puyoSkinChangeFlag) {
                    this.setSoftkeyText("セーブ", "戻る");
                } else {
                    this.setSoftkeyText("", "戻る");
                }

                if ((this.s & 1) != 0) {
                    if (this.sfxType == 1 || this.sfxType == 2) {
                        try {
                            ((VolumeControl)this.menuChoose.getControl("VolumeControl")).setLevel(this.b);
                            this.menuChoose.start();
                        } catch (Exception var45) {
                            var45.printStackTrace();
                        }
                    }

                    ++this.puyoSkinsType;
                    if (this.puyoSkinsType > 5) {
                        this.puyoSkinsType = 1;
                    }

                    this.puyoSkinChangeFlag = true;
                } else if ((this.s & 4) != 0) {
                    if (this.sfxType == 1 || this.sfxType == 2) {
                        try {
                            ((VolumeControl)this.menuChoose.getControl("VolumeControl")).setLevel(this.b);
                            this.menuChoose.start();
                        } catch (Exception var) {
                            var.printStackTrace();
                        }
                    }

                    --this.puyoSkinsType;
                    if (this.puyoSkinsType < 1) {
                        this.puyoSkinsType = 5;
                    }

                    this.puyoSkinChangeFlag = true;
                } else if (((this.s & 16) != 0 || (this.s & 32) != 0) && this.puyoSkinChangeFlag) {
                    if (this.sfxType == 1 || this.sfxType == 2) {
                        try {
                            ((VolumeControl)this.menuSelect.getControl("VolumeControl")).setLevel(this.b);
                            this.menuSelect.start();
                        } catch (Exception var48) {
                            var48.printStackTrace();
                        }
                    }

                    this.dw = false;
                    if (!this.dw) {
                        if (this.puyoSkinsType == 5) {
                            this.puyoFever("skin/rg_L2_classic.png", 0);
                            this.puyoFever("skin/by_L2_classic.png", 1);
                            this.puyoFever("skin/pj_L2_classic.png", 2);
                        } else if (this.puyoSkinsType == 4) {
                            this.puyoFever("skin/rg_L2_gummy.png", 0);
                            this.puyoFever("skin/by_L2_gummy.png", 1);
                            this.puyoFever("skin/pj_L2_gummy.png", 2);
                        } else if (this.puyoSkinsType == 3) {
                            this.puyoFever("skin/rg_L2_aqua.png", 0);
                            this.puyoFever("skin/by_L2_aqua.png", 1);
                            this.puyoFever("skin/pj_L2_aqua.png", 2);
                        } else if (this.puyoSkinsType == 2) {
                            this.puyoFever("skin/rg_L2_retro.png", 0);
                            this.puyoFever("skin/by_L2_retro.png", 1);
                            this.puyoFever("skin/pj_L2_retro.png", 2);
                        } else if (this.puyoSkinsType == 1) {
                            this.puyoFever("skin/rg_L2_fever.png", 0);
                            this.puyoFever("skin/by_L2_fever.png", 1);
                            this.puyoFever("skin/pj_L2_fever.png", 2);
                        }

                        this.dw = true;
                    }

                    if (this.puyoSkinChangeFlag) {
                        this.puyoSkinChangeFlag = false;
                    }

                    this.optionMenuBase2 = 0;
                    this.townMapOptionBase2 = 0;
					if (this.gameError) {
						this.E = 44;
					} else {
                        this.u();
                        this.E = 100;
					}
                } else {
                    if ((this.s & 64) == 0) {
                        break;
                    }

                    if (this.sfxType == 1 || this.sfxType == 2) {
                        try {
                            ((VolumeControl)this.menuBack.getControl("VolumeControl")).setLevel(this.b);
                            this.menuBack.start();
                        } catch (Exception var47) {
                            var47.printStackTrace();
                        }
                    }

                    if (this.townMapOptionBase2 == 1) {
                        this.puyoSkinsType = 1;
                    } else if (this.townMapOptionBase2 == 2) {
                        this.puyoSkinsType = 2;
                    } else if (this.townMapOptionBase2 == 3) {
                        this.puyoSkinsType = 3;
                    } else if (this.townMapOptionBase2 == 4) {
                        this.puyoSkinsType = 4;
                    } else if (this.townMapOptionBase2 == 5) {
                        this.puyoSkinsType = 5;
                    }

                    if (this.puyoSkinChangeFlag) {
                        this.puyoSkinChangeFlag = false;
                    }

                    this.optionMenuBase2 = 0;
                    this.townMapOptionBase2 = 0;
                    this.E = 100;
                }
                break;
            case 104:
                var1.drawImage(this.dimBg, this.hDW, this.hDH, 3);
                var1.drawImage(this.msgWindow1, this.hDW, this.hDH, 3);
                var1.setColor(2406101);
                var1.drawString("について", this.hDW - 74, this.hDH - 100, 20);
                var1.drawString("について", this.hDW - 72, this.hDH - 100, 20);
                var1.drawString("について", this.hDW - 73, this.hDH - 101, 20);
                var1.drawString("について", this.hDW - 73, this.hDH - 99, 20);
                var1.drawString("について", this.hDW - 72, this.hDH - 98, 20);
                var1.drawString("について", this.hDW - 71, this.hDH - 98, 20);
                var1.setColor(16777215);
                var1.drawString("について", this.hDW - 73, this.hDH - 100, 20);
                if (this.townMapOptionBase2 != 0) {
                    var1.setColor(6375051);
                    var1.drawString("↑", this.hDW + 83, this.hDH - 73, 17);
                }

                if (this.townMapOptionBase2 != 10) {
                    var1.setColor(6375051);
                    var1.drawString("↓", this.hDW + 83, this.hDH + 67, 17);
                }

                if (this.townMapOptionBase2 == 0) {
                    var1.setColor(6375051);
                    var1.drawString("ぷよぷよフィーバー", this.hDW, this.hDH - 70, 17);
                    var1.drawString("Re:れんさ", this.hDW, this.hDH - 42, 17);
                    var1.drawString("", this.hDW, this.hDH - 14, 17);
                    var1.drawString("© SEGA", this.hDW, this.hDH + 14, 17);
                    var1.drawString("改造した:", this.hDW, this.hDH + 42, 17);
                    var1.drawString("Realtimeless", this.hDW, this.hDH + 70, 17);
                } else if (this.townMapOptionBase2 == 1) {
                    var1.setColor(6375051);
                    var1.drawString("バージョン:", this.hDW, this.hDH - 70, 17);
                    var1.drawString("2.01_ja_JP (0000)", this.hDW, this.hDH - 42, 17);
                    var1.drawString("リリース", this.hDW, this.hDH - 14, 17);
                    var1.drawString("", this.hDW, this.hDH + 14, 17);
                    var1.drawString("プラットフォーム:", this.hDW, this.hDH + 42, 17);
                    var1.drawString("Java ME / J2ME", this.hDW, this.hDH + 70, 17);
                } else if (this.townMapOptionBase2 == 2) {
                    var1.setColor(6375051);
                    var1.drawString("画面解像度:", this.hDW, this.hDH - 70, 17);
                    var1.drawString("240x320 400x240", this.hDW, this.hDH - 42, 17);
                    var1.drawString("240x400 640x360", this.hDW, this.hDH - 14, 17);
                    var1.drawString("240x432 640x480", this.hDW, this.hDH + 14, 17);
                    var1.drawString("352x416 800x352", this.hDW, this.hDH + 42, 17);
                    var1.drawString("480x800 800x480", this.hDW, this.hDH + 70, 17);
                } else if (this.townMapOptionBase2 == 3) {
                    var1.setColor(6375051);
                    var1.drawString("SEタイプ:", this.hDW, this.hDH - 70, 17);
                    var1.drawString("WAV (11025 Hz)", this.hDW, this.hDH - 42, 17);
                    var1.drawString("PRESENTED BY:", this.hDW, this.hDH - 14, 17);
                    var1.drawString("SEGA", this.hDW, this.hDH + 14, 17);
                    var1.drawString("DEVELOPED BY:", this.hDW, this.hDH + 42, 17);
                    var1.drawString("SONICTEAM", this.hDW, this.hDH + 70, 17);
                } else if (this.townMapOptionBase2 == 4) {
                    var1.setColor(6375051);
                    var1.drawString("スペシャルサンクス:", this.hDW, this.hDH - 70, 17);
                    var1.drawString("- Aburtos -", this.hDW, this.hDH - 42, 17);
                    var1.drawString("(グミぷよ)", this.hDW, this.hDH - 14, 17);
                    var1.drawString("- Nokia64 -", this.hDW, this.hDH + 14, 17);
                    var1.drawString("(スクリプト)", this.hDW, this.hDH + 42, 17);
                    var1.drawString("", this.hDW, this.hDH + 70, 17);
                } else if (this.townMapOptionBase2 == 5) {
                    var1.setColor(6375051);
                    var1.drawString("スペシャルサンクス:", this.hDW, this.hDH - 70, 17);
                    var1.drawString("- ThanhPhuc -", this.hDW, this.hDH - 42, 17);
                    var1.drawString("(Japanese", this.hDW, this.hDH - 14, 17);
                    var1.drawString("Translation)", this.hDW, this.hDH + 14, 17);
                    var1.drawString("", this.hDW, this.hDH + 42, 17);
                    var1.drawString("", this.hDW, this.hDH + 70, 17);
                } else if (this.townMapOptionBase2 == 6) {
                    var1.setColor(6375051);
                    var1.drawString("ぷよぷよフィーバー", this.hDW, this.hDH - 70, 17);
                    var1.drawString("Re:れんさ」は、", this.hDW, this.hDH - 42, 17);
                    var1.drawString("多くの機能を備えた", this.hDW, this.hDH - 14, 17);
                    var1.drawString("ぷよぷよフィーバーDX", this.hDW, this.hDH + 14, 17);
                    var1.drawString("モバイルゲームの", this.hDW, this.hDH + 42, 17);
                    var1.drawString("MODです!", this.hDW, this.hDH + 70, 17);
                } else if (this.townMapOptionBase2 == 7) {
                    var1.setColor(6375051);
                    var1.drawString("このMODは、オリジナル", this.hDW, this.hDH - 70, 17);
                    var1.drawString("のぷよぷよフィーバーの", this.hDW, this.hDH - 42, 17);
                    var1.drawString("ストーリーで、", this.hDW, this.hDH - 14, 17);
                    var1.drawString("ぷよぷよフィーバー2", this.hDW, this.hDH + 14, 17);
                    var1.drawString("のような体験をする", this.hDW, this.hDH + 42, 17);
                    var1.drawString("ことができます。", this.hDW, this.hDH + 70, 17);
                } else if (this.townMapOptionBase2 == 8) {
                    var1.setColor(6375051);
                    var1.drawString("チェンジログ:", this.hDW, this.hDH - 70, 17);
                    var1.drawString("画面解像度の自", this.hDW, this.hDH - 42, 17);
                    var1.drawString("動調整で、秒単", this.hDW, this.hDH - 14, 17);
                    var1.drawString("位で自動的に再", this.hDW, this.hDH + 14, 17);
                    var1.drawString("スケールするように", this.hDW, this.hDH + 42, 17);
                    var1.drawString("修正しました。", this.hDW, this.hDH + 70, 17);
                } else if (this.townMapOptionBase2 == 9) {
                    var1.setColor(6375051);
                    var1.drawString("プレイしていただき、", this.hDW, this.hDH - 70, 17);
                    var1.drawString("ありがとうございます。", this.hDW, this.hDH - 42, 17);
                    var1.drawString("ぷよぷよフィーバー", this.hDW, this.hDH - 14, 17);
                    var1.drawString("Re:れんさ!", this.hDW, this.hDH + 14, 17);
                    var1.drawString("", this.hDW, this.hDH + 42, 17);
                    var1.drawString("Modded by RTL.", this.hDW, this.hDH + 70, 17);
                } else if (this.townMapOptionBase2 == 10) {
                    var1.setColor(6375051);
                    var1.drawString("もし、開発をサポート", this.hDW, this.hDH - 70, 17);
                    var1.drawString("したいのであれば、", this.hDW, this.hDH - 42, 17);
                    var1.drawString("GitHubからソースコード", this.hDW, this.hDH - 14, 17);
                    var1.drawString("を入手して、自分で新", this.hDW, this.hDH + 14, 17);
                    var1.drawString("機能を実装することも", this.hDW, this.hDH + 42, 17);
                    var1.drawString("できますよ。:)", this.hDW, this.hDH + 70, 17);
                }

                this.setSoftkeyText("", "戻る");
				
                if ((this.s & 1) != 0) {
                    if (this.sfxType == 1 || this.sfxType == 2) {
                        try {
                            ((VolumeControl)this.menuChoose.getControl("VolumeControl")).setLevel(this.b);
                            this.menuChoose.start();
                        } catch (Exception var) {
                            var.printStackTrace();
                        }
                    }

                    --this.townMapOptionBase2;
                    if (this.townMapOptionBase2 < 0) {
                        this.townMapOptionBase2 = 0;
                    }
                } else if ((this.s & 4) != 0) {
                    if (this.sfxType == 1 || this.sfxType == 2) {
                        try {
                            ((VolumeControl)this.menuChoose.getControl("VolumeControl")).setLevel(this.b);
                            this.menuChoose.start();
                        } catch (Exception var43) {
                            var43.printStackTrace();
                        }
                    }

                    ++this.townMapOptionBase2;
                    if (this.townMapOptionBase2 > 10) {
                        this.townMapOptionBase2 = 10;
                    }
                } else {
                    if ((this.s & 64) == 0) {
                        break;
                    }

                    if (this.sfxType == 1 || this.sfxType == 2) {
                        try {
                            ((VolumeControl)this.menuBack.getControl("VolumeControl")).setLevel(this.b);
                            this.menuBack.start();
                        } catch (Exception var) {
                            var.printStackTrace();
                        }
                    }

                    this.optionMenuBase2 = 0;
                    this.townMapOptionBase2 = 0;
                    this.E = 100;
                }
                break;
            case 105:
                var1.setColor(0);
                var1.fillRect(this.hDW - 120, 30, 240, 260);
                var1.drawImage(this.mainBg, this.hDW, this.hDH, 3);
                var1.drawImage(this.townmapTownHallBgAkr, this.hDW, this.hDH, 3);
                var1.drawImage(this.townmapMsgWindow, this.hDW, this.hDH + 76, 3);
                if (this.townMapMenuBase == 0) {
                    var1.setColor(16777215);
                    var1.drawString("アコール", this.hDW - 106, this.hDH + 31, 20);
                    var1.drawString("みなさんが、がんばってお勉", this.hDW - 91, this.hDH + 55, 20);
                    var1.drawString("強できるように 先生こんな", this.hDW - 91, this.hDH + 76, 20);
                    var1.drawString("カードを作ってみたの。", this.hDW - 91, this.hDH + 97, 20);
				} else if (this.townMapMenuBase == 1) {
                    var1.setColor(16777215);
                    var1.drawString("アコール", this.hDW - 106, this.hDH + 31, 20);
                    var1.drawString("みなさんが、がんばってお勉", this.hDW - 91, this.hDH + 55, 20);
                    var1.drawString("強できるように 先生こんな", this.hDW - 91, this.hDH + 76, 20);
                    var1.drawString("カードを作ってみたの。", this.hDW - 91, this.hDH + 97, 20);
                    var1.drawImage(this.dimBg, this.hDW, this.hDH, 3);
                    var1.drawImage(this.pCardWindow, this.hDW, this.hDH, 3);
				} else if (this.townMapMenuBase == 2) {
                    var1.setColor(16777215);
                    var1.drawString("アコール", this.hDW - 106, this.hDH + 31, 20);
                    var1.drawString("このカードは、この街のあ", this.hDW - 91, this.hDH + 55, 20);
                    var1.drawString("ちこちで使えますよ･･･", this.hDW - 91, this.hDH + 76, 20);
                    var1.drawString("", this.hDW - 91, this.hDH + 97, 20);
				} else if (this.townMapMenuBase == 3) {
                    var1.setColor(16777215);
                    var1.drawString("アコール", this.hDW - 106, this.hDH + 31, 20);
                    var1.drawString("でもまだ1しかないからみ", this.hDW - 91, this.hDH + 55, 20);
                    var1.drawString("なさんにはナイショね。", this.hDW - 91, this.hDH + 76, 20);
                    var1.drawString("", this.hDW - 91, this.hDH + 97, 20);
				}

                if (this.townMapMenuBase == 1) {
                    this.setSoftkeyText("OK", "");
				} else {
                    this.setSoftkeyText("次へ", "");
				}

                if ((this.s & 16) == 0 && (this.s & 32) == 0) {
                    break;
                }

                if (this.sfxType == 1 || this.sfxType == 2) {
                    try {
                        ((VolumeControl)this.menuSelect.getControl("VolumeControl")).setLevel(this.b);
                        this.menuSelect.start();
                    } catch (Exception var41) {
                        var41.printStackTrace();
                    }
                }

                ++this.townMapMenuBase;
                if (this.townMapMenuBase > 3) {
                    this.i();
                    this.optionMenuBase2 = 0;
                    this.townMapBase = 2;
                    this.townMapMenuBase = 0;
                    this.FirstBootFlag = false;
					this.fadeFlag = true;
                    this.fadeCode = 1;
                    this.E = 46;
                }
                break;
            case 106:
                if (this.TownmapSinglePuyoPopEntraceFlag) {
                    this.TownmapSinglePuyoPopEntraceFlag = false;
                }

                var1.setColor(0);
                var1.fillRect(this.hDW - 120, 30, 240, 260);
                var1.drawImage(this.mainBg, this.hDW, this.hDH, 3);
                var1.drawImage(this.townmapStgSelBgRunRun, this.hDW, this.hDH, 3);
                if (this.townMapOptionBase3 == 0) {
                    var1.drawImage(this.townmapStageSelHighlight, this.hDW + 12, this.hDH + 9, 3);
                } else if (this.townMapOptionBase3 == 1) {
                    var1.drawImage(this.townmapStageSelHighlight, this.hDW - 17, this.hDH - 1, 3);
                } else if (this.townMapOptionBase3 == 2) {
                    var1.drawImage(this.townmapStageSelHighlight, this.hDW - 7, this.hDH - 34, 3);
                }

                this.amtIdleTime += this.C;
                if (this.TownmapStageSelEntranceFlag) {
                    if (this.townMapOptionBase3 == 0) {
                        if (this.amtIdleTime <= 0) {
                            var1.drawImage(this.amtIdle1, this.hDW + 12, this.hDH - 6, 3);
                        } else if (this.amtIdleTime <= 100) {
                            var1.drawImage(this.amtIdle2, this.hDW + 12, this.hDH - 6, 3);
                        } else if (this.amtIdleTime <= 200) {
                            var1.drawImage(this.amtIdle3, this.hDW + 12, this.hDH - 6, 3);
                        } else if (this.amtIdleTime <= 300) {
                            var1.drawImage(this.amtIdle4, this.hDW + 12, this.hDH - 6, 3);
                        } else if (this.amtIdleTime <= 400) {
                            var1.drawImage(this.amtIdle5, this.hDW + 12, this.hDH - 6, 3);
                        } else if (this.amtIdleTime >= 400) {
                            var1.drawImage(this.amtIdle5, this.hDW + 12, this.hDH - 6, 3);
                        }
                    } else if (this.townMapOptionBase3 == 1) {
                        if (this.amtIdleTime <= 0) {
                            var1.drawImage(this.amtIdle1, this.hDW - 17, this.hDH - 16, 3);
                        } else if (this.amtIdleTime <= 100) {
                            var1.drawImage(this.amtIdle2, this.hDW - 17, this.hDH - 16, 3);
                        } else if (this.amtIdleTime <= 200) {
                            var1.drawImage(this.amtIdle3, this.hDW - 17, this.hDH - 16, 3);
                        } else if (this.amtIdleTime <= 300) {
                            var1.drawImage(this.amtIdle4, this.hDW - 17, this.hDH - 16, 3);
                        } else if (this.amtIdleTime <= 400) {
                            var1.drawImage(this.amtIdle5, this.hDW - 17, this.hDH - 16, 3);
                        } else if (this.amtIdleTime >= 400) {
                            var1.drawImage(this.amtIdle5, this.hDW - 17, this.hDH - 16, 3);
                        }
                    } else if (this.townMapOptionBase3 == 2) {
                        if (this.amtIdleTime <= 0) {
                            var1.drawImage(this.amtIdle1, this.hDW - 7, this.hDH - 49, 3);
                        } else if (this.amtIdleTime <= 100) {
                            var1.drawImage(this.amtIdle2, this.hDW - 7, this.hDH - 49, 3);
                        } else if (this.amtIdleTime <= 200) {
                            var1.drawImage(this.amtIdle3, this.hDW - 7, this.hDH - 49, 3);
                        } else if (this.amtIdleTime <= 300) {
                            var1.drawImage(this.amtIdle4, this.hDW - 7, this.hDH - 49, 3);
                        } else if (this.amtIdleTime <= 400) {
                            var1.drawImage(this.amtIdle5, this.hDW - 7, this.hDH - 49, 3);
                        } else if (this.amtIdleTime >= 400) {
                            var1.drawImage(this.amtIdle5, this.hDW - 7, this.hDH - 49, 3);
                        }
                    }
                } else {
                    if (this.amtIdleTime <= 4000) {
                        if (this.townMapOptionBase3 == 0) {
                            var1.drawImage(this.amtIdle1, this.hDW + 12, this.hDH - 6, 3);
                        } else if (this.townMapOptionBase3 == 1) {
                            var1.drawImage(this.amtIdle1, this.hDW - 17, this.hDH - 16, 3);
                        } else if (this.townMapOptionBase3 == 2) {
                            var1.drawImage(this.amtIdle1, this.hDW - 7, this.hDH - 49, 3);
                        }
                    }

                    if (this.amtIdleTime >= 4000) {
                        if (this.townMapOptionBase3 == 0) {
                            var1.drawImage(this.amtIdle2, this.hDW + 12, this.hDH - 6, 3);
                        } else if (this.townMapOptionBase3 == 1) {
                            var1.drawImage(this.amtIdle2, this.hDW - 17, this.hDH - 16, 3);
                        } else if (this.townMapOptionBase3 == 2) {
                            var1.drawImage(this.amtIdle2, this.hDW - 7, this.hDH - 49, 3);
                        }
                    }

                    if (this.amtIdleTime >= 4050) {
                        this.amtIdleTime = 0;
                    }
                }

                if (this.townMapOptionBase3 == 0) {
                    var1.drawImage(this.townmapWindowLarge, this.hDW, this.hDH + 90, 3);
                    var1.setColor(16777215);
                    var1.drawString("STAGE 1", this.hDW, this.hDH + 64, 17);
                    var1.drawString("アミティ VS. リデル", this.hDW, this.hDH + 91, 17);
                } else if (this.townMapOptionBase3 == 1) {
                    var1.drawImage(this.townmapWindowLarge, this.hDW, this.hDH + 90, 3);
                    var1.setColor(16777215);
                    var1.drawString("STAGE 2", this.hDW, this.hDH + 64, 17);
                    var1.drawString("アミティ VS. タルタル", this.hDW, this.hDH + 91, 17);
                } else if (this.townMapOptionBase3 == 2) {
                    var1.drawImage(this.townmapWindowLarge, this.hDW, this.hDH + 90, 3);
                    var1.setColor(16777215);
                    var1.drawString("STAGE 3", this.hDW, this.hDH + 64, 17);
                    var1.drawString("アミティ VS. アコール", this.hDW, this.hDH + 91, 17);
                }

                if (!this.TownmapStageSelEntranceFlag) {
                    if (this.townMapOptionBase3 != 0) {
                        var1.drawString("↓", this.hDW + 95, this.hDH + 64, 17);
                    }

                    if (this.townMapOptionBase3 != 2) {
                        var1.drawString("↑", this.hDW - 95, this.hDH + 64, 17);
                    }
                }

                if (this.TownmapStageSelEntranceFlag) {
                    this.setSoftkeyText("", "");
                } else {
                    this.setSoftkeyText("すべて再生", "戻る");
                }

                if (this.TownmapStageSelEntranceFlag && this.amtIdleTime >= 1400) {
                    this.TownmapStageSelEntranceFlag = false;
                    switch(this.townMapOptionBase3) {
                    case 0:
                        this.TownmapStageSelFlag = true;
                        this.amtIdleTime = 0;
                        this.optionMenuBase1 = 7;
                        this.menu = true;
                        this.aw = 0;
                        this.br = 2;
                        this.optionMenuBase2 = 0;
                        this.singlePuyoPopBase = 0;
						this.fadeFlag = true;
                        this.fadeCode = 19;
                        this.E = 46;
                        break;
                    case 1:
                        this.TownmapStageSelFlag = true;
                        this.amtIdleTime = 0;
                        this.optionMenuBase1 = 7;
                        this.menu = true;
                        this.aw = 0;
                        this.br = 2;
                        this.optionMenuBase2 = 0;
                        this.singlePuyoPopBase = 1;
						this.fadeFlag = true;
                        this.fadeCode = 19;
                        this.E = 46;
                        break;
                    case 2:
                        this.TownmapStageSelFlag = true;
                        this.amtIdleTime = 0;
                        this.optionMenuBase1 = 7;
                        this.menu = true;
                        this.aw = 0;
                        this.br = 2;
                        this.optionMenuBase2 = 0;
                        this.singlePuyoPopBase = 2;
						this.fadeFlag = true;
                        this.fadeCode = 19;
                        this.E = 46;
                    }
                }

                if ((this.s & 1) != 0) {
                    if (this.TownmapStageSelEntranceFlag) {
                        break;
                    }

                    ++this.townMapOptionBase3;
                    if (this.townMapOptionBase3 > 2) {
                        this.townMapOptionBase3 = 2;
                    } else if (this.sfxType == 1 || this.sfxType == 2) {
                        try {
                            ((VolumeControl)this.menuChoose.getControl("VolumeControl")).setLevel(this.b);
                            this.menuChoose.start();
                        } catch (Exception var37) {
                            var37.printStackTrace();
                        }
                    }
                } else if ((this.s & 4) != 0) {
                    if (this.TownmapStageSelEntranceFlag) {
                        break;
                    }

                    --this.townMapOptionBase3;
                    if (this.townMapOptionBase3 < 0) {
                        this.townMapOptionBase3 = 0;
                    } else if (this.sfxType == 1 || this.sfxType == 2) {
                        try {
                            ((VolumeControl)this.menuChoose.getControl("VolumeControl")).setLevel(this.b);
                            this.menuChoose.start();
                        } catch (Exception var40) {
                            var40.printStackTrace();
                        }
                    }
                } else if ((this.s & 16) != 0) {
                    if (this.TownmapStageSelEntranceFlag) {
                        break;
                    }

                    if (this.sfxType == 1 || this.sfxType == 2) {
						if (this.voiceLangType == 0) {
                            try {
                                ((VolumeControl)this.amtStartVoice.getControl("VolumeControl")).setLevel(this.b);
                                this.amtStartVoice.start();
                            } catch (Exception var) {
                              var.printStackTrace();
                            }
				  		} else if (this.voiceLangType == 1) {
                            try {
                                ((VolumeControl)this.amtStartVoiceEN.getControl("VolumeControl")).setLevel(this.b);
                                this.amtStartVoiceEN.start();
                            } catch (Exception var) {
                              var.printStackTrace();
                            }
						}
                    }

                    this.amtIdleTime = 0;
                    this.TownmapStageSelEntranceFlag = true;
                } else if ((this.s & 32) != 0) {
                    if (!this.TownmapStageSelEntranceFlag) {
                        this.amtIdleTime = 0;
                        this.optionMenuBase2 = 0;
						this.fadeFlag = true;
                        this.fadeCode = 4;
                        this.E = 46;
                    }
                } else {
                    if ((this.s & 64) == 0 || this.TownmapStageSelEntranceFlag) {
                        break;
                    }

                    if (this.sfxType == 1 || this.sfxType == 2) {
                        try {
                            ((VolumeControl)this.menuBack.getControl("VolumeControl")).setLevel(this.b);
                            this.menuBack.start();
                        } catch (Exception var39) {
                            var39.printStackTrace();
                        }
                    }

                    this.amtIdleTime = 0;
                    this.optionMenuBase2 = 0;
                    this.townMapOptionBase3 = 0;
                    this.i();
                    this.TownmapSinglePuyoPopEntraceFlag = true;
					this.fadeFlag = true;
                    this.fadeCode = 14;
                    this.E = 46;
                }
                break;
            case 107:
                if (this.TownmapSinglePuyoPopEntraceFlag) {
                    this.TownmapSinglePuyoPopEntraceFlag = false;
                }

                var1.setColor(0);
                var1.fillRect(this.hDW - 120, 30, 240, 260);
                var1.drawImage(this.mainBg, this.hDW, this.hDH, 3);
                var1.drawImage(this.townmapStgSelBgWakuWaku, this.hDW, this.hDH, 3);
                if (this.townMapOptionBase3 == 0) {
                    var1.drawImage(this.townmapStageSelHighlight, this.hDW - 40, this.hDH - 19, 3);
                } else if (this.townMapOptionBase3 == 1) {
                    var1.drawImage(this.townmapStageSelHighlight, this.hDW - 54, this.hDH + 29, 3);
                } else if (this.townMapOptionBase3 == 2) {
                    var1.drawImage(this.townmapStageSelHighlight, this.hDW - 33, this.hDH + 42, 3);
                } else if (this.townMapOptionBase3 == 3) {
                    var1.drawImage(this.townmapStageSelHighlight, this.hDW + 14, this.hDH + 32, 3);
                } else if (this.townMapOptionBase3 == 4) {
                    var1.drawImage(this.townmapStageSelHighlight, this.hDW + 63, this.hDH + 48, 3);
                } else if (this.townMapOptionBase3 == 5) {
                    var1.drawImage(this.townmapStageSelHighlight, this.hDW + 71, this.hDH + 8, 3);
                } else if (this.townMapOptionBase3 == 6) {
                    var1.drawImage(this.townmapStageSelHighlight, this.hDW + 61, this.hDH - 25, 3);
                } else if (this.townMapOptionBase3 == 7) {
                    var1.drawImage(this.townmapStageSelHighlight, this.hDW + 83, this.hDH - 57, 3);
                }

                this.amtIdleTime += this.C;
                if (this.TownmapStageSelEntranceFlag) {
                    if (this.townMapOptionBase3 == 0) {
                        if (this.amtIdleTime <= 0) {
                            var1.drawImage(this.amtIdle1, this.hDW - 40, this.hDH - 34, 3);
                        } else if (this.amtIdleTime <= 100) {
                            var1.drawImage(this.amtIdle2, this.hDW - 40, this.hDH - 34, 3);
                        } else if (this.amtIdleTime <= 200) {
                            var1.drawImage(this.amtIdle3, this.hDW - 40, this.hDH - 34, 3);
                        } else if (this.amtIdleTime <= 300) {
                            var1.drawImage(this.amtIdle4, this.hDW - 40, this.hDH - 34, 3);
                        } else if (this.amtIdleTime <= 400) {
                            var1.drawImage(this.amtIdle5, this.hDW - 40, this.hDH - 34, 3);
                        } else if (this.amtIdleTime >= 400) {
                            var1.drawImage(this.amtIdle5, this.hDW - 40, this.hDH - 34, 3);
                        }
                    } else if (this.townMapOptionBase3 == 1) {
                        if (this.amtIdleTime <= 0) {
                            var1.drawImage(this.amtIdle1, this.hDW - 54, this.hDH + 14, 3);
                        } else if (this.amtIdleTime <= 100) {
                            var1.drawImage(this.amtIdle2, this.hDW - 54, this.hDH + 14, 3);
                        } else if (this.amtIdleTime <= 200) {
                            var1.drawImage(this.amtIdle3, this.hDW - 54, this.hDH + 14, 3);
                        } else if (this.amtIdleTime <= 300) {
                            var1.drawImage(this.amtIdle4, this.hDW - 54, this.hDH + 14, 3);
                        } else if (this.amtIdleTime <= 400) {
                            var1.drawImage(this.amtIdle5, this.hDW - 54, this.hDH + 14, 3);
                        } else if (this.amtIdleTime >= 400) {
                            var1.drawImage(this.amtIdle5, this.hDW - 54, this.hDH + 14, 3);
                        }
                    } else if (this.townMapOptionBase3 == 2) {
                        if (this.amtIdleTime <= 0) {
                            var1.drawImage(this.amtIdle1, this.hDW - 33, this.hDH + 27, 3);
                        } else if (this.amtIdleTime <= 100) {
                            var1.drawImage(this.amtIdle2, this.hDW - 33, this.hDH + 27, 3);
                        } else if (this.amtIdleTime <= 200) {
                            var1.drawImage(this.amtIdle3, this.hDW - 33, this.hDH + 27, 3);
                        } else if (this.amtIdleTime <= 300) {
                            var1.drawImage(this.amtIdle4, this.hDW - 33, this.hDH + 27, 3);
                        } else if (this.amtIdleTime <= 400) {
                            var1.drawImage(this.amtIdle5, this.hDW - 33, this.hDH + 27, 3);
                        } else if (this.amtIdleTime >= 400) {
                            var1.drawImage(this.amtIdle5, this.hDW - 33, this.hDH + 27, 3);
                        }
                    } else if (this.townMapOptionBase3 == 3) {
                        if (this.amtIdleTime <= 0) {
                            var1.drawImage(this.amtIdle1, this.hDW + 14, this.hDH + 17, 3);
                        } else if (this.amtIdleTime <= 100) {
                            var1.drawImage(this.amtIdle2, this.hDW + 14, this.hDH + 17, 3);
                        } else if (this.amtIdleTime <= 200) {
                            var1.drawImage(this.amtIdle3, this.hDW + 14, this.hDH + 17, 3);
                        } else if (this.amtIdleTime <= 300) {
                            var1.drawImage(this.amtIdle4, this.hDW + 14, this.hDH + 17, 3);
                        } else if (this.amtIdleTime <= 400) {
                            var1.drawImage(this.amtIdle5, this.hDW + 14, this.hDH + 17, 3);
                        } else if (this.amtIdleTime >= 400) {
                            var1.drawImage(this.amtIdle5, this.hDW + 14, this.hDH + 17, 3);
                        }
                    } else if (this.townMapOptionBase3 == 4) {
                        if (this.amtIdleTime <= 0) {
                            var1.drawImage(this.amtIdle1, this.hDW + 63, this.hDH + 33, 3);
                        } else if (this.amtIdleTime <= 100) {
                            var1.drawImage(this.amtIdle2, this.hDW + 63, this.hDH + 33, 3);
                        } else if (this.amtIdleTime <= 200) {
                            var1.drawImage(this.amtIdle3, this.hDW + 63, this.hDH + 33, 3);
                        } else if (this.amtIdleTime <= 300) {
                            var1.drawImage(this.amtIdle4, this.hDW + 63, this.hDH + 33, 3);
                        } else if (this.amtIdleTime <= 400) {
                            var1.drawImage(this.amtIdle5, this.hDW + 63, this.hDH + 33, 3);
                        } else if (this.amtIdleTime >= 400) {
                            var1.drawImage(this.amtIdle5, this.hDW + 63, this.hDH + 33, 3);
                        }
                    } else if (this.townMapOptionBase3 == 5) {
                        if (this.amtIdleTime <= 0) {
                            var1.drawImage(this.amtIdle1, this.hDW + 71, this.hDH - 7, 3);
                        } else if (this.amtIdleTime <= 100) {
                            var1.drawImage(this.amtIdle2, this.hDW + 71, this.hDH - 7, 3);
                        } else if (this.amtIdleTime <= 200) {
                            var1.drawImage(this.amtIdle3, this.hDW + 71, this.hDH - 7, 3);
                        } else if (this.amtIdleTime <= 300) {
                            var1.drawImage(this.amtIdle4, this.hDW + 71, this.hDH - 7, 3);
                        } else if (this.amtIdleTime <= 400) {
                            var1.drawImage(this.amtIdle5, this.hDW + 71, this.hDH - 7, 3);
                        } else if (this.amtIdleTime >= 400) {
                            var1.drawImage(this.amtIdle5, this.hDW + 71, this.hDH - 7, 3);
                        }
                    } else if (this.townMapOptionBase3 == 6) {
                        if (this.amtIdleTime <= 0) {
                            var1.drawImage(this.amtIdle1, this.hDW + 61, this.hDH - 40, 3);
                        } else if (this.amtIdleTime <= 100) {
                            var1.drawImage(this.amtIdle2, this.hDW + 61, this.hDH - 40, 3);
                        } else if (this.amtIdleTime <= 200) {
                            var1.drawImage(this.amtIdle3, this.hDW + 61, this.hDH - 40, 3);
                        } else if (this.amtIdleTime <= 300) {
                            var1.drawImage(this.amtIdle4, this.hDW + 61, this.hDH - 40, 3);
                        } else if (this.amtIdleTime <= 400) {
                            var1.drawImage(this.amtIdle5, this.hDW + 61, this.hDH - 40, 3);
                        } else if (this.amtIdleTime >= 400) {
                            var1.drawImage(this.amtIdle5, this.hDW + 61, this.hDH - 40, 3);
                        }
                    } else if (this.townMapOptionBase3 == 7) {
                        if (this.amtIdleTime <= 0) {
                            var1.drawImage(this.amtIdle1, this.hDW + 83, this.hDH - 72, 3);
                        } else if (this.amtIdleTime <= 100) {
                            var1.drawImage(this.amtIdle2, this.hDW + 83, this.hDH - 72, 3);
                        } else if (this.amtIdleTime <= 200) {
                            var1.drawImage(this.amtIdle3, this.hDW + 83, this.hDH - 72, 3);
                        } else if (this.amtIdleTime <= 300) {
                            var1.drawImage(this.amtIdle4, this.hDW + 83, this.hDH - 72, 3);
                        } else if (this.amtIdleTime <= 400) {
                            var1.drawImage(this.amtIdle5, this.hDW + 83, this.hDH - 72, 3);
                        } else if (this.amtIdleTime >= 400) {
                            var1.drawImage(this.amtIdle5, this.hDW + 83, this.hDH - 72, 3);
                        }
                    }
                } else {
                    if (this.amtIdleTime <= 4000) {
                        if (this.townMapOptionBase3 == 0) {
                            var1.drawImage(this.amtIdle1, this.hDW - 40, this.hDH - 34, 3);
                        } else if (this.townMapOptionBase3 == 1) {
                            var1.drawImage(this.amtIdle1, this.hDW - 54, this.hDH + 14, 3);
                        } else if (this.townMapOptionBase3 == 2) {
                            var1.drawImage(this.amtIdle1, this.hDW - 33, this.hDH + 27, 3);
                        } else if (this.townMapOptionBase3 == 3) {
                            var1.drawImage(this.amtIdle1, this.hDW + 14, this.hDH + 17, 3);
                        } else if (this.townMapOptionBase3 == 4) {
                            var1.drawImage(this.amtIdle1, this.hDW + 63, this.hDH + 33, 3);
                        } else if (this.townMapOptionBase3 == 5) {
                            var1.drawImage(this.amtIdle1, this.hDW + 71, this.hDH - 7, 3);
                        } else if (this.townMapOptionBase3 == 6) {
                            var1.drawImage(this.amtIdle1, this.hDW + 61, this.hDH - 40, 3);
                        } else if (this.townMapOptionBase3 == 7) {
                            var1.drawImage(this.amtIdle1, this.hDW + 83, this.hDH - 72, 3);
                        }
                    }

                    if (this.amtIdleTime >= 4000) {
                        if (this.townMapOptionBase3 == 0) {
                            var1.drawImage(this.amtIdle2, this.hDW - 40, this.hDH - 34, 3);
                        } else if (this.townMapOptionBase3 == 1) {
                            var1.drawImage(this.amtIdle2, this.hDW - 54, this.hDH + 14, 3);
                        } else if (this.townMapOptionBase3 == 2) {
                            var1.drawImage(this.amtIdle2, this.hDW - 33, this.hDH + 27, 3);
                        } else if (this.townMapOptionBase3 == 3) {
                            var1.drawImage(this.amtIdle2, this.hDW + 14, this.hDH + 17, 3);
                        } else if (this.townMapOptionBase3 == 4) {
                            var1.drawImage(this.amtIdle2, this.hDW + 63, this.hDH + 33, 3);
                        } else if (this.townMapOptionBase3 == 5) {
                            var1.drawImage(this.amtIdle2, this.hDW + 71, this.hDH - 7, 3);
                        } else if (this.townMapOptionBase3 == 6) {
                            var1.drawImage(this.amtIdle2, this.hDW + 61, this.hDH - 40, 3);
                        } else if (this.townMapOptionBase3 == 7) {
                            var1.drawImage(this.amtIdle2, this.hDW + 83, this.hDH - 72, 3);
                        }
                    }

                    if (this.amtIdleTime >= 4050) {
                        this.amtIdleTime = 0;
                    }
                }

                if (this.townMapOptionBase3 == 0) {
                    var1.drawImage(this.townmapWindowLarge, this.hDW, this.hDH + 90, 3);
                    var1.setColor(16777215);
                    var1.drawString("STAGE 1", this.hDW, this.hDH + 64, 17);
                    var1.drawString("アミティ VS. ラフィーナ", this.hDW, this.hDH + 91, 17);
                } else if (this.townMapOptionBase3 == 1) {
                    var1.drawImage(this.townmapWindowLarge, this.hDW, this.hDH + 90, 3);
                    var1.setColor(16777215);
                    var1.drawString("STAGE 2", this.hDW, this.hDH + 64, 17);
                    var1.drawString("アミティ VS. おしゃれコウベ", this.hDW, this.hDH + 91, 17);
                } else if (this.townMapOptionBase3 == 2) {
                    var1.drawImage(this.townmapWindowLarge, this.hDW, this.hDH + 90, 3);
                    var1.setColor(16777215);
                    var1.drawString("STAGE 3", this.hDW, this.hDH + 64, 17);
                    var1.drawString("アミティ VS. リデル", this.hDW, this.hDH + 91, 17);
                } else if (this.townMapOptionBase3 == 3) {
                    var1.drawImage(this.townmapWindowLarge, this.hDW, this.hDH + 90, 3);
                    var1.setColor(16777215);
                    var1.drawString("STAGE 4", this.hDW, this.hDH + 64, 17);
                    var1.drawString("アミティ VS. どんぐりガエル", this.hDW, this.hDH + 91, 17);
                } else if (this.townMapOptionBase3 == 4) {
                    var1.drawImage(this.townmapWindowLarge, this.hDW, this.hDH + 90, 3);
                    var1.setColor(16777215);
                    var1.drawString("STAGE 5", this.hDW, this.hDH + 64, 17);
                    var1.drawString("アミティ VS. クルーク", this.hDW, this.hDH + 91, 17);
                } else if (this.townMapOptionBase3 == 5) {
                    var1.drawImage(this.townmapWindowLarge, this.hDW, this.hDH + 90, 3);
                    var1.setColor(16777215);
                    var1.drawString("STAGE 6", this.hDW, this.hDH + 64, 17);
                    var1.drawString("アミティ VS. こづれフランケン", this.hDW, this.hDH + 91, 17);
                } else if (this.townMapOptionBase3 == 6) {
                    var1.drawImage(this.townmapWindowLarge, this.hDW, this.hDH + 90, 3);
                    var1.setColor(16777215);
                    var1.drawString("STAGE 7", this.hDW, this.hDH + 64, 17);
                    var1.drawString("アミティ VS. アルル", this.hDW, this.hDH + 91, 17);
                } else if (this.townMapOptionBase3 == 7) {
                    var1.drawImage(this.townmapWindowLarge, this.hDW, this.hDH + 90, 3);
                    var1.setColor(16777215);
                    var1.drawString("STAGE 8", this.hDW, this.hDH + 64, 17);
                    var1.drawString("アミティ VS. ポポイ", this.hDW, this.hDH + 91, 17);
                }

                if (!this.TownmapStageSelEntranceFlag) {
                    if (this.townMapOptionBase3 != 0) {
                        var1.drawString("↓", this.hDW + 95, this.hDH + 64, 17);
                    }

                    if (this.townMapOptionBase3 != 7) {
                        var1.drawString("↑", this.hDW - 95, this.hDH + 64, 17);
                    }
                }

                if (this.TownmapStageSelEntranceFlag) {
                    this.setSoftkeyText("", "");
                } else {
                    this.setSoftkeyText("すべて再生", "戻る");
                }

                if (this.TownmapStageSelEntranceFlag && this.amtIdleTime >= 1400) {
                    this.TownmapStageSelEntranceFlag = false;
                    switch(this.townMapOptionBase3) {
                    case 0:
                        this.TownmapStageSelFlag = true;
                        this.amtIdleTime = 0;
                        this.optionMenuBase1 = 7;
                        this.menu = true;
                        this.aw = 1;
                        this.br = 2;
                        this.optionMenuBase2 = 0;
                        this.singlePuyoPopBase = 3;
						this.fadeFlag = true;
                        this.fadeCode = 19;
                        this.E = 46;
                        break;
                    case 1:
                        this.TownmapStageSelFlag = true;
                        this.amtIdleTime = 0;
                        this.optionMenuBase1 = 7;
                        this.menu = true;
                        this.aw = 1;
                        this.br = 2;
                        this.optionMenuBase2 = 0;
                        this.singlePuyoPopBase = 4;
						this.fadeFlag = true;
                        this.fadeCode = 19;
                        this.E = 46;
                        break;
                    case 2:
                        this.TownmapStageSelFlag = true;
                        this.amtIdleTime = 0;
                        this.optionMenuBase1 = 7;
                        this.menu = true;
                        this.aw = 1;
                        this.br = 2;
                        this.optionMenuBase2 = 0;
                        this.singlePuyoPopBase = 5;
						this.fadeFlag = true;
                        this.fadeCode = 19;
                        this.E = 46;
                        break;
                    case 3:
                        this.TownmapStageSelFlag = true;
                        this.amtIdleTime = 0;
                        this.optionMenuBase1 = 7;
                        this.menu = true;
                        this.aw = 1;
                        this.br = 2;
                        this.optionMenuBase2 = 0;
                        this.singlePuyoPopBase = 6;
						this.fadeFlag = true;
                        this.fadeCode = 19;
                        this.E = 46;
                        break;
                    case 4:
                        this.TownmapStageSelFlag = true;
                        this.amtIdleTime = 0;
                        this.optionMenuBase1 = 7;
                        this.menu = true;
                        this.aw = 1;
                        this.br = 2;
                        this.optionMenuBase2 = 0;
                        this.singlePuyoPopBase = 7;
						this.fadeFlag = true;
                        this.fadeCode = 19;
                        this.E = 46;
                        break;
                    case 5:
                        this.TownmapStageSelFlag = true;
                        this.amtIdleTime = 0;
                        this.optionMenuBase1 = 7;
                        this.menu = true;
                        this.aw = 1;
                        this.br = 2;
                        this.optionMenuBase2 = 0;
                        this.singlePuyoPopBase = 8;
						this.fadeFlag = true;
                        this.fadeCode = 19;
                        this.E = 46;
                        break;
                    case 6:
                        this.TownmapStageSelFlag = true;
                        this.amtIdleTime = 0;
                        this.optionMenuBase1 = 7;
                        this.menu = true;
                        this.aw = 1;
                        this.br = 2;
                        this.optionMenuBase2 = 0;
                        this.singlePuyoPopBase = 9;
						this.fadeFlag = true;
                        this.fadeCode = 19;
                        this.E = 46;
                        break;
                    case 7:
                        this.TownmapStageSelFlag = true;
                        this.amtIdleTime = 0;
                        this.optionMenuBase1 = 7;
                        this.menu = true;
                        this.aw = 1;
                        this.br = 2;
                        this.optionMenuBase2 = 0;
                        this.singlePuyoPopBase = 10;
						this.fadeFlag = true;
                        this.fadeCode = 19;
                        this.E = 46;
                    }
                }

                if ((this.s & 1) != 0) {
                    if (!this.TownmapStageSelEntranceFlag) {
                        ++this.townMapOptionBase3;
                        if (this.townMapOptionBase3 > 7) {
                            this.townMapOptionBase3 = 7;
                        } else if (this.sfxType == 1 || this.sfxType == 2) {
                            try {
                                ((VolumeControl)this.menuChoose.getControl("VolumeControl")).setLevel(this.b);
                                this.menuChoose.start();
                            } catch (Exception var) {
                                var.printStackTrace();
                            }
                        }
                    }
                } else if ((this.s & 4) != 0) {
                    if (!this.TownmapStageSelEntranceFlag) {
                        --this.townMapOptionBase3;
                        if (this.townMapOptionBase3 < 0) {
                            this.townMapOptionBase3 = 0;
                        } else if (this.sfxType == 1 || this.sfxType == 2) {
                            try {
                                ((VolumeControl)this.menuChoose.getControl("VolumeControl")).setLevel(this.b);
                                this.menuChoose.start();
                            } catch (Exception var36) {
                                var36.printStackTrace();
                            }
                        }
                    }
                } else if ((this.s & 16) != 0) {
                    if (!this.TownmapStageSelEntranceFlag) {
                        if (this.sfxType == 1 || this.sfxType == 2) {
    						if (this.voiceLangType == 0) {
                                try {
                                    ((VolumeControl)this.amtStartVoice.getControl("VolumeControl")).setLevel(this.b);
                                    this.amtStartVoice.start();
                                } catch (Exception var) {
                                  var.printStackTrace();
                                }
	    			  		} else if (this.voiceLangType == 1) {
                                try {
                                    ((VolumeControl)this.amtStartVoiceEN.getControl("VolumeControl")).setLevel(this.b);
                                    this.amtStartVoiceEN.start();
                                } catch (Exception var) {
                                  var.printStackTrace();
                                }
			    			}
                        }

                        this.amtIdleTime = 0;
                        this.TownmapStageSelEntranceFlag = true;
                    }
                } else if ((this.s & 32) != 0) {
                    if (!this.TownmapStageSelEntranceFlag) {
                        this.amtIdleTime = 0;
                        this.optionMenuBase2 = 0;
						this.fadeFlag = true;
                        this.fadeCode = 5;
                        this.E = 46;
                    }
                } else if ((this.s & 64) != 0 && !this.TownmapStageSelEntranceFlag) {
                    if (this.sfxType == 1 || this.sfxType == 2) {
                        try {
                            ((VolumeControl)this.menuBack.getControl("VolumeControl")).setLevel(this.b);
                            this.menuBack.start();
                        } catch (Exception var35) {
                            var35.printStackTrace();
                        }
                    }

                    this.amtIdleTime = 0;
                    this.optionMenuBase2 = 0;
                    this.townMapOptionBase3 = 0;
                    this.i();
                    this.TownmapSinglePuyoPopEntraceFlag = true;
					this.fadeFlag = true;
                    this.fadeCode = 14;
                    this.E = 46;
                }
			    break;
            case 108:
                var1.setColor(0);
                var1.fillRect(this.hDW - 120, 30, 240, 260);
                var1.drawImage(this.mainBg, this.hDW, this.hDH, 3);
                if (this.endingManzaiBase == 0) {
                    var1.drawImage(this.wakuwakuEdBkg1, this.hDW, this.hDH, 3);
                    var1.drawImage(this.townmapMsgWindow, this.hDW, this.hDH + 76, 3);
                    var1.setColor(16777215);
                    var1.drawString("アミティ", this.hDW - 106, this.hDH + 31, 20);
                    var1.drawString("やったぁ!", this.hDW - 91, this.hDH + 55, 20);
                    var1.drawString("ついに 飛翔の", this.hDW - 91, this.hDH + 76, 20);
                    var1.drawString("紋を手にいれたよ!", this.hDW - 91, this.hDH + 97, 20);
                } else if (this.endingManzaiBase == 1) {
                    var1.drawImage(this.wakuwakuEdBkg1, this.hDW, this.hDH, 3);
                    var1.drawImage(this.townmapMsgWindow, this.hDW, this.hDH + 76, 3);
                    var1.setColor(16777215);
                    var1.drawString("アコール", this.hDW - 106, this.hDH + 31, 20);
                    var1.drawString("おめでとう、", this.hDW - 91, this.hDH + 55, 20);
                    var1.drawString("アミティさん!", this.hDW - 91, this.hDH + 76, 20);
                    var1.drawString("", this.hDW - 91, this.hDH + 97, 20);
                } else if (this.endingManzaiBase == 2) {
                    var1.drawImage(this.wakuwakuEdBkg2, this.hDW, this.hDH, 3);
                    var1.drawImage(this.townmapMsgWindow, this.hDW, this.hDH + 76, 3);
                    var1.setColor(16777215);
                    var1.drawString("アミティ", this.hDW - 106, this.hDH + 31, 20);
                    var1.drawString("あ、 先生!", this.hDW - 91, this.hDH + 55, 20);
                    var1.drawString("はい、 飛翔のは", this.hDW - 91, this.hDH + 76, 20);
                    var1.drawString("お返しします", this.hDW - 91, this.hDH + 97, 20);
                } else if (this.endingManzaiBase == 3) {
                    var1.drawImage(this.wakuwakuEdBkg2, this.hDW, this.hDH, 3);
                    var1.drawImage(this.townmapMsgWindow, this.hDW, this.hDH + 76, 3);
                    var1.setColor(16777215);
                    var1.drawString("アコール", this.hDW - 106, this.hDH + 31, 20);
                    var1.drawString("ありがとう...", this.hDW - 91, this.hDH + 55, 20);
                    var1.drawString("", this.hDW - 91, this.hDH + 76, 20);
                    var1.drawString("", this.hDW - 91, this.hDH + 97, 20);
                } else if (this.endingManzaiBase == 4) {
                    var1.drawImage(this.wakuwakuEdBkg2, this.hDW, this.hDH, 3);
                    var1.drawImage(this.townmapMsgWindow, this.hDW, this.hDH + 76, 3);
                    var1.setColor(16777215);
                    var1.drawString("アコール", this.hDW - 106, this.hDH + 31, 20);
                    var1.drawString("アミティさんには、", this.hDW - 91, this.hDH + 55, 20);
                    var1.drawString("ごほうびを ", this.hDW - 91, this.hDH + 76, 20);
                    var1.drawString("あげなくてはね.", this.hDW - 91, this.hDH + 97, 20);
                } else if (this.endingManzaiBase == 5) {
                    var1.drawImage(this.wakuwakuEdBkg2, this.hDW, this.hDH, 3);
                    var1.drawImage(this.townmapMsgWindow, this.hDW, this.hDH + 76, 3);
                    var1.setColor(16777215);
                    var1.drawString("アミティ", this.hDW - 106, this.hDH + 31, 20);
                    var1.drawString("いやぁ いいんです", this.hDW - 91, this.hDH + 55, 20);
                    var1.drawString("よそんなのぉ", this.hDW - 91, this.hDH + 76, 20);
                    var1.drawString("", this.hDW - 91, this.hDH + 97, 20);
                } else if (this.endingManzaiBase == 6) {
                    var1.drawImage(this.wakuwakuEdBkg2, this.hDW, this.hDH, 3);
                    var1.drawImage(this.townmapMsgWindow, this.hDW, this.hDH + 76, 3);
                    var1.setColor(16777215);
                    var1.drawString("ポポイ", this.hDW - 106, this.hDH + 31, 20);
                    var1.drawString("おぉそうか! ", this.hDW - 91, this.hDH + 55, 20);
                    var1.drawString("それじゃあ、ごほう", this.hDW - 91, this.hDH + 76, 20);
                    var1.drawString("びはナシだにゃ~", this.hDW - 91, this.hDH + 97, 20);
                } else if (this.endingManzaiBase == 7) {
                    var1.drawImage(this.wakuwakuEdBkg2, this.hDW, this.hDH, 3);
                    var1.drawImage(this.townmapMsgWindow, this.hDW, this.hDH + 76, 3);
                    var1.setColor(16777215);
                    var1.drawString("アコール", this.hDW - 106, this.hDH + 31, 20);
                    var1.drawString("あら そうなの? アミティ", this.hDW - 91, this.hDH + 55, 20);
                    var1.drawString("さんって意外と奥ゆかし", this.hDW - 91, this.hDH + 76, 20);
                    var1.drawString("い あアの ルミね?", this.hDW - 91, this.hDH + 97, 20);
                } else if (this.endingManzaiBase == 8) {
                    var1.drawImage(this.wakuwakuEdBkg2, this.hDW, this.hDH, 3);
                    var1.drawImage(this.townmapMsgWindow, this.hDW, this.hDH + 76, 3);
                    var1.setColor(16777215);
                    var1.drawString("アコール", this.hDW - 106, this.hDH + 31, 20);
                    var1.drawString("先生、見直", this.hDW - 91, this.hDH + 55, 20);
                    var1.drawString("しちゃった", this.hDW - 91, this.hDH + 76, 20);
                    var1.drawString("", this.hDW - 91, this.hDH + 97, 20);
                } else if (this.endingManzaiBase == 9) {
                    var1.drawImage(this.wakuwakuEdBkg3, this.hDW, this.hDH, 3);
                    var1.drawImage(this.townmapMsgWindow, this.hDW, this.hDH + 76, 3);
                    var1.setColor(16777215);
                    var1.drawString("アミティ", this.hDW - 106, this.hDH + 31, 20);
                    var1.drawString("え?  いや...", this.hDW - 91, this.hDH + 55, 20);
                    var1.drawString("えーと...", this.hDW - 91, this.hDH + 76, 20);
                    var1.drawString("あの... その...", this.hDW - 91, this.hDH + 97, 20);
                } else if (this.endingManzaiBase == 10) {
                    var1.drawImage(this.wakuwakuEdBkg3, this.hDW, this.hDH, 3);
                    var1.drawImage(this.townmapMsgWindow, this.hDW, this.hDH + 76, 3);
                    var1.setColor(16777215);
                    var1.drawString("アコール", this.hDW - 106, this.hDH + 31, 20);
                    var1.drawString("さあ、", this.hDW - 91, this.hDH + 55, 20);
                    var1.drawString("みんなってるわ! ", this.hDW - 91, this.hDH + 76, 20);
                    var1.drawString("学校に帰りましょう", this.hDW - 91, this.hDH + 97, 20);
                } else if (this.endingManzaiBase == 11) {
                    var1.drawImage(this.wakuwakuEdBkg3, this.hDW, this.hDH, 3);
                    var1.drawImage(this.townmapMsgWindow, this.hDW, this.hDH + 76, 3);
                    var1.setColor(16777215);
                    var1.drawString("アミティ", this.hDW - 106, this.hDH + 31, 20);
                    var1.drawString("そ、そんなぁ...", this.hDW - 91, this.hDH + 55, 20);
                    var1.drawString("", this.hDW - 91, this.hDH + 76, 20);
                    var1.drawString("", this.hDW - 91, this.hDH + 97, 20);
                }

                this.setSoftkeyText("次へ", "");
                if ((this.s & 16) != 0) {
                    if (this.sfxType == 1 || this.sfxType == 2) {
                        try {
                            ((VolumeControl)this.menuSelect.getControl("VolumeControl")).setLevel(this.b);
                            this.menuSelect.start();
                        } catch (Exception var) {
                            var.printStackTrace();
                        }
                    }

                    ++this.endingManzaiBase;
                    if (this.endingManzaiBase > 11) {
                        this.optionMenuBase2 = 0;
                        this.endingManzaiBase = 0;
						this.fadeFlag = true;
                        this.fadeCode = 21;
                        this.E = 46;
                    }
                } else if ((this.s & 32) != 0) {
                    if (this.sfxType == 1 || this.sfxType == 2) {
                        try {
                            ((VolumeControl)this.menuSelect.getControl("VolumeControl")).setLevel(this.b);
                            this.menuSelect.start();
                        } catch (Exception var) {
                            var.printStackTrace();
                        }
                    }

                    this.optionMenuBase2 = 0;
                    this.endingManzaiBase = 0;
					this.fadeFlag = true;
                    this.fadeCode = 21;
                    this.E = 46;
                }
                break;
            case 109:
                var1.drawImage(this.dimBg, this.hDW, this.hDH, 3);
                var1.drawImage(this.msgWindow2, this.hDW, this.hDH, 3);
                var1.setColor(6375051);
                var1.drawString("ステージセレクトが", this.hDW, this.hDH - 60, 33);
                var1.drawString("るんるんコース", this.hDW, this.hDH - 30, 33);
                var1.drawString("に登場!", this.hDW, this.hDH + 0, 33);
                var1.drawString("(ひとりでぶよぶよ)", this.hDW, this.hDH + 30, 33);
                var1.drawImage(this.pauseMenuSelHigh, this.hDW, this.hDH + 64, 3);
                var1.setColor(16777215);
                var1.drawString("OK", this.hDW, this.hDH + 77, 33);
                this.setSoftkeyText("", "");
                if ((this.s & 16) != 0) {
                    this.RunRunStageSelUnlockedFlag = true;
                    this.optionMenuBase2 = 0;
					this.fadeFlag = true;
                    this.fadeCode = 20;
                    this.E = 46;
                }
                break;
            case 110:
                var1.drawImage(this.dimBg, this.hDW, this.hDH, 3);
                var1.drawImage(this.msgWindow2, this.hDW, this.hDH, 3);
                var1.setColor(6375051);
                var1.drawString("ステージセレクトが", this.hDW, this.hDH - 60, 33);
                var1.drawString("わくわくコース", this.hDW, this.hDH - 30, 33);
                var1.drawString("に登場!", this.hDW, this.hDH + 0, 33);
                var1.drawString("(ひとりでぶよぶよ)", this.hDW, this.hDH + 30, 33);
                var1.drawImage(this.pauseMenuSelHigh, this.hDW, this.hDH + 64, 3);
                var1.setColor(16777215);
                var1.drawString("OK", this.hDW, this.hDH + 77, 33);
                this.setSoftkeyText("", "");
                if ((this.s & 16) != 0) {
                    this.WakuWakuStageSelUnlockedFlag = true;
                    this.optionMenuBase2 = 0;
					this.fadeFlag = true;
                    this.fadeCode = 20;
                    this.E = 46;
                }
                break;
            case 111:
                this.E = 109;
                break;
            case 112:
                this.E = 110;
                break;
			case 113:
                var1.drawImage(this.dimBg, this.hDW, this.hDH, 3);
                var1.drawImage(this.msgWindow1, this.hDW, this.hDH, 3);
                var1.drawImage(this.optMenuSel, this.hDW, this.hDH - 46, 3);
                var1.drawImage(this.optMenuSel, this.hDW, this.hDH - 16, 3);
                if (this.townMapOptionBase2 == 0) {
                    var1.drawImage(this.optMenuSelHigh, this.hDW, this.hDH - 46, 3);
                } else if (this.townMapOptionBase2 == 1) {
                    var1.drawImage(this.optMenuSelHigh, this.hDW, this.hDH - 16, 3);
                }

                var1.setColor(2406101);
                var1.drawString("ゲームプレイ", this.hDW - 74, this.hDH - 100, 20);
                var1.drawString("ゲームプレイ", this.hDW - 72, this.hDH - 100, 20);
                var1.drawString("ゲームプレイ", this.hDW - 73, this.hDH - 101, 20);
                var1.drawString("ゲームプレイ", this.hDW - 73, this.hDH - 99, 20);
                var1.drawString("ゲームプレイ", this.hDW - 72, this.hDH - 98, 20);
                var1.drawString("ゲームプレイ", this.hDW - 71, this.hDH - 98, 20);
                var1.setColor(16777215);
                var1.drawString("ゲームプレイ", this.hDW - 73, this.hDH - 100, 20);
                if (this.townMapOptionBase2 == 0) {
                    var1.setColor(16777215);
                } else {
                    var1.setColor(6375051);
                }

                var1.drawString("振動", this.hDW - 75, this.hDH - 58, 20);
                if (this.vibSetting) {
                    var1.drawString("オン", this.hDW + 78, this.hDH - 58, 24);
                } else {
                    var1.drawString("オフ", this.hDW + 78, this.hDH - 58, 24);
                }

                if (this.townMapOptionBase2 == 1) {
                    var1.setColor(16777215);
                } else {
                    var1.setColor(6375051);
                }

                var1.drawString("テーマ", this.hDW - 75, this.hDH - 28, 20);
                if (this.ingameBgColorType == 4) {
                    var1.drawString("OGフィーバー", this.hDW + 78, this.hDH - 28, 24);
                } else if (this.ingameBgColorType == 3) {
                    var1.drawString("オレンジ", this.hDW + 78, this.hDH - 28, 24);
                } else if (this.ingameBgColorType == 2) {
                    var1.drawString("青色", this.hDW + 78, this.hDH - 28, 24);
                } else if (this.ingameBgColorType == 1) {
                    var1.drawString("ピンク", this.hDW + 78, this.hDH - 28, 24);
                }

                var1.setColor(2406101);
                if (this.townMapOptionBase2 == 0) {
                    var1.drawString("ゲームの振動", this.hDW - 85, this.hDH + 37, 20);
                    var1.drawString("をトグルします。", this.hDW - 85, this.hDH + 67, 20);
                } else if (this.townMapOptionBase2 == 1) {
                    var1.drawString("ゲーム内の背景", this.hDW - 85, this.hDH + 37, 20);
                    var1.drawString("テーマを変更する。", this.hDW - 85, this.hDH + 67, 20);
                }

                if (this.bgColorChangeFlag) {
                    this.setSoftkeyText("変化", "セーブ");
                } else {
                    this.setSoftkeyText("変化", "戻る");
                }
				
                if ((this.s & 1) != 0) {
                    --this.townMapOptionBase2;
                    if (this.townMapOptionBase2 < 0) {
                        this.townMapOptionBase2 = 1;
                    }
                } else if ((this.s & 4) != 0) {
                    ++this.townMapOptionBase2;
                    if (this.townMapOptionBase2 > 1) {
                        this.townMapOptionBase2 = 0;
                    }
                } else if ((this.s & 16) == 0 && (this.s & 32) == 0) {
                    if ((this.s & 64) != 0) {
                        this.optionMenuBase2 = 0;
                        this.townMapOptionBase2 = 0;
                        if (this.bgColorChangeFlag) {
							this.bgColorChangeFlag = false;
							this.loadBGColor();
                        }
						
					    if (this.gameError) {
					    	this.E = 44;
					    } else {
                            this.u();
                            this.E = 100;
                        }
					}
                } else {
                    switch(this.townMapOptionBase2) {
                    case 0:
                        if (this.vibSetting) {
                            this.vibSetting = false;
                        } else {
                            this.vibSetting = true;
                        }
                        break label4905;
                    case 1:
					    this.bgColorChangeFlag = true;
                        switch(this.ingameBgColorType) {
                        case 2:
                            this.ingameBgColorType = 1;
                            break label4905;
                        case 3:
                            this.ingameBgColorType = 2;
                            break label4905;
                        case 4:
                            this.ingameBgColorType = 3;
                            break label4905;
                        default:
                            this.ingameBgColorType = 4;
                            break label4905;
                        }
                    }
                }
                break;
			case 114:
                var1.drawImage(this.dimBg, this.hDW, this.hDH, 3);
                var1.drawImage(this.msgWindow1, this.hDW, this.hDH, 3);
                var1.setColor(2406101);
                var1.drawString("困難", this.hDW - 74, this.hDH - 100, 20);
                var1.drawString("困難", this.hDW - 72, this.hDH - 100, 20);
                var1.drawString("困難", this.hDW - 73, this.hDH - 101, 20);
                var1.drawString("困難", this.hDW - 73, this.hDH - 99, 20);
                var1.drawString("困難", this.hDW - 72, this.hDH - 98, 20);
                var1.drawString("困難", this.hDW - 71, this.hDH - 98, 20);
                var1.setColor(16777215);
                var1.drawString("困難", this.hDW - 73, this.hDH - 100, 20);
                var1.setColor(6375051);
                var1.drawString("ゲームの難易度", this.hDW, this.hDH - 70, 17);
                var1.drawString("を設定します:", this.hDW, this.hDH - 42, 17);
                var1.drawString("ハードの方が", this.hDW, this.hDH - 14, 17);
                var1.drawString("難易度が高い。", this.hDW, this.hDH + 14, 17);
                var1.drawString("↑", this.hDW - 60, this.hDH + 47, 17);
                var1.drawString("↓", this.hDW + 60, this.hDH + 47, 17);
                if (this.difficultyType == 4) {
                    if (this.townMapOptionBase2 == 4) {
                        var1.drawImage(this.pauseMenuSelHigh, this.hDW, this.hDH + 60, 3);
                    } else {
                        var1.drawImage(this.pauseMenuSel, this.hDW, this.hDH + 60, 3);
                    }
                } else if (this.difficultyType == 3) {
                    if (this.townMapOptionBase2 == 3) {
                        var1.drawImage(this.pauseMenuSelHigh, this.hDW, this.hDH + 60, 3);
                    } else {
                        var1.drawImage(this.pauseMenuSel, this.hDW, this.hDH + 60, 3);
                    }
                } else if (this.difficultyType == 2) {
                    if (this.townMapOptionBase2 == 2) {
                        var1.drawImage(this.pauseMenuSelHigh, this.hDW, this.hDH + 60, 3);
                    } else {
                        var1.drawImage(this.pauseMenuSel, this.hDW, this.hDH + 60, 3);
                    }
                } else if (this.difficultyType == 1) {
                    if (this.townMapOptionBase2 == 1) {
                        var1.drawImage(this.pauseMenuSelHigh, this.hDW, this.hDH + 60, 3);
                    } else {
                        var1.drawImage(this.pauseMenuSel, this.hDW, this.hDH + 60, 3);
                    }
                }

                if (this.difficultyType == 4) {
                    if (this.townMapOptionBase2 == 4) {
                        var1.setColor(16777215);
                    } else {
                        var1.setColor(6375051);
                    }

                    var1.drawString("非常にハード", this.hDW, this.hDH + 47, 17);
                } else if (this.difficultyType == 3) {
                    if (this.townMapOptionBase2 == 3) {
                        var1.setColor(16777215);
                    } else {
                        var1.setColor(6375051);
                    }

                    var1.drawString("イージー", this.hDW, this.hDH + 47, 17);
                } else if (this.difficultyType == 2) {
                    if (this.townMapOptionBase2 == 2) {
                        var1.setColor(16777215);
                    } else {
                        var1.setColor(6375051);
                    }

                    var1.drawString("ノーマル", this.hDW, this.hDH + 47, 17);
                } else if (this.difficultyType == 1) {
                    if (this.townMapOptionBase2 == 1) {
                        var1.setColor(16777215);
                    } else {
                        var1.setColor(6375051);
                    }

                    var1.drawString("ハード", this.hDW, this.hDH + 47, 17);
                }

                if (this.puyoSkinChangeFlag) {
                    this.setSoftkeyText("セーブ", "戻る");
                } else {
                    this.setSoftkeyText("", "戻る");
                }

                if ((this.s & 1) != 0) {
                    if (this.sfxType == 1 || this.sfxType == 2) {
                        try {
                            ((VolumeControl)this.menuChoose.getControl("VolumeControl")).setLevel(this.b);
                            this.menuChoose.start();
                        } catch (Exception var45) {
                            var45.printStackTrace();
                        }
                    }

                    ++this.difficultyType;
                    if (this.difficultyType > 4) {
                        this.difficultyType = 1;
                    }

                    this.puyoSkinChangeFlag = true;
                } else if ((this.s & 4) != 0) {
                    if (this.sfxType == 1 || this.sfxType == 2) {
                        try {
                            ((VolumeControl)this.menuChoose.getControl("VolumeControl")).setLevel(this.b);
                            this.menuChoose.start();
                        } catch (Exception var) {
                            var.printStackTrace();
                        }
                    }

                    --this.difficultyType;
                    if (this.difficultyType < 1) {
                        this.difficultyType = 4;
                    }

                    this.puyoSkinChangeFlag = true;
                } else if (((this.s & 16) != 0 || (this.s & 32) != 0) && this.puyoSkinChangeFlag) {
                    if (this.sfxType == 1 || this.sfxType == 2) {
                        try {
                            ((VolumeControl)this.menuSelect.getControl("VolumeControl")).setLevel(this.b);
                            this.menuSelect.start();
                        } catch (Exception var48) {
                            var48.printStackTrace();
                        }
                    }

					
                    if (this.puyoSkinChangeFlag) {
                        this.puyoSkinChangeFlag = false;
                    }

                    this.optionMenuBase2 = 0;
                    this.townMapOptionBase2 = 0;
                    this.u();
                    this.E = 100;
                } else {
                    if ((this.s & 64) == 0) {
                        break;
                    }

                    if (this.sfxType == 1 || this.sfxType == 2) {
                        try {
                            ((VolumeControl)this.menuBack.getControl("VolumeControl")).setLevel(this.b);
                            this.menuBack.start();
                        } catch (Exception var47) {
                            var47.printStackTrace();
                        }
                    }

                    if (this.townMapOptionBase2 == 1) {
                        this.difficultyType = 1;
                    } else if (this.townMapOptionBase2 == 2) {
                        this.difficultyType = 2;
                    } else if (this.townMapOptionBase2 == 3) {
                        this.difficultyType = 3;
                    } else if (this.townMapOptionBase2 == 3) {
                        this.difficultyType = 4;
                    }

                    if (this.puyoSkinChangeFlag) {
                        this.puyoSkinChangeFlag = false;
                    }

                    this.optionMenuBase2 = 0;
                    this.townMapOptionBase2 = 0;
                    this.E = 100;
                }
                break;
            }

            this.X = false;
            this.Y[0] = false;
            this.Y[1] = false;
            this.Z[0] = false;
            this.Z[1] = false;
            this.aa[0] = false;
            this.aa[1] = false;
            this.ab[0] = false;
            this.ab[1] = false;
            this.ac[0] = false;
            this.ac[1] = false;
        } catch (Exception var102) {
            var102.printStackTrace();
        }

        var1.setColor(0);
        var1.fillRect(0, this.aq, this.displayWidth, this.displayHeight - this.aq);
        var1.fillRect(0, 0, this.displayWidth, this.menuBaseC);

		if (this.loadedFlag) {
            this.refreshTime += 50;
		    if (this.refreshTime >= 1000) {
                this.currentDisplayWidth = this.getWidth();
                this.refreshTime = 0;
		    }
		}
		
		if (this.displayWidth != this.currentDisplayWidth) {
            this.displayWidth = this.getWidth();
            this.displayHeight = this.getHeight();
            this.hDW = this.getWidth() >> 1;
            this.hDH = this.getHeight() >> 1;
            this.an = this.hDW - 120;
            this.ao = this.hDW + 120;
            this.menuBaseC = this.hDH - 130;
            this.aq = this.hDH + 130;
            this.at = this.ak.charWidth('a') << 1;
            this.au = this.ak.getHeight();
            this.av = this.hDW - this.at * 9 / 2;
		}

		if (this.saveFlag) {
            this.saveTime += 50;
			var1.setColor(10896);
			var1.drawString("節約...", this.hDW + 72, this.hDH - 91, 40);
			var1.drawString("節約...", this.hDW + 72, this.hDH - 89, 40);
			var1.drawString("節約...", this.hDW + 71, this.hDH - 90, 40);
			var1.drawString("節約...", this.hDW + 73, this.hDH - 90, 40);
			var1.drawString("節約...", this.hDW + 73, this.hDH - 88, 40);
			var1.drawString("節約...", this.hDW + 74, this.hDH - 88, 40);
			var1.drawString("節約...", this.hDW + 74, this.hDH - 89, 40);
			var1.setColor(16777215);
			var1.drawString("節約...", this.hDW + 72, this.hDH - 90, 40);
			var1.drawImage(this.saveIcon, this.hDW + 94, this.hDH - 101, 3);
			if (this.saveTime >= 1200) {
				this.saveFlag = false;
                this.saveTime = 0;
			}
		}

		if (this.displayWidth == 800 && this.displayHeight == 352) {
            try {
                if (this.leftSoftkeyText.length() != 0) {
                    var1.drawImage(this.leftSoftkeyLargeImageE90, this.displayWidth, this.displayHeight - 352, 24);
                    var1.setColor(10896);
                    var1.drawString(this.leftSoftkeyText, this.displayWidth - 34, this.displayHeight - 325, 40);
                    var1.drawString(this.leftSoftkeyText, this.displayWidth - 34, this.displayHeight - 323, 40);
                    var1.drawString(this.leftSoftkeyText, this.displayWidth - 35, this.displayHeight - 324, 40);
                    var1.drawString(this.leftSoftkeyText, this.displayWidth - 33, this.displayHeight - 324, 40);
                    var1.drawString(this.leftSoftkeyText, this.displayWidth - 33, this.displayHeight - 322, 40);
                    var1.drawString(this.leftSoftkeyText, this.displayWidth - 32, this.displayHeight - 322, 40);
                    var1.drawString(this.leftSoftkeyText, this.displayWidth - 32, this.displayHeight - 323, 40);
                    var1.setColor(16777215);
                    var1.drawString(this.leftSoftkeyText, this.displayWidth - 34, this.displayHeight - 324, 40);
                }

                if (this.rightSoftkeyText.length() != 0) {
                    var1.drawImage(this.rightSoftkeyLargeImage, this.displayWidth, this.displayHeight, 40);
                    var1.setColor(10896);
                    var1.drawString(this.rightSoftkeyText, this.displayWidth - 34, this.displayHeight - 5, 40);
                    var1.drawString(this.rightSoftkeyText, this.displayWidth - 34, this.displayHeight - 3, 40);
                    var1.drawString(this.rightSoftkeyText, this.displayWidth - 35, this.displayHeight - 4, 40);
                    var1.drawString(this.rightSoftkeyText, this.displayWidth - 33, this.displayHeight - 4, 40);
                    var1.drawString(this.rightSoftkeyText, this.displayWidth - 33, this.displayHeight - 2, 40);
                    var1.drawString(this.rightSoftkeyText, this.displayWidth - 32, this.displayHeight - 2, 40);
                    var1.drawString(this.rightSoftkeyText, this.displayWidth - 32, this.displayHeight - 3, 40);
                    var1.setColor(16777215);
                    var1.drawString(this.rightSoftkeyText, this.displayWidth - 34, this.displayHeight - 4, 40);
                }
            } catch (Exception var) {
            }
		} else if (this.displayWidth >= 400 && this.displayHeight >= 350) {
            try {
                if (this.leftSoftkeyText.length() != 0) {
                    var1.drawImage(this.leftSoftkeyLargeImage, 0, this.displayHeight, 36);
                    var1.setColor(10896);
                    var1.drawString(this.leftSoftkeyText, 34, this.displayHeight - 5, 36);
                    var1.drawString(this.leftSoftkeyText, 34, this.displayHeight - 3, 36);
                    var1.drawString(this.leftSoftkeyText, 33, this.displayHeight - 4, 36);
                    var1.drawString(this.leftSoftkeyText, 35, this.displayHeight - 4, 36);
                    var1.drawString(this.leftSoftkeyText, 35, this.displayHeight - 2, 36);
                    var1.drawString(this.leftSoftkeyText, 36, this.displayHeight - 2, 36);
                    var1.drawString(this.leftSoftkeyText, 36, this.displayHeight - 3, 36);
                    var1.setColor(16777215);
                    var1.drawString(this.leftSoftkeyText, 34, this.displayHeight - 4, 36);
                }

                if (this.rightSoftkeyText.length() != 0) {
                    var1.drawImage(this.rightSoftkeyLargeImage, this.displayWidth, this.displayHeight, 40);
                    var1.setColor(10896);
                    var1.drawString(this.rightSoftkeyText, this.displayWidth - 34, this.displayHeight - 5, 40);
                    var1.drawString(this.rightSoftkeyText, this.displayWidth - 34, this.displayHeight - 3, 40);
                    var1.drawString(this.rightSoftkeyText, this.displayWidth - 35, this.displayHeight - 4, 40);
                    var1.drawString(this.rightSoftkeyText, this.displayWidth - 33, this.displayHeight - 4, 40);
                    var1.drawString(this.rightSoftkeyText, this.displayWidth - 33, this.displayHeight - 2, 40);
                    var1.drawString(this.rightSoftkeyText, this.displayWidth - 32, this.displayHeight - 2, 40);
                    var1.drawString(this.rightSoftkeyText, this.displayWidth - 32, this.displayHeight - 3, 40);
                    var1.setColor(16777215);
                    var1.drawString(this.rightSoftkeyText, this.displayWidth - 34, this.displayHeight - 4, 40);
                }
            } catch (Exception var) {
            }
		} else {
            try {
                if (this.leftSoftkeyText.length() != 0) {
                    var1.drawImage(this.leftSoftkeyImage, 0, this.displayHeight, 36);
                    var1.setColor(10896);
                    var1.drawString(this.leftSoftkeyText, 39, this.displayHeight - 3, 33);
                    var1.drawString(this.leftSoftkeyText, 39, this.displayHeight - 1, 33);
                    var1.drawString(this.leftSoftkeyText, 38, this.displayHeight - 2, 33);
                    var1.drawString(this.leftSoftkeyText, 40, this.displayHeight - 2, 33);
                    var1.drawString(this.leftSoftkeyText, 40, this.displayHeight - 0, 33);
                    var1.drawString(this.leftSoftkeyText, 41, this.displayHeight - 0, 33);
                    var1.drawString(this.leftSoftkeyText, 41, this.displayHeight - 1, 33);
                    var1.setColor(16777215);
                    var1.drawString(this.leftSoftkeyText, 39, this.displayHeight - 2, 33);
                }

                if (this.rightSoftkeyText.length() != 0) {
                    var1.drawImage(this.rightSoftkeyImage, this.displayWidth, this.displayHeight, 40);
                    var1.setColor(10896);
                    var1.drawString(this.rightSoftkeyText, this.displayWidth - 40, this.displayHeight - 3, 33);
                    var1.drawString(this.rightSoftkeyText, this.displayWidth - 40, this.displayHeight - 1, 33);
                    var1.drawString(this.rightSoftkeyText, this.displayWidth - 41, this.displayHeight - 2, 33);
                    var1.drawString(this.rightSoftkeyText, this.displayWidth - 39, this.displayHeight - 2, 33);
                    var1.drawString(this.rightSoftkeyText, this.displayWidth - 39, this.displayHeight - 0, 33);
                    var1.drawString(this.rightSoftkeyText, this.displayWidth - 38, this.displayHeight - 0, 33);
                    var1.drawString(this.rightSoftkeyText, this.displayWidth - 38, this.displayHeight - 1, 33);
                    var1.setColor(16777215);
                    var1.drawString(this.rightSoftkeyText, this.displayWidth - 40, this.displayHeight - 2, 33);
                }
            } catch (Exception var) {
            }
		}

        var1.setColor(0);
    }

    protected final void showNotify() {
        this.ae = false;
        this.af = true;
        this.X = true;
    }

    protected final void hideNotify() {
        this.ae = true;
        this.z.vibrate(0);
        this.i();
    }

/* ReChained custom record store
 * ID: 2
 * Length: 6 bytes
 *  - Byte 0: sfxType
 *  - Byte 1: puyoSkinsType
 *  - Byte 2: RunRunStageSelUnlockedFlag
 *  - Byte 3: WakuWakuStageSelUnlockedFlag
 *  - Byte 4: HaraHaraStageSelUnlockedFlag
 *  - Byte 6: **unused**
 */

    private void t() {
        RecordStore var1;
        byte[] var2;
        byte[] rechainedData;
        int var3;
        int var5;
        int var6;
        try {
			var1 = RecordStore.openRecordStore("d", false);
			var2 = var1.getRecord(1);
			rechainedData = var1.getRecord(2);
            if (var1 != null && var2 != null && rechainedData != null) {
				
			sfxType = (int) rechainedData[0];
			puyoSkinsType = (int) rechainedData[1];
			voiceLangType = (int) rechainedData[2];
			difficultyType = (int) rechainedData[3];
			ingameBgColorType = (int) rechainedData[4];
			RunRunStageSelUnlockedFlag = (rechainedData[5] == 1);
			WakuWakuStageSelUnlockedFlag = (rechainedData[6] == 1);
			HaraHaraStageSelUnlockedFlag = (rechainedData[7] == 1);
			vibSetting = (rechainedData[8] == 1);
				
                var3 = 0;

                int var4;
                byte var9;
                for(var4 = 0; var4 < 3; ++var4) {
                    var6 = var3++;
                    var9 = var2[var6];
                    byte var11 = var2[var6];
                    this.R[var4] = var9 > 0;
                    this.V[var4] = (var2[var3++] & 255) + ((var2[var3++] & 255) << 8) + ((var2[var3++] & 255) << 16) + ((var2[var3++] & 255) << 24);
                    this.W[var4] = (var2[var3++] & 255) + ((var2[var3++] & 255) << 8) + ((var2[var3++] & 255) << 16) + ((var2[var3++] & 255) << 24);
                    this.S[var4] = 2000 + var2[var3++];
                    this.T[var4] = var2[var3++];
                    this.U[var4] = var2[var3++];
                }

                ++var3;
                this.mainMenu = (var9 = var2[36]) > 0;
                ++var3;
                this.P = (var9 = var2[37]) > 0;
                ++var3;
                this.b = var2[38] * 20;

                for(var4 = 0; var4 < 3; ++var4) {
                    for(var5 = 0; var5 < 5; ++var5) {
                        this.cf[var4][var5][0] = (var2[var3++] & 255) + ((var2[var3++] & 255) << 8) + ((var2[var3++] & 255) << 16) + ((var2[var3++] & 255) << 24);
                        this.cf[var4][var5][1] = var2[var3++];
                        this.cf[var4][var5][2] = (var2[var3++] & 255) + ((var2[var3++] & 255) << 8);
                    }
                }

                this.r = var2[var3++];
                this.puyoMainGUI = var2[var3];
                var1.closeRecordStore();
                return;
            }
        } catch (RecordStoreException var10) {
            try {
                var2 = new byte[146];
                rechainedData = new byte[10];
                var1 = RecordStore.openRecordStore("d", true);
                
                for (var3 = 0; var3 < 6; var3++) {
					rechainedData[var3] = 0;
				}
                
                var3 = 0;

                for(var5 = 0; var5 < 3; ++var5) {
                    var2[var3++] = 0;
                    var2[var3++] = -96;
                    var2[var3++] = -122;
                    var2[var3++] = 1;
                    var2[var3++] = 0;
                    var2[var3++] = -96;
                    var2[var3++] = -122;
                    var2[var3++] = 1;
                    var2[var3++] = 0;
                    var2[var3++] = 0;
                    var2[var3++] = 0;
                    var2[var3++] = 0;
                }

                ++var3;
                var2[36] = 1;
                ++var3;
                var2[37] = 1;
                ++var3;
                var2[38] = 5;

                for(var5 = 0; var5 < 3; ++var5) {
                    for(var6 = 0; var6 < 5; ++var6) {
                        var2[var3++] = (byte)rankingDefaultHighScores[var5][var6][0];
                        var2[var3++] = (byte)(rankingDefaultHighScores[var5][var6][0] >> 8);
                        var2[var3++] = (byte)(rankingDefaultHighScores[var5][var6][0] >> 16);
                        var2[var3++] = (byte)(rankingDefaultHighScores[var5][var6][0] >>> 24);
                        var2[var3++] = (byte)rankingDefaultHighScores[var5][var6][1];
                        var2[var3++] = (byte)rankingDefaultHighScores[var5][var6][2];
                        var2[var3++] = (byte)(rankingDefaultHighScores[var5][var6][2] >> 8);
                    }
                }

                var2[var3++] = 100;
                var2[var3] = 0;
                var1.addRecord(var2, 0, 146);
                var1.addRecord(rechainedData, 0, 10);
                var1.closeRecordStore();
            } catch (RecordStoreException var9) {
                var10.printStackTrace();
            }

            this.t();
        }

    }

    private void u() {
        try {
            RecordStore var1 = RecordStore.openRecordStore("d", false);
            byte[] var2 = new byte[146];
            byte[] rechainedData = new byte[10];
            int var3 = 0;

			rechainedData[0] = (byte) sfxType;
			rechainedData[1] = (byte) puyoSkinsType;
			rechainedData[2] = (byte) voiceLangType;
			rechainedData[3] = (byte) difficultyType;
			rechainedData[4] = (byte) ingameBgColorType;
			rechainedData[5] = (byte) (RunRunStageSelUnlockedFlag ? 1 : 0);
			rechainedData[6] = (byte) (WakuWakuStageSelUnlockedFlag ? 1 : 0);
			rechainedData[7] = (byte) (HaraHaraStageSelUnlockedFlag ? 1 : 0);
			rechainedData[8] = (byte) (vibSetting ? 1 : 0);

            int var4;
            for(var4 = 0; var4 < 3; ++var4) {
                var2[var3++] = (byte)(this.R[var4] ? 1 : 0);
                var2[var3++] = (byte)this.V[var4];
                var2[var3++] = (byte)(this.V[var4] >> 8);
                var2[var3++] = (byte)(this.V[var4] >> 16);
                var2[var3++] = (byte)(this.V[var4] >>> 24);
                var2[var3++] = (byte)this.W[var4];
                var2[var3++] = (byte)(this.W[var4] >> 8);
                var2[var3++] = (byte)(this.W[var4] >> 16);
                var2[var3++] = (byte)(this.W[var4] >>> 24);
                var2[var3++] = (byte)(this.S[var4] % 100);
                var2[var3++] = (byte)this.T[var4];
                var2[var3++] = (byte)this.U[var4];
            }

            ++var3;
            var2[36] = (byte)(this.mainMenu ? 1 : 0);
            ++var3;
            var2[37] = (byte)(this.P ? 1 : 0);
            ++var3;
            var2[38] = (byte)(this.b / 20);

            for(var4 = 0; var4 < 3; ++var4) {
                for(int var5 = 0; var5 < 5; ++var5) {
                    var2[var3++] = (byte)this.cf[var4][var5][0];
                    var2[var3++] = (byte)(this.cf[var4][var5][0] >> 8);
                    var2[var3++] = (byte)(this.cf[var4][var5][0] >> 16);
                    var2[var3++] = (byte)(this.cf[var4][var5][0] >>> 24);
                    var2[var3++] = (byte)this.cf[var4][var5][1];
                    var2[var3++] = (byte)this.cf[var4][var5][2];
                    var2[var3++] = (byte)(this.cf[var4][var5][2] >> 8);
                }
            }

            var2[var3++] = (byte)this.r;
            var2[var3] = (byte)this.puyoMainGUI;
            var1.setRecord(1, var2, 0, 146);
            var1.setRecord(2, rechainedData, 0, 10);
            var1.closeRecordStore();
			if (this.loadedFlag) {
			    this.saveFlag = true;
			}
        } catch (RecordStoreException var6) {
            var6.printStackTrace();
        }

    }

    private int a(int var1, int var2) {
        return this.aY[var1] - 1 + var2;
    }

    private void b(int var1) {
        int var3;
        for(int var2 = 0; var2 < 1; ++var2) {
            for(var3 = 0; var3 < 9; ++var3) {
                this.aR[var1][0][var3] = this.aR[var1][1][var3];
            }

            this.aK[var1][0] = this.aK[var1][1];
        }

        for(var3 = 0; var3 < 9; ++var3) {
            this.aR[var1][1][var3] = 0;
        }

        if (this.aw == 2) {
            this.aK[var1][1] = 0;
        } else {
            this.aK[var1][1] = ep[this.characterBase[var1]][this.aL[var1]];
            ++this.aL[var1];
            if (this.aL[var1] >= 16) {
                this.aL[var1] = 0;
            }
        }

        byte var4;
        byte var5;
        switch(this.aK[var1][1]) {
        case 0:
            var4 = (byte)(1 + Math.abs(this.D.nextInt()) % this.bo[var1]);
            var5 = (byte)(1 + Math.abs(this.D.nextInt()) % this.bo[var1]);
            this.aR[var1][1][1] = var4;
            this.aR[var1][1][4] = var5;
            return;
        case 1:
            var4 = (byte)(1 + Math.abs(this.D.nextInt()) % this.bo[var1]);
            var5 = (byte)(1 + Math.abs(this.D.nextInt()) % this.bo[var1]);
            this.aR[var1][1][1] = var4;
            this.aR[var1][1][4] = var4;
            this.aR[var1][1][5] = var5;
            return;
        case 2:
            var5 = 1;

            for(var4 = 1; var4 == var5; var5 = (byte)(1 + Math.abs(this.D.nextInt()) % this.bo[var1])) {
                var4 = (byte)(1 + Math.abs(this.D.nextInt()) % this.bo[var1]);
            }

            this.aR[var1][1][1] = var4;
            this.aR[var1][1][2] = var5;
            this.aR[var1][1][4] = var4;
            this.aR[var1][1][5] = var5;
            return;
        case 3:
            this.aR[var1][1][1] = this.ba[var1];
            this.aR[var1][1][2] = this.ba[var1];
            this.aR[var1][1][4] = this.ba[var1];
            this.aR[var1][1][5] = this.ba[var1]++;
            if (this.bo[var1] == 5 && this.ba[var1] > 5 || this.bo[var1] == 4 && this.ba[var1] > 4 || this.bo[var1] == 3 && this.ba[var1] > 3) {
                this.ba[var1] = 1;
            }
        default:
        }
    }

    private boolean b(int var1, int var2) {
        boolean var6 = false;
        boolean var7 = false;
        boolean var8 = true;
        int var11;
        if (var2 == 0) {
            if ((var11 = this.aM[var1] + 1) >= 4) {
                var11 -= 4;
            }
        } else if (var2 == 1) {
            if ((var11 = this.aM[var1] - 1) < 0) {
                var11 += 4;
            }
        } else if ((var11 = this.aM[var1] + 2) >= 4) {
            var11 -= 4;
        }

        int var3;
        int var4;
        int var5;
        int var14;
        for(var3 = 0; var3 < 3; ++var3) {
            for(var4 = 0; var4 < 3; ++var4) {
                if (this.aJ[var1] == 2) {
                    if (var3 != 0 && var4 != 2) {
                        if (var2 == 0) {
                            var5 = var4 + 1;
                            var14 = 2 - var3;
                        } else {
                            var5 = 2 - var4;
                            var14 = var3 - 1;
                        }

                        this.aQ[var1][var3 + var4 * 3] = this.aP[var1][var5 + var14 * 3];
                    } else {
                        this.aQ[var1][var3 + var4 * 3] = 0;
                    }
                } else {
                    if (var2 == 0) {
                        var5 = var4;
                        var14 = 2 - var3;
                    } else if (var2 == 1) {
                        var5 = 2 - var4;
                        var14 = var3;
                    } else {
                        var5 = 2 - var3;
                        var14 = 2 - var4;
                    }

                    this.aQ[var1][var3 + var4 * 3] = this.aP[var1][var5 + var14 * 3];
                }
            }
        }

        int var10 = -1;
        var14 = this.aY[var1];
        int var15 = this.aZ[var1];
        int var9;
        if (this.aJ[var1] != 2) {
            label150:
            for(var3 = 0; var3 < 3; ++var3) {
                for(var4 = 0; var4 < 3; ++var4) {
                    var9 = var3 + var4 * 3;
                    if (this.aQ[var1][var9] != 0) {
                        var2 = this.aY[var1] - 1 + var3;
                        var5 = this.aZ[var1] - 1 + var4;
                        if (this.aF[var1] > 0) {
                            ++var5;
                        }

                        if (var2 < 0 || var2 >= 6 || var5 >= 14) {
                            var10 = var9;
                            break label150;
                        }

                        if (this.bb[var1][var2 + var5 * 6] != 0) {
                            var10 = var9;
                            break label150;
                        }
                    }
                }
            }
        }

        if (var10 > 0) {
            switch(var10) {
            case 3:
                var14 = this.aY[var1] + 1;
                var15 = this.aZ[var1];
            case 4:
            case 6:
            default:
                break;
            case 5:
                var14 = this.aY[var1] - 1;
                var15 = this.aZ[var1];
                break;
            case 7:
                var14 = this.aY[var1];
                var15 = this.aZ[var1] - 1;
            }

            label127:
            for(var3 = 0; var3 < 3; ++var3) {
                for(var4 = 0; var4 < 3; ++var4) {
                    var9 = var3 + var4 * 3;
                    if (this.aQ[var1][var9] != 0) {
                        var2 = var14 - 1 + var3;
                        var5 = var15 - 1 + var4;
                        if (this.aF[var1] > 0) {
                            ++var5;
                        }

                        if (var2 < 0 || var2 >= 6 || var5 >= 14) {
                            var8 = false;
                            break label127;
                        }

                        if (this.bb[var1][var2 + var5 * 6] != 0) {
                            var8 = false;
                            break label127;
                        }
                    }
                }
            }
        }

        if (var8) {
            this.aY[var1] = var14;
            this.aZ[var1] = var15;

            for(var3 = 0; var3 < 3; ++var3) {
                for(var4 = 0; var4 < 3; ++var4) {
                    var2 = var3 + var4 * 3;
                    this.aP[var1][var2] = this.aQ[var1][var2];
                }
            }

            this.aM[var1] = var11;
        }

        return var8;
    }

    private boolean c(int var1) {
        return !this.a(var1, this.aY[var1], this.aZ[var1] + 1);
    }

    private boolean d(int var1) {
        return this.a(var1, this.aY[var1], this.aZ[var1]);
    }

    private boolean a(int var1, int var2, int var3) {
        for(int var4 = 0; var4 < 3; ++var4) {
            for(int var5 = 0; var5 < 3; ++var5) {
                if (this.aP[var1][var4 + var5 * 3] != 0) {
                    int var6 = var2 - 1 + var4;
                    int var7 = var3 - 1 + var5;
                    if (this.aF[var1] > 0) {
                        ++var7;
                    }

                    if (var6 < 0 || var6 > 5 || var7 < 0 || var7 > 13) {
                        return true;
                    }

                    if (this.bb[var1][var6 + var7 * 6] != 0) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private void e(Graphics var1, int var2, int var3, int var4) {
        --var2;
        var3 -= 8;
        var4 -= 8;
        var1.drawRegion(this.puyoGraphics[eJ[var2]], 112, eK[var2] + 48, 16, 16, 0, var3, var4, 20);
    }

    private void b(Graphics var1, int var2) {
        int var4 = 0;
        int var3 = this.cj[var2] + this.ck[var2];
        int var5 = this.an + var2 * 133;
        int var6 = this.menuBaseC + 65;
        if (this.bY[var2]) {
            if (this.cl[var2] > 0 && var3 == 0) {
                this.o(var1, var5, var6);
                var3 = this.cl[var2];
            } else {
                var1.drawRegion(this.puyoGraphics[10], 0, 134, 107, 18, 0, var5, var6, 20);
                var3 = var3;
            }
        } else {
            this.o(var1, var5, var6);
            var3 = var3;
        }

        if (var2 < this.br) {
            for(var5 = 0; var5 < 6; ++var5) {
                while(var3 > 0 && var3 >= en[var5]) {
                    int var10002 = 5 - var5;
                    int var10003 = this.an + 4 + (var4 << 4) + var2 * 133;
                    int var10 = this.menuBaseC + 65;
                    var1.drawRegion(this.puyoGraphics[2], var10002 << 4, 112, 16, 16, 0, var10003, var10, 20);
                    var3 -= en[var5];
                    ++var4;
                    if (var4 >= 6) {
                        return;
                    }
                }
            }
        }

    }

    private void b(Graphics var1, int var2, int var3, int var4, int var5) {
        int var6 = var2 - 1;
        short var7;
        if (var2 <= 5) {
            if (var3 == 24) {
                var7 = 2;
                var2 = 48 + (var6 << 4);
                var3 = 80;
            } else {
                var7 = eJ[var6];
                var2 = (var3 << 4) % 128;
                var3 = eK[var6] + (var3 / 8 << 4);
            }
        } else if (var2 == 6) {
            var7 = 2;
            if (var3 == 24) {
                var2 = 32;
                var3 = 80;
            } else {
                var2 = 32;
                var3 = 64;
            }
        } else {
            var7 = 2;
            var2 = 48 + (var2 - 7 << 4);
            var3 = 64;
        }

        var1.drawRegion(this.puyoGraphics[var7], var2, var3, 16, 16, 0, var4 - 8, var5 - 8, 20);
    }

    private void c(Graphics var1, int var2, int var3, int var4, int var5) {
        --var2;
        short var6 = eJ[var2];
        byte var7;
        switch(var3) {
        case 0:
        default:
            var3 = var4 - 8;
            var4 = var5 - 23;
            var7 = 0;
            break;
        case 1:
            var3 = var4 - 8;
            var4 = var5 - 8;
            var7 = 5;
            break;
        case 2:
            var3 = var4 - 8;
            var4 = var5 - 9;
            var7 = 3;
            break;
        case 3:
            var3 = var4 - 23;
            var4 = var5 - 8;
            var7 = 6;
        }

        var1.drawRegion(this.puyoGraphics[var6], 32, eK[var2] + 32, 16, 32, var7, var3, var4, 20);
    }

    private void d(Graphics var1, int var2, int var3, int var4, int var5) {
        --var2;
        short var6 = eJ[var2];
        byte var7;
        switch(var3) {
        case 0:
        default:
            var3 = var4 - 13;
            var4 = var5 - 16;
            var7 = 0;
            break;
        case 1:
            var3 = var4 - 16;
            var4 = var5 - 13;
            var7 = 5;
            break;
        case 2:
            var3 = var4 - 3;
            var4 = var5 - 16;
            var7 = 3;
            break;
        case 3:
            var3 = var4 - 16;
            var4 = var5 - 3;
            var7 = 6;
        }

        var1.drawRegion(this.puyoGraphics[var6], 48, eK[var2] + 32, 16, 32, var7, var3, var4, 20);
    }

    private void f(Graphics var1, int var2, int var3, int var4) {
        if (var2 != 0) {
            this.b(var1, var2, 0, var3, var4);
        }

    }

    private void a(Graphics var1, int var2, int var3, int var4, int var5, byte[] var6) {
        int var7;
        byte var8;
        int var9;
        byte var10;
        int var11;
        int var13;
        int var14;
        byte var17;
        switch(var2) {
        case 0:
            var8 = var6[4];
            var10 = dQ[var3];
            int var10002 = 1 + dP[var10][0];
            var13 = 1 + dP[var10][1];
            if (var8 == var6[var10002 + var13 * 3]) {
                var2 = var4 + 16 + 8;
                var7 = var5 + 14 + 7;
                this.c(var1, var8, var3, var2, var7);
                this.e(var1, var8, var2 + (dP[var10][0] << 4), var7 + dP[var10][1] * 14);
                return;
            }

            for(var2 = 0; var2 < 3; ++var2) {
                for(var7 = 0; var7 < 3; ++var7) {
                    var8 = var6[var2 + var7 * 3];
                    this.f(var1, var8, var4 + (var2 << 4) + 8, var5 + var7 * 14 + 7);
                }
            }

            return;
        case 1:
            var10 = dQ[var3];
            byte var18 = dQ[(var3 + 1) % 4];
            var8 = var6[4];
            int var10001 = 1 + dP[var10][0];
            var13 = 1 + dP[var10][1];
            var17 = var6[var10001 + var13 * 3];
            var10001 = 1 + dP[var18][0];
            var13 = 1 + dP[var18][1];
            byte var15 = var6[var10001 + var13 * 3];
            var2 = var4 + 16 + 8;
            var7 = var5 + 14 + 7;
            if (var17 == var15) {
                var5 = var8 - 1;
                short var12 = eJ[var5];
                byte var19;
                switch(var3) {
                case 0:
                default:
                    var14 = var2 - 9;
                    var9 = var7 - 23;
                    var19 = 0;
                    break;
                case 1:
                    var14 = var2 - 9;
                    var9 = var7 - 9;
                    var19 = 5;
                    break;
                case 2:
                    var14 = var2 - 23;
                    var9 = var7 - 9;
                    var19 = 3;
                    break;
                case 3:
                    var14 = var2 - 23;
                    var9 = var7 - 23;
                    var19 = 6;
                }

                var1.drawRegion(this.puyoGraphics[var12], 72, eK[var5] + 32, 32, 32, var19, var14, var9, 20);
                this.e(var1, var8, var2 + (dP[var10][0] << 4), var7 + dP[var10][1] * 14);
                return;
            }

            if (var8 == var17) {
                this.c(var1, var8, var3, var2, var7);
                this.f(var1, var15, var2 + (dP[var18][0] << 4), var7 + dP[var18][1] * 14);
                this.e(var1, var8, var2 + (dP[var10][0] << 4), var7 + dP[var10][1] * 14);
                return;
            }
            break;
        case 2:
            var11 = (var3 + 2) % 4;
            switch(var3) {
            case 0:
            case 1:
                var8 = var6[1];
                var17 = var6[5];
                break;
            default:
                var8 = var6[5];
                var17 = var6[1];
            }

            this.d(var1, var8, var3, var4 + 32, var5 + 14);
            this.d(var1, var17, var11, var4 + 32, var5 + 14);
            this.e(var1, var8, var4 + (dR[var3][0] << 4) + 8, var5 + dR[var3][1] * 14 + 8);
            this.e(var1, var17, var4 + (dR[var11][0] << 4) + 8, var5 + dR[var11][1] * 14 + 8);
            break;
        case 3:
            var8 = var6[1];
            int var10003 = var4 + 32;
            var9 = var5 + 14;
            var11 = var8 - 1;
            var5 = var10003 - 16;
            var14 = var9 - 16;
            short var16 = eJ[var11];
            var1.drawRegion(this.puyoGraphics[var16], 0, eK[var11] + 32, 32, 32, 0, var5, var14, 20);
            return;
        }

    }

    private void g(Graphics var1, int var2, int var3, int var4) {
        boolean var6 = false;
        boolean var7 = false;
        var6 = false;
        if (var4 >= 2) {
            byte var5;
            int var8;
            int var9;
            if (!this.bY[var2]) {
                var9 = var4 - 2;
                var5 = 3;
                var8 = (var3 << 4) + 1;
            } else {
                if (var4 >= 4 && var4 <= 10) {
                    var8 = var3;
                    var9 = var4 - 4;
                } else {
                    var8 = 0;
                    var9 = 1;
                }

                var5 = 4;
                var8 <<= 4;
            }

            var1.drawRegion(this.puyoGraphics[var5], var8, var9 * 14, 16, 14, 0, this.an + dO[var2] + (var3 << 4), this.menuBaseC + 55 + var4 * 14, 20);
        }

    }

    private void e(int var1) {
        for(int var2 = 0; var2 < 84; ++var2) {
            if (this.bp[var1][var2] == 0) {
                this.bq[var1][var2] = false;
            } else {
                this.bq[var1][var2] = true;
                this.bp[var1][var2] = 0;
            }
        }

    }

    private void f(int var1) {
        this.e(var1);

        label45:
        for(int var4 = 0; var4 < 3; ++var4) {
            for(int var5 = 2; var5 >= 0; --var5) {
                if (this.aP[var1][var4 + var5 * 3] != 0) {
                    int var6 = 13;

                    while(true) {
                        if (var6 < 0) {
                            continue label45;
                        }

                        int var2 = this.aY[var1] - 1 + var4 + var6 * 6;
                        if (this.bb[var1][var2] == 0) {
                            int var7 = var5;

                            while(true) {
                                if (var7 < 0) {
                                    continue label45;
                                }

                                byte var3;
                                if ((var3 = this.aP[var1][var4 + var7 * 3]) != 0) {
                                    int var10000 = this.aY[var1] - 1 + var4;
                                    int var8 = var6 + (var7 - var5);
                                    var2 = var10000 + var8 * 6;
                                    this.bp[var1][var2] = var3 + 6;
                                }

                                --var7;
                            }
                        }

                        --var6;
                    }
                }
            }
        }

        this.Z[var1] = true;
    }

    private int g(int var1) {
        byte var3 = 0;

        for(int var4 = 0; var4 < 6; ++var4) {
            int var6 = var4;
            int var5 = var1;
            a var2 = this;
            boolean var8 = false;
            boolean var7 = false;

            for(int var9 = 13; var9 >= 0; --var9) {
                int var10 = var6 + var9 * 6;
                byte var11 = var2.bb[var5][var10];
                var2.bi[var5][var10] = false;
                if (var11 == 0) {
                    var7 = true;
                } else if (var7) {
                    var2.bi[var5][var10] = true;
                    var8 = true;
                }
            }

            if (var8) {
                this.bn[var1][var4] = 0;
                var3 = 1;
            } else if (this.bn[var1][var4] == 0) {
                this.bn[var1][var4] = 1;
                var3 = 2;
            } else {
                this.bn[var1][var4] = 2;
            }
        }

        return var3;
    }

    private void h(int var1) {
        for(int var2 = 0; var2 < 6; ++var2) {
            for(int var3 = 13; var3 >= 0; --var3) {
                int var4 = var2 + var3 * 6;
                if (this.bi[var1][var4]) {
                    this.bi[var1][var4] = false;
                    byte[] var10000 = this.bb[var1];
                    int var6 = var3 + 1;
                    var10000[var2 + var6 * 6] = this.bb[var1][var4];
                    this.bb[var1][var4] = 0;
                }
            }
        }

    }

    private void a(int var1, byte[] var2) {
        for(int var3 = 0; var3 < 84; ++var3) {
            if (this.bg[var1][var3] == 1) {
                var2[var3] = 0;
            }
        }

    }

    private void b(int var1, int var2, int var3) {
        byte[] var10000 = this.bk[var1];
        var10000[var2] = (byte)(var10000[var2] | 1 << var3);
    }

    private void a(int var1, int var2, int var3, boolean var4) {
        int var8 = var2 + var3 * 6;
        this.bg[var1][var8] = 3;
        if (var4) {
            this.bk[var1][var8] = 0;
        }

        for(int var5 = 0; var5 < 4; ++var5) {
            int var6 = var2 + dP[var5][0];
            int var7 = var3 + dP[var5][1];
            if (var6 >= 0 && var6 < 6 && var7 >= 0 && var7 < 14) {
                int var9 = var6 + var7 * 6;
                if (this.bg[var1][var9] == 0) {
                    if (this.cF[var1][var9] != this.cF[var1][var8]) {
                        this.bg[var1][var9] = 4;
                    } else {
                        this.bg[var1][var9] = 3;
                        int var10003 = this.bj[var1]++;
                        if (var4 && (!this.bi[var1][var8] && !this.bi[var1][var9] || var5 <= 1)) {
                            this.b(var1, var8, var5);
                        }

                        this.a(var1, var6, var7, var4);
                    }
                } else if (var4 && this.bg[var1][var9] == 3 && (!this.bi[var1][var8] && !this.bi[var1][var9] || var5 <= 1)) {
                    this.b(var1, var8, var5);
                }
            }
        }

    }

    private void a(int var1, boolean var2) {
        int var3;
        for(var3 = 0; var3 < 84; ++var3) {
            this.bg[var1][var3] = 0;
        }

        int var4;
        int var6;
        if (!var2) {
            for(var6 = 0; var6 < 6; ++var6) {
                for(var3 = 0; var3 < 14; ++var3) {
                    var4 = var6 + var3 * 6;
                    this.cF[var1][var4] = this.bb[var1][var4];
                }
            }
        }

        for(var6 = 0; var6 < 6; ++var6) {
            for(var3 = 0; var3 < 14; ++var3) {
                var4 = var6 + var3 * 6;
                if (this.bg[var1][var4] == 0) {
                    byte var5;
                    if ((var5 = this.cF[var1][var4]) == 0) {
                        this.bg[var1][var4] = 2;
                    } else if (var5 == 6) {
                        this.bg[var1][var4] = 2;
                    } else {
                        this.a(var1, var6, var3, true);

                        for(var4 = 0; var4 < 84; ++var4) {
                            if (this.bg[var1][var4] == 4) {
                                this.bg[var1][var4] = 0;
                            } else if (this.bg[var1][var4] == 3) {
                                this.bg[var1][var4] = 2;
                            }
                        }
                    }
                }
            }
        }

    }

    private boolean b(int var1, boolean var2) {
        boolean var9 = false;
        this.dq[var1] = 0;
        int var3;
        if (var2) {
            for(var3 = 0; var3 < 5; ++var3) {
                this.bv[var1][var3] = false;
            }

            this.bw[var1] = 0;
            this.bz[var1] = 0;
        }

        for(var3 = 0; var3 < 84; ++var3) {
            this.bg[var1][var3] = 0;
        }

        int var4;
        int var5;
        int var6;
        int var10;
        for(var4 = 0; var4 < 6; ++var4) {
            for(var5 = 0; var5 < 14; ++var5) {
                var6 = var4 + var5 * 6;
                if (this.bg[var1][var6] == 0) {
                    byte var15;
                    if ((var15 = this.cF[var1][var6]) == 0) {
                        this.bg[var1][var6] = 2;
                    } else if (var15 == 6) {
                        this.bg[var1][var6] = 2;
                    } else {
                        var10 = 6;
                        int var11 = 14;
                        int var12 = 0;
                        int var13 = 0;
                        this.bj[var1] = 1;
                        this.a(var1, var4, var5, var2);

                        int var7;
                        for(var6 = 0; var6 < 84; ++var6) {
                            if (this.bg[var1][var6] == 4) {
                                this.bg[var1][var6] = 0;
                            } else if (this.bg[var1][var6] == 3) {
                                if (var2) {
                                    var7 = var6 % 6;
                                    int var8 = var6 / 6;
                                    if (var10 > var7) {
                                        var10 = var7;
                                    }

                                    if (var12 < var7) {
                                        var12 = var7;
                                    }

                                    if (var11 > var8) {
                                        var11 = var8;
                                    }

                                    if (var13 < var8) {
                                        var13 = var8;
                                    }
                                }

                                if (this.bj[var1] >= 4) {
                                    this.bg[var1][var6] = 1;
                                    if (var2) {
                                        var9 = true;
                                    }
                                } else {
                                    this.bg[var1][var6] = 2;
                                }
                            }
                        }

                        if (var2 && this.bj[var1] >= 4) {
                            if (this.dq[var1] < 4) {
                                this.uwu[var1][this.dq[var1]] = (byte)((var10 + var12) / 2);
                                this.dp[var1][this.dq[var1]] = (byte)((var11 + var13) / 2);
                                ++this.dq[var1];
                            }

                            int[] var16 = this.bw;
                            var16[var1] += this.bj[var1] * 10;
                            if (this.aw == 2) {
                                var7 = this.bj[var1];
                                this.dr -= var7;
                                if (this.dr < 0) {
                                    if (++this.singlePuyoPopBase > 99) {
                                        this.singlePuyoPopBase = 99;
                                    }

                                    if (++this.cE[0] > 99) {
                                        this.cE[0] = 90;
                                    }

                                    this.dr = 30;
                                }
                            }

                            this.bv[var1][var15 - 1] = true;
                            if (this.bj[var1] >= 5) {
                                if ((var3 = this.bj[var1] - 5) >= 7) {
                                    var3 = 6;
                                }

                                var16 = this.bA;
                                var16[var1] += ek[var3];
                            }
                        }
                    }
                }
            }
        }

        if (var9) {
            for(var4 = 0; var4 < 6; ++var4) {
                for(var5 = 0; var5 < 14; ++var5) {
                    var6 = var4 + var5 * 6;
                    if (this.bg[var1][var6] == 1 && this.cF[var1][var6] != 6) {
                        for(var3 = 0; var3 < 4; ++var3) {
                            int var14 = var4 + dP[var3][0];
                            var6 = var5 + dP[var3][1];
                            if (var14 >= 0 && var14 < 6 && var6 >= 0 && var6 < 14) {
                                var14 += var6 * 6;
                                if (this.cF[var1][var14] == 6) {
                                    this.bg[var1][var14] = 1;
                                }
                            }
                        }
                    }
                }
            }

            var10 = 0;

            for(var3 = 0; var3 < 5; ++var3) {
                if (this.bv[var1][var3]) {
                    ++var10;
                }
            }

            if (var10 >= 2) {
                this.bz[var1] = el[var10 - 2];
            }
        }

        return var9;
    }

    private byte c(int var1, int var2) {
        byte var6 = 0;
        this.cW[1] = false;
        this.cM[1] = 0;
        this.cH[1] = false;
        int[] var10000;
        switch(var2) {
        case 0:
            var6 = 0;
            var10000 = this.cM;
            var10000[1] |= 8;
            var10000 = this.cM;
            var10000[1] |= 4;
            var10000 = this.cM;
            var10000[1] |= 64;
            var10000 = this.cM;
            var10000[1] |= 512;
            this.cN[1] = 8000;
            this.cx[1] = 1;
            this.cw[1] = 1;
            this.cz[1] = 6000;
            this.cy[1] = 30;
            this.cD[1] = 100;
            this.cE[1] = 0;
            break;
        case 1:
            var6 = 4;
            var10000 = this.cM;
            var10000[1] |= 8;
            var10000 = this.cM;
            var10000[1] |= 4;
            var10000 = this.cM;
            var10000[1] |= 64;
            var10000 = this.cM;
            var10000[1] |= 512;
            this.cN[1] = 8000;
            this.cx[1] = 1;
            this.cw[1] = 1;
            this.cz[1] = 6000;
            this.cy[1] = 30;
            this.cD[1] = 100;
            this.cE[1] = 0;
            break;
        case 2:
            var6 = 6;
            var10000 = this.cM;
            var10000[1] |= 8;
            var10000 = this.cM;
            var10000[1] |= 4;
            var10000 = this.cM;
            var10000[1] |= 64;
            var10000 = this.cM;
            var10000[1] |= 32;
            var10000 = this.cM;
            var10000[1] |= 512;
            this.cN[1] = 2000;
            this.cx[1] = 2;
            this.cw[1] = 1;
            this.cz[1] = 200;
            this.cy[1] = 30;
            this.cD[1] = 100;
            this.cE[1] = 0;
            break;
        case 3:
            var6 = 7;
            var10000 = this.cM;
            var10000[1] |= 4;
            var10000 = this.cM;
            var10000[1] |= 8;
            var10000 = this.cM;
            var10000[1] |= 64;
            var10000 = this.cM;
            var10000[1] |= 512;
            this.cN[1] = 500;
            this.cx[1] = 2;
            this.cw[1] = 1;
            this.cz[1] = 120;
            this.cy[1] = 16;
            this.cD[1] = 100;
            this.cE[1] = 0;
            break;
        case 4:
            var6 = 5;
            var10000 = this.cM;
            var10000[1] |= 8;
            var10000 = this.cM;
            var10000[1] |= 4;
            var10000 = this.cM;
            var10000[1] |= 64;
            var10000 = this.cM;
            var10000[1] |= 512;
            this.cN[1] = 4000;
            this.cx[1] = 2;
            this.cw[1] = 1;
            this.cz[1] = 600;
            this.cy[1] = 30;
            this.cD[1] = 100;
            this.cE[1] = 0;
            break;
        case 5:
            var6 = 1;
            var10000 = this.cM;
            var10000[1] |= 8;
            var10000 = this.cM;
            var10000[1] |= 64;
            var10000 = this.cM;
            var10000[1] |= 4;
            var10000 = this.cM;
            var10000[1] |= 512;
            this.cN[1] = 2000;
            this.cx[1] = 2;
            this.cw[1] = 1;
            this.cz[1] = 140;
            this.cy[1] = 20;
            this.cD[1] = 80;
            this.cE[1] = 0;
            break;
        case 6:
            var6 = 4;
            var10000 = this.cM;
            var10000[1] |= 8;
            var10000 = this.cM;
            var10000[1] |= 64;
            var10000 = this.cM;
            var10000[1] |= 4;
            var10000 = this.cM;
            var10000[1] |= 512;
            this.cN[1] = 500;
            this.cx[1] = 2;
            this.cw[1] = 1;
            this.cz[1] = 120;
            this.cy[1] = 20;
            this.cD[1] = 70;
            this.cE[1] = 1;
            break;
        case 7:
            var6 = 3;
            var10000 = this.cM;
            var10000[1] |= 4;
            var10000 = this.cM;
            var10000[1] |= 512;
            this.cx[1] = 3;
            this.cw[1] = 1;
            this.cN[1] = 30;
            this.cz[1] = 80;
            this.cy[1] = 10;
            this.cD[1] = 70;
            this.cE[1] = 1;
            this.cH[1] = true;
            break;
        case 8:
            var6 = 2;
            var10000 = this.cM;
            var10000[1] |= 4;
            var10000 = this.cM;
            var10000[1] |= 512;
            this.cx[1] = 3;
            this.cw[1] = 2;
            this.cN[1] = 30;
            this.cz[1] = 60;
            this.cy[1] = 8;
            this.cD[1] = 50;
            this.cE[1] = 2;
            break;
        case 9:
            var6 = 8;
            var10000 = this.cM;
            var10000[1] |= 4;
            var10000 = this.cM;
            var10000[1] |= 512;
            this.cx[1] = 3;
            this.cw[1] = 1;
            this.cN[1] = 30;
            this.cz[1] = 40;
            this.cy[1] = 8;
            this.cD[1] = 50;
            this.cE[1] = 2;
            break;
        case 10:
            var6 = 9;
            var10000 = this.cM;
            var10000[1] |= 1024;
            this.cx[1] = 5;
            this.cN[1] = 40;
            this.cz[1] = 20;
            this.cy[1] = 6;
            this.cD[1] = 30;
            this.cE[1] = 4;
            break;
        case 11:
            var6 = 10;
            var10000 = this.cM;
            var10000[1] |= 1024;
            this.cx[1] = 3;
            this.cN[1] = 30;
            this.cz[1] = 20;
            this.cy[1] = 8;
            this.cD[1] = 20;
            this.cE[1] = 4;
        }

        for(int var3 = 0; var3 < 14; ++var3) {
            for(var2 = 0; var2 < 6; ++var2) {
                int var4 = var2 + var3 * 6;
                byte var5;
                if ((var5 = (byte)(er[var6][var3][var2] / 2)) > 25) {
                    var5 = 25;
                }

                this.eq[1][var4] = (short)var5;
            }
        }

        return var6;
    }

    private void c(int var1, int var2, int var3) {
        if (!this.cI[var3] && this.cF[var1][var2] == this.cF[var1][var3]) {
            this.cI[var3] = true;
            this.cJ[this.cL[var1]++] = (byte)var3;
        }

    }

    private void i(int var1) {
        if (this.cr[var1] != -1) {
            for(int var2 = 0; var2 < 17; ++var2) {
                this.de[var1][var2] = -1;
                this.df[var1][var2] = 0;
                this.dd[var1][var2] = 0;
                this.dc[var1][var2] = false;
                this.db[var1][var2] = -100000000;
            }

            this.cB[var1] = 0;
            this.cA[var1] = 0;
            this.cV[var1] = 1;
            this.cW[var1] = false;
        }

    }

    private int d(int var1, int var2) {
        if ((var2 = var2) >= 24) {
            var2 = 23;
        }

        byte var3;
        if (this.bY[var1]) {
            var3 = 1;
        } else {
            var3 = 0;
        }

        return eo[this.characterBase[var1]][var2][var3];
    }

    private int v() {
        if (this.cd / 1000 >= 96) {
            int var1;
            if ((var1 = this.cd / 1000 - 96 >> 3) >= 27) {
                var1 = 26;
            }

            if ((var1 = 120 * em[var1][0] / em[var1][1]) < 1) {
                var1 = 1;
            }

            return var1;
        } else {
            return 120;
        }
    }

    private void j(int var1) {
        int var2;
        for(var2 = 0; var2 < 6; ++var2) {
            this.di[var1][var2] = 0;
        }

        for(var2 = 0; var2 < 6; ++var2) {
            int var3 = 0;

            while(var3 < 12) {
                byte[] var10000 = this.bb[var1];
                int var5 = var3 + 2;
                switch(var10000[var2 + var5 * 6]) {
                case 0:
                    ++this.di[var1][var2];
                default:
                    ++var3;
                }
            }
        }

    }

    private void a(int var1, int var2, int var3, byte var4) {
        if (var3 >= 2) {
            byte var5 = (byte)(var2 + var3 * 6);
            this.cF[var1][var5] = var4;
        }

    }

    private boolean k(int var1) {
        this.cS[var1] = false;
        byte[] var10000 = this.cF[var1];
        byte var3 = 2;
        boolean var2 = true;
        if (var10000[2 + var3 * 6] != 0) {
            this.cS[var1] = true;
        }

        var10000 = this.cF[var1];
        var3 = 2;
        var2 = true;
        if (var10000[3 + var3 * 6] != 0) {
            this.cS[var1] = true;
        }

        return this.cS[var1];
    }

    private byte l(int var1) {
        this.cT[var1] = 0;
        byte var3 = 0;

        for(int var2 = 0; var2 < 6; ++var2) {
            var3 += this.di[var1][var2];
        }

        if (!this.bY[var1]) {
            if (var3 <= 30 && this.cT[var1] == 0) {
                this.cT[var1] = 1;
            }

            if (var3 <= 24) {
                this.cT[var1] = 2;
            }
        }

        label39: {
            byte[] var10000 = this.cF[var1];
            byte var5 = 3;
            boolean var4 = true;
            if (var10000[2 + var5 * 6] == 0) {
                var10000 = this.cF[var1];
                var5 = 3;
                var4 = true;
                if (var10000[3 + var5 * 6] == 0) {
                    break label39;
                }
            }

            this.cT[var1] = 2;
        }

        if ((this.cM[var1] & 8) > 0) {
            return this.cT[var1];
        } else {
            if (this.cj[var1] > 0) {
                if (!this.bY[var1]) {
                    this.cT[var1] = 2;
                } else if (this.cj[var1] > 4) {
                    this.cT[var1] = 2;
                }
            }

            return this.cT[var1];
        }
    }

    private int e(int var1, int var2) {
        ++var2;
        int var3 = 0;
        int var4 = -100000000;
        if (var2 > 16) {
            var2 = 16;
        }

        if ((this.cM[var1] & 4) > 0 && var2 > this.cw[var1] + 1) {
            var2 = this.cw[var1] + 1;
        }

        do {
            if (this.dc[var1][var2] && (var4 < this.db[var1][var2] || var3 > 0)) {
                var3 = var2;
                var4 = this.db[var1][var2];
            }

            ++var2;
        } while(var2 <= 16);

        return var3;
    }

    private int f(int var1, int var2) {
        ++var2;
        int var3 = 0;
        if (var2 > 16) {
            var2 = 16;
        }

        if ((this.cM[var1] & 4) > 0 && var2 > this.cw[var1] + 1) {
            var2 = this.cw[var1] + 1;
        }

        do {
            if (this.dc[var1][var2]) {
                var3 = var2;
            }

            ++var2;
        } while(var2 <= 16);

        return var3;
    }

    private void m(int var1) {
        this.winCondition[var1] = false;

        int var2;
        for(var2 = 0; var2 < 84; ++var2) {
            this.bb[var1][var2] = 0;
        }

        if (this.aw != 2) {
            this.az[var1] = 1;
        } else {
            for(var2 = 0; var2 < 84; ++var2) {
                this.bq[var1][var2] = false;
                this.bp[var1][var2] = 0;
            }

            this.az[var1] = 20;
            this.a(this.es, (this.ce[var1] - 3 << 2) + Math.abs(this.D.nextInt()) % 4, var1);

            for(var2 = 0; var2 < 84; ++var2) {
                this.bk[var1][var2] = 0;
            }
        }

    }

    private void n(int var1) {
        int var2 = this.an;
        int var3 = this.menuBaseC;
        byte var4;
        if (var1 == 0) {
            var2 += 78;
            var3 += 28;
            var4 = 10;
        } else {
            var2 += 161;
            var3 += 28;
            var4 = -10;
        }

        int var5;
        for(var5 = 0; var5 < 84; ++var5) {
            this.bc[var1][var5] = this.bb[var1][var5];
            this.bl[var1][var5] = this.bk[var1][var5];
        }

        this.aA[var1] = this.az[var1];
        this.bW[var1] = this.bV[var1];
        switch(this.az[var1]) {
        case 0:
        case 1:
        case 2:
        case 3:
        case 22:
            break;
        case 4:
        case 8:
        case 10:
        case 12:
        case 13:
        case 14:
        case 15:
        case 16:
        case 17:
        case 19:
        case 20:
        default:
            this.ad[var1] = true;
            break;
        case 5:
        case 11:
        case 18:
            if (var1 == 0) {
                this.ac[var1] = true;
            }
            break;
        case 6:
        case 7:
            if (var1 == 1) {
                this.ad[var1] = true;
            } else {
                this.Y[var1] = true;
            }
            break;
        case 9:
        case 21:
            this.Y[var1] = true;
        }

        int var6 = var1;
        a var26 = this;
        int var8;
        int var11;
        byte[] var10000;
        byte[] var10002;
        boolean var21;
        byte var23;
        byte var33;
        int var34;
        int var37;
        int var46;
        int var48;
        int var53;
        int var10003;
        boolean var54;
        int[] var58;
        byte var51;
        int var25;
        if (this.cr[var1] != -1) {
            label1637:
            while(true) {
                while(true) {
                    a var7;
                    int var12;
                    byte var14;
                    switch(var26.cV[var6]) {
                    case 0:
                        break label1637;
                    case 1:
                        var26.cS[var6] = false;
                        var26.cT[var6] = 0;
                        var26.cU[var6] = 0;
                        var26.j(var6);
                        switch(var26.aJ[var6]) {
                        case 0:
                            var26.cR[var6] = 5;
                            var26.cO[var6] = 4;
                            if ((var26.cM[var6] & 1) > 0) {
                                var26.cO[var6] = 1;
                            }
                            break;
                        case 1:
                            var26.cR[var6] = 5;
                            var26.cO[var6] = 4;
                            if ((var26.cM[var6] & 1) > 0) {
                                var26.cO[var6] = 1;
                            }
                            break;
                        case 2:
                            var26.cR[var6] = 4;
                            var26.cO[var6] = 4;
                            if ((var26.cM[var6] & 1) > 0) {
                                var26.cO[var6] = 1;
                            }
                            break;
                        case 3:
                            var26.cR[var6] = 4;
                            var26.cO[var6] = var26.bo[var6];
                        }

                        var26.cP[var6] = 0;
                        var26.cQ[var6] = 0;
                        var26.cV[var6] = 3;
                    case 3:
                        if (var26.cU[var6] >= 1) {
                            var26.cU[var6] = 0;
                            break label1637;
                        }

                        var26.bw[var6] = var26.bx[var6] = var26.by[var6] = var26.bz[var6] = var26.bA[var6] = 0;
                        var10002 = var26.cF[var6];
                        byte[] var10 = var26.cG[var6];
                        byte[] var9 = var10002;
                        var8 = var6;
                        var7 = var26;

                        for(var11 = 0; var11 < 84; ++var11) {
                            var9[var11] = var7.bb[var8][var11];
                            var10[var11] = var7.bk[var8][var11];
                        }

                        ++var26.cP[var6];
                        switch(var26.aJ[var6]) {
                        case 0:
                            if (var26.cQ[var6] == 5 && var26.cP[var6] == 2) {
                                ++var26.cP[var6];
                            } else if (var26.cQ[var6] == 0 && var26.cP[var6] == 4) {
                                ++var26.cP[var6];
                            } else if (var26.aP[var6][4] == var26.aP[var6][1] && var26.cP[var6] >= 3) {
                                var26.cP[var6] = (byte)(var26.cO[var6] + 1);
                            }
                            break;
                        case 1:
                            if (var26.aP[var6][4] == var26.aP[var6][5]) {
                                if (var26.cP[var6] == 2 || var26.cP[var6] == 4) {
                                    ++var26.cP[var6];
                                }
                            } else if (var26.cP[var6] == 3) {
                                ++var26.cP[var6];
                            }
                        }

                        if (var26.cP[var6] > var26.cO[var6]) {
                            var26.cP[var6] = 0;
                            ++var26.cQ[var6];
                            if (var26.cQ[var6] > var26.cR[var6]) {
                                var26.cV[var6] = 0;
                                var26.cW[var6] = true;
                            }
                            break;
                        } else {
                            var51 = var26.cQ[var6];
                            var33 = var26.cP[var6];
                            var12 = -1;
                            var25 = -1;
                            var26.cK[var6] = 0;
                            var11 = var26.di[var6][var51] - 1 + 2;
                            if (var51 > 0) {
                                var12 = var26.di[var6][var51 - 1] - 1 + 2;
                            }

                            if (var51 < 5) {
                                var25 = var26.di[var6][var51 + 1] - 1 + 2;
                            }

                            label1602: {
                                byte[] var16 = var26.cF[var6];
                                if (var51 == 1) {
                                    var23 = 1;
                                    var21 = true;
                                    if (var16[1 + var23 * 6] != 0) {
                                        var54 = false;
                                        break label1602;
                                    }
                                } else if (var51 == 4) {
                                    var23 = 1;
                                    var21 = true;
                                    if (var16[4 + var23 * 6] != 0) {
                                        var54 = false;
                                        break label1602;
                                    }
                                }

                                var54 = true;
                            }

                            if (var54 && var11 >= 2) {
                                label1592: {
                                    label1589:
                                    switch(var26.aJ[var6]) {
                                    case 0:
                                        switch(var33 - 1) {
                                        case 0:
                                            var26.cs[var6] = var51;
                                            var26.ct[var6] = var11;
                                            var26.a(var6, var51, var11, var26.aP[var6][4]);
                                            var26.a(var6, var51, var11 - 1, var26.aP[var6][1]);
                                            break label1589;
                                        case 1:
                                            if (var25 < 2) {
                                                var54 = false;
                                                break label1592;
                                            }

                                            var26.cs[var6] = var51;
                                            var26.ct[var6] = var11;
                                            var26.a(var6, var51, var11, var26.aP[var6][4]);
                                            var26.a(var6, var51 + 1, var25, var26.aP[var6][1]);
                                            break label1589;
                                        case 2:
                                            var26.cs[var6] = var51;
                                            var26.ct[var6] = var11 - 1;
                                            var26.a(var6, var51, var11 - 1, var26.aP[var6][4]);
                                            var26.a(var6, var51, var11, var26.aP[var6][1]);
                                            break label1589;
                                        case 3:
                                            if (var12 < 2) {
                                                var54 = false;
                                                break label1592;
                                            }

                                            var26.cs[var6] = var51;
                                            var26.ct[var6] = var12;
                                            var26.a(var6, var51, var11, var26.aP[var6][4]);
                                            var26.a(var6, var51 - 1, var12, var26.aP[var6][1]);
                                        default:
                                            break label1589;
                                        }
                                    case 1:
                                        switch(var33 - 1) {
                                        case 0:
                                            if (var25 < 2) {
                                                var54 = false;
                                                break label1592;
                                            }

                                            if (var51 > 4) {
                                                var54 = false;
                                                break label1592;
                                            }

                                            var26.cs[var6] = var51;
                                            var26.ct[var6] = var11;
                                            var26.a(var6, var51, var11, var26.aP[var6][4]);
                                            var26.a(var6, var51, var11 - 1, var26.aP[var6][1]);
                                            var26.a(var6, var51 + 1, var25, var26.aP[var6][5]);
                                            break label1589;
                                        case 1:
                                            if (var25 < 2) {
                                                var54 = false;
                                                break label1592;
                                            }

                                            if (var51 > 4) {
                                                var54 = false;
                                                break label1592;
                                            }

                                            var26.cs[var6] = var51;
                                            var26.ct[var6] = var11 - 1;
                                            var26.a(var6, var51, var11 - 1, var26.aP[var6][4]);
                                            var26.a(var6, var51 + 1, var25, var26.aP[var6][1]);
                                            var26.a(var6, var51, var11, var26.aP[var6][5]);
                                            break label1589;
                                        case 2:
                                            if (var12 < 2) {
                                                var54 = false;
                                                break label1592;
                                            }

                                            if (var51 < 1) {
                                                var54 = false;
                                                break label1592;
                                            }

                                            var26.cs[var6] = var51;
                                            var26.ct[var6] = var11 - 1;
                                            var26.a(var6, var26.cs[var6], var26.ct[var6], var26.aP[var6][4]);
                                            var26.a(var6, var51, var11, var26.aP[var6][1]);
                                            var26.a(var6, var51 - 1, var12, var26.aP[var6][5]);
                                            break label1589;
                                        case 3:
                                            if (var25 < 2) {
                                                var54 = false;
                                                break label1592;
                                            }

                                            if (var51 < 1) {
                                                var54 = false;
                                                break label1592;
                                            }

                                            var26.cs[var6] = var51;
                                            var26.ct[var6] = var11;
                                            var26.a(var6, var26.cs[var6], var26.ct[var6], var26.aP[var6][4]);
                                            var26.a(var6, var51 - 1, var25, var26.aP[var6][1]);
                                            var26.a(var6, var51, var11 - 1, var26.aP[var6][5]);
                                        default:
                                            break label1589;
                                        }
                                    case 2:
                                        if (var25 < 2) {
                                            var54 = false;
                                            break label1592;
                                        }

                                        var26.cs[var6] = var51;
                                        var26.ct[var6] = var11;
                                        switch(var33 - 1) {
                                        case 0:
                                            var26.a(var6, var51, var11, var26.aP[var6][4]);
                                            var26.a(var6, var51, var11 - 1, var26.aP[var6][1]);
                                            var26.a(var6, var51 + 1, var25, var26.aP[var6][5]);
                                            var26.a(var6, var51 + 1, var25 - 1, var26.aP[var6][2]);
                                            break label1589;
                                        case 1:
                                            var26.a(var6, var51, var11, var26.aP[var6][2]);
                                            var26.a(var6, var51, var11 - 1, var26.aP[var6][4]);
                                            var26.a(var6, var51 + 1, var25, var26.aP[var6][5]);
                                            var26.a(var6, var51 + 1, var25 - 1, var26.aP[var6][1]);
                                            break label1589;
                                        case 2:
                                            var26.a(var6, var51, var11, var26.aP[var6][2]);
                                            var26.a(var6, var51, var11 - 1, var26.aP[var6][5]);
                                            var26.a(var6, var51 + 1, var25, var26.aP[var6][1]);
                                            var26.a(var6, var51 + 1, var25 - 1, var26.aP[var6][4]);
                                            break label1589;
                                        case 3:
                                            var26.a(var6, var51, var11, var26.aP[var6][1]);
                                            var26.a(var6, var51, var11 - 1, var26.aP[var6][2]);
                                            var26.a(var6, var51 + 1, var25, var26.aP[var6][4]);
                                            var26.a(var6, var51 + 1, var25 - 1, var26.aP[var6][5]);
                                        default:
                                            break label1589;
                                        }
                                    case 3:
                                        if (var25 < 2) {
                                            var54 = false;
                                            break label1592;
                                        }

                                        if (var33 == 1) {
                                            var14 = var26.aP[var6][4];
                                        } else if ((var14 = (byte)(var26.cv[var6] + 1)) > var26.bo[var6]) {
                                            var14 = 1;
                                        }

                                        var26.cv[var6] = var14;
                                        var26.cs[var6] = var51;
                                        var26.ct[var6] = var11;
                                        var26.a(var6, var51, var11, var14);
                                        var26.a(var6, var51, var11 - 1, var14);
                                        var26.a(var6, var51 + 1, var25, var14);
                                        var26.a(var6, var51 + 1, var25 - 1, var14);
                                    }

                                    var54 = true;
                                }
                            } else {
                                var54 = false;
                            }

                            if (!var54) {
                                break;
                            }

                            var26.da[var6][0] = -100000000;
                            var26.cZ[var6][0] = false;
                            var26.da[var6][1] = -100000000;
                            var26.cZ[var6][1] = false;
                            var26.cV[var6] = 4;
                        }
                    case 4:
                        var26.dg[var6] = false;
                        var10000 = var26.dh;
                        var8 = var6;
                        var7 = var26;
                        boolean var31 = false;
                        var14 = 0;
                        var26.du[var6] = 0;

                        int var52;
                        byte var56;
                        int var17;
                        boolean var40;
                        byte var50;
                        while(true) {
                            if (!var7.b(var8, true)) {
                                var56 = var14;
                                break;
                            }

                            var7.a(var8, var7.cF[var8]);
                            ++var14;
                            int[] var55 = var7.du;
                            int var10004 = var55[var8];
                            var7.by[var8] = var7.d(var8, var14);
                            if ((var52 = (var7.bw[var8] + var7.bx[var8]) * (var7.by[var8] + var7.bz[var8] + var7.bA[var8])) > 99999999) {
                                var52 = 99999999;
                            }

                            var55[var8] = var10004 + (var7.bD[var8] + var52) / var7.v();
                            var40 = false;

                            for(var12 = 0; var12 < 6; ++var12) {
                                var17 = 13;
                                boolean var35 = false;

                                for(var25 = 13; var25 >= 0; --var25) {
                                    var48 = var12 + var25 * 6;
                                    var50 = var7.cF[var8][var48];
                                    if (!var35 && var50 == 0) {
                                        var17 = var25;
                                        var35 = true;
                                    } else if (var35 && var50 != 0) {
                                        var31 = true;
                                        var7.cF[var8][var12 + var17 * 6] = var7.cF[var8][var48];
                                        var7.cF[var8][var48] = 0;
                                        --var17;
                                        var25 = var17;
                                        var35 = false;
                                    }
                                }
                            }

                            if (!var31) {
                                var56 = var14;
                                break;
                            }

                            var7.a(var8, true);
                        }

                        int var18;
                        if ((var10000[var6] = var56) > 0) {
                            var26.k(var6);
                            if ((var26.cM[var6] & 1024) > 0) {
                                var8 = var6;
                                var7 = var26;
                                var37 = 0;

                                label1530:
                                while(true) {
                                    if (var37 >= 12) {
                                        var7.dg[var8] = true;
                                        break;
                                    }

                                    for(var34 = 0; var34 < 6; ++var34) {
                                        if (var7.cF[var8][var34 + var37 * 6] != 0) {
                                            break label1530;
                                        }
                                    }

                                    ++var37;
                                }
                            }

                            var26.cZ[var6][1] = true;
                            var26.da[var6][1] = var26.du[var6];
                        } else if (!var26.k(var6)) {
                            var11 = var6;
                            a var39 = var26;
                            var48 = 10000000;
                            boolean[] var41 = var26.cI;
                            var31 = false;

                            for(var34 = 0; var34 < var41.length; ++var34) {
                                var41[var34] = false;
                            }

                            for(var18 = 2; var18 < 14; ++var18) {
                                for(var17 = 0; var17 < 6; ++var17) {
                                    var46 = var17 + var18 * 6;
                                    var50 = var39.cF[var11][var46];
                                    short var49 = var39.eq[var11][var46];
                                    if (var50 != 0 && var50 != 6 && !var39.cI[var46]) {
                                        var39.cJ[0] = (byte)var46;
                                        var39.cI[var46] = true;
                                        var39.cL[var11] = 1;

                                        for(var12 = 0; var12 < var39.cL[var11]; ++var12) {
                                            byte var22;
                                            int var19 = (var22 = var39.cJ[var12]) % 6;
                                            int var20 = var22 / 6;
                                            if ((var39.cG[var11][var22] & 1) > 0 && (var34 = var20 + 1) < 14) {
                                                var39.c(var11, var22, var19 + var34 * 6);
                                            }

                                            if ((var39.cG[var11][var22] & 2) > 0 && (var34 = var20 - 1) >= 0) {
                                                var39.c(var11, var22, var19 + var34 * 6);
                                            }

                                            if ((var39.cG[var11][var22] & 4) > 0) {
                                                var52 = var19 + 1;
                                                if (var52 < 6) {
                                                    var39.c(var11, var22, var52 + var20 * 6);
                                                }
                                            }

                                            if ((var39.cG[var11][var22] & 8) > 0) {
                                                var52 = var19 - 1;
                                                if (var52 >= 0) {
                                                    var39.c(var11, var22, var52 + var20 * 6);
                                                }
                                            }

                                            for(var34 = 0; var34 < 3; ++var34) {
                                                if ((var20 = var18 + var34 + 1) < 14) {
                                                    if ((var19 = var17 + 1) < 6 && var39.cF[var11][var19 + var20 * 6] == var50) {
                                                        var48 += 1024;
                                                        if ((var39.cG[var11][var46] & 12) == 0) {
                                                            var48 += 256;
                                                        }
                                                    }

                                                    if ((var19 = var17 - 1) >= 0 && var39.cF[var11][var19 + var20 * 6] == var50) {
                                                        var48 += 1024;
                                                        if ((var39.cG[var11][var46] & 12) == 0) {
                                                            var48 += 256;
                                                        }
                                                    }
                                                }
                                            }
                                        }

                                        var48 -= 50 - var49 << 8;
                                    }
                                }

                                var48 -= var39.cL[var11] * 100;
                            }

                            label1478: {
                                var34 = var48;
                                var10000 = var26.cF[var6];
                                var23 = 2;
                                var21 = true;
                                if (var10000[2 + var23 * 6] == 0) {
                                    var10000 = var26.cF[var6];
                                    var23 = 2;
                                    var21 = true;
                                    if (var10000[3 + var23 * 6] == 0) {
                                        break label1478;
                                    }
                                }

                                var34 = var48 - 1000000;
                            }

                            label1473: {
                                var10000 = var26.cF[var6];
                                var23 = 2;
                                var21 = true;
                                if (var10000[1 + var23 * 6] == 0) {
                                    var10000 = var26.cF[var6];
                                    var23 = 2;
                                    var21 = true;
                                    if (var10000[4 + var23 * 6] == 0) {
                                        break label1473;
                                    }
                                }

                                var34 -= 500000;
                            }

                            var26.cZ[var6][0] = true;
                            var26.da[var6][0] = var34;
                        }

                        byte var43 = 0;
                        var37 = 0;
                        if (!var26.cS[var6] || var26.dh[var6] != 0) {
                            if (var26.dh[var6] > 0) {
                                if ((var26.cM[var6] & 16) > 0) {
                                    var26.cS[var6] = true;
                                }

                                var43 = 1;
                                if (var26.dg[var6]) {
                                    var37 = 1;
                                } else if ((var37 = var26.dh[var6] + 1) > 16) {
                                    var37 = 16;
                                }

                                if (var26.cT[var6] > 0 && (var26.cM[var6] & 64) > 0) {
                                    var58 = var26.da[var6];
                                    var58[1] += Math.abs(var26.D.nextInt() % (var26.cN[var6] / 10));
                                }
                            } else if (var26.cT[var6] > 0 && (var26.cM[var6] & 64) > 0) {
                                var58 = var26.da[var6];
                                var58[0] -= Math.abs(var26.D.nextInt() % var26.cN[var6]) * 100;
                            }

                            var40 = false;
                            if (var26.db[var6][var37] >= var26.da[var6][var43] && var26.dc[var6][var37]) {
                                if (var26.db[var6][var37] == var26.da[var6][var43]) {
                                    Math.abs(var26.D.nextInt());
                                }
                            } else {
                                var40 = true;
                            }

                            if (var40) {
                                if (!var26.cS[var6]) {
                                    var26.dc[var6][var37] = true;
                                }

                                var26.db[var6][var37] = var26.da[var6][var43];
                                var26.dd[var6][var37] = var26.cP[var6];
                                var10000 = var26.de[var6];
                                var18 = var26.cs[var6];
                                var53 = var26.ct[var6];
                                var10000[var37] = (byte)(var18 + var53 * 6);
                                var26.df[var6][var37] = var26.dh[var6];
                            }
                        }

                        var10003 = var26.cU[var6]++;
                        var26.cV[var6] = 3;
                        var26.a(var6, false);
                    case 2:
                    }
                }
            }
        }

        int var10001;
        boolean var24;
        byte var36;
        char var32;
        boolean var29;
        switch(this.az[var1]) {
        case 0:
            this.z.vibrate(0);
            var10000 = this.bb[var1];
            var23 = 2;
            var21 = true;
            if (var10000[2 + var23 * 6] == 0) {
                var10000 = this.bb[var1];
                var23 = 2;
                var21 = true;
                if (var10000[3 + var23 * 6] == 0) {
                    if (!this.bY[var1]) {
                        this.az[var1] = 1;
                        return;
                    }

                    if (this.bX[var1] == 0) {
                        if (this.aw == 2) {
                            this.winCondition[var1] = true;
                            return;
                        }

                        this.az[var1] = 15;
                        return;
                    }

                    if (this.bu[var1] == -1) {
                        this.az[var1] = 1;
                        return;
                    }

                    if ((var2 = this.bu[var1] + 1) >= 2) {
                        if (this.aw == 2) {
                            var58 = this.bX;
                            var58[var1] += (var2 - 2) * 1000;
                            var32 = '';
                        } else {
                            var58 = this.bX;
                            var58[var1] += (var2 - 2) * 500;
                            var32 = 30000;
                        }

                        if (this.bX[var1] > var32) {
                            this.bX[var1] = var32;
                        }
                    }

                    ++var2;
                    if (this.cc[var1]) {
                        var2 += 2;
                    }

                    var3 = Math.max(3, this.ce[var1] - 2);
                    if (var2 < var3) {
                        var2 = var3;
                    } else if (var2 > 15) {
                        var2 = 15;
                    }

                    this.ce[var1] = var2;
                    this.a(this.es, (this.ce[var1] - 3 << 2) + Math.abs(this.D.nextInt()) % 4, var1);

                    for(var2 = 0; var2 < 84; ++var2) {
                        this.bk[var1][var2] = 0;
                    }

                    this.az[var1] = 20;
                    return;
                }
            }

            this.winCondition[var1] = true;
            return;
        case 1:
            var58 = this.aC;
            var58[var1] += this.C;
            this.aU[var1][0] = var2 - var4 * this.aC[var1] / 50;
            this.aV[var1][0] = var3 - 20 * this.aC[var1] / 50;
            this.aU[var1][1] = var2 + var4;
            this.aV[var1][1] = var3 + 20;
            if (this.aC[var1] >= 50) {
                this.aa[var1] = true;
                this.aC[var1] = 0;
                this.az[var1] = 2;

                for(var5 = 0; var5 < 9; ++var5) {
                    this.aP[var1][var5] = this.aR[var1][0][var5];
                }

                this.aJ[var1] = this.aK[var1][0];
                this.b(var1);
                this.aU[var1][0] = var2 + var4;
                this.aV[var1][0] = var3 + 20;
                this.aU[var1][1] = var2 + (var4 << 1);
                this.aV[var1][1] = var3 + 40;
                return;
            }
            break;
        case 2:
            var58 = this.aC;
            var58[var1] += this.C;

            for(var5 = 0; var5 < 2; ++var5) {
                this.aU[var1][var5] = var2 + var4 * (var5 + 1) - var4 * this.aC[var1] / 100;
                this.aV[var1][var5] = var3 + 20 * (var5 + 1) - 20 * this.aC[var1] / 100;
            }

            if (this.aC[var1] >= 100) {
                this.aa[var1] = true;
                this.aC[var1] = 0;
                this.aU[var1][0] = var2;
                this.aV[var1][0] = var3;
                this.aU[var1][1] = var2 + var4;
                this.aV[var1][1] = var3 + 20;
                this.aB[var1] = 0;
                this.aD[var1] = 0;
                this.aF[var1] = 0;
                this.bu[var1] = -1;
                this.bw[var1] = this.bx[var1] = this.by[var1] = this.bz[var1] = this.bA[var1] = 0;
                this.bC[var1] = 0;
                this.bD[var1] = 0;
                this.ca[var1] = false;
                this.cc[var1] = false;
                this.bh[var1] = false;
                this.i(var1);
                if (this.cr[var1] == -1) {
                    this.az[var1] = 3;
                    return;
                }

                this.az[var1] = 22;
                return;
            }
            break;
        case 4:
            var58 = this.aC;
            var58[var1] += this.C;
            if (this.aC[var1] >= 75) {
                this.h(var1);
                this.aC[var1] = 0;
                if (this.g(var1) == 2) {
                    this.az[var1] = 5;
                }

                this.a(var1, false);
                return;
            }
            break;
        case 5:
            var58 = this.aC;
            var58[var1] += this.C;
            if (this.aC[var1] >= 200) {
                this.aC[var1] = 0;
                if (this.g(var1) == 0) {
                    var29 = true;
                    var6 = var1;
                    var26 = this;

                    for(var8 = 0; var8 < 6; ++var8) {
                        for(var34 = 0; var34 < 14; ++var34) {
                            var37 = var8 + var34 * 6;
                            var26.cF[var6][var37] = var26.bb[var6][var37];
                        }
                    }

                    if (var26.b(var6, true)) {
                        var10003 = this.bu[var1]++;
                        if (this.vibSetting){
                            this.z.vibrate(300);
                        }

                        if (this.sfxType == 1) {
                            if (this.bu[var1] > 5) {
                                try {
                                    ((VolumeControl)this.chain7.getControl("VolumeControl")).setLevel(this.b);
                                    this.chain7.start();
                                } catch (Exception var62) {
                                    var62.printStackTrace();
                                }
                            } else if (this.bu[var1] > 4) {
                                try {
                                    ((VolumeControl)this.chain6.getControl("VolumeControl")).setLevel(this.b);
                                    this.chain6.start();
                                } catch (Exception var61) {
                                    var61.printStackTrace();
                                }
                            } else if (this.bu[var1] > 3) {
                                try {
                                    ((VolumeControl)this.chain5.getControl("VolumeControl")).setLevel(this.b);
                                    this.chain5.start();
                                } catch (Exception var60) {
                                    var60.printStackTrace();
                                }
                            } else if (this.bu[var1] > 2) {
                                try {
                                    ((VolumeControl)this.chain4.getControl("VolumeControl")).setLevel(this.b);
                                    this.chain4.start();
                                } catch (Exception var59) {
                                    var59.printStackTrace();
                                }
                            } else if (this.bu[var1] > 1) {
                                try {
                                    ((VolumeControl)this.chain3.getControl("VolumeControl")).setLevel(this.b);
                                    this.chain3.start();
                                } catch (Exception var) {
                                    var.printStackTrace();
                                }
                            } else if (this.bu[var1] > 0) {
                                try {
                                    ((VolumeControl)this.chain2.getControl("VolumeControl")).setLevel(this.b);
                                    this.chain2.start();
                                } catch (Exception var57) {
                                    var57.printStackTrace();
                                }
                            } else if (this.bu[var1] > -1) {
                                try {
                                    ((VolumeControl)this.chain1.getControl("VolumeControl")).setLevel(this.b);
                                    this.chain1.start();
                                } catch (Exception var56) {
                                    var56.printStackTrace();
                                }
                            }
                        }

                        var24 = false;
                        this.az[var1] = 6;
                        if (var1 == 0) {
                            this.Y[var1] = true;
                        }

                        this.bh[var1] = true;
                        if (this.bu[var1] > this.bE[var1]) {
                            this.bE[var1] = this.bu[var1];
                        }

                        this.by[var1] = this.d(var1, this.bu[var1]);
                        this.bC[var1] = (this.bw[var1] + this.bx[var1]) * (this.by[var1] + this.bz[var1] + this.bA[var1]);
                        if (this.aw == 2) {
                            var58 = this.bC;
                            var58[var1] *= this.ay;
                        }

                        var58 = this.bB;
                        var58[var1] += this.bC[var1];
                        if (this.bB[var1] > 99999999) {
                            this.bB[var1] = 99999999;
                        }

                        this.cm[var1] = (this.bD[var1] + this.bC[var1]) / this.v();

                        for(var5 = 0; var5 < 3; ++var5) {
                            this.cn[var1][var5] = 0;
                        }

                        var5 = this.cj[var1] + this.ck[var1];
                        if (this.cl[var1] == 0 && var5 == 0) {
                            this.ca[var1] = false;
                            return;
                        }

                        this.ca[var1] = true;
                        if (var5 > 0) {
                            if (this.cj[var1] > 0) {
                                this.cn[var1][0] = Math.min(this.cj[var1], this.cm[var1]);
                                var58 = this.cm;
                                var58[var1] -= this.cn[var1][0];
                            }

                            if (this.ck[var1] > 0 && this.cm[var1] > 0) {
                                this.cn[var1][1] = Math.min(this.ck[var1], this.cm[var1]);
                                var58 = this.cm;
                                var58[var1] -= this.cn[var1][1];
                            }
                        }

                        if (this.cl[var1] > 0 && this.cm[var1] > 0) {
                            this.cn[var1][2] = Math.min(this.cl[var1], this.cm[var1]);
                            var58 = this.cm;
                            var58[var1] -= this.cn[var1][2];
                        }

                        if (var1 == 0) {
                            var36 = 1;
                        } else {
                            var36 = 0;
                        }

                        if (!this.bY[var36]) {
                            var58 = this.bX;
                            var58[var36] += 1000;
                            if (this.bX[var36] > 30000) {
                                this.bX[var36] = 30000;
                                return;
                            }
                        }
                    } else {
                        this.az[var1] = 8;
                        if (var1 == 0) {
                            this.Y[var1] = true;
                            return;
                        }
                    }
                } else {
                    this.a(var1, false);
                    this.az[var1] = 4;
                    if (var1 == 0) {
                        this.Y[var1] = true;
                        return;
                    }
                }
            }
            break;
        case 6:
            var58 = this.aC;
            var58[var1] += this.C;
            if (this.aC[var1] >= 200) {
                this.aC[var1] = 0;
                this.az[var1] = 7;
                var24 = false;
                if (var1 == 0) {
                    var58 = this.ck;
                    var58[1] += this.cm[var1];
                } else {
                    var58 = this.ck;
                    var58[0] += this.cm[var1];
                }

                if (this.ca[var1]) {
                    var58 = this.cj;
                    var58[var1] -= this.cn[var1][0];
                    var58 = this.ck;
                    var58[var1] -= this.cn[var1][1];
                    var58 = this.cl;
                    var58[var1] -= this.cn[var1][2];
                    return;
                }
            }
            break;
        case 7:
            var58 = this.aC;
            var58[var1] += this.C;
            if (this.aC[var1] >= 200) {
                if (this.ca[var1] && !this.bY[var1]) {
                    var10003 = this.bV[var1]++;
                    if (this.bV[var1] >= 7) {
                        this.bV[var1] = 7;
                    }
                }

                this.bC[var1] = 0;
                this.bD[var1] = 0;
                this.bw[var1] = this.bx[var1] = this.by[var1] = this.bz[var1] = this.bA[var1] = 0;
                this.cm[var1] = 0;

                for(var5 = 0; var5 < 3; ++var5) {
                    this.cn[var1][var5] = 0;
                }

                this.aC[var1] = 0;
                this.a(var1, this.bb[var1]);
                if (this.g(var1) == 1) {
                    this.az[var1] = 4;
                } else {
                    this.az[var1] = 8;
                }

                this.a(var1, false);
                return;
            }
            break;
        case 8:
            var24 = false;
            this.j(var1);

            for(var3 = 0; var3 < 6; ++var3) {
                var23 = 1;
                var5 = var3 + var23 * 6;
                if (this.bb[var1][var5] != 0) {
                    this.bb[var1][var5] = 0;
                    var24 = true;
                }
            }

            if (var24) {
                this.a(var1, false);
                this.ad[var1] = true;
            }

            if (var1 == 0) {
                var36 = 1;
            } else {
                var36 = 0;
            }

            var58 = this.cj;
            var58[var36] += this.ck[var36];
            this.ck[var36] = 0;
            if (this.bX[var1] == 0) {
                if (this.aw == 2) {
                    this.winCondition[var1] = true;
                    this.az[var1] = 0;
                } else {
                    this.az[var1] = 15;
                }
            }

            this.cc[var1] = true;

            for(var3 = 0; var3 < 6; ++var3) {
                var10000 = this.bb[var1];
                var23 = 13;
                if (var10000[var3 + var23 * 6] != 0) {
                    this.cc[var1] = false;
                    break;
                }
            }

            if (!this.bY[var1] && this.bV[var1] == 7) {
                this.bY[var1] = true;
                if (var1 == 0) {
                    ++this.bG;
                }

                this.az[var1] = 14;
                this.Y[var1] = true;
                if (this.cc[var1]) {
                    var58 = this.ce;
                    var58[var1] += 2;
                    if (this.ce[var1] > 15) {
                        this.ce[var1] = 15;
                    }
                }

                this.a(this.es, (this.ce[var1] - 3 << 2) + Math.abs(this.D.nextInt()) % 4, var1);
                this.cl[var1] = this.cj[var1] + this.ck[var1];
                this.cj[var1] = this.ck[var1] = 0;

                for(var3 = 0; var3 < 84; ++var3) {
                    this.bd[var1][var3] = this.bb[var1][var3];
                    this.bb[var1][var3] = 0;
                    this.bk[var1][var3] = 0;
                    this.bg[var1][var3] = 0;
                }
            } else if (this.cj[var1] > 0 && !this.bh[var1]) {
                this.az[var1] = 13;
                if (this.cr[var1] == -1 && this.P) {
                    if (this.vibSetting){
                        this.z.vibrate(1000);
                    }
                }

                if (this.cj[var1] > 30) {
                    if (var1 == 0 && (this.sfxType == 1 || this.sfxType == 2)) {
                        try {
                            ((VolumeControl)this.nuisanceHeavy.getControl("VolumeControl")).setLevel(this.b);
                            this.nuisanceHeavy.start();
                        } catch (Exception var55) {
                            var55.printStackTrace();
                        }
                    }

                    var3 = 30;
                } else if (this.cj[var1] > 5) {
                    if (var1 == 0 && (this.sfxType == 1 || this.sfxType == 2)) {
                        try {
                            ((VolumeControl)this.nuisanceHeavy.getControl("VolumeControl")).setLevel(this.b);
                            this.nuisanceHeavy.start();
                        } catch (Exception var) {
                            var.printStackTrace();
                        }
                    }

                    var3 = this.cj[var1];
                } else {
                    if (var1 == 0 && (this.sfxType == 1 || this.sfxType == 2)) {
                        try {
                            ((VolumeControl)this.nuisanceLight.getControl("VolumeControl")).setLevel(this.b);
                            this.nuisanceLight.start();
                        } catch (Exception var) {
                            var.printStackTrace();
                        }
                    }

                    var3 = this.cj[var1];
                }

                var58 = this.cj;
                var58[var1] -= var3;

                for(var2 = 0; var2 < 84; ++var2) {
                    this.be[var1][var2] = 0;
                    this.bm[var1][var2] = 2;
                }

                var2 = var3 / 6;
                var3 %= 6;

                for(var25 = 0; var25 < 6; ++var25) {
                    this.co[var1][var25] = var2;
                }

                for(var25 = 0; var25 < 6; ++var25) {
                    if (var25 < var3) {
                        var5 = (this.cp + var25) % 6;
                        var10003 = this.co[var1][dN[var5]]++;
                    }
                }

                var25 = 0;

                while(true) {
                    if (var25 >= 6) {
                        this.cp = (this.cp + var3) % 6;
                        this.bf[var1] = 13;
                        break;
                    }

                    for(var2 = 0; var2 < this.co[var1][var25]; ++var2) {
                        var10000 = this.be[var1];
                        var53 = 13 - var2;
                        var10000[var25 + var53 * 6] = 6;
                    }

                    ++var25;
                }
            } else if (this.bY[var1] && this.bu[var1] != -1) {
                this.az[var1] = 21;
                var2 = this.bu[var1] + 1;
                if (var1 == 0) {
                    if (var2 < this.ce[var1] && (this.sfxType == 1 || this.sfxType == 2)) {
						if (this.voiceLangType == 0) {
                            try {
                                ((VolumeControl)this.amtFevMissVoice.getControl("VolumeControl")).setLevel(this.b);
                                this.amtFevMissVoice.start();
                            } catch (Exception var) {
                                var.printStackTrace();
                            }
						} else if (this.voiceLangType == 1) {
                            try {
                                ((VolumeControl)this.amtFevMissVoiceEN.getControl("VolumeControl")).setLevel(this.b);
                                this.amtFevMissVoiceEN.start();
                            } catch (Exception var) {
                                var.printStackTrace();
                            }
						}
                    }

                    this.dt = false;
                    if (var2 >= this.ce[var1]) {
                        if (!this.cc[var1] && (this.sfxType == 1 || this.sfxType == 2)) {
							if (this.voiceLangType == 0) {
                                try {
                                    ((VolumeControl)this.amtFevClearVoice.getControl("VolumeControl")).setLevel(this.b);
                                    this.amtFevClearVoice.start();
                                } catch (Exception var) {
                                    var.printStackTrace();
                                }
							} else if (this.voiceLangType == 1) {
                                try {
                                    ((VolumeControl)this.amtFevClearVoiceEN.getControl("VolumeControl")).setLevel(this.b);
                                    this.amtFevClearVoiceEN.start();
                                } catch (Exception var) {
                                    var.printStackTrace();
                                }
							}
                        }

                        this.dt = true;
                    }
                }
            } else {
                this.az[var1] = 0;
            }

            if (this.cc[var1]) {
                if (this.aw == 2) {
                    if (this.sfxType == 1 || this.sfxType == 2) {
                        try {
                            ((VolumeControl)this.allClear.getControl("VolumeControl")).setLevel(this.b);
                            this.allClear.start();
                        } catch (Exception var) {
                            var.printStackTrace();
                        }
                    }

                    if (!this.winCondition[var1]) {
                        var58 = this.bX;
                        var58[var1] += 3000;
                    }
                } else if (this.bX[var1] != 0) {
                    if (this.sfxType == 1 || this.sfxType == 2) {
                        try {
                            ((VolumeControl)this.allClear.getControl("VolumeControl")).setLevel(this.b);
                            this.allClear.start();
                        } catch (Exception var45) {
                            var45.printStackTrace();
                        }
                    }

                    var58 = this.bX;
                    var58[var1] += 5000;
                }

                if (this.aw == 2) {
                    var32 = '';
                } else {
                    var32 = 30000;
                }

                if (this.bX[var1] > var32) {
                    this.bX[var1] = var32;
                }

                if (!this.bY[var1]) {
                    this.a(this.es, 4 + Math.abs(this.D.nextInt()) % 4, var1);

                    for(var2 = 0; var2 < 84; ++var2) {
                        this.bk[var1][var2] = 0;
                    }

                    this.az[var1] = 20;
                }

                var10003 = this.cb[var1]++;
                return;
            }
            break;
        case 9:
            if (this.aC[var1] < 1000) {
                var58 = this.aC;
                var58[var1] += this.C;
                return;
            }

            if (var1 == 0) {
                this.G = 7;
                return;
            }

            this.G = 6;
            break;
        case 11:
        case 18:
            var58 = this.aC;
            var58[var1] += this.C;
            if (this.aC[var1] >= 200) {
                this.aC[var1] = 0;
                if (this.g(var1) == 0) {
                    if (this.az[var1] == 11) {
                        this.az[var1] = 12;
                    } else {
                        this.a(var1, false);
                        this.az[var1] = 19;
                    }

                    this.aC[var1] = 0;
                } else if (this.az[var1] == 11) {
                    this.az[var1] = 13;
                } else {
                    this.az[var1] = 20;
                }

                if (var1 == 0) {
                    this.Y[var1] = true;
                    return;
                }
            }
            break;
        case 12:
        case 19:
            var58 = this.aC;
            var58[var1] += this.C;
            if (this.aC[var1] >= 50) {
                if (!this.bY[var1]) {
                    this.az[var1] = 0;
                    return;
                }

                this.az[var1] = 1;
                this.z.vibrate(0);
                var10000 = this.bb[var1];
                var23 = 2;
                var21 = true;
                if (var10000[2 + var23 * 6] == 0) {
                    var10000 = this.bb[var1];
                    var23 = 2;
                    var21 = true;
                    if (var10000[3 + var23 * 6] == 0) {
                        return;
                    }
                }

                this.winCondition[var1] = true;
                return;
            }
            break;
        case 13:
        case 20:
            var24 = false;
            if (this.bf[var1] >= 0) {
                for(var3 = 0; var3 < 6; ++var3) {
                    var10000 = this.be[var1];
                    var53 = this.bf[var1];
                    if (var10000[var3 + var53 * 6] != 0) {
                        var24 = true;
                        break;
                    }
                }

                if (var24) {
                    this.j(var1);

                    for(var3 = 0; var3 < 6; ++var3) {
                        if (this.di[var1][var3] > 0) {
                            var10000 = this.bb[var1];
                            var23 = 1;
                            var10001 = var3 + var23 * 6;
                            var10002 = this.be[var1];
                            var53 = this.bf[var1];
                            var10000[var10001] = var10002[var3 + var53 * 6];
                        }
                    }
                }
            }

            var10003 = this.bf[var1]--;
            if (this.az[var1] == 13) {
                this.az[var1] = 10;
            } else {
                this.az[var1] = 17;
            }

            this.g(var1);
        case 10:
        case 17:
            var58 = this.aC;
            var58[var1] += this.C;
            if (this.aC[var1] >= 25) {
                this.h(var1);
                this.aC[var1] = 0;
                if (this.g(var1) == 2) {
                    if (var1 == 0) {
                        this.Y[var1] = true;
                    }

                    if (this.az[var1] == 10) {
                        this.az[var1] = 11;
                    } else {
                        this.az[var1] = 18;
                        this.ad[var1] = true;
                    }

                    if (this.bY[var1] && this.bZ[var1]) {
                        this.bZ[var1] = false;
                        this.Y[var1] = true;
                    }

                    if (this.cc[var1]) {
                        this.Y[var1] = true;
                    }

                    if (var1 == 0) {
                        this.dt = false;
                        this.Y[var1] = true;
                    }

                    this.z.vibrate(0);
                    return;
                }

                if (this.bf[var1] >= 0) {
                    if (this.az[var1] == 10) {
                        this.az[var1] = 13;
                        return;
                    }

                    this.az[var1] = 20;
                    return;
                }

                if (this.az[var1] == 10) {
                    this.az[var1] = 11;
                    return;
                }

                this.az[var1] = 18;
                this.ad[var1] = true;
                return;
            }
            break;
        case 14:
            this.az[var1] = 20;
            this.bZ[var1] = true;
            this.a(9);
            if (this.sfxType == 1 || this.sfxType == 2) {
                try {
                    ((VolumeControl)this.feverEntry.getControl("VolumeControl")).setLevel(this.b);
                    this.feverEntry.start();
                } catch (Exception var) {
                    var.printStackTrace();
                }
            }
			
            if (this.vibSetting){
                this.z.vibrate(500);
            }
            return;
        case 15:
            if (this.sfxType == 1 || this.sfxType == 2) {
                try {
                    ((VolumeControl)this.feverExit.getControl("VolumeControl")).setLevel(this.b);
                    this.feverExit.start();
                } catch (Exception var43) {
                    var43.printStackTrace();
                }
            }

            this.az[var1] = 0;
            this.bY[var1] = false;
            if (this.aw == 0 && var1 == 0) {
                this.bV[var1] = 3;
            } else {
                this.bV[var1] = 0;
            }

            this.bX[var1] = 15000;
            var58 = this.cj;
            var58[var1] += this.cl[var1];

            for(var3 = 0; var3 < 84; ++var3) {
                this.bb[var1][var3] = this.bd[var1][var3];
                this.a(var1, false);
            }

            this.Y[var1] = true;
            this.j(var1);
            this.f();
            return;
        case 16:
        default:
            break;
        case 21:
            if (this.aC[var1] < 1000) {
                var58 = this.aC;
                var58[var1] += this.C;
                return;
            }

            for(var3 = 0; var3 < 84; ++var3) {
                this.bb[var1][var3] = 0;
                this.bk[var1][var3] = 0;
                this.bg[var1][var3] = 0;
            }

            this.az[var1] = 0;
            this.aC[var1] = 0;
            if (this.cc[var1]) {
                this.Y[var1] = true;
            }

            if (var1 == 0) {
                this.dt = false;
                this.Y[var1] = true;
                return;
            }
            break;
        case 22:
            var6 = var1;
            var26 = this;
            if (this.cV[var1] != 0) {
                var54 = false;
            } else if (!this.cW[var1]) {
                this.i(var1);
                var54 = false;
            } else {
                if (this.dc[var1][1]) {
                    var8 = 1;
                } else {
                    this.l(var1);
                    var37 = 0;

                    for(var25 = 0; var25 < 6; ++var25) {
                        var37 += var26.di[var6][var25];
                    }

                    var34 = var26.cx[var6];
                    if (var26.bY[var6]) {
                        if ((var34 = var26.ce[var6]) >= 5) {
                            --var34;
                        }

                        if (var26.dv[var6] > 2) {
                            --var34;
                        }

                        if (var26.dv[var6] > 4) {
                            --var34;
                        }

                        if (var26.dv[var6] > 5) {
                            var26.cT[var6] = 1;
                        }

                        if (var26.dv[var6] > 6) {
                            var26.cT[var6] = 2;
                        }

                        if (var34 < 0) {
                            var34 = 1;
                        }
                    } else if (var37 > 48) {
                        ++var34;
                    }

                    var8 = var26.e(var6, var34);
                    if (var26.de[var6][var8] == -1) {
                        var8 = var26.e(var6, 1);
                    } else if (var26.cj[var6] > 0 && (var26.cM[var6] & 512) > 0 && !var26.bY[var6]) {
                        var8 = var26.f(var6, 1);
                    }
                }

                if (var26.cT[var6] == 1) {
                    var8 = var26.f(var6, 2);
                }

                if (var26.cT[var6] >= 2) {
                    var8 = var26.f(var6, 1);
                }

                if (var26.de[var6][var8] == -1 && var26.de[var6][0] != -1) {
                    var8 = 0;
                }

                var26.cu[var6] = var26.dd[var6][var8] - 1;
                var26.cs[var6] = var26.de[var6][var8] % 6;
                var26.ct[var6] = var26.de[var6][var8] / 6;
                if (var26.de[var6][var8] == -1) {
                    var26.cu[var6] = 0;
                    var26.cv[var6] = var26.aP[var6][1];
                    var26.cs[var6] = 2;
                    var26.cs[var6] = 1;
                }

                if (var26.bY[var6]) {
                    ++var26.dv[var6];
                }

                var26.cW[var6] = false;
                var54 = true;
            }

            if (!var54) {
                break;
            }

            this.az[var1] = 3;
        case 3:
            var6 = var1;
            var26 = this;
            var29 = false;
            this.aW[var1] = this.aY[var1];
            this.aX[var1] = this.aZ[var1];
            this.aN[var1] = this.aM[var1];

            for(var11 = 0; var11 < 9; ++var11) {
                var26.aO[var6][var11] = var26.aP[var6][var11];
            }

            label1679: {
                switch(var26.aB[var6]) {
                case 0:
                    var26.aM[var6] = 0;
                    var26.aY[var6] = 2;
                    var26.aZ[var6] = 1;
                    short var42;
                    if (var26.aw == 2) {
                        var42 = dT[var26.cE[var6]];
                    } else {
						if (var26.difficultyType == 4) {
                            var42 = puyoDifficultyVeryHard[var26.cE[var6]];
						} else if (var26.difficultyType == 3) {
                            var42 = puyoDifficultyEasy[var26.cE[var6]];
						} else if (var26.difficultyType == 2) {
                            var42 = puyoDifficultyNormal[var26.cE[var6]];
						} else if (var26.difficultyType == 1) {
                            var42 = puyoDifficultyHard[var26.cE[var6]];
						} else {
                            var42 = puyoDifficultyNormal[var26.cE[var6]];
						}
                    }

                    var26.aE[var6] = 4266 / var42;
                    if (var26.aE[var6] < 75) {
                        var26.aE[var6] = 75;
                    }

                    var26.aB[var6] = 1;
                    var26.aD[var6] = 0;
                    var26.f(var6);
                    var26.aI[var6] = 0;
                case 1:
                    break;
                case 2:
                    if (var1 == 0 && this.sfxType == 1) {
                        try {
                            ((VolumeControl)this.puyoDrop.getControl("VolumeControl")).setLevel(this.b);
                            this.puyoDrop.start();
                        } catch (Exception var50) {
                            var50.printStackTrace();
                        }
                    }

                    for(var8 = 0; var8 < 6; ++var8) {
                        var26.bn[var6][var8] = 2;
                    }

                    for(var8 = 0; var8 < 3; ++var8) {
                        for(var34 = 0; var34 < 3; ++var34) {
                            if ((var33 = var26.aP[var6][var8 + var34 * 3]) != 0) {
                                var10000 = var26.bb[var6];
                                var10001 = var26.a(var6, var8);
                                var53 = var26.aZ[var6] - 1 + var34;
                                var10000[var10001 + var53 * 6] = var33;
                                var26.bn[var6][var26.a(var6, var8)] = 0;
                                var26.aP[var6][var8 + var34 * 3] = 0;
                            }
                        }
                    }

                    var26.e(var6);
                    var26.aY[var6] = 2;
                    var26.aZ[var6] = 1;
                    var26.aS[var6] = var26.an + dO[var6] + (var26.aY[var6] - 1 << 4);
                    var26.aT[var6] = var26.menuBaseC + 55 + (var26.aZ[var6] - 1) * 14;
                    var29 = true;
                default:
                    break label1679;
                }

                label1684: {
                    var58 = var26.aF;
                    var58[var6] += var26.C;
                    switch(var26.aD[var6]) {
                    case 0:
                        break;
                    case 1:
                        if (var26.d(var6)) {
                            if (var26.aF[var6] == 0) {
                                var10003 = var26.aZ[var6]--;
                            } else {
                                var26.aF[var6] = 0;
                            }

                            var26.aD[var6] = 2;
                            var26.aH[var6] = 0;
                            ++var26.aI[var6];
                        } else {
                            var26.aD[var6] = 0;
                        }

                        var58 = var26.aG;
                        var58[var6] += var26.C;
                        if (var26.aG[var6] >= 0) {
                            if (var26.d(var6)) {
                                if (var26.aF[var6] == 0) {
                                    var10003 = var26.aZ[var6]--;
                                } else {
                                    var26.aF[var6] = 0;
                                }

                                var26.aD[var6] = 2;
                                var26.aH[var6] = 0;
                            } else {
                                var26.aD[var6] = 0;
                            }
                        }
                        break label1684;
                    case 2:
                        if (var26.c(var6)) {
                            var26.aD[var6] = 0;
                            break;
                        } else {
                            var26.aF[var6] = 0;
                            var58 = var26.aH;
                            var58[var6] += var26.C;
                            if (var26.aH[var6] < 800 && var26.aI[var6] < 8) {
                                break;
                            }

                            var26.aB[var6] = 2;
                        }
                    default:
                        break label1684;
                    }

                    if (var26.aF[var6] >= var26.aE[var6]) {
                        var26.aF[var6] = 0;
                        var10003 = var26.aZ[var6]++;
                        if (!var26.c(var6)) {
                            if (var26.d(var6)) {
                                var10003 = var26.aZ[var6]--;
                            }

                            var26.aD[var6] = 2;
                            var26.aH[var6] = 0;
                            ++var26.aI[var6];
                            break label1684;
                        }
                    }

                    if (var26.d(var6)) {
                        if (var26.aF[var6] == 0) {
                            var10003 = var26.aZ[var6]--;
                        } else {
                            var26.aF[var6] = 0;
                        }

                        var26.aD[var6] = 2;
                        var26.aH[var6] = 0;
                        ++var26.aI[var6];
                    }

                    var26.cq[var6] = 0;
                    if (var26.cr[var6] == -1) {
                        if ((var26.s & 16) != 0) {
                            var26.cq[var6] = 1;
                        } else if ((var26.s & 1) != 0) {
                            var26.cq[var6] = 2;
                        } else if ((var26.s & 2) != 0) {
                            var26.cq[var6] = 3;
                        } else if ((var26.s & 8) != 0) {
                            var26.cq[var6] = 4;
                        } else if ((var26.t & 4) != 0) {
                            var26.cq[var6] = 5;
                        }
                    } else {
                        if (var26.l(var6) > 0) {
                            var46 = (var26.cz[var6] + var26.cC[var6] / 2) * var26.cD[var6] / 100;
                            var48 = var26.cy[var6] * var26.cD[var6] / 100;
                        } else {
                            var46 = var26.cz[var6] + var26.cC[var6] / 2;
                            var48 = var26.cy[var6];
                        }

                        if (var46 < 75) {
                            var46 = 75;
                        }

                        if (var48 < 20) {
                            var48 = 20;
                        }

                        if (var46 > var26.cB[var6]) {
                            var58 = var26.cB;
                            var58[var6] += var26.C;
                        } else {
                            var26.cq[var6] = 5;
                            var26.cB[var6] = 0;
                        }

                        if (var48 > var26.cA[var6]) {
                            var58 = var26.cA;
                            var58[var6] += var26.C;
                        } else {
                            var26.cA[var6] = 0;
                            if (var26.aZ[var6] > var26.ct[var6] && var26.aZ[var6] < 10) {
                                var26.cq[var6] = 5;
                            }

                            if (var26.aY[var6] < var26.cs[var6]) {
                                var26.cq[var6] = 4;
                            } else if (var26.aY[var6] > var26.cs[var6]) {
                                var26.cq[var6] = 3;
                            }

                            if (var26.aJ[var6] == 3) {
                                var51 = var26.aP[var6][4];
                                if (var26.cv[var6] != var51) {
                                    if ((var26.cv[var6] - var51 + var26.bo[var6]) % var26.bo[var6] < var26.bo[var6] / 2) {
                                        var26.cq[var6] = 1;
                                    } else {
                                        var26.cq[var6] = 2;
                                    }
                                }
                            } else if (var26.aM[var6] != var26.cu[var6]) {
                                if ((var26.aM[var6] - var26.cu[var6] + 4) % 4 > 2) {
                                    var26.cq[var6] = 1;
                                } else {
                                    var26.cq[var6] = 2;
                                }
                            }
                        }
                    }

                    switch(var26.cq[var6]) {
                    case 1:
                        if (var1 == 0 && this.sfxType == 1) {
                            try {
                                ((VolumeControl)this.puyoRotate.getControl("VolumeControl")).setLevel(this.b);
                                this.puyoRotate.start();
                            } catch (Exception var49) {
                                var49.printStackTrace();
                            }
                        }

                        if (var26.aJ[var6] == 3) {
                            var51 = (byte)(var26.aP[var6][1] + 1);
                            if (var26.bo[var6] == 5 && var51 > 5 || var26.bo[var6] == 4 && var51 > 4 || var26.bo[var6] == 3 && var51 > 3) {
                                var51 = 1;
                            }

                            var26.aP[var6][1] = var51;
                            var26.aP[var6][2] = var51;
                            var26.aP[var6][4] = var51;
                            var26.aP[var6][5] = var51;
                            var26.f(var6);
                        } else if (var26.b(var6, 0)) {
                            var26.aD[var6] = 1;
                            var26.aG[var6] = 0;
                            var26.f(var6);
                            var26.aH[var6] = 0;
                        } else if (var26.aJ[var6] == 0) {
                            ++var26.dn[var6];
                            if (var26.dn[var6] == 2) {
                                var26.dn[var6] = 0;
                                if (var26.b(var6, 2)) {
                                    var26.aD[var6] = 1;
                                    var26.aG[var6] = 0;
                                    var26.f(var6);
                                    var26.aH[var6] = 0;
                                }
                            }
                        }
                        break;
                    case 2:
                        if (var26.aJ[var6] == 3) {
                            if ((var51 = (byte)(var26.aP[var6][1] - 1)) < 1) {
                                if (var26.bo[var6] == 3) {
                                    var51 = 3;
                                } else if (var26.bo[var6] == 4) {
                                    var51 = 4;
                                } else {
                                    var51 = 5;
                                }
                            }

                            var26.aP[var6][1] = var51;
                            var26.aP[var6][2] = var51;
                            var26.aP[var6][4] = var51;
                            var26.aP[var6][5] = var51;
                            var26.f(var6);
                        } else if (var26.b(var6, 1)) {
                            var26.aD[var6] = 1;
                            var26.aG[var6] = 0;
                            var26.f(var6);
                            var26.aH[var6] = 0;
                        } else if (var26.aJ[var6] == 0) {
                            ++var26.dn[var6];
                            if (var26.dn[var6] == 2) {
                                var26.dn[var6] = 0;
                                if (var26.b(var6, 2)) {
                                    var26.aD[var6] = 1;
                                    var26.aG[var6] = 0;
                                    var26.f(var6);
                                    var26.aH[var6] = 0;
                                }
                            }
                        }
                        break;
                    case 3:
                        if (!var26.a(var6, var26.aY[var6] - 1, var26.aZ[var6])) {
                            if (var1 == 0 && this.sfxType == 1) {
                                try {
                                    ((VolumeControl)this.puyoMove.getControl("VolumeControl")).setLevel(this.b);
                                    this.puyoMove.start();
                                } catch (Exception var) {
                                    var.printStackTrace();
                                }
                            }

                            var10003 = var26.aY[var6]--;
                            var26.f(var6);
                        }
                        break;
                    case 4:
                        if (!var26.a(var6, var26.aY[var6] + 1, var26.aZ[var6])) {
                            if (var1 == 0 && this.sfxType == 1) {
                                try {
                                    ((VolumeControl)this.puyoMove.getControl("VolumeControl")).setLevel(this.b);
                                    this.puyoMove.start();
                                } catch (Exception var47) {
                                    var47.printStackTrace();
                                }
                            }

                            var10003 = var26.aY[var6]++;
                            var26.f(var6);
                        }
                        break;
                    case 5:
                        if (var26.aD[var6] == 2) {
                            var26.aB[var6] = 2;
                        } else if (var26.c(var6)) {
                            var10003 = var26.aZ[var6]++;
                        } else {
                            var26.aF[var6] = var26.aE[var6];
                        }

                        var10003 = var26.bD[var6]++;
                        var10003 = var26.bB[var6]++;
                    }
                }

                var26.aS[var6] = var26.an + dO[var6] + (var26.aY[var6] - 1 << 4);
                var26.aT[var6] = var26.menuBaseC + 55 + (var26.aZ[var6] - 1) * 14;
            }

            if (var26.aW[var6] != var26.aY[var6] || var26.aX[var6] != var26.aZ[var6] || var26.aN[var6] != var26.aM[var6]) {
                var26.Z[var6] = true;
            }

            if (var29) {
                this.az[var1] = 5;
                this.g(var1);
                this.a(var1, false);
                this.aC[var1] = 0;
                this.ay = this.singlePuyoPopBase;
                return;
            }
        }

    }

    private void c(Graphics var1, int var2) {
        int var5 = this.an + 104 + var2 * 17;
        if (this.aw == 2) {
            if (this.ingameBgColorType == 1) {
                var1.setColor(11622577);
            } else if (this.ingameBgColorType == 2) {
                var1.setColor(4153515);
            } else if (this.ingameBgColorType == 3) {
                var1.setColor(12276558);
            } else if (this.ingameBgColorType == 4) {
                var1.setColor(15185259);
            }
            var1.fillRect(var5, this.menuBaseC + 83 + eL[0], 16, eL[7]);
        } else {
            var1.setColor(16777215);
            var1.fillRect(var5, this.menuBaseC + 83 + eL[0], 16, eL[7]);
            var1.setColor(16750848);

            for(int var6 = 0; var6 < this.bV[var2]; ++var6) {
                int var3 = eL[7 - var6];
                int var4 = eL[7 - var6 - 1];
                var1.fillRect(var5, this.menuBaseC + 83 + var4, 16, var3 - var4);
            }
        }

        var1.drawRegion(this.puyoGraphics[6], var2 * 17, 0, 16, 64, 0, var5, this.menuBaseC + 83, 20);
    }

    private static int o(int var0) {
        return var0 >= 0 ? eM[var0 % 256] : 0;
    }

    private void a(Graphics var1, String var2) {
        int var3 = this.displayWidth;
        int var9 = this.displayHeight;
        var1.setColor(0);
        var1.fillRect(0, 0, var3, var9);
        var1.setColor(16777215);
        Font var4 = var1.getFont();
        int var5 = 0;
        int var6 = 0;
        String[] var7 = new String[]{"", "", "", "", "", "", "", ""};

        int var11;
        while(var2.length() > 0) {
            String var8 = var2.substring(0, 1);
            var2 = var2.substring(1);
            if (var8.equals(",")) {
                if ((var11 = var4.stringWidth(var7[var6++])) > var5) {
                    var5 = var11;
                }
            } else {
                var7[var6] = var7[var6] + var8;
            }
        }

        if ((var11 = var4.stringWidth(var7[var6++])) > var5) {
            var5 = var11;
        }

        var11 = var4.getHeight();
        int var10 = (var3 - var5) / 2;
        var9 = (var9 - var11 * var6) / 2;

        for(var3 = 0; var3 < var6; ++var3) {
            var1.drawString(var7[var3], var10, var9 + var3 * var11, 20);
        }

    }
}
