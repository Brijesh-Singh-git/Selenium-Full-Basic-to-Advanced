package Data_Driven_Testing;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadData_Excel {
    public static void main(String[] args) throws IOException {

        //File --> Workbook --> Sheet --> Rows --> Cells

        FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\ExcelData.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(file);

        //Get the sheet from workbook
        XSSFSheet sheets = workbook.getSheet("Sheet1");
        //XSSFSheet sheets = workbook.getSheetAt(0);

        //No fo rows
        int totalRows = sheets.getLastRowNum();

        //No of Cells
        int totalCells = sheets.getRow(1).getLastCellNum();


        System.out.println("No of Rows: " + totalRows); //5
        System.out.println("No of Cells: " + totalCells); //4

        for(int r=0; r<=totalRows ; r++){

            XSSFRow currentRow = sheets.getRow(r);

            for(int c=0 ; c<totalCells ; c++){

                String value = currentRow.getCell(c).toString();
                System.out.print(value + "      ");
            }
            System.out.println();
        }

        workbook.close();
        file.close();








    }
}
