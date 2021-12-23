package com.datastructureexercises.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Transaction;

import java.util.List;
import java.util.Set;

/**
 * @author liutianlong
 */
public class RedisTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("39.106.30.70", 6379);
        jedis.auth("ltl10121314");
        //PING测试
        System.out.println(jedis.ping());
    }
    @Test
    public void test1(){
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        //set keys
        jedis.set("k1", "v1");
        jedis.set("k2", "v2");
        jedis.set("k3", "v3");

    }
    @Test
    public void test2(){
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        //get key
        System.out.println(jedis.get("k1"));
    }
    @Test
    public void test3(){
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        //keys *
        Set<String> keys = jedis.keys("*");
        //for keys
        for (String key : keys) {
            System.out.println("key: " + key);
        }
        //key size
        System.out.println("key size: " + keys.size());
    }
    @Test
    public void test4(){
        Jedis jedis = new Jedis("39.106.30.70", 6379);
        jedis.auth("ltl10121314");

        long startTime =  System.currentTimeMillis();
        for(int i = 0; i < 10000; i++) {
            jedis.set("k2" + i,i + "");
        }
        long endTime =  System.currentTimeMillis();
        long usedTime = endTime-startTime;
        System.out.println(usedTime + "ms");
    }
    @Test
    public void test5(){
        Jedis jedis = new Jedis("39.106.30.70", 6379);
        jedis.auth("ltl10121314");

        long startTime =  System.currentTimeMillis();
        for(int i = 0; i < 100; i++) {
            Pipeline pipelined = jedis.pipelined();
            for(int j = i * 100; j < (i + 1) * 100; j++) {
                pipelined.set("k3" + i,i + "");
            }
            pipelined.sync();
        }
        long endTime =  System.currentTimeMillis();
        long usedTime = (endTime-startTime);
        System.out.println(usedTime + "ms");
    }
    @Test
    public void test6() throws InterruptedException {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        List<Object> exec = null;
        while (exec == null) {
            System.out.println(jedis.watch("k1"));
            Transaction transaction = jedis.multi();
            Thread.sleep(3000);
            transaction.set("k1", "v2");
            exec = transaction.exec();
            System.out.println(exec);
            Thread.sleep(2000);
        }
    }
}
