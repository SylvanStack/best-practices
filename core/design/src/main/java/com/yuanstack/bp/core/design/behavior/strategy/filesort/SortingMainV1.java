package com.yuanstack.bp.core.design.behavior.strategy.filesort;

/**
 * @description: 待重构的排序工具类
 * @author: hansiyuan
 * @date: 2022/4/1 10:52 AM
 */
public class SortingMainV1 {
    public static void main(String[] args){
        SorterV1 sorter = new SorterV1();
        sorter.sortFile(args[0]);
    }
}
