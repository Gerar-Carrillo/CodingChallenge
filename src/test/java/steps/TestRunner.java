package steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue= {"steps"},
        plugin = { "pretty","html:target/cucumber-reports" },
        tags = "@all",
        monochrome = true
)

public class TestRunner {

}