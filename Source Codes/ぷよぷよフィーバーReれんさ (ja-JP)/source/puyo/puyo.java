package puyo;

import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

public class Puyo extends MIDlet {
    private Display a = Display.getDisplay(this);
    private a b = new a(this);

    public Puyo() {
        this.b.setFullScreenMode(true);
    }

    public void startApp() {
        this.a.setCurrent(this.b);
        this.b.showNotify();
    }

    public void pauseApp() {
        this.b.hideNotify();
    }

    public void destroyApp(boolean var1) {
    }

    public final void a() {
        try {
            this.destroyApp(false);
            this.notifyDestroyed();
        } catch (Exception var1) {
        }
    }
}
 