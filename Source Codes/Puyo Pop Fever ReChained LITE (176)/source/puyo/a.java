package puyo;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.Random;
import javax.microedition.lcdui.Canvas;
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
    private boolean b = false;
    private int c = 100;
    private String d;
    private String e;
    private Image f;
    private String[] bgmSound = new String[]{"/bgm00_title.mid", "/bgm01_menu.mid", "/bgm03_opening.mid", "/bgm04_manzai1.mid", "/bgm10_taisen1.mid", "/bgm11_taisen2.mid", "/bgm12_taisen3.mid", "/bgm13_taisen4.mid", "/bgm14_pinch.mid", "/bgm15_fever.mid", "/bgm18_clear.mid", "/bgm19_lose.mid", "/bgm05_manzai2.mid"};
    private byte h;
    private Image i;
    private int j;
    private int k;
    private int l;
    private int m;
    private byte[] n;
    public boolean a;
    private Thread o;
    private long p;
    private long q;
    private int r;
    private Random s = new Random();
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;
    private int A;
	private boolean gameError;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean[] E = new boolean[3];
    private int[] F = new int[3];
    private int[] G = new int[3];
    private int[] H = new int[3];
    private int[] I = new int[3];
    private int[] J = new int[3];
    private boolean K;
    private boolean[] L = new boolean[2];
    private boolean[] M = new boolean[2];
    private boolean[] N = new boolean[2];
    private boolean[] O = new boolean[2];
    private boolean[] P = new boolean[2];
    private boolean[] Q = new boolean[2];
    private boolean R;
    private boolean S;
    private boolean T;
    private int U;
    private Font V;
    private int W;
    private int X;
    private int Y;
    private int Z;
    private int aa;
    private int ab;
    private int ac;
    private int ad;
    private int ae;
    private int af;
    private int ag;
    private byte ah;
    private byte ai;
    private byte aj;
    private int[] ak = new int[2];
    private int[] al = new int[2];
    private int[] am = new int[2];
    private int[] an = new int[2];
    private int[] ao = new int[2];
    private int[] ap = new int[2];
    private int[] aq = new int[2];
    private int[] ar = new int[2];
    private int[] as = new int[2];
    private byte[] at = new byte[2];
    private byte[] au = new byte[2];
    private byte[][] av = new byte[2][2];
    private byte[] aw = new byte[2];
    private int[] ax = new int[2];
    private int[] ay = new int[2];
    private byte[][] az = new byte[2][9];
    private byte[][] aA = new byte[2][9];
    private byte[][] aB = new byte[2][9];
    private byte[][][] aC = new byte[2][2][9];
    private int[] aD = new int[2];
    private int[] aE = new int[2];
    private int[][] aF = new int[2][2];
    private int[][] aG = new int[2][2];
    private int[] aH = new int[2];
    private int[] aI = new int[2];
    private int[] aJ = new int[2];
    private int[] aK = new int[2];
    private byte[] aL = new byte[2];
    private byte[][] aM = new byte[2][84];
    private byte[][] aN = new byte[2][84];
    private byte[][] aO = new byte[2][84];
    private byte[][] aP = new byte[2][84];
    private int[] aQ = new int[2];
    private int[][] aR = new int[2][84];
    private boolean[] aS = new boolean[2];
    private boolean[][] aT = new boolean[2][84];
    private int[] aU = new int[2];
    private byte[][] aV = new byte[2][84];
    private byte[][] aW = new byte[2][84];
    private byte[][] aX = new byte[2][84];
    private int[][] aY = new int[2][6];
    private byte[] aZ = new byte[2];
    private int[][] ba = new int[2][84];
    private boolean[][] bb = new boolean[2][84];
    private int bc;
    private boolean bd;
    private int be;
    private int[] bf = new int[2];
    private boolean[][] bg = new boolean[2][5];
    private int[] bh = new int[2];
    private int[] bi = new int[2];
    private int[] bj = new int[2];
    private int[] bk = new int[2];
    private int[] bl = new int[2];
    private int[] bm = new int[2];
    private int[] bn = new int[2];
    private int[] bo = new int[2];
    private int[] bp = new int[2];
    private int bq;
    private int br;
    private int bs;
    private int bt;
    private int bu;
    private int bv;
    private byte bw;
    private int bx;
    private int by;
    private int bz;
    private int bA;
    private int bB;
    private int bC;
    private byte bD;
    private int bE;
    private int[] bF = new int[2];
    private int[] bG = new int[2];
    private int[] bH = new int[2];
    private int[] bI = new int[2];
    private boolean[] bJ = new boolean[2];
    private boolean[] bK = new boolean[2];
    private boolean[] bL = new boolean[2];
    private int[] bM = new int[2];
    private boolean[] bN = new boolean[2];
    private int bO;
    private int[] bP = new int[2];
    private int[][][] bQ = new int[3][5][3];
    private byte bR;
    private int[] bS = new int[2];
    private int[] bT = new int[2];
    private int[] bU = new int[2];
    private int[] bV = new int[2];
    private int[] bW = new int[2];
    private int[] bX = new int[2];
    private int[][] bY = new int[2][3];
    private int[][] bZ = new int[2][6];
    private int ca;
    private int[] cb = new int[2];
    private int[] cc = new int[2];
    private int[] cd = new int[2];
    private int[] ce = new int[2];
    private int[] cf = new int[2];
    private int[] cg = new int[2];
    private int[] ch = new int[2];
    private int[] ci = new int[2];
    private int[] cj = new int[2];
    private int[] ck = new int[2];
    private int[] cl = new int[2];
    private int[] cm = new int[2];
    private int[] cn = new int[2];
    private int[] co = new int[2];
    private byte[] cp = new byte[2];
    private byte[][] cq = new byte[2][84];
    private byte[][] cr = new byte[2][84];
    private boolean[] cs = new boolean[2];
    private boolean[] ct = new boolean[84];
    private byte[] cu = new byte[84];
    private byte[] cv = new byte[2];
    private byte[] cw = new byte[2];
    private int[] cx = new int[2];
    private int[] cy = new int[2];
    private byte[] cz = new byte[2];
    private byte[] cA = new byte[2];
    private byte[] cB = new byte[2];
    private byte[] cC = new byte[2];
    private boolean[] cD = new boolean[2];
    private byte[] cE = new byte[2];
    private int[] cF = new int[2];
    private byte[] cG = new byte[2];
    private boolean[] cH = new boolean[2];
    private boolean cI;
    private boolean cJ;
    private boolean[][] cK = new boolean[2][2];
    private int[][] cL = new int[2][2];
    private int[][] cM = new int[2][17];
    private boolean[][] cN = new boolean[2][17];
    private byte[][] cO = new byte[2][17];
    private byte[][] cP = new byte[2][17];
    private byte[][] cQ = new byte[2][17];
    private boolean[] cR = new boolean[2];
    private byte[] cS = new byte[2];
    private byte[][] cT = new byte[2][6];
    private boolean[] cU = new boolean[2];
    private Player cV;
    private byte cW;
    private boolean cX;
    private byte[] cY = new byte[2];
    private byte[][] cZ = new byte[2][4];
    private byte[][] da = new byte[2][4];
    private byte[] db = new byte[2];
    private int dc;
    private byte dd;
    private boolean de;
    private int[] df = new int[2];
    private byte[] dg = new byte[2];
    private boolean dh;
    private boolean di;
    private byte dj;
    private byte dk;
    private boolean dl;
    private int dm;
    private byte dn;
    private int uwu;
    private int dp;
    private boolean dq;
    private int dr;
    private int ds;
    private byte dt;
    private byte du;
    private boolean dv;
    private byte dw;
    private int dx;
    private static final byte[] dy = new byte[]{0, 3, 2, 5, 1, 4};
    private static final short[] dz = new short[]{10, 100};
    private static final byte[][] dA = new byte[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static final byte[] dB = new byte[]{1, 2, 0, 3};
    private static final byte[][] dC = new byte[][]{{1, 0}, {2, 0}, {2, 1}, {1, 1}};
    private static final short[] dD = new short[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 128};
    private static final short[] dE = new short[]{8, 8, 9, 9, 10, 10, 12, 12, 16, 16, 10, 10, 11, 11, 12, 12, 14, 14, 32, 32, 16, 16, 32, 32, 52, 52, 64, 64, 96, 96, 32, 32, 48, 48, 52, 52, 64, 64, 96, 96, 48, 48, 64, 64, 96, 96, 128, 128, 128, 128, 64, 64, 96, 96, 128, 128, 128, 128, 142, 142, 96, 96, 128, 128, 128, 128, 128, 128, 160, 160, 128, 128, 140, 140, 160, 160, 192, 192, 224, 224, 128, 128, 160, 160, 192, 192, 224, 224, 254, 254, 160, 160, 192, 192, 224, 224, 254, 254, 254, 254};
    private static final byte[][] dF = new byte[][]{{3, 4}, {3, 3}, {4, 4}, {3, 3}, {3, 3}, {3, 3}, {4, 4}, {4, 4}, {4, 4}, {5, 4}, {5, 4}};
    private static final byte[] dG = new byte[]{4, 4, 5, 4, 4, 4, 5, 5, 5, 6, 7};
    private Image[] puyoGraphics = new Image[28];
    private static final String[] tutorialMenuGUI = new String[]{"tu0", "tu1", "tu2", "tu3", "tu4", "tu5", "tu6", "tu7", "tut"};
    private static final String[] puyoMainGUI = new String[]{"bg1", "bg_fev", "top", "fev", "puyofever_s", "logo", "ttlbg", "ttlz0", "ttlz1", "scr", "bg0", "op_bg"};
    private static final String[] charGUI = new String[]{"tp_amt", "tp_kob", "tp_krk", "tp_ker", "tp_rdl", "tp_rfn", "tp_trt", "tp_akr", "tp_frk", "tp_arr", "tp_ppi", "tp_ppi2", "tp_frk2"};
    private static final String[] puyoDifficulty = new String[]{"drop3ez", "drop4ez", "", "drop3", "drop4", "drop5", "drop3f", "drop4f", "drop5f"};
    private static final byte[] dM = new byte[]{1, 2, 3, 4, 5, 6, 8};
    private static final byte[] dN = new byte[]{2, 4, 8, 16, 16, 16};
    private static final short[][] dO = new short[][]{{24, 32}, {24, 32}, {16, 32}, {16, 32}, {12, 32}, {12, 32}, {8, 32}, {8, 32}, {6, 32}, {6, 32}, {4, 32}, {4, 32}, {3, 32}, {2, 32}, {2, 32}, {2, 32}, {3, 64}, {1, 32}, {1, 32}, {1, 32}, {3, 128}, {3, 128}, {1, 64}, {1, 64}, {3, 256}, {3, 256}, {1, 128}};
    private static final short[] dP = new short[]{720, 360, 180, 30, 6, 1, 0};
    private static final short[][][] dQ = new short[][][]{{{4, 4}, {12, 10}, {24, 18}, {32, 22}, {48, 30}, {96, 48}, {160, 80}, {240, 120}, {320, 160}, {400, 240}, {500, 280}, {600, 288}, {700, 342}, {800, 400}, {900, 440}, {999, 480}, {999, 520}, {999, 560}, {999, 600}, {999, 640}, {999, 680}, {999, 720}, {999, 760}, {999, 800}}, {{4, 4}, {11, 11}, {22, 20}, {30, 25}, {45, 34}, {91, 55}, {153, 92}, {230, 139}, {309, 186}, {388, 281}, {488, 329}, {588, 339}, {693, 405}, {796, 476}, {900, 526}, {999, 576}, {999, 624}, {999, 672}, {999, 720}, {999, 768}, {999, 816}, {999, 864}, {999, 912}, {999, 960}}, {{4, 4}, {11, 9}, {24, 16}, {34, 20}, {53, 27}, {110, 43}, {188, 72}, {288, 108}, {392, 144}, {500, 216}, {638, 252}, {780, 259}, {945, 308}, {999, 360}, {999, 396}, {999, 432}, {999, 468}, {999, 504}, {999, 540}, {999, 576}, {999, 612}, {999, 648}, {999, 684}, {999, 720}}, {{4, 4}, {13, 10}, {25, 18}, {33, 21}, {49, 29}, {96, 46}, {158, 76}, {235, 113}, {310, 150}, {384, 223}, {475, 259}, {564, 266}, {644, 313}, {728, 364}, {810, 398}, {890, 432}, {968, 468}, {999, 504}, {999, 540}, {999, 576}, {999, 612}, {999, 648}, {999, 684}, {999, 720}}, {{4, 3}, {13, 8}, {26, 14}, {35, 18}, {53, 24}, {106, 38}, {176, 64}, {264, 96}, {352, 128}, {440, 192}, {550, 224}, {660, 230}, {770, 274}, {880, 320}, {990, 352}, {999, 384}, {999, 416}, {999, 448}, {999, 480}, {999, 512}, {999, 544}, {999, 576}, {999, 608}, {999, 640}}, {{4, 4}, {11, 9}, {24, 17}, {33, 20}, {51, 28}, {106, 46}, {179, 76}, {274, 115}, {371, 154}, {472, 233}, {600, 273}, {732, 282}, {882, 337}, {999, 396}, {999, 438}, {999, 480}, {999, 520}, {999, 560}, {999, 600}, {999, 640}, {999, 680}, {999, 720}, {999, 760}, {999, 800}}, {{4, 4}, {13, 10}, {25, 18}, {33, 21}, {49, 29}, {96, 46}, {158, 76}, {235, 113}, {310, 150}, {384, 223}, {475, 259}, {564, 266}, {644, 313}, {728, 364}, {810, 398}, {890, 432}, {968, 468}, {999, 504}, {999, 540}, {999, 576}, {999, 612}, {999, 648}, {999, 684}, {999, 720}}, {{4, 4}, {11, 10}, {24, 18}, {33, 21}, {51, 29}, {106, 46}, {179, 76}, {274, 113}, {371, 150}, {472, 223}, {600, 259}, {732, 266}, {882, 313}, {999, 364}, {999, 398}, {999, 432}, {999, 468}, {999, 504}, {999, 540}, {999, 576}, {999, 612}, {999, 648}, {999, 684}, {999, 720}}, {{4, 4}, {13, 11}, {25, 19}, {32, 22}, {47, 29}, {91, 46}, {150, 75}, {221, 110}, {290, 145}, {356, 214}, {438, 245}, {516, 250}, {581, 290}, {652, 332}, {720, 359}, {785, 384}, {847, 416}, {888, 448}, {999, 480}, {999, 512}, {999, 544}, {999, 576}, {999, 608}, {999, 640}}, {{4, 4}, {12, 10}, {24, 18}, {33, 21}, {50, 29}, {101, 46}, {169, 76}, {254, 113}, {341, 150}, {428, 223}, {538, 259}, {648, 266}, {763, 313}, {876, 364}, {990, 398}, {999, 432}, {999, 468}, {999, 504}, {999, 540}, {999, 576}, {999, 612}, {999, 648}, {999, 684}, {999, 720}}, {{4, 5}, {11, 12}, {22, 22}, {29, 26}, {43, 36}, {86, 58}, {144, 96}, {216, 144}, {288, 192}, {360, 288}, {450, 336}, {540, 346}, {630, 410}, {720, 480}, {810, 528}, {900, 576}, {990, 624}, {999, 672}, {999, 720}, {999, 768}, {999, 816}, {999, 864}, {999, 912}, {999, 960}}};
    private static final byte[][] dR = new byte[][]{{0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 1, 0, 0, 0, 3}, {0, 0, 0, 0, 1, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 3}, {0, 0, 1, 0, 1, 0, 2, 0, 1, 0, 2, 0, 1, 0, 0, 3}, {0, 0, 0, 1, 0, 0, 0, 3, 0, 0, 0, 2, 0, 0, 0, 3}, {0, 0, 0, 1, 0, 0, 2, 0, 0, 1, 0, 0, 2, 0, 0, 3}, {0, 0, 1, 0, 0, 2, 0, 0, 0, 1, 0, 0, 1, 0, 0, 3}, {0, 0, 1, 0, 0, 2, 0, 1, 0, 0, 2, 0, 0, 1, 0, 3}, {0, 1, 0, 1, 0, 1, 0, 2, 0, 1, 0, 1, 0, 1, 0, 3}, {0, 0, 1, 0, 0, 1, 0, 2, 0, 1, 0, 1, 0, 1, 0, 3}, new byte[16], {0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 2, 0, 2, 0, 3}};
    private short[][] dS = new short[2][84];
    private static final short[][][] dT = new short[][][]{{{2, 1, 0, 0, 1, 2}, {3, 1, 0, 0, 1, 3}, {4, 2, 0, 0, 2, 4}, {6, 4, 1, 1, 4, 6}, {9, 8, 4, 4, 8, 9}, {12, 11, 9, 9, 11, 12}, {14, 13, 10, 10, 13, 14}, {17, 15, 13, 13, 15, 17}, {20, 17, 15, 15, 17, 20}, {24, 21, 18, 18, 21, 24}, {28, 24, 22, 22, 24, 28}, {32, 30, 27, 27, 30, 32}, {36, 34, 32, 32, 34, 36}, {40, 38, 36, 36, 38, 40}}, {{2, 1, 0, 0, 1, 2}, {3, 1, 0, 0, 1, 3}, {4, 3, 0, 0, 3, 4}, {5, 4, 1, 1, 4, 5}, {8, 5, 2, 2, 5, 8}, {30, 30, 20, 20, 40, 40}, {30, 30, 20, 20, 40, 40}, {30, 30, 20, 20, 40, 40}, {70, 71, 60, 61, 80, 81}, {73, 72, 63, 62, 83, 82}, {74, 75, 64, 65, 84, 85}, {110, 111, 100, 101, 120, 121}, {113, 112, 103, 102, 123, 122}, {114, 115, 104, 105, 124, 125}}, {{2, 1, 0, 0, 1, 2}, {3, 1, 0, 0, 1, 3}, {4, 2, 0, 0, 2, 4}, {5, 4, 1, 1, 4, 5}, {9, 8, 3, 3, 8, 9}, {12, 11, 5, 5, 10, 12}, {14, 12, 7, 7, 12, 14}, {17, 16, 8, 8, 16, 17}, {19, 18, 9, 9, 18, 19}, {21, 21, 10, 10, 21, 21}, {23, 23, 12, 12, 23, 23}, {25, 25, 15, 15, 25, 25}, {28, 27, 17, 17, 27, 28}, {32, 30, 20, 20, 30, 32}}, {{2, 1, 0, 0, 1, 2}, {3, 1, 0, 0, 1, 3}, {40, 2, 0, 0, 1, 100}, {42, 4, 1, 1, 2, 102}, {44, 6, 3, 3, 80, 104}, {46, 8, 5, 5, 82, 106}, {48, 10, 9, 9, 84, 108}, {50, 14, 13, 13, 86, 110}, {52, 16, 15, 15, 88, 112}, {54, 18, 17, 17, 90, 114}, {56, 19, 19, 19, 92, 116}, {58, 22, 21, 21, 94, 118}, {60, 27, 27, 27, 96, 120}, {62, 30, 30, 30, 98, 122}}, {{2, 1, 0, 0, 1, 2}, {3, 1, 0, 0, 1, 3}, {18, 6, 0, 0, 1, 2}, {20, 18, 1, 1, 2, 3}, {22, 21, 2, 2, 3, 5}, {24, 23, 3, 3, 5, 7}, {26, 25, 4, 5, 7, 9}, {28, 27, 5, 7, 9, 11}, {30, 29, 7, 9, 11, 13}, {33, 32, 10, 11, 13, 15}, {36, 34, 13, 13, 15, 17}, {40, 38, 20, 15, 17, 19}, {45, 42, 23, 20, 19, 20}, {50, 46, 26, 24, 22, 21}}, {{2, 1, 0, 0, 1, 2}, {3, 1, 0, 0, 1, 3}, {16, 2, 0, 0, 2, 16}, {21, 4, 1, 1, 4, 21}, {23, 6, 3, 3, 6, 23}, {25, 8, 5, 5, 8, 25}, {27, 21, 7, 7, 21, 27}, {30, 23, 8, 8, 23, 30}, {32, 25, 9, 9, 25, 32}, {35, 28, 10, 10, 28, 35}, {40, 30, 12, 12, 30, 40}, {45, 32, 15, 15, 32, 45}, {48, 35, 17, 17, 35, 48}, {50, 40, 20, 20, 40, 50}}, {{2, 1, 0, 0, 1, 2}, {3, 1, 0, 0, 1, 3}, {4, 2, 0, 0, 2, 4}, {5, 5, 1, 1, 5, 5}, {9, 9, 3, 3, 9, 9}, {12, 12, 9, 9, 12, 12}, {14, 14, 10, 10, 14, 14}, {17, 17, 13, 13, 17, 17}, {19, 19, 15, 15, 19, 19}, {21, 21, 17, 17, 21, 21}, {23, 23, 19, 19, 23, 23}, {30, 30, 30, 30, 30, 30}, {40, 40, 40, 40, 40, 40}, {50, 50, 50, 50, 50, 50}}, {{2, 1, 0, 0, 1, 2}, {3, 1, 0, 0, 1, 3}, {20, 2, 0, 0, 2, 20}, {24, 4, 1, 1, 4, 24}, {28, 8, 3, 3, 8, 28}, {32, 11, 9, 9, 11, 32}, {36, 13, 10, 10, 13, 36}, {40, 15, 13, 13, 15, 40}, {44, 17, 15, 15, 17, 44}, {48, 19, 17, 17, 19, 48}, {52, 21, 19, 19, 21, 52}, {56, 23, 21, 21, 23, 56}, {60, 25, 23, 23, 25, 60}, {64, 27, 25, 25, 27, 64}}, {{1, 1, 0, 0, 1, 1}, {2, 1, 0, 0, 1, 2}, {3, 2, 0, 0, 2, 3}, {4, 3, 1, 1, 3, 4}, {5, 5, 4, 4, 5, 5}, {6, 6, 6, 6, 6, 6}, {7, 7, 7, 7, 7, 7}, {8, 8, 8, 8, 8, 8}, {9, 9, 9, 9, 9, 9}, {40, 40, 10, 10, 40, 40}, {60, 60, 13, 13, 60, 60}, {80, 80, 15, 15, 80, 80}, {100, 100, 17, 17, 100, 100}, {120, 120, 20, 20, 120, 120}}, {{2, 1, 0, 0, 1, 2}, {3, 1, 0, 0, 1, 3}, {8, 2, 0, 0, 2, 8}, {10, 4, 1, 1, 4, 10}, {13, 8, 3, 3, 8, 13}, {17, 11, 9, 9, 11, 17}, {19, 13, 10, 10, 13, 19}, {21, 15, 13, 13, 15, 21}, {23, 17, 15, 15, 17, 23}, {25, 19, 17, 17, 19, 25}, {27, 21, 19, 19, 21, 27}, {30, 24, 21, 21, 24, 30}, {35, 30, 25, 25, 30, 35}, {40, 35, 30, 30, 35, 40}}, {{2, 1, 0, 0, 1, 2}, {3, 1, 0, 0, 1, 3}, {20, 2, 0, 0, 2, 20}, {24, 4, 1, 1, 4, 24}, {28, 8, 3, 3, 8, 28}, {32, 16, 9, 9, 16, 32}, {36, 24, 10, 10, 24, 36}, {40, 30, 13, 13, 30, 40}, {80, 81, 15, 15, 60, 61}, {83, 82, 17, 17, 63, 62}, {84, 85, 19, 19, 64, 65}, {120, 121, 20, 20, 100, 101}, {123, 122, 22, 22, 103, 102}, {124, 125, 24, 24, 104, 105}}};
    private byte[] dU = new byte[4992];
    private Puyo dV;
    private static final int[][][] dW = new int[][][]{{{30000, 3, 180}, {25000, 2, 144}, {20000, 2, 108}, {15000, 1, 72}, {10000, 1, 36}}, {{50000, 7, 252}, {40000, 6, 216}, {30000, 5, 180}, {20000, 4, 144}, {10000, 3, 108}}, {{500000, 12, 252}, {400000, 11, 216}, {300000, 10, 180}, {200000, 9, 144}, {100000, 8, 108}}};
    private static final byte[][] dX = new byte[][]{{2, 0, 2, 1}, {2, 0, 2, 1}, {0, 1, 2, 0, 1, 1}, {1, 0, 1, 0, 1, 0, 1, 1}, {1, 0, 1, 0, 1, 0, 1}, {0, 1, 0, 1, 0, 1, 0}, {1, 0, 1, 0}, {1, 0, 1, 1, 0, 1, 0, 1}, {1, 0, 2, 2, 0, 1, 2, 2, 0}, {1, 0, 1, 0, 1, 1, 0, 1, 0}, {1, 0, 1, 0, 1, 1, 1, 0}};
    private static final byte[][] dY = new byte[][]{{0, 1, 0, 1}, {0, 2, 0, 2, 2, 0, 1, 2, 2, 2, 0, 2, 0}};
    private String[][] runrunCourseOpeningString = new String[][]{{"Once upon a time...", "In some other world...", "There lived a young girl", "whose dream was to", "become a wonderfully", "clever magic user."}, {"Her name is Amitie,", "and she is at", "her studies again today."}};
    private String[][][] runrunCourseManzaiString = new String[][][]{{{"...And that's that.", "Any questions so far?"}, {"I think I understand."}, {"Okay, then try practicing", "with the person sitting", "next to you."}, {"I'm ready..."}}, {{"Have you kiddies", "got the knack of", "fever mode?"}, {"Yeah...? Teacher, what", "should I do if I can't", "offset well?"}, {"Anyway, Let's try it", "with a different", "partner this time."}, {"Oh, me.", "Try facing off with me."}}, {{"Teacher! I..I think I've", "got the hang of this."}, {"That's good to hear,", "young lady!"}, {"Then...", "I guess it's test time."}, {"What, a test!?"}, {"What would learning", "be without exams?"}, {"After all,", "applied knowledge", "is acquired knowledge."}}};
    private String[][] runrunCourseEndingString = new String[][]{{"Wicked! I got the", "better of you, teacher!!"}, {"Nice job! Okay then,", "your next test will be..."}, {"What!?", "There's more!?"}, {"I'll be waiting at the", "WakuWaku Course!"}};
    private String[][] wakuwakuCourseOpeningString = new String[][]{{"Hello!", "The name's Amitie!!", "I'm hitting the books", "hard to become a", "wonderful magic user.", "But today isn't", "the day for studies."}, {"Prof. Accord seems", "to have \"misplaced\" or", "should I say LOST her", "flying cane."}, {"She said she'd give", "a reward to the person", "who finds it so", "everyone is psyched.", "And of course,", "that goes for little", "old me too!"}};
    private String[][][] wakuwakuCourseManzaiString = new String[][][]{{{"Good day to you,", "Miss Amitie."}, {"Oh hi, Raffina.", "Are you going looking", "for Accord's cane, too?"}, {"Yes, most definitely."}, {"Would you like to go", "together?"}, {"What ever is your", "lowly unrefined", "mind thinking?"}, {"Un...re...fined?"}, {"Everybody knows the", "fewer rivals the", "better, right?"}, {"So you can just take", "a little nap for me!"}}, {{"Wazzup?!"}, {"Whaaaa!", "You scared the living", "heck out of me."}, {"Hey you there in the", "deathly uncool clothes!"}, {"Get real!", "Who are you", "calling uncool!"}, {"Just who are you calling", "uncool? I can't figure", "out why you're uncool."}, {"Get really real!", "Now you've ticked me", "off!!"}, {"Oh-ho-ho! We'll have", "to puyo pop to seperate", "the cool from the uncool."}}, {{"Oh, hi.", "If it isn't Rita."}, {"M-miss A-Amitie..."}, {"No way?", "You're looking too?"}, {"I-I'm sorry...", "I, I just..."}, {"You don't need to", "apologize..."}, {"W-w-well... G-go easy", "on me will you?"}, {"Y-you too...", "(Now he's got me", "stuttering)."}}, {{"Ribit-ribit!"}, {"Ahh, how icky!"}, {"Ribit-ribit!!"}, {"Wha...", "Are you angry?"}}, {{"Salutations Amitie.", "You out cane", "searching too?"}, {"You betcha, Klug.", "But where that cane", "has gotten itself off to."}, {"Well, I shouldn't tell", "you this, but..."}, {"With me being first", "in the class at magic I've", "located its whereabouts."}, {"Get real! Really?"}, {"Would you like for me", "to tell you its", "hiding place?"}, {"Would I!"}, {"Well, only if you can", "outdo me at puyo pop,", "that is!"}}, {{"FriEND!", "F-FriEND!!"}, {"Whaaaa!", "You scared the living", "heck out of me."}, {"Daddy says...", "We won't let you pass!"}, {"Daddy says...", "If you want to pass,", "you'll have to puyo pop!"}, {"Now does he?", "Well then, you're on!"}, {"F-FriEND!!", "End!! End!!"}, {"Daddy says..."}, {"Two on One is only", "fair and square!"}, {"The only thing \"square\"", "here are your heads!"}}, {{"Howdy-do! I'm Arle!", "Nice to meet you."}, {"The name's Amitie!!", "Nice meeting you."}, {"Just...", "Where am I?"}, {"Huh?"}, {"I was playing puyo like", "I always do and the next", "thing I know. I'm here."}, {"And just where is here...", "Maybe my magic failed", "and sent me off the map."}, {"Hmmm... Why do you", "try to do it again?", "Maybe you'll go back!"}, {"Good idea!! Let's get", "in a game of puyo pop", "first."}, {"Sure thing...", "Somehow I knew you", "were going to say that."}}, {{"So you made it this far,", "Amitie..."}, {"And so have you...", "Pretty climactic if you", "ask me!"}, {"Is this golden axe what", "you have been seeking?", "Or this silver axe?"}, {"Thanks, but...", "I told you, what I want", "is the flying cane!"}, {"Ha-ha-ha."}, {"Okay then missy.", "Here's your flying cane!"}, {"But you can't have it", "for nothing."}, {"Prepare to puyo pop!", "I was dying to play", "anyway!"}}};
    private String[][] wakuwakuCourseEndingString = new String[][]{{"Yes! I've got the", "flying cane!"}, {"Congratulations,", "Miss Amitie!"}, {"Oh, Ms. Accord! Here's", "your flying cane back."}, {"Thank you..."}, {"I guess I should", "give you that reward", "for your help."}, {"No,", "not really.", "You don't have to."}, {"I don't? Well if you insist.", "Then no reward it is."}, {"Really? I thought that's", "what you wanted?", "I was wrong about you."}, {"Huh? Well...", "Yeah... Uh-huh...", "But I..."}, {"Come on. It's about", "time we got back to", "school."}, {"Get really real..."}};
    private String[][][] tutorialString = new String[][][]{{{"Good morning.", "Have you got a fever", "for Puyo Pop?"}, {"Let's study", "how to play."}}, {{"Puyo fall down not", "only in twos but as", "many as four at a time."}, {"While you can rotate", "some puyo, the big", "ones change color..."}, {"and can't be turned."}}, {{"When four puyo of the", "same color connect,", "you send a nuisance..."}, {"puyo to your", "opponent."}}, {{"As puyo keep", "disappearing,..."}, {"Chains of nuisance", "puyo are sent to your", "opponent."}}, {{"Don't lose your cool if", "your opponent sends", "you nuisance puyo."}, {"You can negate your", "opponent's nuisance", "puyo with your own."}, {"This is called", "offsetting."}, {"After offsetting,", "Nuisance puyo won't", "fall. Don't give up."}}, {{"When offsetting, the", "fever mode begins..."}, {"when the fever gauge", "gets full."}}, {{"In fever mode, the", "nuisance puyo won't", "fall for a while."}}, {{"What's even better is", "that the chain puyo", "keep dropping one..."}, {"after the other.", "Pretty cool, huh?"}, {"And keep dropping", "no matter what. The", "better you do, the..."}, {"bigger the chain.", "Of course, even in the", "fever mode, you can..."}, {"still make chains or", "send nuisance puyo", "to your opponent."}}, {{"When two middle rows", "pile up, the game is", "over."}, {"And that's that.", "Have a good luck!"}}};
    private String[][] menuDescriptionString = new String[][]{{"Single Player vs. COM.", "", ""}, {"Non stop Fever!", "Big Chains or All Clear", "will add to the playtime."}, {"Here you can change", "the game settings.", ""}, {"This mode is", "unavailable.", "Coming Soon."}, {"Training course for", "beginners. (3 Stages)", ""}, {"Intermediate course for", "those who have learned", "the rules. (8 Stages)"}, {"Explanation of Puyo", "Pop Fever rules."}, {"Change the", "sound settings."}, {"View score ranking", "for each mode."}, {"About Puyo Pop Fever.", ""}};
    private String[][] aboutString = new String[][]{{"Puyo Pop Fever", "Re:Chained LITE", "Ver. 1.50 (0000)", "© SEGA", "Modded by:", "Realtimeless"}, {"Screen Resolutions:", "176x208 176x220", "Presented by:", "SEGA", "Developed by:", "SONIC TEAM"}, {"Thank you", "for playing,", "Puyo Pop Fever", "Re:Chained LITE!", "", "Modded by RTL."}, {"If you want to", "support development,", "you can get the source", "code from GitHub and", "implement some new", "features by yourself! :)"}};
    private int eh = 0;
    private static final byte[] ei = new byte[]{0, 1, 2, 0, 1, 3, 0, 1, 4};
    private int[] ej = new int[6];
    private byte ek;
    private byte el;
    private long em = 0L;
    private static final int[][] en = new int[][]{{2451112, 15790300}, {7237280, 15790300}, {15098980, 15790300}};
    private boolean eo;
    private int ep;
    private int eq;
    private int er;
    private int es;
    private String[][] et;
    private static final byte[][] eu = new byte[][]{{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    private static final int[] ev = new int[]{1000, 5000, 10000, 1000, 3000, 5000, 10000, 20000, 30000, 50000, 100000};
    private static final short[] ew = new short[]{0, 0, 1, 1, 2, 2};
    private static final short[] ex = new short[]{0, 44, 0, 44, 0, 44};
    private static final int[] ey = new int[]{0, 10, 18, 24, 28, 34, 38, 43};
    private static final byte[] ez = new byte[]{0, 3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36, 39, 42, 45, 48, 51, 54, 57, 59, 62, 65, 67, 70, 73, 75, 78, 80, 82, 85, 87, 89, 91, 94, 96, 98, 100, 102, 103, 105, 107, 108, 110, 112, 113, 114, 116, 117, 118, 119, 120, 121, 122, 123, 123, 124, 125, 125, 126, 126, 126, 126, 126, 126, 126, 126, 126, 126, 126, 125, 125, 124, 123, 123, 122, 121, 120, 119, 118, 117, 116, 114, 113, 112, 110, 108, 107, 105, 103, 102, 100, 98, 96, 94, 91, 89, 87, 85, 82, 80, 78, 75, 73, 70, 67, 65, 62, 59, 57, 54, 51, 48, 45, 42, 39, 36, 33, 30, 27, 24, 21, 18, 15, 12, 9, 6, 3, 0, -3, -6, -9, -12, -15, -18, -21, -24, -27, -30, -33, -36, -39, -42, -45, -48, -51, -54, -57, -59, -62, -65, -67, -70, -73, -75, -78, -80, -82, -85, -87, -89, -91, -94, -96, -98, -100, -102, -103, -105, -107, -108, -110, -112, -113, -114, -116, -117, -118, -119, -120, -121, -122, -123, -123, -124, -125, -125, -126, -126, -126, -126, -126, -126, -126, -126, -126, -126, -126, -125, -125, -124, -123, -123, -122, -121, -120, -119, -118, -117, -116, -114, -113, -112, -110, -108, -107, -105, -103, -102, -100, -98, -96, -94, -91, -89, -87, -85, -82, -80, -78, -75, -73, -70, -67, -65, -62, -59, -57, -54, -51, -48, -45, -42, -39, -36, -33, -30, -27, -24, -21, -18, -15, -12, -9, -6, -3, 0};

    public a(Puyo var1) {
        this.dV = var1;

        try {
            this.i = Image.createImage("/rtl_logo.png");
        } catch (Exception var4) {
        }

        try {
            this.f = Image.createImage("/sega_sonic_logo.png");
        } catch (Exception var3) {
        }

        this.o = new Thread(this);
        this.o.start();
    }

    private int a(String var1, byte[] var2) {
        boolean var3;
        int var6;
        do {
            var3 = false;
            var6 = 0;

            try {
                DataInputStream var4;
                int var5;
                for(var4 = new DataInputStream(this.getClass().getResourceAsStream("/" + var1)); (var5 = var4.read(var2, var6, var2.length - var6)) != -1 && var6 < var2.length; var6 += var5) {
                }

                var4.close();
            } catch (Exception var7) {
                var3 = true;
                System.out.println(var1);
            }

            System.gc();
        } while(var3);

        return var6;
    }

    private void a(String var1, int var2) {
        boolean var3;
        do {
            var3 = false;

            try {
                this.puyoGraphics[var2] = null;
                int var4 = this.a(var1, this.n);
                this.puyoGraphics[var2] = Image.createImage(this.n, 0, var4);
                System.gc();
            } catch (Exception var5) {
				this.gameError = true;
				this.t = 45;
                var3 = true;
            }
        } while(var3);

    }

    protected final void keyPressed(int var1) {
        switch(var1) {
        case -7:
            this.eh |= 64;
            return;
        case -6:
            this.eh |= 32;
            return;
        case 50:
            this.eh |= 1;
            return;
        case 52:
            this.eh |= 2;
            return;
        case 53:
            this.eh |= 16;
            return;
        case 54:
            this.eh |= 8;
            return;
        case 56:
            this.eh |= 4;
            return;
        default:
            switch(this.getGameAction(var1)) {
            case 1:
                this.eh |= 1;
                return;
            case 2:
                this.eh |= 2;
                return;
            case 5:
                this.eh |= 8;
            case 3:
            case 4:
            case 7:
            default:
                return;
            case 6:
                this.eh |= 4;
                return;
            case 8:
                this.eh |= 16;
            }
        }
    }

    protected final void keyReleased(int var1) {
        switch(var1) {
        case -7:
            this.eh &= -65;
            return;
        case -6:
            this.eh &= -33;
            return;
        case 50:
            this.eh &= -2;
            return;
        case 52:
            this.eh &= -3;
            return;
        case 53:
            this.eh &= -17;
            return;
        case 54:
            this.eh &= -9;
            return;
        case 56:
            this.eh &= -5;
            return;
        default:
            switch(this.getGameAction(var1)) {
            case 1:
                this.eh &= -2;
                return;
            case 2:
                this.eh &= -3;
                return;
            case 5:
                this.eh &= -9;
            case 3:
            case 4:
            case 7:
            default:
                return;
            case 6:
                this.eh &= -5;
                return;
            case 8:
                this.eh &= -17;
            }
        }
    }

    private void a() {
        this.k = this.eh;
        this.j = ~this.l & this.k;
        this.l = this.k;
        if (this.t != 10) {
            if ((this.k & this.l & 8) != 0) {
                this.m += this.r;
                if (this.m > 400) {
                    this.j |= 8;
                    this.m = 0;
                    return;
                }
            } else if ((this.k & this.l & 2) != 0) {
                this.m += this.r;
                if (this.m > 400) {
                    this.j |= 2;
                    this.m = 0;
                }
            }
        }

    }

    private void setSoftkeyText(String var1, String var2) {
        this.d = var1;
        this.e = var2;
    }

    private void b() {
        this.bF[0] = 0;
        if (this.cX) {
            this.a((String)(charGUI[this.bF[0]] + ".png"), 25);
        }

        if (this.bc > 0) {
            this.cc[1] = this.ai + 1;
            this.bF[1] = this.c(1, this.cc[1]);
            if (this.cX) {
                this.a((String)(charGUI[this.bF[1]] + ".png"), 26);
                byte var1;
                if (this.ai == 2) {
                    var1 = 11;
                } else if (this.ai == 8) {
                    var1 = 12;
                } else {
                    var1 = 7;
                }

                this.a((String)(charGUI[var1] + ".png"), 27);
            }
        }

        this.cX = false;
    }

    private void c() {
        this.bq = 0;
        this.br = 0;
        this.bp[0] = -1;
        this.bp[1] = -1;
        this.bM[0] = 0;
        this.bM[1] = 0;
        this.bs = 0;
        this.bt = 0;
    }

    private void d() {
        this.bR = -1;

        for(int var1 = 0; var1 < 5; ++var1) {
            if (this.bv > this.bQ[this.ah][var1][0]) {
                if (var1 == 0) {
                    this.E[this.ah] = true;
                }

                this.bR = (byte)var1;

                for(int var2 = 4; var2 > var1; --var2) {
                    for(int var3 = 0; var3 < 3; ++var3) {
                        this.bQ[this.ah][var2][var3] = this.bQ[this.ah][var2 - 1][var3];
                    }
                }

                this.bQ[this.ah][var1][0] = this.bv;
                this.bQ[this.ah][var1][1] = this.bA;
                this.bQ[this.ah][var1][2] = this.bu;
                return;
            }
        }

    }

    private void e() {
        this.a(dG[this.ai]);
    }

    private void f() {
        if (this.ah == 2) {
            if (!this.cI && this.bI[0] < 10000) {
                this.cI = true;
                this.a(8);
            }

            if (this.cI && this.bI[0] >= 15000) {
                this.cI = false;
                this.a(9);
                return;
            }
        } else if (!this.bJ[0] && !this.bJ[1]) {
            int var1 = 0;

            for(int var2 = 0; var2 < 6; ++var2) {
                var1 += this.cT[0][var2];
            }

            if (this.cJ) {
                this.cJ = false;
                this.e();
            }

            if (!this.cI) {
                if (var1 < 18) {
                    this.cI = true;
                    this.a(8);
                    return;
                }
            } else if (var1 > 30) {
                this.cI = false;
                this.e();
            }
        } else if (!this.cJ) {
            this.cJ = true;
            this.a(9);
            return;
        }

    }

    private void g() {
        this.i();
        this.v = 5;
        this.T = true;
        this.setSoftkeyText("Resume", "End");
    }

    private void h() {
        if (this.dl) {
            if ((this.j & 16) > 0) {
                this.u = 1;
                return;
            }

            this.dm += this.r;
            if (this.dm >= 30000) {
                this.u = 1;
                return;
            }
        }

        int var1;
        if (this.v == 4) {
            this.bO += this.r;

            for(var1 = 0; var1 < 2; ++var1) {
                if (this.bJ[var1]) {
                    int[] var10000 = this.bI;
                    var10000[var1] -= this.r;
                    if (this.bI[var1] < 0) {
                        this.bI[var1] = 0;
                    }
                }
            }
        }

        switch(this.v) {
        case 0:
            if (this.ah == 2) {
                this.v = 1;
                this.c();
                this.a(9);
            } else {
                if (this.dl) {
                    this.c();
                }

                this.v = 2;
            }
            break;
        case 1:
            if ((this.j & 1) > 0) {
                --this.ai;
                if (this.ai < 0) {
                    this.ai = 2;
                }
            } else if ((this.j & 4) > 0) {
                ++this.ai;
                if (this.ai > 2) {
                    this.ai = 0;
                }
            } else if ((this.j & 16) > 0) {
                this.U = 0;
                this.v = 2;
                this.aZ[0] = (byte)(3 + this.ai);
                switch(this.ai) {
                case 0:
                    this.ai = 1;
                    this.bm[0] = 0;
                    break;
                case 1:
                    this.ai = 5;
                    this.bm[0] = 50000;
                    break;
                case 2:
                    this.ai = 10;
                    this.bm[0] = 100000;
                }

                this.cp[0] = this.ai;
                this.a(puyoDifficulty[this.aZ[0] - 3 + this.ah * 3] + ".dat", this.dU);

                for(var1 = 0; var1 < 2; ++var1) {
                    this.b(0);
                }

                this.m(0);
            }
            break;
        case 2:
            this.U += this.r;
            if (this.U >= 1200) {
                this.U = 0;
                this.v = 3;
            }
            break;
        case 3:
            this.U += this.r;
            if (this.U >= 500) {
                this.U = 0;
                this.v = 4;
                this.setSoftkeyText("", "");
                if (!this.dl) {
                    this.setSoftkeyText("Pause", "");
                }

                if (this.ah != 2) {
                    this.e();
                }
            }

            this.L[0] = this.L[1] = true;
            break;
        case 4:
            for(var1 = 0; var1 < this.bc; ++var1) {
                this.bS[var1] = this.bU[var1] + this.bV[var1];
                this.bT[var1] = this.bW[var1];
            }

            for(var1 = 0; var1 < this.bc; ++var1) {
                this.n(var1);
            }

            for(var1 = 0; var1 < this.bc; ++var1) {
                if (this.bS[var1] != this.bU[var1] + this.bV[var1] || this.bT[var1] != this.bW[var1]) {
                    this.O[var1] = true;
                }
            }

            if (!this.D) {
                this.f();
            }

            if (!this.D) {
                if (this.cU[0]) {
                    this.a(11);
                    this.ak[0] = 9;
                    this.ak[1] = 16;
                    if (!this.dl) {
                        this.setSoftkeyText("Retry", "End");
                    }

                    this.D = true;
                } else if (this.cU[1]) {
                    this.a(10);
                    this.ak[0] = 16;
                    this.ak[1] = 9;
                    if (!this.dl) {
                        this.setSoftkeyText("Next", "");
                    }

                    this.D = true;
                }

                if (this.D) {
                    this.U = 0;
                    this.bq += this.bm[0];
                    this.bm[0] = 0;
                    if (this.ah == 2) {
                        this.bt += this.bO;
                        this.bA = this.bp[0] + 1;
                        this.bu = this.bt / 1000;
                        this.bE = (this.ai + 1) * 500;
                        if (this.bu < 200) {
                            this.by = this.bu * 50;
                        } else if (this.bu < 400) {
                            this.by = this.bu * 100 - 10000;
                        } else if (this.bu < 750) {
                            this.by = this.bu * 200 - '썐';
                        } else {
                            this.by = 100000;
                        }

                        if (this.bA == 0) {
                            this.bB = 0;
                        } else if (this.bA == 1) {
                            this.bB = 24240;
                        } else if (this.bA <= 6) {
                            this.bB = this.bA * 1000;
                        } else if (this.bA <= 10) {
                            this.bB = this.bA * 2000 - 6000;
                        } else {
                            this.bB = this.bA * 4000 - 26000;
                        }

                        this.bB <<= 1;
                        if (this.bM[0] == 0) {
                            this.bC = 0;
                        } else if (this.bM[0] <= 8) {
                            this.bC = this.bM[0] * 500;
                        } else if (this.bM[0] <= 16) {
                            this.bC = this.bM[0] * 1000 - 4000;
                        } else if (this.bM[0] <= 24) {
                            this.bC = this.bM[0] * 1500 - 12000;
                        } else if (this.bM[0] <= 36) {
                            this.bC = this.bM[0] * 2000 - 24000;
                        } else {
                            this.bC = 50000;
                        }

                        this.bC <<= 1;
                        this.bv = this.bq + this.bE + this.by + this.bB + this.bC;
                        this.d();
                        this.o();
                    }
                }

                if ((this.j & 32) != 0) {
                    this.g();
                }
            }
            break;
        case 5:
            if ((this.j & 32) != 0) {
                this.v = 4;
                this.T = false;
                this.K = true;
                this.L[0] = true;
                this.L[1] = true;
                this.M[0] = true;
                this.M[1] = true;
                this.N[0] = true;
                this.N[1] = true;
                if (this.D) {
                    this.setSoftkeyText("Retry", "End");
                } else {
                    this.setSoftkeyText("Pause", "");
                }

                this.j();
            } else if ((this.j & 64) != 0) {
                this.T = false;
                this.u = 1;
                this.j();
            }
            break;
        case 6:
            if ((this.j & 32) != 0 || (this.j & 16) != 0) {
                this.i();
                if (this.ah == 0) {
                    if (this.ai == 2) {
                        this.u = 3;
                    } else {
                        this.u = 8;
                        ++this.ai;
                    }
                } else if (this.ah == 1) {
                    if (this.ai == 10) {
                        this.u = 3;
                    } else {
                        this.u = 8;
                        ++this.ai;
                    }
                }

                this.cU[1] = false;
                this.ak[1] = 0;
                if (this.ah != 2) {
                    this.bt += this.bO;
                }
            }
            break;
        case 7:
            if ((this.j & 32) != 0) {
                this.i();
                ++this.bs;
                this.u = 2;
            } else if ((this.j & 64) != 0) {
                this.i();
                if (this.ah != 2) {
                    this.bt += this.bO;
                }

                this.v = 8;
                this.uwu = 0;
            }
            break;
        case 8:
            this.uwu += this.r;
            if (this.uwu >= 200) {
                if (!this.dl) {
                    this.setSoftkeyText("Next", "");
                }

                if (this.ah == 2) {
                    this.u = 11;
                    this.a(1);
                } else {
                    this.u = 9;
                }
            }
        }

        if (this.v == 7 || this.v == 6) {
            this.U += this.r;
            if (this.U >= 2000) {
                this.U = 0;
            }

            this.dr = 0;
            this.ds = 3 * o((this.U << 8) / 2000) / 127;
            this.dt = (byte)(6 * o((this.U << 8) / 2000 + 64) / 127);
            this.du = (byte)(-Math.abs(5 * o((this.U << 8) / 2000) / 127));
        }

        if (this.dl) {
            this.K = true;
        }

    }

    private void a(int var1) {
        if (this.B) {
            if (this.dx != var1) {
                if (this.cV != null) {
                    this.cV.close();
                    this.cV = null;
                }

                InputStream var2 = Runtime.getRuntime().getClass().getResourceAsStream(this.bgmSound[var1]);

                try {
                    this.cV = Manager.createPlayer(var2, "audio/midi");
                } catch (Exception var7) {
                    var7.printStackTrace();
                }

                try {
                    this.cV.realize();
                } catch (Exception var6) {
                    var6.printStackTrace();
                }

                if (var1 != 0 && var1 != 10 && var1 != 11) {
                    this.cV.setLoopCount(-1);
                }
            }

            try {
                this.cV.setMediaTime(0L);
            } catch (Exception var5) {
                var5.printStackTrace();
            }

            ((VolumeControl)this.cV.getControl("VolumeControl")).setLevel(this.c);

            try {
                this.cV.start();
            } catch (MediaException var4) {
                var4.printStackTrace();
            }

            this.dx = var1;
        }

    }

    private void i() {
        try {
            if (this.cV != null) {
                this.cV.stop();
                return;
            }
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    private void j() {
        if (this.B && this.dx >= 0 && this.dx != 10 && this.dx != 11) {
            this.a(this.dx);
        }

    }

    private void k() {
        if (this.dd >= 0) {
            this.dd = -1;
        }

    }

    private void l() {
        switch(this.dj) {
        case 0:
            if (!this.di) {
                this.a((String)"rg_l2.png", 0);
                this.a((String)"by_l2.png", 1);
                this.a((String)"pj_l2.png", 2);
                this.di = true;
            }

            ++this.dj;
        case 1:
            a var1 = this;

            for(int var2 = 0; var2 < puyoMainGUI.length; ++var2) {
                var1.a(puyoMainGUI[var2] + ".png", var2 + 3);
            }

			if (this.gameError) {
                this.t = 45;
			} else {
                this.t = 44;
			}
        default:
            for(this.h = 0; this.h < 10; ++this.h) {
                this.repaint();
                this.serviceRepaints();
            }

            this.i = null;
        }
    }

    private void a(byte[] var1, int var2, int var3) {
        var2 = var2 *= 96;
        byte[] var6 = new byte[6];

        int var4;
        for(var4 = 0; var4 < 6; ++var4) {
            this.ej[var4] = var1[var2];
            ++var2;
        }

        var2 += 2;
        var6[0] = 0;

        int var5;
        label62:
        for(var5 = 1; var5 < this.aZ[var3] + 1; ++var5) {
            boolean var9 = true;

            while(true) {
                while(true) {
                    if (!var9) {
                        continue label62;
                    }

                    var6[var5] = (byte)(1 + Math.abs(this.s.nextInt()) % this.aZ[var3]);
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
            this.aP[var3][var5] = 0;
        }

        for(var5 = 0; var5 < 12; ++var5) {
            for(var4 = 0; var4 < 6; ++var4) {
                this.aP[var3][var4 + var5 * 6] = var6[var1[var2]];
                ++var2;
            }
        }

        this.aQ[var3] = 13;
    }

    public final void run() {
        this.n = new byte[100000];
        this.V = Font.getFont(0, 0, 8);

        try {
            Thread.sleep(500L);
        } catch (Exception var) {
        }

        this.ac = this.getWidth();
        this.ad = this.getHeight();
        this.W = this.ac >> 1;
        this.X = this.ad >> 1;
        this.Y = this.W - 88;
        this.Z = this.W + 88;
        this.aa = this.X - 91;
        this.ab = this.X + 91;
        this.ae = this.V.charWidth('a');
        this.af = this.V.getHeight();
        this.ag = this.W - this.ae * 18 / 2;
        this.n();
        this.dn = -1;
        this.z = -1;
        this.A = -1;
        this.dx = -1;
        this.k = 0;
        a var1 = this;
        this.b = true;
        this.em = 0L;

        while(true) {
            var1.a();
            if ((var1.j & 32) != 0 || (var1.j & 16) != 0) {
                var1.em += 2000L;
            }

            var1.em += 50L;
            if (var1.em > 4000L) {
                var1.b = false;
                this.a = false;
                this.p = this.q = System.currentTimeMillis();

                while(true) {
                    while(!this.a) {
                        int var2;
                        if (this.u != -1) {
                            var1 = this;
                            this.S = true;
                            this.setSoftkeyText("", "");
                            switch(this.u) {
                            case 1:
                                this.dk = 0;
                                this.uwu = 0;
                                this.dq = false;
                                this.dl = false;
                                this.dm = 0;
                                this.i();
                                this.a((String)"ttlbg.png", 9);
                                this.setSoftkeyText("Start", "Exit");
                                break;
                            case 2:
                                a var3 = this;
                                this.de = false;
                                this.U = 0;
                                this.v = 0;
                                this.D = false;
                                this.T = false;
                                this.K = true;
                                this.cI = false;
                                this.cJ = false;
                                if (this.dl) {
                                    this.ah = 0;
                                    this.bc = 2;
                                    this.ai = 0;
                                    this.cc[0] = 0;
                                    this.cc[1] = this.ai + 1;
                                    this.cX = true;
                                    this.b();
                                } else {
                                    this.cc[0] = -1;
                                }

                                this.bJ[1] = false;

                                for(int var4 = 0; var4 < var3.bc; ++var4) {
                                    var3.ak[var4] = 0;
                                    var3.an[var4] = 0;
                                    var3.aL[var4] = 1;
                                    var3.aw[var4] = 0;
                                    if (var3.ah == 2) {
                                        var3.bP[var4] = 3;
                                    } else {
                                        var3.bP[var4] = 5;
                                    }

                                    var3.bm[var4] = 0;
                                    var3.bU[var4] = 0;
                                    var3.bV[var4] = 0;
                                    var3.bW[var4] = 0;
                                    var3.bO = 0;
                                    var3.cY[var4] = 0;
                                    var3.bN[var4] = false;
                                    var3.bK[var4] = false;
                                    var2 = var3.Y;
                                    int var5 = var3.aa;
                                    byte var6;
                                    if (var4 == 0) {
                                        var2 += 59;
                                        var5 += 15;
                                        var6 = 7;
                                    } else {
                                        var2 += 117;
                                        var5 += 15;
                                        var6 = -7;
                                    }

                                    var3.aF[var4][0] = var2;
                                    var3.aG[var4][0] = var5;
                                    var3.aF[var4][1] = var2 + var6;
                                    var3.aG[var4][1] = var5 + 13;
                                    if (var3.ah != 2) {
                                        var3.aZ[var4] = dF[var3.ai][var4];
                                        if (var4 == 0) {
                                            var3.a(puyoDifficulty[var3.aZ[0] - 3 + var3.ah * 3] + ".dat", var3.dU);
                                        }

                                        var3.bJ[var4] = false;
                                        if (var3.ah == 0 && var4 == 0) {
                                            var3.bG[var4] = 3;
                                        } else {
                                            var3.bG[var4] = 0;
                                        }

                                        var3.bI[var4] = 15000;

                                        for(var2 = 0; var2 < 2; ++var2) {
                                            var3.b(var4);
                                        }

                                        var3.m(var4);
                                    } else {
                                        var3.bJ[var4] = true;
                                        var3.bG[var4] = 7;
                                        var3.bI[var4] = 60000;

                                        for(var2 = 0; var2 < 84; ++var2) {
                                            var3.aM[var4][var2] = 0;
                                        }

                                        var3.ai = 1;
                                    }

                                    for(var2 = 0; var2 < 84; ++var2) {
                                        var3.aX[var4][var2] = 0;
                                    }

                                    var3.j(var4);
                                }

                                var3.ca = 0;
                                var3.dc = 30;
                                if (var3.ah != 2) {
                                    var3.cp[0] = var3.cp[1];
                                }

                                var3.bU[1] = 0;
                                var3.bV[1] = 0;
                                if (var3.ah == 2) {
                                    var3.bK[0] = true;
                                }

                                var3.cI = false;
                                var3.cJ = false;
                                break;
                            case 3:
                                if (this.ah == 0) {
                                    this.a(12);
                                } else if (this.ah == 1) {
                                    this.a(2);
								}
								
                                this.setSoftkeyText("Skip", "");
                                this.cW = dY[this.ah][0];
                                if (this.ah == 0) {
                                    this.et = this.runrunCourseEndingString;
                                } else {
                                    this.et = this.wakuwakuCourseEndingString;
                                    this.a((String)(charGUI[11] + ".png"), 26);
                                }

                                this.dw = 1;
                                this.m();
                                this.bJ[0] = this.bJ[1] = false;
                                break;
                            case 4:
                                this.dq = false;
                                this.a(1);
                                if (this.B) {
                                    this.setSoftkeyText("BGM ON", "Back");
                                } else {
                                    this.setSoftkeyText("BGM OFF", "Back");
                                }

                                this.y = -1;
                                this.a((String)"menubg.png", 9);
                                this.a((String)"rankbg.png", 14);
                                break;
                            case 5:
                                if (!this.dl) {
                                    this.setSoftkeyText("Next", "Back");
                                }

                                if (!this.dh) {
                                    for(var2 = 0; var2 < tutorialMenuGUI.length; ++var2) {
                                        var1.a(tutorialMenuGUI[var2] + ".png", var2 + 16);
                                    }

                                    var1.dh = true;
                                }

                                var1.ek = var1.el = 0;
                                if (var1.dl) {
                                    var1.a(1);
                                }
                                break;
                            case 6:
                                if (this.E[this.ah]) {
                                    this.setSoftkeyText("确认", "Back");
                                } else {
                                    this.setSoftkeyText("", "Back");
                                }
                                break;
                            case 7:
                                this.dd = -1;
                                this.a(2);
                                this.a((String)"op_bg.png", 14);
                                this.setSoftkeyText("Skip", "");
                                this.eq = 0;
                                this.es = 0;
                                this.ep = 0;
                                this.eo = false;
                                if (this.ah == 0) {
                                    this.et = this.runrunCourseOpeningString;
                                } else {
                                    this.et = this.wakuwakuCourseOpeningString;
                                }

                                this.c();
                                break;
                            case 8:
                            if (this.ah == 0) {
                                if (this.ai == 2) {
                                    this.a(12);
                                } else if (this.ai == 1) {
                                    this.a(3);
                                } else if (this.ai == 0) {
                                    this.a(3);
                                }
                            } else if (this.ah == 1) {
                                if (this.ai == 10) {
                                    this.a(12);
                                } else if (this.ai == 9) {
                                    this.a(3);
                                } else if (this.ai == 8) {
                                    this.a(12);
                                } else if (this.ai == 7) {
                                    this.a(12);
                                } else if (this.ai == 6) {
                                    this.a(3);
                                } else if (this.ai == 5) {
                                    this.a(3);
                                } else if (this.ai == 4) {
                                    this.a(12);
                                } else if (this.ai == 3) {
                                    this.a(12);
                                }
                            }

                                this.setSoftkeyText("Skip", "");
                                this.cX = true;
                                this.b();
                                this.bJ[0] = false;
                                this.bJ[1] = false;
                                if (this.ah == 0) {
                                    this.et = this.runrunCourseManzaiString[this.ai];
                                } else {
                                    this.et = this.wakuwakuCourseManzaiString[this.ai - 3];
                                }

                                this.dw = 0;
                                this.uwu = 0;
                                break;
                            case 9:
                                this.bA = this.bp[0] + 1;
                                this.bu = this.bt / 1000;
                                if (this.ah == 0) {
                                    this.bw = this.ai;
                                } else {
                                    this.bw = (byte)(this.ai - 3);
                                }

                                if (this.cU[0]) {
                                    if (this.bw == 0) {
                                        this.bx = 0;
                                    } else {
                                        this.bx = ev[this.ai - 1];
                                    }
                                } else {
                                    ++this.bw;
                                    this.bx = ev[this.ai];
                                }

                                if (this.ah == 0) {
                                    if (this.bu < 100) {
                                        this.by = 10000;
                                    } else if (this.bu < 350) {
                                        this.by = 14000 - this.bu * 40;
                                    } else {
                                        this.by = 0;
                                    }
                                } else if (this.bu < 200) {
                                    this.by = 100000;
                                } else if (this.bu < 500) {
                                    this.by = 140000 - this.bu * 200;
                                } else if (this.bu < 900) {
                                    this.by = 90000 - this.bu * 100;
                                } else {
                                    this.by = 0;
                                }

                                if (this.cU[0]) {
                                    this.by /= 10;
                                }

                                if (this.br == 0) {
                                    if (this.cU[0]) {
                                        this.bz = 0;
                                    } else {
                                        this.bz = 24240;
                                    }
                                } else if (this.br <= 4) {
                                    this.bz = this.br * 2500;
                                } else if (this.br <= 8) {
                                    this.bz = this.br * 5000 - 10000;
                                } else if (this.br <= 14) {
                                    this.bz = this.br * 10000 - '썐';
                                } else {
                                    this.bz = 100000;
                                }

                                if (this.bA == 0) {
                                    this.bB = 0;
                                } else if (this.bA == 1) {
                                    if (this.cU[0]) {
                                        this.bB = 0;
                                    } else {
                                        this.bB = 24240;
                                    }
                                } else if (this.bA <= 4) {
                                    this.bB = this.bA * 2500;
                                } else if (this.bA <= 8) {
                                    this.bB = this.bA * 5000 - 10000;
                                } else if (this.bA <= 12) {
                                    this.bB = this.bA * 7500 - 30000;
                                } else if (this.bA <= 15) {
                                    this.bB = this.bA * 10000 - '';
                                } else {
                                    this.bB = 100000;
                                }

                                if (this.bM[0] == 0) {
                                    this.bC = 0;
                                } else if (this.bM[0] <= 4) {
                                    this.bC = this.bM[0] * 2500;
                                } else if (this.bM[0] <= 8) {
                                    this.bC = this.bM[0] * 5000 - 10000;
                                } else if (this.bM[0] <= 12) {
                                    this.bC = this.bM[0] * 7500 - 30000;
                                } else if (this.bM[0] <= 15) {
                                    this.bC = this.bM[0] * 10000 - '';
                                } else {
                                    this.bC = 100000;
                                }

                                if (this.bs <= 3) {
                                    this.bD = (byte)(100 - this.bs * 20);
                                } else {
                                    this.bD = 20;
                                }

                                this.bv = (this.bq + this.bx + this.by + this.bz + this.bB + this.bC) * this.bD / 100;
                                this.d();
                                this.o();
                                this.a(1);
                                this.a((String)"rankbg.png", 14);
                                this.setSoftkeyText("Next", "");
                                break;
                            case 10:
                                this.bR = -1;
                                if (!this.dl) {
                                    this.setSoftkeyText("", "Back");
                                }
                                break;
                            case 11:
                                this.a((String)"rankbg.png", 14);
                                this.setSoftkeyText("Next", "");
                                break;
                            case 12:
                                this.setSoftkeyText("Next", "");
                                this.a((String)"ed.png", 15);
                                this.dp = 0;
                                this.uwu = 0;
                                break;
                            case 13:
                                this.dj = 0;
                            case 14:
                            }

                            var1.r = 0;
                            var1.t = var1.u;
                            var1.u = -1;
                            var1.K = true;
                            System.gc();
                        }

                        this.a();
                        this.p = System.currentTimeMillis();
                        this.r = (int)(this.p - this.q);
                        if (this.r < 45) {
                            try {
                                Thread.sleep((long)(45 - this.r));
                            } catch (InterruptedException var7) {
                                var7.printStackTrace();
                            }

                            this.r = 45;
                        }

                        this.q = System.currentTimeMillis();
                        if (this.S) {
                            this.r = 0;
                            this.S = false;
                            if (this.t == 2 && this.v == 4 && !this.dl) {
                                this.g();
                            }

                            if (!this.T) {
                                this.j();
                            }
                        }

                        this.be += this.r;
                        if (this.be >= 300) {
                            this.be = 0;
                            if (this.bd) {
                                this.bd = false;
                            } else {
                                this.bd = true;
                            }
                        }

                        label714:
                        switch(this.t) {
                        case 0:
                            this.u = 13;
                            break;
                        case 1:
                            switch(this.dk) {
                            case 0:
                                this.uwu += this.r;
                                if (this.uwu >= 200) {
                                    ++this.dk;
                                    this.dv = false;
                                }
                                break label714;
                            case 1:
                                if (this.B && !this.dv) {
                                    this.dv = true;
                                    this.a(0);
                                }

                                if ((this.j & 16) <= 0 && (this.j & 32) == 0) {
                                    if ((this.j & 64) != 0) {
                                        this.dV.destroyApp(true);
                                    }
                                } else {
                                    this.dm = 0;
                                    this.dl = false;
                                    this.i();
                                    ++this.dk;
                                    this.uwu = 0;
                                }

                                this.dm += this.r;
                                if (this.dm >= 30000) {
                                    this.dl = true;
                                    this.dm = 0;
                                    ++this.dn;
                                    if (this.dn >= ei.length) {
                                        this.dn = 0;
                                    }

                                    this.dk = 2;
                                    this.uwu = 0;
                                }
                                break label714;
                            case 2:
                                this.uwu += this.r;
                                if (this.uwu >= 200) {
                                    if (this.dl) {
                                        this.dm = 0;
                                        switch(ei[this.dn]) {
                                        case 0:
                                            this.u = 5;
                                            break label714;
                                        case 1:
                                            this.u = 2;
                                            break label714;
                                        case 2:
                                        case 3:
                                        case 4:
                                            this.u = 10;
                                            this.ah = (byte)(ei[this.dn] - 2);
                                        }
                                    } else {
                                        this.dm = 0;
                                        this.dl = false;
                                        this.u = 4;
                                    }
                                }
                            default:
                                break label714;
                            }
                        case 2:
                            this.h();
                            break;
                        case 3:
                            switch(this.dw) {
                            case 0:
                                this.uwu += this.r;
                                if (this.uwu >= 200) {
                                    ++this.dw;
                                    this.m();
                                    this.cW = dY[this.ah][0];
                                }
                                break label714;
                            case 1:
                                if (!this.a(this.et) && (this.j & 32) == 0) {
                                    this.cW = dY[this.ah][this.ep];
                                } else {
                                    if (this.ah == 1) {
                                        this.u = 12;
                                    } else {
                                        this.u = 9;
                                    }

                                    this.k();
                                }
                            default:
                                break label714;
                            }
                        case 4:
                            if (this.dq) {
                                this.uwu += this.r;
                                if (this.uwu >= 200) {
                                    if (this.w != -1) {
                                        this.u = this.w;
                                    }

                                    this.dq = false;
                                    this.uwu = 0;
                                }
                            } else if (this.y == -1) {
                                if ((this.j & 1) > 0) {
                                    --this.x;
                                    if (this.x < 0) {
                                        this.x = 3;
                                    }
                                } else if ((this.j & 4) > 0) {
                                    ++this.x;
                                    if (this.x >= 4) {
                                        this.x = 0;
                                    }
                                } else if ((this.j & 16) > 0) {
                                    switch(this.x) {
                                    case 0:
                                        this.y = 0;
                                        this.setSoftkeyText("", "Back");
                                        break label714;
                                    case 1:
                                        this.w = 2;
                                        this.ah = 2;
                                        this.dq = true;
                                        this.uwu = 0;
                                        this.repaint();
                                        this.serviceRepaints();
                                        this.bc = 1;
                                        this.ai = 1;
                                        this.cX = true;
                                        this.b();
                                        break label714;
                                    case 2:
                                        this.y = 0;
                                        this.setSoftkeyText("", "Back");
                                        break label714;
                                    }
                                } else if ((this.j & 64) != 0) {
                                    this.u = 1;
                                } else if ((this.j & 32) != 0 && this.B) {
                                    this.setSoftkeyText("BGM OFF", "Back");
                                    this.B = false;
                                    this.o();
                                    this.i();
                                } else if ((this.j & 32) != 0 && !this.B) {
                                    this.setSoftkeyText("BGM ON", "Back");
                                    this.B = true;
                                    this.o();
                                    this.a(1);
                                }
                            } else if (this.x == 2) {
                                if (this.z == -1 && this.A == -1) {
                                    if ((this.j & 1) != 0) {
                                        --this.y;
                                        if (this.y < 0) {
                                            this.y = 3;
                                        }
                                    } else if ((this.j & 4) != 0) {
                                        ++this.y;
                                        if (this.y > 3) {
                                            this.y = 0;
                                        }
                                    } else if ((this.j & 16) > 0) {
                                        switch(this.y) {
                                        case 0:
                                            this.w = 5;
                                            this.dq = true;
                                            this.uwu = 0;
                                            break label714;
                                        case 1:
                                            this.z = 0;
                                            this.setSoftkeyText("Change", "Back");
                                            break label714;
                                        case 2:
                                            this.w = 10;
                                            this.dq = true;
                                            this.uwu = 0;
                                            break label714;
                                        case 3:
                                            this.A = 0;
                                            this.setSoftkeyText("Next", "Back");
                                        }
                                    } else if ((this.j & 64) != 0) {
                                        this.y = -1;
                                        if (this.B) {
                                            this.setSoftkeyText("BGM ON", "Back");
                                        } else {
                                            this.setSoftkeyText("BGM OFF", "Back");
                                        }
                                    }
                                } else if (this.z != -1) {
                                    if ((this.j & 1) != 0) {
                                        --this.z;
                                        if (this.z < 0) {
                                            this.z = 1;
                                        }
                                    } else if ((this.j & 4) != 0) {
                                        ++this.z;
                                        if (this.z > 1) {
                                            this.z = 0;
                                        }
                                    } else if ((this.j & 16) == 0 && (this.j & 32) == 0) {
                                        if ((this.j & 64) != 0) {
                                            this.setSoftkeyText("", "Back");
                                            this.z = -1;
                                            this.o();
                                        }
                                    } else if (this.z == 0) {
                                        if (!this.B) {
                                            this.B = true;
                                            this.a(1);
                                        } else {
                                            this.B = false;
                                            this.i();
                                        }
                                    } else {
                                        this.i();
                                        switch(this.c) {
                                        case 60:
                                            this.c = 20;
                                            break;
                                        case 100:
                                            this.c = 60;
                                            break;
                                        default:
                                            this.c = 100;
                                        }

                                        this.a(1);
                                    }
                                } else if (this.A != -1) {
                                    if ((this.j & 64) != 0) {
                                        --this.A;
                                        if (this.A < 0) {
                                            this.A = -1;
                                            this.setSoftkeyText("", "Back");
                                        }
                                    } else if ((this.j & 16) != 0 || (this.j & 32) != 0) {
                                        ++this.A;
                                        if (this.A > this.aboutString.length - 1) {
                                            this.A = -1;
                                            this.setSoftkeyText("", "Back");
                                        }
                                    }
                                }
                            } else if (this.x == 0) {
                                if ((this.j & 1) != 0) {
                                    --this.y;
                                    if (this.y < 0) {
                                        this.y = 1;
                                    }
                                } else if ((this.j & 4) != 0) {
                                    ++this.y;
                                    if (this.y > 1) {
                                        this.y = 0;
                                    }
                                } else if ((this.j & 16) != 0) {
                                    this.dq = true;
                                    this.uwu = 0;
                                    this.repaint();
                                    this.serviceRepaints();
                                    switch(this.y) {
                                    case 0:
                                        this.w = 7;
                                        this.ah = 0;
                                        this.bc = 2;
                                        this.ai = 0;
                                        break label714;
                                    case 1:
                                        this.w = 7;
                                        this.ah = 1;
                                        this.bc = 2;
                                        this.ai = 3;
                                    }
                                } else if ((this.j & 64) != 0) {
                                    this.y = -1;
                                    if (this.B) {
                                        this.setSoftkeyText("BGM ON", "Back");
                                    } else {
                                        this.setSoftkeyText("BGM OFF", "Back");
                                    }
                                }
                            }
                            break;
                        case 5:
                            label750: {
                                boolean var13 = false;
                                if (this.dl) {
                                    this.dm += this.r;
                                    if (this.dm >= 4000) {
                                        var13 = true;
                                        this.dm = 0;
                                    }

                                    if ((this.j & 16) > 0) {
                                        this.u = 1;
                                        break label750;
                                    }
                                }

                                if ((this.j & 16) <= 0 && (this.j & 32) == 0 && !var13) {
                                    if ((this.j & 64) != 0) {
                                        --this.el;
                                        if (this.el < 0) {
                                            --this.ek;
                                            if (this.ek < 0) {
                                                this.ek = 0;
                                                this.t = 4;
                                                this.dq = true;
                                                this.w = -1;
                                                this.setSoftkeyText("", "Back");
                                            } else {
                                                this.el = (byte)(this.tutorialString[this.ek].length - 1);
                                            }
                                        }
                                    }
                                } else {
                                    ++this.el;
                                    if (this.el > (byte)(this.tutorialString[this.ek].length - 1)) {
                                        ++this.ek;
                                        if (this.ek >= 9) {
                                            if (this.dl) {
                                                this.dm = 0;
                                                this.u = 1;
                                            } else {
                                                this.ek = 8;
                                                this.t = 4;
                                                this.dq = true;
                                                this.w = -1;
                                                this.setSoftkeyText("", "Back");
                                            }
                                        } else {
                                            this.el = 0;
                                        }
                                    }
                                }
                            }
                        case 6:
                        case 14:
                        default:
                            break;
                        case 7:
                            String[][] var11 = this.et;
                            boolean var12 = false;
                            if (!this.eo) {
                                this.eq += this.r;
                                if (this.eq >= 1000) {
                                    this.eq = 0;
                                    ++this.es;
                                    if (this.es > var11[this.ep].length - 1) {
                                        this.eo = true;
                                    }
                                }
                            }

                            if ((this.j & 16) > 0) {
                                if (!this.eo) {
                                    this.eo = true;
                                } else {
                                    this.eq = 0;
                                    this.es = 0;
                                    ++this.ep;
                                    if (this.ep > var11.length - 1) {
                                        var12 = true;
                                    } else {
                                        this.eo = false;
                                    }
                                }
                            }

                            if (var12 || (this.j & 32) != 0) {
                                this.u = 8;
                            }
                            break;
                        case 8:
                            switch(this.dw) {
                            case 0:
                                this.uwu += this.r;
                                if (this.uwu >= 200) {
                                    ++this.dw;
                                    this.m();
                                    this.cW = dX[this.ai][0];
                                }
                                break label714;
                            case 1:
                                if (!this.a(this.et) && (this.j & 32) == 0) {
                                    this.cW = dX[this.ai][this.ep];
                                } else {
                                    this.u = 2;
                                    this.k();
                                }
                            default:
                                break label714;
                            }
                        case 9:
                            if ((this.j & 16) != 0 || (this.j & 32) != 0) {
                                this.u = 11;
                            }
                            break;
                        case 10:
                            if (this.dl) {
                                this.dm += this.r;
                                if (this.dm >= 5000) {
                                    this.u = 1;
                                    break;
                                }

                                if ((this.j & 16) != 0) {
                                    this.u = 1;
                                    break;
                                }
                            }

                            if ((this.j & 2) != 0) {
                                --this.ah;
                                if (this.ah < 0) {
                                    this.ah = 2;
                                }
                            } else if ((this.j & 8) != 0) {
                                ++this.ah;
                                if (this.ah > 2) {
                                    this.ah = 0;
                                }
                            } else if ((this.j & 32) == 0 && (this.j & 64) != 0) {
                                this.setSoftkeyText("", "Back");
                                this.t = 4;
                                this.dq = true;
                                this.w = -1;
                            }
                            break;
                        case 11:
                            if ((this.j & 16) != 0 || (this.j & 32) != 0) {
                                this.u = 1;
                            }
                            break;
                        case 12:
                            switch(this.dp) {
                            case 0:
                                this.uwu += this.r;
                                if (this.uwu >= 200) {
                                    ++this.dp;
                                }
                                break label714;
                            case 1:
                                if ((this.j & 16) != 0 || (this.j & 32) != 0) {
                                    ++this.dp;
                                    this.uwu = 0;
                                }
                                break label714;
                            case 2:
                                this.uwu += this.r;
                                if (this.uwu >= 200) {
                                    this.u = 9;
                                }
                            default:
                                break label714;
                            }
                        case 13:
                            this.l();
                        }

                        if (this.v != 4) {
                            this.K = true;
                        }

                        if (this.K) {
                            this.L[0] = true;
                            this.L[1] = true;
                            this.N[0] = true;
                            this.N[1] = true;
                        }

                        for(var2 = 0; var2 < 2; ++var2) {
                            if (this.L[var2]) {
                                this.M[var2] = true;
                            }
                        }

                        if (this.u == -1) {
                            this.repaint();
                            this.serviceRepaints();
                        }

                        while(true) {
                            Thread.yield();
                            if (!this.R) {
                                break;
                            }
                        }
                    }

                    return;
                }
            }

            try {
                Thread.sleep(50L);
            } catch (InterruptedException var8) {
                var8.printStackTrace();
            }

            var1.repaint();
            var1.serviceRepaints();
        }
    }

    private void a(Graphics var1) {
        var1.setColor(9234943);
        var1.fillRect(0, 0, this.ac, this.ad);
        if (this.puyoGraphics[9] != null) {
            var1.drawImage(this.puyoGraphics[9], this.W, this.X, 3);
        }

    }

    private void b(Graphics var1) {
        var1.setColor(0);
        var1.fillRect(0, 0, this.ac, this.ad);
    }

    private static void a(Graphics var0, int var1, int var2, int var3, int var4, int var5) {
        var3 -= var1;
        var4 -= var2;
        var0.setColor(en[var5][0]);
        var0.fillRoundRect(var1, var2, var3, var4, 16, 16);
        var0.setColor(en[var5][1]);
        var0.fillRoundRect(var1 + 2, var2 + 2, var3 - 4, var4 - 4, 20, 10);
    }

    private void m() {
        this.eq = 0;
        this.er = 0;
        this.es = 0;
        this.ep = 0;
        this.eo = false;
    }

    private boolean a(String[][] var1) {
        boolean var2 = false;
        if (!this.eo) {
            this.eq += this.r;
            if (this.eq >= 30) {
                this.eq = 0;
                ++this.er;
                if (this.er > var1[this.ep][this.es].length() - 1) {
                    this.er = 0;
                    ++this.es;
                    if (this.es > var1[this.ep].length - 1) {
                        this.eo = true;
                        this.k();
                    }
                }
            }
        }

        if ((this.j & 16) > 0) {
            if (!this.eo) {
                this.eo = true;
                this.k();
            } else {
                this.eq = 0;
                this.er = 0;
                this.es = 0;
                ++this.ep;
                if (this.ep > var1.length - 1) {
                    var2 = true;
                    this.k();
                } else {
                    this.eo = false;
                }
            }
        }

        return var2;
    }

    private void c(Graphics var1) {
        this.K = true;
        this.L[0] = true;
        this.L[1] = true;
        this.N[0] = true;
        this.N[1] = true;
        switch(this.dw) {
        case 0:
            this.b(var1);
            return;
        case 1:
            this.e(var1);
            this.a((Graphics)var1, 0);
            this.a((Graphics)var1, 1);
            var1.drawImage(this.puyoGraphics[25], this.Y, this.aa + 9, 20);
            byte var2;
            switch(this.cW) {
            case 0:
            default:
                if (this.ah == 0) {
                    if (this.ai == 2) {
                        var2 = 26;
                    } else {
                        var2 = 27;
                    }
                    break;
                } else if (this.t != 3) {
                    var2 = 26;
                    break;
                }
            case 2:
                var2 = 27;
                break;
            case 1:
                var2 = 26;
            }

            var1.drawImage(this.puyoGraphics[var2], this.Z, this.aa + 9, 24);
            int var3 = this.aa + 44;
            a(var1, this.Y, var3, this.Y + 176 - 1, var3 + 88, 2);
            int var10;
            if (this.cW == 0) {
                var10 = this.Y + 27;
                var1.setColor(0);
            } else {
                var10 = this.Y + 137;
                var1.setColor(17286);
            }

            int var6 = this.aa + 36;
            a(var1, this.puyoGraphics[7], 55, 77, 11, 11, 0, var10, var6, 20);
            boolean var7 = true;
            String[][] var5 = this.et;
            Graphics var4 = var1;
            a var11 = this;
            int var8 = (84 - 3 * this.af) / 4;
            int var9 = var3 + 2 + var8;
            if (this.eo) {
                this.es = var5[this.ep].length;
            } else {
                var1.drawSubstring(var5[this.ep][this.es], 0, this.er, this.ag - 5, var9 + (var8 + this.af) * this.es, 20);
            }

            for(var3 = 0; var3 < var11.es; ++var3) {
                var4.drawString(var5[var11.ep][var3], var11.ag - 5, var9 + (var8 + var11.af) * var3, 20);
            }
        default:
        }
    }

    private void d(Graphics var1) {
        a(var1, this.puyoGraphics[5], 68, 0, 41, 20, 0, this.Y + 68, this.aa + 9, 20);
    }

    private void e(Graphics var1) {
        if (this.K) {
            var1.setColor(16639461);
            var1.fillRect(0, 0, this.ac, this.ad);
        }

        int var2;
        for(var2 = 0; var2 < 2; ++var2) {
            if (this.N[var2]) {
                var1.setColor(11622577);
                var1.fillRect(this.Y + var2 * 88, this.aa + 9, 88, 37);
            }
        }

        int var3;
        for(var2 = 0; var2 < 2; ++var2) {
            if (this.L[var2]) {
                var3 = this.Y + dz[var2];
                if (this.bJ[var2]) {
                    var1.setColor(0);
                    var1.fillRect(var3, this.aa + 58, 66, 112);
                    boolean var5 = false;
                    var1.drawImage(this.puyoGraphics[4], var3, this.aa + 58 + 18, 20);
                } else {
                    byte var4;
                    if (var2 != 0 && this.ah == 2) {
                        var4 = 13;
                    } else {
                        var4 = 3;
                    }

                    var1.drawImage(this.puyoGraphics[var4], var3, this.aa + 58, 20);
                }
            }
        }

        this.d(var1);
        var3 = this.aa + 134;
        var2 = this.W;
        a(var1, this.puyoGraphics[7], 143, 99, 22, 33, 0, var2, var3, 17);
    }

    private void a(Graphics var1, int var2) {
        a(var1, this.puyoGraphics[5], var2 * 88, 0, 88, 49, 0, this.Y + var2 * 88, this.aa + 9, 20);
        this.c(var1, var2);
    }

    private void b(Graphics var1, int var2) {
        if (this.bd) {
            a(var1, this.puyoGraphics[10], 0, 0, 100, 18, 0, this.W, this.aa + 140, 17);
        }

    }

    private void a(Graphics var1, int var2, int var3) {
        a(var1, this.puyoGraphics[12], 54, 88, 9, 9, 0, var2, var3, 20);
    }

    private void b(Graphics var1, int var2, int var3) {
        a(var1, this.puyoGraphics[12], 59, 66, 5, 9, 0, var2, var3, 20);
    }

    private void c(Graphics var1, int var2, int var3) {
        a(var1, this.puyoGraphics[12], 54, 66, 4, 9, 0, var2, var3, 20);
    }

    private void a(Graphics var1, int var2, int var3, int var4) {
        int var5 = var2 - 15;
        this.d(var1, var5, var3, var4 / 60);
        this.c(var1, var5, var3);
        this.a(var1, var2, var3, var4 % 60, 2);
    }

    private void d(Graphics var1, int var2, int var3) {
        a(var1, this.puyoGraphics[10], 0, 36, 100, 18, 0, var2, var3, 17);
    }

    private void e(Graphics var1, int var2, int var3) {
        a(var1, this.puyoGraphics[10], 0, 54, 100, 18, 0, var2, var3, 17);
    }

    private void b(Graphics var1, int var2, int var3, int var4) {
        a(var1, this.puyoGraphics[11], 0, 0 + var4 * 18, 100, 18, 0, var2, var3, 17);
    }

    private void f(Graphics var1, int var2, int var3) {
        a(var1, this.puyoGraphics[12], 0, 33, 54, 9, 0, var2, var3, 20);
    }

    private void g(Graphics var1, int var2, int var3) {
        a(var1, this.puyoGraphics[12], 0, 44, 54, 9, 0, var2, var3, 20);
    }

    private void h(Graphics var1, int var2, int var3) {
        a(var1, this.puyoGraphics[12], 0, 66, 54, 9, 0, var2, var3, 20);
    }

    private void i(Graphics var1, int var2, int var3) {
        a(var1, this.puyoGraphics[12], 55, 22, 27, 9, 0, var2, var3, 20);
    }

    private void j(Graphics var1, int var2, int var3) {
        a(var1, this.puyoGraphics[12], 55, 11, 29, 9, 0, var2, var3, 20);
    }

    private void k(Graphics var1, int var2, int var3) {
        a(var1, this.puyoGraphics[12], 55, 0, 29, 9, 0, var2, var3, 20);
    }

    private void l(Graphics var1, int var2, int var3) {
        a(var1, this.puyoGraphics[12], 0, 55, 54, 9, 0, var2, var3, 20);
    }

    private void m(Graphics var1, int var2, int var3) {
        a(var1, this.puyoGraphics[7], 154, 0, 55, 35, 0, var2, var3, 20);
    }

    private void n(Graphics var1, int var2, int var3) {
        a(var1, this.puyoGraphics[7], 99, 44, 55, 55, 0, var2, var3, 20);
    }

    private void o(Graphics var1, int var2, int var3) {
        a(var1, this.puyoGraphics[7], 0, 88, 67, 11, 0, var2, var3, 20);
    }

    private void p(Graphics var1, int var2, int var3) {
        a(var1, this.puyoGraphics[7], 0, 132, 108, 20, 0, var2, var3, 17);
    }

    private void q(Graphics var1, int var2, int var3) {
        a(var1, this.puyoGraphics[7], 0, 110, 108, 20, 0, var2, var3, 17);
    }

    private void c(Graphics var1, int var2, int var3, int var4) {
        a(var1, this.puyoGraphics[12], 55 + var4 % 5 * 5, 44 + var4 / 5 * 11, 5, 11, 0, var2, var3, 20);
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
            var6 += 5;
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
            var6 += 5;
            this.c(var1, var2 - var6, var3, var4 % 10);
            if (var4 > 0) {
                var4 /= 10;
            }
        }

    }

    public final void paint(Graphics var1) {
        try {
            if (this.b) {
                var1.setColor(16777215);
                var1.fillRect(0, 0, this.ac, this.ad);
                if (this.em < 2000L) {
                    var1.drawImage(this.f, this.W, this.X, 3);
                } else if (this.em < 4000L) {
                    var1.drawImage(this.i, this.W, this.X, 3);
                }

                return;
            }

            if (this.S) {
                return;
            }

            var1.setFont(this.V);
            a var2;
            Graphics var3;
            int var5;
            int var6;
            int var8;
            int var9;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var21;
            byte var22;
            int var25;
            boolean var35;
            int var36;
            int var37;
            boolean var41;
            boolean var27;
            int var10002;
            label576:
            switch(this.t) {
            case 1:
                switch(this.dk) {
                case 0:
                case 2:
                    this.b(var1);
                    break label576;
                case 1:
                    this.a(var1);
                    if (this.puyoGraphics[8] != null) {
                        var1.drawImage(this.puyoGraphics[8], this.W, this.aa + 8, 17);
                    }

                    this.b(var1, 149);
                    var25 = this.aa + 171;
                    var6 = this.W;
                    a(var1, this.puyoGraphics[11], 62, 54, 34, 18, 0, var6, var25, 17);
                default:
                    break label576;
                }
            case 2:
                var3 = var1;
                var2 = this;
                if (this.v == 8) {
                    this.b(var1);
                } else {
                    this.e(var1);
                    var8 = this.bI[0] / 10 % 100;
                    var9 = this.bI[0] / 1000;

                    for(var21 = 0; var21 < var2.bc; ++var21) {
                        var27 = false;
                        boolean var38 = false;
                        if (var2.L[var21] || var2.bH[var21] != var2.bG[var21]) {
                            var2.d(var3, var21);
                        }

                        if (!var2.T && var2.v >= 2) {
                            int var17;
                            Graphics var28;
                            a var50;
                            if (var2.ak[var21] == 3 && var2.M[var21]) {
                                if (!var2.L[var21]) {
                                    var25 = var21;
                                    var28 = var3;
                                    var50 = var2;
                                    var12 = 0;

                                    label739:
                                    while(true) {
                                        if (var12 >= 3) {
                                            var25 = var21;
                                            var28 = var3;
                                            var50 = var2;

                                            for(var13 = 0; var13 < 6; ++var13) {
                                                for(var14 = 0; var14 < 14; ++var14) {
                                                    var12 = var13 + var14 * 6;
                                                    if (var50.bb[var25][var12]) {
                                                        var50.g(var28, var25, var13, var14);
                                                    }
                                                }
                                            }

                                            var25 = var21;
                                            var28 = var3;
                                            var50 = var2;
                                            var14 = 0;

                                            while(true) {
                                                if (var14 >= 6) {
                                                    break label739;
                                                }

                                                for(var17 = 2; var17 < 14; ++var17) {
                                                    var12 = var14 + var17 * 6;
                                                    if ((var13 = var50.ba[var25][var12]) != 0) {
                                                        var50.b(var28, var13, 0, var50.Y + dz[var25] + var14 * 11 + 5, var50.aa + 40 + var17 * 9 + 4 + 3);
                                                    }
                                                }

                                                ++var14;
                                            }
                                        }

                                        for(var13 = 0; var13 < 3; ++var13) {
                                            if (var50.az[var25][var12 + var13 * 3] != 0) {
                                                var50.g(var28, var25, var50.aH[var25] - 1 + var12, var50.aI[var25] - 1 + var13);
                                            }
                                        }

                                        ++var12;
                                    }
                                }

                                if (var2.aE[var21] >= var2.aa + 40 + 9) {
                                    var2.a(var3, var2.au[var21], var2.ax[var21], var2.aD[var21], var2.aE[var21] + 3, var2.aA[var21]);
                                }

                                if (var2.aK[var21] <= 2) {
                                    var2.c(var3, var21);
                                }
                            }

                            Graphics var45;
                            byte var29;
                            if (var2.L[var21] || var2.P[var21] || var2.Q[var21]) {
                                var16 = var21;
                                var45 = var3;
                                var50 = var2;
                                Graphics var49 = var3;

                                for(var17 = 0; var17 < 6; ++var17) {
                                    if (var50.P[var16] && var50.aY[var16][var17] == 1) {
                                        var36 = var17;
                                        var25 = var16;
                                        var28 = var49;
                                        a var43 = var50;

                                        for(var12 = 0; var12 < 14; ++var12) {
                                            if (var43.aM[var25][var36 + var12 * 6] != 0) {
                                                var43.g(var28, var25, var36, var12);
                                            }
                                        }
                                    }

                                    for(var5 = 2; var5 < 14; ++var5) {
                                        var36 = var17 + var5 * 6;
                                        var29 = var50.aM[var16][var36];
                                        if (var50.Q[var16] && (var50.aN[var16][var36] != var50.aM[var16][var36] || var50.aW[var16][var36] != var50.aV[var16][var36])) {
                                            var50.g(var49, var16, var17, var5);
                                        }

                                        if (var29 != 0) {
                                            boolean var47 = true;
                                            byte var18 = var50.aV[var16][var36];
                                            if ((var50.ak[var16] == 5 || var50.ak[var16] == 11 || var50.ak[var16] == 18) && var50.aY[var16][var17] == 1) {
                                                if (var16 == 0) {
                                                    var36 = o((var50.an[var16] << 7) / 200);
                                                    var12 = 512 - var36 * 512 / 3 / 127;
                                                    var12 = var12 * 9 / 512;
                                                    var25 = 126 - (13 - var5) * var12 - (var12 >> 1);
                                                } else {
                                                    var41 = false;
                                                    var25 = var5 * 9 + 4;
                                                }
                                            } else if (var50.ak[var16] == 6 && var50.aR[var16][var36] == 1) {
                                                var18 = 23;
                                                var41 = false;
                                                var25 = var5 * 9 + 4;
                                            } else if (var50.ak[var16] == 7 && var50.aR[var16][var36] == 1) {
                                                var41 = false;
                                                var25 = var5 * 9 + 4;
                                                var18 = 24;
                                                if (var16 == 1) {
                                                    var50.g(var49, var16, var17, var5);
                                                }
                                            } else if (var50.ak[var16] != 9 && var50.ak[var16] != 21) {
                                                var41 = false;
                                                var25 = var5 * 9 + 4;
                                                if (var50.Q[var16] && var50.aN[var16][var36] == var50.aM[var16][var36] && var50.aW[var16][var36] == var50.aV[var16][var36]) {
                                                    var47 = false;
                                                }
                                            } else {
                                                var41 = false;
                                                var25 = var5 * 9 + 4 + var50.an[var16] * 9 * 14 / 1000;
                                            }

                                            if (var47 || var50.L[var16]) {
                                                var36 = var50.Y + dz[var16] + var17 * 11 + 5;
                                                var12 = var50.aa + 40 + var25 + 3;
                                                if (var25 <= 126) {
                                                    var50.b(var45, var29, var18, var36, var12);
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                            if (var2.N[var21]) {
                                var16 = var21;
                                var45 = var3;
                                var50 = var2;

                                for(var5 = 1; var5 >= 0; --var5) {
                                    byte var30;
                                    if ((var29 = var50.av[var16][var5]) == 0) {
                                        var30 = 16;
                                    } else {
                                        var30 = 22;
                                    }

                                    var50.a(var45, var29, 0, var50.aF[var16][var5] - var30, var50.aG[var16][var5] - 9 + 8 - 1, var50.aC[var16][var5]);
                                }
                            }
                        }

                        if (var2.N[var21]) {
                            var2.a(var3, var21);
                            if (var21 == 0) {
                                var3.drawImage(var2.puyoGraphics[25], var2.Y, var2.aa + 9, 20);
                            } else {
                                var3.drawImage(var2.puyoGraphics[26], var2.Z, var2.aa + 9, 24);
                            }
                        }

                        if (var2.O[var21]) {
                            var2.c(var3, var21);
                        }

                        if (var2.L[var21] || var2.P[var21]) {
                            var25 = var2.aa + 8 + 50 + 112;
                            var3.setColor(16639461);
                            var3.fillRect(var2.Y + var21 * 88, var25, 88, 11);
                        }
                    }

                    if (var2.bc == 1 && var2.K) {
                        var2.a((Graphics)var3, 1);
                        var2.d(var3, 1);
                    }

                    var2.d(var3);
                    var2.a(var3, var2.Y + 107, var2.aa + 15, var2.bq + var2.bm[0], 8);
                    if (var2.ah == 2 && var2.v >= 2) {
                        var6 = var2.Y + 74;
                        var25 = var2.aa + 30;
                        var3.setColor(16639461);
                        var3.fillRect(var6, var25, 19, 11);
                        var2.k(var3, var6, var25);
                        var2.a(var3, var2.Y + 102, var25, var2.ai, 2);
                    }

                    var6 = var2.Y + 87;
                    var25 = var2.aa + 148;
                    var5 = var2.aa + 137;
                    var16 = var2.W;
                    a(var3, var2.puyoGraphics[12], 55, 77, 18, 10, 0, var16, var5, 17);
                    var2.a(var3, var6, var25, var9, 2);
                    var2.c(var3, var6 - 1, var25);
                    var2.a(var3, var6 + 13, var25, var8, 2);
                    var5 = var25 + 15;
                    var16 = var2.W;
                    a(var3, var2.puyoGraphics[12], 77, 77, 11, 10, 0, var16, var5, 17);

                    for(var21 = 0; var21 < var2.bc; ++var21) {
                        if (var2.v == 4) {
                            if (var2.bJ[var21] && (var2.ak[var21] == 20 || var2.ak[var21] == 17) && var2.bK[var21]) {
                                var10002 = var2.Y + 6 + dz[var21];
                                var5 = var2.aa + 62;
                                a(var3, var2.puyoGraphics[7], 0, 0, 53, 19, 0, var10002, var5, 20);
                            }

                            if (!var2.bJ[var21] && (var2.ak[var21] == 20 || var2.ak[var21] == 17) || var2.bJ[var21] && var2.ak[var21] == 21) {
                                if (var2.bN[var21]) {
                                    var10002 = var2.Y + 5 + dz[var21];
                                    var5 = var2.aa + 62;
                                    a(var3, var2.puyoGraphics[7], 99, 0, 55, 37, 0, var10002, var5, 20);
                                }

                                if (var21 == 0 && var2.bJ[0] && var2.de) {
                                    var10002 = var2.Y + 27;
                                    var5 = var2.aa + 95;
                                    a(var3, var2.puyoGraphics[7], 110, 99, 33, 62, 0, var10002, var5, 20);
                                }
                            }

                            if (var21 == 0 && var2.ak[var21] == 7) {
                                var25 = 0;
                                var6 = 0;

                                for(var14 = 0; var14 < var2.db[var21]; ++var14) {
                                    if ((var36 = var2.cZ[var21][var14] + 1) > 4) {
                                        var36 = 4;
                                    }

                                    if ((var37 = var2.da[var21][var14] + 1) < 2) {
                                        var37 = 2;
                                    }

                                    if (var37 > 12) {
                                        var37 = 12;
                                    }

                                    var6 += var2.cZ[var21][var14];
                                    var25 += var2.da[var21][var14];
                                    if (var2.an[var21] < 66) {
                                        var22 = 0;
                                    } else if (var2.an[var21] < 133) {
                                        var22 = 1;
                                    } else {
                                        var22 = 2;
                                    }

                                    var10002 = var2.Y + dz[var21] + var36 * 11;
                                    var5 = var2.aa + 40 + var37 * 9;
                                    a(var3, var2.puyoGraphics[7], 66, var22 * 22, 22, 22, 0, var10002, var5, 20);
                                }

                                var6 /= var2.db[var21];
                                var25 /= var2.db[var21];
                                if ((var36 = var6 + 1) < 2) {
                                    var36 = 2;
                                }

                                if (var36 > 4) {
                                    var36 = 4;
                                }

                                if ((var37 = var25 - 3) < 2) {
                                    var37 = 2;
                                }

                                var12 = var2.Y + dz[var21] + var36 * 11 - 7;
                                var13 = var2.aa + 40 + var37 * 9;
                                var2.d(var3, var12, var13, var2.bf[var21] + 1);
                                var2.j(var3, var12, var13);
                            }
                        }
                    }

                    label589:
                    switch(var2.v) {
                    case 1:
                        var10002 = var2.Y + 14;
                        var5 = var2.aa + 72;
                        a(var3, var2.puyoGraphics[7], 165, 99, 33, 85, 0, var10002, var5, 20);
                        var10002 = var2.Y + 47;
                        var5 = var2.aa + 78 + var2.ai * 30;
                        a(var3, var2.puyoGraphics[7], 110, 165, 22, 14, 0, var10002, var5, 20);
                        break;
                    case 2:
                        var21 = 0;

                        while(true) {
                            if (var21 >= var2.bc) {
                                break label589;
                            }

                            var10002 = var2.Y + 9 + dz[var21];
                            var5 = var2.X;
                            a(var3, var2.puyoGraphics[7], 0, 22, 53, 18, 0, var10002, var5, 20);
                            ++var21;
                        }
                    case 3:
                        for(var21 = 0; var21 < var2.bc; ++var21) {
                            var10002 = var2.Y + 5 + dz[var21];
                            var5 = var2.X;
                            a(var3, var2.puyoGraphics[7], 0, 66, 53, 18, 0, var10002, var5, 20);
                        }
                    case 4:
                    default:
                        break;
                    case 5:
                        var5 = var2.aa + 109;
                        var16 = var2.W;
                        a(var3, var2.puyoGraphics[7], 0, 44, 62, 22, 0, var16, var5, 3);
                        break;
                    case 6:
                        var2.m(var3, var2.Y + 5 + dz[0] + var2.dt, var2.aa + 91 + var2.du);
                        if (var2.bc == 2) {
                            var2.n(var3, var2.Y + 5 + dz[1], var2.aa + 84 + var2.ds);
                        }
                        break;
                    case 7:
                        var10002 = var2.Y + 15;
                        var5 = var2.aa + 120;
                        a(var3, var2.puyoGraphics[7], 150, 44, 55, 44, 0, var10002, var5, 20);
                        var2.n(var3, var2.Y + 5 + dz[0], var2.aa + 60 + var2.ds);
                        if (var2.bc == 2) {
                            var2.m(var3, var2.Y + 5 + dz[1] + var2.dt, var2.aa + 91 + var2.du);
                        } else {
                            var16 = var2.Y + 101;
                            var5 = var2.aa + 59;
                            var36 = var16 + 60 - 4;
                            var6 = var16 + 25;
                            a(var3, var2.puyoGraphics[12], 0, 77, 54, 9, 0, var16, var5, 20);
                            var5 += 10;
                            var25 = var5 + 1;
                            var2.d(var3, var36, var5, var2.bq);
                            var2.a(var3, var36, var25);
                            var5 += 10;
                            var25 = var5 + 1;
                            var2.k(var3, var16, var5);
                            var2.d(var3, var6, var5, var2.ai);
                            var2.d(var3, var36, var5, var2.bE);
                            var2.b(var3, var6, var5);
                            var2.a(var3, var36, var25);
                            var5 += 10;
                            var2.h(var3, var16, var5);
                            var5 += 10;
                            var25 = var5 + 1;
                            var2.a(var3, var6, var5, var2.bu);
                            var2.d(var3, var36, var5, var2.by);
                            var2.b(var3, var6, var5);
                            var2.a(var3, var36, var25);
                            var5 += 10;
                            var2.l(var3, var16, var5);
                            var5 += 10;
                            var25 = var5 + 1;
                            var2.d(var3, var6, var5, var2.bA);
                            var2.d(var3, var36, var5, var2.bB);
                            var2.b(var3, var6, var5);
                            var2.a(var3, var36, var25);
                            var5 += 10;
                            var2.g(var3, var16, var5);
                            var5 += 10;
                            var25 = var5 + 1;
                            var2.d(var3, var6, var5, var2.bM[0]);
                            var2.d(var3, var36, var5, var2.bC);
                            var2.b(var3, var6, var5);
                            var2.a(var3, var36, var25);
                            var5 += 10;
                            var2.f(var3, var16, var5);
                            var5 += 10;
                            var25 = var5 + 1;
                            var2.d(var3, var36, var5, var2.bv);
                            var2.a(var3, var36, var25);
                        }
                    }

                    if (var2.dl) {
                        var2.b(var3, 90);
                    }
                }
                break;
            case 3:
                this.c(var1);
                break;
            case 4:
                var3 = var1;
                var2 = this;
                if (this.dq) {
                    this.b(var1);
                    break;
                } else {
                    var1.setColor(9234943);
                    var1.fillRect(0, 0, this.ac, this.ad);
                    this.a(var1);
                    var5 = 0;
                    if (this.y == -1) {
                        a(var1, this.Y + 8, this.aa + 91, this.Y + 176 - 8, this.aa + 182 - 8, 0);

                        for(var25 = 0; var25 < 4; ++var25) {
                            var21 = var2.aa + 6 + var25 * 22;
                            if (var25 == var2.x) {
                                var2.p(var3, var2.W, var21 - 2);
                            } else {
                                var2.q(var3, var2.W, var21 - 2);
                            }

                            switch(var25) {
                            case 0:
                                var2.e(var3, var2.W, var21);
                                break;
                            case 1:
                                var2.d(var3, var2.W, var21);
                                break;
                            case 2:
                                var37 = var2.W;
                                a(var3, var2.puyoGraphics[11], 0, 36, 50, 18, 0, var37, var21, 17);
                                break;
                            case 3:
                                var37 = var2.W;
                                var3.drawRegion(var2.puyoGraphics[11], 0, 90, 100, 18, 0, var37, var21, 17);
                            }
                        }

                        var5 = var2.x;
                    } else if (this.x == 0) {
                        a(var1, this.Y + 8, this.aa + 91, this.Y + 176 - 8, this.aa + 182 - 8, 0);

                        for(var25 = 0; var25 < 2; ++var25) {
                            var21 = var2.aa + 27 + var25 * 24;
                            if (var25 == var2.y) {
                                var2.p(var3, var2.W, var21 - 2);
                            } else {
                                var2.q(var3, var2.W, var21 - 2);
                            }

                            var2.b(var3, var2.W, var21, var25);
                        }

                        var5 = 4 + var2.y;
                    } else if (this.x == 2) {
                        if (this.z == -1 && this.A == -1) {
                            a(var1, this.Y + 8, this.aa + 91, this.Y + 176 - 8, this.aa + 182 - 8, 1);

                            for(var25 = 0; var25 < 4; ++var25) {
                                var21 = var2.aa + 4 + var25 * 22;
                                if (var25 == var2.y) {
                                    var2.p(var3, var2.W, var21 - 2);
                                } else {
                                    var2.q(var3, var2.W, var21 - 2);
                                }

                                switch(var25) {
                                case 0:
                                    var37 = var2.W;
                                    a(var3, var2.puyoGraphics[10], 0, 18, 100, 18, 0, var37, var21, 17);
                                    break;
                                case 1:
                                    var37 = var2.W;
                                    a(var3, var2.puyoGraphics[11], 50, 36, 50, 18, 0, var37, var21, 17);
                                    break;
                                case 2:
                                    var37 = var2.W;
                                    a(var3, var2.puyoGraphics[10], 0, 90, 64, 18, 0, var37, var21, 17);
                                    break;
                                case 3:
                                    var37 = var2.W;
                                    a(var3, var2.puyoGraphics[10], 0, 72, 100, 18, 0, var37, var21, 17);
                                }
                            }

                            var5 = 6 + var2.y;
                        } else {
                            a(var1, this.Y + 8, this.aa + 91, this.Y + 176 - 8, this.aa + 182 - 8, 1);
                            if (this.z != -1) {
                                for(var25 = 0; var25 < 2; ++var25) {
                                    var21 = var2.aa + 36 + var25 * 32;
                                    if (var25 == var2.z) {
                                        var2.p(var3, var2.W, var21 - 3);
                                    } else {
                                        var2.q(var3, var2.W, var21 - 3);
                                    }

                                    if (var2.B) {
                                        var12 = var2.aa + 36;
                                        var37 = var2.W;
                                        a(var3, var2.puyoGraphics[11], 50, 36, 50, 18, 0, var37 - 20, var12, 17);
                                        a(var3, var2.puyoGraphics[11], 8, 54, 17, 18, 0, var37 + 20, var12, 17);
                                    } else {
                                        var12 = var2.aa + 36;
                                        var37 = var2.W;
                                        a(var3, var2.puyoGraphics[11], 50, 36, 50, 18, 0, var37 - 20, var12, 17);
                                        a(var3, var2.puyoGraphics[11], 42, 54, 17, 18, 0, var37 + 20, var12, 17);
                                    }

                                    var10002 = var2.aa + 36 + 30;
                                    var13 = var2.c;
                                    var37 = var2.W;
                                    a(var3, var2.puyoGraphics[11], 8, 72, 34, 18, 0, var37 - 20, var10002, 17);
                                    switch(var13) {
                                    case 20:
                                        a(var3, var2.puyoGraphics[11], 82, 72, 16, 18, 0, var37 + 20, var10002, 17);
                                        break;
                                    case 60:
                                        a(var3, var2.puyoGraphics[11], 62, 72, 16, 18, 0, var37 + 20, var10002, 17);
                                        break;
                                    default:
                                        a(var3, var2.puyoGraphics[11], 43, 72, 16, 18, 0, var37 + 20, var10002, 17);
                                    }
                                }

                                var5 = 6 + var2.y;
                            } else if (this.A != -1) {
                                a(var1, this.Y + 8, this.aa + 8, this.Y + 176 - 8, this.aa + 182 - 8, 1);
                                var1.setColor(4802947);
                                String[] var34 = this.aboutString[this.A];

                                for(var8 = 0; var8 < var34.length; ++var8) {
                                    if (var34[var8] != null) {
                                        var3.drawString(var34[var8], var2.W, var2.aa + 20 + var8 * 25, 17);
                                    }
                                }

                                var5 = 6 + var2.y;
                            }
                        }
                    }

                    if (var2.A != -1) {
                        break;
                    }

                    var41 = false;
                    Graphics var40 = var3;
                    a var39 = var2;
                    var3.setColor(35752);
                    String[] var44;
                    var14 = (var44 = var2.menuDescriptionString[var5]).length;
                    var15 = (79 - var14 * var2.af) / (var14 + 1);
                    var16 = 0;

                    while(true) {
                        if (var16 >= var44.length) {
                            break label576;
                        }

                        if (var44[var16] != null) {
                            var40.drawString(var44[var16], var39.ag, var39.aa + 91 + 2 + var15 + (var15 + var39.af) * var16, 20);
                        }

                        ++var16;
                    }
                }
            case 5:
                var3 = var1;
                var2 = this;
                this.b(var1);
                var1.drawImage(this.puyoGraphics[24], this.W, this.aa, 17);
                if (this.ek > 0) {
                    byte var26;
                    if (this.ek - 1 < 5) {
                        var26 = 24;
                        var22 = 16;
                    } else {
                        var26 = 51;
                        var22 = 18;
                    }

                    var1.drawImage(this.puyoGraphics[16 + this.ek - 1], this.Y + var26, this.aa + var22, 20);
                }

                var1.setColor(16777215);

                for(var21 = 0; var21 < var2.tutorialString[var2.ek][var2.el].length; ++var21) {
                    var3.drawString(var2.tutorialString[var2.ek][var2.el][var21], var2.ag - 10, var2.aa + 100 + var21 * 20, 20);
                }

                if (var2.dl) {
                    var2.b(var3, 68);
                }
            case 6:
            default:
                break;
            case 7:
                var1.setColor(666532);
                var1.fillRect(0, 0, this.ac, this.ad);
                var1.drawImage(this.puyoGraphics[14], this.W, this.X, 3);
                var35 = false;
                var9 = 16250789;
                var27 = true;
                var25 = this.aa;
                String[][] var23 = this.et;
                Graphics var32 = var1;
                a var24 = this;
                var12 = (178 - 7 * this.af) / 8;
                var13 = var25 + 2 + var12;
                if (this.eo) {
                    this.es = var23[this.ep].length;
                }

                var14 = 0;

                while(true) {
                    if (var14 >= var24.es) {
                        break label576;
                    }

                    var15 = var24.W;
                    var16 = var13 + (var12 + var24.af) * var14;
                    var32.setColor(0);

                    for(var37 = 0; var37 < 4; ++var37) {
                        var32.drawString(var23[var24.ep][var14], var15 + eu[var37][0], var16 + eu[var37][1], 17);
                    }

                    var32.setColor(var9);
                    var32.drawString(var23[var24.ep][var14], var15, var16, 17);
                    ++var14;
                }
            case 8:
                this.c(var1);
                break;
            case 9:
                var3 = var1;
                var2 = this;
                var21 = this.Y + 12;
                var6 = this.Y + 100;
                var25 = this.Y + 165;
                var8 = this.Y + 105;
                var1.setColor(666532);
                var1.fillRect(0, 0, this.ac, this.ad);
                var1.drawImage(this.puyoGraphics[14], this.W, this.X, 3);
                byte var33;
                switch(this.ah) {
                case 0:
                default:
                    var33 = 2;
                    break;
                case 1:
                    var33 = 0;
                }

                a(var1, this.Y + 6, this.aa + 48, this.Y + 176 - 6, this.aa + 182 - 6, var33);
                var1.setColor(en[var33][0]);
                var5 = this.aa + 69;

                for(var36 = 0; var36 < 2; ++var36) {
                    var3.drawLine(var2.Y + 8, var5 + var36, var2.Z - 8, var5 + var36);
                }

                var5 = var2.aa + 153;

                for(var36 = 0; var36 < 2; ++var36) {
                    var3.drawLine(var2.Y + 8, var5 + var36, var2.Z - 8, var5 + var36);
                }

                var3.setStrokeStyle(1);

                for(var36 = 0; var36 < 5; ++var36) {
                    var5 = var2.aa + 83 + var36 * 14;
                    var3.drawLine(var2.Y + 8, var5, var2.Z - 8, var5);
                }

                var3.setStrokeStyle(0);
                var2.e(var3, var2.W, var2.aa + 7);
                var2.b(var3, var2.W, var2.aa + 22, var2.ah);
                var5 = var2.aa + 58;
                var2.i(var3, var21, var5);
                var2.d(var3, var25, var5, var2.bq);
                var5 = var2.aa + 73;
                a(var3, var2.puyoGraphics[12], 0, 22, 54, 9, 0, var21, var5, 20);
                var2.d(var3, var6, var5, var2.bw);
                var2.d(var3, var25, var5, var2.bx);
                var2.b(var3, var8, var5);
                var5 = var2.aa + 87;
                var2.h(var3, var21, var5);
                var2.a(var3, var6, var5, var2.bu);
                var2.d(var3, var25, var5, var2.by);
                var2.b(var3, var8, var5);
                var5 = var2.aa + 101;
                a(var3, var2.puyoGraphics[12], 0, 11, 54, 9, 0, var21, var5, 20);
                var2.d(var3, var6, var5, var2.br);
                var2.d(var3, var25, var5, var2.bz);
                var2.b(var3, var8, var5);
                var5 = var2.aa + 115;
                var2.l(var3, var21, var5);
                var2.d(var3, var6, var5, var2.bA);
                var2.d(var3, var25, var5, var2.bB);
                var2.b(var3, var8, var5);
                var5 = var2.aa + 129;
                var2.g(var3, var21, var5);
                var2.d(var3, var6, var5, var2.bM[0]);
                var2.d(var3, var25, var5, var2.bC);
                var2.b(var3, var8, var5);
                var5 = var2.aa + 143;
                a(var3, var2.puyoGraphics[12], 0, 0, 54, 9, 0, var21, var5, 20);
                var2.d(var3, var6, var5, var2.bs);
                var2.d(var3, var25 - 15, var5, var2.bD / 100);
                var13 = var25 - 15;
                a(var3, var2.puyoGraphics[12], 69, 66, 5, 9, 0, var13, var5, 20);
                var2.a(var3, var25, var5, var2.bD % 100, 2);
                a(var3, var2.puyoGraphics[12], 64, 66, 5, 9, 0, var8, var5, 20);
                var5 = var2.aa + 157;
                var2.f(var3, var21, var5);
                var2.d(var3, var25, var5, var2.bv);
                break;
            case 10:
            case 11:
                var3 = var1;
                var2 = this;
                var6 = this.Y + 18 + 5;
                var25 = this.Y + 89 - 5;
                var8 = this.Y + 107 + 10;
                var9 = this.Y + 148 + 5;
                var1.setColor(666532);
                var1.fillRect(0, 0, this.ac, this.ad);
                var1.drawImage(this.puyoGraphics[14], this.W, this.X, 3);
                switch(this.ah) {
                case 0:
                default:
                    var22 = 2;
                    break;
                case 1:
                    var22 = 0;
                    break;
                case 2:
                    var22 = 1;
                }

                a(var1, this.Y + 6, this.aa + 48, this.Y + 176 - 6, this.aa + 182 - 6, var22);
                var21 = this.aa + 17;
                if (this.ah == 2) {
                    this.d(var1, this.W, var21);
                } else {
                    this.e(var1, this.W, this.aa + 7);
                    this.b(var1, this.W, this.aa + 22, this.ah);
                }

                if (this.t == 10) {
                    var14 = this.W - 52;
                    a(var1, this.puyoGraphics[10], 64, 90, 18, 18, 0, var14, var21, 17);
                    var14 = this.W + 52;
                    a(var1, this.puyoGraphics[10], 82, 90, 18, 18, 0, var14, var21, 17);
                }

                var1.setColor(en[var22][0]);
                var21 = this.aa + 76;

                for(var37 = 0; var37 < 2; ++var37) {
                    var3.drawLine(var2.Y + 8, var21 + var37, var2.Z - 8, var21 + var37);
                }

                var21 = var2.aa + 146;

                for(var37 = 0; var37 < 2; ++var37) {
                    var3.drawLine(var2.Y + 8, var21 + var37, var2.Z - 8, var21 + var37);
                }

                var3.setStrokeStyle(1);

                for(var37 = 0; var37 < 4; ++var37) {
                    var21 = var2.aa + 90 + var37 * 14;
                    var3.drawLine(var2.Y + 8, var21, var2.Z - 8, var21);
                }

                var3.setStrokeStyle(0);
                var21 = var2.aa + 64;
                var14 = var2.Y + 14;
                a(var3, var2.puyoGraphics[12], 54, 33, 27, 9, 0, var14, var21, 20);
                var2.i(var3, var2.Y + 58, var21);
                var2.j(var3, var2.Y + 99, var21);
                var14 = var2.Y + 127 + 5;
                a(var3, var2.puyoGraphics[12], 0, 88, 54, 11, 0, var14, var21, 20);

                for(var37 = 0; var37 < 5; ++var37) {
                    if (var2.bR == var37) {
                        var35 = var2.bd;
                    } else {
                        var35 = true;
                    }

                    var21 = var2.aa + 81 + var37 * 14;
                    if (var35) {
                        var2.d(var3, var6, var21, var37 + 1);
                        var2.c(var3, var2.Y + 32, var21);
                        var2.d(var3, var25, var21, var2.bQ[var2.ah][var37][0]);
                        var2.a(var3, var25, var21);
                        var2.d(var3, var8, var21, var2.bQ[var2.ah][var37][1]);
                        var2.a(var3, var9, var21, var2.bQ[var2.ah][var37][2]);
                    }
                }

                if (var2.dl) {
                    var2.b(var3, 149);
                }
                break;
            case 12:
                var1.setColor(0);
                var1.fillRect(0, 0, this.ac, this.ad);
                if (this.dp == 1) {
                    var1.drawImage(this.puyoGraphics[15], this.W, this.X, 3);
                }
                break;
            case 13:
                var1.setColor(0);
                var1.fillRect(0, 0, this.ac, this.ad);
            case 14:
                String var4 = null;
                var3 = var1;
                var5 = this.ac;
                var6 = this.ad;
                var1.setColor(0);
                var1.fillRect(0, 0, var5, var6);
                var1.setColor(16777215);
                Font var7 = var1.getFont();
                var8 = 0;
                var9 = 0;
                String[] var10 = new String[]{"", "", "", "", "", "", "", ""};

                while(var4.length() > 0) {
                    String var11 = var4.substring(0, 1);
                    var4 = var4.substring(1);
                    if (var11.equals(",")) {
                        if ((var12 = var7.stringWidth(var10[var9++])) > var8) {
                            var8 = var12;
                        }
                    } else {
                        var10[var9] = var10[var9] + var11;
                    }
                }

                if ((var37 = var7.stringWidth(var10[var9++])) > var8) {
                    var8 = var37;
                }

                var12 = var7.getHeight();
                var13 = (var5 - var8) / 2;
                var14 = (var6 - var12 * var9) / 2;

                for(var37 = 0; var37 < var9; ++var37) {
                    var3.drawString(var10[var37], var13, var14 + var37 * var12, 20);
                }
				break;
            case 44:
                var1.setColor(2368548);
                var1.fillRect(0, 0, this.ac, this.ad);
                var1.setColor(16777215);
                var1.drawString("Enable Sound?", this.W, this.X, 33);
                this.setSoftkeyText("Yes", "No");
                if ((this.j & 32) != 0) {
                    this.B = true;
	                this.setSoftkeyText("Start", "Exit");
                    this.u = 1;
                } else if ((this.j & 64) != 0) {
                    this.B = false;
	                this.setSoftkeyText("Start", "Exit");
                    this.u = 1;
                }
				break;
            case 45:
                var1.setColor(2368548);
                var1.fillRect(0, 0, this.ac, this.ad);
                var1.setColor(16777215);
                var1.drawString("ERROR!", this.W, this.X, 33);
                this.setSoftkeyText("Yes", "No");
                if ((this.j & 64) != 0) {
                    this.dV.destroyApp(true);
                }
				break;
            }

            this.K = false;
            this.L[0] = false;
            this.L[1] = false;
            this.M[0] = false;
            this.M[1] = false;
            this.N[0] = false;
            this.N[1] = false;
            this.O[0] = false;
            this.O[1] = false;
            this.P[0] = false;
            this.P[1] = false;
        } catch (Exception var31) {
            var31.printStackTrace();
        }

        var1.setColor(0);
        var1.fillRect(0, 0, this.ac, this.aa);
        var1.fillRect(0, this.ab, this.ac, this.ad - this.ab);
        var1.fillRect(0, this.aa - 1, this.ac, 1);
        var1.fillRect(0, this.ab - 1, this.ac, 1);
        var1.setColor(16777215);
        var1.drawString(this.d, 0, this.ad, 36);
        var1.drawString(this.e, this.ac, this.ad, 40);
    }

    protected final void showNotify() {
        this.R = false;
        this.S = true;
        this.K = true;
    }

    protected final void hideNotify() {
        this.R = true;
        this.i();
    }

    private void n() {
        RecordStore var1;
        byte[] var2;
        int var3;
        int var5;
        int var6;
        try {
            if ((var1 = RecordStore.openRecordStore("d", false)) != null) {
                if ((var2 = var1.getRecord(1)) != null) {
                    var3 = 0;

                    int var4;
                    byte var9;
                    for(var4 = 0; var4 < 3; ++var4) {
                        var6 = var3++;
                        var9 = var2[var6];
                        byte var11 = var2[var6];
                        this.E[var4] = var9 > 0;
                        this.I[var4] = (var2[var3++] & 255) + ((var2[var3++] & 255) << 8) + ((var2[var3++] & 255) << 16) + ((var2[var3++] & 255) << 24);
                        this.J[var4] = (var2[var3++] & 255) + ((var2[var3++] & 255) << 8) + ((var2[var3++] & 255) << 16) + ((var2[var3++] & 255) << 24);
                        this.F[var4] = 2000 + var2[var3++];
                        this.G[var4] = var2[var3++];
                        this.H[var4] = var2[var3++];
                    }

                    ++var3;
                    this.B = (var9 = var2[36]) > 0;
                    ++var3;
                    this.C = (var9 = var2[37]) > 0;
                    ++var3;
                    this.c = var2[38] * 20;
                    var4 = 0;

                    while(true) {
                        if (var4 >= 3) {
                            var1.closeRecordStore();
                            break;
                        }

                        for(var5 = 0; var5 < 5; ++var5) {
                            this.bQ[var4][var5][0] = (var2[var3++] & 255) + ((var2[var3++] & 255) << 8) + ((var2[var3++] & 255) << 16) + ((var2[var3++] & 255) << 24);
                            this.bQ[var4][var5][1] = var2[var3++];
                            this.bQ[var4][var5][2] = (var2[var3++] & 255) + ((var2[var3++] & 255) << 8);
                        }

                        ++var4;
                    }
                }

                System.gc();
                return;
            }
        } catch (RecordStoreException var10) {
            try {
                var2 = new byte[144];
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
                        var2[var3++] = (byte)dW[var5][var6][0];
                        var2[var3++] = (byte)(dW[var5][var6][0] >> 8);
                        var2[var3++] = (byte)(dW[var5][var6][0] >> 16);
                        var2[var3++] = (byte)(dW[var5][var6][0] >>> 24);
                        var2[var3++] = (byte)dW[var5][var6][1];
                        var2[var3++] = (byte)dW[var5][var6][2];
                        var2[var3++] = (byte)(dW[var5][var6][2] >> 8);
                    }
                }

                var1.addRecord(var2, 0, 144);
                var1.closeRecordStore();
            } catch (RecordStoreException var9) {
                var10.printStackTrace();
            }

            this.n();
            System.gc();
        }

    }

    private void o() {
        try {
            RecordStore var1 = RecordStore.openRecordStore("d", false);
            byte[] var2 = new byte[144];
            int var3 = 0;

            int var4;
            for(var4 = 0; var4 < 3; ++var4) {
                var2[var3++] = (byte)(this.E[var4] ? 1 : 0);
                var2[var3++] = (byte)this.I[var4];
                var2[var3++] = (byte)(this.I[var4] >> 8);
                var2[var3++] = (byte)(this.I[var4] >> 16);
                var2[var3++] = (byte)(this.I[var4] >>> 24);
                var2[var3++] = (byte)this.J[var4];
                var2[var3++] = (byte)(this.J[var4] >> 8);
                var2[var3++] = (byte)(this.J[var4] >> 16);
                var2[var3++] = (byte)(this.J[var4] >>> 24);
                var2[var3++] = (byte)(this.F[var4] % 100);
                var2[var3++] = (byte)this.G[var4];
                var2[var3++] = (byte)this.H[var4];
            }

            ++var3;
            var2[36] = (byte)(this.B ? 1 : 0);
            ++var3;
            var2[37] = (byte)(this.C ? 1 : 0);
            ++var3;
            var2[38] = (byte)(this.c / 20);

            for(var4 = 0; var4 < 3; ++var4) {
                for(int var5 = 0; var5 < 5; ++var5) {
                    var2[var3++] = (byte)this.bQ[var4][var5][0];
                    var2[var3++] = (byte)(this.bQ[var4][var5][0] >> 8);
                    var2[var3++] = (byte)(this.bQ[var4][var5][0] >> 16);
                    var2[var3++] = (byte)(this.bQ[var4][var5][0] >>> 24);
                    var2[var3++] = (byte)this.bQ[var4][var5][1];
                    var2[var3++] = (byte)this.bQ[var4][var5][2];
                    var2[var3++] = (byte)(this.bQ[var4][var5][2] >> 8);
                }
            }

            var1.setRecord(1, var2, 0, 144);
            var1.closeRecordStore();
            System.gc();
        } catch (RecordStoreException var6) {
        }

    }

    private int a(int var1, int var2) {
        return this.aJ[var1] - 1 + var2;
    }

    private void b(int var1) {
        int var3;
        for(int var2 = 0; var2 < 1; ++var2) {
            for(var3 = 0; var3 < 9; ++var3) {
                this.aC[var1][0][var3] = this.aC[var1][1][var3];
            }

            this.av[var1][0] = this.av[var1][1];
        }

        for(var3 = 0; var3 < 9; ++var3) {
            this.aC[var1][1][var3] = 0;
        }

        if (this.ah == 2) {
            this.av[var1][1] = 0;
        } else {
            this.av[var1][1] = dR[this.bF[var1]][this.aw[var1]];
            ++this.aw[var1];
            if (this.aw[var1] >= 16) {
                this.aw[var1] = 0;
            }
        }

        byte var5;
        byte var4;
        switch(this.av[var1][1]) {
        case 0:
            var4 = (byte)(1 + Math.abs(this.s.nextInt()) % this.aZ[var1]);
            var5 = (byte)(1 + Math.abs(this.s.nextInt()) % this.aZ[var1]);
            this.aC[var1][1][1] = var4;
            this.aC[var1][1][4] = var5;
            return;
        case 1:
            var4 = (byte)(1 + Math.abs(this.s.nextInt()) % this.aZ[var1]);
            var5 = (byte)(1 + Math.abs(this.s.nextInt()) % this.aZ[var1]);
            this.aC[var1][1][1] = var4;
            this.aC[var1][1][4] = var4;
            this.aC[var1][1][5] = var5;
            return;
        case 2:
            var5 = 1;

            for(var4 = 1; var4 == var5; var5 = (byte)(1 + Math.abs(this.s.nextInt()) % this.aZ[var1])) {
                var4 = (byte)(1 + Math.abs(this.s.nextInt()) % this.aZ[var1]);
            }

            this.aC[var1][1][1] = var4;
            this.aC[var1][1][2] = var5;
            this.aC[var1][1][4] = var4;
            this.aC[var1][1][5] = var5;
            return;
        case 3:
            this.aC[var1][1][1] = this.aL[var1];
            this.aC[var1][1][2] = this.aL[var1];
            this.aC[var1][1][4] = this.aL[var1];
            this.aC[var1][1][5] = this.aL[var1]++;
            if (this.aZ[var1] == 5 && this.aL[var1] > 5 || this.aZ[var1] == 4 && this.aL[var1] > 4 || this.aZ[var1] == 3 && this.aL[var1] > 3) {
                this.aL[var1] = 1;
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
            if ((var11 = this.ax[var1] + 1) >= 4) {
                var11 -= 4;
            }
        } else if (var2 == 1) {
            if ((var11 = this.ax[var1] - 1) < 0) {
                var11 += 4;
            }
        } else if ((var11 = this.ax[var1] + 2) >= 4) {
            var11 -= 4;
        }

        int var3;
        int var4;
        int var5;
        int var14;
        for(var3 = 0; var3 < 3; ++var3) {
            for(var4 = 0; var4 < 3; ++var4) {
                if (this.au[var1] == 2) {
                    if (var3 != 0 && var4 != 2) {
                        if (var2 == 0) {
                            var5 = var4 + 1;
                            var14 = 2 - var3;
                        } else {
                            var5 = 2 - var4;
                            var14 = var3 - 1;
                        }

                        this.aB[var1][var3 + var4 * 3] = this.aA[var1][var5 + var14 * 3];
                    } else {
                        this.aB[var1][var3 + var4 * 3] = 0;
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

                    this.aB[var1][var3 + var4 * 3] = this.aA[var1][var5 + var14 * 3];
                }
            }
        }

        int var10 = -1;
        var14 = this.aJ[var1];
        int var15 = this.aK[var1];
        int var9;
        if (this.au[var1] != 2) {
            label150:
            for(var3 = 0; var3 < 3; ++var3) {
                for(var4 = 0; var4 < 3; ++var4) {
                    var9 = var3 + var4 * 3;
                    if (this.aB[var1][var9] != 0) {
                        var2 = this.aJ[var1] - 1 + var3;
                        var5 = this.aK[var1] - 1 + var4;
                        if (this.aq[var1] > 0) {
                            ++var5;
                        }

                        if (var2 < 0 || var2 >= 6 || var5 >= 14) {
                            var10 = var9;
                            break label150;
                        }

                        if (this.aM[var1][var2 + var5 * 6] != 0) {
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
                var14 = this.aJ[var1] + 1;
                var15 = this.aK[var1];
            case 4:
            case 6:
            default:
                break;
            case 5:
                var14 = this.aJ[var1] - 1;
                var15 = this.aK[var1];
                break;
            case 7:
                var14 = this.aJ[var1];
                var15 = this.aK[var1] - 1;
            }

            label127:
            for(var3 = 0; var3 < 3; ++var3) {
                for(var4 = 0; var4 < 3; ++var4) {
                    var9 = var3 + var4 * 3;
                    if (this.aB[var1][var9] != 0) {
                        var2 = var14 - 1 + var3;
                        var5 = var15 - 1 + var4;
                        if (this.aq[var1] > 0) {
                            ++var5;
                        }

                        if (var2 < 0 || var2 >= 6 || var5 >= 14) {
                            var8 = false;
                            break label127;
                        }

                        if (this.aM[var1][var2 + var5 * 6] != 0) {
                            var8 = false;
                            break label127;
                        }
                    }
                }
            }
        }

        if (var8) {
            this.aJ[var1] = var14;
            this.aK[var1] = var15;

            for(var3 = 0; var3 < 3; ++var3) {
                for(var4 = 0; var4 < 3; ++var4) {
                    var2 = var3 + var4 * 3;
                    this.aA[var1][var2] = this.aB[var1][var2];
                }
            }

            this.ax[var1] = var11;
        }

        return var8;
    }

    private boolean c(int var1) {
        return !this.a(var1, this.aJ[var1], this.aK[var1] + 1);
    }

    private boolean d(int var1) {
        return this.a(var1, this.aJ[var1], this.aK[var1]);
    }

    private boolean a(int var1, int var2, int var3) {
        for(int var4 = 0; var4 < 3; ++var4) {
            for(int var5 = 0; var5 < 3; ++var5) {
                if (this.aA[var1][var4 + var5 * 3] != 0) {
                    int var6 = var2 - 1 + var4;
                    int var7 = var3 - 1 + var5;
                    if (this.aq[var1] > 0) {
                        ++var7;
                    }

                    if (var6 < 0 || var6 > 5 || var7 < 0 || var7 > 13) {
                        return true;
                    }

                    if (this.aM[var1][var6 + var7 * 6] != 0) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private void e(Graphics var1, int var2, int var3, int var4) {
        --var2;
        var3 -= 5;
        var4 -= 5;
        a(var1, this.puyoGraphics[ew[var2]], 77, ex[var2] + 33, 11, 11, 0, var3, var4, 20);
    }

    private void c(Graphics var1, int var2) {
        int var4 = 0;
        int var3 = this.bU[var2] + this.bV[var2];
        int var5 = this.Y + dz[var2];
        int var6 = this.aa + 8 + 50 - 11;
        if (this.bJ[var2]) {
            if (this.bW[var2] > 0 && var3 == 0) {
                this.o(var1, var5, var6);
                var3 = this.bW[var2];
            } else {
                a(var1, this.puyoGraphics[7], 0, 99, 67, 11, 0, var5, var6, 20);
                var3 = var3;
            }
        } else {
            this.o(var1, var5, var6);
            var3 = var3;
        }

        if (var2 < this.bc) {
            for(var2 = 0; var2 < 6; ++var2) {
                while(var3 > 0 && var3 >= dP[var2]) {
                    int var10002 = 5 - var2;
                    int var10 = 4 + var4 * 11 + var5 - 3;
                    a(var1, this.puyoGraphics[2], var10002 * 11, 77, 11, 11, 0, var10, var6, 20);
                    var3 -= dP[var2];
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
                var2 = 33 + var6 * 11;
                var3 = 55;
            } else {
                var7 = ew[var6];
                var2 = var3 * 11 % 88;
                var3 = ex[var6] + var3 / 8 * 11;
            }
        } else if (var2 == 6) {
            var7 = 2;
            if (var3 == 24) {
                var2 = 22;
                var3 = 55;
            } else {
                var2 = 22;
                var3 = 44;
            }
        } else {
            var7 = 2;
            var2 = 33 + (var2 - 7) * 11;
            var3 = 44;
        }

        a(var1, this.puyoGraphics[var7], var2, var3, 11, 11, 0, var4 - 5, var5 - 5, 20);
    }

    private void c(Graphics var1, int var2, int var3, int var4, int var5) {
        --var2;
        short var6 = ew[var2];
        byte var7;
        switch(var3) {
        case 0:
        default:
            var3 = var4 - 6;
            var4 = var5 - 15;
            var7 = 0;
            break;
        case 1:
            var3 = var4 - 7;
            var4 = var5 - 5;
            var7 = 5;
            break;
        case 2:
            var3 = var4 - 6;
            var4 = var5 - 6;
            var7 = 3;
            break;
        case 3:
            var3 = var4 - 16;
            var4 = var5 - 5;
            var7 = 6;
        }

        a(var1, this.puyoGraphics[var6], 22, ex[var2] + 22, 11, 22, var7, var3, var4, 20);
    }

    private void d(Graphics var1, int var2, int var3, int var4, int var5) {
        --var2;
        short var6 = ew[var2];
        byte var7;
        switch(var3) {
        case 0:
        default:
            var3 = var4 - 9;
            var4 = var5 - 11;
            var7 = 0;
            break;
        case 1:
            var3 = var4 - 11;
            var4 = var5 - 9;
            var7 = 5;
            break;
        case 2:
            var3 = var4 - 2;
            var4 = var5 - 11;
            var7 = 3;
            break;
        case 3:
            var3 = var4 - 11;
            var4 = var5 - 2;
            var7 = 6;
        }

        a(var1, this.puyoGraphics[var6], 33, ex[var2] + 22, 11, 22, var7, var3, var4, 20);
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
            var10 = dB[var3];
            int var10002 = 1 + dA[var10][0];
            var13 = 1 + dA[var10][1];
            if (var8 == var6[var10002 + var13 * 3]) {
                var2 = var4 + 11 + 5;
                var7 = var5 + 9 + 4;
                this.c(var1, var8, var3, var2, var7);
                this.e(var1, var8, var2 + dA[var10][0] * 11, var7 + dA[var10][1] * 9);
                return;
            }

            for(var2 = 0; var2 < 3; ++var2) {
                for(var7 = 0; var7 < 3; ++var7) {
                    var8 = var6[var2 + var7 * 3];
                    this.f(var1, var8, var4 + var2 * 11 + 5, var5 + var7 * 9 + 4);
                }
            }

            return;
        case 1:
            var10 = dB[var3];
            byte var18 = dB[(var3 + 1) % 4];
            var8 = var6[4];
            int var10001 = 1 + dA[var10][0];
            var13 = 1 + dA[var10][1];
            var17 = var6[var10001 + var13 * 3];
            var10001 = 1 + dA[var18][0];
            var13 = 1 + dA[var18][1];
            byte var15 = var6[var10001 + var13 * 3];
            var2 = var4 + 11 + 5;
            var7 = var5 + 9 + 4;
            if (var17 == var15) {
                var5 = var8 - 1;
                short var12 = ew[var5];
                byte var19;
                switch(var3) {
                case 0:
                default:
                    var14 = var2 - 7;
                    var9 = var7 - 15;
                    var19 = 0;
                    break;
                case 1:
                    var14 = var2 - 7;
                    var9 = var7 - 6;
                    var19 = 5;
                    break;
                case 2:
                    var14 = var2 - 14;
                    var9 = var7 - 6;
                    var19 = 3;
                    break;
                case 3:
                    var14 = var2 - 16;
                    var9 = var7 - 15;
                    var19 = 6;
                }

                a(var1, this.puyoGraphics[var12], 55, ex[var5] + 22, 22, 22, var19, var14, var9, 20);
                this.e(var1, var8, var2 + dA[var10][0] * 11, var7 + dA[var10][1] * 9);
                return;
            }

            if (var8 == var17) {
                this.c(var1, var8, var3, var2, var7);
                this.f(var1, var15, var2 + dA[var18][0] * 11, var7 + dA[var18][1] * 9);
                this.e(var1, var8, var2 + dA[var10][0] * 11, var7 + dA[var10][1] * 9);
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

            this.d(var1, var8, var3, var4 + 22, var5 + 9);
            this.d(var1, var17, var11, var4 + 22, var5 + 9);
            this.e(var1, var8, var4 + dC[var3][0] * 11 + 5, var5 + dC[var3][1] * 9 + 5);
            this.e(var1, var17, var4 + dC[var11][0] * 11 + 5, var5 + dC[var11][1] * 9 + 5);
            break;
        case 3:
            var8 = var6[1];
            int var10003 = var4 + 22;
            var9 = var5 + 9;
            var11 = var8 - 1;
            var5 = var10003 - 11;
            var14 = var9 - 11;
            short var16 = ew[var11];
            a(var1, this.puyoGraphics[var16], 0, ex[var11] + 22, 22, 22, 0, var5, var14, 20);
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
            if (!this.bJ[var2]) {
                var9 = var4 - 2;
                var5 = 3;
                var8 = var3 * 11;
            } else {
                if (var4 >= 4 && var4 <= 10) {
                    var8 = var3;
                    var9 = var4 - 4;
                } else {
                    var8 = 0;
                    var9 = 1;
                }

                var5 = 4;
                var8 *= 11;
            }

            a(var1, this.puyoGraphics[var5], var8, var9 * 9 + 3, 11, 9, 0, this.Y + dz[var2] + var3 * 11, this.aa + 40 + var4 * 9 + 3, 20);
            a(var1, this.puyoGraphics[var5], 0, 0, 66, 3, 0, this.Y + dz[var2], this.aa + 58, 20);
        }

    }

    private void e(int var1) {
        for(int var2 = 0; var2 < 84; ++var2) {
            if (this.ba[var1][var2] == 0) {
                this.bb[var1][var2] = false;
            } else {
                this.bb[var1][var2] = true;
                this.ba[var1][var2] = 0;
            }
        }

    }

    private void f(int var1) {
        this.e(var1);

        label45:
        for(int var4 = 0; var4 < 3; ++var4) {
            for(int var5 = 2; var5 >= 0; --var5) {
                if (this.aA[var1][var4 + var5 * 3] != 0) {
                    int var6 = 13;

                    while(true) {
                        if (var6 < 0) {
                            continue label45;
                        }

                        int var2 = this.aJ[var1] - 1 + var4 + var6 * 6;
                        if (this.aM[var1][var2] == 0) {
                            int var7 = var5;

                            while(true) {
                                if (var7 < 0) {
                                    continue label45;
                                }

                                byte var3;
                                if ((var3 = this.aA[var1][var4 + var7 * 3]) != 0) {
                                    int var10000 = this.aJ[var1] - 1 + var4;
                                    int var8 = var6 + (var7 - var5);
                                    var2 = var10000 + var8 * 6;
                                    this.ba[var1][var2] = var3 + 6;
                                }

                                --var7;
                            }
                        }

                        --var6;
                    }
                }
            }
        }

        this.M[var1] = true;
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
                byte var11 = var2.aM[var5][var10];
                var2.aT[var5][var10] = false;
                if (var11 == 0) {
                    var7 = true;
                } else if (var7) {
                    var2.aT[var5][var10] = true;
                    var8 = true;
                }
            }

            if (var8) {
                this.aY[var1][var4] = 0;
                var3 = 1;
            } else if (this.aY[var1][var4] == 0) {
                this.aY[var1][var4] = 1;
                var3 = 2;
            } else {
                this.aY[var1][var4] = 2;
            }
        }

        return var3;
    }

    private void h(int var1) {
        for(int var2 = 0; var2 < 6; ++var2) {
            for(int var3 = 13; var3 >= 0; --var3) {
                int var4 = var2 + var3 * 6;
                if (this.aT[var1][var4]) {
                    this.aT[var1][var4] = false;
                    byte[] var10000 = this.aM[var1];
                    int var6 = var3 + 1;
                    var10000[var2 + var6 * 6] = this.aM[var1][var4];
                    this.aM[var1][var4] = 0;
                }
            }
        }

    }

    private void a(int var1, byte[] var2) {
        for(int var3 = 0; var3 < 84; ++var3) {
            if (this.aR[var1][var3] == 1) {
                var2[var3] = 0;
            }
        }

    }

    private void b(int var1, int var2, int var3) {
        byte[] var10000 = this.aV[var1];
        var10000[var2] = (byte)(var10000[var2] | 1 << var3);
    }

    private void a(int var1, int var2, int var3, boolean var4) {
        int var8 = var2 + var3 * 6;
        this.aR[var1][var8] = 3;
        if (var4) {
            this.aV[var1][var8] = 0;
        }

        for(int var5 = 0; var5 < 4; ++var5) {
            int var6 = var2 + dA[var5][0];
            int var7 = var3 + dA[var5][1];
            if (var6 >= 0 && var6 < 6 && var7 >= 0 && var7 < 14) {
                int var9 = var6 + var7 * 6;
                if (this.aR[var1][var9] == 0) {
                    if (this.cq[var1][var9] != this.cq[var1][var8]) {
                        this.aR[var1][var9] = 4;
                    } else {
                        this.aR[var1][var9] = 3;
                        int var10003 = this.aU[var1]++;
                        if (var4 && (!this.aT[var1][var8] && !this.aT[var1][var9] || var5 <= 1)) {
                            this.b(var1, var8, var5);
                        }

                        this.a(var1, var6, var7, var4);
                    }
                } else if (var4 && this.aR[var1][var9] == 3 && (!this.aT[var1][var8] && !this.aT[var1][var9] || var5 <= 1)) {
                    this.b(var1, var8, var5);
                }
            }
        }

    }

    private void a(int var1, boolean var2) {
        int var3;
        for(var3 = 0; var3 < 84; ++var3) {
            this.aR[var1][var3] = 0;
        }

        int var4;
        int var6;
        if (!var2) {
            for(var6 = 0; var6 < 6; ++var6) {
                for(var3 = 0; var3 < 14; ++var3) {
                    var4 = var6 + var3 * 6;
                    this.cq[var1][var4] = this.aM[var1][var4];
                }
            }
        }

        for(var6 = 0; var6 < 6; ++var6) {
            for(var3 = 0; var3 < 14; ++var3) {
                var4 = var6 + var3 * 6;
                if (this.aR[var1][var4] == 0) {
                    byte var5;
                    if ((var5 = this.cq[var1][var4]) == 0) {
                        this.aR[var1][var4] = 2;
                    } else if (var5 == 6) {
                        this.aR[var1][var4] = 2;
                    } else {
                        this.a(var1, var6, var3, true);

                        for(var4 = 0; var4 < 84; ++var4) {
                            if (this.aR[var1][var4] == 4) {
                                this.aR[var1][var4] = 0;
                            } else if (this.aR[var1][var4] == 3) {
                                this.aR[var1][var4] = 2;
                            }
                        }
                    }
                }
            }
        }

    }

    private boolean b(int var1, boolean var2) {
        boolean var9 = false;
        this.db[var1] = 0;
        int var3;
        if (var2) {
            for(var3 = 0; var3 < 5; ++var3) {
                this.bg[var1][var3] = false;
            }

            this.bh[var1] = 0;
            this.bk[var1] = 0;
        }

        for(var3 = 0; var3 < 84; ++var3) {
            this.aR[var1][var3] = 0;
        }

        int var4;
        int var5;
        int var6;
        int var10;
        for(var4 = 0; var4 < 6; ++var4) {
            for(var5 = 0; var5 < 14; ++var5) {
                var6 = var4 + var5 * 6;
                if (this.aR[var1][var6] == 0) {
                    byte var15;
                    if ((var15 = this.cq[var1][var6]) == 0) {
                        this.aR[var1][var6] = 2;
                    } else if (var15 == 6) {
                        this.aR[var1][var6] = 2;
                    } else {
                        var10 = 6;
                        int var11 = 14;
                        int var12 = 0;
                        int var13 = 0;
                        this.aU[var1] = 1;
                        this.a(var1, var4, var5, var2);

                        int var7;
                        for(var6 = 0; var6 < 84; ++var6) {
                            if (this.aR[var1][var6] == 4) {
                                this.aR[var1][var6] = 0;
                            } else if (this.aR[var1][var6] == 3) {
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

                                if (this.aU[var1] >= 4) {
                                    this.aR[var1][var6] = 1;
                                    if (var2) {
                                        var9 = true;
                                    }
                                } else {
                                    this.aR[var1][var6] = 2;
                                }
                            }
                        }

                        if (var2 && this.aU[var1] >= 4) {
                            if (this.db[var1] < 4) {
                                this.cZ[var1][this.db[var1]] = (byte)((var10 + var12) / 2);
                                this.da[var1][this.db[var1]] = (byte)((var11 + var13) / 2);
                                ++this.db[var1];
                            }

                            int[] var16 = this.bh;
                            var16[var1] += this.aU[var1] * 10;
                            if (this.ah == 2) {
                                var7 = this.aU[var1];
                                this.dc -= var7;
                                if (this.dc < 0) {
                                    if (++this.ai > 99) {
                                        this.ai = 99;
                                    }

                                    if (++this.cp[0] > 99) {
                                        this.cp[0] = 90;
                                    }

                                    this.dc = 30;
                                }
                            }

                            this.bg[var1][var15 - 1] = true;
                            if (this.aU[var1] >= 5) {
                                if ((var3 = this.aU[var1] - 5) >= 7) {
                                    var3 = 6;
                                }

                                var16 = this.bl;
                                var16[var1] += dM[var3];
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
                    if (this.aR[var1][var6] == 1 && this.cq[var1][var6] != 6) {
                        for(var3 = 0; var3 < 4; ++var3) {
                            int var14 = var4 + dA[var3][0];
                            var6 = var5 + dA[var3][1];
                            if (var14 >= 0 && var14 < 6 && var6 >= 0 && var6 < 14) {
                                var14 += var6 * 6;
                                if (this.cq[var1][var14] == 6) {
                                    this.aR[var1][var14] = 1;
                                }
                            }
                        }
                    }
                }
            }

            var10 = 0;

            for(var3 = 0; var3 < 5; ++var3) {
                if (this.bg[var1][var3]) {
                    ++var10;
                }
            }

            if (var10 >= 2) {
                this.bk[var1] = dN[var10 - 2];
            }
        }

        return var9;
    }

    private byte c(int var1, int var2) {
        byte var6 = 0;
        this.cH[1] = false;
        this.cx[1] = 0;
        this.cs[1] = false;
        int[] var10000;
        switch(var2) {
        case 0:
            var6 = 0;
            var10000 = this.cx;
            var10000[1] |= 8;
            var10000 = this.cx;
            var10000[1] |= 4;
            var10000 = this.cx;
            var10000[1] |= 64;
            var10000 = this.cx;
            var10000[1] |= 512;
            this.cy[1] = 8000;
            this.ci[1] = 1;
            this.ch[1] = 1;
            this.ck[1] = 6000;
            this.cj[1] = 30;
            this.co[1] = 100;
            this.cp[1] = 0;
            break;
        case 1:
            var6 = 4;
            var10000 = this.cx;
            var10000[1] |= 8;
            var10000 = this.cx;
            var10000[1] |= 4;
            var10000 = this.cx;
            var10000[1] |= 64;
            var10000 = this.cx;
            var10000[1] |= 512;
            this.cy[1] = 8000;
            this.ci[1] = 1;
            this.ch[1] = 1;
            this.ck[1] = 6000;
            this.cj[1] = 30;
            this.co[1] = 100;
            this.cp[1] = 0;
            break;
        case 2:
            var6 = 6;
            var10000 = this.cx;
            var10000[1] |= 8;
            var10000 = this.cx;
            var10000[1] |= 4;
            var10000 = this.cx;
            var10000[1] |= 64;
            var10000 = this.cx;
            var10000[1] |= 32;
            var10000 = this.cx;
            var10000[1] |= 512;
            this.cy[1] = 2000;
            this.ci[1] = 2;
            this.ch[1] = 1;
            this.ck[1] = 200;
            this.cj[1] = 30;
            this.co[1] = 100;
            this.cp[1] = 0;
            break;
        case 3:
            var6 = 7;
            var10000 = this.cx;
            var10000[1] |= 4;
            var10000 = this.cx;
            var10000[1] |= 8;
            var10000 = this.cx;
            var10000[1] |= 64;
            var10000 = this.cx;
            var10000[1] |= 512;
            this.cy[1] = 500;
            this.ci[1] = 2;
            this.ch[1] = 1;
            this.ck[1] = 120;
            this.cj[1] = 16;
            this.co[1] = 100;
            this.cp[1] = 0;
            break;
        case 4:
            var6 = 5;
            var10000 = this.cx;
            var10000[1] |= 8;
            var10000 = this.cx;
            var10000[1] |= 4;
            var10000 = this.cx;
            var10000[1] |= 64;
            var10000 = this.cx;
            var10000[1] |= 512;
            this.cy[1] = 4000;
            this.ci[1] = 2;
            this.ch[1] = 1;
            this.ck[1] = 600;
            this.cj[1] = 30;
            this.co[1] = 100;
            this.cp[1] = 0;
            break;
        case 5:
            var6 = 1;
            var10000 = this.cx;
            var10000[1] |= 8;
            var10000 = this.cx;
            var10000[1] |= 64;
            var10000 = this.cx;
            var10000[1] |= 4;
            var10000 = this.cx;
            var10000[1] |= 512;
            this.cy[1] = 2000;
            this.ci[1] = 2;
            this.ch[1] = 1;
            this.ck[1] = 140;
            this.cj[1] = 20;
            this.co[1] = 80;
            this.cp[1] = 0;
            break;
        case 6:
            var6 = 4;
            var10000 = this.cx;
            var10000[1] |= 8;
            var10000 = this.cx;
            var10000[1] |= 64;
            var10000 = this.cx;
            var10000[1] |= 4;
            var10000 = this.cx;
            var10000[1] |= 512;
            this.cy[1] = 500;
            this.ci[1] = 2;
            this.ch[1] = 1;
            this.ck[1] = 120;
            this.cj[1] = 20;
            this.co[1] = 70;
            this.cp[1] = 1;
            break;
        case 7:
            var6 = 3;
            var10000 = this.cx;
            var10000[1] |= 4;
            var10000 = this.cx;
            var10000[1] |= 512;
            this.ci[1] = 3;
            this.ch[1] = 1;
            this.cy[1] = 30;
            this.ck[1] = 80;
            this.cj[1] = 10;
            this.co[1] = 70;
            this.cp[1] = 1;
            this.cs[1] = true;
            break;
        case 8:
            var6 = 2;
            var10000 = this.cx;
            var10000[1] |= 4;
            var10000 = this.cx;
            var10000[1] |= 512;
            this.ci[1] = 3;
            this.ch[1] = 2;
            this.cy[1] = 30;
            this.ck[1] = 60;
            this.cj[1] = 8;
            this.co[1] = 50;
            this.cp[1] = 2;
            break;
        case 9:
            var6 = 8;
            var10000 = this.cx;
            var10000[1] |= 4;
            var10000 = this.cx;
            var10000[1] |= 512;
            this.ci[1] = 3;
            this.ch[1] = 1;
            this.cy[1] = 30;
            this.ck[1] = 40;
            this.cj[1] = 8;
            this.co[1] = 50;
            this.cp[1] = 2;
            break;
        case 10:
            var6 = 9;
            var10000 = this.cx;
            var10000[1] |= 1024;
            this.ci[1] = 5;
            this.cy[1] = 40;
            this.ck[1] = 20;
            this.cj[1] = 6;
            this.co[1] = 30;
            this.cp[1] = 4;
            break;
        case 11:
            var6 = 10;
            var10000 = this.cx;
            var10000[1] |= 1024;
            this.ci[1] = 3;
            this.cy[1] = 30;
            this.ck[1] = 20;
            this.cj[1] = 8;
            this.co[1] = 20;
            this.cp[1] = 4;
        }

        for(int var3 = 0; var3 < 14; ++var3) {
            for(var2 = 0; var2 < 6; ++var2) {
                int var4 = var2 + var3 * 6;
                byte var5;
                if ((var5 = (byte)(dT[var6][var3][var2] / 2)) > 25) {
                    var5 = 25;
                }

                this.dS[1][var4] = (short)var5;
            }
        }

        return var6;
    }

    private void c(int var1, int var2, int var3) {
        if (!this.ct[var3] && this.cq[var1][var2] == this.cq[var1][var3]) {
            this.ct[var3] = true;
            this.cu[this.cw[var1]++] = (byte)var3;
        }

    }

    private void i(int var1) {
        if (this.cc[var1] != -1) {
            for(int var2 = 0; var2 < 17; ++var2) {
                this.cP[var1][var2] = -1;
                this.cQ[var1][var2] = 0;
                this.cO[var1][var2] = 0;
                this.cN[var1][var2] = false;
                this.cM[var1][var2] = -100000000;
            }

            this.cm[var1] = 0;
            this.cl[var1] = 0;
            this.cG[var1] = 1;
            this.cH[var1] = false;
        }

    }

    private int d(int var1, int var2) {
        if ((var2 = var2) >= 24) {
            var2 = 23;
        }

        byte var3;
        if (this.bJ[var1]) {
            var3 = 1;
        } else {
            var3 = 0;
        }

        return dQ[this.bF[var1]][var2][var3];
    }

    private int p() {
        if (this.bO / 1000 >= 96) {
            int var1;
            if ((var1 = this.bO / 1000 - 96 >> 3) >= 27) {
                var1 = 26;
            }

            if ((var1 = 120 * dO[var1][0] / dO[var1][1]) < 1) {
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
            this.cT[var1][var2] = 0;
        }

        for(var2 = 0; var2 < 6; ++var2) {
            int var3 = 0;

            while(var3 < 12) {
                byte[] var10000 = this.aM[var1];
                int var5 = var3 + 2;
                switch(var10000[var2 + var5 * 6]) {
                case 0:
                    ++this.cT[var1][var2];
                default:
                    ++var3;
                }
            }
        }

    }

    private void a(int var1, int var2, int var3, byte var4) {
        if (var3 >= 2) {
            byte var5 = (byte)(var2 + var3 * 6);
            this.cq[var1][var5] = var4;
        }

    }

    private boolean k(int var1) {
        this.cD[var1] = false;
        byte[] var10000 = this.cq[var1];
        byte var3 = 2;
        boolean var2 = true;
        if (var10000[2 + var3 * 6] != 0) {
            this.cD[var1] = true;
        }

        var10000 = this.cq[var1];
        var3 = 2;
        var2 = true;
        if (var10000[3 + var3 * 6] != 0) {
            this.cD[var1] = true;
        }

        return this.cD[var1];
    }

    private byte l(int var1) {
        this.cE[var1] = 0;
        byte var3 = 0;

        for(int var2 = 0; var2 < 6; ++var2) {
            var3 += this.cT[var1][var2];
        }

        if (!this.bJ[var1]) {
            if (var3 <= 30 && this.cE[var1] == 0) {
                this.cE[var1] = 1;
            }

            if (var3 <= 24) {
                this.cE[var1] = 2;
            }
        }

        label39: {
            byte[] var10000 = this.cq[var1];
            byte var5 = 3;
            boolean var4 = true;
            if (var10000[2 + var5 * 6] == 0) {
                var10000 = this.cq[var1];
                var5 = 3;
                var4 = true;
                if (var10000[3 + var5 * 6] == 0) {
                    break label39;
                }
            }

            this.cE[var1] = 2;
        }

        if ((this.cx[var1] & 8) > 0) {
            return this.cE[var1];
        } else {
            if (this.bU[var1] > 0) {
                if (!this.bJ[var1]) {
                    this.cE[var1] = 2;
                } else if (this.bU[var1] > 4) {
                    this.cE[var1] = 2;
                }
            }

            return this.cE[var1];
        }
    }

    private int e(int var1, int var2) {
        ++var2;
        int var3 = 0;
        int var4 = -100000000;
        if (var2 > 16) {
            var2 = 16;
        }

        if ((this.cx[var1] & 4) > 0 && var2 > this.ch[var1] + 1) {
            var2 = this.ch[var1] + 1;
        }

        do {
            if (this.cN[var1][var2] && (var4 < this.cM[var1][var2] || var3 > 0)) {
                var3 = var2;
                var4 = this.cM[var1][var2];
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

        if ((this.cx[var1] & 4) > 0 && var2 > this.ch[var1] + 1) {
            var2 = this.ch[var1] + 1;
        }

        do {
            if (this.cN[var1][var2]) {
                var3 = var2;
            }

            ++var2;
        } while(var2 <= 16);

        return var3;
    }

    private void m(int var1) {
        this.cU[var1] = false;

        int var2;
        for(var2 = 0; var2 < 84; ++var2) {
            this.aM[var1][var2] = 0;
        }

        if (this.ah != 2) {
            this.ak[var1] = 1;
        } else {
            for(var2 = 0; var2 < 84; ++var2) {
                this.bb[var1][var2] = false;
                this.ba[var1][var2] = 0;
            }

            this.ak[var1] = 20;
            this.a(this.dU, (this.bP[var1] - 3 << 2) + Math.abs(this.s.nextInt()) % 4, var1);

            for(var2 = 0; var2 < 84; ++var2) {
                this.aV[var1][var2] = 0;
            }
        }

    }

    private void n(int var1) {
        int var2 = this.Y;
        int var3 = this.aa;
        byte var4;
        if (var1 == 0) {
            var2 += 59;
            var3 += 15;
            var4 = 7;
        } else {
            var2 += 117;
            var3 += 15;
            var4 = -7;
        }

        int var5;
        for(var5 = 0; var5 < 84; ++var5) {
            this.aN[var1][var5] = this.aM[var1][var5];
            this.aW[var1][var5] = this.aV[var1][var5];
        }

        this.al[var1] = this.ak[var1];
        this.bH[var1] = this.bG[var1];
        switch(this.ak[var1]) {
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
            this.Q[var1] = true;
            break;
        case 5:
        case 11:
        case 18:
            if (var1 == 0) {
                this.P[var1] = true;
            }
            break;
        case 6:
        case 7:
            if (var1 == 1) {
                this.Q[var1] = true;
            } else {
                this.L[var1] = true;
            }
            break;
        case 9:
        case 21:
            this.L[var1] = true;
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
        if (this.cc[var1] != -1) {
            label1398:
            while(true) {
                while(true) {
                    a var7;
                    int var12;
                    int var13;
                    byte var14;
                    switch(var26.cG[var6]) {
                    case 0:
                        break label1398;
                    case 1:
                        var26.cD[var6] = false;
                        var26.cE[var6] = 0;
                        var26.cF[var6] = 0;
                        var26.j(var6);
                        switch(var26.au[var6]) {
                        case 0:
                            var26.cC[var6] = 5;
                            var26.cz[var6] = 4;
                            if ((var26.cx[var6] & 1) > 0) {
                                var26.cz[var6] = 1;
                            }
                            break;
                        case 1:
                            var26.cC[var6] = 5;
                            var26.cz[var6] = 4;
                            if ((var26.cx[var6] & 1) > 0) {
                                var26.cz[var6] = 1;
                            }
                            break;
                        case 2:
                            var26.cC[var6] = 4;
                            var26.cz[var6] = 4;
                            if ((var26.cx[var6] & 1) > 0) {
                                var26.cz[var6] = 1;
                            }
                            break;
                        case 3:
                            var26.cC[var6] = 4;
                            var26.cz[var6] = var26.aZ[var6];
                        }

                        var26.cA[var6] = 0;
                        var26.cB[var6] = 0;
                        var26.cG[var6] = 3;
                    case 3:
                        if (var26.cF[var6] >= 1) {
                            var26.cF[var6] = 0;
                            break label1398;
                        }

                        var26.bh[var6] = var26.bi[var6] = var26.bj[var6] = var26.bk[var6] = var26.bl[var6] = 0;
                        var10002 = var26.cq[var6];
                        byte[] var10 = var26.cr[var6];
                        byte[] var9 = var10002;
                        var8 = var6;
                        var7 = var26;

                        for(var11 = 0; var11 < 84; ++var11) {
                            var9[var11] = var7.aM[var8][var11];
                            var10[var11] = var7.aV[var8][var11];
                        }

                        ++var26.cA[var6];
                        switch(var26.au[var6]) {
                        case 0:
                            if (var26.cB[var6] == 5 && var26.cA[var6] == 2) {
                                ++var26.cA[var6];
                            } else if (var26.cB[var6] == 0 && var26.cA[var6] == 4) {
                                ++var26.cA[var6];
                            } else if (var26.aA[var6][4] == var26.aA[var6][1] && var26.cA[var6] >= 3) {
                                var26.cA[var6] = (byte)(var26.cz[var6] + 1);
                            }
                            break;
                        case 1:
                            if (var26.aA[var6][4] == var26.aA[var6][5]) {
                                if (var26.cA[var6] == 2 || var26.cA[var6] == 4) {
                                    ++var26.cA[var6];
                                }
                            } else if (var26.cA[var6] == 3) {
                                ++var26.cA[var6];
                            }
                        }

                        if (var26.cA[var6] > var26.cz[var6]) {
                            var26.cA[var6] = 0;
                            ++var26.cB[var6];
                            if (var26.cB[var6] > var26.cC[var6]) {
                                var26.cG[var6] = 0;
                                var26.cH[var6] = true;
                            }
                            break;
                        } else {
                            var51 = var26.cB[var6];
                            var33 = var26.cA[var6];
                            var12 = -1;
                            var13 = -1;
                            var26.cv[var6] = 0;
                            var11 = var26.cT[var6][var51] - 1 + 2;
                            if (var51 > 0) {
                                var12 = var26.cT[var6][var51 - 1] - 1 + 2;
                            }

                            if (var51 < 5) {
                                var13 = var26.cT[var6][var51 + 1] - 1 + 2;
                            }

                            label1363: {
                                byte[] var16 = var26.cq[var6];
                                if (var51 == 1) {
                                    var23 = 1;
                                    var21 = true;
                                    if (var16[1 + var23 * 6] != 0) {
                                        var54 = false;
                                        break label1363;
                                    }
                                } else if (var51 == 4) {
                                    var23 = 1;
                                    var21 = true;
                                    if (var16[4 + var23 * 6] != 0) {
                                        var54 = false;
                                        break label1363;
                                    }
                                }

                                var54 = true;
                            }

                            if (var54 && var11 >= 2) {
                                label1353: {
                                    label1350:
                                    switch(var26.au[var6]) {
                                    case 0:
                                        switch(var33 - 1) {
                                        case 0:
                                            var26.cd[var6] = var51;
                                            var26.ce[var6] = var11;
                                            var26.a(var6, var51, var11, var26.aA[var6][4]);
                                            var26.a(var6, var51, var11 - 1, var26.aA[var6][1]);
                                            break label1350;
                                        case 1:
                                            if (var13 < 2) {
                                                var54 = false;
                                                break label1353;
                                            }

                                            var26.cd[var6] = var51;
                                            var26.ce[var6] = var11;
                                            var26.a(var6, var51, var11, var26.aA[var6][4]);
                                            var26.a(var6, var51 + 1, var13, var26.aA[var6][1]);
                                            break label1350;
                                        case 2:
                                            var26.cd[var6] = var51;
                                            var26.ce[var6] = var11 - 1;
                                            var26.a(var6, var51, var11 - 1, var26.aA[var6][4]);
                                            var26.a(var6, var51, var11, var26.aA[var6][1]);
                                            break label1350;
                                        case 3:
                                            if (var12 < 2) {
                                                var54 = false;
                                                break label1353;
                                            }

                                            var26.cd[var6] = var51;
                                            var26.ce[var6] = var12;
                                            var26.a(var6, var51, var11, var26.aA[var6][4]);
                                            var26.a(var6, var51 - 1, var12, var26.aA[var6][1]);
                                        default:
                                            break label1350;
                                        }
                                    case 1:
                                        switch(var33 - 1) {
                                        case 0:
                                            if (var13 < 2) {
                                                var54 = false;
                                                break label1353;
                                            }

                                            if (var51 > 4) {
                                                var54 = false;
                                                break label1353;
                                            }

                                            var26.cd[var6] = var51;
                                            var26.ce[var6] = var11;
                                            var26.a(var6, var51, var11, var26.aA[var6][4]);
                                            var26.a(var6, var51, var11 - 1, var26.aA[var6][1]);
                                            var26.a(var6, var51 + 1, var13, var26.aA[var6][5]);
                                            break label1350;
                                        case 1:
                                            if (var13 < 2) {
                                                var54 = false;
                                                break label1353;
                                            }

                                            if (var51 > 4) {
                                                var54 = false;
                                                break label1353;
                                            }

                                            var26.cd[var6] = var51;
                                            var26.ce[var6] = var11 - 1;
                                            var26.a(var6, var51, var11 - 1, var26.aA[var6][4]);
                                            var26.a(var6, var51 + 1, var13, var26.aA[var6][1]);
                                            var26.a(var6, var51, var11, var26.aA[var6][5]);
                                            break label1350;
                                        case 2:
                                            if (var12 < 2) {
                                                var54 = false;
                                                break label1353;
                                            }

                                            if (var51 < 1) {
                                                var54 = false;
                                                break label1353;
                                            }

                                            var26.cd[var6] = var51;
                                            var26.ce[var6] = var11 - 1;
                                            var26.a(var6, var26.cd[var6], var26.ce[var6], var26.aA[var6][4]);
                                            var26.a(var6, var51, var11, var26.aA[var6][1]);
                                            var26.a(var6, var51 - 1, var12, var26.aA[var6][5]);
                                            break label1350;
                                        case 3:
                                            if (var13 < 2) {
                                                var54 = false;
                                                break label1353;
                                            }

                                            if (var51 < 1) {
                                                var54 = false;
                                                break label1353;
                                            }

                                            var26.cd[var6] = var51;
                                            var26.ce[var6] = var11;
                                            var26.a(var6, var26.cd[var6], var26.ce[var6], var26.aA[var6][4]);
                                            var26.a(var6, var51 - 1, var13, var26.aA[var6][1]);
                                            var26.a(var6, var51, var11 - 1, var26.aA[var6][5]);
                                        default:
                                            break label1350;
                                        }
                                    case 2:
                                        if (var13 < 2) {
                                            var54 = false;
                                            break label1353;
                                        }

                                        var26.cd[var6] = var51;
                                        var26.ce[var6] = var11;
                                        switch(var33 - 1) {
                                        case 0:
                                            var26.a(var6, var51, var11, var26.aA[var6][4]);
                                            var26.a(var6, var51, var11 - 1, var26.aA[var6][1]);
                                            var26.a(var6, var51 + 1, var13, var26.aA[var6][5]);
                                            var26.a(var6, var51 + 1, var13 - 1, var26.aA[var6][2]);
                                            break label1350;
                                        case 1:
                                            var26.a(var6, var51, var11, var26.aA[var6][2]);
                                            var26.a(var6, var51, var11 - 1, var26.aA[var6][4]);
                                            var26.a(var6, var51 + 1, var13, var26.aA[var6][5]);
                                            var26.a(var6, var51 + 1, var13 - 1, var26.aA[var6][1]);
                                            break label1350;
                                        case 2:
                                            var26.a(var6, var51, var11, var26.aA[var6][2]);
                                            var26.a(var6, var51, var11 - 1, var26.aA[var6][5]);
                                            var26.a(var6, var51 + 1, var13, var26.aA[var6][1]);
                                            var26.a(var6, var51 + 1, var13 - 1, var26.aA[var6][4]);
                                            break label1350;
                                        case 3:
                                            var26.a(var6, var51, var11, var26.aA[var6][1]);
                                            var26.a(var6, var51, var11 - 1, var26.aA[var6][2]);
                                            var26.a(var6, var51 + 1, var13, var26.aA[var6][4]);
                                            var26.a(var6, var51 + 1, var13 - 1, var26.aA[var6][5]);
                                        default:
                                            break label1350;
                                        }
                                    case 3:
                                        if (var13 < 2) {
                                            var54 = false;
                                            break label1353;
                                        }

                                        if (var33 == 1) {
                                            var14 = var26.aA[var6][4];
                                        } else if ((var14 = (byte)(var26.cg[var6] + 1)) > var26.aZ[var6]) {
                                            var14 = 1;
                                        }

                                        var26.cg[var6] = var14;
                                        var26.cd[var6] = var51;
                                        var26.ce[var6] = var11;
                                        var26.a(var6, var51, var11, var14);
                                        var26.a(var6, var51, var11 - 1, var14);
                                        var26.a(var6, var51 + 1, var13, var14);
                                        var26.a(var6, var51 + 1, var13 - 1, var14);
                                    }

                                    var54 = true;
                                }
                            } else {
                                var54 = false;
                            }

                            if (!var54) {
                                break;
                            }

                            var26.cL[var6][0] = -100000000;
                            var26.cK[var6][0] = false;
                            var26.cL[var6][1] = -100000000;
                            var26.cK[var6][1] = false;
                            var26.cG[var6] = 4;
                        }
                    case 4:
                        var26.cR[var6] = false;
                        var10000 = var26.cS;
                        var8 = var6;
                        var7 = var26;
                        boolean var31 = false;
                        var14 = 0;
                        var26.df[var6] = 0;

                        int var52;
                        byte var56;
                        int var17;
                        boolean var40;
                        while(true) {
                            if (!var7.b(var8, true)) {
                                var56 = var14;
                                break;
                            }

                            var7.a(var8, var7.cq[var8]);
                            ++var14;
                            int[] var55 = var7.df;
                            int var10004 = var55[var8];
                            var7.bj[var8] = var7.d(var8, var14);
                            if ((var52 = (var7.bh[var8] + var7.bi[var8]) * (var7.bj[var8] + var7.bk[var8] + var7.bl[var8])) > 99999999) {
                                var52 = 99999999;
                            }

                            var55[var8] = var10004 + (var7.bo[var8] + var52) / var7.p();
                            var40 = false;

                            for(var12 = 0; var12 < 6; ++var12) {
                                var17 = 13;
                                boolean var35 = false;

                                for(var13 = 13; var13 >= 0; --var13) {
                                    var48 = var12 + var13 * 6;
                                    byte var15 = var7.cq[var8][var48];
                                    if (!var35 && var15 == 0) {
                                        var17 = var13;
                                        var35 = true;
                                    } else if (var35 && var15 != 0) {
                                        var31 = true;
                                        var7.cq[var8][var12 + var17 * 6] = var7.cq[var8][var48];
                                        var7.cq[var8][var48] = 0;
                                        --var17;
                                        var13 = var17;
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
                            if ((var26.cx[var6] & 1024) > 0) {
                                var8 = var6;
                                var7 = var26;
                                var37 = 0;

                                label1291:
                                while(true) {
                                    if (var37 >= 12) {
                                        var7.cR[var8] = true;
                                        break;
                                    }

                                    for(var34 = 0; var34 < 6; ++var34) {
                                        if (var7.cq[var8][var34 + var37 * 6] != 0) {
                                            break label1291;
                                        }
                                    }

                                    ++var37;
                                }
                            }

                            var26.cK[var6][1] = true;
                            var26.cL[var6][1] = var26.df[var6];
                        } else if (!var26.k(var6)) {
                            var11 = var6;
                            a var39 = var26;
                            var48 = 10000000;
                            boolean[] var41 = var26.ct;
                            var31 = false;

                            for(var34 = 0; var34 < var41.length; ++var34) {
                                var41[var34] = false;
                            }

                            for(var18 = 2; var18 < 14; ++var18) {
                                for(var17 = 0; var17 < 6; ++var17) {
                                    var46 = var17 + var18 * 6;
                                    byte var50 = var39.cq[var11][var46];
                                    short var49 = var39.dS[var11][var46];
                                    if (var50 != 0 && var50 != 6 && !var39.ct[var46]) {
                                        var39.cu[0] = (byte)var46;
                                        var39.ct[var46] = true;
                                        var39.cw[var11] = 1;

                                        for(var12 = 0; var12 < var39.cw[var11]; ++var12) {
                                            byte var22;
                                            int var19 = (var22 = var39.cu[var12]) % 6;
                                            int var20 = var22 / 6;
                                            if ((var39.cr[var11][var22] & 1) > 0 && (var34 = var20 + 1) < 14) {
                                                var39.c(var11, var22, var19 + var34 * 6);
                                            }

                                            if ((var39.cr[var11][var22] & 2) > 0 && (var34 = var20 - 1) >= 0) {
                                                var39.c(var11, var22, var19 + var34 * 6);
                                            }

                                            if ((var39.cr[var11][var22] & 4) > 0) {
                                                var52 = var19 + 1;
                                                if (var52 < 6) {
                                                    var39.c(var11, var22, var52 + var20 * 6);
                                                }
                                            }

                                            if ((var39.cr[var11][var22] & 8) > 0) {
                                                var52 = var19 - 1;
                                                if (var52 >= 0) {
                                                    var39.c(var11, var22, var52 + var20 * 6);
                                                }
                                            }

                                            for(var34 = 0; var34 < 3; ++var34) {
                                                if ((var20 = var18 + var34 + 1) < 14) {
                                                    if ((var19 = var17 + 1) < 6 && var39.cq[var11][var19 + var20 * 6] == var50) {
                                                        var48 += 1024;
                                                        if ((var39.cr[var11][var46] & 12) == 0) {
                                                            var48 += 256;
                                                        }
                                                    }

                                                    if ((var19 = var17 - 1) >= 0 && var39.cq[var11][var19 + var20 * 6] == var50) {
                                                        var48 += 1024;
                                                        if ((var39.cr[var11][var46] & 12) == 0) {
                                                            var48 += 256;
                                                        }
                                                    }
                                                }
                                            }
                                        }

                                        var48 -= 50 - var49 << 8;
                                    }
                                }

                                var48 -= var39.cw[var11] * 100;
                            }

                            label1239: {
                                var34 = var48;
                                var10000 = var26.cq[var6];
                                var23 = 2;
                                var21 = true;
                                if (var10000[2 + var23 * 6] == 0) {
                                    var10000 = var26.cq[var6];
                                    var23 = 2;
                                    var21 = true;
                                    if (var10000[3 + var23 * 6] == 0) {
                                        break label1239;
                                    }
                                }

                                var34 = var48 - 1000000;
                            }

                            label1234: {
                                var10000 = var26.cq[var6];
                                var23 = 2;
                                var21 = true;
                                if (var10000[1 + var23 * 6] == 0) {
                                    var10000 = var26.cq[var6];
                                    var23 = 2;
                                    var21 = true;
                                    if (var10000[4 + var23 * 6] == 0) {
                                        break label1234;
                                    }
                                }

                                var34 -= 500000;
                            }

                            var26.cK[var6][0] = true;
                            var26.cL[var6][0] = var34;
                        }

                        byte var43 = 0;
                        var37 = 0;
                        if (!var26.cD[var6] || var26.cS[var6] != 0) {
                            if (var26.cS[var6] > 0) {
                                if ((var26.cx[var6] & 16) > 0) {
                                    var26.cD[var6] = true;
                                }

                                var43 = 1;
                                if (var26.cR[var6]) {
                                    var37 = 1;
                                } else if ((var37 = var26.cS[var6] + 1) > 16) {
                                    var37 = 16;
                                }

                                if (var26.cE[var6] > 0 && (var26.cx[var6] & 64) > 0) {
                                    var58 = var26.cL[var6];
                                    var58[1] += Math.abs(var26.s.nextInt() % (var26.cy[var6] / 10));
                                }
                            } else if (var26.cE[var6] > 0 && (var26.cx[var6] & 64) > 0) {
                                var58 = var26.cL[var6];
                                var58[0] -= Math.abs(var26.s.nextInt() % var26.cy[var6]) * 100;
                            }

                            var40 = false;
                            if (var26.cM[var6][var37] >= var26.cL[var6][var43] && var26.cN[var6][var37]) {
                                if (var26.cM[var6][var37] == var26.cL[var6][var43]) {
                                    Math.abs(var26.s.nextInt());
                                }
                            } else {
                                var40 = true;
                            }

                            if (var40) {
                                if (!var26.cD[var6]) {
                                    var26.cN[var6][var37] = true;
                                }

                                var26.cM[var6][var37] = var26.cL[var6][var43];
                                var26.cO[var6][var37] = var26.cA[var6];
                                var10000 = var26.cP[var6];
                                var18 = var26.cd[var6];
                                var53 = var26.ce[var6];
                                var10000[var37] = (byte)(var18 + var53 * 6);
                                var26.cQ[var6][var37] = var26.cS[var6];
                            }
                        }

                        var10003 = var26.cF[var6]++;
                        var26.cG[var6] = 3;
                        var26.a(var6, false);
                    case 2:
                    }
                }
            }
        }

        int var10001;
        char var32;
        int var25;
        byte var36;
        boolean var24;
        boolean var29;
        switch(this.ak[var1]) {
        case 0:
            var10000 = this.aM[var1];
            var23 = 2;
            var21 = true;
            if (var10000[2 + var23 * 6] == 0) {
                var10000 = this.aM[var1];
                var23 = 2;
                var21 = true;
                if (var10000[3 + var23 * 6] == 0) {
                    if (!this.bJ[var1]) {
                        this.ak[var1] = 1;
                        return;
                    }

                    if (this.bI[var1] == 0) {
                        if (this.ah == 2) {
                            this.cU[var1] = true;
                            return;
                        }

                        this.ak[var1] = 15;
                        return;
                    }

                    if (this.bf[var1] == -1) {
                        this.ak[var1] = 1;
                        return;
                    }

                    if ((var2 = this.bf[var1] + 1) >= 2) {
                        if (this.ah == 2) {
                            var58 = this.bI;
                            var58[var1] += (var2 - 2) * 1000;
                            var32 = '';
                        } else {
                            var58 = this.bI;
                            var58[var1] += (var2 - 2) * 500;
                            var32 = 30000;
                        }

                        if (this.bI[var1] > var32) {
                            this.bI[var1] = var32;
                        }
                    }

                    ++var2;
                    if (this.bN[var1]) {
                        var2 += 2;
                    }

                    var3 = Math.max(3, this.bP[var1] - 2);
                    if (var2 < var3) {
                        var2 = var3;
                    } else if (var2 > 15) {
                        var2 = 15;
                    }

                    this.bP[var1] = var2;
                    this.a(this.dU, (this.bP[var1] - 3 << 2) + Math.abs(this.s.nextInt()) % 4, var1);

                    for(var2 = 0; var2 < 84; ++var2) {
                        this.aV[var1][var2] = 0;
                    }

                    this.ak[var1] = 20;
                    return;
                }
            }

            this.cU[var1] = true;
            return;
        case 1:
            var58 = this.an;
            var58[var1] += this.r;
            this.aF[var1][0] = var2 - var4 * this.an[var1] / 50;
            this.aG[var1][0] = var3 - 13 * this.an[var1] / 50;
            this.aF[var1][1] = var2 + var4;
            this.aG[var1][1] = var3 + 13;
            if (this.an[var1] >= 50) {
                this.N[var1] = true;
                this.an[var1] = 0;
                this.ak[var1] = 2;

                for(var5 = 0; var5 < 9; ++var5) {
                    this.aA[var1][var5] = this.aC[var1][0][var5];
                }

                this.au[var1] = this.av[var1][0];
                this.b(var1);
                this.aF[var1][0] = var2 + var4;
                this.aG[var1][0] = var3 + 13;
                this.aF[var1][1] = var2 + (var4 << 1);
                this.aG[var1][1] = var3 + 26;
                return;
            }
            break;
        case 2:
            var58 = this.an;
            var58[var1] += this.r;

            for(var5 = 0; var5 < 2; ++var5) {
                this.aF[var1][var5] = var2 + var4 * (var5 + 1) - var4 * this.an[var1] / 100;
                this.aG[var1][var5] = var3 + 13 * (var5 + 1) - 13 * this.an[var1] / 100;
            }

            if (this.an[var1] >= 100) {
                this.N[var1] = true;
                this.an[var1] = 0;
                this.aF[var1][0] = var2;
                this.aG[var1][0] = var3;
                this.aF[var1][1] = var2 + var4;
                this.aG[var1][1] = var3 + 13;
                this.am[var1] = 0;
                this.ao[var1] = 0;
                this.aq[var1] = 0;
                this.bf[var1] = -1;
                this.bh[var1] = this.bi[var1] = this.bj[var1] = this.bk[var1] = this.bl[var1] = 0;
                this.bn[var1] = 0;
                this.bo[var1] = 0;
                this.bL[var1] = false;
                this.bN[var1] = false;
                this.aS[var1] = false;
                this.i(var1);
                if (this.cc[var1] == -1) {
                    this.ak[var1] = 3;
                    return;
                }

                this.ak[var1] = 22;
                return;
            }
            break;
        case 4:
            var58 = this.an;
            var58[var1] += this.r;
            if (this.an[var1] >= 25) {
                this.h(var1);
                this.an[var1] = 0;
                if (this.g(var1) == 2) {
                    this.ak[var1] = 5;
                }

                this.a(var1, false);
                return;
            }
            break;
        case 5:
            var58 = this.an;
            var58[var1] += this.r;
            if (this.an[var1] >= 200) {
                this.an[var1] = 0;
                if (this.g(var1) == 0) {
                    var29 = true;
                    var6 = var1;
                    var26 = this;

                    for(var8 = 0; var8 < 6; ++var8) {
                        for(var34 = 0; var34 < 14; ++var34) {
                            var37 = var8 + var34 * 6;
                            var26.cq[var6][var37] = var26.aM[var6][var37];
                        }
                    }

                    if (var26.b(var6, true)) {
                        var10003 = this.bf[var1]++;
                        var24 = false;
                        this.ak[var1] = 6;
                        if (var1 == 0) {
                            this.L[var1] = true;
                        }

                        this.aS[var1] = true;
                        if (this.bf[var1] > this.bp[var1]) {
                            this.bp[var1] = this.bf[var1];
                        }

                        this.bj[var1] = this.d(var1, this.bf[var1]);
                        this.bn[var1] = (this.bh[var1] + this.bi[var1]) * (this.bj[var1] + this.bk[var1] + this.bl[var1]);
                        if (this.ah == 2) {
                            var58 = this.bn;
                            var58[var1] *= this.aj;
                        }

                        var58 = this.bm;
                        var58[var1] += this.bn[var1];
                        if (this.bm[var1] > 99999999) {
                            this.bm[var1] = 99999999;
                        }

                        this.bX[var1] = (this.bo[var1] + this.bn[var1]) / this.p();

                        for(var5 = 0; var5 < 3; ++var5) {
                            this.bY[var1][var5] = 0;
                        }

                        var5 = this.bU[var1] + this.bV[var1];
                        if (this.bW[var1] == 0 && var5 == 0) {
                            this.bL[var1] = false;
                            return;
                        }

                        this.bL[var1] = true;
                        if (var5 > 0) {
                            if (this.bU[var1] > 0) {
                                this.bY[var1][0] = Math.min(this.bU[var1], this.bX[var1]);
                                var58 = this.bX;
                                var58[var1] -= this.bY[var1][0];
                            }

                            if (this.bV[var1] > 0 && this.bX[var1] > 0) {
                                this.bY[var1][1] = Math.min(this.bV[var1], this.bX[var1]);
                                var58 = this.bX;
                                var58[var1] -= this.bY[var1][1];
                            }
                        }

                        if (this.bW[var1] > 0 && this.bX[var1] > 0) {
                            this.bY[var1][2] = Math.min(this.bW[var1], this.bX[var1]);
                            var58 = this.bX;
                            var58[var1] -= this.bY[var1][2];
                        }

                        if (var1 == 0) {
                            var36 = 1;
                        } else {
                            var36 = 0;
                        }

                        if (!this.bJ[var36]) {
                            var58 = this.bI;
                            var58[var36] += 1000;
                            if (this.bI[var36] > 30000) {
                                this.bI[var36] = 30000;
                                return;
                            }
                        }
                    } else {
                        this.ak[var1] = 8;
                        if (var1 == 0) {
                            this.L[var1] = true;
                            return;
                        }
                    }
                } else {
                    this.a(var1, false);
                    this.ak[var1] = 4;
                    if (var1 == 0) {
                        this.L[var1] = true;
                        return;
                    }
                }
            }
            break;
        case 6:
            var58 = this.an;
            var58[var1] += this.r;
            if (this.an[var1] >= 200) {
                this.an[var1] = 0;
                this.ak[var1] = 7;
                var24 = false;
                if (var1 == 0) {
                    var58 = this.bV;
                    var58[1] += this.bX[var1];
                } else {
                    var58 = this.bV;
                    var58[0] += this.bX[var1];
                }

                if (this.bL[var1]) {
                    var58 = this.bU;
                    var58[var1] -= this.bY[var1][0];
                    var58 = this.bV;
                    var58[var1] -= this.bY[var1][1];
                    var58 = this.bW;
                    var58[var1] -= this.bY[var1][2];
                    return;
                }
            }
            break;
        case 7:
            var58 = this.an;
            var58[var1] += this.r;
            if (this.an[var1] >= 200) {
                if (this.bL[var1] && !this.bJ[var1]) {
                    var10003 = this.bG[var1]++;
                    if (this.bG[var1] >= 7) {
                        this.bG[var1] = 7;
                    }
                }

                this.bn[var1] = 0;
                this.bo[var1] = 0;
                this.bh[var1] = this.bi[var1] = this.bj[var1] = this.bk[var1] = this.bl[var1] = 0;
                this.bX[var1] = 0;

                for(var5 = 0; var5 < 3; ++var5) {
                    this.bY[var1][var5] = 0;
                }

                this.an[var1] = 0;
                this.a(var1, this.aM[var1]);
                if (this.g(var1) == 1) {
                    this.ak[var1] = 4;
                } else {
                    this.ak[var1] = 8;
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
                if (this.aM[var1][var5] != 0) {
                    this.aM[var1][var5] = 0;
                    var24 = true;
                }
            }

            if (var24) {
                this.a(var1, false);
                this.Q[var1] = true;
            }

            if (var1 == 0) {
                var36 = 1;
            } else {
                var36 = 0;
            }

            var58 = this.bU;
            var58[var36] += this.bV[var36];
            this.bV[var36] = 0;
            if (this.bI[var1] == 0) {
                if (this.ah == 2) {
                    this.cU[var1] = true;
                    this.ak[var1] = 0;
                } else {
                    this.ak[var1] = 15;
                }
            }

            this.bN[var1] = true;

            for(var3 = 0; var3 < 6; ++var3) {
                var10000 = this.aM[var1];
                var23 = 13;
                if (var10000[var3 + var23 * 6] != 0) {
                    this.bN[var1] = false;
                    break;
                }
            }

            if (!this.bJ[var1] && this.bG[var1] == 7) {
                this.bJ[var1] = true;
                if (var1 == 0) {
                    ++this.br;
                }

                this.ak[var1] = 14;
                this.L[var1] = true;
                if (this.bN[var1]) {
                    var58 = this.bP;
                    var58[var1] += 2;
                    if (this.bP[var1] > 15) {
                        this.bP[var1] = 15;
                    }
                }

                this.a(this.dU, (this.bP[var1] - 3 << 2) + Math.abs(this.s.nextInt()) % 4, var1);
                this.bW[var1] = this.bU[var1] + this.bV[var1];
                this.bU[var1] = this.bV[var1] = 0;

                for(var3 = 0; var3 < 84; ++var3) {
                    this.aO[var1][var3] = this.aM[var1][var3];
                    this.aM[var1][var3] = 0;
                    this.aV[var1][var3] = 0;
                    this.aR[var1][var3] = 0;
                }
            } else if (this.bU[var1] > 0 && !this.aS[var1]) {
                this.ak[var1] = 13;
                if (this.bU[var1] > 30) {
                    var3 = 30;
                } else {
                    var3 = this.bU[var1];
                }

                var58 = this.bU;
                var58[var1] -= var3;

                for(var2 = 0; var2 < 84; ++var2) {
                    this.aP[var1][var2] = 0;
                    this.aX[var1][var2] = 2;
                }

                var2 = var3 / 6;
                var3 %= 6;

                for(var25 = 0; var25 < 6; ++var25) {
                    this.bZ[var1][var25] = var2;
                }

                for(var25 = 0; var25 < 6; ++var25) {
                    if (var25 < var3) {
                        var5 = (this.ca + var25) % 6;
                        var10003 = this.bZ[var1][dy[var5]]++;
                    }
                }

                var25 = 0;

                while(true) {
                    if (var25 >= 6) {
                        this.ca = (this.ca + var3) % 6;
                        this.aQ[var1] = 13;
                        break;
                    }

                    for(var2 = 0; var2 < this.bZ[var1][var25]; ++var2) {
                        var10000 = this.aP[var1];
                        var53 = 13 - var2;
                        var10000[var25 + var53 * 6] = 6;
                    }

                    ++var25;
                }
            } else if (this.bJ[var1] && this.bf[var1] != -1) {
                this.ak[var1] = 21;
                var2 = this.bf[var1] + 1;
                if (var1 == 0) {
                    this.de = false;
                    if (var2 >= this.bP[var1]) {
                        this.de = true;
                    }
                }
            } else {
                this.ak[var1] = 0;
            }

            if (this.bN[var1]) {
                if (this.ah == 2) {
                    if (!this.cU[var1]) {
                        var58 = this.bI;
                        var58[var1] += 3000;
                    }
                } else if (this.bI[var1] != 0) {
                    var58 = this.bI;
                    var58[var1] += 5000;
                }

                if (this.ah == 2) {
                    var32 = '';
                } else {
                    var32 = 30000;
                }

                if (this.bI[var1] > var32) {
                    this.bI[var1] = var32;
                }

                if (!this.bJ[var1]) {
                    this.a(this.dU, 4 + Math.abs(this.s.nextInt()) % 4, var1);

                    for(var2 = 0; var2 < 84; ++var2) {
                        this.aV[var1][var2] = 0;
                    }

                    this.ak[var1] = 20;
                }

                var10003 = this.bM[var1]++;
                return;
            }
            break;
        case 9:
            if (this.an[var1] < 1000) {
                var58 = this.an;
                var58[var1] += 80;
                return;
            }

            if (var1 == 0) {
                this.v = 7;
                return;
            }

            this.v = 6;
            break;
        case 11:
        case 18:
            var58 = this.an;
            var58[var1] += this.r;
            if (this.an[var1] >= 200) {
                this.an[var1] = 0;
                if (this.g(var1) == 0) {
                    if (this.ak[var1] == 11) {
                        this.ak[var1] = 12;
                    } else {
                        this.a(var1, false);
                        this.ak[var1] = 19;
                    }

                    this.an[var1] = 0;
                } else if (this.ak[var1] == 11) {
                    this.ak[var1] = 13;
                } else {
                    this.ak[var1] = 20;
                }

                if (var1 == 0) {
                    this.L[var1] = true;
                    return;
                }
            }
            break;
        case 12:
        case 19:
            var58 = this.an;
            var58[var1] += this.r;
            if (this.an[var1] >= 50) {
                if (!this.bJ[var1]) {
                    this.ak[var1] = 0;
                    return;
                }

                this.ak[var1] = 1;
                var10000 = this.aM[var1];
                var23 = 2;
                var21 = true;
                if (var10000[2 + var23 * 6] == 0) {
                    var10000 = this.aM[var1];
                    var23 = 2;
                    var21 = true;
                    if (var10000[3 + var23 * 6] == 0) {
                        return;
                    }
                }

                this.cU[var1] = true;
                return;
            }
            break;
        case 13:
        case 20:
            var24 = false;
            if (this.aQ[var1] >= 0) {
                for(var3 = 0; var3 < 6; ++var3) {
                    var10000 = this.aP[var1];
                    var53 = this.aQ[var1];
                    if (var10000[var3 + var53 * 6] != 0) {
                        var24 = true;
                        break;
                    }
                }

                if (var24) {
                    this.j(var1);

                    for(var3 = 0; var3 < 6; ++var3) {
                        if (this.cT[var1][var3] > 0) {
                            var10000 = this.aM[var1];
                            var23 = 1;
                            var10001 = var3 + var23 * 6;
                            var10002 = this.aP[var1];
                            var53 = this.aQ[var1];
                            var10000[var10001] = var10002[var3 + var53 * 6];
                        }
                    }
                }
            }

            var10003 = this.aQ[var1]--;
            if (this.ak[var1] == 13) {
                this.ak[var1] = 10;
            } else {
                this.ak[var1] = 17;
            }

            this.g(var1);
        case 10:
        case 17:
            var58 = this.an;
            var58[var1] += this.r;
            if (this.an[var1] >= 25) {
                this.h(var1);
                this.an[var1] = 0;
                if (this.g(var1) != 2) {
                    if (this.aQ[var1] >= 0) {
                        if (this.ak[var1] == 10) {
                            this.ak[var1] = 13;
                            return;
                        }

                        this.ak[var1] = 20;
                        return;
                    }

                    if (this.ak[var1] == 10) {
                        this.ak[var1] = 11;
                        return;
                    }

                    this.ak[var1] = 18;
                    this.Q[var1] = true;
                    return;
                }

                if (var1 == 0) {
                    this.L[var1] = true;
                }

                if (this.ak[var1] == 10) {
                    this.ak[var1] = 11;
                } else {
                    this.ak[var1] = 18;
                    this.Q[var1] = true;
                }

                if (this.bJ[var1] && this.bK[var1]) {
                    this.bK[var1] = false;
                    this.L[var1] = true;
                }

                if (this.bN[var1]) {
                    this.L[var1] = true;
                }

                if (var1 == 0) {
                    this.de = false;
                    this.L[var1] = true;
                    return;
                }
            }
            break;
        case 14:
            this.ak[var1] = 20;
            this.bK[var1] = true;
            this.a(9);
            return;
        case 15:
            this.ak[var1] = 0;
            this.bJ[var1] = false;
            if (this.ah == 0 && var1 == 0) {
                this.bG[var1] = 3;
            } else {
                this.bG[var1] = 0;
            }

            this.bI[var1] = 15000;
            var58 = this.bU;
            var58[var1] += this.bW[var1];

            for(var3 = 0; var3 < 84; ++var3) {
                this.aM[var1][var3] = this.aO[var1][var3];
                this.a(var1, false);
            }

            this.L[var1] = true;
            this.j(var1);
            this.f();
            return;
        case 16:
        default:
            break;
        case 21:
            if (this.an[var1] < 1000) {
                var58 = this.an;
                var58[var1] += 80;
                return;
            }

            for(var3 = 0; var3 < 84; ++var3) {
                this.aM[var1][var3] = 0;
                this.aV[var1][var3] = 0;
                this.aR[var1][var3] = 0;
            }

            this.ak[var1] = 0;
            this.an[var1] = 0;
            if (this.bN[var1]) {
                this.L[var1] = true;
            }

            if (var1 == 0) {
                this.de = false;
                this.L[var1] = true;
                return;
            }
            break;
        case 22:
            var6 = var1;
            var26 = this;
            if (this.cG[var1] != 0) {
                var54 = false;
            } else if (!this.cH[var1]) {
                this.i(var1);
                var54 = false;
            } else {
                if (this.cN[var1][1]) {
                    var8 = 1;
                } else {
                    this.l(var1);
                    var37 = 0;

                    for(var25 = 0; var25 < 6; ++var25) {
                        var37 += var26.cT[var6][var25];
                    }

                    var34 = var26.ci[var6];
                    if (var26.bJ[var6]) {
                        if ((var34 = var26.bP[var6]) >= 5) {
                            --var34;
                        }

                        if (var26.dg[var6] > 2) {
                            --var34;
                        }

                        if (var26.dg[var6] > 4) {
                            --var34;
                        }

                        if (var26.dg[var6] > 5) {
                            var26.cE[var6] = 1;
                        }

                        if (var26.dg[var6] > 6) {
                            var26.cE[var6] = 2;
                        }

                        if (var34 < 0) {
                            var34 = 1;
                        }
                    } else if (var37 > 48) {
                        ++var34;
                    }

                    var8 = var26.e(var6, var34);
                    if (var26.cP[var6][var8] == -1) {
                        var8 = var26.e(var6, 1);
                    } else if (var26.bU[var6] > 0 && (var26.cx[var6] & 512) > 0 && !var26.bJ[var6]) {
                        var8 = var26.f(var6, 1);
                    }
                }

                if (var26.cE[var6] == 1) {
                    var8 = var26.f(var6, 2);
                }

                if (var26.cE[var6] >= 2) {
                    var8 = var26.f(var6, 1);
                }

                if (var26.cP[var6][var8] == -1 && var26.cP[var6][0] != -1) {
                    var8 = 0;
                }

                var26.cf[var6] = var26.cO[var6][var8] - 1;
                var26.cd[var6] = var26.cP[var6][var8] % 6;
                var26.ce[var6] = var26.cP[var6][var8] / 6;
                if (var26.cP[var6][var8] == -1) {
                    var26.cf[var6] = 0;
                    var26.cg[var6] = var26.aA[var6][1];
                    var26.cd[var6] = 2;
                    var26.cd[var6] = 1;
                }

                if (var26.bJ[var6]) {
                    ++var26.dg[var6];
                }

                var26.cH[var6] = false;
                var54 = true;
            }

            if (!var54) {
                break;
            }

            this.ak[var1] = 3;
        case 3:
            var6 = var1;
            var26 = this;
            var29 = false;
            this.aH[var1] = this.aJ[var1];
            this.aI[var1] = this.aK[var1];
            this.ay[var1] = this.ax[var1];

            for(var11 = 0; var11 < 9; ++var11) {
                var26.az[var6][var11] = var26.aA[var6][var11];
            }

            label1456: {
                switch(var26.am[var6]) {
                case 0:
                    var26.ax[var6] = 0;
                    var26.aJ[var6] = 2;
                    var26.aK[var6] = 1;
                    short var42;
                    if (var26.ah == 2) {
                        var42 = dE[var26.cp[var6]];
                    } else {
                        var42 = dD[var26.cp[var6]];
                    }

                    var26.ap[var6] = 4266 / var42;
                    var26.am[var6] = 1;
                    var26.ao[var6] = 0;
                    var26.f(var6);
                    var26.at[var6] = 0;
                case 1:
                    break;
                case 2:
                    for(var8 = 0; var8 < 6; ++var8) {
                        var26.aY[var6][var8] = 2;
                    }

                    for(var8 = 0; var8 < 3; ++var8) {
                        for(var34 = 0; var34 < 3; ++var34) {
                            if ((var33 = var26.aA[var6][var8 + var34 * 3]) != 0) {
                                var10000 = var26.aM[var6];
                                var10001 = var26.a(var6, var8);
                                var53 = var26.aK[var6] - 1 + var34;
                                var10000[var10001 + var53 * 6] = var33;
                                var26.aY[var6][var26.a(var6, var8)] = 0;
                                var26.aA[var6][var8 + var34 * 3] = 0;
                            }
                        }
                    }

                    var26.e(var6);
                    var26.aJ[var6] = 2;
                    var26.aK[var6] = 1;
                    var26.aD[var6] = var26.Y + dz[var6] + (var26.aJ[var6] - 1) * 11;
                    var26.aE[var6] = var26.aa + 40 + (var26.aK[var6] - 1) * 9;
                    var29 = true;
                default:
                    break label1456;
                }

                label1460: {
                    var58 = var26.aq;
                    var58[var6] += var26.r;
                    switch(var26.ao[var6]) {
                    case 0:
                        break;
                    case 1:
                        if (var26.d(var6)) {
                            if (var26.aq[var6] == 0) {
                                var10003 = var26.aK[var6]--;
                            } else {
                                var26.aq[var6] = 0;
                            }

                            var26.ao[var6] = 2;
                            var26.as[var6] = 0;
                            ++var26.at[var6];
                        } else {
                            var26.ao[var6] = 0;
                        }

                        var58 = var26.ar;
                        var58[var6] += var26.r;
                        if (var26.ar[var6] >= 0) {
                            if (var26.d(var6)) {
                                if (var26.aq[var6] == 0) {
                                    var10003 = var26.aK[var6]--;
                                } else {
                                    var26.aq[var6] = 0;
                                }

                                var26.ao[var6] = 2;
                                var26.as[var6] = 0;
                            } else {
                                var26.ao[var6] = 0;
                            }
                        }
                        break label1460;
                    case 2:
                        if (var26.c(var6)) {
                            var26.ao[var6] = 0;
                            break;
                        } else {
                            var26.aq[var6] = 0;
                            var58 = var26.as;
                            var58[var6] += var26.r;
                            if (var26.as[var6] < 800 && var26.at[var6] < 8) {
                                break;
                            }

                            var26.am[var6] = 2;
                        }
                    default:
                        break label1460;
                    }

                    if (var26.aq[var6] >= var26.ap[var6]) {
                        var26.aq[var6] = 0;
                        var10003 = var26.aK[var6]++;
                        if (!var26.c(var6)) {
                            if (var26.d(var6)) {
                                var10003 = var26.aK[var6]--;
                            }

                            var26.ao[var6] = 2;
                            var26.as[var6] = 0;
                            ++var26.at[var6];
                            break label1460;
                        }
                    }

                    if (var26.d(var6)) {
                        if (var26.aq[var6] == 0) {
                            var10003 = var26.aK[var6]--;
                        } else {
                            var26.aq[var6] = 0;
                        }

                        var26.ao[var6] = 2;
                        var26.as[var6] = 0;
                        ++var26.at[var6];
                    }

                    var26.cb[var6] = 0;
                    if (var26.cc[var6] == -1) {
                        if ((var26.j & 16) != 0) {
                            var26.cb[var6] = 1;
                        } else if ((var26.j & 1) != 0) {
                            var26.cb[var6] = 2;
                        } else if ((var26.j & 2) != 0) {
                            var26.cb[var6] = 3;
                        } else if ((var26.j & 8) != 0) {
                            var26.cb[var6] = 4;
                        } else if ((var26.k & 4) != 0) {
                            var26.cb[var6] = 5;
                        }
                    } else {
                        if (var26.l(var6) > 0) {
                            var46 = (var26.ck[var6] + var26.cn[var6] / 2) * var26.co[var6] / 100;
                            var48 = var26.cj[var6] * var26.co[var6] / 100;
                        } else {
                            var46 = var26.ck[var6] + var26.cn[var6] / 2;
                            var48 = var26.cj[var6];
                        }

                        if (var46 > var26.cm[var6]) {
                            var58 = var26.cm;
                            var58[var6] += var26.r;
                        } else {
                            var26.cb[var6] = 5;
                            var26.cm[var6] = 0;
                        }

                        if (var48 > var26.cl[var6]) {
                            var58 = var26.cl;
                            var58[var6] += var26.r;
                        } else {
                            var26.cl[var6] = 0;
                            if (var26.aK[var6] > var26.ce[var6] && var26.aK[var6] < 10) {
                                var26.cb[var6] = 5;
                            }

                            if (var26.aJ[var6] < var26.cd[var6]) {
                                var26.cb[var6] = 4;
                            } else if (var26.aJ[var6] > var26.cd[var6]) {
                                var26.cb[var6] = 3;
                            }

                            if (var26.au[var6] == 3) {
                                var51 = var26.aA[var6][4];
                                if (var26.cg[var6] != var51) {
                                    if ((var26.cg[var6] - var51 + var26.aZ[var6]) % var26.aZ[var6] < var26.aZ[var6] / 2) {
                                        var26.cb[var6] = 1;
                                    } else {
                                        var26.cb[var6] = 2;
                                    }
                                }
                            } else if (var26.ax[var6] != var26.cf[var6]) {
                                if ((var26.ax[var6] - var26.cf[var6] + 4) % 4 > 2) {
                                    var26.cb[var6] = 1;
                                } else {
                                    var26.cb[var6] = 2;
                                }
                            }
                        }
                    }

                    switch(var26.cb[var6]) {
                    case 1:
                        if (var26.au[var6] == 3) {
                            var51 = (byte)(var26.aA[var6][1] + 1);
                            if (var26.aZ[var6] == 5 && var51 > 5 || var26.aZ[var6] == 4 && var51 > 4 || var26.aZ[var6] == 3 && var51 > 3) {
                                var51 = 1;
                            }

                            var26.aA[var6][1] = var51;
                            var26.aA[var6][2] = var51;
                            var26.aA[var6][4] = var51;
                            var26.aA[var6][5] = var51;
                            var26.f(var6);
                        } else if (var26.b(var6, 0)) {
                            var26.ao[var6] = 1;
                            var26.ar[var6] = 0;
                            var26.f(var6);
                            var26.as[var6] = 0;
                        } else if (var26.au[var6] == 0) {
                            ++var26.cY[var6];
                            if (var26.cY[var6] == 2) {
                                var26.cY[var6] = 0;
                                if (var26.b(var6, 2)) {
                                    var26.ao[var6] = 1;
                                    var26.ar[var6] = 0;
                                    var26.f(var6);
                                    var26.as[var6] = 0;
                                }
                            }
                        }
                        break;
                    case 2:
                        if (var26.au[var6] == 3) {
                            if ((var51 = (byte)(var26.aA[var6][1] - 1)) < 1) {
                                if (var26.aZ[var6] == 3) {
                                    var51 = 3;
                                } else if (var26.aZ[var6] == 4) {
                                    var51 = 4;
                                } else {
                                    var51 = 5;
                                }
                            }

                            var26.aA[var6][1] = var51;
                            var26.aA[var6][2] = var51;
                            var26.aA[var6][4] = var51;
                            var26.aA[var6][5] = var51;
                            var26.f(var6);
                        } else if (var26.b(var6, 1)) {
                            var26.ao[var6] = 1;
                            var26.ar[var6] = 0;
                            var26.f(var6);
                            var26.as[var6] = 0;
                        } else if (var26.au[var6] == 0) {
                            ++var26.cY[var6];
                            if (var26.cY[var6] == 2) {
                                var26.cY[var6] = 0;
                                if (var26.b(var6, 2)) {
                                    var26.ao[var6] = 1;
                                    var26.ar[var6] = 0;
                                    var26.f(var6);
                                    var26.as[var6] = 0;
                                }
                            }
                        }
                        break;
                    case 3:
                        if (!var26.a(var6, var26.aJ[var6] - 1, var26.aK[var6])) {
                            var10003 = var26.aJ[var6]--;
                            var26.f(var6);
                        }
                        break;
                    case 4:
                        if (!var26.a(var6, var26.aJ[var6] + 1, var26.aK[var6])) {
                            var10003 = var26.aJ[var6]++;
                            var26.f(var6);
                        }
                        break;
                    case 5:
                        if (var26.ao[var6] == 2) {
                            var26.am[var6] = 2;
                        } else if (var26.c(var6)) {
                            var10003 = var26.aK[var6]++;
                        } else {
                            var26.aq[var6] = var26.ap[var6];
                        }

                        var10003 = var26.bo[var6]++;
                        var10003 = var26.bm[var6]++;
                    }
                }

                var26.aD[var6] = var26.Y + dz[var6] + (var26.aJ[var6] - 1) * 11;
                var26.aE[var6] = var26.aa + 40 + (var26.aK[var6] - 1) * 9;
            }

            if (var26.aH[var6] != var26.aJ[var6] || var26.aI[var6] != var26.aK[var6] || var26.ay[var6] != var26.ax[var6]) {
                var26.M[var6] = true;
            }

            if (var29) {
                this.ak[var1] = 5;
                this.g(var1);
                this.a(var1, false);
                this.an[var1] = 0;
                this.aj = this.ai;
                return;
            }
        }

    }

    private void d(Graphics var1, int var2) {
        int var5 = this.Y + 77 + var2 * 11;
        if (this.ah == 2) {
            var1.setColor(11622577);
            var1.fillRect(var5, this.aa + 59 + ey[0], 11, ey[7]);
        } else {
            var1.setColor(16777215);
            var1.fillRect(var5, this.aa + 59 + ey[0], 11, ey[7]);
            var1.setColor(16750848);

            for(int var6 = 0; var6 < this.bG[var2]; ++var6) {
                int var3 = ey[7 - var6];
                int var4 = ey[7 - var6 - 1];
                var1.fillRect(var5, this.aa + 59 + var4, 11, var3 - var4);
            }
        }

        a(var1, this.puyoGraphics[6], var2 * 11, 0, 11, 43, 0, var5, this.aa + 59, 20);
    }

    private static int o(int var0) {
        return var0 >= 0 ? ez[var0 % 256] : 0;
    }

    private static void a(Graphics var0, Image var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
        var0.drawRegion(var1, var2, var3, var4, var5, var6, var7, var8, var9);
    }
}
