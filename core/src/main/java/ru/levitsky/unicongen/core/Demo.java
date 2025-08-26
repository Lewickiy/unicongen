package ru.levitsky.unicongen.core;

import ru.levitsky.unicongen.core.model.ExposedClass;
import ru.levitsky.unicongen.core.scanner.ExposeScanner;

import java.util.Set;

public class Demo {
    public static void main(String[] args) {
        Set<ExposedClass> exposedMethods = ExposeScanner.scan("ru.levitsky.unicongen.core.demo");

        if (exposedMethods.isEmpty()) {
            System.out.println("No exposed methods found.");
        } else {
            System.out.println("Exposed methods:");
            exposedMethods.forEach(System.out::println);
        }
    }
}
