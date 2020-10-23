package mainpckg;


import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author owenralbovsky
 */
public class ExcelToDriver {

    public static XSSFWorkbook data;
    
    public static void retrieveData(String path)
    {
        try
        {
            data = new XSSFWorkbook(path);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public static void dataToDriver()
    {
        
        XSSFSheet sheet = data.getSheetAt(0);
        
        int i = 0;
        for(Row row : sheet)
        {
            if(i == 0)
            {
                i++;
                continue;
            }
            
            //ID, First, Last, Gender, Address, Address 2, Hair Color, Eye Color, DOB, Exp Date, Weight, Height, Points, Vision, Donor, DL Number
            
            Driver d = new Driver((int) row.getCell(0).getNumericCellValue(), 
            row.getCell(1).getStringCellValue(), 
            row.getCell(2).getStringCellValue(),
            row.getCell(3).getStringCellValue(), 
            row.getCell(4).getStringCellValue(),
            row.getCell(5).getStringCellValue(), 
            row.getCell(6).getStringCellValue(),
            row.getCell(7).getStringCellValue(), row.getCell(8).getDateCellValue(),
            row.getCell(9).getDateCellValue(),
            (int) row.getCell(10).getNumericCellValue(), (int) row.getCell(11).getNumericCellValue(),
            (int) row.getCell(12).getNumericCellValue(), (int) row.getCell(13).getNumericCellValue(),
            (int) row.getCell(14).getNumericCellValue(), (int) row.getCell(15).getNumericCellValue());
            
            Driver.drivers.add(d);
        }
        
    }
    
}
