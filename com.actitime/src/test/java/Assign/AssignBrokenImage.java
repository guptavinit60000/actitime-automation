package Assign;

import common.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import org.openqa.selenium.devtools.v119.*;
public class AssignBrokenImage {

    public static void main(String[] args) throws IOException {

        CommonFunctions commonFunctions = new CommonFunctions();

        WebDriver driver = commonFunctions.launchBrowser("chrome");

        driver.get("https://www.amazon.in/");

        List<WebElement> imageWebElementslist =driver.findElements(By.tagName("img"));

        for (WebElement imageElement : imageWebElementslist) {
            String img = imageElement.getAttribute("src");
            try {
                URL url = new URL(img);
                URLConnection connection = url.openConnection();
                HttpURLConnection urlConnection = (HttpURLConnection) connection;
                urlConnection.connect();
                int statusCode = urlConnection.getResponseCode();
                if (statusCode == 200)
                    System.out.println("BROKEN LINK " + statusCode + " " + img);

            } catch (IOException e) {
                System.err.println("Error connecting to URL: " + img);
                e.printStackTrace();
            }
        }

    }
        }


