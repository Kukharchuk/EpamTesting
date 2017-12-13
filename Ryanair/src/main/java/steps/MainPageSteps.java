package steps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.junit.Assert;
import java.util.concurrent.TimeUnit;

import pages.MainPage;

public class MainPageSteps extends Steps {

    public void initBrowser(){
        super.init();
    }

    public void searchPath(String from, String to, String day, string month, string year) {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.search(from, to, day1, month1, year1, day2, month2, year2);
    }

    public void isOnSchedulePage() {
        Assert.assertTrue("title should start with Official Ryanair website | Cheap flights in Europe | Ryanair",
                driver.getTitle().startsWith("Official Ryanair website | Cheap flights in Europe | Ryanair"));
    }

    public void signIn(String email, String password) {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.login(email, password);
    }

    public boolean isSignedIn() {
        WebElement logOutBtn = driver.findElement(By.linkText("Log out"));
        if(logOutBtn != null)
            return true;
        return false;
    }


    public void openMainPage(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
    }

    public void changeLanguage(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.changeLanguage();
    }

    public void isLanguageChanged(){
        WebElement bodyTag = driver.findElement(By.xpath("//html"));
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        Assert.assertTrue("Language should be Italy",
                htmlTag.getAttribute("lang").equals("it"));
    }

}
