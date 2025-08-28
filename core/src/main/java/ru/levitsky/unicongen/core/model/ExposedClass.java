package ru.levitsky.unicongen.core.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import ru.levitsky.unicongen.core.enumeration.ExposureType;

import java.lang.reflect.Method;

@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = {"technology", "operationType", "clazz", "method"})
@ToString
public class ExposedClass {
    private final ExposureType technology;
    private final String operationType; // GET, POST, PRODUCER, CONSUMER, QUERY, UNARY и т.д.
    private final Class<?> clazz;
    private final Method method;
}

