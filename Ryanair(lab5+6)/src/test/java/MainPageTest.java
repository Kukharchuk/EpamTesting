import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import steps.MainPageSteps;
import driver.Driver;

public class MainPageTest {

    private MainPageSteps steps;

    private final Logger logger  = LogManager.getRootLogger();

    private final String FROM_CITY           = "Dublin";
    private final String TO_CITY             = "Bucharest";

    private final String LOGIN               = "nigaiakio@gmail.com";
    private final String PASSWORD            = "Testpass12345";

    private final String PICK_UP_DATE_DAY        = "26";
    private final String PICK_UP_DATE_MONTH        = "04";
    private final String PICK_UP_DATE_YEAR        = "2018";
    private final String RETURN_DATE_DAY         = "31";
    private final String RETURN_DATE_MONTH         = "04";
    private final String RETURN_DATE_YEAR        = "2018";

    @BeforeMethod(description = "Init browser")
    public void setUp() {
        steps = new MainPageSteps();
        steps.initBrowser();
    }

    @Test
    public void performSearchPath() {
        steps.searchPath(FROM_CITY, TO_CITY, PICK_UP_DATE_DAY, PICK_UP_DATE_MONTH, PICK_UP_DATE_YEAR, RETURN_DATE_DAY, RETURN_DATE_MONTH, RETURN_DATE_YEAR);
        steps.isOnSchedulePage();
    }

    @Test
    public void performSignIn() {
        steps.signIn(LOGIN, PASSWORD);
        steps.isSignedIn();
    }

    @Test
    public void performChangeLanguage(){
        steps.changeLanguage();
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            System.out.println(e);
        }
        steps.isLanguageChanged();
    }

    @Test
    public void testLoadingPage(){
        steps.openMainPage();
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
