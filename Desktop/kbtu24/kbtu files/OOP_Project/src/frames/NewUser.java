package frames;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class NewUser extends JFrame {
	
	public NewUser() throws IOException{
		ImageIcon backgroundIcon = new ImageIcon("result_bg_panel (1).jpg");
		JLabel backgroundLabel = new JLabel(backgroundIcon);
		backgroundLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
        this.setContentPane(backgroundLabel);
		boolean combobool = true;
		FileWriter writer = new FileWriter("login_password.txt",true);
		JTextField IDtextField = new JTextField();
		String ChosenType;
		JLabel loginLabel = new JLabel("Login:");
        JLabel passwordLabel = new JLabel("Password:");
        JLabel FirstNameLabel = new JLabel("First Name:");
        JLabel LastNameLabel = new JLabel("Last Name:");
        JLabel ID = new JLabel("Users ID:");
        JTextField loginField = new JTextField();
        JTextField passwordField = new JTextField();
        JTextField FNameField = new JTextField();
        JTextField LNameField = new JTextField();
        JButton registrateButton = new JButton("Registrate");
        String[] roles = {"","Student","Manager", "Admin", "Finance Manager","Teacher"};
        String[] STypes = {"Bachelor", "Master","PHD"};
        String[] MTypes = {"Department", "OR"};
        String[] TTypes = {"Tutor", "Lector","Professor"};
        JComboBox Roles = new JComboBox(roles);
        JComboBox StudentTypes = new JComboBox(STypes);
        JComboBox ManagerTypes = new JComboBox(MTypes);
        JComboBox TeacherTypes = new JComboBox(TTypes);
        
        Roles.addActionListener(Roles);
        Roles.setBounds(40,400,100,20);
        
        StudentTypes.addActionListener(StudentTypes);
        StudentTypes.setBounds(200,400,100,20);
        
        TeacherTypes.addActionListener(StudentTypes);
        TeacherTypes.setBounds(200,400,100,20);
        
        ManagerTypes.addActionListener(ManagerTypes);
        ManagerTypes.setBounds(200,400,100,20);
        StudentTypes.setVisible(false);
        ManagerTypes.setVisible(false);
        TeacherTypes.setVisible(false);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(400,50,500, 700);
        
        FirstNameLabel.setBounds(50, 100, 100, 30);
        FNameField.setBounds(150, 100, 250, 30);
        
        LastNameLabel.setBounds(50, 150, 100, 30);
        LNameField.setBounds(150, 150, 250, 30);

        loginLabel.setBounds(50, 200, 100, 30);
        loginField.setBounds(150, 200, 250, 30);

        passwordLabel.setBounds(50, 250, 100, 30);
        ID.setBounds(50, 300, 100, 30);
        IDtextField.setBounds(150, 300, 250, 30);
        passwordField.setBounds(150, 250, 250, 30);
        registrateButton.setBounds(150, 600, 200, 50);
        Roles.getSelectedItem();
        this.add(loginLabel);
        this.add(loginField);
        this.add(passwordLabel);
        this.add(passwordField);
        this.add(registrateButton);
        this.add(FirstNameLabel);
        this.add(FNameField);
        this.add(LastNameLabel);
        this.add(LNameField);
        this.setVisible(true);
        this.add(Roles);
        this.add(StudentTypes);
        this.add(ManagerTypes);
        this.add(TeacherTypes);
        this.add(IDtextField);
        this.add(ID);
 
        registrateButton.addActionListener(e -> {
            String chosenRole = (String) Roles.getSelectedItem();
            String chosenType = null;

            if ("Student".equals(chosenRole)) {
                chosenType = (String) StudentTypes.getSelectedItem();
            } else if ("Manager".equals(chosenRole)) {
                chosenType = (String) ManagerTypes.getSelectedItem();
            } else if ("Teacher".equals(chosenRole)) {
                chosenType = (String) TeacherTypes.getSelectedItem();
            }

            if (chosenRole == null || chosenRole.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Выберите роль пользователя!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (chosenType == null) {
                chosenType = "Не выбран тип для роли " + chosenRole;
            }

            JOptionPane.showMessageDialog(
                this, 
                "Роль: " + chosenRole + "\nТип: " + chosenType, 
                "Информация о пользователе", 
                JOptionPane.INFORMATION_MESSAGE
            );
            this.setResizable(false);

            try {
                writer.write("\n" + loginField.getText() + ":" + passwordField.getText() + ":" + chosenRole + ":" + chosenType +
                		":" + FNameField.getText() + ":"+ LNameField.getText()+ ""+ IDtextField.getText());
                writer.flush();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        Roles.addActionListener(e -> {
            String ChosenRole = (String) Roles.getSelectedItem();
            if ("Student".equals(ChosenRole)) {
                StudentTypes.setVisible(true);
                ManagerTypes.setVisible(false);
                TeacherTypes.setVisible(false);
            } else if ("Manager".equals(ChosenRole)) {
                StudentTypes.setVisible(false);
                ManagerTypes.setVisible(true);
                TeacherTypes.setVisible(false);
            } else if ("Teacher".equals(ChosenRole)) {
                StudentTypes.setVisible(false);
                ManagerTypes.setVisible(false);
                TeacherTypes.setVisible(true);
            } else {
                StudentTypes.setVisible(false);
                ManagerTypes.setVisible(false);
                TeacherTypes.setVisible(false);
            }
        });

       
	}
}
