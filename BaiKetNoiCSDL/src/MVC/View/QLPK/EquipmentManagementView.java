package MVC.View.QLPK;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class EquipmentManagementView extends JFrame {
    public JComboBox<String> equipmentTypeBox; // Box hiển thị tên vật tư không trùng
    public JTextField equipmentIDField;
    public JTextField equipmentNameField;
    public JTextField priceField;
    public JTextField equipmentStatusField;
    public JTextField stockInDateField;
    public JTextField supplierField;
    public JTextField dateOfExpireField;
    public JButton addButton;
    public JButton updateButton;
    public JButton deleteButton;
    public JButton searchButton;
    public JButton returnButton;

    public EquipmentManagementView() {
        setTitle("Equipment Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main Panel with GridBagLayout
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Equipment Type Box (Dropdown for unique names)
        JLabel equipmentTypeLabel = new JLabel("Equipment Type:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(equipmentTypeLabel, gbc);

        equipmentTypeBox = new JComboBox<>();
        equipmentTypeBox.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 1;
        gbc.gridy = 0;
        mainPanel.add(equipmentTypeBox, gbc);

        // Equipment ID field
        JLabel equipmentIDLabel = new JLabel("Equipment ID:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(equipmentIDLabel, gbc);

        equipmentIDField = new JTextField();
        equipmentIDField.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 1;
        gbc.gridy = 1;
        mainPanel.add(equipmentIDField, gbc);

        // Equipment Name field
        JLabel equipmentNameLabel = new JLabel("Equipment Name:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(equipmentNameLabel, gbc);

        equipmentNameField = new JTextField();
        equipmentNameField.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 1;
        gbc.gridy = 2;
        mainPanel.add(equipmentNameField, gbc);

        // Price field
        JLabel priceLabel = new JLabel("Price:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(priceLabel, gbc);

        priceField = new JTextField();
        priceField.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 1;
        gbc.gridy = 3;
        mainPanel.add(priceField, gbc);

        // Equipment Status field
        JLabel equipmentStatusLabel = new JLabel("Equipment Status:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        mainPanel.add(equipmentStatusLabel, gbc);

        equipmentStatusField = new JTextField();
        equipmentStatusField.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 1;
        gbc.gridy = 4;
        mainPanel.add(equipmentStatusField, gbc);

        // Date of Expire field
        JLabel dateOfExpireLabel = new JLabel("Date of Expire:");
        gbc.gridx = 0;
        gbc.gridy = 5;
        mainPanel.add(dateOfExpireLabel, gbc);

        dateOfExpireField = new JTextField();
        dateOfExpireField.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 1;
        gbc.gridy = 5;
        mainPanel.add(dateOfExpireField, gbc);

        // Stock-in Date field
        JLabel stockInDateLabel = new JLabel("Stock-in Date:");
        gbc.gridx = 0;
        gbc.gridy = 6;
        mainPanel.add(stockInDateLabel, gbc);

        stockInDateField = new JTextField();
        stockInDateField.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 1;
        gbc.gridy = 6;
        mainPanel.add(stockInDateField, gbc);

        // Supplier field
        JLabel supplierLabel = new JLabel("Supplier:");
        gbc.gridx = 0;
        gbc.gridy = 7;
        mainPanel.add(supplierLabel, gbc);

        supplierField = new JTextField();
        supplierField.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 1;
        gbc.gridy = 7;
        mainPanel.add(supplierField, gbc);

        // Buttons Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        searchButton = new JButton("Search");
        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        returnButton = new JButton("Return");

        buttonPanel.add(searchButton);
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(returnButton);

        // Add panels to the frame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        pack(); // Adjust frame size to fit components
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }

    // Methods to attach listeners to buttons
    public void addSearchButtonListener(ActionListener listener) {
        searchButton.addActionListener(listener);
    }

    public void addAddButtonListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }

    public void addUpdateButtonListener(ActionListener listener) {
        updateButton.addActionListener(listener);
    }

    public void addDeleteButtonListener(ActionListener listener) {
        deleteButton.addActionListener(listener);
    }

    public void addReturnButtonListener(ActionListener listener) {
        returnButton.addActionListener(listener);
    }

    // Method to populate the ComboBox with unique equipment names
    public void populateEquipmentTypeBox(List<String> equipmentNames) {
        equipmentTypeBox.removeAllItems();
        for (String name : equipmentNames) {
            equipmentTypeBox.addItem(name);
        }
    }
}
