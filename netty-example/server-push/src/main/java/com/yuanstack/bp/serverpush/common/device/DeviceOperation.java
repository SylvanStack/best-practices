package com.yuanstack.bp.serverpush.common.device;

import com.yuanstack.bp.serverpush.common.Operation;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

/**
 * @author hansiyuan
 * @date 2022年03月19日 22:47
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Slf4j
public class DeviceOperation extends Operation {

    /**
     * 设备Key + 设备类型 确定设备的唯一性
     */
    private final String key;
    /**
     * 执行操作指令
     */
    private String action;
    /**
     * 设备类型
     */
    private String deviceType;

    public DeviceOperation(String key, String action, String deviceType) {
        this.key = key;
        this.action = action;
        this.deviceType = deviceType;
    }

    /**
     * 执行操作（主要连接操作）
     *
     * @return 操作结果
     */
    @Override
    public DeviceOperationResult execute() {
        log.info("设备操作开始执行..." + toString());
        DeviceOperationResult orderResponse = new DeviceOperationResult(key, DeviceActionEnum.CONNECT_SUCCESS.toString(), deviceType);
        log.info("设备操作执行结束...");
        return orderResponse;
    }
}

