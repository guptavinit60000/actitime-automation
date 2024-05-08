package testNgPractice;

import actiTimeLogin.LoginTest;
import common.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LoginFunction {

    public static void main(String[] args) {
        CommonFunctions commonFunctions = new CommonFunctions();

        WebDriver driver = commonFunctions.launchBrowser("chrome");

        driver.get("https://online.actitime.com/cybersuccess7/login.do");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);



        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("cybersuccess@yopmail.com");

        driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("Test@1234");

        driver.findElement(By.xpath("//div[contains(text(),'Login')]")).click();


       // https://online.actitime.com/cybersuccess01/login.do

    }
}
