package MVC.Controller.QLPK;

import MVC.Model.QLPK.PermissionModel;
import MVC.View.QLPK.MainView;
import MVC.View.QLPK.PermissionView;

import javax.swing.*;
import java.sql.*;

public class PermissionController {
    private Connection connection;
    private PermissionView view;

    public PermissionController(PermissionView view) throws SQLException, ClassNotFoundException {
        this.view = view;

        // Initialize database connection
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyPhongKham;encrypt=true;trustServerCertificate=true";
        String username = "sa";
        String pass = "Phucthan@2004";
        connection = DriverManager.getConnection(url, username, pass);

        loadPermissions();

        view.addButton.addActionListener(e -> addPermission());
        view.editButton.addActionListener(e -> editPermission());
        view.deleteButton.addActionListener(e -> deletePermission());
        view.assignButton.addActionListener(e -> assignPermission());
        view.permissionBox.addActionListener(e -> loadPermissionDetails());
        view.returnButton.addActionListener(e -> {
            view.dispose(); // Close the Permission View
            MainView mainView = new MainView(); // Reopen the Main View
            new MainController(mainView);
        });
    }

    private void loadPermissions() {
        try (Statement stm = connection.createStatement()) {
            ResultSet resultSet = stm.executeQuery("SELECT maQuyen FROM Permission");
            view.permissionBox.removeAllItems();
            while (resultSet.next()) {
                view.permissionBox.addItem(resultSet.getString("maQuyen"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void loadPermissionDetails() {
        String selectedPermission = (String) view.permissionBox.getSelectedItem();
        if (selectedPermission != null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM Permission WHERE maQuyen = ?")) {
                preparedStatement.setString(1, selectedPermission);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    view.permissionIDField.setText(resultSet.getString("maQuyen"));
                    view.permissionNameField.setText(resultSet.getString("tenQuyen"));
                    view.permissionUsageField.setText(resultSet.getString("cacQuyenSuDung"));
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(view, "An error occurred while loading permission details.");
                ex.printStackTrace();
            }
        }
    }

    private void addPermission() {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO Permission (maQuyen, tenQuyen, cacQuyenSuDung) VALUES (?, ?, ?)")) {
            preparedStatement.setString(1, view.permissionIDField.getText());
            preparedStatement.setString(2, view.permissionNameField.getText());
            preparedStatement.setString(3, view.permissionUsageField.getText());
            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(view, "Permission added successfully.");
            loadPermissions();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "An error occurred while adding the permission.");
            ex.printStackTrace();
        }
    }

    private void editPermission() {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE Permission SET tenQuyen = ?, cacQuyenSuDung = ? WHERE maQuyen = ?")) {
            preparedStatement.setString(1, view.permissionNameField.getText());
            preparedStatement.setString(2, view.permissionUsageField.getText());
            preparedStatement.setString(3, (String) view.permissionBox.getSelectedItem());
            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(view, "Permission updated successfully.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "An error occurred while updating the permission.");
            ex.printStackTrace();
        }
    }

    private void deletePermission() {
        String selectedPermission = (String) view.permissionBox.getSelectedItem();
        if (selectedPermission != null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM Permission WHERE maQuyen = ?")) {
                preparedStatement.setString(1, selectedPermission);
                preparedStatement.executeUpdate();

                JOptionPane.showMessageDialog(view, "Permission deleted successfully.");
                loadPermissions();

                // Clear the fields after deletion
                view.permissionIDField.setText("");
                view.permissionNameField.setText("");
                view.permissionUsageField.setText("");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(view, "An error occurred while deleting the permission.");
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(view, "No permission selected to delete.");
        }
    }

    private void assignPermission() {
        String selectedPermission = (String) view.permissionBox.getSelectedItem();
        if (selectedPermission != null) {
            // Logic for assigning the selected permission
            JOptionPane.showMessageDialog(view, "Assigned permission: " + selectedPermission);
        } else {
            JOptionPane.showMessageDialog(view, "No permission selected for assignment.");
        }
    }

    public static void main(String[] args) {
        try {
            PermissionView view = new PermissionView();
            new PermissionController(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
