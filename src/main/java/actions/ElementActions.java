package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

public class ElementActions extends TestBase {

    private static WebElement initiateElement(By locator) {
        return driver.findElement(locator);
    }
    public static void selectByValueDropDown(By element , String value){
        Select select = new Select(initiateElement(element));
        select.selectByValue(value);
    }

    public static void click(By element) {
        initiateElement(element).click();
    }

    public static void typeText(By element, String text) {
        initiateElement(element).sendKeys(text);
    }

    public static void clickEnterKey(By element) {
        initiateElement(element).sendKeys(Keys.ENTER);

    }

    public static String getText(By element) {
        return initiateElement(element).getText();
    }

    public static void waitUnitElementDisplayed(By element) {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}
