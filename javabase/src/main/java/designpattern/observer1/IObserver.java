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
  * @date 2018/11/2915:00
  */
 public interface IObserver {

     //传入的参数对象可以间接获取变化后的主题数据
     public void refresh(ISubject subject);
 }
