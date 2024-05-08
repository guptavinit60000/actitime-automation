package orangeHrmAutomation.actitimeLogin.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class orangehrm {
    public static void main(String [] arg) throws Exception {
        //launch the browser
        //ChromeOptions options=new ChromeOptions();  //capabilities
       // options.setBrowserVersion("118");
        //options.addArguments("--remote-allow-origins-*");
        WebDriver driver=new ChromeDriver();

        //Navigate to url
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(10000);
        WebElement usrname = driver.findElement(By.name("username"));
        usrname.sendKeys("admin");

        driver.findElement(By.name("password")).sendKeys("admin123");
        WebElement loginButton= driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        Thread.sleep(10000);

        WebElement dashboard = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
        String dashboardText = dashboard.getText();
        System.out.println(dashboardText);

        if (dashboardText.equals("Dashboard")) {
            System.out.println("Successfully landed on dashboard module");
        }else {
            throw new Exception("Unable login to application");
        }

        WebElement profile= driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']/following-sibling::i"));

        profile.click();

        driver.findElement(By.xpath("//a[text()='Logout']")).click();

        Thread.sleep(5000);

        usrname.sendKeys("admin24567");
        //driver.findElement(By.name("username")).sendKeys("admin24234234");



    }
}

