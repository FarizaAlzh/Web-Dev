package frames;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SendRequestFrame extends JFrame {

    JTextField messageField;
    JComboBox<String> levelComplaints;
    JButton sendButton;
    JLabel messageLabel;
    String senderLogin;

    public SendRequestFrame(String senderLogin){
        this.senderLogin = senderLogin;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500,200);
        this.setTitle("WSP");
        this.setLayout(null);
        this.setResizable(false);
        this.setLocation(500, 200);

        String[] levels ={"OR", "Department"};

        messageLabel = new JLabel("Request");
        messageLabel.setBounds(52, 53 , 80, 20);
        messageLabel.setFont(new Font("Dialog", Font.BOLD, 13));

        messageField = new JTextField();
        messageField.setBounds(120, 50, 200, 30);
        messageField.setFont(new Font("Arial", Font.BOLD, 12));

        levelComplaints = new JComboBox<>(levels);
        levelComplaints.setBounds(210, 105, 100,20);

        sendButton = new JButton("Send");
        sendButton.setBounds(120,105, 65, 20);

        sendButton.addActionListener(e -> {
            String message = messageField.getText();
            if (!message.isEmpty()) {
                writeToFile(senderLogin + ":" + message);
                JOptionPane.showMessageDialog(null, "You have successfully sent your request", "INFO!!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Message cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        this.add(messageLabel);
        this.add(messageField);
        this.add(sendButton);
        this.add(levelComplaints);
        this.setVisible(true);
    }

    private void writeToFile(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("request.txt", true))) {
            writer.write(content);
            writer.newLine();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error writing to file", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

