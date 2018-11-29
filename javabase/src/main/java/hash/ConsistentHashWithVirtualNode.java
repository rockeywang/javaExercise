 /*
  * Copyright 2018 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package hash;

 import java.util.SortedMap;
 import java.util.TreeMap;

 /**
  * @author wangchao4
  * @date 2018/11/2816:31
  */
 public class ConsistentHashWithVirtualNode {
     private final SortedMap<Integer, Node> circle = new TreeMap<>();

     private HashStrategy hashStrategy;

     private int virtualNum; // 把实际节点虚拟为多少个节点

     public ConsistentHashWithVirtualNode(HashStrategy hashStrategy, int virtualNum) {
         this.hashStrategy = hashStrategy;
         this.virtualNum = virtualNum;
     }

     public void addNode(Node node) {
         for (int i = 0; i < virtualNum; i++) {
             circle.put(hashStrategy.hash(i + node.getIp()), node);
         }
     }

     public void removeNode(Node node) {
         for (int i = 0; i < virtualNum; i++) {
             circle.remove(hashStrategy.hash(i + node.getIp()));
         }
     }

     /**
      * 根据key查找服务器节点
      *
      * @param key
      * @return
      */
     public Node getNode(Object key) {
         int hashCode = hashStrategy.hash(key);

         if (!circle.containsKey(hashCode)) {
             //顺时针取得最近的节点
             SortedMap<Integer, Node> tailMap = circle.tailMap(hashCode);
             hashCode = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
         }

         return circle.get(hashCode);
     }






     public static void main(String[] args){
         String key="122322";
        // getNode(key);
     }
 }
