package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CommonMethods {
    public static void optionSelect(List<WebElement> options, String option) {
        for (WebElement cs : options) {
            if (cs.getText().equals(option)) {
                cs.click();
                break;
            }
        }
    }

    public static void click(WebDriver driver , WebElement elmnt){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elmnt));
        element.click();
    }
}