package abd.sweetsystem.AcceptanceTest;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "cases",
        monochrome = true,
        snippets = SnippetType.CAMELCASE,
        glue = {"abd.sweetsystem.AcceptanceTest"}
)
public class acceptanceTest {
}
