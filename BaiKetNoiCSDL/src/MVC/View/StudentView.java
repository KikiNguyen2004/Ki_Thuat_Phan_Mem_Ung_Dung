package MVC.View;

import javax.swing.*;
import java.awt.*;
 
public class StudentView extends JFrame {
    public JComboBox<String> mssvBox;
    public JTextField fullNameField;
    public JTextField doBField;
    public JTextField genderField;
    public JTextField classIDField;
    public JButton searchButton;
 
    public StudentView() {
        setTitle("Search Student");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
 
        mssvBox = new JComboBox<>();
        mssvBox.setLocation(30, 200);
        mssvBox.setSize(150, 50);
 
        searchButton = new JButton("Search");
        searchButton.setLocation(200, 200);
        searchButton.setSize(100, 50);
 
        JLabel fullNameLabel = new JLabel("FullName:");
        fullNameLabel.setLocation(30, 300);
        fullNameLabel.setSize(100, 30);
        fullNameField = new JTextField();
        fullNameField.setLocation(140, 300);
        fullNameField.setSize(200, 30);
 
        JLabel doBLabel = new JLabel("DoB:");
        doBLabel.setLocation(30, 350);
        doBLabel.setSize(100, 30);
        doBField = new JTextField();
        doBField.setLocation(140, 350);
        doBField.setSize(200, 30);
 
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setLocation(30, 400);
        genderLabel.setSize(100, 30);
        genderField = new JTextField();
        genderField.setLocation(140, 400);
        genderField.setSize(200, 30);
 
        JLabel classIDLabel = new JLabel("Class ID:");
        classIDLabel.setLocation(30, 500);
        classIDLabel.setSize(100, 30);
        classIDField = new JTextField();
        classIDField.setLocation(140, 500);
        classIDField.setSize(200, 30);
 
        contentPane.add(mssvBox);
        contentPane.add(searchButton);
        contentPane.add(fullNameLabel);
        contentPane.add(fullNameField);
        contentPane.add(doBLabel);
        contentPane.add(doBField);
        contentPane.add(genderLabel);
        contentPane.add(genderField);
        contentPane.add(classIDLabel);
        contentPane.add(classIDField);
 
        setVisible(true);
    }
}