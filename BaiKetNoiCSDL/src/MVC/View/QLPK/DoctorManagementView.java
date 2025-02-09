package MVC.View.QLPK;

import javax.swing.*;
import java.awt.*;

public class DoctorManagementView extends JFrame {
    public JComboBox<String> doctorIDBox;
    public JTextField doctorIDField;
    public JTextField passwordField;
    public JTextField nameField;
    public JTextField dobField;
    public JTextField phoneField;
    public JTextField emailField;
    public JTextField positionField;
    public JTextField salaryField;
    public JTextField permissionIDField;
    public JButton searchButton;
    public JButton addButton;
    public JButton updateButton;
    public JButton deleteButton;
    public JButton returnButton; // Added return button

    public DoctorManagementView() {
        setTitle("Doctor Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main Panel with GridBagLayout
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Doctor ID ComboBox
        JLabel doctorIDBoxLabel = new JLabel("Doctor ID:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(doctorIDBoxLabel, gbc);

        doctorIDBox = new JComboBox<>();
        doctorIDBox.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        mainPanel.add(doctorIDBox, gbc);

        // Doctor ID field
        JLabel doctorIDLabel = new JLabel("Doctor ID:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(doctorIDLabel, gbc);

        doctorIDField = new JTextField();
        doctorIDField.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        mainPanel.add(doctorIDField, gbc);

        // Password field
        JLabel passwordLabel = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(passwordLabel, gbc);

        passwordField = new JTextField();
        passwordField.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        mainPanel.add(passwordField, gbc);

        // Name field
        JLabel nameLabel = new JLabel("Name:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(nameLabel, gbc);

        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        mainPanel.add(nameField, gbc);

        // Date of Birth field
        JLabel dobLabel = new JLabel("Date of Birth:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        mainPanel.add(dobLabel, gbc);

        dobField = new JTextField();
        dobField.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        mainPanel.add(dobField, gbc);

        // Phone field
        JLabel phoneLabel = new JLabel("Phone:");
        gbc.gridx = 0;
        gbc.gridy = 5;
        mainPanel.add(phoneLabel, gbc);

        phoneField = new JTextField();
        phoneField.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        mainPanel.add(phoneField, gbc);

        // Email field
        JLabel emailLabel = new JLabel("Email:");
        gbc.gridx = 0;
        gbc.gridy = 6;
        mainPanel.add(emailLabel, gbc);

        emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        mainPanel.add(emailField, gbc);

        // Position field
        JLabel positionLabel = new JLabel("Position:");
        gbc.gridx = 0;
        gbc.gridy = 7;
        mainPanel.add(positionLabel, gbc);

        positionField = new JTextField();
        positionField.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        mainPanel.add(positionField, gbc);

        // Salary field
        JLabel salaryLabel = new JLabel("Salary:");
        gbc.gridx = 0;
        gbc.gridy = 8;
        mainPanel.add(salaryLabel, gbc);

        salaryField = new JTextField();
        salaryField.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        mainPanel.add(salaryField, gbc);

        // Permission ID field
        JLabel permissionIDLabel = new JLabel("Permission ID:");
        gbc.gridx = 0;
        gbc.gridy = 9;
        mainPanel.add(permissionIDLabel, gbc);

        permissionIDField = new JTextField();
        permissionIDField.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        mainPanel.add(permissionIDField, gbc);

        // Buttons Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        searchButton = new JButton("Search");
        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        returnButton = new JButton("Return"); // Added Return button

        buttonPanel.add(searchButton);
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(returnButton); // Add the return button to the panel

        // Add components to the frame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        pack(); // Adjust frame size to fit components
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }

    public static void main(String[] args) {
        new DoctorManagementView();
    }
}