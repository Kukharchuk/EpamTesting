package pages;

import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainPage extends Page{
    private final Logger logger   = LogManager.getRootLogger();

    private final String BASE_URL = "http://www.airarabia.com/ru";

    public MainPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.webDriver, this);
    }

    /*For log in*/
    @FindBy(linkText = "Log in")
    private WebElement logInBtn;

    @FindBy(name = "emailAddress")
    private WebElement inputLogin;

    @FindBy(name = "password")
    private WebElement inputPassword;

    @FindBy(className = "core-btn-primary")
    private WebElement logInSubmitBtn;

    /*flghts shedul.*/
    @FindBy(className = "core-input ng-pristine ng-untouched ng-valid ng-not-empty")
    private List<WebElement> inputs;

    @FindBy(cssSelector = "div.col-flight-search-right>button")
    private WebElement flightsSubmitBtn;

    @FindBy(className = "dd")
    private List <WebElement> flightDateDay;

    @FindBy(className = "mm")
    private List <WebElement> flightDateMonth;

    @FindBy(className = "yyyy")
    private List <WebElement> flightDateYear;

    /*Change lang*/
    @FindBy(xpath="//a[@className='ico-flag']/..")
    WebElement changeLanguageBtn;

    @FindBy(lintText = "Italy")
    WebElement languageToChoose;
    /*-------------------------------------------*/



    @Override
    public void open() {
        webDriver.navigate().to(BASE_URL);
        logger.info("Main page opened");
    }

    public void login(String username, String password) {
        logInBtn.click();
        inputLogin.sendKeys(username);
        inputPassword.sendKeys(password);
        logInSubmitBtn.submit();
        logger.info("Sign In performed");
    }

    public void search(String from, String to, String day1, String month1, String year1, String day2, String month2, String year2 ) {
        inputs.get(1).sendKeys(from);
        inputs.get(2).sendKeys(to);
        flightDateDay.get(1).sendKeys(day1);
        flightDateMonth.get(1).sendKeys(month1);
        flightDateYear.get(1).sendKeys(year1);
        flightDateDay.get(2).sendKeys(day2);
        flightDateMonth.get(2).sendKeys(month2);
        flightDateYear.get(2).sendKeys(year2);
        flightsSubmitBtn.submit();
    }

    public void changeLanguage(){
        changeLanguageBtn.click();
        logger.info("click on longuage from list to change language");
        languageToChoose.click();
        Driver.getDriver().manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        logger.info("choose language");
    }

}
