package pageObject;

import org.openqa.selenium.By;

class MultiCityPageObject {
    private static final By FromTextBox1_MultiTrip = By.xpath("//input[@id='From1']/preceding-sibling::input");
    private static final By FromTextBox2_MultiTrip = By.xpath("//input[@id='From2']/preceding-sibling::input");
    private static final By FromTextBox3_MultiTrip = By.xpath("//input[@id='From3']/preceding-sibling::input");

    private static final By ToTextBox1_MultiTrip = By.xpath("//input[@id='To1']/preceding-sibling::input");
    private static final By ToTextBox2_MultiTrip = By.xpath("//input[@id='To2']/preceding-sibling::input");
    private static final By ToTextBox3_MultiTrip = By.xpath("//input[@id='To3']/preceding-sibling::input");

    private static final By DepartOnTextBox1_MultiTrip = By.xpath("//input[@id='FromDate1']/preceding-sibling::input");
    private static final By DepartOnTextBox2_MultiTrip = By.xpath("//input[@id='FromDate2']/preceding-sibling::input");
    private static final By DepartOnTextBox3_MultiTrip = By.xpath("//input[@id='FromDate3']/preceding-sibling::input");

    private static final By ClassOfTravel_MultiCity_DropDown = By.xpath("//div[@id='multiFlClass']/descendant::select");

    public  MultiCityPageObject(String string)
    {

    }

}
