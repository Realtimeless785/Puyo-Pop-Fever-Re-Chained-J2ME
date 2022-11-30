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
    private String leftSoftkeyText;
    private String rightSoftkeyText;
    private Image leftSoftkeyImage;
    private Image rightSoftkeyImage;
    private Image saveIcon;
    private byte e;
    private Image f;
    private Image g;
    private int[][] splashRGB = new int[2][];
    private int[] splashRGBw = new int[2];
    private int[] splashRGBh = new int[2];
    private int h;
    private String[][] runrunCourseOpeningString = new String[][]{{"Once upon a time...", "In some other world...", "There lived a young girl", "whose dream was to", "become a wonderfully", "clever magic user."}, {"Her name is Amitie,", "and she is at", "her studies again today."}};
    private String[][][] runrunCourseManzaiString = new String[][][]{{{"...And that's that.", "Any questions so far?"}, {"I think I understand."}, {"Okay, then try practicing", "with the person sitting", "next to you."}, {"I'm ready..."}}, {{"Have you kiddies", "got the knack of", "fever mode?"}, {"Yeah...? Teacher, what", "should I do if I can't", "offset well?"}, {"Anyway, Let's try it", "with a different", "partner this time."}, {"Oh, me.", "Try facing off with me."}}, {{"Teacher! I..I think I've", "got the hang of this."}, {"That's good to hear,", "young lady!"}, {"Then...", "I guess it's test time."}, {"What, a test!?"}, {"What would learning", "be without exams?"}, {"After all,", "applied knowledge", "is acquired knowledge."}}};
    private String[][] runrunCourseEndingString = new String[][]{{"Wicked! I got the", "better of you, teacher!!"}, {"Nice job! Okay then,", "your next test will be..."}, {"What!?", "There's more!?"}, {"I'll be waiting at the", "WakuWaku Course!"}};
    private String[][] wakuwakuCourseOpeningString = new String[][]{{"Hello!", "The name's Amitie!!", "I'm hitting the books", "hard to become a", "wonderful magic user.", "But today isn't", "the day for studies."}, {"Prof. Accord seems", "to have \"misplaced\" or", "should I say LOST her", "flying cane."}, {"She said she'd give", "a reward to the person", "who finds it so", "everyone is psyched.", "And of course,", "that goes for little", "old me too!"}};
    private String[][][] wakuwakuCourseManzaiString = new String[][][]{{{"Good day to you,", "Miss Amitie."}, {"Oh hi, Raffina.", "Are you going looking", "for Accord's cane, too?"}, {"Yes, most definitely."}, {"Would you like to go", "together?"}, {"What ever is your", "lowly unrefined", "mind thinking?"}, {"Un...re...fined?"}, {"Everybody knows the", "fewer rivals the", "better, right?"}, {"So you can just take", "a little nap for me!"}}, {{"Wazzup?!"}, {"Whaaaa!", "You scared the living", "heck out of me."}, {"Hey you there in the", "deathly uncool clothes!"}, {"Get real!", "Who are you", "calling uncool!"}, {"Just who are you calling", "uncool? I can't figure", "out why you're uncool."}, {"Get really real!", "Now you've ticked me", "off!!"}, {"Oh-ho-ho! We'll have", "to puyo pop to seperate", "the cool from the uncool."}}, {{"Oh, hi.", "If it isn't Rita."}, {"M-miss A-Amitie..."}, {"No way?", "You're looking too?"}, {"I-I'm sorry...", "I, I just..."}, {"You don't need to", "apologize..."}, {"W-w-well... G-go easy", "on me will you?"}, {"Y-you too...", "(Now he's got me", "stuttering)."}}, {{"Ribit-ribit!"}, {"Ahh, how icky!"}, {"Ribit-ribit!!"}, {"Wha...", "Are you angry?"}}, {{"Salutations Amitie.", "You out cane", "searching too?"}, {"You betcha, Klug.", "But where that cane", "has gotten itself off to."}, {"Well, I shouldn't tell", "you this, but..."}, {"With me being first", "in the class at magic I've", "located its whereabouts."}, {"Get real! Really?"}, {"Would you like for me", "to tell you its", "hiding place?"}, {"Would I!"}, {"Well, only if you can", "outdo me at puyo pop,", "that is!"}}, {{"FriEND!", "F-FriEND!!"}, {"Whaaaa!", "You scared the living", "heck out of me."}, {"Daddy says...", "We won't let you pass!"}, {"Daddy says...", "If you want to pass,", "you'll have to puyo pop!"}, {"Now does he?", "Well then, you're on!"}, {"F-FriEND!!", "End!! End!!"}, {"Daddy says..."}, {"Two on One is only", "fair and square!"}, {"The only thing \"square\"", "here are your heads!"}}, {{"Howdy-do! I'm Arle!", "Nice to meet you."}, {"The name's Amitie!!", "Nice meeting you."}, {"Just...", "Where am I?"}, {"Huh?"}, {"I was playing puyo like", "I always do and the next", "thing I know. I'm here."}, {"And just where is here...", "Maybe my magic failed", "and sent me off the map."}, {"Hmmm... Why do you", "try to do it again?", "Maybe you'll go back!"}, {"Good idea!! Let's get", "in a game of puyo pop", "first."}, {"Sure thing...", "Somehow I knew you", "were going to say that."}}, {{"So you made it this far,", "Amitie..."}, {"And so have you...", "Pretty climactic if you", "ask me!"}, {"Is this golden axe what", "you have been seeking?", "Or this silver axe?"}, {"Thanks, but...", "I told you, what I want", "is the flying cane!"}, {"Ha-ha-ha."}, {"Okay then missy.", "Here's your flying cane!"}, {"But you can't have it", "for nothing."}, {"Prepare to puyo pop!", "I was dying to play", "anyway!"}}};
    private String[][] wakuwakuCourseEndingString = new String[][]{{"Yes! I've got the", "flying cane!"}, {"Congratulations,", "Miss Amitie!"}, {"Oh, Ms. Accord! Here's", "your flying cane back."}, {"Thank you..."}, {"I guess I should", "give you that reward", "for your help."}, {"No,", "not really.", "You don't have to."}, {"I don't? Well if you insist.", "Then no reward it is."}, {"Really? I thought that's", "what you wanted?", "I was wrong about you."}, {"Huh? Well...", "Yeah... Uh-huh...", "But I..."}, {"Come on. It's about", "time we got back to", "school."}, {"Get really real..."}};
    private String[][][] tutorialString = new String[][][]{{{"Good morning.", "Have you got a fever", "for Puyo Pop?"}, {"Let's study", "how to play."}}, {{"Puyo fall down not", "only in twos but as", "many as four at a time."}, {"While you can rotate", "some puyo, the big", "ones change color..."}, {"and can't be turned."}}, {{"When four puyo of the", "same color connect,", "you send a nuisance..."}, {"puyo to your", "opponent."}}, {{"As puyo keep", "disappearing,..."}, {"Chains of nuisance", "puyo are sent to your", "opponent."}}, {{"Don't lose your cool if", "your opponent sends", "you nuisance puyo."}, {"You can negate your", "opponent's nuisance", "puyo with your own."}, {"This is called", "offsetting."}, {"After offsetting,", "Nuisance puyo won't", "fall. Don't give up."}}, {{"When offsetting, the", "fever mode begins..."}, {"when the fever gauge", "gets full."}}, {{"In fever mode, the", "nuisance puyo won't", "fall for a while."}}, {{"What's even better is", "that the chain puyo", "keep dropping one..."}, {"after the other.", "Pretty cool, huh?"}, {"And keep dropping", "no matter what. The", "better you do, the..."}, {"bigger the chain.", "Of course, even in the", "fever mode, you can..."}, {"still make chains or", "send nuisance puyo", "to your opponent."}}, {{"When two middle rows", "pile up, the game is", "over."}}, {{"And that's that.", "Have a good luck!"}}};
    private String[][] menuDescriptionString = new String[][]{{"Single Player vs. COM.", "", ""}, {"Non stop Fever!", "Big Chains or All Clear", "will add to the playtime."}, {"Training course for", "beginners. (3 Stages)", ""}, {"Intermediate course for", "those who have learned", "the rules. (8 Stages)"}, {"Here you can change", "the game settings.", ""}, {"Explanation of Puyo", "Pop Fever rules."}, {"Change the", "sound settings."}, {"View score ranking", "for each mode."}, {"About Puyo Pop Fever.", ""}, {"Return to the", "main menu."}};
    private String[][] aboutString = new String[][]{{"Puyo Pop Fever", "Re:Chained LITE", "Ver. 1.51 (0000)", "© SEGA", "", "Modded by:", "Realtimeless"}, {"", "Screen Resolution:", "240x320", "Presented by:", "SEGA", "Developed by:", "SONIC TEAM"}, {"", "Thank you", "for playing,", "Puyo Pop Fever", "Re:Chained LITE!", "", "Modded by RTL."}, {"", "If you want to", "support development,", "you can get the source", "code from GitHub and", "implement some new", "features by yourself! :)"}};
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
    private int saveTime = 0;
    private int refreshTime = 0;
    private int soundOptionMenu;
    private int aboutOptionMenu;
    private int N;
    private boolean gameError;
    private boolean loadedFlag;
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
    private Player dk;
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
    private String[] bgmSound = new String[]{"/bgm00_title.mid", "/bgm01_menu.mid", "/bgm03_opening.mid", "/bgm04_manzai1.mid", "/bgm10_taisen1.mid", "/bgm11_taisen2.mid", "/bgm12_taisen3.mid", "/bgm13_taisen4.mid", "/bgm14_pinch.mid", "/bgm15_fever.mid", "/bgm18_clear.mid", "/bgm19_lose.mid", "/bgm05_manzai2.mid"};
    private static final int[][] dM = new int[][]{{2451112, 15790300}, {7237280, 15790300}, {15098980, 15790300}};
    private static final byte[] dN = new byte[]{0, 3, 2, 5, 1, 4};
    private static final short[] dO = new short[]{5, 138};
    private static final byte[][] dP = new byte[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static final byte[] dQ = new byte[]{1, 2, 0, 3};
    private static final byte[][] dR = new byte[][]{{1, 0}, {2, 0}, {2, 1}, {1, 1}};
    private static final short[] dS = new short[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 128};
    private static final short[] dT = new short[]{8, 8, 9, 9, 10, 10, 12, 12, 16, 16, 10, 10, 11, 11, 12, 12, 14, 14, 32, 32, 16, 16, 32, 32, 52, 52, 64, 64, 96, 96, 32, 32, 48, 48, 52, 52, 64, 64, 96, 96, 48, 48, 64, 64, 96, 96, 128, 128, 128, 128, 64, 64, 96, 96, 128, 128, 128, 128, 142, 142, 96, 96, 128, 128, 128, 128, 128, 128, 160, 160, 128, 128, 140, 140, 160, 160, 192, 192, 224, 224, 128, 128, 160, 160, 192, 192, 224, 224, 254, 254, 160, 160, 192, 192, 224, 224, 254, 254, 254, 254};
    private static final byte[][] dU = new byte[][]{{3, 4}, {3, 3}, {4, 4}, {3, 3}, {3, 3}, {3, 3}, {4, 4}, {4, 4}, {4, 4}, {5, 4}, {5, 4}};
    private static final byte[] dV = new byte[]{4, 4, 5, 4, 4, 4, 5, 5, 5, 6, 7};
    private Image[] puyoGraphics = new Image[28];
    private Image loadBg;
    private static final String[] characterGUI = new String[]{"tp_amt", "tp_kob", "tp_krk", "tp_ker", "tp_rdl", "tp_rfn", "tp_trt", "tp_akr", "tp_frk", "tp_arr", "tp_ppi", "tp_ppi2", "tp_frk2"};
    private static final String[] puyoDifficulty = new String[]{"drop3ez", "drop4ez", "", "drop3", "drop4", "drop5", "drop3f", "drop4f", "drop5f"};
    private static final String[][] tutorialMenuGUI = new String[][]{{"tu0", "tu1", "tu2", "tu3_e", "tu4", "tu5", "tu6", "tu7", "tut"}, {"tu0", "tu1", "tu2", "tu3_f", "tu4_f", "tu5_f", "tu6", "tu7", "tut"}, {"tu0", "tu1", "tu2", "tu3_i", "tu4_i", "tu5_i", "tu6", "tu7", "tut"}, {"tu0", "tu1", "tu2", "tu3_g", "tu4_g", "tu5_g", "tu6", "tu7", "tut"}, {"tu0", "tu1", "tu2", "tu3_s", "tu4_s", "tu5_s", "tu6", "tu7", "tut"}};
    private static final String[] puyoMainBackgroundGUI = new String[]{"bg1", "bg_fev", "top", "fev", "ttlbg", "bg0"};
    private static final String[] menuTextSpriteGUI1 = new String[]{"ttlz0.png"};
    private static final String[] menuTextSpriteGUI2 = new String[]{"ttlz1.png"};
    private static final String[] puyoMainSpriteGUI = new String[]{"puyofever_s_e.png", "puyofever_s_f.png", "puyofever_s_i.png", "puyofever_s_g.png", "puyofever_s_s.png"};
    private static final String[] puyoTitleLogo = new String[]{"logo_e.png", "logo_e.png", "logo_e.png", "logo_e.png", "logo_e.png"};
    private static final String[] openingBackground = new String[]{"op_bg_e.png", "op_bg_e.png", "op_bg_e.png", "op_bg_e.png", "op_bg_e.png"};
    private static final String[] ingameTextSpriteGUI = new String[]{"scr_e.png", "scr_f.png", "scr_i.png", "scr_g.png", "scr_s.png"};
    private static final String[] endingBackground = new String[]{"ed_e.png", "ed_f.png", "ed_i.png", "ed_g.png", "ed_s.png"};
    private static byte[][] ei = new byte[][]{{2, 0, 2, 1}, {2, 0, 2, 1}, {0, 1, 2, 0, 1, 1}, {1, 0, 1, 0, 1, 0, 1, 1}, {1, 0, 1, 0, 1, 0, 1}, {0, 1, 0, 1, 0, 1, 0}, {1, 0, 1, 0}, {1, 0, 1, 1, 0, 1, 0, 1}, {1, 0, 2, 2, 0, 1, 2, 2, 0}, {1, 0, 1, 0, 1, 1, 0, 1, 0}, {1, 0, 1, 0, 1, 1, 1, 0}};
    private static byte[][] ej = new byte[][]{{0, 1, 0, 1}, {0, 2, 0, 2, 2, 0, 1, 2, 2, 2, 0, 2, 0}};
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
    private static final int[] eI = new int[]{1000, 5000, 10000, 1000, 3000, 5000, 10000, 20000, 30000, 50000, 100000};
    private static final short[] eJ = new short[]{0, 0, 1, 1, 2, 2};
    private static final short[] eK = new short[]{0, 64, 0, 64, 0, 64};
    private static final int[] eL = new int[]{0, 16, 27, 36, 42, 50, 56, 64};
    private static final byte[] eM = new byte[]{0, 3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36, 39, 42, 45, 48, 51, 54, 57, 59, 62, 65, 67, 70, 73, 75, 78, 80, 82, 85, 87, 89, 91, 94, 96, 98, 100, 102, 103, 105, 107, 108, 110, 112, 113, 114, 116, 117, 118, 119, 120, 121, 122, 123, 123, 124, 125, 125, 126, 126, 126, 126, 126, 126, 126, 126, 126, 126, 126, 125, 125, 124, 123, 123, 122, 121, 120, 119, 118, 117, 116, 114, 113, 112, 110, 108, 107, 105, 103, 102, 100, 98, 96, 94, 91, 89, 87, 85, 82, 80, 78, 75, 73, 70, 67, 65, 62, 59, 57, 54, 51, 48, 45, 42, 39, 36, 33, 30, 27, 24, 21, 18, 15, 12, 9, 6, 3, 0, -3, -6, -9, -12, -15, -18, -21, -24, -27, -30, -33, -36, -39, -42, -45, -48, -51, -54, -57, -59, -62, -65, -67, -70, -73, -75, -78, -80, -82, -85, -87, -89, -91, -94, -96, -98, -100, -102, -103, -105, -107, -108, -110, -112, -113, -114, -116, -117, -118, -119, -120, -121, -122, -123, -123, -124, -125, -125, -126, -126, -126, -126, -126, -126, -126, -126, -126, -126, -126, -125, -125, -124, -123, -123, -122, -121, -120, -119, -118, -117, -116, -114, -113, -112, -110, -108, -107, -105, -103, -102, -100, -98, -96, -94, -91, -89, -87, -85, -82, -80, -78, -75, -73, -70, -67, -65, -62, -59, -57, -54, -51, -48, -45, -42, -39, -36, -33, -30, -27, -24, -21, -18, -15, -12, -9, -6, -3, 0};

    public a(Puyo var1) {
        this.et = var1;

        try {
            this.f = Image.createImage("/rtl_logo.png");
            this.splashRGBw[0] = this.f.getWidth();
            this.splashRGBh[0] = this.f.getHeight();
            this.splashRGB[0] = new int[this.splashRGBw[0] * this.splashRGBh[0]];
            this.f.getRGB(this.splashRGB[0], 0, this.splashRGBw[0], 0, 0, this.splashRGBw[0], this.splashRGBh[0]);
            this.f = null;
        } catch (Exception var4) {
        }

        try {
            this.g = Image.createImage("/sega_sonic_logo.png");
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
			this.E = 46;
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
            this.puyoFever(characterGUI[this.characterBase[0]] + ".png", 25);
        }

        if (this.br > 0) {
            this.cr[1] = this.singlePuyoPopBase + 1;
            this.characterBase[1] = this.c(1, this.cr[1]);
            if (this.dm) {
                this.puyoFever(characterGUI[this.characterBase[1]] + ".png", 26);
                byte var1;
                if (this.singlePuyoPopBase == 2) {
                    var1 = 11;
                } else if (this.singlePuyoPopBase == 8) {
                    var1 = 12;
                } else {
                    var1 = 7;
                }

                this.puyoFever(characterGUI[var1] + ".png", 27);
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
        this.setSoftkeyText("Resume", "End");
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
                --this.singlePuyoPopBase;
                if (this.singlePuyoPopBase < 0) {
                    this.singlePuyoPopBase = 2;
                }
            } else if ((this.s & 4) != 0) {
                ++this.singlePuyoPopBase;
                if (this.singlePuyoPopBase > 2) {
                    this.singlePuyoPopBase = 0;
                }
            } else if ((this.s & 16) != 0) {
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
                this.a(puyoDifficulty[this.bo[0] - 3 + this.aw * 3] + ".dat", this.es);

                for(var1 = 0; var1 < 2; ++var1) {
                    this.b(0);
                }

                this.m(0);
            }
            break;
        case 2:
            this.ah += this.C;
            if (this.ah >= 1200) {
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
                this.setSoftkeyText("Pause", "");
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
                    this.setSoftkeyText("Retry", "End");
                    this.Q = true;
                } else if (this.winCondition[1]) {
                    this.a(10);
                    this.az[0] = 16;
                    this.az[1] = 9;
                    this.setSoftkeyText("Next", "");
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

                    this.z.vibrate(0);
                }

                if ((this.s & 32) != 0) {
                    this.g();
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
                    this.setSoftkeyText("Retry", "End");
                } else {
                    this.setSoftkeyText("Pause", "");
                }

                this.j();
            } else if ((this.s & 64) != 0) {
                this.ag = false;
                this.F = 1;
                this.j();
            }
            break;
        case 6:
            if ((this.s & 32) != 0 || (this.s & 16) != 0) {
                this.i();
                if (this.aw == 0) {
                    if (this.singlePuyoPopBase == 2) {
                        this.F = 3;
                    } else {
                        this.F = 8;
                        ++this.singlePuyoPopBase;
                    }
                } else if (this.aw == 1) {
                    if (this.singlePuyoPopBase == 10) {
                        this.F = 3;
                    } else {
                        this.F = 8;
                        ++this.singlePuyoPopBase;
                    }
                }

                this.winCondition[1] = false;
                this.az[1] = 0;
                if (this.aw != 2) {
                    this.bI += this.cd;
                }
            }
            break;
        case 7:
            if ((this.s & 32) != 0) {
                this.i();
                ++this.bH;
                this.F = 2;
            } else if ((this.s & 64) != 0) {
                this.i();
                if (this.aw != 2) {
                    this.bI += this.cd;
                }

                this.G = 8;
                this.optionMenuBase2 = 0;
            }
            break;
        case 8:
            this.optionMenuBase2 += this.C;
            if (this.optionMenuBase2 >= 200) {
                this.setSoftkeyText("Next", "");
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
                if (this.dk != null) {
                    this.dk.close();
                    this.dk = null;
                }

                InputStream var2 = Runtime.getRuntime().getClass().getResourceAsStream(this.bgmSound[var1]);

                try {
                    this.dk = Manager.createPlayer(var2, "audio/midi");
                } catch (Exception var7) {
                    var7.printStackTrace();
                }

                try {
                    this.dk.realize();
                } catch (Exception var6) {
                    var6.printStackTrace();
                }

                if (var1 != 0 && var1 != 10 && var1 != 11) {
                    this.dk.setLoopCount(-1);
                }
            }

            try {
                this.dk.setMediaTime(0L);
            } catch (Exception var5) {
                var5.printStackTrace();
            }

            ((VolumeControl)this.dk.getControl("VolumeControl")).setLevel(this.b);

            try {
                this.dk.start();
            } catch (MediaException var4) {
                var4.printStackTrace();
            }

            this.h = var1;
        }

    }

    private void i() {
        try {
            if (this.dk != null) {
                this.dk.stop();
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
        this.puyoFever("ttlbg.png", 7);
    }

    private void m() {
        this.menu = true;

        for(int var1 = 0; var1 < 9; ++var1) {
            this.puyoGraphics[var1 + 16] = null;
        }

        this.puyoGraphics[7] = null;
        this.puyoFever(openingBackground[this.puyoMainGUI], 7);
    }

    private void n() {
        this.menu = true;

        for(int var1 = 0; var1 < 9; ++var1) {
            this.puyoGraphics[var1 + 16] = null;
        }

        this.puyoGraphics[7] = null;
        this.puyoFever(endingBackground[this.puyoMainGUI], 7);
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

            for(int var2 = 0; var2 < puyoMainBackgroundGUI.length; ++var2) {
                var1.puyoFever(puyoMainBackgroundGUI[var2] + ".png", var2 + 3);
            }

            ++this.dx;
            this.e = 4;
            this.repaint();
            this.serviceRepaints();
            if (!this.dw) {
                this.puyoFever("rg_L2.png", 0);
                this.puyoFever("by_L2.png", 1);
                this.puyoFever("pj_L2.png", 2);
                this.dw = true;
            }

            this.e = 6;
            this.repaint();
            this.serviceRepaints();
            this.e = 8;
            this.repaint();
            this.serviceRepaints();
            if (this.displayWidth <= 240 && this.displayHeight <= 260) {
                this.E = 45;
			} else if (this.gameError) {
                this.E = 46;
			} else {
                this.E = 44;
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
        this.puyoFever(puyoTitleLogo[this.puyoMainGUI], 11);
        this.puyoFever(menuTextSpriteGUI1[this.puyoMainGUI], 13);
        this.puyoFever(menuTextSpriteGUI2[this.puyoMainGUI], 14);
        this.puyoFever(puyoMainSpriteGUI[this.puyoMainGUI], 10);
        this.puyoFever(ingameTextSpriteGUI[this.puyoMainGUI], 12);
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
                        this.tutorialBase1 = 0;
                        this.E = 4;
                        this.menu = true;
                        this.optionMenuBase1 = -1;
                        this.setSoftkeyText("", "Back");
                        this.l();
                        this.puyoGraphics[7] = null;
                        this.puyoFever("menubg2.png", 7);
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
                if (this.tutorialBase1 >= 10) {
                    this.tutorialBase1 = 8;
                    this.E = 4;
                    this.menu = true;
                    this.optionMenuBase1 = -1;
                    this.setSoftkeyText("", "Back");
                    this.l();
                    this.puyoGraphics[7] = null;
                    this.puyoFever("menubg2.png", 7);
                    return;
                }

                this.tutorialBase2 = 0;
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
        } catch (Exception var12) {
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
            this.leftSoftkeyImage = Image.createImage("/soft_left.png");
            this.rightSoftkeyImage = Image.createImage("/soft_right.png");
            this.loadBg = Image.createImage("/loadbg.png");
            this.saveIcon = Image.createImage("/saveicon.png");
        } catch (Exception var) {
			this.gameError = true;
        }

        while(true) {
            var1.a();
            if ((var1.s & 32) != 0 || (var1.s & 16) != 0) {
                var1.eA += 2000L;
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
                            this.splashRGB = (int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])((int[][])null)))))))))))))))))))))))))))))))));
                            System.gc();
                            this.dy = 0;
                            this.optionMenuBase2 = 0;
                            this.menu = false;
                            this.dz = false;
                            this.dA = 0;
                            this.i();
                            this.setSoftkeyText("Start", "Exit");
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
                                        var3.a(puyoDifficulty[var3.bo[0] - 3 + var3.aw * 3] + ".dat", var3.es);
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
							
                            this.setSoftkeyText("Skip", "");
                            this.dl = ej[this.aw][0];
                            if (this.aw == 0) {
                                this.singlePuyoPopManzaiBase = this.runrunCourseEndingString;
                            } else {
                                this.singlePuyoPopManzaiBase = this.wakuwakuCourseEndingString;
                                this.puyoFever(characterGUI[11] + ".png", 26);
                            }

                            this.dK = 1;
                            this.s();
                            this.bY[0] = this.bY[1] = false;
                            break;
                        case 4:
                            this.menu = false;
                            this.a(1);
                            if (this.mainMenu) {
                                this.setSoftkeyText("♪ ON", "Back");
                            } else {
                                this.setSoftkeyText("♪ OFF", "Back");
                            }

                            this.mainMenuBase = -1;
                            this.puyoGraphics[7] = null;
                            this.puyoFever("menubg1.png", 7);
                            break;
                        case 5:
                            this.setSoftkeyText("Next", "Back");

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
                                this.setSoftkeyText("OK", "Back");
                            } else {
                                this.setSoftkeyText("", "Back");
                            }

                            this.aj = 0;
                            break;
                        case 7:
                            this.ds = -1;
                            this.a(2);
                            this.setSoftkeyText("Skip", "");
                            this.m();
                            this.eD = 0;
                            this.eF = 0;
                            this.eC = 0;
                            this.eB = false;
                            if (this.aw == 0) {
                                this.singlePuyoPopManzaiBase = this.runrunCourseOpeningString;
                            } else {
                                this.singlePuyoPopManzaiBase = this.wakuwakuCourseOpeningString;
                            }

                            this.c();
                            break;
                        case 8:
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

                            this.setSoftkeyText("Skip", "");
                            this.dm = true;
                            this.b();
                            this.bY[0] = false;
                            this.bY[1] = false;
                            if (this.aw == 0) {
                                this.singlePuyoPopManzaiBase = this.runrunCourseManzaiString[this.singlePuyoPopBase];
                            } else {
                                this.singlePuyoPopManzaiBase = this.wakuwakuCourseManzaiString[this.singlePuyoPopBase - 3];
                            }

                            this.dK = 0;
                            this.optionMenuBase2 = 0;
                            break;
                        case 9:
                            this.bP = this.bE[0] + 1;
                            this.bJ = this.bI / 1000;
                            if (this.aw == 0) {
                                this.bL = this.singlePuyoPopBase;
                            } else {
                                this.bL = (byte)(this.singlePuyoPopBase - 3);
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
                            this.setSoftkeyText("Next", "");
                            this.puyoGraphics[7] = null;
                            this.puyoFever("rankbg.png", 7);
                            break;
                        case 10:
                            this.m();
                            this.cg = -1;
                            this.setSoftkeyText("", "Back");
                            this.puyoGraphics[7] = null;
                            this.puyoFever("rankbg.png", 7);
                            break;
                        case 11:
                            this.setSoftkeyText("Next", "");
                            this.puyoGraphics[7] = null;
                            this.puyoFever("rankbg.png", 7);
                            break;
                        case 12:
                            this.setSoftkeyText("Next", "");
                            this.n();
                            this.dD = 0;
                            this.optionMenuBase2 = 0;
                            break;
                        case 13:
                            this.dx = 0;
                        case 14:
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
                        } catch (InterruptedException var9) {
                            var9.printStackTrace();
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

                    label678:
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
                            break label678;
                        case 1:
                            if (this.mainMenu && !this.dJ) {
                                this.dJ = true;
                                this.a(0);
                            }

                            if ((this.s & 16) == 0 && (this.s & 32) == 0) {
                                if ((this.s & 64) != 0) {
                                    this.et.a();
                                }
                            } else {
                                this.dA = 0;
                                this.dz = false;
                                this.i();
                                ++this.dy;
                                this.optionMenuBase2 = 0;
                            }

                            this.dA += this.C;
                            if (this.dA >= 30000) {
                                this.dA = 0;
                                ++this.dB;
                                if (this.dB >= ew.length) {
                                    this.dB = 0;
                                }

                                this.dy = 2;
                                this.optionMenuBase2 = 0;
                            }
                            break label678;
                        case 2:
                            this.optionMenuBase2 += this.C;
                            if (this.optionMenuBase2 >= 200) {
                                this.dA = 0;
                                this.dz = false;
                                this.F = 4;
                            }
                            break label678;
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
                                this.dl = ej[this.aw][0];
                            }
                            break label678;
                        case 1:
                            if (!this.a(this.singlePuyoPopManzaiBase) && (this.s & 32) == 0) {
                                this.dl = ej[this.aw][this.eC];
                            } else {
                                if (this.aw == 1) {
                                    this.F = 12;
                                } else {
                                    this.F = 9;
                                }

                                this.k();
                            }
                        default:
                            break label678;
                        }
                    case 4:
                        var1 = this;
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
                            } else if ((this.s & 16) != 0) {
                                switch(this.J) {
                                case 0:
                                    this.puyoGraphics[7] = null;
                                    this.puyoFever("menubg3.png", 7);
                                    this.mainMenuBase = 0;
                                    this.setSoftkeyText("", "Back");
                                    break label678;
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
                                    break label678;
                                case 2:
                                    this.puyoGraphics[7] = null;
                                    this.puyoFever("menubg2.png", 7);
                                    this.mainMenuBase = 0;
                                    this.setSoftkeyText("", "Back");
                                }
                            } else if ((this.s & 64) != 0) {
                                this.F = 1;
                            } else if ((this.s & 32) != 0 && this.mainMenu) {
                                this.setSoftkeyText("♪ OFF", "Back");
                                this.mainMenu = false;
                                this.u();
                                this.i();
                            } else if ((this.s & 32) != 0 && !this.mainMenu) {
                                this.setSoftkeyText("♪ ON", "Back");
                                this.mainMenu = true;
                                this.u();
                                this.a(1);
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
                                        break label678;
                                    case 1:
                                        this.soundOptionMenu = 0;
                                        this.setSoftkeyText("Change", "Back");
                                        break label678;
                                    case 2:
                                        this.optionMenuBase1 = 10;
                                        this.menu = true;
                                        this.optionMenuBase2 = 0;
                                        break label678;
                                    case 3:
                                        this.aboutOptionMenu = 0;
                                        this.setSoftkeyText("Next", "Back");
                                        break label678;
                                    case 4:
                                        this.puyoGraphics[7] = null;
                                        this.puyoFever("menubg1.png", 7);
                                        this.mainMenuBase = -1;
                                        if (this.mainMenu) {
                                            this.setSoftkeyText("♪ ON", "Back");
                                        } else {
                                            this.setSoftkeyText("♪ OFF", "Back");
                                        }
                                    }
                                } else if ((this.s & 64) != 0) {
                                    this.puyoGraphics[7] = null;
                                    this.puyoFever("menubg1.png", 7);
                                    this.mainMenuBase = -1;
                                    if (this.mainMenu) {
                                        this.setSoftkeyText("♪ ON", "Back");
                                    } else {
                                        this.setSoftkeyText("♪ OFF", "Back");
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
                                        this.setSoftkeyText("", "Back");
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
                            } else if (this.aboutOptionMenu != -1) {
                                if ((this.s & 64) != 0) {
                                    --this.aboutOptionMenu;
                                    if (this.aboutOptionMenu < 0) {
                                        this.aboutOptionMenu = -1;
                                        this.setSoftkeyText("", "Back");
                                    }
                                } else {
                                    if ((this.s & 16) == 0 && (this.s & 32) == 0) {
                                        break;
                                    }

                                    ++this.aboutOptionMenu;
                                    if (this.aboutOptionMenu > this.aboutString.length - 1) {
                                        this.aboutOptionMenu = -1;
                                        this.setSoftkeyText("", "Back");
                                    }
                                }
                            } else if (this.N != -1) {
                                this.r();
                                this.menu = false;
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
                                    break label678;
                                case 1:
                                    this.optionMenuBase1 = 7;
                                    this.aw = 1;
                                    this.br = 2;
                                    this.singlePuyoPopBase = 3;
                                }
                            } else if ((this.s & 64) != 0) {
                                this.puyoGraphics[7] = null;
                                this.puyoFever("menubg1.png", 7);
                                this.mainMenuBase = -1;
                                if (this.mainMenu) {
                                    this.setSoftkeyText("♪ ON", "Back");
                                } else {
                                    this.setSoftkeyText("♪ OFF", "Back");
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
                            this.F = 8;
                        }
                        break;
                    case 8:
                        switch(this.dK) {
                        case 0:
                            this.optionMenuBase2 += this.C;
                            if (this.optionMenuBase2 >= 200) {
                                ++this.dK;
                                this.s();
                                this.dl = ei[this.singlePuyoPopBase][0];
                            }
                            break label678;
                        case 1:
                            if (!this.a(this.singlePuyoPopManzaiBase) && (this.s & 32) == 0) {
                                this.dl = ei[this.singlePuyoPopBase][this.eC];
                            } else {
                                this.F = 2;
                                this.h = -1;
                                this.k();
                            }
                        default:
                            break label678;
                        }
                    case 9:
                        if ((this.s & 16) != 0 || (this.s & 32) != 0) {
                            this.F = 11;
                        }
                        break;
                    case 10:
                        if ((this.s & 2) != 0) {
                            --this.aw;
                            if (this.aw < 0) {
                                this.aw = 2;
                            }
                        } else if ((this.s & 8) != 0) {
                            ++this.aw;
                            if (this.aw > 2) {
                                this.aw = 0;
                            }
                        } else if ((this.s & 64) != 0) {
                            this.setSoftkeyText("", "Back");
                            this.E = 4;
                            this.menu = true;
                            this.optionMenuBase1 = -1;
                            this.l();
                            this.puyoGraphics[7] = null;
                            this.puyoFever("menubg2.png", 7);
                        }
                        break;
                    case 11:
                        if ((this.s & 16) != 0 || (this.s & 32) != 0) {
                            this.F = 1;
                        }
                        break;
                    case 12:
                        switch(this.dD) {
                        case 0:
                            this.optionMenuBase2 += this.C;
                            if (this.optionMenuBase2 >= 200) {
                                ++this.dD;
                            }
                            break label678;
                        case 1:
                            if ((this.s & 16) != 0 || (this.s & 32) != 0) {
                                ++this.dD;
                                this.optionMenuBase2 = 0;
                            }
                            break label678;
                        case 2:
                            this.optionMenuBase2 += this.C;
                            if (this.optionMenuBase2 >= 200) {
                                this.m();
                                this.F = 9;
                            }
                        default:
                            break label678;
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
                                this.setSoftkeyText("连接", "End");
                            }
                            break label678;
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
                            break label678;
                        }
                    case 16:
                        this.F = 1;
                        break;
                    case 17:
                        if (this.r() == -1) {
                            if (this.displayWidth <= 240 && this.displayHeight <= 260) {
                                this.E = 45;
                            } else if (this.gameError) {
                                this.E = 46;
                            } else {
                                this.E = 44;
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
            } catch (InterruptedException var10) {
                var10.printStackTrace();
            }

            var1.repaint();
            var1.serviceRepaints();
        }
    }

    private void b(Graphics var1) {
        this.c(var1);
        if (this.puyoGraphics[7] != null) {
            var1.drawImage(this.puyoGraphics[7], this.hDW, this.hDH, 3);
        }

    }

    private void c(Graphics var1) {
        var1.setColor(0);
        var1.fillRect(0, 0, this.displayWidth, this.displayHeight);
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
                        this.eB = true;
                        this.k();
                    }
                }
            }
        }

        if ((this.s & 16) != 0) {
            if (!this.eB) {
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
            var1.setColor(16639461);
            var1.fillRect(0, 0, this.displayWidth, this.displayHeight);
        }

        int var2;
        for(var2 = 0; var2 < 2; ++var2) {
            if (this.aa[var2]) {
                var1.setColor(11622577);
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
                var1.setColor(0);
                var1.drawString("", this.hDW, this.displayHeight, 33);
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
            label614:
            switch(this.E) {
            case 1:
                switch(this.dy) {
                case 0:
                case 2:
                    this.c(var1);
                    break label614;
                case 1:
                    this.b(var1);
                    if (this.puyoGraphics[11] != null) {
                        var1.drawImage(this.puyoGraphics[11], this.hDW, this.menuBaseC + 10, 17);
                    }

                    short var41 = 188;
                    if (this.bs) {
                        var1.drawRegion(this.puyoGraphics[13], 0, 124, 160, 21, 0, this.hDW, this.menuBaseC + var41, 17);
                    }

                    var7 = this.menuBaseC + 238;
                    var6 = this.hDW;
                    var1.drawRegion(this.puyoGraphics[14], 0, 142, 128, 18, 0, var6, var7, 17);
                default:
                    break label614;
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

                                    label762:
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
                                                    break label762;
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
                            var3.setColor(16639461);
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
                        var3.setColor(16639461);
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
                        break label614;
                    case 2:
                        var4 = 0;

                        while(true) {
                            if (var4 >= var2.br) {
                                break label614;
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
                        break label614;
                    case 5:
                        var24 = var2.hDH + 30;
                        var17 = var2.hDW;
                        var3.drawRegion(var2.puyoGraphics[10], 0, 56, 92, 31, 0, var17, var24, 3);
                        break label614;
                    case 6:
                        var2.m(var3, var2.an + 8 + dO[0] + var2.dH, var2.hDH + 30 + var2.dI);
                        if (var2.br == 2) {
                            var2.n(var3, var2.an + 8 + dO[1], var2.hDH + 30 + 4 + var2.dG);
                        }
                        break label614;
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
                    var14 = (var31 = var2.menuDescriptionString[var24]).length;
                    var15 = var25 + 130;
                    var16 = (252 - var15 - 4 - var14 * var2.au) / (var14 + 1);
                    var17 = 0;

                    while(true) {
                        if (var17 >= var31.length) {
                            break label614;
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
                        break label614;
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
                        break label614;
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
                    var1.drawImage(this.puyoGraphics[7], this.hDW, this.hDH, 3);
                }
                break;
            case 13:
            case 17:
                this.c(var1);
                var1.drawImage(this.loadBg, this.hDW, this.hDH, 3);
                break;
            case 14:
                this.a(var1, (String)null);
            case 15:
            case 16:
            case 44:
                var1.setColor(2368548);
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
                var1.drawString("?", this.hDW - 87 , this.hDH - 84, 33);
                var1.setColor(16777215);
                var1.drawString("SOUND", this.hDW - 66 , this.hDH - 84, 36);
                var1.setColor(6375051);
                var1.drawString("Do you want to", this.hDW, this.hDH + 10, 33);
                var1.drawString("enable sound?", this.hDW, this.hDH + 40, 33);
                this.setSoftkeyText("Yes", "No");
                if ((this.s & 32) != 0) {
                    this.loadedFlag = true;
                    this.mainMenu = true;
	                this.setSoftkeyText("Start", "Exit");
                    this.F = 1;
                } else if ((this.s & 64) != 0) {
                    this.loadedFlag = true;
                    this.mainMenu = false;
	                this.setSoftkeyText("Start", "Exit");
                    this.F = 1;
                }
                break;
            case 45:
                var1.setColor(2368548);
                var1.fillRect(this.hDW - this.hDW - 0, this.hDH - 130, 854, 260);
                var1.setColor(16777215);
                var1.drawString("This game is not", this.hDW, this.hDH - 63, 33);
                var1.drawString("compatible with", this.hDW, this.hDH - 33, 33);
                var1.drawString("this device lower", this.hDW, this.hDH - 3, 33);
                var1.drawString("than 240x320", this.hDW, this.hDH + 27, 33);
                var1.drawString("(QVGA) resolution.", this.hDW, this.hDH + 57, 33);
                var1.drawString("Press OK to exit.", this.hDW, this.hDH + 87, 33);
                this.setSoftkeyText("", "");
                if ((this.s & 16) != 0) {
                    this.et.a();
                }
                break;
            case 46:
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
                var1.drawString("The game cannot", this.hDW, this.hDH - 33, 33);
                var1.drawString("continue because", this.hDW, this.hDH - 3, 33);
                var1.drawString("an error occured", this.hDW, this.hDH + 27, 33);
                var1.drawString("while loading", this.hDW, this.hDH + 57, 33);
                var1.drawString("the game data.", this.hDW, this.hDH + 87, 33);
                this.setSoftkeyText("", "");
                if ((this.s & 64) != 0) {
                    this.et.a();
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
        } catch (Exception var33) {
            var33.printStackTrace();
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
			var1.drawString("Saving...", this.hDW + 72, this.hDH - 91, 40);
			var1.drawString("Saving...", this.hDW + 72, this.hDH - 89, 40);
			var1.drawString("Saving...", this.hDW + 71, this.hDH - 90, 40);
			var1.drawString("Saving...", this.hDW + 73, this.hDH - 90, 40);
			var1.drawString("Saving...", this.hDW + 73, this.hDH - 88, 40);
			var1.drawString("Saving...", this.hDW + 74, this.hDH - 88, 40);
			var1.drawString("Saving...", this.hDW + 74, this.hDH - 89, 40);
			var1.setColor(16777215);
			var1.drawString("Saving...", this.hDW + 72, this.hDH - 90, 40);
			var1.drawImage(this.saveIcon, this.hDW + 94, this.hDH - 101, 3);
			if (this.saveTime >= 1200) {
				this.saveFlag = false;
                this.saveTime = 0;
			}
		}

        try {
            if (this.leftSoftkeyText.length() != 0) {
                var1.drawImage(this.leftSoftkeyImage, 0, this.displayHeight, 36);
                var1.setColor(10896);
                var1.drawString(this.leftSoftkeyText, 39, this.displayHeight - 3, 33);
                var1.setColor(10896);
                var1.drawString(this.leftSoftkeyText, 39, this.displayHeight - 1, 33);
                var1.setColor(10896);
                var1.drawString(this.leftSoftkeyText, 38, this.displayHeight - 2, 33);
                var1.setColor(10896);
                var1.drawString(this.leftSoftkeyText, 40, this.displayHeight - 2, 33);
                var1.setColor(10896);
                var1.drawString(this.leftSoftkeyText, 40, this.displayHeight - 0, 33);
                var1.setColor(10896);
                var1.drawString(this.leftSoftkeyText, 41, this.displayHeight - 0, 33);
                var1.setColor(10896);
                var1.drawString(this.leftSoftkeyText, 41, this.displayHeight - 1, 33);
                var1.setColor(16777215);
                var1.drawString(this.leftSoftkeyText, 39, this.displayHeight - 2, 33);
            }

            if (this.rightSoftkeyText.length() != 0) {
                var1.drawImage(this.rightSoftkeyImage, this.displayWidth, this.displayHeight, 40);
                var1.setColor(10896);
                var1.drawString(this.rightSoftkeyText, this.displayWidth - 40, this.displayHeight - 3, 33);
                var1.setColor(10896);
                var1.drawString(this.rightSoftkeyText, this.displayWidth - 40, this.displayHeight - 1, 33);
                var1.setColor(10896);
                var1.drawString(this.rightSoftkeyText, this.displayWidth - 41, this.displayHeight - 2, 33);
                var1.setColor(10896);
                var1.drawString(this.rightSoftkeyText, this.displayWidth - 39, this.displayHeight - 2, 33);
                var1.setColor(10896);
                var1.drawString(this.rightSoftkeyText, this.displayWidth - 39, this.displayHeight - 0, 33);
                var1.setColor(10896);
                var1.drawString(this.rightSoftkeyText, this.displayWidth - 38, this.displayHeight - 0, 33);
                var1.setColor(10896);
                var1.drawString(this.rightSoftkeyText, this.displayWidth - 38, this.displayHeight - 1, 33);
                var1.setColor(16777215);
                var1.drawString(this.rightSoftkeyText, this.displayWidth - 40, this.displayHeight - 2, 33);
            }
        } catch (Exception var32) {
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

    private void t() {
        RecordStore var1;
        byte[] var2;
        int var3;
        int var5;
        int var6;
        try {
            if ((var1 = RecordStore.openRecordStore("d", false)) != null && (var2 = var1.getRecord(1)) != null) {
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
                var1 = RecordStore.openRecordStore("d", true);
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
            int var3 = 0;

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

        byte var5;
        byte var4;
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
            label1415:
            while(true) {
                while(true) {
                    a var7;
                    int var12;
                    byte var14;
                    switch(var26.cV[var6]) {
                    case 0:
                        break label1415;
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
                            break label1415;
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

                            label1380: {
                                byte[] var16 = var26.cF[var6];
                                if (var51 == 1) {
                                    var23 = 1;
                                    var21 = true;
                                    if (var16[1 + var23 * 6] != 0) {
                                        var54 = false;
                                        break label1380;
                                    }
                                } else if (var51 == 4) {
                                    var23 = 1;
                                    var21 = true;
                                    if (var16[4 + var23 * 6] != 0) {
                                        var54 = false;
                                        break label1380;
                                    }
                                }

                                var54 = true;
                            }

                            if (var54 && var11 >= 2) {
                                label1370: {
                                    label1367:
                                    switch(var26.aJ[var6]) {
                                    case 0:
                                        switch(var33 - 1) {
                                        case 0:
                                            var26.cs[var6] = var51;
                                            var26.ct[var6] = var11;
                                            var26.a(var6, var51, var11, var26.aP[var6][4]);
                                            var26.a(var6, var51, var11 - 1, var26.aP[var6][1]);
                                            break label1367;
                                        case 1:
                                            if (var25 < 2) {
                                                var54 = false;
                                                break label1370;
                                            }

                                            var26.cs[var6] = var51;
                                            var26.ct[var6] = var11;
                                            var26.a(var6, var51, var11, var26.aP[var6][4]);
                                            var26.a(var6, var51 + 1, var25, var26.aP[var6][1]);
                                            break label1367;
                                        case 2:
                                            var26.cs[var6] = var51;
                                            var26.ct[var6] = var11 - 1;
                                            var26.a(var6, var51, var11 - 1, var26.aP[var6][4]);
                                            var26.a(var6, var51, var11, var26.aP[var6][1]);
                                            break label1367;
                                        case 3:
                                            if (var12 < 2) {
                                                var54 = false;
                                                break label1370;
                                            }

                                            var26.cs[var6] = var51;
                                            var26.ct[var6] = var12;
                                            var26.a(var6, var51, var11, var26.aP[var6][4]);
                                            var26.a(var6, var51 - 1, var12, var26.aP[var6][1]);
                                        default:
                                            break label1367;
                                        }
                                    case 1:
                                        switch(var33 - 1) {
                                        case 0:
                                            if (var25 < 2) {
                                                var54 = false;
                                                break label1370;
                                            }

                                            if (var51 > 4) {
                                                var54 = false;
                                                break label1370;
                                            }

                                            var26.cs[var6] = var51;
                                            var26.ct[var6] = var11;
                                            var26.a(var6, var51, var11, var26.aP[var6][4]);
                                            var26.a(var6, var51, var11 - 1, var26.aP[var6][1]);
                                            var26.a(var6, var51 + 1, var25, var26.aP[var6][5]);
                                            break label1367;
                                        case 1:
                                            if (var25 < 2) {
                                                var54 = false;
                                                break label1370;
                                            }

                                            if (var51 > 4) {
                                                var54 = false;
                                                break label1370;
                                            }

                                            var26.cs[var6] = var51;
                                            var26.ct[var6] = var11 - 1;
                                            var26.a(var6, var51, var11 - 1, var26.aP[var6][4]);
                                            var26.a(var6, var51 + 1, var25, var26.aP[var6][1]);
                                            var26.a(var6, var51, var11, var26.aP[var6][5]);
                                            break label1367;
                                        case 2:
                                            if (var12 < 2) {
                                                var54 = false;
                                                break label1370;
                                            }

                                            if (var51 < 1) {
                                                var54 = false;
                                                break label1370;
                                            }

                                            var26.cs[var6] = var51;
                                            var26.ct[var6] = var11 - 1;
                                            var26.a(var6, var26.cs[var6], var26.ct[var6], var26.aP[var6][4]);
                                            var26.a(var6, var51, var11, var26.aP[var6][1]);
                                            var26.a(var6, var51 - 1, var12, var26.aP[var6][5]);
                                            break label1367;
                                        case 3:
                                            if (var25 < 2) {
                                                var54 = false;
                                                break label1370;
                                            }

                                            if (var51 < 1) {
                                                var54 = false;
                                                break label1370;
                                            }

                                            var26.cs[var6] = var51;
                                            var26.ct[var6] = var11;
                                            var26.a(var6, var26.cs[var6], var26.ct[var6], var26.aP[var6][4]);
                                            var26.a(var6, var51 - 1, var25, var26.aP[var6][1]);
                                            var26.a(var6, var51, var11 - 1, var26.aP[var6][5]);
                                        default:
                                            break label1367;
                                        }
                                    case 2:
                                        if (var25 < 2) {
                                            var54 = false;
                                            break label1370;
                                        }

                                        var26.cs[var6] = var51;
                                        var26.ct[var6] = var11;
                                        switch(var33 - 1) {
                                        case 0:
                                            var26.a(var6, var51, var11, var26.aP[var6][4]);
                                            var26.a(var6, var51, var11 - 1, var26.aP[var6][1]);
                                            var26.a(var6, var51 + 1, var25, var26.aP[var6][5]);
                                            var26.a(var6, var51 + 1, var25 - 1, var26.aP[var6][2]);
                                            break label1367;
                                        case 1:
                                            var26.a(var6, var51, var11, var26.aP[var6][2]);
                                            var26.a(var6, var51, var11 - 1, var26.aP[var6][4]);
                                            var26.a(var6, var51 + 1, var25, var26.aP[var6][5]);
                                            var26.a(var6, var51 + 1, var25 - 1, var26.aP[var6][1]);
                                            break label1367;
                                        case 2:
                                            var26.a(var6, var51, var11, var26.aP[var6][2]);
                                            var26.a(var6, var51, var11 - 1, var26.aP[var6][5]);
                                            var26.a(var6, var51 + 1, var25, var26.aP[var6][1]);
                                            var26.a(var6, var51 + 1, var25 - 1, var26.aP[var6][4]);
                                            break label1367;
                                        case 3:
                                            var26.a(var6, var51, var11, var26.aP[var6][1]);
                                            var26.a(var6, var51, var11 - 1, var26.aP[var6][2]);
                                            var26.a(var6, var51 + 1, var25, var26.aP[var6][4]);
                                            var26.a(var6, var51 + 1, var25 - 1, var26.aP[var6][5]);
                                        default:
                                            break label1367;
                                        }
                                    case 3:
                                        if (var25 < 2) {
                                            var54 = false;
                                            break label1370;
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

                                label1308:
                                while(true) {
                                    if (var37 >= 12) {
                                        var7.dg[var8] = true;
                                        break;
                                    }

                                    for(var34 = 0; var34 < 6; ++var34) {
                                        if (var7.cF[var8][var34 + var37 * 6] != 0) {
                                            break label1308;
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

                            label1256: {
                                var34 = var48;
                                var10000 = var26.cF[var6];
                                var23 = 2;
                                var21 = true;
                                if (var10000[2 + var23 * 6] == 0) {
                                    var10000 = var26.cF[var6];
                                    var23 = 2;
                                    var21 = true;
                                    if (var10000[3 + var23 * 6] == 0) {
                                        break label1256;
                                    }
                                }

                                var34 = var48 - 1000000;
                            }

                            label1251: {
                                var10000 = var26.cF[var6];
                                var23 = 2;
                                var21 = true;
                                if (var10000[1 + var23 * 6] == 0) {
                                    var10000 = var26.cF[var6];
                                    var23 = 2;
                                    var21 = true;
                                    if (var10000[4 + var23 * 6] == 0) {
                                        break label1251;
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
                    this.z.vibrate(1000);
                }

                if (this.cj[var1] > 30) {
                    var3 = 30;
                } else {
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
                    this.dt = false;
                    if (var2 >= this.ce[var1]) {
                        this.dt = true;
                    }
                }
            } else {
                this.az[var1] = 0;
            }

            if (this.cc[var1]) {
                if (this.aw == 2) {
                    if (!this.winCondition[var1]) {
                        var58 = this.bX;
                        var58[var1] += 3000;
                    }
                } else if (this.bX[var1] != 0) {
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
            return;
        case 15:
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

            label1461: {
                switch(var26.aB[var6]) {
                case 0:
                    var26.aM[var6] = 0;
                    var26.aY[var6] = 2;
                    var26.aZ[var6] = 1;
                    short var42;
                    if (var26.aw == 2) {
                        var42 = dT[var26.cE[var6]];
                    } else {
                        var42 = dS[var26.cE[var6]];
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
                    break label1461;
                }

                label1466: {
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
                        break label1466;
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
                        break label1466;
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
                            break label1466;
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
                            var10003 = var26.aY[var6]--;
                            var26.f(var6);
                        }
                        break;
                    case 4:
                        if (!var26.a(var6, var26.aY[var6] + 1, var26.aZ[var6])) {
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
            var1.setColor(11622577);
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
