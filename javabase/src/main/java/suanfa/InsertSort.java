 /*
  * Copyright 2018 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package suanfa;

 /**
  * 插入排序算法：
  * 1、以数组的某一位作为分隔位，比如index=1，假设左面的都是有序的.
  * 2、将index位的数据拿出来，放到临时变量里，这时index位置就空出来了.
  * 3、从leftindex=index-1开始将左面的数据与当前index位的数据（即temp）进行比较，如果array[leftindex]>temp,
  *
  * @author wangchao4
  * @date 2018/11/810:08
  */
 public class InsertSort {

     private int[] array;

     private int length;

     public InsertSort(int[] array,int length) {
         this.array = array;
         this.length=length;

     }

     public void display() {
         for (int a : array) {
             System.out.println(a + "");
         }
         System.out.println();
     }

     /**
      * 插入排序方法
      */
     public void doInsertSort() {
         //外层向右的index，即作为比较对象的数据的index
         for (int index = 1; index < length; index++) {
             int temp = array[index];//用作比较的数据
             int leftindex = index - 1;
             while (leftindex >= 0 && array[leftindex] > temp) { //当比到最左边或者遇到比temp小的数据时，结束循环
               array[leftindex+1]=array[leftindex];
               leftindex--;
             }
             array[leftindex+1] = temp;//把temp放到空位上
         }
     }

     public static void main(String [] args){
         int[] array = {38,65,97,76,13,27,49};
         InsertSort is = new InsertSort(array,array.length);
         System.out.println("排序前的数据为：");
         is.display();
         is.doInsertSort();
         System.out.println("排序后的数据为：");
         is.display();
     }
 }
