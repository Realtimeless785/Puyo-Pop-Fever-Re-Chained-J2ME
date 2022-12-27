import java.io.IOException;
import java.io.InterruptedIOException;
import javax.wireless.messaging.Message;
import javax.wireless.messaging.MessageConnection;
import javax.wireless.messaging.MessageListener;

public class XConnection implements MessageConnection {
    public void close() throws IOException {
    }

    public Message newMessage(String s) {
        return null;
    }

    public Message newMessage(String s, String s1) {
        return null;
    }

    public int numberOfSegments(Message message) {
        return 0;
    }

    public Message receive() throws IOException, InterruptedIOException {
        return null;
    }

    public void send(Message message1) throws IOException, InterruptedIOException {
    }

    public void setMessageListener(MessageListener messagelistener1) throws IOException {
    }

    public String toString() {
        return "javax.wireless.messaging.MessageConnection";
    }
}
 