package pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import util.ActionClass;
import util.ReadExcel;

public class CommonPageObject {

    private static final Logger logger = Logger.getLogger(CommonPageObject.class);

    private ActionClass actionClass;

    public CommonPageObject(String string)
    {
        actionClass =new ActionClass();
    }

    private static final By SearchFrame = By.xpath("//form[@id='SearchForm']");
    private static final By OneWayTripRadioButton = By.id("OneWay");
    private static final By RoundTripRadioButton = By.xpath("//input[@id='RoundTrip']");
    private static final By MultiCityRadioButton = By.xpath("//input[@id='MultiCity'][@value='MultiCity']");



    private static final By SearchFlightsButton = By.xpath("//div[@class='searchBtnContainer']/descendant::input[@title='Search flights']");

    public void clickMethod(String str) {
        logger.debug("clickMethod started");
        try {
            switch (str)
            {
                case "OneWayRadioButton":
                    System.out.println("OneWayRadioButton click");
                    actionClass.waitForPageLoad();
                    actionClass.clickRadioButton(OneWayTripRadioButton);
                    break;
                case "RoundTripRadioButton":
                    System.out.println("RoundTripRadioButton click");
                    actionClass.waitForPageLoad();
                    actionClass.clickRadioButton(RoundTripRadioButton);
                    break;
                case "SearchFlightsButton":
                   actionClass.waitForPageLoad();
                    actionClass.waitForUIElementToBeDisplayed(SearchFlightsButton);
                    actionClass.click(SearchFlightsButton);
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
