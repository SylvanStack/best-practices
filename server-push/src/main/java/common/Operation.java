package common;

import common.message.MessageBody;

/**
 * 执行的编码操作
 *
 * @author hansiyuan
 * @date 2022年03月19日 22:35
 */
public abstract class Operation extends MessageBody {

    /**
     * 执行操作
     *
     * @return 操作结果
     */
    public abstract OperationResult execute();

}
