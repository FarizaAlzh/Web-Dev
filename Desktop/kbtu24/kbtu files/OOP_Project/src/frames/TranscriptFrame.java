package frames;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
public class TranscriptFrame extends JFrame {
	public TranscriptFrame() {
		JButton download = new JButton("Download");
		download.setFocusable(false);
		download.setPreferredSize(new Dimension(100,50));
		JPanel buttonPanel = new JPanel();
		ImageIcon backgroundIcon = new ImageIcon("result_bg_panel (1).jpg");
		JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
        this.setContentPane(backgroundLabel);
        buttonPanel.add(download);
        
        this.setBounds(300, 300, 900, 300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        this.add(buttonPanel, BorderLayout.SOUTH);
		String[] transcript_columns = {"Cipher","Course name","Credits","ECTS","Rate","GPA"};
		String[][] argss = {{"LAN1183","English Intermediate","6","10","80","3.5"},
				{"STAT2201","Statistics","6","10","70.1","3.5"},
				{"MATH1203","Linear Algebra","6","10","70.1","3.5"},
				{"FUN1105","Physics","6","10","70.1","3.5"},
				{"CSCI1204","Programming Principle","6","10","70.1","3.5"},
				{"CSCI2104","Dara base","6","10","70.1","3.5"},
				{"CSCI2105","Alghoritms and Structures","6","10","70.1","3.5"},
				{"LAN1119","Russian","6","10","70.1","3.5"},
				{"MATH1202","Mathematical analysis","6","10","70.1","3.5"},
				{"PHE101","Physical Education","6","10","70.1","3.5"},
				{"CSCI1102","Discrete Structures","6","10","70.1","3.5"},
				{"HUM1141","Evolution and Global","6","10","70.1","3.5"},
				{"CSCI1126","OOP","6","10","70.1","3.5"}
				};
		JTable transcript_table = new JTable(argss , transcript_columns);
        JScrollPane pane = new JScrollPane(transcript_table);
        this.add(pane);
        
        this.setVisible(true);
	}
}