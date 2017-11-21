package trade.mayo.catche;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/30.
 */
public abstract class CacheAdapter implements CatcheDao{

    @Autowired
    @Qualifier("redisDao")
    private CatcheDao catcheDao;

    public abstract String getCustomKey(String key);
    public abstract String getCustomFieldKey(String field);
    public abstract String[] getCustomFieldKeys(String... fields);

    @Override
    public String get(String key) {
        return catcheDao.get(getCustomKey(key));
    }

    @Override
    public String set(String key, String value) {
        return catcheDao.set(getCustomKey(key), value);
    }

    @Override
    public byte[] getByte(String key) {
        return catcheDao.getByte(getCustomKey(key));
    }

    @Override
    public String setByte(String key, byte[] value) {
        return catcheDao.setByte(getCustomKey(key), value);
    }

    @Override
    public Boolean exists(String key) {
        return catcheDao.exists(getCustomKey(key));
    }

    @Override
    public Long persist(String key) {
        return catcheDao.persist(getCustomKey(key));
    }

    @Override
    public String type(String key) {
        return catcheDao.type(getCustomKey(key));
    }

    @Override
    public Long expire(String key, int seconds) {
        return catcheDao.expire(getCustomKey(key), seconds);
    }

    @Override
    public Long hset(String key, String field, String value) {
        return catcheDao.hset(getCustomKey(key), getCustomFieldKey(field), value);
    }

    @Override
    public String hget(String key, String field) {
        return catcheDao.hget(getCustomKey(key), getCustomFieldKey(field));
    }

    @Override
    public Long hsetnx(String key, String field, String value) {
        return catcheDao.hsetnx(getCustomKey(key), getCustomFieldKey(field), value);
    }

    @Override
    public String hmset(String key, Map<String, String> hash) {
        return catcheDao.hmset(getCustomKey(key), hash);
    }

    @Override
    public List<String> hmget(String key, String... fields) {
        return catcheDao.hmget(getCustomKey(key), getCustomFieldKeys(fields));
    }
}
