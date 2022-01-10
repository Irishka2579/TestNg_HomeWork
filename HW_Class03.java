package HomeWork_TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.CommonMethods;

import java.io.File;
import java.io.IOException;

/**
 TC 1: HRMS Add Employee:
 Open chrome browser
 Go to HRMS
 Login into the application
 Add 5 different Employees and create login credentials by providing:
 First Name
 Last Name
 Username
 Password
 Verify Employee has been added successfully and take screenshot (you must have 5 different screenshots)
 Close the browser
 Specify group for this test case, add it into specific suite and execute from xml file.
 */
public class HW_Class03 extends CommonMethods {


    @Test(groups="addemployee",dataProvider = "emp")
    public void NewEmployee(String firstname,String lastname,String userName,String pass,String confirm) throws InterruptedException {
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
        driver.findElement(By.id("btnLogin")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        driver.findElement(By.id("btnAdd")).click();
        driver.findElement(By.id("firstName")).sendKeys(firstname);
        driver.findElement(By.id("lastName")).sendKeys(lastname);
        driver.findElement(By.id("chkLogin")).click();
        driver.findElement(By.id("user_name")).sendKeys(userName);
        driver.findElement(By.id("user_password")).sendKeys(pass);
        driver.findElement(By.id("re_password")).sendKeys(confirm);
        Thread.sleep(1000);
        driver.findElement(By.id("btnSave")).click();

    }
/*
    @Test(priority = 2, dependsOnMethods = "emp", groups = "addemployee")
    public void screenShot() throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        try{
        FileUtils.copyFile(sourceFile, new File("screenshots/TestNg/HomeWork_TestNg/HW_Class03.png"));
    }catch (IOException e){
            e.printStackTrace();
        }}
*/
    @DataProvider
    public Object[][] emp (){
            Object[][] addEmp =new Object[5][5];
            addEmp[0][0]="Irina";
            addEmp[0][1]="Kozlova";
            addEmp[0][2]="iraaaaaa";
            addEmp[0][3]="IK123@#$%lo789";
            addEmp[0][4]="IK123@#$%lo789";
            addEmp[1][0]="John";
            addEmp[1][1]="Smith";
            addEmp[1][2]="jooooooo";
            addEmp[1][3]="JS234@#$ji89";
            addEmp[1][4]="JJS234@#$ji89";
            addEmp[2][0]="Kevin";
            addEmp[2][1]="Gurt";
            addEmp[2][2]="kevvvvvv";
            addEmp[2][3]="KG345&*(kl700";
            addEmp[2][4]="KG345&*(kl700";
            addEmp[3][0]="Larry";
            addEmp[3][1]="Miller";
            addEmp[3][2]="Layyyyyy";
            addEmp[3][3]="LM456#$%^ju77";
            addEmp[3][4]="LM456#$%^ju77";
            addEmp[4][0]="Emily";
            addEmp[4][1]="Parrys";
            addEmp[4][2]="Emiiiiii";
            addEmp[4][3]="EP567&*fg990";
            addEmp[4][4]="EP567&*fg990";
            return addEmp;

        }

    }