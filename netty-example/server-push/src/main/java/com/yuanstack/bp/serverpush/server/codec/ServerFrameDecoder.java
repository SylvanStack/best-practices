package com.yuanstack.bp.serverpush.server.codec;

import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * 一次解码器 解决粘包、半包问题
 *
 * @author hansiyuan
 * @date 2022年03月19日 22:41
 */
public class ServerFrameDecoder extends LengthFieldBasedFrameDecoder {
    /**
     * 采用封装成帧：固定长度字段存个内容的长度信息的方式解决粘包、半包问题
     * maxFrameLength：帧的最大长度
     * lengthFieldOffset： 长度字段偏移量 0偏移（特殊情况下可设置）
     * lengthFieldLength：长度字段大小 占用2个字节
     * lengthAdjustment： 数据包调整（偏移） 例如数据包前插入某字段 字段占两个字节 就需设置值为2 不设置为0
     * initialBytesToStrip：是否读取头字段  不设置的话获取的数据为 长度+数据 设置为长度值2 只取数据集（易错点 需设置）
     */
    public ServerFrameDecoder() {
        super(10240, 0, 2, 0, 2);
    }
}
