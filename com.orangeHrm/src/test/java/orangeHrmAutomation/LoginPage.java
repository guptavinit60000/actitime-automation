package orangeHrmAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {
WebElement driver;

LoginPage(WebElement driver){


    this.driver = driver;
}

public void login(String username,String password);

        driver.findElement(By.name("username")).sendkeys(username);
    driver.findElement(By.name("password")).sendkeys(password);
    driver.findElement(By.xpath("//button[@type='submit']")).sendkeys(username);

}
