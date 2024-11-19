package com.example.context;

public class BaseContext {
    //    ThreadLocal 是 Java 中的一个类，用于创建线程本地变量。它提供了一种在多线程环境下，每个线程都有自己独立的变量副本的能力
    public static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static void setCurrentId(Long id) {
        threadLocal.set(id);
    }

    public static Long getCurrentId() {
        return threadLocal.get();
    }

    public static void removeCurrentId() {
        threadLocal.remove();
    }
}
