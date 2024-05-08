package Assign;

import common.CommonFunctions;
import common.CommonMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.time.Duration;
import java.util.List;

public class Assign22 {


    static WebDriver driver ;
    @BeforeTest
    public static  void login () throws InterruptedException {
        CommonFunctions commonFunctions = new CommonFunctions();

        driver = commonFunctions.launchBrowser("chrome");
        driver.get("https://online.actitime.com/cybersuccess01/login.do");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("guptavinit70000000@gmail.com");


        driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("cyber@123");

        WebElement cnt = driver.findElement(By.xpath("//div[contains(text(),'Login')]"));
 CommonMethods.click(driver,cnt);

    }

    @Test

    public static void test() throws InterruptedException {



        driver.findElement(By.id("container_users")).click();

        driver.findElement(By.xpath("(//td[@class= 'middle-left-cell contents'])[1]")).click();

        driver.findElement(By.xpath("//label[text()='Selected users']")).click();
     List<WebElement> usrName =  driver.findElements(By.xpath("//span[@class='ellipsisLabel']"));
        System.out.println(usrName.size());
        CommonMethods.optionSelect(usrName,"White, Jane");

        driver.findElement(By.xpath("(//span[text() = 'Apply'])[2]")).click();

       WebElement selecUsr = driver.findElement(By.xpath("(//span[text()= 'White, Jane'])[1]"));
    CommonMethods.click(driver,selecUsr);

       Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement regRate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='regularRateColumn']//input[@type='text'])[1]")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", regRate);
        regRate.click();
        regRate.clear();

WebElement regRate1 = wait.until(ExpectedConditions.visibilityOf(regRate));

        regRate1.sendKeys("400");

        driver.findElement(By.xpath("(//div[@class='hideButton_panelContainer'])[1]"));

      /*  driver.findElement(By.xpath("(//span[text()= 'White, Jane'])[1]")).click();

       WebElement dollar =  driver.findElement(By.xpath("((//input[@type='text']/parent::div[@class = 'rateCell'])[1]"));

       actions.scrollToElement(dollar);

       dollar.sendKeys("500"); */



    }

}
