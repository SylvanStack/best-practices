package client.handler.dispatcher;

import common.message.ResponseMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author hansiyuan
 * @date 2022年03月19日 23:24
 */
public class ResponseDispatcherHandler extends SimpleChannelInboundHandler<ResponseMessage> {
    private RequestPendingCenter requestPendingCenter;

    public ResponseDispatcherHandler(RequestPendingCenter requestPendingCenter) {
        this.requestPendingCenter = requestPendingCenter;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ResponseMessage responseMessage) throws Exception {
        requestPendingCenter.set(responseMessage.getMessageHeader().getStreamId(), responseMessage.getMessageBody());
    }
}
