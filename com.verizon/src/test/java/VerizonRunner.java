import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/homepage.feature"},
        glue = {"step_definitions"},
        tags = "@Ratings",
        monochrome = true,
        plugin = {"pretty", "html:target/cucumber-html-report.html"}
)
public class VerizonRunner {



}