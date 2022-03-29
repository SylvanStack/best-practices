package com.yuanstack.bp.serverpush.client.codec;

import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * 客户端 一次解码器
 *
 * @author hansiyuan
 * @date 2022年03月19日 23:16
 */
public class ClientFrameDecoder extends LengthFieldBasedFrameDecoder {
    public ClientFrameDecoder() {
        super(Integer.MAX_VALUE, 0, 2, 0, 2);
    }
}
