package actions;

import utilities.TestBase;

public class BrowserActions extends TestBase {

    // Navigate to a specific URL
    public static void navigateTo(String URL)
    {
        driver.navigate().to(URL);
    }

    // Get the Current URL
    public static String getCurrentURL() {
        return driver.getCurrentUrl();
    }

}
