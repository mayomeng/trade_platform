package trade.mayo.zookeeper.curator.watcher.impl;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import trade.mayo.zookeeper.curator.watcher.Watcher;
import trade.mayo.zookeeper.curator.watcher.WatcherContext;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/20.
 */
@Component
public class NodeWatcherContext implements WatcherContext {

    @Autowired
    private CuratorFramework client;

    private Map<String, NodeCache> catcheMap;

    @PostConstruct
    public void init() {
        catcheMap = new HashMap<>();
    }

    @Override
    public void addWathcer(String path, Watcher watcher) throws Exception {
        final NodeCache cache = new NodeCache(client, path);
        NodeCacheListener listener = () -> {
            ChildData data = cache.getCurrentData();
            if (null != data) {
                watcher.callbackHandler(new String(cache.getCurrentData().getData()));
            }
        };
        cache.getListenable().addListener(listener);
        cache.start();
        catcheMap.put(path, cache);
    }

    @Override
    public void removeWathcer(String path) throws Exception {
        NodeCache cache = catcheMap.get(path);
        cache.close();
        catcheMap.remove(path);
    }
}
