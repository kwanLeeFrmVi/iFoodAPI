package com.ifood.repository;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import redis.clients.jedis.Jedis;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class RedisRepo<T> {
    private Jedis jedis;
    private Class<T> tClass;
    public void startConnection(){
        jedis = new Jedis("TestRedisss.redis.cache.windows.net", 6379);
//        jedis.connect();
        jedis.auth("tFYgxtUAu374UO3YX6wWe4FKhSjhWZlaID55fPQa9J4=");
//        jedis.flushAll();
    }

    public void setToRedis(String key, T value){
        if (jedis!=null){
            jedis.set(key, new Gson().toJson(value));
        }
    }
    public T getFromRedis(String key , Class<T> clssType){
        tClass = clssType;
        T result = null;
        if (jedis!=null ){
            result = new Gson().fromJson(jedis.get(key), tClass);
        }
        return result;
    }
    public List<T> getListFromRedis(String key, Class<T> clssType){
        List<T> result = null;
        if (jedis!=null ){
            result = new ArrayList<>();
            for(String st: jedis.lrange(key, 0,9999999999999L)){
                T tc = new Gson().fromJson(st,clssType);
                result.add(tc);
            }

        }
        return result;
    }

    public List<String> getRawListRedis(String key){
        List<String> result = null;
        if(jedis!=null){
            result = jedis.mget(key);
        }
        return result;

    }
    public void close(){
        jedis.disconnect();
    }

}
