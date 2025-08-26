package ru.levitsky.unicongen.core.demo;

import ru.levitsky.unicongen.core.annotation.ExposeAs;
import ru.levitsky.unicongen.core.annotation.ExposedService;
import ru.levitsky.unicongen.core.enumeration.ExposureType;

@ExposedService
public class GreetingService {

    @ExposeAs(ExposureType.REST)
    public String hello(String name) {
        return "Hello, " + name;
    }

    @ExposeAs(ExposureType.GRAPHQL)
    public String greet(String name) {
        return "Greetings, " + name;
    }

    @ExposeAs(ExposureType.KAFKA)
    public String sendMessage(String message) {
        return "Message sent: " + message;
    }
}
