package tests;

import actions.BrowserActions;
import actions.ElementActions;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import pages.PageBase;
import utilities.ConfigUtil;
import utilities.TestBase;

import java.io.IOException;

public class TaskTest extends TestBase {
    PageBase pageBase = new PageBase();
    @Test
    @Description("Search Suggestions")
    public void checkOnSearchSuggestion() throws IOException, InterruptedException {
        //Navigate to Travel Page
        BrowserActions.navigateTo(ConfigUtil.getProperty("BaseURL"));

        //Accept Page Cookies
        pageBase.acceptPageCookies();

        //Select Departure City
        pageBase.searchDepartureCity("cairo");

        //Select Arrival City
        pageBase.searchArrivalCity("alexandria");

        //Select Number Of Passengers
        pageBase.addPassengers(2);

        //Select Date
        pageBase.selectTomorrowDate();

        //Search for Rides
        pageBase.clickSearchButton();

        //Choose First Trip
        pageBase.chooseFirstTrip();

        //Validate Contact details page opened successfully
        pageBase.VerifyNavigationToContactDetailsPage();

    }
}
