 /*
  * Copyright 2018 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package designpattern.proxy;

 import java.lang.reflect.InvocationHandler;
 import java.lang.reflect.Proxy;

 /**
  * 代理设计模式
  * @author wangchao4
  * @date 2018/11/2919:27
  */
 public class Test {


     public static void main(String[] args) {

         //我们要代理的真实对象
         Customer customer = new Customer();
         //我们要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法的
         InvocationHandler handler = new DynamicProxy(customer);

         /*
          * 通过Proxy的newProxyInstance方法来创建我们的代理对象，我们来看看其三个参数
          * 第一个参数 handler.getClass().getClassLoader() ，我们这里使用handler这个类的ClassLoader对象来加载我们的代理对象
          * 第二个参数customer.getClass().getInterfaces()，我们这里为代理对象提供的接口是真实对象所实行的接口，表示我要代理的是该真实对象，这样我就能调用这组接口中的方法了
          * 第三个参数handler， 我们这里将这个代理对象关联到了上方的 InvocationHandler 这个对象上
          */
         IBuyCar buyCar = (IBuyCar) Proxy.newProxyInstance(handler.getClass().getClassLoader(), customer.getClass().getInterfaces(), handler);
         buyCar.buyCar();

     }
 }
