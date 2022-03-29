package com.yuanstack.bp.gateway.router;

import java.util.List;

/**
 * @author hansiyuan
 * @date 2022年03月19日 17:48
 */
public interface HttpEndpointRouter {

    String route(List<String> endpoints);

    // Load Balance
    // Random
    // RoundRibbon
    // Weight
    // - server01,20
    // - server02,30
    // - server03,50

}
