package practice;

import common.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class FindLinks {

    public static void main(String[] args) throws IOException {


        CommonFunctions commonFunctions = new CommonFunctions();

        WebDriver driver = commonFunctions.launchBrowser("chrome");

        driver.get("https://www.amazon.in/");

        List<WebElement> webElementList = driver.findElements(By.tagName("a"));


        //iterate through the list to get element

        for (WebElement element : webElementList) {


            String link = element.getAttribute("href");

            if (link != null && !link.startsWith("javascript")) {


               // System.out.println(link);

                URL url = new URL(link);

                URLConnection connection = url.openConnection();

                HttpURLConnection urlConnection = (HttpURLConnection) connection;


                urlConnection.connect();

                int statusCode = urlConnection.getResponseCode();

                if (statusCode != 200)

                    System.out.println("BROKEN LINK" + statusCode + " " +link);





            }
        }


    }

}

