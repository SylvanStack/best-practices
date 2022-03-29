package com.yuanstack.bp.serverpush.client.codec;

import io.netty.handler.codec.LengthFieldPrepender;

/**
 * 客户端 一次编码器
 *
 * @author hansiyuan
 * @date 2022年03月19日 23:19
 */
public class ClientFrameEncoder extends LengthFieldPrepender {
    public ClientFrameEncoder() {
        super(2);
    }
}
