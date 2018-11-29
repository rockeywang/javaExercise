 /*
  * Copyright 2018 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package designpattern.observer1;

 import java.util.ArrayList;

 /**
  * @author wangchao4
  * @date 2018/11/2915:05
  */
 public class AbstractSubject implements ISubject {

     private ArrayList<IObserver> array = new ArrayList<IObserver>();


     @Override
     public void register(IObserver obs) {

         array.add(obs);

     }

     @Override
     public void unregister(IObserver obs) {

         array.remove(obs);
     }

     @Override
     public void notifyObservers() {

         for(int i=0;i<array.size();i++){
             IObserver  obs = array.get(i);
             obs.refresh(this);
         }

     }
 }
