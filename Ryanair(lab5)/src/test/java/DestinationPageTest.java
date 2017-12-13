import driver.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import steps.DestinationsPageSteps;
import steps.Steps;

import java.util.Set;
import java.util.concurrent.TimeUnit;

private final String FROM_AIRPORT = "Beziers";

public class DestinationsPageTest extends Steps {

    private DestinationsPageSteps steps;

    private final Logger logger  = LogManager.getRootLogger();

    @BeforeMethod(description = "Init browser")
    public void setUp() {
        steps = new DestinationsPageSteps();
        steps.initBrowser();
    }

    @AfterMethod(description = "Stop Browser")
    public void stopBrowser() {
        steps.closeDriver();
    }

    @Test
    public void performAirportsFromChossenAirport(){
        steps.chooseFromAirport(String FROM_AIRPORT);
        steps.isAiroportChoosen();
    }


    @Test
    public void performOpenBlog(){
        steps.openBlogPage();
        String parentWindow = Driver.getDriver().getWindowHandle();
        Set<String> handles =  Driver.getDriver().getWindowHandles();
        for(String windowHandle  : handles)
        {
            if(!windowHandle.equals(parentWindow))
            {
                Driver.getDriver().switchTo().window(windowHandle);
                Driver.getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
                steps.isOnBlogPage();
            }
        }
    }

    @Test
    public void testLoadingPage(){
        steps.openDestinationPage();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        long loadEventEnd = (Long) js.executeScript("return window.performance.timing.loadEventEnd;");
        long navigationStart = (Long) js.executeScript("return window.performance.timing.navigationStart;");
        logger.info("Page Load Time is " + (loadEventEnd - navigationStart)/1000 + " seconds.");
    }
}
