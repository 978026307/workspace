package ssmtest1;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class test {
	public static void main(String[] args) {
		Jedis jedis =  new Jedis("localhost");
        System.out.println("连接成功");
        //查看服务是否运行
        //System.out.println("服务正在运行: "+jedis.ping());
        jedis.set("redis", "hello redis");
       // System.out.println("view"+jedis.get("redis"));
        jedis.lpush("list", "value1");
        jedis.lpush("list", "value2");
        jedis.lpush("list", "value3");
        List<String> list = jedis.lrange("list", 0	, 2);
        for(String i : list) {
        	System.out.println(i);
        }
        Set<String> keys = jedis.keys("*");
        Iterator<String> it = keys.iterator();
        while(it.hasNext()) {
        	String key = it.next();
        	System.out.println(key);
        }
        jedis.close();
	}
}
