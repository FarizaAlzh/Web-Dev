package frames;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CourseRegistrationFrame extends JFrame {
    public CourseRegistrationFrame(String studentId) {
        this.setTitle("Course Registration");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        ImageIcon backgroundIcon = new ImageIcon("result_bg_panel (1).jpg");
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setLayout(new BorderLayout());
        this.setContentPane(backgroundLabel);
        List<String[]> courseData = readCoursesFromFile("CourseRegistration.txt", studentId);
        String[] columnNames = {"Course Name", "Credits", "Teacher", "Choose"};
        Object[][] tableData = courseData.stream()
                .map(row -> new Object[]{row[1], Integer.parseInt(row[2]), row[3], false})
                .toArray(Object[][]::new);

        DefaultTableModel model = new DefaultTableModel(tableData, columnNames) {
            public Class<?> getColumnClass(int column) {
                return column == 3 ? Boolean.class : String.class; 
            }
        };

        JTable table = new JTable(model);
        table.setRowHeight(30);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(700, 400));
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setOpaque(false);
        panel.add(scrollPane);
        backgroundLabel.add(panel, BorderLayout.CENTER);
        JPanel bottomPanel = new JPanel();
        bottomPanel.setOpaque(false);

        JLabel creditLabel = new JLabel("Total Credits: 0");
        creditLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JButton submitButton = new JButton("Submit");
        submitButton.setEnabled(false);

        bottomPanel.add(creditLabel);
        bottomPanel.add(submitButton);
        backgroundLabel.add(bottomPanel, BorderLayout.SOUTH);
        model.addTableModelListener(e -> {
            int totalCredits = 0;
            for (int i = 0; i < model.getRowCount(); i++) {
                Boolean isSelected = (Boolean) model.getValueAt(i, 3);
                if (isSelected != null && isSelected) {
                    totalCredits += (int) model.getValueAt(i, 1);
                }
            }
            creditLabel.setText("Total Credits: " + totalCredits);
            submitButton.setEnabled(totalCredits > 0 && totalCredits <= 20);
        });

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(
                        CourseRegistrationFrame.this,
                        "Wait for approval of registration",
                        "Registration Submitted",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });
        this.setVisible(true);
    }
    private List<String[]> readCoursesFromFile(String filename, String studentId) {
        List<String[]> courses = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 4 && parts[0].equals(studentId)) {
                    courses.add(parts);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading file: " + e.getMessage(),
                    "File Error", JOptionPane.ERROR_MESSAGE);
        }
        return courses;
    }
}


