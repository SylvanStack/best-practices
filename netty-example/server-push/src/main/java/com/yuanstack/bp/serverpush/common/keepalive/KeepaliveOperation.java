package com.yuanstack.bp.serverpush.common.keepalive;

import com.yuanstack.bp.serverpush.common.Operation;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.java.Log;

/**
 * 心跳操作
 *
 * @author hansiyuan
 * @date 2022年03月19日 22:45
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Log
public class KeepaliveOperation extends Operation {

    private long time;

    public KeepaliveOperation() {
        this.time = System.nanoTime();
    }

    @Override
    public KeepaliveOperationResult execute() {
        KeepaliveOperationResult orderResponse = new KeepaliveOperationResult(time);
        return orderResponse;
    }
}
