package common.device;

import common.OperationResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 设备操作结果类
 *
 * @author hansiyuan
 * @date 2022年03月19日 22:47
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class DeviceOperationResult extends OperationResult {
    /**
     * 设备Key + 设备类型 确定设备的唯一性
     */
    private final String key;
    /**
     * 执行操作指令
     */
    private final String action;
    /**
     * 设备类型
     */
    private final String deviceType;
}