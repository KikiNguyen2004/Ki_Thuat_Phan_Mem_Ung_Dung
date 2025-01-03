package MVC.Controller;

import MVC.Model.StudentModel;
import MVC.View.StudentView;

import javax.swing.*;
import java.sql.*;
 
public class StudentController {
    private Connection connection;
    private StudentView view;
 
    public StudentController(StudentView view) throws SQLException, ClassNotFoundException {
        this.view = view;
 
        // Initialize database connection
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=TestD8;encrypt=true;trustServerCertificate=true";
        String username = "sa";
        String pass = "Phucthan@2004";
        connection = DriverManager.getConnection(url, username, pass);
 
        loadStudentIDs();
 
        view.searchButton.addActionListener(e -> searchStudent());
    }
 
    private void loadStudentIDs() {
        try (Statement stm = connection.createStatement()) {
            ResultSet resultSet = stm.executeQuery("SELECT studentID FROM Student");
            while (resultSet.next()) {
                view.mssvBox.addItem(resultSet.getString("studentID"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
 
    private void searchStudent() {
        String selectedID = (String) view.mssvBox.getSelectedItem();
        if (selectedID != null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM Student WHERE studentID = ?")) {
                preparedStatement.setString(1, selectedID);
                ResultSet resultSet = preparedStatement.executeQuery();
 
                if (resultSet.next()) {
                    view.fullNameField.setText(resultSet.getString(2));
                    view.doBField.setText(String.valueOf(resultSet.getDate(3)));
                    view.genderField.setText(String.valueOf(resultSet.getString(4)));               
                    view.classIDField.setText(resultSet.getString(5));
                } else {
                    JOptionPane.showMessageDialog(view, "No data found for the selected student.");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(view, "An error occurred while fetching data.");
                ex.printStackTrace();
            }
        }
    }
 
    public static void main(String[] args) {
        try {
            StudentView view = new StudentView();
            new StudentController(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}