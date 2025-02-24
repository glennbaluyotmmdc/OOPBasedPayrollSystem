/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author GlennPhillipBaluyot
 */
public class PayrollCalculator {
    private static final double TAX_RATE = 0.30; //Created a fixed percentage for TAX which is 30%. You can create a logic to change this based on the basic salary
    private static final double SSS_RATE = 500; //Fixed SSS rate. Add a logic if you want to make this dynamic
    private static final double PHILHEALTH_RATE = 1000; //Fixed PhilHealth  rate. Add a logic if you want to make this dynamic
    private static final double PAGIBIG_RATE = 200;
    
    public static double calculateGrossSalary(double basicSalary, double allowance)
    {
        double grossSalary = basicSalary + allowance;
        return grossSalary;
    }
    
    public static double calculateNetSalary(double basicSalary, double allowance)
    {
        double grossSalary = calculateGrossSalary(basicSalary, allowance);
        
        //There are instances in which TAX_RATE differs based on the gross salary including SSS, PhilHealth, and PAGIBIG.
        //You may want to add that logic in here to make it dynamic.
        double netSalary = grossSalary - (grossSalary * TAX_RATE) - SSS_RATE - PHILHEALTH_RATE - PAGIBIG_RATE;
        return netSalary;
    }
}
