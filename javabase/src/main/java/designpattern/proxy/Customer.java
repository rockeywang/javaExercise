 /*
  * Copyright 2018 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package designpattern.proxy;

 /**
  * @author wangchao4
  * @date 2018/11/2919:25
  */
 public class Customer implements IBuyCar {


     private int cash;//购车款

     public int getCash() {
         return cash;
     }

     public void setCash(int cash) {
         this.cash = cash;
     }

     @Override
     public void buyCar() {
        System.out.println("buyCar,买一辆车花费了-->" + cash + "元");
     }
 }
