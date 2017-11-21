package trade.mayo.zookeeper.curator.watcher;

/**
 * Created by Administrator on 2017/10/20.
 */
public interface Watcher {
    public void callbackHandler(String value);
}
