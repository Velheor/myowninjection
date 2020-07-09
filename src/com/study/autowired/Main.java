package com.study.autowired;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = Class.forName("com.study.autowired.Presenter");
        Object leftSide = clazz.getDeclaredConstructor().newInstance();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Autowired annotation = field.getAnnotation(Autowired.class);
            if (annotation != null) {
                field.setAccessible(true);
                Class<?> type = field.getType();
                Object rightSide = type.getDeclaredConstructor().newInstance();
                field.set(leftSide, rightSide);
            }
        }
        System.out.println(" " + leftSide);
    }
}
