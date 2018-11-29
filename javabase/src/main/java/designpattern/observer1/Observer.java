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
  * @date 2018/11/2915:11
  */
 public class Observer implements IObserver {

     @Override
     public void refresh(ISubject obj) {
         // TODO Auto-generated method stub
         Subject subject = (Subject) obj;
         System.out.println("数据正在更新为:" + subject.getData());
     }
 }
