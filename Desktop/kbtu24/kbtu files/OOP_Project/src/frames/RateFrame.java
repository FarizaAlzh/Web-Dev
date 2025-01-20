package frames;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RateFrame extends JFrame{
	public RateFrame() {
		ImageIcon backgroundIcon = new ImageIcon("result_bg_panel (1).jpg");
		JLabel backgroundLabel = new JLabel(backgroundIcon);
		backgroundLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
        this.setContentPane(backgroundLabel);
		this.setVisible(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(300,300,500,500);
		this.setResizable(false);
		String[] teachs = {"Izbasar Asylzhan","Dzhanka", "Arnur Kelgenbaev", "Larisa Li Borisovna","Usykin"};
		JComboBox teacher_list = new JComboBox(teachs);
		teacher_list.addActionListener(teacher_list);
		this.setLayout(null);
		teacher_list.setBounds(50,100,400,25);
		this.add(teacher_list);
		ButtonGroup group = new ButtonGroup();
		JButton submitbutton = new JButton("Submit");
		submitbutton.setBounds(200,400,100,50);
		
		JRadioButton button_13 = new JRadioButton("1-3");
		JRadioButton button_37 = new JRadioButton("3-7");
		JRadioButton button_710 = new JRadioButton("7-10");
		
		group.add(button_13);
		group.add(button_37);
		group.add(button_710);
		
		
		JLabel ratingLabel = new JLabel("Select a rating range:");
		ratingLabel.setBounds(150, 250, 300, 30);

		Font labelFont = new Font("Serif", Font.PLAIN, 24);
		ratingLabel.setFont(labelFont);

		this.add(ratingLabel);
		
		button_13.setBounds(125,300,100,50);
		button_13.setFocusable(false);
		
		button_37.setBounds(225,300,100,50);
		button_37.setFocusable(false);
		
		button_710.setBounds(325,300,50,50);
		button_710.setFocusable(false);
		JPanel whiteSquare = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2D = (Graphics2D) g;
                g2D.setStroke(new BasicStroke(4));
            }
        };
        whiteSquare.setBounds(120, 295, 260,60);
        whiteSquare.setBackground(new Color(46,139,87));
		this.add(button_13);
		this.add(button_37);
		this.add(button_710);
		this.add(submitbutton);
		this.add(whiteSquare);
		button_13.addActionListener(e -> {
		    JOptionPane.showMessageDialog(this, 
		        teacher_list.getSelectedItem()+"'s rate is 1-3", 
		        "Rating Selected", 
		        JOptionPane.INFORMATION_MESSAGE);
		});
		button_37.addActionListener(e -> {
		    JOptionPane.showMessageDialog(this, 
		        teacher_list.getSelectedItem()+"'s rate is 3-7", 
		        "Rating Selected", 
		        JOptionPane.INFORMATION_MESSAGE);
		});
		button_710.addActionListener(e -> {
		    JOptionPane.showMessageDialog(this, 
		        teacher_list.getSelectedItem()+"'s rate is 7-10", 
		        "Rating Selected", 
		        JOptionPane.INFORMATION_MESSAGE);
		});
		button_13.setBackground(new java.awt.Color(255, 255, 255)); 
		button_37.setBackground(new java.awt.Color(255, 255, 255));
		button_710.setBackground(new java.awt.Color(255, 255, 255));
		button_13.setForeground(java.awt.Color.BLACK);
		button_37.setForeground(java.awt.Color.BLACK);
		button_710.setForeground(java.awt.Color.BLACK);
		button_13.setBorderPainted(false);
		button_37.setBorderPainted(false);
		button_710.setBorderPainted(false);
		submitbutton.addActionListener(e -> {
			this.setVisible(false);
		});
		this.setVisible(false);
	}
}
