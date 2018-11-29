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
  * @date 2018/11/2816:26
  */
 public class ConsistentHash {


     private final SortedMap<Integer, Node> circle = new TreeMap<>();

     private HashStrategy hashStrategy;


     public ConsistentHash(HashStrategy hashStrategy) {
         this.hashStrategy = hashStrategy;
     }

     public void addNode(Node node) {
         circle.put(hashStrategy.hash(node.getIp()), node);
     }

     public void removeNode(Node node) {
         circle.remove(hashStrategy.hash(node.getIp()));
     }


 }
