package common.message;

import common.OperationResult;
import common.OperationType;

/**
 * 响应信息 操作对应响应结果
 *
 * @author hansiyuan
 * @date 2022年03月19日 22:39
 */
public class ResponseMessage extends Message<OperationResult> {
    @Override
    public Class getMessageBodyDecodeClass(int opcode) {
        return OperationType.fromOpCode(opcode).getOperationResultClazz();
    }
}
