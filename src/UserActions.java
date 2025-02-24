/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author GlennPhillipBaluyot
 */
public interface UserActions {
    public abstract boolean login(String username, String password);
    public abstract String[] viewPersonalInformation();
    public abstract String[] viewSalary();
}
