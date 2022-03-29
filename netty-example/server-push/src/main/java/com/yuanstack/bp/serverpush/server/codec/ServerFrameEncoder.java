package com.yuanstack.bp.serverpush.server.codec;

import io.netty.handler.codec.LengthFieldPrepender;

/**
 * 一次编码器 解决粘包、半包问题
 *
 * @author hansiyuan
 * @date 2022年03月19日 22:42
 */
public class ServerFrameEncoder extends LengthFieldPrepender {
    /**
     * 采用封装成帧：固定长度字段存个内容的长度信息的方式解决粘包、半包问题
     * lengthFieldLength：长度字段大小 占用2个字节
     */
    public ServerFrameEncoder() {
        super(2);
    }
}
