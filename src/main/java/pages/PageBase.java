package pages;

import actions.BrowserActions;
import actions.ElementActions;
import org.openqa.selenium.*;
import org.testng.Assert;
import utilities.ConfigUtil;
import java.util.Calendar;
import java.util.Locale;
public class PageBase {


    /*** Locators **/
    private static final By AcceptCookiesButton = By.id("onetrust-accept-btn-handler");
    private static final By DepartureDropDown = By.xpath("(//input[@type='text'])[1]");
    private static final By ArrivalCityDropDown = By.xpath("(//input[@type='text'])[2]");
    private static final By AddPassengersButton = By.xpath("//button[@data-testid='add-passengers']");
    private static final By SearchButton = By.xpath("//*[@type='submit']");
    private static final By DatePicker = By.id("custom_date_picker_input");
    private static final By CurrentDisplayedMonthYear = By.xpath("//*[@class='react-datepicker__current-month']");
    private static final By NextMonthButton = By.xpath("//button[contains(text(),'Next Month')]");
    private static final By FirstTripButton = By.xpath("(//Button[contains(text(),'Choose Trip')])[1]");
    private static final By ContactDetailsPageHeader = By.xpath("//h2[contains(text(),'Contact Details')]");

    /*****************************************************/

    //Accepts page cookies pop up
    public void acceptPageCookies() {
        ElementActions.click(AcceptCookiesButton);
    }

    // Search & select the Departure City
    public void searchDepartureCity(String DepartureCity) {
        ElementActions.click(DepartureDropDown);
        ElementActions.typeText(DepartureDropDown, DepartureCity);
        ElementActions.clickEnterKey(DepartureDropDown);
    }

    // Search & select the Arrival City
    public void searchArrivalCity(String ArrivalCity) {
        ElementActions.click(ArrivalCityDropDown);
        ElementActions.typeText(ArrivalCityDropDown, ArrivalCity);
        ElementActions.clickEnterKey(ArrivalCityDropDown);
    }

    // Add Passengers to the ride
    public void addPassengers(int numberOfPassengers) {
        for (int i = 1; i <= numberOfPassengers; i++) {
            ElementActions.click(AddPassengersButton);
        }
    }

    // Click on search button
    public void clickSearchButton() {
        ElementActions.click(SearchButton);
    }

    // Selects Tomorrow's Date form the Date Picker
    public void selectTomorrowDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        String TomorrowMonth = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
        int TomorrowDay = calendar.get(Calendar.DAY_OF_MONTH);
        String TomorrowDate = TomorrowMonth + " " + calendar.get(Calendar.YEAR);
        ElementActions.click(DatePicker);
        while (!TomorrowDate.equals(ElementActions.getText(CurrentDisplayedMonthYear))) {
            ElementActions.click(NextMonthButton);
        }
        ElementActions.click(By.xpath("//div[contains(@aria-label,'" + TomorrowMonth + " " + TomorrowDay + "')]"));
    }

    // Chooses the first trip in the list
    public void chooseFirstTrip() {
        ElementActions.click(FirstTripButton);
    }

    // Verify landing on the contact details page successfully
    public void VerifyNavigationToContactDetailsPage() {
        ElementActions.waitUnitElementDisplayed(ContactDetailsPageHeader);
        Assert.assertEquals(BrowserActions.getCurrentURL(), ConfigUtil.getProperty("ContactDetailsPageURL"));
    }
}
