package com.yuanstack.bp.core.design.behavior.template.source;

import java.io.InputStream;
import java.util.AbstractList;

/**
 * @description: 模版模式在Java源码中的应用
 * @author: hansiyuan
 * @date: 2022/3/30 10:27 AM
 */
public class TemplateInJavaSource {
    public static void main(String[] args) {
        // 模版模式在InputStream中的应用(复用)
        templateInInputStream();
        // 模版模式在AbstractList中的应用(复用)
        templateAbstractList();
    }

    private static void templateAbstractList() {
        AbstractList abstractList;
        // 1、public abstract class AbstractList<E> extends AbstractCollection<E> implements List<E>
        // 1.1、public boolean addAll(int index, Collection<? extends E> c)
        // 1.2、public void add(int index, E element)

        // 2、public class LinkedList<E> extends AbstractSequentialList<E> implements List<E>, Deque<E>, Cloneable, java.io.Serializable
        // 2.1、public void add(int index, E element)
    }

    public static void templateInInputStream() {
        InputStream inputStream;
        // 1、public abstract class InputStream implements Closeable
        // 1.1、public int read(byte b[], int off, int len)throws IOException
        // 1.2、public abstract int read() throws IOException;

        // 2、public class ByteArrayInputStream extends InputStream
        // 2.1、public synchronized int read()
    }
}
