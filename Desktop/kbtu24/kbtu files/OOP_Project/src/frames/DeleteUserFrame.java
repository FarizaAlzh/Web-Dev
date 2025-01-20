package frames;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DeleteUserFrame extends JFrame {
    public DeleteUserFrame() {
        this.setTitle("Delete User");
        this.setBounds(100, 100, 500, 300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        JLabel idLabel = new JLabel("Enter User ID to delete:");
        JTextField idField = new JTextField();
        JButton deleteButton = new JButton("Delete User");

        idLabel.setBounds(50, 50, 200, 30);
        idField.setBounds(250, 50, 150, 30);
        deleteButton.setBounds(150, 150, 200, 50);

        this.add(idLabel);
        this.add(idField);
        this.add(deleteButton);
        this.setVisible(true);

        deleteButton.addActionListener(e -> {
            String inputID = idField.getText().trim();
            if (inputID.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a valid ID.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            boolean userFound = false;
            List<String> updatedLines = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader("login_password.txt"))) {
                String line;

                while ((line = reader.readLine()) != null) {
                    String[] userData = line.split(":");
                    if (userData.length == 7 && userData[6].trim().equals(inputID)) {
                        userFound = true;
                    } else {
                        updatedLines.add(line);
                    }
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error reading file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (userFound) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("login_password.txt"))) {
                    for (String updatedLine : updatedLines) {
                        writer.write(updatedLine);
                        writer.newLine();
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error writing to file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                JOptionPane.showMessageDialog(this, "студент отчислен...", "Success", JOptionPane.INFORMATION_MESSAGE);
                //JOptionPane.showMessageDialog(this, "User with ID " + inputID + " deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No user found with ID " + inputID + ".", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}

