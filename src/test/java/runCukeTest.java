import cucumber.api.junit.*;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(format = { "pretty", "html:target/cucumber-html-report",
        "json:target/cucumber-json-report.json" }, tags= {"@Sum"},
        features="src/test/resources")
public class runCukeTest {

}
