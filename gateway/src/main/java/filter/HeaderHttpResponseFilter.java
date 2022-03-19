package filter;

import io.netty.handler.codec.http.FullHttpResponse;

/**
 * 响应Header添加
 *
 * @author hansiyuan
 * @date 2022年03月19日 17:38
 */
public class HeaderHttpResponseFilter implements HttpResponseFilter {
    @Override
    public void filter(FullHttpResponse response) {
        response.headers().set("bp", "best-practices");
    }
}
