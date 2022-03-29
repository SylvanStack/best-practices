package com.yuanstack.bp.serverpush.common.auth;

import com.yuanstack.bp.serverpush.common.OperationResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 授权操作结果类
 *
 * @author hansiyuan
 * @date 2022年03月19日 22:45
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AuthOperationResult extends OperationResult {
    private final boolean passAuth;
}
