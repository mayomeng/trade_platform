package trade.mayo.zookeeper.curator.watcher;

/**
 * Created by Administrator on 2017/10/20.
 */
public interface WatcherContext {
    public void addWathcer(String path, Watcher watcher) throws Exception;
    public void removeWathcer(String path) throws Exception;
}
