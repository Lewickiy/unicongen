# UniConGen (Universal Contract Generator)

[![MIT License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

**UniConGen** is a Java library for **generating REST, gRPC, GraphQL APIs and Kafka producers/consumers** from annotated services.  
Its goal is to simplify microservice contract creation by automatically generating code for inter-service communication.

> **Note:** The project is currently in **Prototype / MVP** state.  
> REST and gRPC modules contain placeholders, Kafka and GraphQL are under development.

---

## Features

- Generate API contracts for multiple technologies from a single annotated service.
- Modular architecture:
  - `core` — library core
  - `api-rest` — **REST API** generation (MVP)
  - `api-grpc` — **gRPC API** generation (MVP)
  - `api-graphql` — **GraphQL** generation (under development)
  - `api-kafka` — **Kafka producers/consumers** generation (under development)
- Annotations for generation configuration:
  - `@ExposedService`, `@ExposeAs`
  - `@RestApiRoot`, `@GrpcApiRoot`
- Compatible with Java 21 and Gradle

---

## Architecture and Modules

```text
unicongen/
│
├─ core/           # Core: annotation scanning, models, generation logic
├─ api-rest/       # REST generation (MVP)
├─ api-grpc/       # gRPC generation (MVP)
├─ api-graphql/    # GraphQL generation (under development)
└─ api-kafka/      # Kafka generation (under development)
```

## Example of an Annotated Service (current implementation)
```java
@ExposedService
@RestApiRoot(basePath = "/greeting")
@GrpcApiRoot(serviceName = "GreetingService", packageName = "ru.levitsky.grpc")
public class GreetingService {

    @ExposeAs(rest = @RestType(RestOperationType.GET))
    public String hello(String name) {
        return "Hello, " + name;
    }

    @ExposeAs(rest = @RestType(RestOperationType.POST))
    public String helloPost(String name) {
        return "Hello, " + name + " posted";
    }

    @ExposeAs(graphql = @GraphQLType(GraphQLOperationType.QUERY))
    public String greet(String name) {
        return "Greetings, " + name;
    }

    @ExposeAs(kafka = @KafkaType(KafkaOperatorType.PRODUCER))
    public String sendMessage(String message) {
        return "Message sent: " + message;
    }
}
```

## Demo Usage Example
```java
package ru.levitsky.unicongen.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.levitsky.unicongen.core.model.ExposedClass;
import ru.levitsky.unicongen.core.scanner.ExposeScanner;

import java.util.Set;

public class Demo {

    private static final Logger log = LoggerFactory.getLogger(Demo.class);

    public static void main(String[] args) {
        log.info("Starting UniConGen Demo...");

        Set<ExposedClass> exposedMethods = ExposeScanner.scan("ru.levitsky.unicongen.core.demo");

        if (exposedMethods.isEmpty()) {
            log.warn("No exposed methods found");
        } else {
            log.info("Exposed methods found:");
            exposedMethods.forEach(exposed -> log.info(exposed.toString()));
        }

        log.info("Demo finished");
    }
}
```

### Example Console Output
```bash
11:32:30 [main] INFO ru.levitsky.unicongen.core.Demo - Starting UniConGen Demo...
11:32:30 [main] INFO ru.levitsky.unicongen.core.Demo - Exposed methods found:
ExposedClass(technology=REST, operationType=POST, clazz=class GreetingService, method=helloPost)
ExposedClass(technology=KAFKA, operationType=PRODUCER, clazz=class GreetingService, method=sendMessage)
...
11:32:30 [main] INFO ru.levitsky.unicongen.core.Demo - Demo finished.
```

## Setup and Installation
```gradle
dependencies {
    implementation project(':core')
}
```
*Other modules (`api-rest`, `api-grpc`, `api-graphql`, `api-kafka`) will be included as they become ready*

## License
The project is licensed under the MIT License – see [LICENSE](https://github.com/Lewickiy/unicongen/tree/main?tab=MIT-1-ov-file)

## Contribution
Contributions are welcome! Please open `issues` or `pull requests` for bug fixes, improvements, or feature proposals

## Roadmap
- Full **REST API** generation (`api-rest`)
- Full **gRPC API** generation (`api-grpc`)
- **Kafka producers/consumers** (`api-kafka`)
- **GraphQL** generation (`api-graphql`)
- Transition from **runtime Scanner** to **Annotation Processor**
- Structured **logging** across all modules
- **Unit tests** and **CI/CD integration**