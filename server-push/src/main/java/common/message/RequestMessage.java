package common.message;

import common.Operation;
import common.OperationType;

/**
 * 请求信息 对应相应的操作
 *
 * @author hansiyuan
 * @date 2022年03月19日 22:38
 */
public class RequestMessage extends Message<Operation> {
    public RequestMessage() {
    }

    public RequestMessage(Long streamId, Operation operation) {
        MessageHeader messageHeader = new MessageHeader();
        messageHeader.setStreamId(streamId);
        messageHeader.setOpCode(OperationType.fromOperation(operation).getOpCode());
        this.setMessageHeader(messageHeader);
        this.setMessageBody(operation);
    }

    /**
     * 根据操作码获取操作类
     *
     * @param opcode 操作码
     * @return 操作类
     */
    @Override
    public Class getMessageBodyDecodeClass(int opcode) {
        return OperationType.fromOpCode(opcode).getOperationClazz();
    }

}
