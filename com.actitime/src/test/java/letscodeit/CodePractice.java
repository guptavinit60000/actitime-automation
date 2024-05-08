package letscodeit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.time.Duration;
import java.util.List;

public class CodePractice {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.letskodeit.com/practice");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        JavascriptExecutor js = (JavascriptExecutor) driver ;
        js.executeScript("window.scrollBy(0, 500)");

        WebElement showhide =driver.findElement(By.name("show-hide"));
        if(showhide.isDisplayed())
        showhide.sendKeys("vinit gupta baniya");
        driver.findElement(By.id("hide-textbox")).click();

        if(showhide.isDisplayed())
            showhide.sendKeys("vinit gupta baniya hai");
        else
            System.out.println("Element is hide");

        driver.findElement(By.id("show-textbox")).click();

        if(showhide.isDisplayed())
            showhide.sendKeys("Element find");
        else
            System.out.println("Element didnot find");



        WebElement sel = driver.findElement(By.id("carselect"));

        Select select = new Select(sel);

       List<WebElement> ln  = select.getOptions();
        for(int i = 0 ; i< ln.size() ; i++){
            System.out.println(ln.get(i).getText());

            }

        }
    }

