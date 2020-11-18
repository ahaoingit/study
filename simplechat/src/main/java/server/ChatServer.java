package server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * TODO
 *
 * @author ahao 2020-08-30
 */
public class ChatServer {
    public static void main(String[] args) {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        //配置
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup,workerGroup)
                       .channel(NioServerSocketChannel.class)
                       .option(ChannelOption.SO_BACKLOG,128)
                       .childOption(ChannelOption.SO_KEEPALIVE,true)
                       .childHandler(new ChannelInitializer() {
                           @Override
                           protected void initChannel(Channel ch) throws Exception {
                               ch.pipeline().addLast("decoder",new StringDecoder());
                               ch.pipeline().addLast("encoder",new StringEncoder());
                               ch.pipeline().addLast(new MesHandel());
                           }
                       });
        try {
            ChannelFuture sync = serverBootstrap.bind(7070).sync();
            sync.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
        }
    }
