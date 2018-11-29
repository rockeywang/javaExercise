 /*
  * Copyright 2018 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package designpattern.observer1;

 /**
  * @author wangchao4
  * @date 2018/11/2915:01
  */
 public interface ISubject {


     //注册观察者
     public void register(IObserver obs);

     //撤销观察者
     public void unregister(IObserver obs);

     //通知所有观察者及进行数据响应
     public void notifyObservers();
 }
