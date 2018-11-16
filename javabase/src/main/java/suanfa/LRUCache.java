 /*
  * Copyright 2018 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package suanfa;

 import java.util.LinkedHashMap;
 import java.util.Map;
 import java.util.concurrent.locks.Lock;
 import java.util.concurrent.locks.ReentrantLock;

 /**
  * 类说明:利用LinkedHashMap实现简单的缓存，必须实现removeEldestEntry方法
  *
  * @author wangchao4
  * @date 2018/11/916:15
  */
 public class LRUCache<k, v> extends LinkedHashMap<k, v> {


     //缓存大小
     private int cacheSize;

     public static ReentrantLock lock = new ReentrantLock();

     public LRUCache(int cacheSize) {
         //第三个参数true是关键
         super(10, 0.75f, true);
         this.cacheSize = cacheSize;
     }


     @Override
     protected boolean removeEldestEntry(Map.Entry<k, v> eldest) {
         boolean r = size() > cacheSize;
         if(r){
             System.out.println("清除缓存key："+eldest.getKey());
         }
         return r;
     }


     /**
      * 判断Map集合对象中是否包含指定的键名
      * @param key
      * @return
      */
     @Override
     public boolean containsKey(Object key) {
         try {
             lock.lock();
             return super.containsKey(key);
         }finally {
             lock.unlock();
         }
     }

     @Override
     public v get(Object key) {
         return super.get(key);
     }

     public static void main(String[] args) {
         LRUCache<String, String> cache = new LRUCache<String, String>(5);
         cache.put("1", "1");
         cache.put("2", "2");
         cache.put("3", "3");
         cache.put("4", "4");
         cache.put("5", "5");

         System.out.println("初始：");
         System.out.println(cache.keySet());
         System.out.println("访问3：");
         cache.get("3");
         System.out.println(cache.keySet());
         System.out.println("访问2：");
         cache.get("2");
         System.out.println(cache.keySet());
         System.out.println("增加数据6,7：");
         cache.put("6", "6");
         cache.put("7", "7");
         System.out.println(cache.keySet());
     }
 }
