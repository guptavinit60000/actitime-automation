package practice;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelHandling {
    FileInputStream inputStream;
    Workbook workbook;

    //get the contraol of the workbook
    public Workbook getWorkbook(String filePath) throws IOException {

        File file = new File(filePath);
        String fileName = file.getName();
        String extension = fileName.substring(fileName.indexOf(".") + 1);
        System.out.println(extension);

        //access the file
        inputStream = new FileInputStream(file);

        //access the workbook
        if (extension.equals("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (extension.equals("xlx")) {
            workbook = new HSSFWorkbook(inputStream);
        }

        return workbook;
    }


    //get the excel data
    @DataProvider
    public Object[][] getExcelData() throws IOException {


        Workbook workbook1 = getWorkbook("vvvvvvvvh");

        //access 0th index sheet
        Sheet sheet = workbook.getSheetAt(0);

        //get the total number of rows
        int totalRows = sheet.getPhysicalNumberOfRows();
        System.out.println("Total Rows : " + totalRows);

        //get total number of columns

        Row row;

        row = sheet.getRow(0);
        int totalColumns = row.getPhysicalNumberOfCells();
        System.out.println("Total Columns :" + totalColumns);

        Object[][] data = new Object[totalRows][totalColumns];

        for (int i = 1; i < totalRows; i++) {
            //get the access of each row based on the value of i
            row = sheet.getRow(i);

            for (int j = 0; j < totalColumns; j++) {

                Cell cel = row.getCell(j);
                Object value = null;
                if (cel.getCellType() != null) {
                    switch (cel.getCellType()) {
                        case STRING:
                            value = cel.getStringCellValue();
                            break;
                        case NUMERIC:
                            value = cel.getNumericCellValue();
                            break;
                        case BLANK:
                            value = "";
                            break;
                    }
                    data[i-1][j]=value;
                    System.out.print(value+ "");
                }

            }
            System.out.println();
        }
        return data;
    }

//close workbook and fileinputstream instances
public void closeInstance() throws IOException {

        //close workbook
    workbook.close();
    //close file
    inputStream.close();
}

@Test(dataProvider = "getExcelData")
public void verifyExcelData(Object var1 , Object var2 ) {
    System.out.println(var1 + " " + var2);
}

@AfterClass
public void tearDown() throws IOException {

    closeInstance();        }

    }


