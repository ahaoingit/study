package client;

import entity.Date;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * TODO
 *
 * @author ahao 2020-08-30
 */
public class ClientHandel extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(msg);
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
    }
}

