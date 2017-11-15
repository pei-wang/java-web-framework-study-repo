package org.smart4j.framework;

import org.apache.commons.lang3.ArrayUtils;
import org.smart4j.framework.annotation.Inject;
import org.smart4j.framework.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

public final class IOCHelper {
    static {
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        for (Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()) {
            Class<?> beanClass = beanEntry.getKey();
            Object beanInstance = beanEntry.getValue();
            Field[] beanFields = beanClass.getDeclaredFields();
            if (ArrayUtils.isNotEmpty(beanFields)) {
                for (Field beanField : beanFields) {
                    if (beanField.isAnnotationPresent(Inject.class)) {
                        Class<?> beanFieldClass = beanField.getType();
                        Object beanFieldInstance = beanMap.get(beanFieldClass);
                        if (beanFieldInstance != null) {
                            ReflectionUtil.setField(beanInstance, beanField, beanFieldInstance);
                        }
                    }
                }
            }
        }
    }
}
