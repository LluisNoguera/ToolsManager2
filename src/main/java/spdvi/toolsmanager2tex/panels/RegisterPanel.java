/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spdvi.toolsmanager2tex.panels;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import spdvi.toolsmanager2tex.data.DataAccess;
import spdvi.toolsmanager2tex.models.Usuari;
import spdvi.toolsmanager2tex.utils.Constants;
import spdvi.toolsmanager2tex.utils.Utils;

/**
 *
 * @author lluis
 */
public class RegisterPanel extends javax.swing.JPanel {
    static boolean UserExists = false;
    DataAccess da = new DataAccess();
    
    
    /**
     * Creates new form RegisterPanel
     */
    public RegisterPanel() {
        initComponents();
        
    }

    static String Users = Constants.UsersPath;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblName = new javax.swing.JLabel();
        lblSurname = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtSurname = new javax.swing.JTextField();
        txtUserName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btnRegister = new javax.swing.JButton();
        pwsPassword = new javax.swing.JPasswordField();
        chbShow = new javax.swing.JCheckBox();

        lblName.setText("Name:");

        lblSurname.setText("Surname:");

        lblUserName.setText("UserName:");

        lblEmail.setText("Email:");

        lblPassword.setText("Password:");

        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        pwsPassword.setText("jPasswordField1");
        pwsPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwsPasswordActionPerformed(evt);
            }
        });

        chbShow.setText("Show");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(btnRegister))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSurname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblUserName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtName)
                            .addComponent(txtSurname)
                            .addComponent(txtUserName)
                            .addComponent(txtEmail)
                            .addComponent(pwsPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chbShow)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUserName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEmail)
                .addGap(4, 4, 4)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pwsPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chbShow))
                .addGap(12, 12, 12)
                .addComponent(btnRegister)
                .addContainerGap(11, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        try
        {
            Usuari user = new Usuari();
            int id = Usuari.createNewID();
            user.setId(id);
            user.setNom(txtName.getText());
            user.setLlinatge(txtSurname.getText());
            user.setUsername(txtUserName.getText());
            user.setEmail(txtEmail.getText());
            user.setPassword(pwsPassword.getText());
            user.setFoto("http://dummyimage.com/329x305.png/5fa2dd/ffffff");
            
            if(checkUserExists(txtUserName.getText(),txtEmail.getText())){
                Utils.errorMessage("Cant create, User already exists.");
            }else{
                da.setUsuari(user);    
            }
        } catch (SQLException ex)            
        {
            Logger.getLogger(RegisterPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void pwsPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwsPasswordActionPerformed
        boolean show = false;
        if(chbShow.isSelected() == true){
            show = true;
        }else{
            show = false;
        }
        Utils.showHidePassword(pwsPassword, show);
    }//GEN-LAST:event_pwsPasswordActionPerformed

    private static boolean checkUserExists(String name, String email){
        DataAccess da = new DataAccess();
        
        try
        {
            ArrayList<Usuari> users = new ArrayList<>();
            users = da.getUsuaris();
            String namec;
            String emailc;
            for(Usuari user : users){
                System.out.println("u: "+user);
                namec = user.getUsername().trim();
                System.out.println(user.getUsername().trim());
                System.out.println("namec: "+ namec);
                emailc = user.getEmail();
                if(namec.contains(name) || emailc.contains(name)){
                    UserExists = true;
                    return UserExists;
                }
            }
            System.out.println("UserExists: "+ UserExists);
            
        } catch (SQLException ex)
        {
            Logger.getLogger(RegisterPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(UserExists);
        return UserExists;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegister;
    private javax.swing.JCheckBox chbShow;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblSurname;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JPasswordField pwsPassword;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSurname;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}