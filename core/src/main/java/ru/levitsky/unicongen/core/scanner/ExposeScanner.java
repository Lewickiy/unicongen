package ru.levitsky.unicongen.core.scanner;

import org.reflections.Reflections;
import ru.levitsky.unicongen.core.annotation.ExposeAs;
import ru.levitsky.unicongen.core.annotation.ExposedService;
import ru.levitsky.unicongen.core.enumeration.GraphQLOperationType;
import ru.levitsky.unicongen.core.enumeration.GrpcOperationType;
import ru.levitsky.unicongen.core.enumeration.KafkaOperatorType;
import ru.levitsky.unicongen.core.enumeration.RestOperationType;
import ru.levitsky.unicongen.core.model.ExposedClass;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import static ru.levitsky.unicongen.core.enumeration.ExposureType.GRAPHQL;
import static ru.levitsky.unicongen.core.enumeration.ExposureType.GRPC;
import static ru.levitsky.unicongen.core.enumeration.ExposureType.KAFKA;
import static ru.levitsky.unicongen.core.enumeration.ExposureType.REST;

public class ExposeScanner {
    public static Set<ExposedClass> scan(String basePackage) {
        Reflections reflections = new Reflections(basePackage);
        Set<ExposedClass> exposedMethods = new HashSet<>();

        Set<Class<?>> services = reflections.getTypesAnnotatedWith(ExposedService.class);

        for (Class<?> clazz : services) {
            for (Method method : clazz.getMethods()) {
                if (method.isAnnotationPresent(ExposeAs.class)) {
                    ExposeAs expose = method.getAnnotation(ExposeAs.class);

                    if (expose != null) {
                        if (expose.rest().value() != RestOperationType.DEFAULT) {
                            exposedMethods.add(new ExposedClass(REST, expose.rest().value().name(), clazz, method));
                        }

                        if (expose.kafka().value() != KafkaOperatorType.DEFAULT) {
                            exposedMethods.add(new ExposedClass(KAFKA, expose.kafka().value().name(), clazz, method));
                        }

                        if (expose.graphql().value() != GraphQLOperationType.DEFAULT) {
                            exposedMethods.add(new ExposedClass(GRAPHQL, expose.graphql().value().name(), clazz, method));
                        }

                        if (expose.grpc().value() != GrpcOperationType.DEFAULT) {
                            exposedMethods.add(new ExposedClass(GRPC, expose.grpc().value().name(), clazz, method));
                        }
                    }
                }
            }
        }
        return exposedMethods;
    }
}
