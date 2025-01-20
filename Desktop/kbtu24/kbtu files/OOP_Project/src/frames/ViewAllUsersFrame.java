package frames;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ViewAllUsersFrame extends JFrame {
    public ViewAllUsersFrame() {
        this.setTitle("View All Users");
        this.setResizable(false);
        this.setBounds(100, 100, 700, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        String[] columnNames = {"Login", "Password", "Role", "Type", "First Name", "Last Name", "ID"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable userTable = new JTable(tableModel);
        try (BufferedReader reader = new BufferedReader(new FileReader("login_password.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(":");
                if (userData.length == 7) {
                    tableModel.addRow(userData);
                } else {
                    System.err.println("Invalid line format: " + line);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        JScrollPane scrollPane = new JScrollPane(userTable);
        this.add(scrollPane);
        this.setVisible(true);
    }
    
}

