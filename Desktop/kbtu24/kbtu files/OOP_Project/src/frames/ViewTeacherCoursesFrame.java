package frames;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ViewTeacherCoursesFrame extends JFrame {
    private String teacherLogin;

    public ViewTeacherCoursesFrame(String teacherLogin) {
        this.teacherLogin = teacherLogin;
        ImageIcon backgroundIcon = new ImageIcon("result_bg_panel (1).jpg");
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setBounds(0, 0, 400, 250);
        setContentPane(backgroundLabel);
        this.setBounds(300, 200, 500, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        
        List<String> courses = getTeacherCourses();
        displayCourses(courses);
        
        this.setVisible(true);
    }

    private List<String> getTeacherCourses() {
        List<String> courses = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("assignments.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(teacherLogin + ":")) {
                    String course = line.split(":")[1];
                    courses.add(course);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading courses file", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return courses;
    }

    private void displayCourses(List<String> courses) {
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBounds(100, 100, 300, 200);
        textArea.setBackground(Color.WHITE);

        StringBuilder courseText = new StringBuilder();
        for (String course : courses) {
            courseText.append(course).append("\n");
        }

        textArea.setText(courseText.toString());
        this.add(textArea);
    }
}

