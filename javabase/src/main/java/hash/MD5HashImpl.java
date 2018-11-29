 /*
  * Copyright 2018 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package hash;

 import java.security.MessageDigest;
 import java.security.NoSuchAlgorithmException;

 /**
  * @author wangchao4
  * @date 2018/11/2816:13
  */
 public class MD5HashImpl implements HashStrategy {

     MessageDigest digest; //MessageDigest 类为应用程序提供信息摘要算法的功能，如 MD5 或 SHA 算法。信息摘要是安全的单向哈希函数，它接收任意大小的数据，并输出固定长度的哈希值。


     public MD5HashImpl() throws NoSuchAlgorithmException {
         this.digest = MessageDigest.getInstance("MD5");
     }

     public int hash(Object key) {

         if (key == null) {
             return 0;
         }

         int h = key.hashCode();

         //开32的空间
         byte[] bytes = new byte[4];


         //将h赋值给bytes数组
         for (int i = 3; i > -1; i--) {
             bytes[i] = (byte)(h>>(i*8));
         }

         byte[] hashBytes;

         synchronized (digest){
             hashBytes=digest.digest(bytes);
         }

         int result = 0;
         for(int i=0; i<4 ;i++){
             int idx = i*4;
             result += (hashBytes[idx + 3]&0xFF << 24)
                     | (hashBytes[idx + 2]&0xFF << 16)
                     | (hashBytes[idx + 1]&0xFF << 8)
                     | (hashBytes[idx + 0]&0xFF);
         }
         return result;

     }


 }
