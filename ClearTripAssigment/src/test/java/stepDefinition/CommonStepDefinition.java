package stepDefinition;

import cucumber.api.java.en.And;
import pageObject.CommonPageObject;

public class CommonStepDefinition {

//    @Autowired
    private CommonPageObject commonPageObject =new CommonPageObject();

    @And("^I click \"([^\"]*)\"$")
    public void iClick(String element) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        commonPageObject.clickMethod(element);
    }


}
