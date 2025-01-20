package frames;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.List;
import javax.swing.*;

class Course {
    String name;
    int credits;

    public Course(String name, int credits) {
        this.name = name;
        this.credits = credits;
    }
}

public class AssignCourses extends JFrame {
    private List<Course> courses = List.of(
        new Course("OOP", 6),
        new Course("PP", 6),
        new Course("PP II", 6),
        new Course("Calculus", 6),
        new Course("English", 10),
        new Course("Statistic", 10),
        new Course("Algorithms and Structure", 10),
        new Course("Russian", 10)
    );

    private JTextField teacherLoginField;
    private JComboBox<String> courseComboBox;

    public AssignCourses() {
        setTitle("Assign Courses to Teacher");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        // Background image setup
        ImageIcon backgroundIcon = new ImageIcon("result_bg_panel (1).jpg");
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setBounds(0, 0, 400, 250);
        setContentPane(backgroundLabel);
        backgroundLabel.setLayout(null);

        JLabel loginLabel = new JLabel("Teacher Login:");
        loginLabel.setBounds(50, 30, 100, 25);
        backgroundLabel.add(loginLabel);

        teacherLoginField = new JTextField(15);
        teacherLoginField.setBounds(160, 30, 150, 25);
        backgroundLabel.add(teacherLoginField);

        JLabel coursesLabel = new JLabel("Select Course:");
        coursesLabel.setBounds(50, 70, 100, 25);
        backgroundLabel.add(coursesLabel);

        String[] courseNames = courses.stream().map(course -> course.name).toArray(String[]::new);
        courseComboBox = new JComboBox<>(courseNames);
        courseComboBox.setBounds(160, 70, 150, 25);
        backgroundLabel.add(courseComboBox);

        JButton assignButton = new JButton("Assign");
        assignButton.setBounds(150, 120, 100, 30);
        assignButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                assignCourseToTeacher();
            }
        });
        backgroundLabel.add(assignButton);

        setVisible(true);
    }

    private void assignCourseToTeacher() {
        String teacherLogin = teacherLoginField.getText().trim();
        if (teacherLogin.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a teacher login.");
            return;
        }

        String selectedCourse = (String) courseComboBox.getSelectedItem();
        if (selectedCourse == null) {
            JOptionPane.showMessageDialog(this, "Please select a course.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("assignments.txt", true))) {
            writer.write(teacherLogin + ":" + selectedCourse+"\n");
            JOptionPane.showMessageDialog(this, "Course assigned successfully.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error writing to file.");
        }
    }
}




