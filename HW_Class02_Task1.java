package HomeWork_TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

/**
 * HRMS Application Negative Login:
 * Open chrome browser
 * Go to http://hrmstest.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login
 * Enter valid username
 * Leave password field empty
 * Verify error message with text “Password cannot be empty” is displayed.
 */
public class HW_Class02_Task1 {
    WebDriver driver;

    //pre-condition @before method--launch browser and navigate url
    @BeforeMethod
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/login");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test
    public void verifyErrorMessage() {

        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("btnLogin")).click();

        String actualTitle=driver.findElement(By.id("spanMessage")).getText();
        String expectedTitle = "Password cannot be empty";
        Assert.assertEquals(actualTitle,expectedTitle);

        WebElement errorMessage=driver.findElement(By.id("spanMessage"));
        Assert.assertTrue(errorMessage.isDisplayed());
        System.out.println("Error message is displayed");


    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
