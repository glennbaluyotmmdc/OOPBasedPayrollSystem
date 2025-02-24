
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author GlennPhillipBaluyot
 */
abstract class User {
    //attributes
    protected int employeeID;
    protected String firstName;
    protected String surname;
    protected LocalDate birthday;
    protected String address;
    protected String sssNumber;
    protected String philHealthNumber;
    protected String tinNumber;
    protected String position;
    protected double basicSalary;
    protected double allowance;
    protected String username;
    protected  String password; 
    
    //default constructor
    public User() {};
    
    //getters
    public int getEmployeeID() {
        return employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getAddress() {
        return address;
    }

    public String getSssNumber() {
        return sssNumber;
    }

    public String getPhilHealthNumber() {
        return philHealthNumber;
    }

    public String getTinNumber() {
        return tinNumber;
    }

    public String getPosition() {
        return position;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public double getAllowance() {
        return allowance;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    

    //Load from CSV using array
    public void loadInformationFromCSV(String[] data) {
        this.employeeID = Integer.parseInt(data[0]);
        this.firstName = data[1];
        this.surname = data[2];
        this.birthday = LocalDate.parse(data[3]);
        this.address = data[4];
        this.sssNumber = data[5];
        this.philHealthNumber = data[6]; 
        this.tinNumber = data[7];
        this.position = data[8];

        // Check if salary information is present before accessing it
        if (data.length > 9) {
            this.basicSalary = Double.parseDouble(data[9]);
        } else {
            this.basicSalary = 0.0; // Default value if missing
        }

        if (data.length > 10) {
            this.allowance = Double.parseDouble(data[10]);
        } else {
            this.allowance = 0.0; // Default value if missing
        }
    } 

}

