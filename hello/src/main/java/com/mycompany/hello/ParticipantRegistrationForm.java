package com.mycompany.hello;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.io.File;
import java.sql.*;
import java.util.regex.Pattern;

public class ParticipantRegistrationForm extends JFrame {

    // DB connection string - update path to your Access file
    private static final String DB_URL = "jdbc:ucanaccess:\"C:\\Users\\HP\\Desktop\\VUE_Exhibition.accdb\"";
    // GUI components
    private final JTextField txtRegID;
    private final JTextField txtStudentName;
    private final JTextField txtFaculty;
    private final JTextField txtProjectTitle;
    private final JTextField txtContactNumber;
    private final JTextField txtEmailAddress;
    private final JLabel lblImageDisplay;
    private String selectedImagePath = null;

    public ParticipantRegistrationForm() {
        setTitle("Participant Registration - VU Innovation Exhibition");
        setSize(600, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Labels and TextFields
        add(new JLabel("Registration ID (Search/Update/Delete):")).setBounds(20, 10, 220, 25);
        txtRegID = new JTextField();
        txtRegID.setBounds(250, 10, 100, 25);
        add(txtRegID);

        add(new JLabel("Student Name:")).setBounds(20, 50, 120, 25);
        txtStudentName = new JTextField();
        txtStudentName.setBounds(150, 50, 300, 25);
        add(txtStudentName);

        add(new JLabel("Faculty:")).setBounds(20, 90, 120, 25);
        txtFaculty = new JTextField();
        txtFaculty.setBounds(150, 90, 300, 25);
        add(txtFaculty);

        add(new JLabel("Project Title:")).setBounds(20, 130, 120, 25);
        txtProjectTitle = new JTextField();
        txtProjectTitle.setBounds(150, 130, 300, 25);
        add(txtProjectTitle);

        add(new JLabel("Contact Number:")).setBounds(20, 170, 120, 25);
        txtContactNumber = new JTextField();
        txtContactNumber.setBounds(150, 170, 300, 25);
        add(txtContactNumber);

        add(new JLabel("Email Address:")).setBounds(20, 210, 120, 25);
        txtEmailAddress = new JTextField();
        txtEmailAddress.setBounds(150, 210, 300, 25);
        add(txtEmailAddress);

        // Image label and display
        add(new JLabel("Project Image:")).setBounds(20, 250, 120, 25);
        lblImageDisplay = new JLabel();
        lblImageDisplay.setBounds(150, 250, 150, 150);
        lblImageDisplay.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(lblImageDisplay);

        // Buttons
        JButton btnUploadImage = new JButton("Upload Image");
        btnUploadImage.setBounds(320, 250, 130, 25);
        add(btnUploadImage);

        JButton btnRegister = new JButton("Register");
        btnRegister.setBounds(20, 420, 100, 30);
        add(btnRegister);

        JButton btnSearch = new JButton("Search");
        btnSearch.setBounds(130, 420, 100, 30);
        add(btnSearch);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBounds(240, 420, 100, 30);
        add(btnUpdate);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setBounds(350, 420, 100, 30);
        add(btnDelete);

        JButton btnClear = new JButton("Clear");
        btnClear.setBounds(460, 420, 100, 30);
        add(btnClear);

        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(240, 460, 100, 30);
        add(btnExit);

        // Button actions
        btnUploadImage.addActionListener(e -> {
            uploadImage();
            autoSaveParticipant(); // Auto-save after image upload
        });
        btnRegister.addActionListener(e -> registerParticipant());
        btnSearch.addActionListener(e -> searchParticipant());
        btnUpdate.addActionListener(e -> updateParticipant());
        btnDelete.addActionListener(e -> deleteParticipant());
        btnClear.addActionListener(e -> clearFields());
        btnExit.addActionListener(e -> System.exit(0));

        // Auto-save on text changes
        DocumentListener autoSaveListener = new DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) { autoSaveParticipant(); }
            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) { autoSaveParticipant(); }
            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) { autoSaveParticipant(); }
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

    // Upload image and display in label
    private void uploadImage() {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            String path = file.getAbsolutePath();
            if (path.toLowerCase().endsWith(".jpg") || path.toLowerCase().endsWith(".png") || path.toLowerCase().endsWith(".jpeg")) {
                selectedImagePath = path;
                ImageIcon icon = new ImageIcon(path);
                Image img = icon.getImage().getScaledInstance(lblImageDisplay.getWidth(), lblImageDisplay.getHeight(), Image.SCALE_SMOOTH);
                lblImageDisplay.setIcon(new ImageIcon(img));
            } else {
                JOptionPane.showMessageDialog(this, "Please select an image file (JPG, JPEG, PNG).");
            }
        }
    }

    // Validate inputs before insert/update
    private boolean validateInputs(boolean checkRegID) {
        String name = txtStudentName.getText().trim();
        String faculty = txtFaculty.getText().trim();
        String project = txtProjectTitle.getText().trim();
        String contact = txtContactNumber.getText().trim();
        String email = txtEmailAddress.getText().trim();

        if (checkRegID && txtRegID.getText().trim().isEmpty()) {
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
        if (selectedImagePath == null) {
            return false;
        }
        return true;
    }

    // Check if participant exists by EmailAddress to avoid duplicates
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

    // Auto-save participant (insert only) - no dialog, no clearing fields
    private void autoSaveParticipant() {
        if (!validateInputs(false)) return;

        // Prevent duplicates by email
        if (participantExists(txtEmailAddress.getText().trim())) {
            System.out.println("Auto-save skipped: participant already exists.");
            return;
        }

        String sql = "INSERT INTO Participants (StudentName, Faculty, ProjectTittle, ContactNumber, EmailAddress, ImagePath) VALUES (?, ?, ?, ?, ?, ?)";

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
        }
    }

    // Register participant - INSERT with dialog and clear
    private void registerParticipant() {
        if (!validateInputs(false)) {
            JOptionPane.showMessageDialog(this, "Please fill all fields correctly before registering.");
            return;
        }

        // Prevent duplicates by email
        if (participantExists(txtEmailAddress.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Participant with this email already registered.");
            return;
        }

        String sql = "INSERT INTO Participants (StudentName, Faculty, ProjectTittle, ContactNumber, EmailAddress, ImagePath) VALUES (?, ?, ?, ?, ?, ?)";
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
                clearFields();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error registering participant: " + e.getMessage());
        }
    }

    // Search participant by RegistrationID - SELECT
    private void searchParticipant() {
        String regIdStr = txtRegID.getText().trim();
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
                txtProjectTitle.setText(rs.getString("ProjectTittle"));
                txtContactNumber.setText(rs.getString("ContactNumber"));
                txtEmailAddress.setText(rs.getString("EmailAddress"));
                selectedImagePath = rs.getString("ImagePath");

                if (selectedImagePath != null && !selectedImagePath.isEmpty()) {
                    ImageIcon icon = new ImageIcon(selectedImagePath);
                    Image img = icon.getImage().getScaledInstance(lblImageDisplay.getWidth(), lblImageDisplay.getHeight(), Image.SCALE_SMOOTH);
                    lblImageDisplay.setIcon(new ImageIcon(img));
                } else {
                    lblImageDisplay.setIcon(null);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Participant not found.");
                clearFields();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error searching participant: " + e.getMessage());
        }
    }

    // Update participant - UPDATE
    private void updateParticipant() {
        if (!validateInputs(true)) {
            JOptionPane.showMessageDialog(this, "Please fill all fields correctly before updating.");
            return;
        }

        int regID;
        try {
            regID = Integer.parseInt(txtRegID.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Registration ID must be a number.");
            return;
        }

        String sql = "UPDATE Participants SET StudentName=?, Faculty=?, ProjectTittle=?, ContactNumber=?, EmailAddress=?, ImagePath=? WHERE RegistrationID=?";
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
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "No participant found with this Registration ID.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error updating participant: " + e.getMessage());
        }
    }

    // Delete participant - DELETE
    private void deleteParticipant() {
        String regIdStr = txtRegID.getText().trim();
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
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "No participant found with this Registration ID.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error deleting participant: " + e.getMessage());
        }
    }

    // Clear all fields and image display
    private void clearFields() {
        txtRegID.setText("");
        txtStudentName.setText("");
        txtFaculty.setText("");
        txtProjectTitle.setText("");
        txtContactNumber.setText("");
        txtEmailAddress.setText("");
        selectedImagePath = null;
        lblImageDisplay.setIcon(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ParticipantRegistrationForm().setVisible(true);
        });
    }
}
