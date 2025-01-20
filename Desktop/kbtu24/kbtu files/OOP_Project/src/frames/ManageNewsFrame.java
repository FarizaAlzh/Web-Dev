package frames;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class ManageNewsFrame extends JFrame {
    public ManageNewsFrame() {
        this.setBounds(100, 100, 500, 550);
        this.setTitle("Manage News");
        ImageIcon backgroundIcon = new ImageIcon("result_bg_panel (1).jpg");
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
        this.setContentPane(backgroundLabel);
        JLabel Date = new JLabel("Enter the date:");
        JLabel Info = new JLabel("Enter the info:");
        JTextField DateField = new JTextField();
        JTextArea InfoArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(InfoArea);
        JButton Post = new JButton("Post");
        Post.setBounds(200,450,100,40);
        Post.setFocusable(false);
        this.add(Post);
        Date.setBounds(50, 35, 100, 50);
        Info.setBounds(50, 140, 100, 50);
        DateField.setBounds(140, 50, 200, 25);
        scrollPane.setBounds(50, 180, 400, 250);
        InfoArea.setLineWrap(true);
        InfoArea.setWrapStyleWord(true);
        InfoArea.setMargin(new java.awt.Insets(5, 5, 5, 5));
        this.add(Info);
        this.add(Date);
        this.add(DateField);
        this.add(scrollPane);
        this.setLayout(null);
        this.setVisible(true);
        String filePath = "News.txt";
        Post.addActionListener(e -> {
        	try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
                writer.write(DateField.getText()+":"+InfoArea.getText());
                writer.newLine();
                writer.close();

                JOptionPane.showMessageDialog(this, "News is posted!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
		});
    }
    public static void main(String[] args) {
        new ManageNewsFrame();
    }
}

