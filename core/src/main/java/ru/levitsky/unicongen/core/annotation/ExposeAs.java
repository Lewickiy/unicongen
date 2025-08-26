package ru.levitsky.unicongen.core.annotation;

import ru.levitsky.unicongen.core.enumeration.ExposureType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks a method to be exposed by UniConGen as a specific type of endpoint or message handler.
 *
 * <p>When applied to a method, {@code @ExposeAs} indicates that this method should be exposed
 * according to the specified {@link ExposureType} (REST, gRPC, GraphQL, Kafka, etc.).</p>
 *
 * <p><b>Usage example:</b></p>
 * <pre>{@code
 * @ExposedService
 * public class GreetingService {
 *
 *     @ExposeAs(ExposureType.REST)
 *     public String hello(String name) { ... } // exposed as REST
 *
 *     @ExposeAs(ExposureType.GRAPHQL)
 *     public String greet(String name) { ... } // exposed as GraphQL
 *
 *     public String sendMessage(String message) { ... } // not exposed
 * }
 * }</pre>
 *
 * <p>Only methods explicitly annotated with {@code @ExposeAs} will be exposed.
 * Methods without {@code @ExposeAs} will be ignored by the scanner.</p>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface ExposeAs {

    /**
     * The type of exposure for this method.
     * Defaults to {@link ExposureType#REST}.
     */
    ExposureType value() default ExposureType.REST;
}
