package stepDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;
import pageObject.One_RoundWayTripPageObject;

public class One_RoundWayTripStepDefinition {

//    @Autowired
     private One_RoundWayTripPageObject oneRoundWayTripPageObject = new One_RoundWayTripPageObject();


    @And("^I enter \"([^\"]*)\" Location$")
    public void iEnterLocation(String locationCity) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        oneRoundWayTripPageObject.enterFlightDetails(locationCity);
    }


    @And("^I select \"([^\"]*)\"$")
    public void iSelect(String str) throws Throwable {
       oneRoundWayTripPageObject.enterFlightDetails(str);
    }

    @And("^I click \"([^\"]*)\" in One_RoundTrip$")
    public void iClickInOne_RoundTrip(String str) throws Throwable {
        oneRoundWayTripPageObject.clickMethod(str);
    }

    @And("^I enter \"([^\"]*)\"$")
    public void iEnter(String Airline) throws Throwable {
        oneRoundWayTripPageObject.enterFlightDetails(Airline);
    }

    @And("^I enter \"([^\"]*)\" Date for OneWayTrip$")
    public void iEnterDateForOneWayTrip(String arg0) throws Throwable {
        oneRoundWayTripPageObject.enterOneWayTripDate();
    }

    @And("^I enter \"([^\"]*)\" Date for RoundTrip$")
    public void iEnterDateForRoundTrip(String dateType) throws Throwable {
       oneRoundWayTripPageObject.enterRoundTripDate(dateType);
    }

    @Given("^I Launch the ClearTrip application$")
    public void iLaunchTheClearTripApplication() throws Throwable {
        oneRoundWayTripPageObject.launchApp();
    }
}
