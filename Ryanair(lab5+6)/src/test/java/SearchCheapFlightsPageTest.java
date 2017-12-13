import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import steps.SearchCheapFlightsPageSteps;
import steps.Steps;
import driver.Driver;


import java.util.concurrent.TimeUnit;

public class SearchCheapFlightPage {
    private SearchCheapFlightPageSteps steps;

    private final String FROM = "Dole";
    private final String TO = "Fez";

    private final Logger logger  = LogManager.getRootLogger();

    @BeforeMethod(description = "Init browser")
    public void setUp() {
        steps = new SearchCheapFlightsPageSteps();
        steps.initBrowser();
    }

    @Test
    public void performSearchCheapFlights() {
        steps.searchCheapFlights(FROM, TO);
        String parentWindow = Driver.getDriver().getWindowHandle();
        Set <String> handles =  Driver.getDriver().getWindowHandles();
        for(String windowHandle  : handles)
        {
            if(!windowHandle.equals(parentWindow))
            {
                Driver.getDriver().switchTo().window(windowHandle);
                Driver.getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
                steps.isOnCheapFlightsPage();
            }
        }

    }

    @Test
    public void performContactUsPage(){
        steps.openContactUsPage();
        steps.isOnContactUsPage();
    }

    @Test
    public void performOpenTermsOfUsePage(){
        steps.openTermsOfUsePage();
        steps.isOnTermsOfUsePage();
    }

    @Test
    public void testLoadingPage(){
        steps.openSearchCheapFlightsPage();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        long loadEventEnd = (Long) js.executeScript("return window.performance.timing.loadEventEnd;");
        long navigationStart = (Long) js.executeScript("return window.performance.timing.navigationStart;");
        logger.info("Page Load Time is " + (loadEventEnd - navigationStart)/1000 + " seconds.");
    }


    @AfterMethod(description = "Stop Browser")
    public void stopBrowser() {
        steps.closeDriver();
    }
}
