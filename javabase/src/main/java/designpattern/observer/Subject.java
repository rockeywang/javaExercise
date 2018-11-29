 /*
  * Copyright 2018 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package designpattern.observer;

 import java.util.Observable;

 /**
  * Observable类派生出来的子类，只需要定义各被监控的数据及getter()、setter()方法，
  * getter方法主要用于具体观察者“拉”数据，setter方法主要用于更新、设置changed变量及通知各具体观察者进行数据响应
  *
  * @author wangchao4
  * @date 2018/11/2914:40
  */
 public class Subject extends Observable {


     private String data;

     public String getData() {
         return data;
     }


     public void setData(String data) {
         //更新数据
         this.data = data;
         //置更新数据标志
         setChanged();
         //通知各个具体的观察者，这里有推数据的作用
         notifyObservers(null);
     }

 }
