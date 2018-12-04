package stepDefinition;


import APIs.Config;
import APIs.GetAPI;
import APIs.PostAPI;
import APIs.PutAPI;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.ITestContext;

@ContextConfiguration(classes = Config.class)
public class APIStepDefintion {

   @Autowired
   private GetAPI getAPI;
   @Autowired
   private PutAPI putAPI;
   @Autowired
   private PostAPI postAPI;

    @Given("^I call Get API$")
    public void iCallGetAPI() throws Throwable {
        getAPI.testGetAPI();
    }

    @And("^I call Post API$")
    public void iCallPostAPI() throws Throwable {
              postAPI.testPostAPI();
    }

    @Then("^I call Put API$")
    public void iCallPutAPI() throws Throwable {
       putAPI.testPutAPI();
    }
}
