package ru.levitsky.unicongen.core.annotation;

import ru.levitsky.unicongen.core.enumeration.KafkaOperatorType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface KafkaType {
    KafkaOperatorType value();
}
