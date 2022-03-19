package client.codec;

import common.Operation;
import common.message.RequestMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import util.IdUtil;

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
