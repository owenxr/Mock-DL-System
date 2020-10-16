/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpckg;

import java.util.LinkedList;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author owenralbovsky
 */
public class Sort {
    
    //Unfinished
    public static LinkedList<Driver> sortMethod(int column)
    {
        XSSFWorkbook save = ExcelToDriver.data;
        XSSFSheet sheet = save.getSheetAt(0);
        
        LinkedList<String> stuff = new LinkedList<String>();
        LinkedList<String> dateStuff = new LinkedList<String>();
        
        LinkedList<Driver> output = new LinkedList<Driver>();
        
        if(column != 9 || column != 10)
        {
            
        }
        else
        {
            for(Row r : sheet)
            {
                String data = r.getCell(column).getStringCellValue();
                String newS;
                for(int i = data.length() - 1; i>=0; i++)
                {
                    if(data.charAt(i) == '/')
                    {
                        //newS = data.substring();
                    }
                }
            }
        } 
        
            for(Row r : sheet)
            {
            
            }
            
        return output;
    }
    
}
