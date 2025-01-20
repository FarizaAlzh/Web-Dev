package launcher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import frames.AdminFrame;
import frames.ManagerFrame;
import frames.NewUser;
import frames.StudentFrame;
import frames.TeacherFrame;
public class App {
    public static void main(String[] args) {
        JLabel loginLabel = new JLabel("Login:");
        JLabel passwordLabel = new JLabel("Password:");
        JTextField loginField = new JTextField();
        JTextField passwordField = new JTextField();
        JButton loginButton = new JButton("Log In");
        JButton registrateLoginButton = new JButton("Registrate");
        JFrame login_frame = new JFrame("Login Window");
        ImageIcon backgroundIcon = new ImageIcon("result_bg_panel (1).jpg");
		JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setBounds(0, 0, login_frame.getWidth(), login_frame.getHeight());
        login_frame.setContentPane(backgroundLabel);
        login_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login_frame.setLayout(null);
        login_frame.setBounds(400, 200, 500, 300);

        loginLabel.setBounds(50, 50, 100, 30);
        loginField.setBounds(150, 50, 250, 30);
        passwordLabel.setBounds(50, 100, 100, 30);
        passwordField.setBounds(150, 100, 250, 30);
        loginButton.setBounds(150, 150, 200, 50);

        login_frame.add(loginLabel);
        login_frame.add(loginField);
        login_frame.add(passwordLabel);
        login_frame.add(passwordField);
        login_frame.add(loginButton);
        login_frame.setVisible(true);
        login_frame.setResizable(false);

        loginButton.addActionListener(e -> {
            boolean try_again = true;
            List<String> userDetails = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader("login_password.txt"))) {
                String line;

                while ((line = reader.readLine()) != null) {
                    String[] credentials = line.split(":");
                    if (credentials.length < 7) {
                        System.err.println("Invalid line format: " + line);
                        continue;
                    }

                    String fileLogin = credentials[0].trim();
                    String filePassword = credentials[1].trim();
                    String fileRole = credentials[2].trim();
                    String fileType = credentials[3].trim();
                    String fileFirstName = credentials[4].trim();
                    String fileLastName = credentials[5].trim();
                    String ID = credentials[6].trim();
                    if (loginField.getText().trim().equals(fileLogin) &&
                        passwordField.getText().trim().equals(filePassword)) {
                        login_frame.setVisible(false);

                        if (fileRole.equals("Student")) {
                            StudentFrame studentMainFrame = new StudentFrame(fileFirstName, fileLastName, ID, fileLogin);
                        } else if (fileRole.equals("Admin")) {
                            AdminFrame adminFrame = new AdminFrame();
                        } else if (fileRole.equals("Teacher")) {
                            TeacherFrame teacherFrame = new TeacherFrame(fileFirstName, fileLastName, ID, fileLogin);
                        }
                        else if (fileRole.equals("Manager")) {
                        ManagerFrame teacherFrame = new ManagerFrame(fileFirstName, fileLastName, ID);
                        }

                        try_again = false;
                        userDetails.add(fileLogin);
                        userDetails.add(fileRole);
                        userDetails.add(fileType);
                        userDetails.add(fileFirstName);
                        userDetails.add(fileLastName);

                        System.out.println("User details:");
                        System.out.println("Login: " + fileLogin);
                        System.out.println("Role: " + fileRole);
                        System.out.println("Type: " + fileType);
                        System.out.println("First Name: " + fileFirstName);
                        System.out.println("Last Name: " + fileLastName);

                        break;
                    }
                }
                if (try_again) {
                    JOptionPane.showMessageDialog(login_frame,
                        "Invalid login or password. Try again.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(login_frame,
                    "Error reading file.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        });
        registrateLoginButton.addActionListener(e -> {
            try {
                NewUser user = new NewUser();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
       
    }
}


