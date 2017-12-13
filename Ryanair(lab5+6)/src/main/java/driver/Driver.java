package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import java.util.concurrent.TimeUnit;

import listener.Listener;

public class Driver {

    private static WebDriver driver;
    private static EventFiringWebDriver e_driver;
    private static Listener eventListener;

    public static WebDriver getDriver(){
        if (e_driver == null){
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
            e_driver = new EventFiringWebDriver(driver);
            eventListener = new Listener();
            e_driver.register(eventListener);
            e_driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }

        return e_driver;
    }

    public static void closeDriver(){
        e_driver.quit();
        e_driver = null;
    }
}
