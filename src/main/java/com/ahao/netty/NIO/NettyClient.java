package com.ahao.netty.NIO;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author ahao
 */
public class NettyClient {

    public static void main(String[] args) throws InterruptedException {
        //事件循环组
        NioEventLoopGroup eventExecutors = new NioEventLoopGroup();
        try {


            //创建启动对象注意不是ServerBootstrap
            Bootstrap bootstrap = new Bootstrap();
            //设置线程组
            bootstrap.group(eventExecutors)
                    //设置客户端通道实现类
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new NettyClientHandle());
                        }
                    });
            System.out.println("客户端ok");

            //启动连接服务器端
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 7000).sync();
            //给关闭通道进行监听
            channelFuture.sync();
        }finally {
            eventExecutors.shutdownGracefully();
        }
    }
}
