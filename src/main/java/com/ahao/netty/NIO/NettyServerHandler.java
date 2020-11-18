package com.ahao.netty.NIO;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.CharsetUtil;

import java.util.Date;

/**
 * @author ahao
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent){
            IdleStateEvent event = (IdleStateEvent) evt;
            switch (event.state()){
                case READER_IDLE:
                    //ctx.channel().close();
                    System.out.println("读空闲");
                    break;
                case WRITER_IDLE:
                    ctx.writeAndFlush(Unpooled.copiedBuffer("42 43 44",CharsetUtil.UTF_8));
                    System.out.println(new Date()+"发送心跳");
                    break;
                default:
                    System.out.println("无");
            }
        }
    }
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("ctx:"+ctx);
        //转换msg
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println("客户端信息："+new Date()+byteBuf.toString(CharsetUtil.UTF_8));
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("异常"+cause.getCause().toString());
        ctx.channel().close();
    }

}
