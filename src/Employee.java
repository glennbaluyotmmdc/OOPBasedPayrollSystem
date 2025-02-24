
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author GlennPhillipBaluyot
 */
public class Employee extends User implements UserActions { 
//superclass is User and implements the interface UserActions

    //Constructors
    public Employee() {
        super();
    }

public Employee(int employeeID, String firstName, String surname, LocalDate birthday,
                String address, String sssNumber, String philHealthNumber, String tinNumber,
                String position, double basicSalary, double allowance) {
    this.employeeID = employeeID;
    this.firstName = firstName;
    this.surname = surname;
    this.birthday = birthday;
    this.address = address;
    this.sssNumber = sssNumber;
    this.philHealthNumber = philHealthNumber;
    this.tinNumber = tinNumber;
    this.position = position;
    this.basicSalary = basicSalary;
    this.allowance = allowance;
}

    
    //Login reads from the CSV file by passing the username and password.
    @Override
    public boolean login(String username, String password) {
        EmployeeDatabase db = new EmployeeDatabase("employees.csv", "credentials.csv");
        int empID = db.validateLogin(username, password);
        if (empID != -1) {
            this.employeeID = empID;
            return true; // Login successful
        }
        return false; // Login failed
    }

    @Override
    public String[] viewPersonalInformation() {
        return new String[]{
            String.valueOf(getEmployeeID()),
            getFirstName(),
            getSurname(),
            getBirthday().toString(),
            getAddress(),
            getSssNumber(),
            getPhilHealthNumber(),
            getTinNumber(),
            getPosition()
        };
    }
    

    @Override
    public String[] viewSalary() {
        
        double grossSalary = PayrollCalculator.calculateGrossSalary(basicSalary, allowance);
        double netSalary = PayrollCalculator.calculateNetSalary(basicSalary, allowance);
        
        return new String[]{
            String.valueOf(grossSalary),
            String.valueOf(netSalary)
        };
    } 
    
    
}