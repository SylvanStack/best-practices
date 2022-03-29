package com.yuanstack.bp.serverpush.server.codec;

import com.yuanstack.bp.serverpush.common.message.ResponseMessage;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

/**
 * 二次编码器 ResponseMessage -> ByteBuf
 * 将Java对象转化为二进制字节数组
 * 采用Json序列了化方式（编解码）
 *
 * @author hansiyuan
 * @date 2022年03月19日 22:44
 */
public class ServerProtocolEncoder extends MessageToMessageEncoder<ResponseMessage> {


    /**
     * 编码
     */
    @Override
    protected void encode(ChannelHandlerContext ctx, ResponseMessage responseMessage, List<Object> out) throws Exception {
        // 分配ByteBuf
        ByteBuf buffer = ctx.alloc().buffer();
        responseMessage.encode(buffer);
        out.add(buffer);
    }
}