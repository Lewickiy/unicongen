package ru.levitsky.unicongen.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks a class as an "exposable service" for UniConGen.
 * <br>
 * Any class annotated with {@code @ExposedService} will be scanned by the<br>
 * UniConGen framework for methods annotated with {@link ExposeAs}.<br>
 * These methods will then be automatically exposed as endpoints or<br>
 * producers/consumers, depending on the specified {@link ru.levitsky.unicongen.core.enumeration.ExposureType}.
 *
 * <p><b>Usage example:</b></p>
 * <pre>{@code
 * @ExposedService
 * public class GreetingService {
 *
 *     @ExposeAs(ExposureType.REST)
 *     public String hello(String name) { ... }
 *
 *     @ExposeAs(ExposureType.GRAPHQL)
 *     public String greet(String name) { ... }
 * }
 * }</pre>
 *
 * Only public classes should be annotated.<br>
 * Methods without {@code @ExposeAs} will be ignored by the scanner.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ExposedService {
}
