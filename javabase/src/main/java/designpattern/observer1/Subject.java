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
  * @date 2018/11/2915:17
  */
 public class Subject extends AbstractSubject {


     //被监控的数据
     private String data;

     public String getData() {
         return data;
     }

     public void setData(String data) {
         this.data = data;
     }
 }
