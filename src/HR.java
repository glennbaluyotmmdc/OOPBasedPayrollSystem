

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
public class HR extends User implements UserActions {
    private EmployeeDatabase database;

    public HR(EmployeeDatabase database) {
        this.database = database;
    }
    
    public HR() {};
    public HR(int employeeID, String firstName, String surname, 
                    LocalDate birthday, String address, String sssNumber, 
                    String philHealthNumber, String tinNumber, String position, 
                    double basicSalary, double allowance) 
    {
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

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSssNumber(String sssNumber) {
        this.sssNumber = sssNumber;
    }

    public void setPhilHealthNumber(String philHealthNumber) {
        this.philHealthNumber = philHealthNumber;
    }

    public void setTinNumber(String tinNumber) {
        this.tinNumber = tinNumber;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
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
    


    // Add an employee
    public void addEmployee(Employee employee) {
        if (database != null) {
            if (database.addEmployeeToCSV(employee)) {
                System.out.println("Employee added successfully: " + employee.getFirstName() + " " + employee.getSurname());
            } else {
                System.out.println("Failed to add employee.");
            }
        } else {
            System.out.println("EmployeeDatabase is not initialized.");
        }
    }

    // Remove an employee
    public void deleteEmployee(int employeeID) {
        if (database.removeEmployeeByID(employeeID)) {
            System.out.println("Employee removed successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }
        // Date format for parsing CSV dates


    public static void setSalary(Employee employee, double salary, double allowance) {
        employee.basicSalary = salary;
        employee.allowance = allowance;
    }
    
    
        // Static method to load all Employee details from CSV
    public static List<Employee> loadEmployeesFromCSV() {
        String fileName = "employees.csv";
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if (firstLine) { 
                    firstLine = false; // Skip header row
                    continue;
                }

                String[] data = line.split(",");
                Employee emp = new Employee();
                emp.loadInformationFromCSV(data);
                employees.add(emp);
            }
        } catch (IOException e) {
            e.getLocalizedMessage();
        }
        return employees;
    }
}
