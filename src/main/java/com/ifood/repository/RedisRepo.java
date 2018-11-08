package com.ifood.repository;

import com.google.gson.Gson;
import redis.clients.jedis.Jedis;

import java.lang.reflect.Type;

public class RedisRepo<T> {
    private Jedis jedis;
    private Class<T> tClass;
    public void startConnection(){
        jedis = new Jedis("TestRedisss.redis.cache.windows.net", 6380);
        jedis.connect();
        jedis.auth("tFYgxtUAu374UO3YX6wWe4FKhSjhWZlaID55fPQa9J4=");
        jedis.flushAll();
    }

    public void setToRedis(String key, T value){
        if (jedis!=null){
            jedis.set(key, new Gson().toJson(value));
        }
    }
    public T getFromRedis(String key){
        T result = null;
        if (jedis!=null ){
            result = new Gson().fromJson(jedis.get(key), tClass);
        }
        return result;
    }

}
