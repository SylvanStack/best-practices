package com.yuanstack.bp.serverpush.util;

import com.google.gson.Gson;

/**
 * Json解析转换工具类
 *
 * @author hansiyuan
 * @date 2022年03月19日 22:18
 */
public final class JsonUtil {

    private static final Gson GSON = new Gson();

    private JsonUtil() {
        //no instance
    }

    public static <T> T fromJson(String jsonStr, Class<T> clazz) {
        return GSON.fromJson(jsonStr, clazz);
    }

    public static String toJson(Object object) {
        return GSON.toJson(object);
    }

}
