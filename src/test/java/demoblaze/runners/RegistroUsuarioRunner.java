package demoblaze.runners;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "demoblaze.stepsDefinitions",
        tags = "@CASO1",
        snippets =  CucumberOptions.SnippetType.CAMELCASE)

public class RegistroUsuarioRunner {

}
