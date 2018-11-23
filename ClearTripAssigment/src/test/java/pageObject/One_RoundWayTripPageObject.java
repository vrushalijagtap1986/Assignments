package pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import util.ActionClass;
import util.ReadExcel;

public class One_RoundWayTripPageObject {

    private static final Logger logger = Logger.getLogger(One_RoundWayTripPageObject.class);

    private ActionClass actionClass;
    private ReadExcel readExcel;
    public One_RoundWayTripPageObject() {
        actionClass = new ActionClass();
        readExcel = new ReadExcel();
    }

    private static final By FromTextBox_OneWay_RoundTrip = By.xpath("//div[@id='ORtrip']//input[@etitle='From']");
    private static final By ToTextBox_OneWay_RoundTrip = By.xpath("//div[@id='ORtrip']//input[@id='ToTag']");

    private static final By FromDropDown = By.xpath("//ul[@id='ui-id-1']/li[1]/a");
    private static final By ToDropDown = By.xpath("//ul[@id='ui-id-2']/li[1]/a");

    private static final By DepartOnTextBox_OneWay_RoundTrip = By.xpath("//div[@id='ORtrip']//input[@id='DepartDate']");
    private static final By ReturnOnTextBox_OneWay_RoundTrip = By.xpath("//div[@id='ORtrip']//input[@id='ReturnDate']");
    private static final By Datepicker = By.xpath("//td[@data-handler='selectDay'][@class=' undefined']");
    private static final By RoundTripDatepicker = By.xpath("//td[@data-handler='selectDay'][@class=' ']");

    private static final By AdultDropDown = By.xpath("//select[@id='Adults']");
    private static final By ChildernDropDown = By.xpath("//select[@id='Childrens']");
    private static final By InfantDropDown = By.xpath("//select[@id='Infants']");

    private static final By MoreOptionsLink = By.xpath("//a[@id='MoreOptionsLink']/descendant::i");
    private static final By ClassOfTravelDropDown = By.xpath("//div[@id='FlClass']/descendant::select");
    private static final By PreferredAirlineDropDown = By.xpath("//input[@id='AirlineAutocomplete']");


    public void launchApp() throws Exception {
        try {
            actionClass.launchApplication();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterFlightDetails(String location) throws Exception {
        readExcel.readExcelFile();
        String FromCity = readExcel.FromCity;
        String ToCity = readExcel.ToCity;
        String Adults = readExcel.Adults;
        String Children = readExcel.Children;
        String Infants = readExcel.Infants;
        String ClassOfTravel = readExcel.ClassOfTravel;
        String Airline = readExcel.Airline;
        try {
            switch ( location ) {
                case "From":
                    actionClass.enterText(FromTextBox_OneWay_RoundTrip, FromCity);
                    actionClass.selectByVisibleText(FromDropDown,FromCity);
                    break;
                case "To":
                    actionClass.enterText(ToTextBox_OneWay_RoundTrip,ToCity);
                    actionClass.click(ToDropDown);
                    break;
                case "Adults":
                    actionClass.moveToElementAndClick(AdultDropDown);
                    actionClass.selectByVisibleText(AdultDropDown,Adults);
                    break;
                case "Children":
                    actionClass.moveToElementAndClick(ChildernDropDown);
                    actionClass.selectByVisibleText(ChildernDropDown,Children);
                    break;
                case "Infants":
                    actionClass.moveToElementAndClick(InfantDropDown);
                    actionClass.selectByVisibleText(InfantDropDown,Infants);
                    break;
                case "ClassOfTravel":
                    actionClass.moveToElementAndClick(ClassOfTravelDropDown);
                    actionClass.selectByVisibleText(ClassOfTravelDropDown,ClassOfTravel);
                    break;
                case "PreferredAirline":
                    actionClass.moveToElementAndClick(PreferredAirlineDropDown);
                    actionClass.enterText(PreferredAirlineDropDown,Airline);
                    break;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterOneWayTripDate() throws Exception
    {
        try {
            logger.debug("enterOneWayTripDate started");
                    actionClass.click(DepartOnTextBox_OneWay_RoundTrip);
                    actionClass.findsBy(RoundTripDatepicker).get(2).click();
        }
        catch (Exception e)
        {
            logger.error("Failed to Enter enterOneWayTripDate :"+e.getMessage(),e);
        }
    }

    public void enterRoundTripDate(String dateType) throws Exception
    {
        try {
            logger.debug("enterRoundTripDate started");
            switch ( dateType ) {
                case "DepartOn":
                    actionClass.click(DepartOnTextBox_OneWay_RoundTrip);
                    actionClass.findsBy(RoundTripDatepicker).get(2).click();
                    break;
                case "ReturnOn":
                    actionClass.click(ReturnOnTextBox_OneWay_RoundTrip);
                    actionClass.findsBy(RoundTripDatepicker).get(3).click();
                    break;
            }
        }
        catch (Exception e)
        {
            logger.error("Failed to Enter enterRoundTripDate :"+e.getMessage(),e);
        }
    }

    public void clickMethod(String str) throws Exception {
        logger.debug("clickMethod started");
        try {
            switch (str)
            {
                case "MoreOptionsLink":
                    actionClass.click(MoreOptionsLink);
                    break;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
