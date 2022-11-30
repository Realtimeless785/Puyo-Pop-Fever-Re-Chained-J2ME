import java.util.Date;
import javax.wireless.messaging.BinaryMessage;
import javax.wireless.messaging.TextMessage;

public class XMessage implements TextMessage, BinaryMessage {
    String payloadText;
    String address;
    byte[] payloadData;

    public String getPayloadText() {
        return this.payloadText;
    }

    public void setPayloadText(String arg0) {
        this.payloadText = arg0;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String arg0) {
        this.address = arg0;
    }

    public Date getTimestamp() {
        return new Date();
    }

    public byte[] getPayloadData() {
        return this.payloadData;
    }

    public void setPayloadData(byte[] arg0) {
        this.payloadData = arg0;
    }

    public String toString() {
        return "javax.wireless.messaging.TextMessage";
    }
}
 