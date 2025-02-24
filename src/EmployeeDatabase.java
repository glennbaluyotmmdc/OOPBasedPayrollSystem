/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author GlennPhillipBaluyot
 */
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDatabase {

    protected String employeeFile;
    protected String credentialsFile;

    public EmployeeDatabase(String employeeFile, String credentialsFile) {
        this.employeeFile = employeeFile;
        this.credentialsFile = credentialsFile;
    }

    public String getEmployeeFile() {
        return employeeFile;
    }

    public String getCredentialsFile() {
        return credentialsFile;
    }
    
    // Validate login by checking credentials.csv
    public int validateLogin(String username, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader(credentialsFile))) {
            String line;
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                if (firstLine) { // Skip header
                    firstLine = false;
                    continue;
                }
                String[] data = line.split(",");
                if (data.length < 3) continue;  // Ensure the line has all three fields

                String storedUsername = data[1].trim();
                String storedPassword = data[2].trim();

        if (storedUsername.equals(username) && storedPassword.equals(password)) {
            return Integer.parseInt(data[0]); // Return employeeID if match found
        } 

            }
        } catch (IOException e) {
            e.getLocalizedMessage();
        }
        return -1; // Return -1 if login fails
    }

    public User getEmployeeByID(int employeeID) {
        try (BufferedReader br = new BufferedReader(new FileReader("employees.csv"))) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false; // Skip header row
                    continue;
                }

                String[] data = line.split(",");

                if (data.length > 0 && Integer.parseInt(data[0]) == employeeID) {
                   
                    Employee employee = new Employee(
                        Integer.parseInt(data[0]), data[1], data[2], 
                        LocalDate.parse(data[3]), data[4], data[5], data[6], data[7], 
                        data[8], Double.parseDouble(data[9]), Double.parseDouble(data[10])
                    );

                    return employee;  // Return the employee object
                }
            }
        } catch (IOException e) {
            e.printStackTrace();  // Print the exception stack trace for debugging
        }
        return null; // If no employee found
    }





    
    // Helper method to remove an employee by ID
    public boolean removeEmployeeByID(int employeeID) {
        List<String> updatedLines = new ArrayList<>();
        boolean removed = false;

        try (BufferedReader br = new BufferedReader(new FileReader(employeeFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (Integer.parseInt(data[0]) == employeeID) {
                    removed = true; // Employee found, do not add this line
                } else {
                    updatedLines.add(line);
                }
            }
        } catch (IOException e) {
            e.getLocalizedMessage();
            return false;
        }

        // Rewrite the CSV file without the removed employee
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(employeeFile))) {
            for (String updatedLine : updatedLines) {
                bw.write(updatedLine);
                bw.newLine();
            }
        } catch (IOException e) {
            e.getLocalizedMessage();
            return false;
        }

        return removed;
    }
    // Helper method to add an employee to the CSV
    public boolean addEmployeeToCSV(Employee employee) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(employeeFile, true))) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            String line = employee.getEmployeeID() + "," + employee.getFirstName() + "," +
                    employee.getSurname() + "," + employee.getBirthday().format(formatter) + "," +
                    employee.getAddress() + "," + employee.getSssNumber() + "," +
                    employee.getPhilHealthNumber() + "," + employee.getTinNumber() + "," +
                    employee.getPosition() + "," + employee.getBasicSalary() + "," +
                    employee.getAllowance();
            bw.write(line);
            bw.newLine();
        } catch (IOException e) {
            e.getLocalizedMessage();
            return false;
        }

        // Also add credentials to credentials.csv
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(credentialsFile, true))) {
            String credentialsLine = employee.getEmployeeID() + "," + employee.getUsername() + "," + employee.getPassword();
            bw.write(credentialsLine);
            bw.newLine();
        } catch (IOException e) {
            e.getLocalizedMessage();
            return false;
        }

        return true;
    }
    
    public boolean updateEmployeeInCSV(int employeeID, Employee updatedEmployee) {
        List<String> updatedLines = new ArrayList<>();
        boolean updated = false;

        // Read the file and update the employee record
        try (BufferedReader br = new BufferedReader(new FileReader(employeeFile))) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if (firstLine) { // Skip the header
                    updatedLines.add(line);
                    firstLine = false;
                    continue;
                }

                String[] data = line.split(",");
                if (Integer.parseInt(data[0]) == employeeID) {
                    // Employee found, update the line with new employee data
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                    String updatedLine = updatedEmployee.getEmployeeID() + "," +
                            updatedEmployee.getFirstName() + "," +
                            updatedEmployee.getSurname() + "," +
                            updatedEmployee.getBirthday().format(formatter) + "," +
                            updatedEmployee.getAddress() + "," +
                            updatedEmployee.getSssNumber() + "," +
                            updatedEmployee.getPhilHealthNumber() + "," +
                            updatedEmployee.getTinNumber() + "," +
                            updatedEmployee.getPosition() + "," +
                            updatedEmployee.getBasicSalary() + "," +
                            updatedEmployee.getAllowance();
                    updatedLines.add(updatedLine);
                    updated = true; // Mark as updated
                } else {
                    updatedLines.add(line); // Add the unmodified line
                }
            }
        } catch (IOException e) {
            e.getLocalizedMessage();
            return false; // Return false if there's an error
        }

        // If employee was updated, rewrite the CSV file with updated lines
        if (updated) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(employeeFile))) {
                for (String updatedLine : updatedLines) {
                    bw.write(updatedLine);
                    bw.newLine();
                }
            } catch (IOException e) {
                e.getLocalizedMessage();
                return false;
            }
        }

        return updated; // Return true if employee was successfully updated, false otherwise
    }

}
