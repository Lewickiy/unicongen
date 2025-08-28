package ru.levitsky.unicongen.core.demo;

import ru.levitsky.unicongen.core.annotation.ExposeAs;
import ru.levitsky.unicongen.core.annotation.ExposedService;
import ru.levitsky.unicongen.core.annotation.GraphQLType;
import ru.levitsky.unicongen.core.annotation.KafkaType;
import ru.levitsky.unicongen.core.annotation.RestType;
import ru.levitsky.unicongen.core.enumeration.GraphQLOperationType;
import ru.levitsky.unicongen.core.enumeration.KafkaOperatorType;
import ru.levitsky.unicongen.core.enumeration.RestOperationType;

@ExposedService
public class GreetingService {

    @ExposeAs(rest = @RestType(value = RestOperationType.GET, path = "/getByName"))
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
