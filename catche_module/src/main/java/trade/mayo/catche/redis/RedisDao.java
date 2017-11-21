package trade.mayo.catche.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisClusterCommand;
import redis.clients.jedis.JedisClusterConnectionHandler;
import trade.mayo.catche.CatcheDao;

import java.util.List;
import java.util.Map;

@Component("redisDao")
public class RedisDao implements CatcheDao {

    @Autowired
    private JedisClusterConnectionHandler connectionHandler;

    @Override
    public String get(final String key) {
        return new JedisClusterCommand<String>(connectionHandler, RedisConfiguration.DEFAULT_MAX_REDIRECTIONS) {
            @Override
            public String execute(Jedis connection) {
                return connection.get(key);
            }
        }.run(key);
    }

    @Override
    public String set(final String key, final String value) {
        return new JedisClusterCommand<String>(connectionHandler, RedisConfiguration.DEFAULT_MAX_REDIRECTIONS) {
            @Override
            public String execute(Jedis connection) {
                return connection.set(key, value);
            }
        }.run(key);
    }

    @Override
    public byte[] getByte(final String key) {
        return new JedisClusterCommand<byte[]>(connectionHandler, RedisConfiguration.DEFAULT_MAX_REDIRECTIONS) {
            @Override
            public byte[] execute(Jedis connection) {
                return connection.get(key.getBytes());
            }
        }.run(key);
    }

    @Override
    public String setByte(final String key, final byte[] value) {
        return new JedisClusterCommand<String>(connectionHandler, RedisConfiguration.DEFAULT_MAX_REDIRECTIONS) {
            @Override
            public String execute(Jedis connection) {
                return connection.set(key.getBytes(), value);
            }
        }.run(key);
    }

    @Override
    public Boolean exists(final String key) {
        return new JedisClusterCommand<Boolean>(connectionHandler, RedisConfiguration.DEFAULT_MAX_REDIRECTIONS) {
            @Override
            public Boolean execute(Jedis connection) {
                return connection.exists(key);
            }
        }.run(key);
    }

    @Override
    public Long persist(final String key) {
        return new JedisClusterCommand<Long>(connectionHandler, RedisConfiguration.DEFAULT_MAX_REDIRECTIONS) {
            @Override
            public Long execute(Jedis connection) {
                return connection.persist(key);
            }
        }.run(key);
    }

    @Override
    public String type(final String key) {
        return new JedisClusterCommand<String>(connectionHandler, RedisConfiguration.DEFAULT_MAX_REDIRECTIONS) {
            @Override
            public String execute(Jedis connection) {
                return connection.type(key);
            }
        }.run(key);
    }

    @Override
    public Long expire(final String key, final int seconds) {
        return new JedisClusterCommand<Long>(connectionHandler, RedisConfiguration.DEFAULT_MAX_REDIRECTIONS) {
            @Override
            public Long execute(Jedis connection) {
                return connection.expire(key, seconds);
            }
        }.run(key);
    }

    @Override
    public Long hset(final String key, final String field, final String value) {
        return new JedisClusterCommand<Long>(connectionHandler, RedisConfiguration.DEFAULT_MAX_REDIRECTIONS) {
            @Override
            public Long execute(Jedis connection) {
                return connection.hset(key, field, value);
            }
        }.run(key);
    }

    @Override
    public String hget(final String key, final String field) {
        return new JedisClusterCommand<String>(connectionHandler, RedisConfiguration.DEFAULT_MAX_REDIRECTIONS) {
            @Override
            public String execute(Jedis connection) {
                return connection.hget(key, field);
            }
        }.run(key);
    }

    @Override
    public Long hsetnx(final String key, final String field, final String value) {
        return new JedisClusterCommand<Long>(connectionHandler, RedisConfiguration.DEFAULT_MAX_REDIRECTIONS) {
            @Override
            public Long execute(Jedis connection) {
                return connection.hsetnx(key, field, value);
            }
        }.run(key);
    }

    @Override
    public String hmset(final String key, final Map<String, String> hash) {
        return new JedisClusterCommand<String>(connectionHandler, RedisConfiguration.DEFAULT_MAX_REDIRECTIONS) {
            @Override
            public String execute(Jedis connection) {
                return connection.hmset(key, hash);
            }
        }.run(key);
    }

    @Override
    public List<String> hmget(final String key, final String[] fields) {
        return new JedisClusterCommand<List<String>>(connectionHandler, RedisConfiguration.DEFAULT_MAX_REDIRECTIONS) {
            @Override
            public List<String> execute(Jedis connection) {
                return connection.hmget(key, fields);
            }
        }.run(key);
    }
}
