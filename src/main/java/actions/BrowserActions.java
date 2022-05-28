package actions;

import utilities.TestBase;

public class BrowserActions extends TestBase {
    public static void navigateTo(String URL)
    {
        driver.navigate().to(URL);
    }

    public static String getCurrentURL() {
        return driver.getCurrentUrl();
    }

}
