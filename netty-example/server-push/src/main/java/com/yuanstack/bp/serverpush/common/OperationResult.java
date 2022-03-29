package com.yuanstack.bp.serverpush.common;

import com.yuanstack.bp.serverpush.common.message.MessageBody;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 执行的编码操作结果
 *
 * @author hansiyuan
 * @date 2022年03月19日 22:35
 */
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class OperationResult extends MessageBody {

}
