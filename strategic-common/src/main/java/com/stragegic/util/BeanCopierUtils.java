package com.stragegic.util;



import net.sf.cglib.beans.BeanCopier;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author chaowei
 * 工具类
 * */

public class BeanCopierUtils {

    private static Map<String, BeanCopier> beanCopierMap = new HashMap<>();

    public static void copy(Object src, Object dest) {
        if (src==null) {
            return;
        }
        Objects.requireNonNull(dest);
        String key = getKey(src, dest);
        BeanCopier beanCopier;
        if (!beanCopierMap.containsKey(key)) {
            beanCopier = BeanCopier.create(src.getClass(), dest.getClass(), false);
            beanCopierMap.put(key, beanCopier);
        } else {
            beanCopier = beanCopierMap.get(key);
        }
        beanCopier.copy(src, dest, null);
    }

    public static <T> T copy(Object src, Class<T> destClass) {
        if (src==null) {
            return null;
        }
        Objects.requireNonNull(destClass);
        T dest;
        try {
            dest = destClass.getDeclaredConstructor().newInstance();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
            IllegalArgumentException | InvocationTargetException e) {
            throw new IllegalArgumentException(e);
        }
        copy(src, dest);
        return dest;
    }

    public static <T, S> List<T> copyList(List<S> srcList, Class<T> destClass) {
        Objects.requireNonNull(destClass);
        return srcList
            .stream()
            .map(src -> copy(src, destClass))
            .collect(Collectors.toList());
    }

    private static String getKey(Object src, Object dest) {
        return src.getClass().getName() + dest.getClass().getName();
    }

}
