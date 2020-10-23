package mainpckg;


import java.time.LocalDate;
import java.time.Period;
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
    
    //ID, First, Last, Gender, Address, Address 2, Hair Color, Eye Color, DOB, Exp Date, Weight, Height, Points, Vision, Donor, DL Number
    
    public static LinkedList<Driver> drivers = new LinkedList<Driver>();
    
    private int id, vision, dlNumber, postalCode, age, weight, points;
    private String firstName, lastName, gender, address, city, state, eyeColor, hairColor, height;
    private Date dob, expDate;
    private boolean underAge, visionPassed, donor, canDrive;
    
    public Driver(int id, String firstName, String lastName, String gender,
            String address, String address2, String hairColor, String eyeColor,
            Date dob, Date expDate, int weight, int height, int points, int vision, 
            int donor, int dlNumber)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.address = address;
        System.out.println(address2);
        this.city = address2.substring(0, address2.indexOf(","));
        this.state = address2.substring(address2.indexOf(',') + 2, address2.indexOf(',') + 4);
        this.postalCode = Integer.parseInt(address2.substring(address2.indexOf(',') + 5, address2.length()));
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.dob = dob;
        this.expDate = expDate;
        this.age = getAgeNum();
        this.underAge = age > 16;
        this.vision = vision;
        this.visionPassed = vision >= 15;
        this.dlNumber = dlNumber;
        this.height = Math.floor(height/12) + "'" + height % 12 + "\"";
        this.hairColor = hairColor;
        this.weight = weight;
        this.donor = donor == 1;
        this.points = points;
        this.canDrive = points <= 5 || !underAge;
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
    public String getHairColor()
    {
        return hairColor;
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
    public String getHeight()
    {
        return height;
    }
    public int getWeight()
    {
        return weight;
    }
    public boolean getDonor()
    {
        return donor;
    }
    public boolean canDrive()
    {
        return canDrive;
    }
    public int getPoints()
    {
        return points;
    }
    public void setDonor(boolean donor)
    {
        this.donor = donor;
    }
    public void setHeight(int height)
    {
        this.height = ((int) Math.floor(height/12)) + "'" + height % 12 + "\"";
    }
    
    public void setID(int id)
    {
        this.id = id;
    }
    public void setVision(int vision)
    {
        this.vision = vision;
        visionPassed = vision >= 15;
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
        underAge = age < 16;
        canDrive = points <= 5 || !underAge;
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
    public void setHairColor(String hairColor)
    {
        this.hairColor = hairColor;
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
    public void setWeight(int weight)
    {
        this.weight = weight;
    }
    public void setPoints(int points)
    {
        this.points = points;
        canDrive = points <= 5;
    }
    
    private int getAgeNum()
    {
        Calendar c = Calendar.getInstance();
        c.setTime(dob);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int date = c.get(Calendar.DATE);
        LocalDate dobDate = LocalDate.of(year, month, date);
        LocalDate now = LocalDate.now();
        Period dif = Period.between(dobDate, now);
        
        return age;
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
    
    public Object getValue(int val)
    {
        switch(val)
        {
            case 0:
                return id;
            case 1:
                return firstName;
            case 2:
                return lastName;
            case 3:
                return gender;
            case 4:
                return address;
            case 5:
                return city;
            case 6:
                return state;
            case 7:
                return postalCode;
            case 8:
                return eyeColor;
            case 9:
                String r = toCal(dob).get(Calendar.MONTH) + "/" 
                        + toCal(dob).get(Calendar.DATE) + "/" 
                        + toCal(dob).get(Calendar.YEAR);
                return r;
            case 10:
                r = toCal(expDate).get(Calendar.MONTH) + "/" 
                        + toCal(expDate).get(Calendar.DATE) + "/" 
                        + toCal(expDate).get(Calendar.YEAR);
                return r;
            case 11:
                return age;
            case 12:
                return underAge;
            case 13:
                return vision;
            case 14:
                return visionPassed;
            case 15:
                return dlNumber;
            case 16:
                return hairColor;
            case 17:
                return height;
            case 18:
                return weight;
            case 19:
                return donor;
        }
        return null;
    }
    
}
