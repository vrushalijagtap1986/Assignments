package pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import util.ActionClass;
import util.ReadExcel;

public class CommonPageObject {

    private static final Logger logger = Logger.getLogger(CommonPageObject.class);

    private ActionClass actionClass;
    private ReadExcel readExcel;
    public CommonPageObject()
    {
        actionClass =new ActionClass();
        readExcel = new ReadExcel();
    }

    private static final By SearchFrame = By.xpath("//form[@id='SearchForm']");
    private static final By OneWayTripRadioButton = By.id("OneWay");
    private static final By RoundTripRadioButton = By.xpath("//input[@id='RoundTrip']");
    private static final By MultiCityRadioButton = By.xpath("//input[@id='MultiCity'][@value='MultiCity']");



    private static final By SearchFlightsButton = By.xpath("//div[@class='searchBtnContainer']/descendant::input[@title='Search flights']");

    public void clickMethod(String str) throws Exception {
        logger.debug("clickMethod started");
        try {
            switch (str)
            {
                case "OneWayRadioButton":
                    actionClass.click(OneWayTripRadioButton);
                    break;
                case "RoundTripRadioButton":
                    actionClass.click(RoundTripRadioButton);
                    break;
                case "SearchFlightsButton":
                    actionClass.click(SearchFlightsButton);
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
