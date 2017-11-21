package trade.mayo.zookeeper.configuration;

import org.apache.zookeeper.data.ACL;
import trade.mayo.config.BaseConfig;

import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by Administrator on 2017/10/19.
 */
public interface ConfigurationCenter {
    public String getNameSpace();
    public void updateConfig(BaseConfig config) throws Exception;
    public BaseConfig getConfig() throws Exception;
    public void updateConfig(String configName, BaseConfig config, String auth) throws Exception;
    public byte[] getConfig(String configName) throws Exception;
    public List<ACL> getAclList(String auth) throws NoSuchAlgorithmException;
}
