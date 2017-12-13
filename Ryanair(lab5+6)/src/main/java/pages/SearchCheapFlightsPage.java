package pages;

import driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SearchCheapFlightsPage extends Page {

    private final String BASE_URL = "https://www.ryanair.com/fi/en/cheap-flights";

    private final Logger logger   = LogManager.getRootLogger();

    public SearchCheapFlightsPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.webDriver, this);
    }

    /*For Searching chepiest flights*/
    @FindBy(xpath = "//input[@aria-labelledby='label-departure-input']")
    private WebElement fromCountry;

    @FindBy(xpath = "//input[@aria-labelledby='label-destination-input']")
    private WebElement toCountry;

    @FindBy(xpath = "//div[@class='lets-go']/button")
    private WebElement letsGoBtn;


    /*Contact us page*/
    @FindBy(linkText = "Contact us")
    WebElement contactUsLink;


    /*Terms of use page*/
    @FindBy(linkText = "Terms of Use")
    WebElement termsLink;
    /*--------------------------------------------------*/

    @Override
    public void open() {
        webDriver.navigate().to(BASE_URL);
        logger.info("Cheap Flights page was opened");
    }

    public void searchCheapFlighta(String From, String To){
        fromCountry.sendKeys(from)
        logger.info("Country from was typed");
        toCountry.sendKeys(to);
        logger.info("Country from was typed");
        letsGoBtn.click();
        logger.info("cheapeats flights ws shown");
    }

    public void openContactUsPage(){
        contactUsLink.click();
        logger.info("contact us link was clicked");
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void openTermsOfUsePage(){
        termsLink.click();
        logger.info("terms of use page was ppend");
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
