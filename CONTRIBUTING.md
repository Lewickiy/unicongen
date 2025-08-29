# UniConGen Documentation Standards
This document defines the standards for writing documentation in the UniConGen repository. 
Following these standards ensures consistency, readability, and ease of contribution.

## 1. General Guidelines
- **Primary Language:** English
- **File Format:** Markdown (`.md`)
- **Headings:** Use `#`, `##`, `###` to organize content.
- **Code Blocks:** Use triple backticks (```) with language specification.
- **Inline Code:** Use single backticks (\`code`) for inline references.

## 2. Javadoc for Annotations and Classes
- All annotations and public classes must include Javadoc.
- Explain the purpose, parameters, and provide examples.
- Use {@link ClassName} to reference other classes or annotations.
- Example for an annotation: 
    ```java
    /**
     * Annotation for specifying the base REST API configuration at the service class level.
     * Used with {@link ExposedService} and {@link ExposeAs} for generating a RestController.
     *
     * Available fields:
     * - {@code basePath} (String) — required; the base path of the controller, e.g., "/greeting".
     * - {@code version} (String) — optional; API version for path, default "v1".
     * - {@code outputDir} (String) — optional; path where RestController files will be generated.
     * - {@code description} (String) — optional; short description of the service.
     *
     * Example usage:
     * {@code
     * @ExposedService(
     *     restApiRoot = @RestApiRoot(
     *         basePath = "/greeting",
     *         version = "v1",
     *         outputDir = "src/generated/java",
     *         description = "Greeting API"
     *     )
     * )
     * public class GreetingService { ... }
     * }
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.ANNOTATION_TYPE)
    public @interface RestApiRoot {
        String version() default "v1";
        String basePath();
        String outputDir() default "src/generated/java";
        String description() default "";
    }
    ```

## 3. README.md Requirements
- Project name and short description.
- License badge and link.
- Example usage of the library.
- Project structure and modules:
    ```text
    unicongen/
    ├─ core/
    ├─ api-rest/
    ├─ api-grpc/
    ├─ api-graphql/
    └─ api-kafka/
    ```
- Roadmap (optional).
- Contribution guidelines (link to CONTRIBUTING.md).

## 4. Issues and Pull Requests
- **Issues** should include:
  - Title (concise and descriptive)
  - Description (details, requirements, example if needed)
  - Labels (bug, enhancement, docs, help wanted, discussion)
  - Milestone (default Backlog)
- **Pull Requests** should:
  - Reference related issue(s)
  - Follow commit message conventions
  - Include description of changes and impact
## 5. Commit Workflow
**1.Branching:**
- Each feature, fix, or task should be done in its own branch.
- Branch names should be descriptive, e.g., feature/rest-api-root, fix/logger-issue.

**2. Pull Requests:**
- All branches are merged into the development branch via Pull Requests (PRs).
- Direct commits to development are discouraged; use PRs for code review and discussion.

**3. Commit Message Guidelines**

We follow **Conventional Commits** with some customization for this project.
- **Use imperative mood:** `Add`, `Fix`, `Update`, `Refactor`, `Docs`.
- **Structure:**
    ```text
    type(scope): short description

    Detailed explanation if necessary
    ```
- **Examples:**
    ```text
    docs(annotation): add full Javadoc for @RestType
    feat(core): implement Annotation Processor prototype
    refactor(core): replace runtime Scanner with modular API
    ```
This workflow keeps the repository organized, ensures **traceability**, and maintains a **clean development history**.    

## 6. Contribution
- Contributions are welcome: bug fixes, enhancements, or documentation improvements.
- Open issues or submit pull requests.
- Always follow the documentation standards described here.

## 7. Example Annotations Reference
- `@ExposedService` — Marks a service class to be exposed via one or multiple technologies.
- `@RestApiRoot` — Base REST API configuration inside `@ExposedService`.
- `@GrpcApiRoot` — Base gRPC configuration inside `@ExposedService`.
- `@ExposeAs` — Nested annotations specifying operation type per technology (`@RestType`, `@GraphQLType`, `@KafkaType`, `@GrpcType`).
- `@RestType` — Defines HTTP method and optional relative path for REST endpoints.
