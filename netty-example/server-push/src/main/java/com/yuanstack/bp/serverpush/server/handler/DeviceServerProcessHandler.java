package com.yuanstack.bp.serverpush.server.handler;

import com.yuanstack.bp.serverpush.common.Operation;
import com.yuanstack.bp.serverpush.common.OperationResult;
import com.yuanstack.bp.serverpush.common.device.DeviceContainers;
import com.yuanstack.bp.serverpush.common.device.DeviceOperationResult;
import com.yuanstack.bp.serverpush.common.device.DeviceTypeEnum;
import com.yuanstack.bp.serverpush.common.message.RequestMessage;
import com.yuanstack.bp.serverpush.common.message.ResponseMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * handler 处理请求 -> 发送请求
 * SimpleChannelInboundHandler：帮助我们自动释放ByteBuf
 *
 * @author hansiyuan
 * @date 2022年03月19日 22:33
 */
@Slf4j
public class DeviceServerProcessHandler extends SimpleChannelInboundHandler<RequestMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RequestMessage requestMessage) throws Exception {
        try {
            Operation operation = requestMessage.getMessageBody();
            OperationResult operationResult = operation.execute();

            // 设置响应结果
            ResponseMessage responseMessage = new ResponseMessage();
            responseMessage.setMessageHeader(requestMessage.getMessageHeader());
            responseMessage.setMessageBody(operationResult);
            DeviceOperationResult deviceOperationResult = (DeviceOperationResult) operationResult;
            String key = deviceOperationResult.getKey();
            String deviceType = deviceOperationResult.getDeviceType();
            if (DeviceTypeEnum.PHONE_APP.getType().equals(deviceType)) {
                ChannelHandlerContext ctxLocal = DeviceContainers.getphoneAppDevice(key);
                if (ctxLocal == null || ctx != ctxLocal) {
                    DeviceContainers.addphoneAppDevice(key, ctx);
                }
            }
            if (ctx.channel().isActive() && ctx.channel().isWritable()) {
                ctx.writeAndFlush(responseMessage);
            } else {
                log.error("not writable now, message dropped");
            }
        } catch (Exception ex) {
            System.out.println("==============");
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
        log.error("异常信息：{}", cause.getMessage());
    }
}
