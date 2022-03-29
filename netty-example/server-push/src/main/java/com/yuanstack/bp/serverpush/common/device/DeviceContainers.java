package com.yuanstack.bp.serverpush.common.device;

import io.netty.channel.ChannelHandlerContext;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 设备容器类：手机APP设备容器、广告电视设备容器、直播电视设备容器
 *
 * @author hansiyuan
 * @date 2022年03月19日 22:57
 */
public class DeviceContainers {
    private static Map<String, ChannelHandlerContext> phoneAppContainer = new ConcurrentHashMap<>();

    private DeviceContainers() {
    }

    public static void addphoneAppDevice(String key, ChannelHandlerContext ctx) {
        phoneAppContainer.put(key, ctx);
    }

    public static ChannelHandlerContext getphoneAppDevice(String key) {
        return phoneAppContainer.get(key);
    }

    public static Map<String, ChannelHandlerContext> getphoneAppDevices() {
        return phoneAppContainer;
    }

    public static boolean containsphoneAppKey(String key) {
        return phoneAppContainer == null || phoneAppContainer.containsKey(key);
    }

}
