package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class CommonFunctions {

    WebDriver driver;

    // launch the browser


    public WebDriver launchBrowser(String browserName) {

        switch (browserName) {

            case "chrome":
                ChromeOptions options = new ChromeOptions(); // capapbilites
                options.setBrowserVersion("stable");
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--start-maximized");
                driver = new ChromeDriver(options);
                break;

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setBrowserVersion("stable");
                edgeOptions.addArguments("--start-maximized");
                driver = new EdgeDriver(edgeOptions);
                break;


            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setBrowserVersion("stable");
                firefoxOptions.addArguments("--startmaximized");
                driver = new FirefoxDriver(firefoxOptions);
                break;

            default:
                ChromeOptions chromeOptionsoptions = new ChromeOptions(); // capapbilites
                chromeOptionsoptions.setBrowserVersion("stable");
                chromeOptionsoptions.addArguments("--remote-allow-origins=*");
                chromeOptionsoptions.addArguments("--start-maximized");
                driver = new ChromeDriver(chromeOptionsoptions);
                break;


        }

        return driver;


    }


        public void  fluentWait( WebDriver driver , By by ){

            Wait<WebDriver>FluentWait = new FluentWait<>(driver)
                    .pollingEvery(Duration.ofSeconds(2))
                    .withTimeout(Duration.ofSeconds(15))
                    .ignoring(Exception.class);

            Function< WebDriver, WebElement > function = (var)->{

                System.out.println("wait until the element is availabel ...");

                return driver.findElement(by);

            };
            FluentWait.until(function);

        }

        public void waitForElementToPresent(WebDriver driver , WebElement element){

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(element));           }

        public void waitElementToClickable(WebElement element){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));           }

    public  void  waitElementToClickable(By by){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(by));        }














        /* if (name.toLowerCase().equals("chrome")) {

           // ChromeOptions options = new ChromeOptions(); // capapbilites

            //options.setBrowserVersion("118");

            //options.addArguments("--remote-allow-origins=*");

            driver = new ChromeDriver();
        }

        return driver;
    }

    }*/


    }

