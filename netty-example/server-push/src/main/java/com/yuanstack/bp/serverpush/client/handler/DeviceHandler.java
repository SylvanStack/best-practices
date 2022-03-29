package com.yuanstack.bp.serverpush.client.handler;

import com.yuanstack.bp.serverpush.common.message.ResponseMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author hansiyuan
 * @date 2022年03月19日 23:22
 */
public class DeviceHandler extends SimpleChannelInboundHandler<ResponseMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ResponseMessage msg) throws Exception {
        System.out.println("======================");
        System.out.println(msg);
        System.out.println("======================");
    }
}
