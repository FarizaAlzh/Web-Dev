package frames;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NewsFrame extends JFrame {
    public NewsFrame() {
        this.setTitle("News");
        this.setBounds(100, 100, 600, 400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setLayout(null);
        this.setContentPane(layeredPane);
        ImageIcon backgroundIcon = new ImageIcon("result_bg_panel (1).jpg");
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setBounds(0, 0, 600, 400);
        layeredPane.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);
        JPanel newsPanel = new JPanel();
        newsPanel.setBackground(new Color(255, 255, 255, 200)); 
        newsPanel.setLayout(new BoxLayout(newsPanel, BoxLayout.Y_AXIS));
        try (BufferedReader reader = new BufferedReader(new FileReader("News.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] newsData = line.split(":", 2);
                if (newsData.length == 2) {
                    String date = newsData[0].trim();
                    String message = newsData[1].trim();

                    JTextArea newsTextArea = new JTextArea(date + ": " + message);
                    newsTextArea.setLineWrap(true);
                    newsTextArea.setWrapStyleWord(true);
                    newsTextArea.setEditable(false);
                    newsTextArea.setBackground(Color.white);
                    newsTextArea.setForeground(Color.black);
                    newsTextArea.setFont(new Font("Arial", Font.PLAIN, 14));
                    newsTextArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                    newsPanel.add(newsTextArea);
                } else {
                    System.err.println("Invalid news format: " + line);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading news file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        JScrollPane scrollPane = new JScrollPane(newsPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(50, 50, 500, 300);
        layeredPane.add(scrollPane, JLayeredPane.PALETTE_LAYER);

        this.setVisible(true);
    }
}





