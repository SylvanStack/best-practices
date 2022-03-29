package com.yuanstack.bp.serverpush.client.codec;

import com.yuanstack.bp.serverpush.common.Operation;
import com.yuanstack.bp.serverpush.common.message.RequestMessage;
import com.yuanstack.bp.serverpush.util.IdUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

/**
 * 客户端 操作转换Message
 *
 * @author hansiyuan
 * @date 2022年03月19日 23:15
 */
public class OperationToRequestMessageEncoder extends MessageToMessageEncoder<Operation> {

    /**
     * 编码
     */
    @Override
    protected void encode(ChannelHandlerContext ctx, Operation operation, List<Object> out) throws Exception {
        RequestMessage requestMessage = new RequestMessage(IdUtil.nextId(), operation);

        out.add(requestMessage);
    }
}
