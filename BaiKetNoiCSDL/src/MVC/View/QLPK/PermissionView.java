package MVC.View.QLPK;

import javax.swing.*;
import java.awt.*;

public class PermissionView extends JFrame {
    public JComboBox<String> permissionBox;
    public JTextField permissionIDField, permissionNameField, permissionUsageField;
    public JButton addButton, editButton, deleteButton, assignButton, returnButton;

    public PermissionView() {
        setTitle("Permission Management");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10)); // Use BorderLayout with padding

        // Main panel with GridBagLayout
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Add padding between components
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Initialize components
        permissionBox = new JComboBox<>();
        permissionIDField = new JTextField();
        permissionNameField = new JTextField();
        permissionUsageField = new JTextField();
        addButton = new JButton("Add");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");
        assignButton = new JButton("Assign");
        returnButton = new JButton("Return");

        // Add components to the panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(new JLabel("Permission:"), gbc);
        gbc.gridx = 1;
        mainPanel.add(permissionBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(new JLabel("Permission ID:"), gbc);
        gbc.gridx = 1;
        mainPanel.add(permissionIDField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(new JLabel("Permission Name:"), gbc);
        gbc.gridx = 1;
        mainPanel.add(permissionNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(new JLabel("Permission Usage:"), gbc);
        gbc.gridx = 1;
        mainPanel.add(permissionUsageField, gbc);

        // Panel for buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 5, 10, 0)); // Buttons in one row
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(assignButton);
        buttonPanel.add(returnButton);

        // Add panels to frame
        add(mainPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Center the frame on screen
        setLocationRelativeTo(null);
    }
}
