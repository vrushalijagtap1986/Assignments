package stepDefinition;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.springframework.test.context.ContextConfiguration;
import spring.UISpring;
import testConfiguration.ApplicationDetails;
import testConfiguration.ApplicationDriver;

//@ContextConfiguration(classes = UISpring.class)
public class Hooks {

    @Before
    public void beforeScenario() throws Exception{
        System.out.println("This will run before the Scenario");
        ApplicationDetails.loadConfiguration();
    }

    @After
    public void afterScenario(){
        System.out.println("This will run after the Scenario");
        ApplicationDriver.closeDriver();
    }
}

