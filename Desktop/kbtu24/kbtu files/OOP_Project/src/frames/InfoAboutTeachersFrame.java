package frames;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import classes.Student;
import classes.Teacher;
import enums.TeacherType;

public class InfoAboutTeachersFrame extends JFrame {
    Teacher t1 = new Teacher("a_izbassar", "Aizbassar123", "Assylzhan", "Izbassar", "23BD06", "a_izb@kbtu.kz", 22, 350000, TeacherType.LECTOR);
    Teacher t2 = new Teacher("dzhankieva", "Dzhanka123", "Botagoz", "Dzhankieva", "23BD01", "d_botagoz@kbtu.kz", 25, 550000, TeacherType.PROFESSOR);
    Teacher t3 = new Teacher("mustafaeva", "Mustafaeva111", "Ardak", "Mustafaeva", "23BD02", "m_ardak@kbtu.kz", 21, 400000, TeacherType.PROFESSOR);

    List<Teacher>teachers = Arrays.asList(t1,t2,t3);

    public InfoAboutTeachersFrame() {
        this.setBounds(100, 100, 800, 600);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("View All Teachers");
        this.setLayout(new BorderLayout());

        ImageIcon backgroundIcon = new ImageIcon("result_bg_panel (1).jpg");
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setLayout(new BorderLayout());
        this.setContentPane(backgroundLabel);

        String[] columnNames = {"Id","Login", "Name", "Surname", "Age", "Email", "Salary", "TeacherType"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        for (Teacher t : teachers) {
            Object[] rowData = {
                    t.get_name(),
                    t.get_login(),
                    t.getName(),
                    t.getLastName(),
                    t.getAge(),
                    t.getEmail(),
                    t.getSalary(),
                    t.getTeacherType()
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
        new InfoAboutTeachersFrame();
    }
}
