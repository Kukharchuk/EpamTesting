package steps;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import pages.DestinationsPage;

public class DestinationPageSteps extends Steps{

    public void initBrowser(){
        super.init();
    }

    public void chooseFromAirport(String airport){
        DestinationsPage destinationsPage = new DestinationsPage(driver);
        destinationsPage.open();
        destinationsPage.chooseWhereToFly(airport);
    }

    public void isAiroportChoosen(){
        Assert.assertTrue("Input should be not empty",
                inputTag.getAttribute("className").equals("ng-not-empty")
    }


    public void openBlogPage(){
        DestinationsPage destinationsPage = new DestinationsPage(driver);
        destinationsPage.open();
        destinationsPage.openBlogPage();
    }

    public void isOnBlogPage(){
        Assert.assertTrue("title should contain Into the Blue | Ryanair Travel Blog",
                driver.getTitle().contains("Into the Blue | Ryanair Travel Blog"));
    }

    public void openDestinationPage(){
        DestinationsPage destinationsPage = new DestinationsPage(driver);
        destinationsPage.open();
    }

}
