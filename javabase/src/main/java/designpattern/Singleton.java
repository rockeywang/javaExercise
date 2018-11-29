 /*
  * Copyright 2018 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package designpattern;

 /**
  * 单列
  * @author wangchao4
  * @date 2018/11/2810:31
  */
 public class Singleton {


     private static Singleton singleton=null;

     //限制产生多个对象
     private Singleton(){

     }

     //通过该方法获得实例对象
     public static Singleton getSingleton(){
         if (singleton==null){
             synchronized(Singleton.class){
                 singleton=new Singleton();
             }
             return singleton;
         }
         return singleton;
     }
 }
