/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpckg;

import java.util.LinkedList;

/**
 *
 * @author owenralbovsky
 */
public class Sort {
    
    
    /*
    ID
First Name
Last Name
Gender
Address
City
State
Postal Code
Hair Color
Eye Color
DL Number
    */
    
    public static LinkedList<Driver> sortMethod(int searchIndex, String searchText)
    {
        
        LinkedList<Driver> output = new LinkedList<Driver>();
        
        if(searchText.replace(" ", "").equals(""))
            return Driver.drivers;
        
        int index = searchIndex;
        
        switch(index) {
            case 8:
                index = 16;
                break;
            case 9:
                index = 8;
                break;
            case 10:
                index = 19;
        }
        
        for(int i = 0; i < Driver.drivers.size(); i++)
        {
            if(Driver.drivers.get(i).getValue(index).toString().contains(searchText))
                output.add(Driver.drivers.get(i));
        }
        
        return output;
    }
    
}
