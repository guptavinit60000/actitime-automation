package practice;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import static testNgPractice.CreateCus.driver;

public class ActitimeExcel {

    Workbook workbook;
    public Workbook getWorkbook(String filePath) throws IOException {

        File file = new File(filePath);
        String fileName = file.getName();
        String extension = fileName.substring(fileName.indexOf(".") + 1);
        System.out.println(extension);

        //access the file
        FileInputStream inputStream = new FileInputStream(file);

        //access the workbook

        if (extension.equals("xlsx")) {
            Workbook workbook = new XSSFWorkbook(inputStream);
        } else if (extension.equals("xlx")) {
            Workbook workbook = new HSSFWorkbook(inputStream);
        }

        return workbook;
    }
    @Test
    public void Custmor(){

List<WebElement> AllCus = driver.findElements(By.xpath(""));
List<WebElement>AllProj = driver.findElements(By.xpath(""));



    }
}
