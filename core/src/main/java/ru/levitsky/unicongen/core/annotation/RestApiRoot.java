package ru.levitsky.unicongen.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for specifying the base REST API configuration at the service class level.
 * <p>
 * Used together with {@link ru.levitsky.unicongen.core.annotation.ExposedService} and
 * {@link ru.levitsky.unicongen.core.annotation.ExposeAs} for generating
 * a RestController and corresponding endpoints.
 * </p>
 *
 * <p>Available fields:</p>
 * <ul>
 *     <li>{@code basePath} (String) — required; the base path of the controller, e.g., "/greeting".</li>
 *     <li>{@code version} (String) — optional; API version for path, default "v1".</li>
 *     <li>{@code outputDir} (String) — optional; path where RestController files will be generated, default "src/generated/java".</li>
 *     <li>{@code description} (String) — optional; short description of the service, default empty.</li>
 * </ul>
 *
 * <p>Example usage:</p>
 * <pre>{@code
 * @ExposedService(
 *     restApiRoot = @RestApiRoot(
 *         basePath = "/greeting",
 *         version = "v1",
 *         outputDir = "src/generated/java",
 *         description = "Greeting API"
 *     )
 * )
 * public class GreetingService {
 *     ...
 * }
 * }</pre>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface RestApiRoot {

    /**
     * API version. Used for building the base path,
     * e.g., "/v1". Default is "v1".
     *
     * @return API version
     */
    String version() default "v1";

    /**
     * Base path of the controller. Required field.
     * For example, "/greeting" for all service methods.
     *
     * @return controller base path
     */
    String basePath();

    /**
     * Path for generating RestController files.
     * Default is "src/generated/java".
     *
     * @return output directory for generated files
     */
    String outputDir() default "src/generated/java";

    /**
     * Short description of the service. Used for documentation
     * and can appear in generated API docs.
     *
     * @return service description
     */
    String description() default "";
}
