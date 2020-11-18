package com.ahao.netty.NIO;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.Timer;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @author ahao
 */
public class NettyServer {
    public static void main(String[] args) throws InterruptedException {

        //创建BoosGroup 以及WorkerGroup
        //处理连接
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //处理业务
        EventLoopGroup workGroup = new NioEventLoopGroup();
        //创建启动对象
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        //指定两个线程组
        try {
        serverBootstrap.group(bossGroup,workGroup)
                //使用NioServerSocketChannel作为通道实现
                .channel(NioServerSocketChannel.class)
                //设置线程队列得到连接个数
                .option(ChannelOption.SO_BACKLOG,128)
                //设置保持活动状态
                .childOption(ChannelOption.SO_KEEPALIVE,true)
                .childHandler(new ChannelInitializer<SocketChannel >() {
                    //给pipeline设置处理器
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast(new IdleStateHandler(10,10,200, TimeUnit.SECONDS));
                        pipeline.addLast(new NettyServerHandler());//设置处理器
                    }
                });
        System.out.println("ready");
        //绑定端口并同步处理
        ChannelFuture cf = serverBootstrap.bind(6666).sync();
        //对关闭通道进行监听
        cf.channel().closeFuture().sync();

     }finally {
           bossGroup.shutdownGracefully();
           workGroup.shutdownGracefully();
       }
    }

}
