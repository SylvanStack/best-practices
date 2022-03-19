package filter;

import io.netty.handler.codec.http.FullHttpResponse;

/**
 * 响应过滤
 * @author hansiyuan
 * @date 2022年03月19日 17:36
 */
public interface HttpResponseFilter {

    /**
     *  响应过滤
     * @param response 响应
     */
    void filter(FullHttpResponse response);

}
