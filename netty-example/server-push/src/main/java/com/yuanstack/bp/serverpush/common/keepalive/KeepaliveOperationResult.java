package com.yuanstack.bp.serverpush.common.keepalive;

import com.yuanstack.bp.serverpush.common.OperationResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 心跳操作结果类
 *
 * @author hansiyuan
 * @date 2022年03月19日 22:45
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class KeepaliveOperationResult extends OperationResult {

    private final long time;

}
