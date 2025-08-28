package ru.levitsky.unicongen.core.annotation;

import ru.levitsky.unicongen.core.enumeration.ExposureType;
import ru.levitsky.unicongen.core.enumeration.GraphQLOperationType;
import ru.levitsky.unicongen.core.enumeration.GrpcOperationType;
import ru.levitsky.unicongen.core.enumeration.KafkaOperatorType;
import ru.levitsky.unicongen.core.enumeration.RestOperationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface ExposeAs {

    GraphQLType graphql() default @GraphQLType(GraphQLOperationType.DEFAULT);

    KafkaType kafka() default @KafkaType(KafkaOperatorType.DEFAULT);

    RestType rest() default @RestType(RestOperationType.DEFAULT);

    GrpcType grpc() default @GrpcType(GrpcOperationType.DEFAULT);
}
