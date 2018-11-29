 /*
  * Copyright 2018 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package designpattern.observer;


 import java.util.Observer;

 /**
  * @author wangchao4
  * @date 2018/11/2914:49
  */
 public class Test {


     public static void main(String[] args) {
         // TODO Auto-generated method stub
         Observer obj = new ObserverOne();
         Subject subject = new Subject();
         subject.addObserver(obj);
         subject.setData("One");
     }
 }
