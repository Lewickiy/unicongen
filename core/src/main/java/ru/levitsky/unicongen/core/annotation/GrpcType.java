package ru.levitsky.unicongen.core.annotation;

import ru.levitsky.unicongen.core.enumeration.GrpcOperationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface GrpcType {
    GrpcOperationType value();
}
