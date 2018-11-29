 /*
  * Copyright 2018 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package designpattern.observer;

 import java.util.ArrayList;
 import java.util.List;
 import java.util.Observable;
 import java.util.Observer;

 /**
  * 被观察者，也就是微信公众号服务
  * 实现了Observerable接口，对Observerable接口的三个方法进行了具体实现
  *
  * @author wangchao4
  * @date 2018/11/2914:21
  */
 public class ObserverOne  implements Observer {


     @Override
     public void update(Observable o, Object arg) {
         // TODO Auto-generated method stub
         Subject subject = (Subject) o;
         System.out.println("数据正在更新为："+subject.getData());
     }
 }
