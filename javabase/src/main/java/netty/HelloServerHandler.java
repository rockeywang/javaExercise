 /*
  * Copyright 2018 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package netty;

 import io.netty.buffer.Unpooled;
 import io.netty.channel.ChannelHandlerContext;
 import io.netty.channel.SimpleChannelInboundHandler;
 import io.netty.handler.codec.http.*;
 import io.netty.util.AsciiString;
 /**
  * @author wangchao4
  * @date 2018/11/2716:50
  */
 public class HelloServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {


     private AsciiString contentType = HttpHeaderValues.TEXT_PLAIN;




     protected void channelRead0(ChannelHandlerContext channelHandlerContext, FullHttpRequest msg) throws Exception {
         System.out.println("class:" + msg.getClass().getName());
         DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,
                 HttpResponseStatus.OK,
                 Unpooled.wrappedBuffer("test".getBytes())); // 2

         HttpHeaders heads = response.headers();
         heads.add(HttpHeaderNames.CONTENT_TYPE, contentType + "; charset=UTF-8");
         heads.add(HttpHeaderNames.CONTENT_LENGTH, response.content().readableBytes()); // 3
         heads.add(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);

     }

     @Override
     public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
         System.out.println("channelReadComplete");
         super.channelReadComplete(ctx);
         ctx.flush(); // 4
     }


     /**
      * 当Netty由于IO错误或者处理器在处理事件时抛出异常时调用
      * @param ctx
      * @param cause
      * @throws Exception
      */
     @Override
     public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
         System.out.println("exceptionCaught");
         if(null != cause) cause.printStackTrace();
         if(null != ctx) ctx.close();
     }
 }
