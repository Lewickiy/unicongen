package ru.levitsky.unicongen.core.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.levitsky.unicongen.core.model.ExposedClass;
import ru.levitsky.unicongen.core.scanner.ExposeScanner;

import java.util.Set;

public class Demo {
    private static final Logger log = LoggerFactory.getLogger(Demo.class);

    public static void main(String[] args) {
        log.info("Start UniConGen Core Demo");

        String basePackage = "ru.levitsky.unicongen.core";
        Set<ExposedClass> exposedMethods = ExposeScanner.scan(basePackage);

        if (exposedMethods.isEmpty()) {
            log.info("No exposed classes found");
        } else {
            log.info("Found {}  exposed classes", exposedMethods.size());
            exposedMethods.forEach(exposed -> log.info(exposed.toString()));
        }
        log.info("Demo finished");
    }
}
