package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;


import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class TestBase {

    //For Initialize the Driver

    public static WebDriver driver;
    public void StartDriver(String browserName) throws IOException {
        System.out.printf("Browser Type = " + browserName);
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--use-fake-ui-for-media-stream");
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @Parameters("browserName")
    @BeforeMethod(alwaysRun = true)
    public void restart() throws IOException {
        StartDriver(ConfigUtil.getProperty("browserName"));
    }

    @AfterMethod(alwaysRun = true)
    public void quit(ITestResult result) throws IOException {
        driver.quit();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws IOException {
    }


}
