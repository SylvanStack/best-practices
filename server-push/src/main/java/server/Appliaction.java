package server;

import server.codec.ServerFrameDecoder;
import server.codec.ServerFrameEncoder;
import server.codec.ServerProtocolDecoder;
import server.codec.ServerProtocolEncoder;
import server.handler.DeviceServerProcessHandler;
import server.handler.MetricsHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioChannelOption;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.concurrent.DefaultThreadFactory;
import io.netty.util.concurrent.UnorderedThreadPoolEventExecutor;

/**
 * @author hansiyuan
 * @date 2022年03月19日 22:11
 */
public class Appliaction {
    public static void main(String[] args) {
        // 服务端启动类
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        // 配置 NioServerSocketChannel
        serverBootstrap.channel(NioServerSocketChannel.class);
        // 可选配置 阻塞时常 最大的等待连接数量
        serverBootstrap.option(NioChannelOption.SO_BACKLOG, 1024);
        // 大报文时使用
        //serverBootstrap.childOption(NioChannelOption.TCP_NODELAY, true);
        serverBootstrap.handler(new LoggingHandler(LogLevel.INFO));

        //metrics
        MetricsHandler metricsHandler = new MetricsHandler();

        /*
         * 1. 采用主从Reactor模式
         * 2. NioEventLoop 单线程死循环TV操作开始执行
         * 3. NioServerSocketChannel 反射+工厂+泛型
         */
        // 完善线程名
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(0, new DefaultThreadFactory("boss"));
        NioEventLoopGroup workGroup = new NioEventLoopGroup(0, new DefaultThreadFactory("worker"));
        UnorderedThreadPoolEventExecutor businessGroup = new UnorderedThreadPoolEventExecutor(10, new DefaultThreadFactory("business"));
        try {
            serverBootstrap.group(bossGroup, workGroup);
            serverBootstrap.childHandler(new ChannelInitializer<NioSocketChannel>() {
                @Override
                protected void initChannel(NioSocketChannel ch) throws Exception {
                    ChannelPipeline pipeline = ch.pipeline();
                    // 连接检测可视化
                    pipeline.addLast("metricHandler", metricsHandler);
                    // 注意 childHandler 的共享问题
                    pipeline.addLast(new LoggingHandler(LogLevel.INFO));
                    // 完善handle名称
                    pipeline.addLast("frameDecoder", new ServerFrameDecoder());
                    pipeline.addLast("frameEncoder", new ServerFrameEncoder());
                    pipeline.addLast("protocolDecoder", new ServerProtocolDecoder());
                    pipeline.addLast("protocolEncoder", new ServerProtocolEncoder());
                    pipeline.addLast(businessGroup, new DeviceServerProcessHandler());
                }
            });
            ChannelFuture channelFuture = serverBootstrap.bind(7788).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
}
