package frames;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyCoursesFrame extends JFrame {

    public MyCoursesFrame(String studentId) {
        this.setTitle("My Courses");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        ImageIcon backgroundIcon = new ImageIcon("result_bg_panel (1).jpg");
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setLayout(new BorderLayout());
        this.setContentPane(backgroundLabel);
        List<String[]> courseData = readCoursesFromFile("MyCourses.txt", studentId);

        String[] columnNames = {"Discipline", "Credits", "Teacher"};
        String[][] tableData = courseData.toArray(new String[0][]);
        JTable table = new JTable(tableData, columnNames);
        table.setFillsViewportHeight(true);
        table.setRowHeight(30);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(700, 400)); 
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setOpaque(false); 
        panel.add(scrollPane);
        backgroundLabel.add(panel, BorderLayout.CENTER);
        this.setVisible(true);
    }
    private List<String[]> readCoursesFromFile(String filename, String studentId) {
        List<String[]> courses = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 4 && parts[0].equals(studentId)) {
                    String[] courseInfo = {parts[1], parts[2], parts[3]};
                    courses.add(courseInfo);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading file: " + e.getMessage(),
                    "File Error", JOptionPane.ERROR_MESSAGE);
        }
        return courses;
    }
}


