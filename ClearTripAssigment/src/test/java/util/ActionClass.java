package util;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import testConfiguration.ApplicationDetails;
import testConfiguration.ApplicationDriver;

import java.util.List;
import java.util.function.Function;


public class ActionClass extends ApplicationDriver {

    private static final Logger logger = Logger.getLogger(ActionClass.class);

    public static void launchApplication() throws Exception {
        createDriver(ApplicationDetails.getBrowser());
        driver.navigate().to(ApplicationDetails.getApplicationURL());

    }

    public void clickRadioButton(By UIElement) throws Exception
    {
        try {
            logger.debug("clickRadioButton method Started");
//           if(findBy(UIElement).isSelected())
//              System.out.println("Already clicked");
//           else
               findBy(UIElement).click();
            logger.debug("clickRadioButton method Completed");
        }
        catch (Exception e)
        {
            logger.error("Failed to click :"+e.getMessage(),e);
        }
    }
    public void click(By UIElement) throws Exception
    {
        try {
            logger.debug("click method Started");
            waitForUIElementToBeDisplayed(UIElement);
            findBy(UIElement).click();
            logger.debug("click method Completed");
        }
        catch (Exception e)
        {
            logger.error("Failed to click :"+e.getMessage(),e);
        }
    }
    public void switchToFrame(By UIElement) throws Exception
    {
        try {
            logger.debug("switchToFrame method Started");

                driver.switchTo().frame(findBy(UIElement));
            logger.debug("switchToFrame method Completed");
        }
        catch (Exception e)
        {
            logger.error("Failed to switchToFrame :"+e.getMessage(),e);
        }
    }
    public void moveToElementAndClick(By UIElement) throws Exception
    {
        try {
            logger.debug("moveToElementAndClick method Started");
            Actions action = new Actions(driver);
            action.moveToElement(findBy(UIElement)).click();
            logger.debug("moveToElementAndClick method Completed");
        }
        catch (Exception e)
        {
            logger.error("Failed to moveToElementAndClick :"+e.getMessage(),e);
        }
    }

    public void enterText(By UIElement, String str) throws Exception
    {
        try {
            logger.debug("enterText method Started");
//            waitForUIElementToBeDisplayed(UIElement);
            waitForPageLoad();
            moveToElementAndClick(UIElement);
            findBy(UIElement).clear();
            findBy(UIElement).sendKeys(str);
            logger.debug("enterText method Completed");
        }
        catch (Exception e)
        {
            logger.error("Failed to enter text :"+e.getMessage(), e);
        }
    }

    public void selectByVisibleText(By UIElement, String str) throws Exception
    {
        try
        {
            Select select = new Select(findBy(UIElement));
            waitForDropdownItems(UIElement);
            select.selectByVisibleText(str);
        }
        catch (Exception e)
        {
            logger.error("Failed to select :"+e.getMessage(), e);
        }
    }

    private void waitForDropdownItems(By UIElement) throws Exception{
       try {
           WebDriverWait wait = new WebDriverWait(driver, 15);
           wait.until(ExpectedConditions.visibilityOfElementLocated(UIElement));
       }
       catch (Exception e)
       {
           logger.error("Failed to waitForDropdownItems :"+e.getMessage(), e);
       }
    }

    public void waitForUIElementToBeClickable(By UIElement) throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.elementToBeClickable(UIElement));
        }
        catch (Exception e)
        {
            logger.error("Failed to waitForUIElementToBeClickable :"+e.getMessage(), e);
        }
    }

    public void waitForUIElementToBeDisplayed(By UIElement) throws Exception {
       try {
           WebDriverWait wait = new WebDriverWait(driver, 15);
           wait.until(ExpectedConditions.visibilityOfElementLocated(UIElement));
       }
       catch (Exception e)
       {
           logger.error("Failed to waitForUIElementToBeDisplayed :"+e.getMessage(), e);
       }

    }
    public void waitForPageLoad() {
        Wait<WebDriver> wait = new WebDriverWait(driver, 30);
        wait.until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                System.out.println("Current Window State       : "
                        + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
                return String
                        .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                        .equals("complete");
            }
        });

    }


    private WebElement findBy(By locator) {
        try {
            return driver.findElement(locator);
        } catch (NoSuchElementException ex) {
            throw new NoSuchElementException(ex.getMessage());
//            ex.getMessage();
        }
    }
    public List<WebElement> findsBy(By locator) {
        try {
            return driver.findElements(locator);
        } catch (NoSuchElementException ex) {
            throw new NoSuchElementException(ex.getMessage());
      }
    }



}
