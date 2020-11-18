package client;

import com.alibaba.fastjson.JSON;
import entity.Date;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;

/**
 * TODO
 *
 * @author ahao 2020-08-30
 */
public class ChatClient {
    public static void main(String[] args)  {
        EventLoopGroup eventExecutors = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(eventExecutors)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast("decoder",new StringDecoder());
                        ch.pipeline().addLast("encoder",new StringEncoder());
                        ch.pipeline().addLast(new ClientHandel());
                    }
                });
        ChannelFuture sync = null;
        try {
            sync = bootstrap.connect("127.0.0.1", 7070).sync();
            Channel channel = sync.channel();
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println(channel.localAddress());
                System.out.println("私聊请以一下格式输入1#端口号#信息内容");
                String s = scanner.nextLine();
                channel.writeAndFlush(s);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            eventExecutors.shutdownGracefully();
        }
    }
}
