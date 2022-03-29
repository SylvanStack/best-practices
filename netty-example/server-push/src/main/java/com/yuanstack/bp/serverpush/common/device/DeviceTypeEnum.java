package com.yuanstack.bp.serverpush.common.device;

import lombok.Getter;

/**
 * @author hansiyuan
 * @date 2022年03月19日 22:55
 */
public enum DeviceTypeEnum {
    /**
     * 手机APP
     */
    PHONE_APP("phone_app");

    @Getter
    private final String type;

    DeviceTypeEnum(String type) {
        this.type = type;
    }
}
