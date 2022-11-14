package puyo;

import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

public class Puyo extends MIDlet {
    private a a = new a(this);
    private Display b = Display.getDisplay(this);

    public void startApp() {
        this.b.setCurrent(this.a);
        this.a.setFullScreenMode(true);
    }

    public void destroyApp(boolean var1) {
        this.a.a = true;
        this.notifyDestroyed();
    }

    protected void pauseApp() {
    }
}
 