package practice;

import common.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class CalenderExample {

    public static void main(String[] args) {

        //get the current day of month

        int dayofmonth = LocalDateTime.now().getDayOfMonth();
        System.out.println("Day of month is " +dayofmonth);

        String currentmonth = LocalDateTime.now().getMonth().name();
        String actualcurrentmonth = currentmonth.charAt(0) +currentmonth.substring(1,currentmonth.length()).toLowerCase();
        System.out.println("Actual current month is " +actualcurrentmonth);

        CommonFunctions commonFunctions = new CommonFunctions();

        WebDriver driver = commonFunctions.launchBrowser("chrome");

        driver.get("https://online.actitime.com/cybersuccess7/login.do");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();


        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("cybersuccess@yopmail.com");
        driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("Test@1234");
        driver.findElement(By.xpath("//div[contains(text(),'Login')]")).click();

        driver.findElement(By.id("container_tasks")).click();

        driver.findElement(By.xpath("//div[ text() ='Flight operations']")).click();

        driver.findElement(By.xpath("//div[@class ='rightContainer']")).click();

        driver.findElement(By.xpath("//div[@class ='detailsRow']/descendant::div[text()='Set up deadline']")).click();

        String monthXpath = "//td[starts-with(title,'"+actualcurrentmonth+"')]/div" ;

        System.out.println(monthXpath);

        List <WebElement> days = driver.findElements(By.xpath(monthXpath));

        for ( WebElement dayElement : days){

            String day = dayElement.getText();

            System.out.println(day);

            //check if the day value is euqals to the day of month then select that day
            //also convert the dayofmonth into string for  comparison

            if (day.equals(String.valueOf(dayofmonth))){

                dayElement.click();
            }
        }


    }
}
