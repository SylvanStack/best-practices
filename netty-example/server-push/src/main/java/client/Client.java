package client;

import client.codec.*;
import client.handler.DeviceHandler;
import common.device.DeviceActionEnum;
import common.device.DeviceOperation;
import common.device.DeviceTypeEnum;
import common.message.RequestMessage;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author hansiyuan
 * @date 2022年03月19日 22:11
 */
public class Client {
    public static void main(String[] args) throws InterruptedException {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.channel(NioSocketChannel.class);

        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            bootstrap.group(group);
            bootstrap.handler(new ChannelInitializer<NioSocketChannel>() {
                @Override
                protected void initChannel(NioSocketChannel ch) throws Exception {
                    ChannelPipeline pipeline = ch.pipeline();
                    pipeline.addLast(new ClientFrameDecoder());
                    pipeline.addLast(new ClientFrameEncoder());
                    pipeline.addLast(new ClientProtocolEncoder());
                    pipeline.addLast(new ClientProtocolDecoder());
                    pipeline.addLast(new OperationToRequestMessageEncoder());
                    pipeline.addLast(new LoggingHandler(LogLevel.INFO));
                    pipeline.addLast(new DeviceHandler());
                }
            });

            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 7788);
            channelFuture.sync();
            DeviceOperation deviceOperation = new DeviceOperation("server-push", DeviceActionEnum.CONNECT.getAction(), DeviceTypeEnum.PHONE_APP.getType());
            RequestMessage msg = new RequestMessage(1L, deviceOperation);
            channelFuture.channel().writeAndFlush(msg);
            channelFuture.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }
}
