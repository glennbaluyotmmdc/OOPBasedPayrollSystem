
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author GlennPhillipBaluyot
 */
public class EmployeeInformationGUI extends javax.swing.JFrame {

    /**
     * Creates new form EmployeeInformationGUI
     */
    public EmployeeInformationGUI() {
        initComponents();
    }

    private int employeeID;
    
    public EmployeeInformationGUI(int employeeID)
    {
        initComponents();
        this.employeeID = employeeID;      
        loadEmployeeInformation(employeeID);

    }
    
    private void loadEmployeeInformation(int employeeID) {
        EmployeeDatabase db = new EmployeeDatabase("employees.csv", "credentials.csv");
        User user = db.getEmployeeByID(employeeID);  // Get the employee by ID

        if (user != null) {
            // Check if the employee is HR, if so, create an HR object
            if ("HR".equalsIgnoreCase(user.getPosition())) {
                // Create HR object based on the employee data
                user = new HR(user.getEmployeeID(), user.getFirstName(), user.getSurname(),
                                  user.getBirthday(), user.getAddress(), user.getSssNumber(),
                                  user.getPhilHealthNumber(), user.getTinNumber(), user.getPosition(),
                                  user.getBasicSalary(), user.getAllowance()); 
                
                jMenuViewSalary.setVisible(true);  // Make sure "View Salary" is visible for HR
                jMenuItemManageEmployeeRecords.setVisible(true);  
            }
            else {
                // Disable or hide HR-specific menu items
                jMenuViewSalary.setVisible(true);  // Allow "View Salary" for non-HR employees
                jMenuItemManageEmployeeRecords.setVisible(false);  // Hide "Manage Employee Records" for non-HR
        }

            // Populate UI components with user information
            jLabelWelcome.setText(jLabelWelcome.getText() + user.getFirstName());
            jTextFieldFirstName.setText(user.getFirstName());
            jTextFieldSurname.setText(user.getSurname());
            jTextFieldBirthday.setText(user.getBirthday() != null ? user.getBirthday().toString() : "N/A");
            jTextFieldPosition.setText(user.getPosition());
            jTextAreaAddress.setText(user.getAddress());
            jTextFieldSSS.setText(user.getSssNumber());
            jTextFieldPhilhealth.setText(user.getPhilHealthNumber());
            jTextFieldTIN.setText(user.getTinNumber());
        } else {
            JOptionPane.showMessageDialog(this, "Employee not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTop = new javax.swing.JPanel();
        jLabelWelcome = new javax.swing.JLabel();
        jPanelBottom = new javax.swing.JPanel();
        jLabelFirstName = new javax.swing.JLabel();
        jLabelSurname = new javax.swing.JLabel();
        jLabelBirthday = new javax.swing.JLabel();
        jLabelAddress = new javax.swing.JLabel();
        jLabelPosition = new javax.swing.JLabel();
        jTextFieldFirstName = new javax.swing.JTextField();
        jTextFieldSurname = new javax.swing.JTextField();
        jTextFieldBirthday = new javax.swing.JTextField();
        jTextFieldPosition = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaAddress = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabelSSS = new javax.swing.JLabel();
        jLabelPhilhealth = new javax.swing.JLabel();
        jLabelTinNumber = new javax.swing.JLabel();
        jTextFieldSSS = new javax.swing.JTextField();
        jTextFieldPhilhealth = new javax.swing.JTextField();
        jTextFieldTIN = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuInformation = new javax.swing.JMenu();
        jMenuViewSalary = new javax.swing.JMenuItem();
        jMenuItemManageEmployeeRecords = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelTop.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelWelcome.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabelWelcome.setText("Welcome, ");

        javax.swing.GroupLayout jPanelTopLayout = new javax.swing.GroupLayout(jPanelTop);
        jPanelTop.setLayout(jPanelTopLayout);
        jPanelTopLayout.setHorizontalGroup(
            jPanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTopLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabelWelcome)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTopLayout.setVerticalGroup(
            jPanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTopLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabelWelcome)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jPanelBottom.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBottom.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Employee Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

        jLabelFirstName.setText("First Name:");

        jLabelSurname.setText("Surname:");

        jLabelBirthday.setText("Birthday:");

        jLabelAddress.setText("Address:");

        jLabelPosition.setText("Position:");

        jTextFieldFirstName.setEditable(false);

        jTextFieldSurname.setEditable(false);

        jTextFieldBirthday.setEditable(false);

        jTextFieldPosition.setEditable(false);

        jTextAreaAddress.setEditable(false);
        jTextAreaAddress.setColumns(20);
        jTextAreaAddress.setRows(5);
        jScrollPane1.setViewportView(jTextAreaAddress);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelSSS.setText("SSS Number:");

        jLabelPhilhealth.setText("Philhealth Number:");

        jLabelTinNumber.setText("TIN Number:");

        jTextFieldSSS.setEditable(false);

        jTextFieldPhilhealth.setEditable(false);

        jTextFieldTIN.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPhilhealth)
                    .addComponent(jLabelSSS, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelTinNumber, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldSSS, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPhilhealth, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTIN, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(363, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSSS)
                    .addComponent(jTextFieldSSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPhilhealth)
                    .addComponent(jTextFieldPhilhealth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTinNumber)
                    .addComponent(jTextFieldTIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelBottomLayout = new javax.swing.GroupLayout(jPanelBottom);
        jPanelBottom.setLayout(jPanelBottomLayout);
        jPanelBottomLayout.setHorizontalGroup(
            jPanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBottomLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelBottomLayout.createSequentialGroup()
                        .addGroup(jPanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelBirthday)
                            .addComponent(jLabelFirstName)
                            .addComponent(jLabelSurname))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldFirstName)
                            .addComponent(jTextFieldSurname)
                            .addComponent(jTextFieldBirthday, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
                        .addGap(43, 43, 43)
                        .addGroup(jPanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelPosition)
                            .addComponent(jLabelAddress))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1)))
                    .addGroup(jPanelBottomLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanelBottomLayout.setVerticalGroup(
            jPanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBottomLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFirstName)
                    .addComponent(jTextFieldFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPosition)
                    .addComponent(jTextFieldPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBottomLayout.createSequentialGroup()
                        .addGroup(jPanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelBottomLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelSurname)
                                    .addComponent(jTextFieldSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanelBottomLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabelAddress)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelBirthday)
                            .addComponent(jTextFieldBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBottomLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jMenuInformation.setText("File");

        jMenuViewSalary.setText("View Salary");
        jMenuViewSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuViewSalaryActionPerformed(evt);
            }
        });
        jMenuInformation.add(jMenuViewSalary);

        jMenuItemManageEmployeeRecords.setText("Manage Employee Records");
        jMenuItemManageEmployeeRecords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemManageEmployeeRecordsActionPerformed(evt);
            }
        });
        jMenuInformation.add(jMenuItemManageEmployeeRecords);

        jMenuBar1.add(jMenuInformation);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelBottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanelTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelBottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuViewSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuViewSalaryActionPerformed
        // TODO add your handling code here:
        ViewSalaryGUI viewSalaryGUI = new ViewSalaryGUI(employeeID);
        viewSalaryGUI.setVisible(true);
    }//GEN-LAST:event_jMenuViewSalaryActionPerformed

    private void jMenuItemManageEmployeeRecordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemManageEmployeeRecordsActionPerformed
        // TODO add your handling code here:
        ManageEmployeeGUI manageEmployeeGUI = new ManageEmployeeGUI(employeeID);
        manageEmployeeGUI.setVisible(true);
    }//GEN-LAST:event_jMenuItemManageEmployeeRecordsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmployeeInformationGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeInformationGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeInformationGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeInformationGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeInformationGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelAddress;
    private javax.swing.JLabel jLabelBirthday;
    private javax.swing.JLabel jLabelFirstName;
    private javax.swing.JLabel jLabelPhilhealth;
    private javax.swing.JLabel jLabelPosition;
    private javax.swing.JLabel jLabelSSS;
    private javax.swing.JLabel jLabelSurname;
    private javax.swing.JLabel jLabelTinNumber;
    private javax.swing.JLabel jLabelWelcome;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuInformation;
    private javax.swing.JMenuItem jMenuItemManageEmployeeRecords;
    private javax.swing.JMenuItem jMenuViewSalary;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelBottom;
    private javax.swing.JPanel jPanelTop;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaAddress;
    private javax.swing.JTextField jTextFieldBirthday;
    private javax.swing.JTextField jTextFieldFirstName;
    private javax.swing.JTextField jTextFieldPhilhealth;
    private javax.swing.JTextField jTextFieldPosition;
    private javax.swing.JTextField jTextFieldSSS;
    private javax.swing.JTextField jTextFieldSurname;
    private javax.swing.JTextField jTextFieldTIN;
    // End of variables declaration//GEN-END:variables
}
