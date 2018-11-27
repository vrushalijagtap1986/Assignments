package testConfiguration;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class ApplicationDriver {

    public static WebDriver driver;

    private final static String browswerpath = System.getProperty("user.dir")+"\\browseDrivers";

    public static WebDriver createDriver(String browswerName)
    {
        if (browswerName.equals("IE")) {
            InternetExplorerOptions ieOptions = new InternetExplorerOptions();
            DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
            ieCapabilities.setCapability(CapabilityType.BROWSER_NAME, "internet explorer");
            ieCapabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
            ieCapabilities.setCapability("unexpectedAlertBehaviour","accept");
            ieCapabilities.setCapability("allow-blocked-content", true);
            ieCapabilities.setCapability("allowBlockedContent", true);
            ieCapabilities.setCapability(ieOptions.destructivelyEnsureCleanSession().toString(), true);
            System.setProperty("webdriver.ie.driver", browswerpath + "\\IEDriverServer.exe");
            driver = new InternetExplorerDriver(ieOptions);
        }
        else if(browswerName.equals("Chrome"))
        {
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--disable-notifications");
            chromeOptions.addArguments("disable-infobars");
            chromeOptions.setExperimentalOption("excludeSwitches", "disable-popup-blocking");
            capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            System.setProperty("webdriver.chrome.driver", browswerpath + "\\chromedriver.exe");
            driver = new ChromeDriver(capabilities);

        }
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public static void closeDriver()
    {
        driver.close();
    }
}
