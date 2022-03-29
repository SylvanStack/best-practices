package com.yuanstack.bp.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * 请求过滤
 *
 * @author hansiyuan
 * @date 2022年03月19日 17:35
 */
public interface HttpRequestFilter {

    /**
     * 请求过滤
     *
     * @param fullRequest http请求
     * @param ctx         上下文
     */
    void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx);

}
