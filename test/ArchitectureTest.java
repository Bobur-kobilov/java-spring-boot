import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RestController;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@SpringBootTest
public class ArchitectureTest {

    private final JavaClasses classes = new ClassFileImporter().importPackages("com.example.api");
    @Test
    public void controllers_should_be_in_controller_package() {
        ArchRule rule = classes()
                .that().areAnnotatedWith(RestController.class)
                .should().resideInAPackage("..controller..");
    
        rule.check(classes);
    }
}