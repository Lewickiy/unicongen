package ru.levitsky.unicongen.core.scanner;

import org.reflections.Reflections;
import ru.levitsky.unicongen.core.annotation.ExposeAs;
import ru.levitsky.unicongen.core.annotation.ExposedService;
import ru.levitsky.unicongen.core.enumeration.ExposureType;
import ru.levitsky.unicongen.core.model.ExposedClass;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class ExposeScanner {
    public static Set<ExposedClass> scan(String basePackage) {
        Reflections reflections = new Reflections(basePackage);
        Set<ExposedClass> exposed = new HashSet<>();

        // Находим все классы
        Set<Class<?>> classes = reflections.getSubTypesOf(Object.class);
        classes.addAll(reflections.getTypesAnnotatedWith(ExposedService.class));

        for (Class<?> clazz : classes) {
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent(ExposeAs.class)) {
                    ExposeAs annotation = method.getAnnotation(ExposeAs.class);
                    ExposureType type = annotation.value();
                    exposed.add(new ExposedClass(clazz, method, type));
                }
            }
        }

        return exposed;
    }
}
