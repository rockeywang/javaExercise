 /*
  * Copyright 2018 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package hash;

 import java.util.concurrent.ConcurrentHashMap;

 /**
  * @author wangchao4
  * @date 2018/11/2816:24
  */
 public class Node {

     /**
      * 主机ip
      */
     private String ip;

     /**
      * 代表该主机中存放的KV
      */
     private ConcurrentHashMap map = new ConcurrentHashMap();

     public Node(String ip) {
         this.ip = ip;
     }

     public String getIp() {
         return ip;
     }

     public void setIp(String ip) {
         this.ip = ip;
     }

     public ConcurrentHashMap getMap() {
         return map;
     }
 }
