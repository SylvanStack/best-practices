package client;

import client.codec.*;
import client.handler.DeviceHandler;
import client.handler.dispatcher.OperationResultFuture;
import client.handler.dispatcher.RequestPendingCenter;
import client.handler.dispatcher.ResponseDispatcherHandler;
import common.OperationResult;
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
import util.IdUtil;

import java.util.concurrent.ExecutionException;

/**
 * @author hansiyuan
 * @date 2022年03月19日 23:14
 */
public class ClientFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.channel(NioSocketChannel.class);

        NioEventLoopGroup group = new NioEventLoopGroup();
        RequestPendingCenter requestPendingCenter = new RequestPendingCenter();
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
                    pipeline.addLast(new ResponseDispatcherHandler(requestPendingCenter));
                    pipeline.addLast(new OperationToRequestMessageEncoder());
                    pipeline.addLast(new LoggingHandler(LogLevel.INFO));
                    pipeline.addLast(new DeviceHandler());
                }
            });

            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 8090);
            channelFuture.sync();
            DeviceOperation deviceOperation = new DeviceOperation("server-push", DeviceActionEnum.CONNECT.getAction(), DeviceTypeEnum.PHONE_APP.getType());
            long streamId = IdUtil.nextId();
            RequestMessage msg = new RequestMessage(streamId, deviceOperation);
            OperationResultFuture operationResultFuture = new OperationResultFuture();
            requestPendingCenter.add(streamId, operationResultFuture);
            channelFuture.channel().writeAndFlush(msg);

            OperationResult operationResult = operationResultFuture.get();

            System.out.println(operationResult);
            channelFuture.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }
}
