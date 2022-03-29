package com.yuanstack.bp.serverpush.common;

import com.yuanstack.bp.serverpush.common.auth.AuthOperation;
import com.yuanstack.bp.serverpush.common.auth.AuthOperationResult;
import com.yuanstack.bp.serverpush.common.device.DeviceOperation;
import com.yuanstack.bp.serverpush.common.device.DeviceOperationResult;
import com.yuanstack.bp.serverpush.common.keepalive.KeepaliveOperation;
import com.yuanstack.bp.serverpush.common.keepalive.KeepaliveOperationResult;
import lombok.Getter;

import java.util.function.Predicate;

/**
 * 操作类型 权限、KeepLive 、设备
 *
 * @author hansiyuan
 * @date 2022年03月19日 22:38
 */
public enum OperationType {

    AUTH(1, AuthOperation.class, AuthOperationResult.class),
    /**
     * 心跳+idle检测
     */
    KEEPALIVE(2, KeepaliveOperation.class, KeepaliveOperationResult.class),
    /**
     * 设备业务操作类型
     */
    DEVICE(3, DeviceOperation.class, DeviceOperationResult.class);

    /**
     * 操作码
     */
    @Getter
    private final int opCode;
    /**
     * 执行的编码操作类
     */
    @Getter
    private final Class<? extends Operation> operationClazz;
    /**
     * 执行的编码操作结果类
     */
    @Getter
    private final Class<? extends OperationResult> operationResultClazz;

    OperationType(int opCode, Class<? extends Operation> operationClazz, Class<? extends OperationResult> responseClass) {
        this.opCode = opCode;
        this.operationClazz = operationClazz;
        this.operationResultClazz = responseClass;
    }

    /**
     * 根据操作码获取操作类型枚举
     *
     * @param type 操作码
     * @return 操作类型枚举
     */
    public static OperationType fromOpCode(int type) {
        return getOperationType(requestType -> requestType.opCode == type);
    }

    /**
     * 根据编码操作类获取操作类型枚举
     *
     * @param operation 编码操作类
     * @return 操作类型枚举
     */
    public static OperationType fromOperation(Operation operation) {
        return getOperationType(requestType -> requestType.operationClazz == operation.getClass());
    }

    /**
     * 根据predicate表达式获取操作类型枚举
     *
     * @param predicate predicate表达式
     * @return 操作类型枚举
     */
    private static OperationType getOperationType(Predicate<OperationType> predicate) {
        OperationType[] values = values();
        for (OperationType operationType : values) {
            if (predicate.test(operationType)) {
                return operationType;
            }
        }
        throw new AssertionError("no found type");
    }
}
