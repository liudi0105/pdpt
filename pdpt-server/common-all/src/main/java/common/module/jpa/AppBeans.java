package common.module.jpa;

import common.module.util.AppReflections;
import common.module.util.model.SerializableFunction;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.FeatureDescriptor;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AppBeans {

    private static Set<String> nullablePropSet(Object source, boolean nullable) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        return Arrays.stream(src.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .filter(name -> (src.getPropertyValue(name) == null) == nullable)
                .collect(Collectors.toSet());
    }

    public static void copyProperties(Object source, Object target) {
        BeanUtils.copyProperties(source, target);
    }

    public static <V> V valueOf(Object obj, String propName) {
        return (V) new BeanWrapperImpl(obj).getPropertyValue(propName);
    }

    public static <T, V> V valueOf(T obj, SerializableFunction<T, V> func) {
        return (V) new BeanWrapperImpl(obj).getPropertyValue(AppReflections.getFieldName(func));
    }

    public static <T> T copyNonNullField(Object source, T target) {
        BeanUtils.copyProperties(source, target, nullPropArray(source));
        return target;
    }

    public static Set<String> nullProps(Object source) {
        return nullablePropSet(source, true);
    }

    public static Set<String> nonNullProps(Object source) {
        return nullablePropSet(source, false);
    }

    public static String[] nullPropArray(Object source) {
        return nullProps(source).toArray(new String[0]);
    }

    public static String[] nonNullPropArray(Object source) {
        return nonNullProps(source).toArray(new String[0]);
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
