package frames;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import classes.Course;
import classes.Student;

public class PutMarksFrame extends JFrame {
    Student student1 = new Student("a_kaliyev", "12345678", "Alpamys", "Kaliyev", "23B01", 18, "a_kaliyev@kbtu.kz", "SITE", "CHS", 2);
    Student student2 = new Student("f_alzhan", "12345678", "Fariza", "Alzhan", "23B02", 18, "f_alzhan@kbtu.kz", "Oil and Gas", "Managment", 2);
    Student student3 = new Student("a_kazybek", "12345678", "Abylai", "Kazybek", "23B03", 18, "a_kazybek@kbtu.kz", "BS", "Manager", 2);
    Student student4 = new Student("m_altynbek", "12345678", "Maksat", "Altynbek", "23B04", 18, "m_altynbek@kbtu.kz", "SITE", "IS", 2);
    List<Student> students = Arrays.asList(student1, student2, student3, student4);

    Course OOP = new Course("OOP", 6);
    Course PP = new Course("PP", 6);
    Course PPII = new Course("PP II", 6);
    List<Course> courses = Arrays.asList(OOP, PP, PPII);

    public PutMarksFrame(String loginTeacher) {
        this.setBounds(100, 100, 500, 500);
        this.setLayout(null);
        ArrayList<String> allStudents = new ArrayList<>();
        ArrayList<String> allCourses = new ArrayList<>();
        for (Student student : students) {
            allStudents.add(student.get_login());
        }
        for (Course course : courses) {
            allCourses.add(course.getName());
        }
        JLabel studentLabel = new JLabel("Select Student:");
        JLabel courseLabel = new JLabel("Select Course:");
        JLabel markLabel = new JLabel("Enter Mark:");
        studentLabel.setBounds(50, 50, 150, 25);
        courseLabel.setBounds(50, 100, 150, 25);
        markLabel.setBounds(50, 150, 150, 25);
        this.add(studentLabel);
        this.add(courseLabel);
        this.add(markLabel);
        JComboBox<String> studentsBox = new JComboBox<>(allStudents.toArray(new String[0]));
        JComboBox<String> coursesBox = new JComboBox<>(allCourses.toArray(new String[0]));
        JTextField markField = new JTextField();
        studentsBox.setBounds(200, 50, 200, 25);
        coursesBox.setBounds(200, 100, 200, 25);
        markField.setBounds(200, 150, 200, 25);
        this.add(studentsBox);
        this.add(coursesBox);
        this.add(markField);
        JButton submitButton = new JButton("Put Mark");
        submitButton.setBounds(200, 200, 100, 30);
        this.add(submitButton);
        submitButton.addActionListener(e -> {
            String selectedStudent = (String) studentsBox.getSelectedItem();
            String selectedCourse = (String) coursesBox.getSelectedItem();
            String mark = markField.getText();

            if (selectedStudent == null || selectedCourse == null || mark.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String filePath = "Marks.txt";
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
                writer.write(selectedStudent + ":" + selectedCourse + ":" + mark + ":" + loginTeacher);
                writer.newLine();
                JOptionPane.showMessageDialog(this, "Mark has been successfully added!", "Success", JOptionPane.INFORMATION_MESSAGE);
                markField.setText("");
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Failed to save mark!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        this.setVisible(true);
    }
}

