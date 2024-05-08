package Assign;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.security.KeyPairGeneratorSpi;
import java.time.Duration;

public class Amazone {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.d", "path_to_chromedriver");
        WebDriver d = new ChromeDriver();
        d.get("https://www.amazon.in");
        d.manage().window().maximize();
        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Actions ac = new Actions(d);
       // ac.contextClick(d.findElement(By.partialLinkText("Amazon miniTV"))).keyDown(Keys.SHIFT).click().keyDown(Keys.SHIFT).build().perform();
       // ac.contextClick(d.findElement(By.partialLinkText("Amazon miniTV"))).sendKeys("t").build().perform();
        WebElement mini = d.findElement(By.partialLinkText("Amazon miniTV"));
        ac.contextClick(d.findElement(By.partialLinkText("Amazon miniTV"))).perform();
       // ac.sendKeys("t").perform();


       //ac.co



        WebElement openInNewTabOption = d.findElement(By.xpath("//div[contains(text(),'Open link in new tab')]"));
        openInNewTabOption.click();
       // ac.keyDown(Keys.);

    }
}
