
import java.awt.Desktop;
import java.awt.Point;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1100167246
 */
public class Reports extends javax.swing.JFrame {

    /**
     * Creates new form Reports
     */
    String addon="";
    public Reports() {
        //initialize Reports
        setTitle("AHS FBLA Desktop Application - Reports");
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Employer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Score");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Employee");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton4.setText("Save");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Exit");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)
                        .addGap(0, 22, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //Convery displayed text into a text document, then open it
        String folder="EvaluationReports\\";
        Boolean uccess = (new File(folder)).mkdirs();
        File file = new File(folder+"Report" + addon + ".txt");
        FieldPlacement FP;
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(file));
            String[] data = jTextArea1.getText().split("\n");
            for(String str:data)    
            {
                bw.write(str);
                bw.newLine();
            }
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().edit(file);
            } catch (IOException ex) {
                Logger.getLogger(EmployeeReport.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            // dunno, up to you to handle this
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Display employees grouped by Employer
        FieldPlacement FP;
        String Report = "";
        addon="Employer";
        try {
            FP = new FieldPlacement();
            ArrayList<String[]> fields = FP.getFields();
            fields.remove(0);
            ArrayList<String> employers = new ArrayList();
            boolean employerExists = false;
            for(String[] strArray:fields)
            {
                String Employer = strArray[1];
                for(String str:employers) {
                    if(Employer.equals(str)) {
                        employerExists = true;
                    }
                }
                if(!employerExists)
                {
                    employers.add(Employer);
                }
                employerExists = false;
            }
            for(String employer:employers)
            {
                Employer Employr = new Employer(employer);
                Report += ("Employer: " + Employr.getData(1) + "\n\n");
                for(String[] str:fields) {
                    if (str[1].equals(employer)) {
                        Report += employeeReport(str[0]);
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTextArea1.setText(Report);
        jScrollPane1.getViewport().setViewPosition(new Point(0,0));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Display employees sorted by average score
        FieldPlacement FP;
        String Report = "";
        addon="Score";
        Evaluation Eval;
        try {
            FP = new FieldPlacement();
            ArrayList<String[]> fields = FP.getFields();
            fields.remove(0);
            ArrayList<String> employees = new ArrayList();
            boolean employeeExists = false;
            for(String[] strArray:fields)
            {
                String Employee = strArray[0];
                for(String str:employees) {
                    if(Employee.equals(str)) {
                        employeeExists = true;
                    }
                }
                if(!employeeExists)
                {
                    employees.add(Employee);
                }
                employeeExists = false;
            }
            for(double i=5; i>=0; i-=.25)
            {
                
                for(String str:employees)
                {
                    Eval = new Evaluation(str,1);
                    String DATA = Eval.getData(15);
                    if(DATA.length()==1)
                    {
                        DATA+=".0";
                    }
                    if((DATA).equals(""+i))
                    {
                        Report += employeeReport(str);
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
        }

        jTextArea1.setText(Report);
        jScrollPane1.getViewport().setViewPosition(new Point(0,0));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //display all employees
        FieldPlacement FP;
        String Report = "";
        addon="Employee";
        try {
            FP = new FieldPlacement();
            ArrayList<String[]> fields = FP.getFields();
            fields.remove(0);
            for(String[] str:fields) {
                Report += employeeReport(str[0]) + "\n";
            }
        } catch (IOException ex) {
            Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTextArea1.setText(Report);
        jScrollPane1.getViewport().setViewPosition(new Point(0,0));
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        //Exit window
        setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static String employeeReport(String employeeID) throws IOException
    {
        //Generate a string that makes up an individual employee's report
        String EmployeeReport="";
        Evaluation Eval = new Evaluation(employeeID, 1);
        Employee Emp = new Employee(employeeID);
        FieldPlacement FP = new FieldPlacement(employeeID,0);
        Employer Empr = new Employer(FP.getData(1));
            String[] DEFAULT = {"Employee ID Number: ", "Employee Name: ", "Employer: ", "Evaluation Data: ", "Next Evaluation: ", 
                                "Job Knowledge: ", "Quality of Work: ", "Work Habits: ", "Behavior/Relations: ",
                                "Overall: ", "Average Score: ", "Recommendation: "};
            String[] data = new String[12];
            data[0] = Eval.getData(1);
            data[1] = Emp.getData(1) + " " + Emp.getData(2);
            data[2] = Empr.getData(1);
            data[3] = Eval.getData(3);
            data[4] = Eval.getData(4);
            data[5] = Eval.getData(9);
            data[6] = Eval.getData(5);
            data[7] = Eval.getData(7);
            data[8] = Eval.getData(11);
            data[9] = Eval.getData(13);
            data[10] = Eval.getData(15);
            data[11] = Eval.getData(16);
            for (int i=0; i<data.length; i++)
            {
                EmployeeReport += (" " + DEFAULT[i] + data[i] + "\n");
            }
            EmployeeReport += ("\n");
            return EmployeeReport;
        }
    
    
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
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reports().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}