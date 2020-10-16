/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpckg;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author owenralbovsky
 */
public class Save {
    
    public static XSSFWorkbook data;
    
    public static void save(String path)
    {
        data = new XSSFWorkbook();
        
        XSSFSheet sheet = data.createSheet();
        sheet = data.getSheetAt(0);
        
        int driversLen = Driver.drivers.size() + 1;
        
        for(int i = 0; i < driversLen; i++)
        {
            sheet.createRow(i);
            for(int k = 0; k<19; k++)
            {
                sheet.getRow(i).createCell(k);
                sheet.getRow(i).getCell(k).setCellValue(headers(k));
            }
        }
        
        
        
        try
        {
        FileOutputStream fOut = new FileOutputStream(new File(path));
        data.write(fOut);
        fOut.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public static String headers(int i)
    {
        switch(i)
        {
            case 0:
                return "id";
            case 1:
                return "First Name";
            case 2:
                return "Last Name";
            case 3:
                return "Gender";
            case 4:
                return "Address";
            case 5:
                return "City";
            case 6:
                return "State";
            case 7:
                return "Postal Code";
            case 8:
                return "Eye Color";
            case 9:
                return "DOB";
            case 10:
                return "Expiration Date";
            case 11:
                return "Age";
            case 12:
                return "Under Age";
            case 13:
                return "Vision";
            case 14:
                return "Vision Passed";
            case 15:
                return "DL Number";
            case 16:
                return "Hair Color";
            case 17:
                return "Height";
            case 18:
                return "Weight";
            case 19:
                return "Organ Donor";
        }
        return "";
    }
    
}
