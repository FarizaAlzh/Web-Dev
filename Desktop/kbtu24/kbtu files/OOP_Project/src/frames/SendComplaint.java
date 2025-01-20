package frames;


import javax.swing.*;
import java.awt.*;

public class SendComplaint extends JFrame {

    JTextField messageField;
    JComboBox levelComplaints;
    JButton sendButton;
    JLabel messageLabel;

    public SendComplaint(){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500,200);
        this.setTitle("WSP");
        this.setLayout(null);
        this.setResizable(false);
        this.setLocation(500, 200);

        String[] levels ={"Low", "Medium", "High"};


        messageLabel = new JLabel("Message");
        messageLabel.setBounds(52, 52, 80, 20);
        messageLabel.setFont(new Font("Dialog", Font.BOLD, 13));


        messageField = new JTextField();
        messageField.setBounds(120, 50, 200, 30);
        messageField.setFont(new Font("Arial", Font.BOLD, 12));



        levelComplaints = new JComboBox(levels);
        levelComplaints.setBounds(210, 105, 75,20);

        sendButton = new JButton("Send");
        sendButton.setBounds(120,105, 65, 20);

        sendButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "You have successfully submitted your complaint", "INFO!!", JOptionPane.INFORMATION_MESSAGE);
        });

        this.add(messageLabel);
        this.add(messageField);
        this.add(sendButton);
        this.add(levelComplaints);
        this.setVisible(true);
    }
}
