package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.support.PageFactory;
import java.lang.*;


public class DestinationsPage extends Page {
    private final Logger logger   = LogManager.getRootLogger();
    private final String BASE_URL = "https://www.ryanair.com/us/en/cheap-flight-destinations-list";

    public DestinationsPage(WebDriver webDriver) {
        super(webDriver);

        PageFactory.initElements(this.webDriver, this);
    }

    @Override
    public void open() {
        webDriver.navigate().to(BASE_URL);
        logger.info("Destination page opened");
    }

    /*-------find airports where you can fly from choosen ccountry---------*/
    @FindBy(xpath = "//input[@aria-labelledby='label-airport-selector-from']")
    WebElement countryFromStart;
    @FindBy(xpath = "//input[@translate='common.buttons.lets_go']")
    WebElement letsGoBtn;
    /*------------------------------------------*/



    /*--------------Click On Blog----------------*/
    @FindBy(linkText = "Blog")
    WebElement blog;
    /*------------------------------------------*/


    public void chooseFromAirport(String airport){
        coontryFromStart.sendKeys(airport)
        letsGoBtn.click();
    }


    public void openBlogPage(){
        blog.click();
        logger.info("the blog link was clicked");
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
