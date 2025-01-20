package frames;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class SendMessageFrame extends JFrame {
    private JTextField recipientField;
    private JTextField messageField;
    private JButton sendButton;

    public SendMessageFrame(String senderID, String senderName) {
        this.setBounds(100, 100, 500, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        ImageIcon backgroundIcon = new ImageIcon("result_bg_panel (1).jpg");
		JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
        this.setContentPane(backgroundLabel);
        this.setVisible(true);
        this.setResizable(false);

        JLabel recipientLabel = new JLabel("Recipient ID:");
        recipientLabel.setBounds(20, 20, 100, 30);
        this.add(recipientLabel);

        recipientField = new JTextField();
        recipientField.setBounds(130, 20, 300, 30);
        this.add(recipientField);

        JLabel messageLabel = new JLabel("Message:");
        messageLabel.setBounds(20, 70, 100, 30);
        this.add(messageLabel);

        messageField = new JTextField();
        messageField.setBounds(130, 70, 300, 30);
        this.add(messageField);

        sendButton = new JButton("Send");
        sendButton.setBounds(180, 120, 100, 30);
        this.add(sendButton);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String recipientID = recipientField.getText();
                String message = messageField.getText();

                if (!recipientID.isEmpty() && !message.isEmpty()) {
                    writeMessageToFile(senderID, senderName, recipientID, message);
                    JOptionPane.showMessageDialog(null, "Message sent!");
                } else {
                    JOptionPane.showMessageDialog(null, "Please fill all fields.");
                }
            }
        });
    }

    private void writeMessageToFile(String senderID, String senderName, String recipientID, String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("messages.txt", true))) {
            writer.write(senderID + ":" + senderName + ":" + message + ":" + recipientID + ":" + "approved");
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


