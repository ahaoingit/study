package com.ahao.netty.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ServerChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @author ahao
 */
public class ServerInitializer extends ChannelInitializer<ServerChannel> {
    @Override
    protected void initChannel(ServerChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast("MyHttpCodec",new HttpServerCodec());
    }
}
