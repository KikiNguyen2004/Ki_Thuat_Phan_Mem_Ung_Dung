package GUI;
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
 
public class PasteOnLabel {
 
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
 
        String url = "jdbc:sqlserver://localhost:1433;databaseName=TestD8;encrypt=true;trustServerCertificate=true";
        String username = "sa";
        String pass = "Phucthan@2004";
        Connection connection = DriverManager.getConnection(url, username, pass);
 
        String sqlString = "Select *\n" +
                           "From Student\n" +
                           "Where studentID = (?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
 
        JFrame frame = new JFrame("Search Student");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(null);
 
        JTextField input = new JTextField();
        input.setLocation(30, 200);
        input.setSize(150, 50);
 
        JLabel resultLabel = new JLabel("Result: ");
        resultLabel.setLocation(30, 300);
        resultLabel.setSize(400, 50);
 
        JButton button = new JButton("Search");
        button.setLocation(30, 30);
        button.setSize(150, 100);
 
        // Sử dụng lớp ActionListener riêng biệt
        button.addActionListener(new MyActionListener(preparedStatement, input, resultLabel));
 
        contentPane.add(button);
        contentPane.add(input);
        contentPane.add(resultLabel);
 
        frame.setVisible(true);
    }
 
    // Lớp xử lý sự kiện riêng
    static class MyActionListener implements ActionListener {
        private final PreparedStatement preparedStatement;
        private final JTextField input;
        private final JLabel resultLabel;
 
        public MyActionListener(PreparedStatement preparedStatement, JTextField input, JLabel resultLabel) {
            this.preparedStatement = preparedStatement;
            this.input = input;
            this.resultLabel = resultLabel;
        }
 
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                preparedStatement.setString(1, input.getText());
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    String result = resultSet.getString(2) + " " + resultSet.getString(3);
                    resultLabel.setText("Result: " + result);
                } else {
                    resultLabel.setText("Result: No student found.");
                }
            } catch (SQLException ex) {
                resultLabel.setText("Result: Error occurred.");
                ex.printStackTrace();
            }
        }
    }
}