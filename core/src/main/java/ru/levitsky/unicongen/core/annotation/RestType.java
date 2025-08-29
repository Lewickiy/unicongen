package ru.levitsky.unicongen.core.annotation;

import ru.levitsky.unicongen.core.enumeration.RestOperationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation used inside {@link ru.levitsky.unicongen.core.annotation.ExposeAs}
 * to specify the REST operation type for a service method.
 * <p>
 * Provides configuration for mapping service methods to HTTP endpoints.
 * </p>
 *
 * <p>Fields:</p>
 * <ul>
 *     <li>{@code value} — defines the HTTP method, represented by {@link RestOperationType} enum
 *         (GET, POST, PUT, DELETE). Required.</li>
 *     <li>{@code path} — optional relative path appended to the base path defined
 *         in {@link ru.levitsky.unicongen.core.annotation.RestApiRoot}. Default is empty string.</li>
 * </ul>
 *
 * <p>Example usage:</p>
 * <pre>{@code
 * @ExposeAs(
 *     rest = @RestType(value = RestOperationType.GET, path = "/hello")
 * )
 * public String hello(String name) {
 *     return "Hello, " + name;
 * }
 * }</pre>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface RestType {

    /**
     * HTTP method for the service method.
     *
     * @return the REST operation type (GET, POST, PUT, DELETE)
     */
    RestOperationType value();

    /**
     * Optional relative path appended to the base path.
     *
     * @return the relative path for this method
     */
    String path() default "";
}
