package common.auth;

import common.Operation;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

/**
 * 授权操作类
 *
 * @author hansiyuan
 * @date 2022年03月19日 22:45
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Slf4j
public class AuthOperation extends Operation {

    private final String userName;
    private final String password;

    @Override
    public AuthOperationResult execute() {
        if ("admin".equalsIgnoreCase(this.userName)) {
            AuthOperationResult orderResponse = new AuthOperationResult(true);
            return orderResponse;
        }

        return new AuthOperationResult(false);
    }
}
