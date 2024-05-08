package actiTimeLogin;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LoginTest {
   static WebDriver driver ;
    public static WebDriver br(String browser){
       if(browser.equals("chrome"))
            driver = new ChromeDriver();
       else if(browser.equals("edge"))
           driver = new EdgeDriver();
           return driver ;
    }
    public static void main(String[] args) throws InterruptedException {
       WebDriver driver = new ChromeDriver();
        WebDriver driverbrowser = LoginTest.br("chrome");

/*

driver.get("https://online.actitime.com/cybersuccess7/login.do");
driver.manage().window().maximize();

Thread.sleep(5000);

//WebElement loginIn = driver.findElement(By.xpath("//a[text() ='Log in']"));
 // loginIn.click();


  //      Thread.sleep(5000);
  driver.findElement(By.xpath(""//input[@name='username']");

 // driver.findElement(By.id());
    //driver.quit();
*/

    }}

