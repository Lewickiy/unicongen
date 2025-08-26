package ru.levitsky.unicongen.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.levitsky.unicongen.core.enumeration.ExposureType;

import java.lang.reflect.Method;

@AllArgsConstructor
@Getter
public class ExposedClass {

    private final Class<?> clazz;
    private final Method method;
    private final ExposureType exposureType;

    @Override
    public String toString() {
        return clazz.getName() + "#" + method.getName() + " > " + exposureType;
    }
}
