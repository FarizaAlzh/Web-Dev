package frames;

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import classes.Course;

public class ViewMarksFrame extends JFrame {
    Course OOP = new Course("OOP", 6);
    Course PP = new Course("PP", 6);
    Course PPII = new Course("PP II", 6);
    Course Calculus = new Course("Calculus", 6);
    Course English = new Course("English", 10);
    Course Statistic = new Course("Statistic", 10);
    Course ADS = new Course("Algorithms and Structure", 10);
    Course Russian = new Course("Russian", 10);
    List<Course> courses = Arrays.asList(OOP, PP, PPII, Calculus, English, Statistic, ADS, Russian);

    public ViewMarksFrame(String studentLogin) {
        this.setBounds(100, 100, 600, 400);
        this.setLayout(new BorderLayout());

        JComboBox<String> courseComboBox = new JComboBox<>();
        for (Course course : courses) {
            courseComboBox.addItem(course.getName());
        }

        JTextArea marksArea = new JTextArea();
        marksArea.setEditable(false);
        marksArea.setBackground(Color.WHITE);
        marksArea.setFont(new Font("Monospaced", Font.PLAIN, 14));

        JScrollPane scrollPane = new JScrollPane(marksArea);
        scrollPane.setPreferredSize(new Dimension(400, 300));

        this.add(courseComboBox, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
        courseComboBox.addActionListener(e -> {
            String selectedCourse = (String) courseComboBox.getSelectedItem();
            if (selectedCourse != null) {
                String marks = getMarksForCourse(studentLogin, selectedCourse);
                marksArea.setText(marks);
            }
        });

        this.setVisible(true);
    }

    private String getMarksForCourse(String studentLogin, String courseName) {
        StringBuilder marksBuilder = new StringBuilder();
        String filePath = "Marks.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 4 && parts[0].equals(studentLogin) && parts[1].equals(courseName)) {
                    marksBuilder.append("Mark: ").append(parts[2]).append(" (Teacher: ").append(parts[3]).append(")\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error reading marks file.";
        }

        if (marksBuilder.length() == 0) {
            return "No marks found for this course.";
        }

        return marksBuilder.toString();
    }
}


