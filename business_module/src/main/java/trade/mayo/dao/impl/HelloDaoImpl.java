package trade.mayo.dao.impl;

import org.springframework.stereotype.Repository;
import trade.mayo.catche.CacheAdapter;
import trade.mayo.dao.HelloDao;

/**
 * Created by Administrator on 2017/6/30.
 */
@Repository
public class HelloDaoImpl extends CacheAdapter implements HelloDao {

    @Override
    public String getCustomKey(String key) {
        return key;
    }

    @Override
    public String getCustomFieldKey(String field) {
        return field;
    }

    @Override
    public String[] getCustomFieldKeys(String... fields) {
        return fields;
    }

    @Override
    public String setUserName(String key, String value) {
        return set(key, value);
    }

    @Override
    public String getUserName(String key) {
        return null;
    }
}
