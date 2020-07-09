package com.study.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Properties;

public class Config {
    private FileInputStream fis;
    private Properties property = new Properties();

    public Config() {
        try {
            fis = new FileInputStream(".\\src\\com\\study\\application.properties");
            property.load(fis);
        } catch (IOException e) {
            System.out.println("Error: properties file is empty!");
        }
    }

    public String getValue(String key) {
        return property.getProperty(key);
    }

    public void setProperties(Object object) {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof ConfigProperty) {
                    String name = ((ConfigProperty) annotation).value();
                    field.setAccessible(true);
                    try {
                        field.set(object, this.getValue(name));
                    } catch (IllegalAccessException e) {
                        System.out.println("No data");
                    }
                }
            }
        }
    }
}
