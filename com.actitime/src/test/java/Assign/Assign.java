package Assign;

import common.CommonFunctions;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Assign {

    public static void main(String[] args) throws InterruptedException{
        WebDriver driver = new ChromeDriver();

        driver.get("https://online.actitime.com/cybersuccess7/login.do");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();


        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("cybersuccess@yopmail.com");

        driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("Test@1234");

        driver.findElement(By.xpath("//div[contains(text(),'Login')]")).click();


        driver.findElement(By.xpath("//div[text()='Tasks']")).click();
        Thread.sleep(10000);

        List<WebElement> allTask = driver.findElements(By.xpath("//table[@class ='taskRowsTable']//div[@class = 'title']"));
        System.out.println("ALL TASK : " + allTask.size());
        List<String> allTaskText = new ArrayList<>();
        for(WebElement element : allTask){
            allTaskText.add(element.getText());
        }

       for(WebElement task : allTask ){

            if(task.isDisplayed()){

                System.out.println(task.getText());

            }

            else {
                Actions actions = new Actions(driver);
                actions.scrollToElement(task).build().perform();
                System.out.println(task.getText());


            }

        }



        driver.findElement(By.xpath("//tr[@class = 'headers']//child::div[@class ='img']")).click();

        driver.findElement(By.xpath("//div[@class ='moveTo button']")).click();

//................(//div[@class = 'dropdownButton'])[3]
        //...................//div[@class = 'customer']//div[@class = 'itemRow cpItemRow ']
        //.................... //div[@class = 'project']//div[@class = 'itemRow cpItemRow ']
        //....................... (//div[@class = 'project']//div[@class = 'dropdownButton'])[1]

        driver.findElement(By.xpath("(//div[@class = 'dropdownButton'])[3]")).click();

       List <WebElement> customer = driver.findElements(By.xpath("//div[@class = 'customer']//div[@class = 'itemRow cpItemRow ']"));
     /*
        CommonFunctions.optionSelect(customer , "Big Bang Company");

        driver.findElement(By.xpath("(//div[@class = 'project']//div[@class = 'dropdownButton'])[1]")).click();
        List<WebElement> project = driver.findElements(By.xpath("//div[@class = 'project']//div[@class = 'itemRow cpItemRow ']"));
        CommonFunctions.optionSelect(project,"Spaceship building");

        driver.findElement(By.xpath("(//div[text() = 'Move'])[3]")).click();
        Thread.sleep(20000);

List<WebElement> allCustmor = driver.findElements(By.xpath("//div[@class = 'unfilteredContainer']//div[@class = 'title']"));
       CommonFunctions.optionSelect(allCustmor,"Spaceship building");


       // driver.findElement(By.xpath("//div[@class = 'node projectNode editable selected']//div[text() = 'Spaceship building']")).click();

        List<WebElement> movedTask =  driver.findElements(By.xpath("//table[@class ='taskRowsTable']//div[@class = 'title']"));
        System.out.println(movedTask.size());
        List<String> movedTaskText = new ArrayList<>();
        for(WebElement element : movedTask){
            movedTaskText.add(element.getText());
        }
        boolean result = movedTaskText.containsAll(allTaskText);
        if(result)
        System.out.println();
          /*
            for(WebElement cs : customer){
                if(cs.getText().equals("coder")){
                    cs.click();
                    break;
                }
            }

           */


    }
}
