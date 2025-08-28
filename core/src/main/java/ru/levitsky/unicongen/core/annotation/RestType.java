package ru.levitsky.unicongen.core.annotation;

import ru.levitsky.unicongen.core.enumeration.RestOperationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * В качестве параметров мошут быть установлены
 * value = {@link RestOperationType} со значениями `GET`, `POST`, `PUT`, `DELETE`
 * path = "String", в случае если её значение дополняет
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RestType {
    RestOperationType value();
    String path() default "";
}
