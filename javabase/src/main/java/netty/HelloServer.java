 /*
  * Copyright 2018 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package netty;

 import io.netty.bootstrap.ServerBootstrap;
 import io.netty.channel.ChannelInitializer;
 import io.netty.channel.ChannelOption;
 import io.netty.channel.nio.NioEventLoopGroup;
 import io.netty.channel.socket.nio.NioServerSocketChannel;
 import io.netty.channel.socket.SocketChannel;
 import io.netty.handler.codec.http.HttpObjectAggregator;
 import io.netty.handler.codec.http.HttpRequestDecoder;
 import io.netty.handler.codec.http.HttpResponseEncoder;


 /**
  * @author wangchao4
  * @date 2018/11/2717:00
  */
 public class HelloServer {

     private int port;


     public HelloServer(int port) {
         this.port = port;
     }


     public void start() throws Exception {
         ServerBootstrap b = new ServerBootstrap();
         NioEventLoopGroup group = new NioEventLoopGroup();
         b.group(group)
                 .channel(NioServerSocketChannel.class)
                 .childHandler(new ChannelInitializer<SocketChannel>() {
                     @Override
                     public void initChannel(SocketChannel ch)
                             throws Exception {
                         System.out.println("initChannel ch:" + ch);
                         ch.pipeline()
                                 .addLast("decoder", new HttpRequestDecoder())   // 1
                                 .addLast("encoder", new HttpResponseEncoder())  // 2
                                 .addLast("aggregator", new HttpObjectAggregator(512 * 1024))    // 3
                                 .addLast("handler", new HelloServerHandler());        // 4
                     }
                 })
                 .option(ChannelOption.SO_BACKLOG, 128) // determining the number of connections queued
                 .childOption(ChannelOption.SO_KEEPALIVE, Boolean.TRUE);

         b.bind(port).sync();
     }



     public static void main(String[] args) throws Exception {
//         if (args.length != 1) {
//             System.err.println(
//                     "Usage: " + HelloServer.class.getSimpleName() +
//                             " <port>");
//             return;
//         }
         int port = 8080;//Integer.parseInt(args[0]);
         new HelloServer(port).start();
     }


 }
