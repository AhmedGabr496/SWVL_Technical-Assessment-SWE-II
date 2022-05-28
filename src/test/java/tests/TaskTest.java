package tests;

import actions.BrowserActions;
import jdk.jfr.Description;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.PageBase;
import utilities.ConfigUtil;
import utilities.TestBase;


public class TaskTest extends TestBase {
    PageBase pageBase = new PageBase();
    @Test (priority = 1)
    @Description("Search Suggestions")
    @Parameters({"Departure","Arrival"})
    public void checkOnSearchSuggestion(String Departure , String Arrival) {
        BrowserActions.navigateTo(ConfigUtil.getProperty("BaseURL"));         //Navigate to Travel Page
        pageBase.acceptPageCookies();                                        //Accept Page Cookies
        pageBase.searchDepartureCity(Departure);                              //Select Departure City
        pageBase.searchArrivalCity(Arrival);                                //Select Arrival City
        pageBase.addPassengers(2);                        //Select Number Of Passengers
        pageBase.selectTomorrowDate();                                   //Select Tomorrow Date
        pageBase.clickSearchButton();                                   //Search for Rides
        pageBase.chooseFirstTrip();                                    //Choose First Trip
        pageBase.VerifyNavigationToContactDetailsPage();              //Validate Contact details page opened successfully
    }
}
