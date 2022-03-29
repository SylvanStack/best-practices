package com.yuanstack.bp.gateway.router;

import java.util.List;
import java.util.Random;

/**
 * @author hansiyuan
 * @date 2022年03月19日 17:48
 */
public class RandomHttpEndpointRouter implements HttpEndpointRouter {
    @Override
    public String route(List<String> urls) {
        int size = urls.size();
        Random random = new Random(System.currentTimeMillis());
        return urls.get(random.nextInt(size));
    }
}
