package util;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import testConfiguration.ApplicationDetails;
import testConfiguration.ApplicationDriver;

import java.util.List;


public class ActionClass extends ApplicationDriver {

    private static final Logger logger = Logger.getLogger(ActionClass.class);

    public static void launchApplication() throws Exception {
        createDriver(ApplicationDetails.getBrowser());
        driver.navigate().to(ApplicationDetails.getApplicationURL());

    }

    public void click(By UIElement) throws Exception
    {
        try {
            logger.debug("click method Started");
           if(findBy(UIElement).isSelected())
              System.out.println("Already clicked");
           else
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
//            moveToElementAndClick(UIElement);
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

    private void waitForDropdownItems(By UIElement) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(UIElement));
    }

    public void waitForUIElementToBeClickable(By UIElement) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(UIElement));
    }

    public void waitForUIElementToBeDisplayed(By UIElement) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(UIElement));

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
