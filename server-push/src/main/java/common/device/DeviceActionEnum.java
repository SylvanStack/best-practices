package common.device;

import lombok.Getter;

/**
 * @author hansiyuan
 * @date 2022年03月19日 22:53
 */
public enum DeviceActionEnum {
    /**
     * 连接成功
     */
    CONNECT_SUCCESS("connect_success"),

    /**
     * 连接
     */
    CONNECT("connect");

    @Getter
    private final String action;

    DeviceActionEnum(String action) {
        this.action = action;
    }

}

