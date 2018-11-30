 /*
  * Copyright 2018 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package bingfa;


 import java.util.Map;
 import java.util.TreeMap;
 import java.util.concurrent.locks.Lock;
 import java.util.concurrent.locks.ReentrantReadWriteLock;

 /**
  * @author wangchao4
  * @date 2018/11/2715:53
  */
 public class ReentrantLockDemo {

     private final Map<String, String> m = new TreeMap<String, String>();


     private final ReentrantReadWriteLock rw1=new ReentrantReadWriteLock();

     private final Lock r=rw1.readLock();

     private final Lock w=rw1.writeLock();



     public static void main(String[] args){


     }



 }
