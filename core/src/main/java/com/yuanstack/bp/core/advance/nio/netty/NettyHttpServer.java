package com.yuanstack.bp.core.advance.nio.netty;

/**
 * @author hansiyuan
 * @date 2022年03月07日 22:16
 */
public class NettyHttpServer {
    public static void main(String[] args) {
        HttpServer httpServer = new HttpServer();
        try {
            httpServer.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
