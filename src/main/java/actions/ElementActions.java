package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.util.List;

public class ElementActions extends TestBase {

    // Initialize  the Web Elements
    private static WebElement initiateElement(By locator) {
        return driver.findElement(locator);
    }
    // Clicks on the selected element
    public static void click(By element) {
        initiateElement(element).click();
    }

    // Type text in the text fields
    public static void typeText(By element, String text) {
        initiateElement(element).sendKeys(text);
    }

    // Click keyboard enter key
    public static void clickEnterKey(By element) {
        initiateElement(element).sendKeys(Keys.ENTER);

    }

    // Get Text of an element
    public static String getText(By element) {
        return initiateElement(element).getText();
    }

    // Explicit wait until element is visible on the UI
    public static void waitUnitElementDisplayed(By element) {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static List<WebElement> getElements(By element) {
        return driver.findElements(element);
    }
}
