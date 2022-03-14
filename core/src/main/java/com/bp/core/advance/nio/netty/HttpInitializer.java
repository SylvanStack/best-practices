package com.bp.core.advance.nio.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.ssl.SslContext;

/**
 * @author hansiyuan
 * @date 2022年03月07日 22:16
 */
public class HttpInitializer extends ChannelInitializer<SocketChannel> {
    private final SslContext sslCtx;

    public HttpInitializer(SslContext sslCtx) {
        this.sslCtx = sslCtx;
    }


    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline channelPipeline = socketChannel.pipeline();
        if (sslCtx != null) {
            channelPipeline.addLast(sslCtx.newHandler(socketChannel.alloc()));
        }
        channelPipeline.addLast(new HttpServerCodec());
        channelPipeline.addLast(new HttpObjectAggregator(1024*1024));
        channelPipeline.addLast(new HttpHandler());
    }
}
