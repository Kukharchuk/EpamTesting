package steps;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import pages.HelpCenterPage;

public class HelpCenterPageSteps extends Steps{

    public void initBrowser(){
        super.init();
    }

    public void searchInfo(String information){
        HelpCenterPage helpCenterPage = new HelpCenterPage(driver);
        helpCenterPage.open();
        helpCenterPage.chooseWhereToFly(information);
    }

    public void isSearchSuccesfull(){
        Assert.assertTrue("Input should be not empty",
                inputTag.getAttribute("className").equals("ng-not-empty")
    }


    public void openInfoPage(){
        HelpCenterPage helpCenterPage = new HelpCenterPage(driver);
        helpCenterPage.open();
        helpCenterPage.openInfoPage();
    }

    public void isOnInfoPage(){
        Assert.assertTrue("title should contain Help Centre for Winter Schedule Changes ",
                driver.getTitle().contains("Help Centre for Winter Schedule Changes "));
    }

    public void openBaggagePage(){
        HelpCenterPage helpCenterPage = new HelpCenterPage(driver);
        helpCenterPage.open();
        helpCenterPage.openBaggagePage();
    }

    public void isOnBaggagePage(){
        Assert.assertTrue("title should contain Baggage",
                driver.getTitle().contains("Baggage"));
    }

    public void openDestinationPage(){
        HelpCenterPage helpCenterPage = new HelpCenterPage(driver);
        helpCenterPage.open();
    }

}
