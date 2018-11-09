 /*
  * Copyright 2018 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package suanfa;

 /**
  * 计数排序算法
  *
  * @author wangchao4
  * @date 2018/11/715:47
  */
 public class CountingSort {


     /**
      * 计数算法就是给每个元素计一些数，通过一些数来对元素进行比较和排序
      * @param theArray
      * @return
      */
     public static int[] countingSort(int[] theArray) {
         int[] lastArray = new int[theArray.length];
         for (int i = 0; i < theArray.length; i++) {
             int count = 0;
             for (int j = 0; j < theArray.length; j++) {
                 if (theArray[i] > theArray[j]) {
                     count++;
                 }
             }
             lastArray[count]=theArray[i];
         }
         return  lastArray;
     }


     public static void main(String[] args) {
         int []theArray = {6, 4, 5, 1, 8, 7, 2, 3};
         System.out.print("之前的排序：");
         for(int i = 0; i < theArray.length; i++) {
             System.out.print(theArray[i] + " ");
         }

         int []resultArray = countingSort(theArray);

         System.out.print("计数排序：");
         for(int i = 0; i < resultArray.length; i++) {
             System.out.print(resultArray[i] + " ");
         }
     }


 }
