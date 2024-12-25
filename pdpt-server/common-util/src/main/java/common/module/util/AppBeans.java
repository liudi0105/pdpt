package common.module.util;

import common.module.util.model.SerializableFunction;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.reflect.ConstructorUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.lang3.reflect.MethodUtils;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 一个自定义工具类，用于实现类似于 Spring 的 BeanUtils 功能。
 * 该实现基于 Apache Commons 工具包，提供属性拷贝、字段操作、方法调用等功能。
 */
public class AppBeans {

    /**
     * 将源对象的属性拷贝到目标对象中。
     * 使用 Apache Commons 的 BeanUtils 实现属性拷贝。
     *
     * @param source 源对象
     * @param target 目标对象
     * @throws RuntimeException 如果属性拷贝失败
     */
    public static void copyProperties(Object source, Object target) {
        try {
            BeanUtils.copyProperties(target, source);
        } catch (Exception e) {
            throw new RuntimeException("属性拷贝失败", e);
        }
    }

    /**
     * 实例化给定类的一个新对象。
     * 使用 Apache Commons 的 ConstructorUtils 创建实例。
     *
     * @param clazz 要实例化的类
     * @param <T>   对象类型
     * @return 类的一个新实例
     * @throws RuntimeException 如果实例化失败
     */
    public static <T> T instantiateClass(Class<T> clazz) {
        try {
            return ConstructorUtils.invokeConstructor(clazz);
        } catch (Exception e) {
            throw new RuntimeException("实例化类失败", e);
        }
    }

    /**
     * 获取对象的指定属性值。
     * 使用 Apache Commons 的 PropertyUtils。
     *
     * @param bean         要获取属性的对象
     * @param propertyName 属性名称
     * @return 属性值
     * @throws RuntimeException 如果获取属性值失败
     */
    public static Object getProperty(Object bean, String propertyName) {
        try {
            return PropertyUtils.getProperty(bean, propertyName);
        } catch (Exception e) {
            throw new RuntimeException("获取属性值失败", e);
        }
    }

    /**
     * 设置对象的指定属性值。
     * 使用 Apache Commons 的 PropertyUtils。
     *
     * @param bean         要设置属性的对象
     * @param propertyName 属性名称
     * @param value        要设置的属性值
     * @throws RuntimeException 如果设置属性值失败
     */
    public static void setProperty(Object bean, String propertyName, Object value) {
        try {
            PropertyUtils.setProperty(bean, propertyName, value);
        } catch (Exception e) {
            throw new RuntimeException("设置属性值失败", e);
        }
    }

    /**
     * 获取对象的指定字段值，包括私有字段。
     * 使用 Apache Commons 的 FieldUtils。
     *
     * @param bean      要获取字段值的对象
     * @param fieldName 字段名称
     * @return 字段值
     * @throws RuntimeException 如果获取字段值失败
     */
    public static Object getFieldValue(Object bean, String fieldName) {
        try {
            return FieldUtils.readField(bean, fieldName, true); // true 表示忽略访问权限
        } catch (Exception e) {
            throw new RuntimeException("获取字段值失败", e);
        }
    }

    /**
     * 设置对象的指定字段值，包括私有字段。
     * 使用 Apache Commons 的 FieldUtils。
     *
     * @param bean      要设置字段值的对象
     * @param fieldName 字段名称
     * @param value     要设置的字段值
     * @throws RuntimeException 如果设置字段值失败
     */
    public static void setFieldValue(Object bean, String fieldName, Object value) {
        try {
            FieldUtils.writeField(bean, fieldName, value, true); // true 表示忽略访问权限
        } catch (Exception e) {
            throw new RuntimeException("设置字段值失败", e);
        }
    }

    /**
     * 调用对象的指定方法。
     * 使用 Apache Commons 的 MethodUtils。
     *
     * @param bean       要调用方法的对象
     * @param methodName 方法名称
     * @param args       方法参数
     * @return 方法调用的返回值
     * @throws RuntimeException 如果方法调用失败
     */
    public static Object invokeMethod(Object bean, String methodName, Object... args) {
        try {
            return MethodUtils.invokeMethod(bean, methodName, args);
        } catch (Exception e) {
            throw new RuntimeException("调用方法失败", e);
        }
    }

    /**
     * 获取 Java Bean 中值为 null 的字段名称集合。
     *
     * @param bean 要检查的 Java Bean 对象
     * @return 值为 null 的字段名称集合
     * @throws IllegalArgumentException 如果传入的 bean 为 null
     */
    public static Set<String> getNullProperties(Object bean) {
        if (bean == null) {
            throw new IllegalArgumentException("Bean 不能为 null");
        }

        Set<String> nullFields = new HashSet<>();
        try {
            var descriptors = PropertyUtils.getPropertyDescriptors(bean);

            for (var descriptor : descriptors) {
                String propertyName = descriptor.getName();

                // 跳过 "class" 属性
                if ("class".equals(propertyName)) {
                    continue;
                }

                // 获取属性值
                Object value = PropertyUtils.getProperty(bean, propertyName);

                // 如果值为 null，则记录字段名称
                if (value == null) {
                    nullFields.add(propertyName);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("获取 null 属性失败", e);
        }

        return nullFields;
    }

    /**
     * 调用指定类的静态方法。
     * 使用 Apache Commons 的 MethodUtils。
     *
     * @param clazz      要调用方法的类
     * @param methodName 方法名称
     * @param args       方法参数
     * @return 方法调用的返回值
     * @throws RuntimeException 如果静态方法调用失败
     */
    public static Object invokeStaticMethod(Class<?> clazz, String methodName, Object... args) {
        try {
            return MethodUtils.invokeStaticMethod(clazz, methodName, args);
        } catch (Exception e) {
            throw new RuntimeException("调用静态方法失败", e);
        }
    }

    public static <V> V valueOf(Object bean, String propertyName) {
        try {
            return (V) PropertyUtils.getProperty(bean, propertyName);
        } catch (Exception e) {
            throw new RuntimeException("获取属性值失败: " + propertyName, e);
        }
    }

    public static <T, V> V valueOf(T obj, SerializableFunction<T, V> func) {
        return valueOf(obj , AppReflections.getFieldName(func));
    }

    public static <T> T copyNonNullField(Object source, T target) {
        copyPropertiesIgnoreFields(source, target, getNullProperties(source));
        return target;
    }

    /**
     * 将源对象的属性拷贝到目标对象，仅忽略指定的字段。
     *
     * @param source         源对象
     * @param target         目标对象
     * @param fieldsToIgnore 要忽略的字段集合
     * @throws RuntimeException 如果属性拷贝失败
     */
    public static void copyPropertiesIgnoreFields(Object source, Object target, Set<String> fieldsToIgnore) {
        if (source == null || target == null) {
            throw new IllegalArgumentException("源对象和目标对象不能为空");
        }

        try {
            var descriptors = PropertyUtils.getPropertyDescriptors(source);

            for (var descriptor : descriptors) {
                String propertyName = descriptor.getName();

                // 跳过 "class" 属性或在忽略列表中的字段
                if ("class".equals(propertyName) || (fieldsToIgnore != null && fieldsToIgnore.contains(propertyName))) {
                    continue;
                }

                // 获取属性值并拷贝
                Object value = PropertyUtils.getProperty(source, propertyName);
                PropertyUtils.setProperty(target, propertyName, value);
            }
        } catch (Exception e) {
            throw new RuntimeException("属性拷贝失败", e);
        }
    }

    public static <T> T convert(Object o, Class<T> clazz) {
        T t = AppReflections.newInstance(clazz);
        copyNonNullField(o, t);
        return t;
    }

    public static <T> List<T> convertList(Collection<?> collection, Class<T> clazz) {
        return collection.stream()
                .map(v -> convert(v, clazz))
                .collect(Collectors.toList());
    }
}