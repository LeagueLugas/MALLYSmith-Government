package com.github.kodomo.mallysmith.government.bean;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BeanContainer {

    private final static Map<Class<?>, Object> BEANS = new HashMap<>();

    public static <T> T registerBean(Class<T> tClass, Object... params) {
        try {
            Constructor<T> constructor = tClass.getConstructor(
                    Arrays.stream(params)
                            .map(Object::getClass)
                            .toArray(Class[]::new)
            );
            constructor.setAccessible(true);
            T instance = constructor.newInstance(params);
            BEANS.put(tClass, instance);
            return instance;
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            return null;
        }
    }

    public static <T> T getBean(Class<T> tClass) {
        return tClass.cast(BEANS.get(tClass));
    }

    public static void test() {
        System.out.println(BEANS);
    }

}
