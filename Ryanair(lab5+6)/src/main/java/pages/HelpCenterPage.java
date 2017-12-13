package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.support.PageFactory;
import java.lang.*;


public class HelpCenterPage extends Page {
    private final Logger logger   = LogManager.getRootLogger();
    private final String BASE_URL = "https://www.ryanair.com/fi/en/useful-info/help-centre";

    public DestinationsPage(WebDriver webDriver) {
        super(webDriver);

        PageFactory.initElements(this.webDriver, this);
    }

    @Override
    public void open() {
        webDriver.navigate().to(BASE_URL);
        logger.info("Help Center page was opened");
    }

    /*search information*/
    @FindBy(xpath = "//div[@class='search-text']/input")
    WebElement searchArea;
    @FindBy(xpath = "//input[@value='search']")
    WebElement searchBtn;


    /*One of 5 top questions*/
    @FindBy(linkText = "Help Centre for Winter Schedule Changes ")
    WebElement top5Questions;

    /*Baggage Info*/
    @FindBy(xpath = "//a[@href='/fi/en/useful-info/help-centre/faq-overview/Baggage']")
    WebElement baggageInfoLink;


    public void searchInfo(String information){
        searchArea.sendKeys(information)
        searchBtn.click();
    }


    public void openInfoPage(){
        top5Questions.click();
        logger.info("the top5 was clicked");
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void openBaggagePage(){
        baggageInfoLink.click();
        logger.info("baggage page was clicked");
    }
}

