package frames;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GetMessageFrame extends JFrame {
    private JTextArea messagesArea;

    public GetMessageFrame(String recipientID) {
        this.setBounds(100, 100, 500, 500);
        ImageIcon backgroundIcon = new ImageIcon("result_bg_panel (1).jpg");
		JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
        this.setContentPane(backgroundLabel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
        this.setResizable(false);

        JLabel messagesLabel = new JLabel("Messages for " + recipientID + ":");
        messagesLabel.setBounds(20, 20, 300, 30);
        this.add(messagesLabel);

        messagesArea = new JTextArea();
        messagesArea.setBounds(20, 60, 440, 380);
        messagesArea.setEditable(false);
        this.add(messagesArea);

        loadMessages(recipientID);
    }

    private void loadMessages(String recipientID) {
        List<String> messages = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("messages.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 4 && parts[3].equals(recipientID)) {
                    messages.add(parts[1] + " (" + parts[0] + ") -> " + parts[2]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (messages.isEmpty()) {
            messagesArea.setText("No messages found.");
        } else {
            for (String message : messages) {
                messagesArea.append(message + "\n");
            }
        }
    }
}


