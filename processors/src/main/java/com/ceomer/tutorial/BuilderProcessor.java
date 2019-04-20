package com.ceomer.tutorial;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BuilderProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        //processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "TEST WARNING");
        for (Element element : roundEnv.getElementsAnnotatedWith(Builder.class)) {
            JavaFileObject builderClass = null;
            PackageElement packageElement = (PackageElement)element.getEnclosingElement();
            BufferedWriter bufferedWriter = null;
            try {
                String builderName = element.getSimpleName().toString() + "Builder";
                builderClass = processingEnv.getFiler().createSourceFile(builderName);
                bufferedWriter = new BufferedWriter(builderClass.openWriter());
                bufferedWriter.append("package ");
                bufferedWriter.append(packageElement.getQualifiedName().toString());
                bufferedWriter.append(";");
                bufferedWriter.newLine();
                bufferedWriter.append("public class ");
                bufferedWriter.append(builderName);
                bufferedWriter.append("{");
                bufferedWriter.newLine();
                bufferedWriter.append("public static ");
                bufferedWriter.append(builderName);
                bufferedWriter.append(" ");
                bufferedWriter.append("create(){");
                bufferedWriter.newLine();
                bufferedWriter.append("return new ");
                bufferedWriter.append(builderName);
                bufferedWriter.append("();}");
                bufferedWriter.newLine();
                bufferedWriter.newLine();
                bufferedWriter.append("private ");
                bufferedWriter.append(element.getSimpleName().toString());
                bufferedWriter.append(" object;");
                bufferedWriter.newLine();
                bufferedWriter.append("private ");
                bufferedWriter.append(builderName);
                bufferedWriter.append("(){");
                bufferedWriter.newLine();
                bufferedWriter.append("this.object = new ");
                bufferedWriter.append(element.getSimpleName());
                bufferedWriter.append("();}");
                if (element.getKind().isClass()) {
                    for (Element enclosed : element.getEnclosedElements()) {
                        if (enclosed.getKind().isField() & (enclosed.getModifiers().contains(Modifier.PUBLIC)
                                | enclosed.getModifiers().contains(Modifier.PROTECTED))) {
                                bufferedWriter.newLine();
                                bufferedWriter.newLine();
                                bufferedWriter.append("public ");
                                bufferedWriter.append(builderName);
                                bufferedWriter.append(" set");
                                bufferedWriter.append(enclosed.getSimpleName().toString());
                                bufferedWriter.append("(");
                                bufferedWriter.append(enclosed.asType().toString());
                                bufferedWriter.append(" param){");
                                bufferedWriter.newLine();
                                bufferedWriter.append("this.object.");
                                bufferedWriter.append(enclosed.getSimpleName().toString());
                                bufferedWriter.append(" = ");
                                bufferedWriter.append("param;");
                                bufferedWriter.newLine();
                                bufferedWriter.append("return this;}");
                        }
                    }
                }
                bufferedWriter.newLine();
                bufferedWriter.append("public ");
                bufferedWriter.append(element.getSimpleName());
                bufferedWriter.append(" build(){");
                bufferedWriter.append("return this.object;}");
                bufferedWriter.newLine();
                bufferedWriter.append("}");
                bufferedWriter.close();
            } catch (IOException e) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, e.toString());
            }

        }
        return false;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return new HashSet<>(Arrays.asList("com.ceomer.tutorial.Builder"));
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.RELEASE_10;
    }
}
