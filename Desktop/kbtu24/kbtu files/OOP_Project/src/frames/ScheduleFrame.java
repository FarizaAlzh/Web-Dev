package frames;
import java.awt.*;
import javax.swing.*;
public class ScheduleFrame extends JFrame {
    public ScheduleFrame() {
        this.setBounds(300, 300, 800, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(false);
        ImageIcon backgroundIcon = new ImageIcon("result_bg_panel (1).jpg");
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setBounds(0, 0, 800, 500);
        backgroundLabel.setLayout(null);
        this.add(backgroundLabel);
        JButton ADS_911 = new JButton("АDS "
        		+ "\n345 L");
        ADS_911.setFocusable(false);
        ADS_911.setBounds(52,113,138,77);
        ADS_911.setFont(new Font("Arial", Font.PLAIN, 14));
        JButton DB_1012 = new JButton("Data Base "
        		+ "\n441 L");
        DB_1012.setFocusable(false);
        DB_1012.setBounds(191,152,138,79);
        DB_1012.setFont(new Font("Arial", Font.PLAIN, 14));
        JButton RUS_1415 = new JButton("RUSSIAN "
        		+ "Online");
        RUS_1415.setFocusable(false);
        JButton PHE_1315 = new JButton("ОФП "
        		+ "\n441 L");
        PHE_1315.setBounds(191,272,138,79);
        PHE_1315.setFont(new Font("Arial", Font.PLAIN, 14));
        PHE_1315.setFocusable(false);
        JButton OOP = new JButton("OOP "
        		+ "\n441 L");
        OOP.setBounds(191,392,138,39);
        OOP.setFocusable(false);
        OOP.setFont(new Font("Arial", Font.PLAIN, 14));
        JButton FEE = new JButton("FEE "
        		+ "\n441 L");
        FEE.setBounds(331,192,138,79);
        FEE.setFocusable(false);
        FEE.setFont(new Font("Arial", Font.PLAIN, 14));
        JButton FEE_2 = new JButton("FEE "
        		+ "\n441 L");
        FEE_2.setFocusable(false);
        FEE_2.setBounds(471,112,138,79);
        FEE_2.setFont(new Font("Arial", Font.PLAIN, 14));
        
        JButton Calculus = new JButton("Calculus "
        		+ "\n441 L");
        Calculus.setBounds(611,272,138,79);
        Calculus.setFont(new Font("Arial", Font.PLAIN, 14));
        JPanel whiteSquare = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2D = (Graphics2D) g;
                g2D.setStroke(new BasicStroke(4));
                g2D.setColor(new Color(46,139,87));
                g2D.drawLine(700, 0, 700, 560);
                g2D.drawLine(0, 0, 0, 400);
                g2D.drawLine(0, 0, 730, 0);
                g2D.drawLine(730, 0, 730, 400);
                g2D.drawLine(0, 400, 730, 400);
                g2D.setStroke(new BasicStroke(3));
                g2D.drawLine(0, 40, 730, 40);
                g2D.drawLine(0, 80, 730, 80);
                g2D.drawLine(0, 120, 730, 120);
                g2D.drawLine(0, 160, 730, 160);
                g2D.drawLine(0, 200, 730, 200);
                g2D.drawLine(0, 240, 730, 240);
                g2D.drawLine(0, 280, 730, 280);
                g2D.drawLine(0, 320, 730, 320);
                g2D.drawLine(0, 360, 730, 360);
                g2D.drawLine(140, 0, 140, 400);
                g2D.drawLine(280, 0, 280, 400);
                g2D.drawLine(420, 0, 420, 420);
                g2D.drawLine(560, 0, 560, 560);
            }
        };
        JLabel backgroundText1 = new JLabel("Monday");
        backgroundText1.setFont(new Font("Arial", Font.BOLD, 16));
        backgroundText1.setForeground(Color.black); 
        backgroundText1.setBounds(90, 32, 300, 30); 
        backgroundLabel.add(backgroundText1);
        //////////////////////////////////
        JLabel backgroundText2 = new JLabel("Tuesday");
        backgroundText2.setFont(new Font("Arial", Font.BOLD, 16));
        backgroundText2.setForeground(Color.black); 
        backgroundText2.setBounds(230, 32, 300, 30); 
        backgroundLabel.add(backgroundText2);
        //////////////////////////////////
        JLabel backgroundText3 = new JLabel("Wednesday");
        backgroundText3.setFont(new Font("Arial", Font.BOLD, 16));
        backgroundText3.setForeground(Color.black); 
        backgroundText3.setBounds(360, 32, 300, 30); 
        backgroundLabel.add(backgroundText3);
        //////////////////////////////////
        JLabel backgroundText4 = new JLabel("Thursday");
        backgroundText4.setFont(new Font("Arial", Font.BOLD, 16));
        backgroundText4.setForeground(Color.black); 
        backgroundText4.setBounds(510, 32, 300, 30); 
        backgroundLabel.add(backgroundText4);
        //////////////////////////////////
        JLabel backgroundText5 = new JLabel("Friday");
        backgroundText5.setFont(new Font("Arial", Font.BOLD, 16));
        backgroundText5.setForeground(Color.black); 
        backgroundText5.setBounds(650, 32, 300, 30); 
        backgroundLabel.add(backgroundText5);
        //////////////////////////////////
        ///////////////////////////////////
        JLabel backgroundText8 = new JLabel("08:00");
        backgroundText8.setFont(new Font("Arial", Font.BOLD, 13));
        backgroundText8.setForeground(Color.black); 
        backgroundText8.setBounds(10, 57, 150, 30); 
        backgroundLabel.add(backgroundText8);
        //////////////////////////////////
        JLabel backgroundText9 = new JLabel("09:00");
        backgroundText9.setFont(new Font("Arial", Font.BOLD, 13));
        backgroundText9.setForeground(Color.black); 
        backgroundText9.setBounds(10, 97, 150, 30); 
        backgroundLabel.add(backgroundText9);
        //////////////////////////////////
        JLabel backgroundText10 = new JLabel("10:00");
        backgroundText10.setFont(new Font("Arial", Font.BOLD, 13));
        backgroundText10.setForeground(Color.black); 
        backgroundText10.setBounds(10, 137, 150, 30); 
        backgroundLabel.add(backgroundText10);
        //////////////////////////////////
        JLabel backgroundText11 = new JLabel("11:00");
        backgroundText11.setFont(new Font("Arial", Font.BOLD, 13));
        backgroundText11.setForeground(Color.black); 
        backgroundText11.setBounds(10, 177, 150, 30); 
        backgroundLabel.add(backgroundText11);
        //////////////////////////////////
        JLabel backgroundText12 = new JLabel("12:00");
        backgroundText12.setFont(new Font("Arial", Font.BOLD, 13));
        backgroundText12.setForeground(Color.black); 
        backgroundText12.setBounds(10, 217, 150, 30); 
        backgroundLabel.add(backgroundText12);
        //////////////////////////////////
        JLabel backgroundText13 = new JLabel("13:00");
        backgroundText13.setFont(new Font("Arial", Font.BOLD, 13));
        backgroundText13.setForeground(Color.black); 
        backgroundText13.setBounds(10, 257, 150, 30); 
        backgroundLabel.add(backgroundText13);
        //////////////////////////////////
        JLabel backgroundText14 = new JLabel("14:00");
        backgroundText14.setFont(new Font("Arial", Font.BOLD, 13));
        backgroundText14.setForeground(Color.black); 
        backgroundText14.setBounds(10, 297, 150, 30); 
        backgroundLabel.add(backgroundText14);
        //////////////////////////////////
        JLabel backgroundText15 = new JLabel("15:00");
        backgroundText15.setFont(new Font("Arial", Font.BOLD, 13));
        backgroundText15.setForeground(Color.black); 
        backgroundText15.setBounds(10, 337, 150, 30); 
        backgroundLabel.add(backgroundText15);
        //////////////////////////////////
        JLabel backgroundText16 = new JLabel("16:00");
        backgroundText16.setFont(new Font("Arial", Font.BOLD, 13));
        backgroundText16.setForeground(Color.black); 
        backgroundText16.setBounds(10, 377, 150, 30); 
        backgroundLabel.add(backgroundText16);
        //////////////////////////////////
        JLabel backgroundText17 = new JLabel("17:00");
        backgroundText17.setFont(new Font("Arial", Font.BOLD, 13));
        backgroundText17.setForeground(Color.black); 
        backgroundText17.setBounds(10, 417, 150, 30); 
        backgroundLabel.add(backgroundText17);
        //////////////////////////////////
        JLabel backgroundText18 = new JLabel("18:00");
        backgroundText18.setFont(new Font("Arial", Font.BOLD, 13));
        backgroundText18.setForeground(Color.black); 
        backgroundText18.setBounds(10, 457, 150, 30); 
        backgroundLabel.add(backgroundText18);
        backgroundLabel.add(ADS_911);
        backgroundLabel.add(RUS_1415);
        backgroundLabel.add(DB_1012);
        backgroundLabel.add(PHE_1315);
        backgroundLabel.add(OOP);
        backgroundLabel.add(FEE);
        backgroundLabel.add(FEE_2);
        backgroundLabel.add(Calculus);
        //////////////////////////////////
        whiteSquare.setBounds(50, 32, 700, 400);
        whiteSquare.setBackground(Color.WHITE);
        backgroundLabel.add(whiteSquare);
        //////////////////////
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ScheduleFrame::new);
    }
}
