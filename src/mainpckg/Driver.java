package mainpckg;


import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author owenralbovsky
 */
public class Driver {
    
    public static LinkedList<Driver> drivers = new LinkedList<Driver>();
    
    private int id, vision, dlNumber, postalCode, age;
    private String firstName, lastName, gender, address, city, state, eyeColor;
    private Date dob, expDate;
    private boolean underAge, visionPassed;
    
    public Driver(int id, String firstName, String lastName, String gender,
            String address, String city, String state, int postalCode, String eyeColor,
            Date dob, Date expDate, int age, boolean underAge, int vision, 
            boolean visionPassed, int dlNumber)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.address = address;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.eyeColor = eyeColor;
        this.dob = dob;
        this.expDate = expDate;
        this.age = age;
        this.underAge = underAge;
        this.vision = vision;
        this.visionPassed = visionPassed;
        this.dlNumber = dlNumber;
    }
    
    public int getID()
    {
        return id;
    }
    public int getVision()
    {
        return vision;
    }
    public int getDLNum()
    {
        return dlNumber;
    }
    public int getPostalCode()
    {
        return postalCode;
    }
    public int getAge()
    {
        return age;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public String getGender()
    {
        return gender;
    }
    public String getAddress()
    {
        return address;
    }
    public String getCity()
    {
        return city;
    }
    public String getState()
    {
        return state;
    }
    public String getEyeColor()
    {
        return eyeColor;
    }
    public Date getDOBDate()
    {
        return dob;
    }
    public Date getEXPDate()
    {
        return expDate;
    }
    public boolean isUnderAge()
    {
        return underAge;
    }
    public boolean isVisionPassed()
    {
        return visionPassed;
    }
    
    public void setID(int id)
    {
        this.id = id;
    }
    public void setVision(int vision)
    {
        this.vision = vision;
        if(vision >= 20)
            visionPassed = true;
        else
            visionPassed = false;
    }
    public void setDLNum(int dlNum)
    {
        this.dlNumber = dlNum;
    }
    public void setPostalCode(int postalCode)
    {
        this.postalCode = postalCode;
    }
    public void setAge(int age)
    {
        this.age = age;
        if(age >= 21)
            underAge = false;
        else
            underAge = true;
    }
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    public void setGender(String gender)
    {
        this.gender = gender;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
    public void setCity(String city)
    {
        this.city = city;
    }
    public void setState(String state)
    {
        this.state = state;
    }
    public void setEyeColor(String eyeColor)
    {
        this.eyeColor = eyeColor;
    }
    public void setDOBDate(String DOBDate)
    {
        LinkedList<String> list = (LinkedList<String>) Arrays.asList(DOBDate.split("/"));
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.MONTH, Integer.parseInt(list.get(0).trim()));
            cal.set(Calendar.DAY_OF_WEEK, Integer.parseInt(list.get(1).trim()));
            cal.set(Calendar.YEAR, Integer.parseInt(list.get(2).trim()));
            Date d = new Date();
            d.setTime(cal.getTimeInMillis());
            dob = d;
    }
    public void setEXPDate(String EXPDate)
    {
        LinkedList<String> list = (LinkedList<String>) Arrays.asList(EXPDate.split("/"));
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.MONTH, Integer.parseInt(list.get(0).trim()));
            cal.set(Calendar.DAY_OF_WEEK, Integer.parseInt(list.get(1).trim()));
            cal.set(Calendar.YEAR, Integer.parseInt(list.get(2).trim()));
            Date d = new Date();
            d.setTime(cal.getTimeInMillis());
            expDate = d;
    }
    
    public Calendar toCal(Date d)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        return cal;
    }
    
    public String toString()
    {
        String r;
        r = "\n------------------------------------------------";
        r += "\nID: " + id;
        r += "\nFirst Name: " + firstName;
        r += "\nLast Name: " + lastName;
        r += "\nGender: " + gender;
        r += "\nAddress: " + address;
        r += "\nCity: " + city;
        r += "\nState: " + state;
        r += "\nPostal Code: " + postalCode;
        r += "\nEye Color: " + eyeColor;
        r += "\nDate Of Birth: " + dob.toString();
        r += "\nExpiration Date: " + expDate.toString();
        r += "\nAge: " + age;
        r += "\nUnder Age? " + underAge;
        r += "\nVision " + vision + "/20";
        r += "\nVision Passed? " + visionPassed;
        r += "\nDriver's License Number: " + dlNumber;
        r += "\n------------------------------------------------";
        r += "\n";
        
        return r;
    }
    
}
