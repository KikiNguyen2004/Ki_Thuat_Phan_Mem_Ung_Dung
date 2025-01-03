package GUI;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class ShowStudentList {
	    public static void main(String[] args) {
	        // Tạo frame chính
	        JFrame frame = new JFrame("Thông Tin Sinh Viên");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(600, 400);
	        
	        // Tạo panel để chứa label
	        JPanel panel = new JPanel();
	        panel.setLayout(new BorderLayout());
	        
	        // Tạo label để hiển thị dữ liệu
	        JLabel infoLabel = new JLabel();
	        infoLabel.setVerticalAlignment(SwingConstants.TOP); // Canh chỉnh văn bản
	        infoLabel.setHorizontalAlignment(SwingConstants.LEFT);
	        infoLabel.setFont(new Font("Arial", Font.PLAIN, 14));
	        
	        // Đổ dữ liệu từ cơ sở dữ liệu vào label
	        try (Connection conn = DatabaseConnection.connect();
	             Statement statement = conn.createStatement()) {
	            
	            // Lấy danh sách sinh viên
	            ResultSet resultSet1 = statement.executeQuery("SELECT * FROM Student");
	            StringBuilder studentInfo = new StringBuilder("<html>"); // HTML để format văn bản
	            
	            // Xử lý từng dòng kết quả
	            while (resultSet1.next())
	  			 	System.out.println(resultSet1.getInt(1) + "\t" +
	  			 			resultSet1.getString(2) + "\t" + resultSet1.getDate(3) +
	  			 			"\t" + resultSet1.getString(4) + "\t" + resultSet1.getString(5));
	            }
	            studentInfo.append("</html>");
	            infoLabel.setText(studentInfo.toString());
	        } catch (SQLException e) {
	            e.printStackTrace();
	            infoLabel.setText("Không thể kết nối hoặc truy vấn cơ sở dữ liệu!");
	        }
	        
	        // Thêm label vào panel và frame
	        JScrollPane scrollPane = new JScrollPane(infoLabel); // Thêm cuộn nếu nội dung quá dài
	        panel.add(scrollPane, BorderLayout.CENTER);
	        frame.add(panel);
	        
	        // Hiển thị frame
	        frame.setVisible(true);
	    }
	}
}


package GUI;
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
 
public class ShowStudentList {
 
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
                    String result = resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4) + " " + resultSet.getString(5);
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

/*
package GUI;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
 
 
public class ShowStudentList {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
       // System.out.println("Driver loaded");
 
        String url = "jdbc:sqlserver://localhost:1433;databaseName=TestD8;encrypt=true;trustServerCertificate=true";
        String username = "sa";
        String pass = "Phucthan@2004";
        Connection connection = DriverManager.getConnection(url, username, pass);
        //System.out.println("Database connected");
        Statement stm = connection.createStatement();
 
        JFrame frame = new JFrame("Hello World!");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(null);
 
        JComboBox<String> mssvBox = new JComboBox<String>();
        mssvBox.setLocation(30, 200);
        mssvBox.setSize(150, 50);
 
           try {
                ResultSet resultSet =  stm.executeQuery("Select studentID from Student");
                while (resultSet.next()) {
                	mssvBox.addItem(resultSet.getString("studentID"));//getString(1)
                }
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
        //});
       // contentPane.add(button);
        contentPane.add(mssvBox);
 
        frame.setVisible(true);
    }
}


package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
 
public class ShowStudentList {
 
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
 
        String url = "jdbc:sqlserver://localhost:1433;databaseName=TestD8;encrypt=true;trustServerCertificate=true";
        String username = "sa";
        String pass = "Phucthan@2004";
        Connection connection = DriverManager.getConnection(url, username, pass);
 
        JFrame frame = new JFrame("Search Student");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(null);
 
        JLabel infoLabel = new JLabel("Student Info: ");
        infoLabel.setLocation(30, 300);
        infoLabel.setSize(700, 50);
 
        JComboBox<String> mssvBox = new JComboBox<>();
        mssvBox.setLocation(30, 200);
        mssvBox.setSize(150, 50);
 
        // Load student IDs into JComboBox
        try (Statement stm = connection.createStatement()) {
            ResultSet resultSet = stm.executeQuery("SELECT studentID FROM Student");
            while (resultSet.next()) {
                mssvBox.addItem(resultSet.getString("studentID"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
 
        // Add ActionListener to JComboBox
        mssvBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedID = (String) mssvBox.getSelectedItem();
                if (selectedID != null) {
                    try (PreparedStatement preparedStatement = connection.prepareStatement(
                            "SELECT * FROM Student WHERE studentID = ?")) {
                        preparedStatement.setString(1, selectedID);
                        ResultSet resultSet = preparedStatement.executeQuery();
 
                        if (resultSet.next()) {
                            String info = resultSet.getString(2) + " " + resultSet.getDate(3) + " " + resultSet.getString(4)+ " " + resultSet.getString(5);
                            infoLabel.setText("Student Info: " + info);
                        } else {
                            infoLabel.setText("Student Info: No data found.");
                        }
                    } catch (SQLException ex) {
                        infoLabel.setText("Student Info: Error occurred.");
                        ex.printStackTrace();
                    }
                }
            }
        });
 
        contentPane.add(mssvBox);
        contentPane.add(infoLabel);
 
        frame.setVisible(true);
    }
}

package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ShowStudentList {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        String url = "jdbc:sqlserver://localhost:1433;databaseName=TestD8;encrypt=true;trustServerCertificate=true";
        String username = "sa";
        String pass = "Phucthan@2004";
        Connection connection = DriverManager.getConnection(url, username, pass);

        // Frame setup
        JFrame frame = new JFrame("Student Management");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // ComboBox for Student IDs
        JLabel selectLabel = new JLabel("Select MSSV:");
        selectLabel.setBounds(30, 30, 100, 30);
        frame.add(selectLabel);

        JComboBox<String> mssvBox = new JComboBox<>();
        mssvBox.setBounds(150, 30, 200, 30);
        frame.add(mssvBox);

        // Load MSSV into ComboBox
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT studentID FROM Student");
            while (resultSet.next()) {
                mssvBox.addItem(resultSet.getString("studentID"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        // TextFields for student information
        JLabel[] labels = new JLabel[5];
        JTextField[] textFields = new JTextField[5];
        String[] fieldNames = {"MSSV", "Họ Tên", "Ngày Sinh", "Giới Tính", "Mã Lớp"};
        for (int i = 0; i < 5; i++) {
            labels[i] = new JLabel(fieldNames[i] + ":");
            labels[i].setBounds(30, 80 + i * 50, 100, 30);
            frame.add(labels[i]);

            textFields[i] = new JTextField();
            textFields[i].setBounds(150, 80 + i * 50, 200, 30);
            frame.add(textFields[i]);
        }

        // Search button
        JButton searchButton = new JButton("Search");
        searchButton.setBounds(400, 30, 100, 30);
        frame.add(searchButton);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedID = (String) mssvBox.getSelectedItem();
                if (selectedID != null) {
                    try (PreparedStatement preparedStatement = connection.prepareStatement(
                            "SELECT * FROM Student WHERE studentID = ?")) {
                        preparedStatement.setString(1, selectedID);
                        ResultSet resultSet = preparedStatement.executeQuery();

                        if (resultSet.next()) {
                            for (int i = 0; i < 5; i++) {
                                textFields[i].setText(resultSet.getString(i + 1));
                            }
                        } else {
                            JOptionPane.showMessageDialog(frame, "No data found!");
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(frame, "Error retrieving data.");
                        ex.printStackTrace();
                    }
                }
            }
        });

        // Update button
        JButton updateButton = new JButton("Update");
        updateButton.setBounds(150, 350, 100, 30);
        frame.add(updateButton);

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedID = (String) mssvBox.getSelectedItem();
                if (selectedID != null) {
                    try (PreparedStatement preparedStatement = connection.prepareStatement(
                            "UPDATE Student SET studentID = ?, name = ?, birthDate = ?, gender = ?, classID = ? WHERE studentID = ?")) {
                        for (int i = 0; i < 5; i++) {
                            preparedStatement.setString(i + 1, textFields[i].getText());
                        }
                        preparedStatement.setString(6, selectedID);

                        int rowsUpdated = preparedStatement.executeUpdate();
                        if (rowsUpdated > 0) {
                            JOptionPane.showMessageDialog(frame, "Student information updated successfully!");
                        } else {
                            JOptionPane.showMessageDialog(frame, "Update failed.");
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(frame, "Error updating data.");
                        ex.printStackTrace();
                    }
                }
            }
        });

        frame.setVisible(true);
    }
}
*/
ComboBoxStudentSearchByButton
 
package GUI;
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
 
public class ComboBoxSearchStudentByButton {
 
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
 
        String url = "jdbc:sqlserver://localhost:1433;databaseName=qlsv;encrypt=true;trustServerCertificate=true";
        String username = "sa";
        String pass = "sa";
        Connection connection = DriverManager.getConnection(url, username, pass);
 
        JFrame frame = new JFrame("Search Student");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(null);
 
        JLabel infoLabel = new JLabel("Student Info: ");
        infoLabel.setLocation(30, 300);
        infoLabel.setSize(700, 50);
 
        JComboBox<String> mssvBox = new JComboBox<>();
        mssvBox.setLocation(30, 200);
        mssvBox.setSize(150, 50);
 
        JButton searchButton = new JButton("Search");
        searchButton.setLocation(200, 200);
        searchButton.setSize(100, 50);
 
        // Load student IDs into JComboBox
        try (Statement stm = connection.createStatement()) {
            ResultSet resultSet = stm.executeQuery("SELECT studentID FROM Student");
            while (resultSet.next()) {
                mssvBox.addItem(resultSet.getString("studentID"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
 
        // Add ActionListener to Search Button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedID = (String) mssvBox.getSelectedItem();
                if (selectedID != null) {
                    try (PreparedStatement preparedStatement = connection.prepareStatement(
                            "SELECT * FROM Student WHERE studentID = ?")) {
                        preparedStatement.setString(1, selectedID);
                        ResultSet resultSet = preparedStatement.executeQuery();
 
                        if (resultSet.next()) {
                            String info = resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getInt(4)+ " " + resultSet.getDate(5)+ " " + resultSet.getString(6) ;
                            infoLabel.setText("Student Info: " + info);
                        } else {
                            infoLabel.setText("Student Info: No data found.");
                        }
                    } catch (SQLException ex) {
                        infoLabel.setText("Student Info: Error occurred.");
                        ex.printStackTrace();
                    }
                }
            }
        });
 
        contentPane.add(mssvBox);
        contentPane.add(searchButton);
        contentPane.add(infoLabel);
 
        frame.setVisible(true);
    }
}
 

package GUI;
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
 
public class SearchStudenttoUpdate {
 
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
 
        String url = "jdbc:sqlserver://localhost:1433;databaseName=qlsv;encrypt=true;trustServerCertificate=true";
        String username = "sa";
        String pass = "sa";
        Connection connection = DriverManager.getConnection(url, username, pass);
 
        JFrame frame = new JFrame("Search Student");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(null);
 
        JLabel firstNameLabel = new JLabel("FirstName:");
        firstNameLabel.setLocation(30, 300);
        firstNameLabel.setSize(100, 30);
        JTextField firstNameField = new JTextField();
        firstNameField.setLocation(140, 300);
        firstNameField.setSize(200, 30);
 
        JLabel lastNameLabel = new JLabel("LastName:");
        lastNameLabel.setLocation(30, 350);
        lastNameLabel.setSize(100, 30);
        JTextField lastNameField = new JTextField();
        lastNameField.setLocation(140, 350);
        lastNameField.setSize(200, 30);
 
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setLocation(30, 400);
        genderLabel.setSize(100, 30);
        JTextField genderField = new JTextField();
        genderField.setLocation(140, 400);
        genderField.setSize(200, 30);
 
        JComboBox<String> mssvBox = new JComboBox<>();
        mssvBox.setLocation(30, 200);
        mssvBox.setSize(150, 50);
 
        JButton searchButton = new JButton("Search");
        searchButton.setLocation(200, 200);
        searchButton.setSize(100, 50);
 
        // Load student IDs into JComboBox
        try (Statement stm = connection.createStatement()) {
            ResultSet resultSet = stm.executeQuery("SELECT studentID FROM Student");
            while (resultSet.next()) {
                mssvBox.addItem(resultSet.getString("studentID"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
 
        // Add ActionListener to Search Button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedID = (String) mssvBox.getSelectedItem();
                if (selectedID != null) {
                    try (PreparedStatement preparedStatement = connection.prepareStatement(
                            "SELECT * FROM Student WHERE studentID = ?")) {
                        preparedStatement.setString(1, selectedID);
                        ResultSet resultSet = preparedStatement.executeQuery();
 
                        if (resultSet.next()) {
                        	firstNameField.setText(resultSet.getString(2));
                            lastNameField.setText(resultSet.getString(3));
                            genderField.setText(String.valueOf(resultSet.getInt(4)));
                        } else {
                        	firstNameField.setText("");
                        	lastNameField.setText("");
                        	genderField.setText("");
                            JOptionPane.showMessageDialog(frame, "No data found for the selected student.");
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(frame, "An error occurred while fetching data.");
                        ex.printStackTrace();
                    }
                }
            }
        });
 
        contentPane.add(mssvBox);
        contentPane.add(searchButton);
        contentPane.add(firstNameLabel);
        contentPane.add(firstNameField);
        contentPane.add(lastNameLabel);
        contentPane.add(lastNameField);
        contentPane.add(genderLabel);
        contentPane.add(genderField);
 
        frame.setVisible(true);
    }
}
 
 


