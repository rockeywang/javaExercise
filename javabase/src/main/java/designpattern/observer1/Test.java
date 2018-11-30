 /*
  * Copyright 2018 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package designpattern.observer1;

 /**
  * 观察者设计模式
  * @author wangchao4
  * @date 2018/11/2915:18
  */
 public class Test {

     public static void main(String[] args) {
         // TODO Auto-generated method stub
         IObserver obs = new Observer();
         Subject subject = new Subject();
         subject.register(obs);
         subject.setData("one");
         subject.notifyObservers();
     }
 }
