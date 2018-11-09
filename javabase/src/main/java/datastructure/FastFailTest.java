 /*
  * Copyright 2018 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package datastructure;

 import java.util.ArrayList;
 import java.util.Iterator;
 import java.util.List;

 /**
  * 集合中Fast-Fail的测试程序
  *
  * @author wangchao4
  * @date 2018/11/910:01
  */
 public class FastFailTest {


     private static List<String> list = new ArrayList<String>();


     public static void main(String[] args) {
         // 同时启动两个线程对list进行操作！
         new ThreadOne().start();
         new ThreadTwo().start();
     }

     private static void printAll() {
         System.out.println("");

         String value = null;
         Iterator iter = list.iterator();
         while (iter.hasNext()) {
             value = (String) iter.next();
             System.out.print(value + ", ");
         }
     }


     /**
      * 向list中依次添加0,1,2,3,4,5，每添加一个数之后，就通过printAll()遍历整个list
      */
     private static class ThreadOne extends Thread {
         public void run() {
             int i = 0;
             while (i < 6) {
                 list.add(String.valueOf(i));
                 printAll();
                 i++;
             }
         }
     }

     /**
      * 向list中依次添加10,11,12,13,14,15，每添加一个数之后，就通过printAll()遍历整个list
      */
     private static class ThreadTwo extends Thread {
         public void run() {
             int i = 10;
             while (i < 16) {
                 list.add(String.valueOf(i));
                 printAll();
                 i++;
             }
         }
     }

 }