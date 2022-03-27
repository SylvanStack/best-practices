package server.codec;

import common.message.RequestMessage;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

/**
 * 二次解码器 ByteBuf -> RequestMessage
 * 将二进制字节数组转化为Java对象
 * 用Json反·序列了化方式（编解码）
 *
 * @author hansiyuan
 * @date 2022年03月19日 22:43
 */
public class ServerProtocolDecoder extends MessageToMessageDecoder<ByteBuf> {
    /**
     * 解码
     */
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf byteBuf, List<Object> out) throws Exception {

        RequestMessage requestMessage = new RequestMessage();
        requestMessage.decode(byteBuf);

        // 将 requestMessage 添加到 out 上才能被传输出去
        out.add(requestMessage);
    }
}
