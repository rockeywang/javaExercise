 /*
  * Copyright 2018 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package suanfa;

 import java.util.*;

 /**
  * 把数组 arr 划分为n个大小相同子区间（桶），每个子区间各自排序，最后合并
  *
  * @author wangchao4
  * @date 2018/11/716:42
  */
 public class BucketSort {

     public static void bucketSort(int[] arr) {

         int max = Integer.MIN_VALUE;
         int min = Integer.MAX_VALUE;
         for (int i = 0; i < arr.length; i++) {
             max = Math.max(max, arr[i]);
             min = Math.min(min, arr[i]);
         }

         //桶数
         int bucketNum = (max - min) / arr.length + 1;
         ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<ArrayList<Integer>>(bucketNum);
         for (int i = 0; i < bucketNum; i++) {
             bucketArr.add(new ArrayList<Integer>());
         }

         //将每个元素放入桶
         for (int i = 0; i < arr.length; i++) {
             int num = (arr[i] - min) / (arr.length);
             bucketArr.get(num).add(arr[i]);
         }

         //对每个桶进行排序
         for (int i = 0; i < bucketArr.size(); i++) {
             Collections.sort(bucketArr.get(i));
         }

         System.out.println(bucketArr.toString());

     }

     public static void main(String[] args) {
         int[] theArray = {6, 4, 5, 1, 8, 7, 2, 3,0};
         bucketSort(theArray);
     }


 }
