package testNgPractice;

import common.CommonFunctions;
import common.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class CreateCus {
   public static WebDriver driver ;
    @BeforeTest
    public static  void login () throws InterruptedException {
        CommonFunctions commonFunctions = new CommonFunctions();

        driver = commonFunctions.launchBrowser("chrome");
        driver.get("https://online.actitime.com/cybersuccess7/login.do");
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("cybersuccess@yopmail.com");


        driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("Test@1234");

        driver.findElement(By.xpath("//div[contains(text(),'Login')]")).click();

   Thread.sleep(10000);

    }

    @Test

    public static void createCus() throws InterruptedException {
        driver.findElement(By.xpath("//a[@class = 'content users'] /div[text() = 'Users']")).click();
driver.findElement(By.xpath("//div[text() = 'New User']")).click();
Thread.sleep(10000);
String firstname = "Test500";
String lastname = "Engg";
       driver.findElement(By.xpath("(//input[@name = 'firstName'])[2]")).sendKeys(firstname);
        Thread.sleep(10000);
       driver.findElement(By.xpath("(//input[@name = 'lastName'])[2]")).sendKeys(lastname);
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//input[@name = 'email'])[2]")).sendKeys("16test@gmail.com");
        Thread.sleep(10000);
        driver.findElement(By.xpath("(//div[@class = 'content_panelContainer' ] //div[@class = 'downIcon'])")).click();
        Thread.sleep(10000);
        List<WebElement> deptOption =  driver.findElements(By.xpath("//div[@class = 'itemsContainer']//div[contains(@class,'item')]"));
        System.out.println(deptOption.size());
        CommonMethods.optionSelect(deptOption,"Production");
        driver.findElement(By.xpath("//div[text() = 'Save & Send Invitation']")).click();
Thread.sleep(10000);
        String ActualRes = driver.findElement(By.xpath("//div[contains(text(),'has been created')]")).getText();
        System.out.println(ActualRes);
        String ExpectRes = "Account for " + firstname + " " +lastname+" has been created.";
        System.out.println(ExpectRes);
      /* if(ActualRes.equals(ExpectRes))
           System.out.println(firstname + " User has been created");
       else System.out.println("Test case failed");

       */
        Assert.assertEquals(ActualRes,ExpectRes,"Failed");
// //td[@class = 'userNameCell first']
    }
}
