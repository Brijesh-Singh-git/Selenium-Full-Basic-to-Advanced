package Data_Driven_Testing;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class WriteData_Excel {
    public static void main(String[] args) throws IOException {

        //Create Excel File first
        FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\TestData\\myFile.xlsx");

        //Create a new Workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        XSSFSheet sheets = workbook.createSheet("DummyData");

        /*
        XSSFCell cell = sheets.createRow(0).createCell(1);

        cell.setCellValue("Welcome");
        cell.setCellValue("To");
        cell.setCellValue("India");

         */

        //Creating rows, cells amd update data without using the loop
      /*  XSSFRow row = sheets.createRow(0);

        row.createCell(0).setCellValue("Welcome");
        row.createCell(1).setCellValue("To");
        row.createCell(2).setCellValue("India!!");

        XSSFRow row2 = sheets.createRow(1);
        row2.createCell(0).setCellValue("This is ");
        row2.createCell(1).setCellValue("Java ");
        row2.createCell(2).setCellValue("Programming");

*/

        //Creating rows, cells amd update data using the loop
        Scanner sc = new Scanner(System.in);

        for(int r=0 ; r<=2 ; r++){

            XSSFRow currentRow = sheets.createRow(r);

            for(int c=0 ; c<2 ; c++){

                //currentRow.createCell(c).setCellValue("WELCOME!!");

                //User will provide the value
                System.out.println("Enter the Value: ");
                String value = sc.next();
                currentRow.createCell(c).setCellValue(value);

            }
        }


        workbook.write(file);
        workbook.close();
        file.close();

        System.out.println("Writing is Done!!!!");
    }
}
