package com.yuanstack.bp.core.advance.concurrent.collection;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author hansiyuan
 * @date 2022年03月19日 18:17
 */
public class TreeMapDemo {

    public static void main(String[] args) {

        //
        TreeMap<Integer, String> map = new TreeMap<>(Comparator.reverseOrder());
        map.put(3, "val");
        map.put(2, "val");
        map.put(1, "val");
        map.put(5, "val");
        map.put(4, "val");
        // {5=val, 4=val, 3=val, 2=val, 1=val}
        System.out.println(map);

        TreeMap<Integer, String> map1 = new TreeMap<>(Comparator.naturalOrder());
        map1.putAll(map);
        System.out.println(map1);
    }

}