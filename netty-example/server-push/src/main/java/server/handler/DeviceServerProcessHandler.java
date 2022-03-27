package server.handler;

import common.Operation;
import common.OperationResult;
import common.device.DeviceContainers;
import common.device.DeviceOperationResult;
import common.device.DeviceTypeEnum;
import common.message.RequestMessage;
import common.message.ResponseMessage;
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
