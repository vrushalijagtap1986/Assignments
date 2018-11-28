package stepDefinition;

import cucumber.api.java.en.And;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pageObject.CommonPageObject;
import pageObject.One_RoundWayTripPageObject;

public class CommonStepDefinition {

//    @Autowired
//    private CommonPageObject commonPageObject =new CommonPageObject();
ApplicationContext context = new ClassPathXmlApplicationContext("spring.XML");
    CommonPageObject commonPageObject =(CommonPageObject) context.getBean("CommonPage");


    @And("^I click \"([^\"]*)\"$")
    public void iClick(String element) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        commonPageObject.clickMethod(element);
    }


}
