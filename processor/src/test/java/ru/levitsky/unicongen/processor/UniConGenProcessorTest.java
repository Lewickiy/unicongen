package ru.levitsky.unicongen.processor;

import com.google.testing.compile.Compilation;
import com.google.testing.compile.Compiler;
import org.junit.Test;

import javax.tools.JavaFileObject;

import static com.google.testing.compile.CompilationSubject.assertThat;
import static com.google.testing.compile.JavaFileObjects.forSourceLines;

public class UniConGenProcessorTest {
    @Test
    public void testProcessorCompilesWithoutErrors() {

        JavaFileObject testSource = forSourceLines(
                "test.Hello",
                "package test;",
                "import javax.annotation.processing.*;",
                "public class Hello {}"
        );

        Compilation compilation = Compiler.javac()
                .withProcessors(new UniConGenProcessor())
                .compile(testSource);

        assertThat(compilation).succeeded();
    }
}
