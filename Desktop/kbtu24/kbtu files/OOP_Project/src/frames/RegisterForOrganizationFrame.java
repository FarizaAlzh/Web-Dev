package frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import classes.Student;

public class RegisterForOrganizationFrame extends JFrame {
    public RegisterForOrganizationFrame(String id) {
    	Student student1 = new Student("a_kaliyev", "12345678", "Alpamys", "Kaliyev", "23B01", 18, "a_kaliyev@kbtu.kz", "SITE", "CHS", 2);
    	Student student2 = new Student("f_alzhan", "12345678", "Fariza", "Alzhan", "23B02", 18, "f_alzhan@kbtu.kz", "Oil and Gas", "Managment", 2);
    	Student student3 = new Student("a_kazybek", "12345678", "Abylai", "Kazybek", "23B03", 18, "a_kazybek@kbtu.kz", "BS", "Manager", 2);
    	Student student4 = new Student("m_altynbek", "12345678", "Maksat", "Altynbek", "23B04", 18, "m_altynbek@kbtu.kz", "SITE", "IS", 2);
    	List<Student> students = Arrays.asList(student1, student2,student3,student4);
        this.setTitle("Register for Organization");
        this.setBounds(100, 100, 400, 300);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel label = new JLabel("Select an Organization:");
        label.setBounds(50, 50, 200, 30);
        this.add(label);

        List<String> validOrganizations = Arrays.asList("OSIT", "ARTHOUSE", "FACES");
        JComboBox<String> comboBox = new JComboBox<>(validOrganizations.toArray(new String[0]));
        comboBox.setBounds(50, 100, 300, 30);
        this.add(comboBox);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(150, 200, 100, 30);
        this.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOrganization = (String) comboBox.getSelectedItem();

                for (Student student : students) {
                    if (student.get_id().equals(id)) {
                        if (student.registeredOrganizations.contains(selectedOrganization)) {
                            JOptionPane.showMessageDialog(
                                null,
                                "You are already registered in this organization: " + selectedOrganization,
                                "Info",
                                JOptionPane.INFORMATION_MESSAGE
                            );
                        } else {
                            student.registeredOrganizations.add(selectedOrganization);
                            JOptionPane.showMessageDialog(
                                null,
                                "Successfully registered in: " + selectedOrganization,
                                "Success",
                                JOptionPane.INFORMATION_MESSAGE
                            );
                        }
                        return;
                    }
                }
                JOptionPane.showMessageDialog(
                    null,
                    "No student found with ID: " + id,
                    "Error",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        });

        this.setVisible(true);
    }
}


	

