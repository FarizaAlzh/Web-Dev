package frames;

import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ManagerFrame extends JFrame{
	public ManagerFrame(String fileFirstName, String fileLastName, String ID) {
		this.setBounds(20,10,1200,700);
		this.setResizable(false);
		this.setTitle("Hello Manager "+fileFirstName+" "+fileLastName+"!");
		ImageIcon backgroundIcon = new ImageIcon("zaeb.jpg");
		JLabel backgroundLabel = new JLabel(backgroundIcon);
		JMenuBar menuBar = new JMenuBar();
		JMenu StudentsMenu = new JMenu("Students");
		JMenu TeachersMenu = new JMenu("Teachers");
		JMenu EmployeesMenu = new JMenu("Employees");
		JMenu Send = new JMenu("Send");
		JMenuItem SendMessage = new JMenuItem("Message");
		JMenuItem GetMessages = new JMenuItem("Get Messages");
		ImageIcon GetMessageIcon = new ImageIcon("getMessage-removebg-preview.png");
		GetMessages.setIcon(GetMessageIcon);
		ImageIcon SendMessageIcon = new ImageIcon("message-removebg-preview.png");
		SendMessage.setIcon(SendMessageIcon);
		JMenu News = new JMenu("News");
		JMenuItem ManageNews = new JMenuItem("Manage News");
		ImageIcon NewsIcon = new ImageIcon("news-removebg-preview.png");
		ManageNews.setIcon(NewsIcon);
		
		News.add(ManageNews);
		menuBar.add(News);
		Send.add(SendMessage);
		Send.add(GetMessages);
		JMenuItem InfoAbStudents = new JMenuItem("Info About Students");
		JMenuItem InfoAbTeachers = new JMenuItem("Info About Teachers");
		JMenuItem CourseAssign = new JMenuItem("Assign Course");
		JMenuItem ViewRequests = new JMenuItem("View Requests");
		StudentsMenu.add(InfoAbStudents);
		TeachersMenu.add(InfoAbTeachers);
		TeachersMenu.add(CourseAssign);
		EmployeesMenu.add(ViewRequests);
		menuBar.add(TeachersMenu);
		menuBar.add(StudentsMenu);
		menuBar.add(EmployeesMenu);
		menuBar.add(Send);
		backgroundLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
        this.setContentPane(backgroundLabel);
        this.setJMenuBar(menuBar);
		this.setVisible(true);
	
		ManageNews.addActionListener(e -> {
			ManageNewsFrame NewsManage = new ManageNewsFrame();
        });
		SendMessage.addActionListener(e -> {
			SendMessageFrame SendMessagefR = new SendMessageFrame(ID,fileFirstName );
        });
		GetMessages.addActionListener(e -> {
			GetMessageFrame SendMessagefR = new GetMessageFrame(ID);
        });
		InfoAbStudents.addActionListener(e -> {
			new ViewAllStudentsFrame();
        });
		InfoAbTeachers.addActionListener(e -> {
			InfoAboutTeachersFrame frameee = new InfoAboutTeachersFrame();
        });
		CourseAssign.addActionListener(e -> {
			new AssignCourses();
        });
		ViewRequests.addActionListener(e -> {
			GetRequestFrame getReqs = new GetRequestFrame();
        });
	}
}
