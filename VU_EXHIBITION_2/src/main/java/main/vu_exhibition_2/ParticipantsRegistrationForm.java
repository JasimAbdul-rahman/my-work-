package main.vu_exhibition_2;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class ParticipantsRegistrationForm extends javax.swing.JFrame {
private static final String DB_URL = "jdbc:ucanaccess://C:/Users/HP/Desktop/VUE_Exhibition.accdb";
 private String selectedImagePath = null;
    
    public ParticipantsRegistrationForm() {
                setTitle("Participant Registration - VU Innovation Exhibition");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        initComponents();
        
       DocumentListener autoSaveListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                autoSaveParticipant(); // Call your auto-save method
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                autoSaveParticipant(); // Call your auto-save method
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                // This event is typically not fired by plain text components
            }
        };
     txtStudentName.getDocument().addDocumentListener(autoSaveListener);
        txtFaculty.getDocument().addDocumentListener(autoSaveListener);
        txtProjectTitle.getDocument().addDocumentListener(autoSaveListener);
        txtContactNumber.getDocument().addDocumentListener(autoSaveListener);
        txtEmailAddress.getDocument().addDocumentListener(autoSaveListener);
        
    }
 private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnRegister = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        lblImage = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        RegistrationID = new javax.swing.JLabel();
        txtRegistrationID = new javax.swing.JTextField();
        StudentName = new javax.swing.JLabel();
        txtStudentName = new javax.swing.JTextField();
        Faculty = new javax.swing.JLabel();
        txtFaculty = new javax.swing.JTextField();
        ProjectTitle = new javax.swing.JLabel();
        txtProjectTitle = new javax.swing.JTextField();
        ContactNumber = new javax.swing.JLabel();
        txtContactNumber = new javax.swing.JTextField();
        EmailAddress = new javax.swing.JLabel();
        txtEmailAddress = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        blImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Participants", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("VU REGISTRA");

        btnRegister.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        btnSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        lblImage.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblImage.setText("Upload Image");
        lblImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblImageActionPerformed(evt);
            }
        });

        btnExit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        RegistrationID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RegistrationID.setText("RegistrationID");

        txtRegistrationID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        StudentName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        StudentName.setText("Student Name");

        Faculty.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Faculty.setText("Faculty");

        txtFaculty.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        ProjectTitle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ProjectTitle.setText("Project Title");

        txtProjectTitle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        ContactNumber.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ContactNumber.setText("Contact Number");

        txtContactNumber.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        EmailAddress.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        EmailAddress.setText("Email Address");

        txtEmailAddress.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Project Image");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnRegister)
                        .addGap(32, 32, 32)
                        .addComponent(btnSearch)
                        .addGap(43, 43, 43)
                        .addComponent(btnUpdate)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtProjectTitle)
                            .addComponent(ProjectTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFaculty, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Faculty, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtStudentName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RegistrationID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(StudentName, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                            .addComponent(txtRegistrationID))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(btnDelete)
                                        .addGap(39, 39, 39)
                                        .addComponent(btnClear)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnExit))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(ContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(EmailAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtEmailAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(blImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(140, 140, 140))))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RegistrationID)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addComponent(txtRegistrationID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(blImage, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImage)
                    .addComponent(StudentName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtStudentName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ContactNumber))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Faculty)
                    .addComponent(txtContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFaculty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EmailAddress))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ProjectTitle)
                    .addComponent(txtEmailAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txtProjectTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegister)
                    .addComponent(btnSearch)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnClear)
                    .addComponent(btnExit))
                .addGap(26, 26, 26))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(30, 20, 730, 510);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
         if (!validateInputs(false)) {
            JOptionPane.showMessageDialog(this, "Please fill all fields correctly before registering.");
            return;
        }

        // Prevent duplicates by email
        if (participantExists(txtEmailAddress.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Participant with this email  registered successfully.");
            return;
        }

        String sql = "INSERT INTO Participants (StudentName, Faculty, ProjectTitle, ContactNumber, EmailAddress, ImagePath) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, txtStudentName.getText().trim());
            pst.setString(2, txtFaculty.getText().trim());
            pst.setString(3, txtProjectTitle.getText().trim());
            pst.setString(4, txtContactNumber.getText().trim());
            pst.setString(5, txtEmailAddress.getText().trim());
            pst.setString(6, selectedImagePath);
            int affected = pst.executeUpdate();
            if (affected > 0) {
                JOptionPane.showMessageDialog(this, "Participant registered successfully!");
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error registering participant: " + e.getMessage());
        }
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String regIdStr = txtRegistrationID.getText().trim();
        if (regIdStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Registration ID to search.");
            return;
        }
        int regID;
        try {
            regID = Integer.parseInt(regIdStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Registration ID must be a number.");
            return;
        }

        String sql = "SELECT * FROM Participants WHERE RegistrationID = ?";
        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, regID);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                txtStudentName.setText(rs.getString("StudentName"));
                txtFaculty.setText(rs.getString("Faculty"));
                txtProjectTitle.setText(rs.getString("ProjectTitle"));
                txtContactNumber.setText(rs.getString("ContactNumber"));
                txtEmailAddress.setText(rs.getString("EmailAddress"));
                selectedImagePath = rs.getString("ImagePath");

                if (selectedImagePath != null && !selectedImagePath.isEmpty()) {
                    ImageIcon icon = new ImageIcon(selectedImagePath);
                    Image img = icon.getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
                    lblImage.setIcon(new ImageIcon(img));
                } else {
                    lblImage.setIcon(null);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Participant not found.");
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error searching participant: " + e.getMessage());
        }
    }//GEN-LAST:event_btnSearchActionPerformed

     private boolean validateInputs(boolean checkRegID) {
        String name = txtStudentName.getText().trim();
        String faculty = txtFaculty.getText().trim();
        String project = txtProjectTitle.getText().trim();
        String contact = txtContactNumber.getText().trim();
        String email = txtEmailAddress.getText().trim();

        if (checkRegID && txtRegistrationID.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Registration ID.");
            return false;
        }
        if (name.isEmpty() || faculty.isEmpty() || project.isEmpty() || contact.isEmpty() || email.isEmpty()) {
            return false;  // for auto-save, no dialog on empty fields
        }
        if (!contact.matches("\\d{7,15}")) {
            return false;
        }
        if (!Pattern.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", email)) {
            return false;
        }
        return selectedImagePath != null;
    }
    
    
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
       
        if (!validateInputs(true)) {
            JOptionPane.showMessageDialog(this, "Please fill all fields correctly before updating.");
            return;
        }

        int regID;
        try {
            regID = Integer.parseInt(txtRegistrationID.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Registration ID must be a number.");
            return;
        }

        String sql = "UPDATE Participants SET StudentName=?, Faculty=?, ProjectTitle=?, ContactNumber=?, EmailAddress=?, ImagePath=? WHERE RegistrationID=?";
        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, txtStudentName.getText().trim());
            pst.setString(2, txtFaculty.getText().trim());
            pst.setString(3, txtProjectTitle.getText().trim());
            pst.setString(4, txtContactNumber.getText().trim());
            pst.setString(5, txtEmailAddress.getText().trim());
            pst.setString(6, selectedImagePath);
            pst.setInt(7, regID);
            int affected = pst.executeUpdate();
            if (affected > 0) {
                JOptionPane.showMessageDialog(this, "Participant updated successfully!");
                
            } else {
                JOptionPane.showMessageDialog(this, "No participant found with this Registration ID.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error updating participant: " + e.getMessage());
       
   
   
        }    
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String regIdStr = txtRegistrationID.getText().trim();
        if (regIdStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Registration ID to delete.");
            return;
        }
        int regID;
        try {
            regID = Integer.parseInt(regIdStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Registration ID must be a number.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete participant with ID " + regID + "?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) return;

        String sql = "DELETE FROM Participants WHERE RegistrationID = ?";
        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, regID);
            int affected = pst.executeUpdate();
            if (affected > 0) {
                JOptionPane.showMessageDialog(this, "Participant deleted successfully.");
                
            } else {
                JOptionPane.showMessageDialog(this, "No participant found with this Registration ID.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error deleting participant: " + e.getMessage());
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtRegistrationID.setText("");
        txtStudentName.setText("");
        txtFaculty.setText("");
        txtProjectTitle.setText("");
        txtContactNumber.setText("");
        txtEmailAddress.setText("");
        selectedImagePath = null;
        lblImage.setIcon(null);
        
        

        
        
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
     int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
    if (choice == JOptionPane.YES_OPTION) {
        System.exit(0);
    }
    }//GEN-LAST:event_btnExitActionPerformed

    private void lblImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblImageActionPerformed
        
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            String path = file.getAbsolutePath();
           
            
            if (path.toLowerCase().endsWith(".jpg") || path.toLowerCase().endsWith(".png") || path.toLowerCase().endsWith(".jpeg")) {
                selectedImagePath = path;
                ImageIcon icon = new ImageIcon(path);
                Image img = icon.getImage().getScaledInstance(blImage.getWidth(), blImage.getHeight(), Image.SCALE_SMOOTH);
                blImage.setIcon(new ImageIcon(img));
            } else {
                JOptionPane.showMessageDialog(this, "Please select an image file (JPG, JPEG, PNG).");
            }
        }
        
    }//GEN-LAST:event_lblImageActionPerformed

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ParticipantsRegistrationForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ContactNumber;
    private javax.swing.JLabel EmailAddress;
    private javax.swing.JLabel Faculty;
    private javax.swing.JLabel ProjectTitle;
    private javax.swing.JLabel RegistrationID;
    private javax.swing.JLabel StudentName;
    private javax.swing.JLabel blImage;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton lblImage;
    private javax.swing.JTextField txtContactNumber;
    private javax.swing.JTextField txtEmailAddress;
    private javax.swing.JTextField txtFaculty;
    private javax.swing.JTextField txtProjectTitle;
    private javax.swing.JTextField txtRegistrationID;
    private javax.swing.JTextField txtStudentName;
    // End of variables declaration//GEN-END:variables

 private boolean participantExists(String email) {
        String sql = "SELECT COUNT(*) FROM Participants WHERE EmailAddress = ?";
        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.err.println("Error checking participant existence: " + e.getMessage());
        }
        return false;
    }    
      
    
    private void autoSaveParticipant() {
        if (!validateInputs(false)) return;

        // Prevent duplicates by email
        if (participantExists(txtEmailAddress.getText().trim())) {
            System.out.println("Auto-save skipped: participant already exists.");
            return;
        }

        String sql = "INSERT INTO Participants (StudentName, Faculty, ProjectTitle, ContactNumber, EmailAddress, ImagePath) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, txtStudentName.getText().trim());
            pst.setString(2, txtFaculty.getText().trim());
            pst.setString(3, txtProjectTitle.getText().trim());
            pst.setString(4, txtContactNumber.getText().trim());
            pst.setString(5, txtEmailAddress.getText().trim());
            pst.setString(6, selectedImagePath);

            pst.executeUpdate();
            System.out.println("Auto-saved participant.");

        } catch (SQLException e) {
            System.err.println("Auto-save failed: " + e.getMessage());
        }       }        }        

 

