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
 public class LRULinkedHashMap<k, v> extends LinkedHashMap<k, v> {


     private final int maxCapacity;

     private static final float DEFAULT_LOAD_FACTOR = 0.75f;

     private final Lock lock = new ReentrantLock();

     public LRULinkedHashMap(int maxCapacity) {
         super(maxCapacity, DEFAULT_LOAD_FACTOR, true);
         this.maxCapacity = maxCapacity;
     }


     @Override
     protected boolean removeEldestEntry(Map.Entry<k, v> eldest) {
         return size()>maxCapacity;
     }


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
 }
