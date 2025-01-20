package frames;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GetRequestFrame extends JFrame {

    public GetRequestFrame() {
        this.setTitle("Request Viewer");
        ImageIcon backgroundIcon = new ImageIcon("result_bg_panel (1).jpg");
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setLayout(new BorderLayout());
        this.setContentPane(backgroundLabel);
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.WHITE);
                g.fillRect(50, 50, 300, 300);
                
                g.setColor(Color.BLACK);
                g.setFont(new Font("Arial", Font.PLAIN, 18));
                
                String text = readRequestFromFile("request.txt");
                if (text != null) {
                    g.drawString(text, 60, 100);
                } else {
                    g.drawString("No data available", 60, 100);
                }
            }
        };

        this.add(panel);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private String readRequestFromFile(String fileName) {
        String login = "";
        String request = "";
        
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            if ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    login = parts[0];
                    request = parts[1];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!login.isEmpty() && !request.isEmpty()) {
            return "Login: " + login + "\nMessage: " + request;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        new GetRequestFrame();
    }
}

