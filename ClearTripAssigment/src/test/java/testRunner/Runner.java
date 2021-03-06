package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/Feature/"
        ,glue={"stepDefinition"}
        ,tags = "@RoundWayFlightSearch"
)

public class Runner {
}
