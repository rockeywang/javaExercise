 /*
  * Copyright 2018 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package designpattern.proxy;

 import java.lang.reflect.InvocationHandler;
 import java.lang.reflect.Method;

 /**
  * @author wangchao4
  * @date 2018/11/2919:15
  */
 public class DynamicProxy implements InvocationHandler {

     //被代理的实例
     Object obj;

     //将被代理的实例传进动态代理类的构造函数中
     public DynamicProxy(Object obj) {
         this.obj = obj;
     }


     /**
      * 覆盖InvocationHandler接口中的invoke()方法
      * 更重要的是，动态代理模式可以使得我们在不改变原来已有的代码结构
      * 的情况下，对原来的“真实方法”进行扩展、增强其功能，并且可以达到
      * 控制被代理对象的行为，下面的before、after就是我们可以进行特殊
      * 代码切入的扩展点了。
      */

     @Override
     public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

         Object  result=method.invoke(this.obj,args);
         return result;
     }



 }
