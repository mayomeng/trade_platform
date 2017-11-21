package trade.mayo.zookeeper.configuration;

import com.alibaba.fastjson.JSON;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.data.Stat;
import org.apache.zookeeper.server.auth.DigestAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import trade.mayo.config.BaseConfig;
import trade.mayo.zookeeper.curator.ZookeeperProperties;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/20.
 */
@EnableConfigurationProperties(ZookeeperProperties.class)
public class ConfigurationCenterAdapter implements ConfigurationCenter {

    @Autowired
    private CuratorFramework client;

    @Autowired
    private ZookeeperProperties zkProperties;

    public CuratorFramework getClient() {
        return client;
    }

    public ZookeeperProperties getProperties() {
        return zkProperties;
    }

    @Override
    public String getNameSpace() {
        return null;
    }

    @Override
    public void updateConfig(BaseConfig config) throws Exception {

    }

    @Override
    public BaseConfig getConfig() throws Exception {
        return null;
    }

    @Override
    public void updateConfig(String configName, BaseConfig config, String auth) throws Exception {

        Stat stat = getClient().checkExists().forPath(configName);
        if (stat != null) {
            client.setData().forPath(configName, JSON.toJSONString(config).getBytes());
        } else {
            client.create().withACL(getAclList(auth)).forPath(configName, JSON.toJSONString(config).getBytes());
        }
    }

    @Override
    public byte[] getConfig(String configName) throws Exception {
        byte[] value = null;

        Stat stat = getClient().checkExists().forPath(configName);
        if (stat != null) {
            value = getClient().getData().forPath(configName);
        }

        return value;
    }

    @Override
    public List<ACL> getAclList(String auth) throws NoSuchAlgorithmException {
        return null;
    }
}
