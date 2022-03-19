package common.message;

import lombok.Data;

/**
 * 消息头
 *
 * @author hansiyuan
 * @date 2022年03月19日 22:36
 */
@Data
public class MessageHeader {

    private int version = 1;
    private int opCode;
    private long streamId;

}
