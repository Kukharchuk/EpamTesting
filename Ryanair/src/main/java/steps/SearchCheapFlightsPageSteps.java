package steps;

import org.junit.Assert;

import pages.BookFlightsPage;

public class SearchFlightsPageSteps extends Steps{

    public void initBrowser(){
        super.init();
    }

    public void searchCheapFlights(String from, String to){
        SearchCheapFlightsPage searchCheapFlightsPage = new SearchCheapFlightsPage(driver);
        searchCheapFlightsPage.open();
        searchCheapFlightsPage.searchCheapFlight(from, to);
    }

    public void isOnCheapFlightsPage(){
        Assert.assertTrue("title should contain Find cheap flights to Europe | Ryanair’s Fare Finder",
                driver.getTitle().contains("Find cheap flights to Europe | Ryanair’s Fare Finder"));
    }

    public void openContactUsPage(){
        SearchCheapFlightsPage searchCheapFlightsPage = new SearchCheapFlightsPage(driver);
        searchCheapFlightsPage.open();
        searchCheapFlightsPage.openContactUsPage();
    }

    public void isOnContactUsPage(){
        Assert.assertTrue("title should contain Where are you calling from?",
                driver.getTitle().contains("Where are you calling from?"));
    }

    public void openTermsOfUsePage(){
        SearchCheapFlightsPage searchCheapFlightsPage = new SearchCheapFlightsPage(driver);
        searchCheapFlightsPage.open();
        searchCheapFlightsPage.openTermsOfUsePage();
    }

    public void isOnTermsOfUsePage(){
        Assert.assertTrue("title should contain Terms of use | Ryanair.com",
                driver.getTitle().contains("Terms of use | Ryanair.com"));
    }

    public void openSearchCheapFlightsPage(){
        SearchFlightsPage searchFlightsPage = new SearchFlightsPage(driver);
        searchFlightsPage.open();
    }



}
