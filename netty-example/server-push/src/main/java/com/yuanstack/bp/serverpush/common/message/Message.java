package com.yuanstack.bp.serverpush.common.message;

import com.yuanstack.bp.serverpush.util.JsonUtil;
import io.netty.buffer.ByteBuf;
import lombok.Data;

import java.nio.charset.StandardCharsets;

/**
 * Message = MessageHeader + MessageBody
 *
 * @author hansiyuan
 * @date 2022年03月19日 22:37
 */
@Data
public abstract class Message<T extends MessageBody> {

    private MessageHeader messageHeader;
    private T messageBody;

    public T getMessageBody() {
        return messageBody;
    }

    /**
     * 编码
     *
     * @param byteBuf 缓冲字节
     */
    public void encode(ByteBuf byteBuf) {
        byteBuf.writeInt(messageHeader.getVersion());
        byteBuf.writeLong(messageHeader.getStreamId());
        byteBuf.writeInt(messageHeader.getOpCode());
        byteBuf.writeBytes(JsonUtil.toJson(messageBody).getBytes());
    }

    /**
     * 根据操作码获取解码类
     *
     * @param opcode 操作码
     * @return 解码类
     */
    public abstract Class<T> getMessageBodyDecodeClass(int opcode);

    /**
     * 解码  ByteBuf -> Java Object
     *
     * @param msg 消息缓冲字节码
     */
    public void decode(ByteBuf msg) {
        int version = msg.readInt();
        long streamId = msg.readLong();
        int opCode = msg.readInt();

        MessageHeader messageHeader = new MessageHeader();
        messageHeader.setVersion(version);
        messageHeader.setOpCode(opCode);
        messageHeader.setStreamId(streamId);
        this.messageHeader = messageHeader;

        Class<T> bodyClazz = getMessageBodyDecodeClass(opCode);
        T body = JsonUtil.fromJson(msg.toString(StandardCharsets.UTF_8), bodyClazz);
        this.messageBody = body;
    }

}
