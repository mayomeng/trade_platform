package trade.mayo.zookeeper.configuration.impl;

import com.alibaba.fastjson.JSON;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.server.auth.DigestAuthenticationProvider;
import org.springframework.stereotype.Component;
import trade.mayo.config.BaseConfig;
import trade.mayo.config.impl.RedisConfig;
import trade.mayo.zookeeper.configuration.ConfigurationCenter;
import trade.mayo.zookeeper.configuration.ConfigurationCenterAdapter;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/19.
 */
@Component("RedisConfigurationCenter")
public class RedisConfigurationCenter extends ConfigurationCenterAdapter implements ConfigurationCenter {

    @Override
    public String getNameSpace() {
        return getProperties().getRedisNameSpace();
    }

    @Override
    public List<ACL> getAclList(String auth) throws NoSuchAlgorithmException {
        List<ACL> aclList = new ArrayList<ACL>();
        Id id = new Id(getProperties().getConfigAclScheme(), DigestAuthenticationProvider.generateDigest(auth));
        ACL acl = new ACL(ZooDefs.Perms.ALL, id);
        aclList.add(acl);
        return aclList;
    }

    @Override
    public void updateConfig(BaseConfig config) throws Exception {
        updateConfig(getProperties().getRedisNameSpace(), config, getProperties().getMqAuth());
    }

    @Override
    public RedisConfig getConfig() throws Exception {
        RedisConfig redisConfig = null;
        byte[] config = getConfig(getProperties().getRedisNameSpace());
        if (config != null) {
            redisConfig = JSON.parseObject(new String(config, "UTF-8"), RedisConfig.class);
        }
        return redisConfig;
    }
}
