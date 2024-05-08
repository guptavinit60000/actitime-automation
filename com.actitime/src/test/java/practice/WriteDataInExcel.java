package practice;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class WriteDataInExcel {
    FileInputStream inputStream;
    Workbook workbook;
    Sheet sheet;
    public void writeData() throws IOException {
        File file = new File("path");
        // get the file name
        String fileName = file.getName();

        //get the extension of the file
        String extension = fileName.substring(fileName.indexOf(".")+1);
        inputStream= new FileInputStream(file);
        //check if extension is xlsx --> then create object of XSSFWorkbook
        // else create object of HSSFWorkbook
        if (extension.equals("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        }
        else {
            workbook = new HSSFWorkbook(inputStream);
        }
        //check if the sheet is present with cyber name or not
        //if not present then create , if present then use as it is.
        if (workbook.getSheet("cyber") != null ) {
            sheet = workbook.getSheet("cyber");
        }
        else {
            sheet = workbook.createSheet("cyber");
        }

    for (int i = 0 ; i<10 ; i++){
        //create row
            Row row = sheet.createRow(i);
            for ( int j =0 ; j<2; j++){
                //create cell

                Cell cell = row.createCell(j);
                if(j==0){
                    //add data in the cell
                    cell.setCellValue("Selenium" +i);
                }
                else {
                    // add data in the cell
                    cell.setCellValue("API" +i);
                }
            }

        }

        sheet.createRow(0).createCell(0).setCellValue("seleniuim");
        sheet.createRow(1).createCell(0).setCellValue("API");
        sheet.createRow(2).createCell(0).setCellValue("Manual");
        sheet.createRow(3).createCell(0).setCellValue("SQL");
        sheet.createRow(4).createCell(0).setCellValue("JAVA");
        sheet.createRow(5).createCell(0).setCellValue("Moblie testing");


        //write the data in file
        FileOutputStream outputStream = new FileOutputStream(file);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
        System.out.println("Data wtritten successfully in excel file ....");

    }
}
