import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

@SupportedAnnotationTypes({"ClassAnnotation"})
public class MyProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Messager messager = processingEnv.getMessager();
        for (TypeElement type : annotations) {
            for (Element element : roundEnv.getElementsAnnotatedWith(type)) {
                messager.printMessage(Diagnostic.Kind.NOTE, element.getSimpleName());
                messager.printMessage(Diagnostic.Kind.NOTE, element.getKind().toString());
                ClassAnnotation annotation = element.getAnnotation(ClassAnnotation.class);
                if (annotation != null) {
                    messager.printMessage(Diagnostic.Kind.NOTE, annotation.value());
                }
            }
        }

        return false;
    }
}
