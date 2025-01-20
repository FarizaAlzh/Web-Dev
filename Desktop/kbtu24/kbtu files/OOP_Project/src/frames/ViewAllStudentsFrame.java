package frames;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

import classes.Student;

public class ViewAllStudentsFrame extends JFrame {
    Student student1 = new Student("a_kaliyev", "12345678", "Alpamys", "Kaliyev", "23B01", 18, "a_kaliyev@kbtu.kz", "SITE", "CHS", 2);
    Student student2 = new Student("f_alzhan", "12345678", "Fariza", "Alzhan", "23B02", 18, "f_alzhan@kbtu.kz", "Oil and Gas", "Managment", 2);
    Student student3 = new Student("a_kazybek", "12345678", "Abylai", "Kazybek", "23B03", 18, "a_kazybek@kbtu.kz", "BS", "Manager", 2);
    Student student4 = new Student("m_altynbek", "12345678", "Maksat", "Altynbek", "23B04", 18, "m_altynbek@kbtu.kz", "SITE", "IS", 2);
    List<Student> students = Arrays.asList(student1, student2, student3, student4);

    public ViewAllStudentsFrame() {
        this.setBounds(100, 100, 800, 600);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("View All Students");
        this.setLayout(new BorderLayout());

        ImageIcon backgroundIcon = new ImageIcon("result_bg_panel (1).jpg"); 
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setLayout(new BorderLayout());
        this.setContentPane(backgroundLabel);

        String[] columnNames = {"Login", "Name", "Surname", "Group", "Age", "Email", "Department", "Specialization", "Year"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        for (Student student : students) {
            Object[] rowData = {
                student.get_login(),
                student.get_name(),
                student.getLastName(),
                student.get_id(),
                student.getAge(),
                student.getEmail(),
                student.getDepartment(),
                student.getSpecialization(),
                student.getYear()
            };
            tableModel.addRow(rowData);
        }

        JTable table = new JTable(tableModel);
        table.setFillsViewportHeight(true);
        table.setOpaque(false);
        table.setBackground(new Color(255, 255, 255, 200));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);
        this.add(scrollPane, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ViewAllStudentsFrame();
    }
}

