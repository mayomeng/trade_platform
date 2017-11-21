package trade.mayo.messageQueue;

/**
 * Created by Administrator on 2017/8/29.
 */
public class MessageValue {

    private Object value;

    public MessageValue(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }
}
