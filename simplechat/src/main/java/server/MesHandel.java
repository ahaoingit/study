package server;

import context.Context;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.net.SocketAddress;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * TODO
 *
 * @author ahao 2020-08-30
 */
public class MesHandel extends SimpleChannelInboundHandler<String> {

     private Map<String, Channel> userMap =  Context.cx.getMap();

    /*
        建立连接第一个被调用 绑定通道
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        String socketAddress = ctx.channel().remoteAddress().toString();
        String port = socketAddress.split(":")[1];
        userMap.put(port,ctx.channel());
        System.out.println(userMap);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        String socketAddress = ctx.channel().remoteAddress().toString();
        String port = socketAddress.split(":")[1];
        userMap.remove(port);
    }

    @Override
    public boolean acceptInboundMessage(Object msg) throws Exception {
        System.out.println(msg);
        return super.acceptInboundMessage(msg);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        if (msg.contains("1#")) {
            String[] split = msg.split("#");
            if (userMap.containsKey(split[1])) {
                Channel channel = userMap.get(split[1]);
                channel.writeAndFlush(ctx.channel().remoteAddress()+":对您说:"+split[2]);
            }else {
                ctx.channel().writeAndFlush(split[1]+"此用户不在线");
            }
        }else {
            Set<String> entries = userMap.keySet();
            entries.stream().forEach(entry->{
                Channel channel = userMap.get(entry);
                if (channel == ctx.channel()) {
                    channel.writeAndFlush("我说:"+msg);
                }else {
                    channel.writeAndFlush(ctx.channel().remoteAddress()+"说:"+msg);
                }
            });
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
