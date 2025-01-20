package frames;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
public class TeacherFrame extends JFrame{
	public TeacherFrame(String FirstName, String LastName, String ID, String login) {
		this.setBounds(20,10,1200,700);
		ImageIcon backgroundIcon = new ImageIcon("zaeb.jpg");
		JLabel backgroundLabel = new JLabel(backgroundIcon);
		JMenuBar menuBar = new JMenuBar();
		JMenu Courses = new JMenu("Courses");
		JMenu Students = new JMenu("Students");
		JMenu Marks = new JMenu("Marks");
		JMenu Send = new JMenu("Send");
		JMenuItem ViewCourses = new JMenuItem("View Courses");
		JMenuItem ManageCourses = new JMenuItem("Manage Courses");
		JMenuItem ViewStudents = new JMenuItem("View Students");
		JMenuItem InfoAbStudents = new JMenuItem("Info About Students");
		JMenuItem PutMarks = new JMenuItem("Put marks");
		JMenuItem SendMessage = new JMenuItem("Message");
		JMenuItem SendComplaint = new JMenuItem("Complaint");
		JMenuItem SendRequests = new JMenuItem("Requests");
		JMenuItem GetMessages = new JMenuItem("Get Messages");
		JMenu News = new JMenu("News");
		JMenuItem ViewNews = new JMenuItem("View News");
		ImageIcon GetMessageIcon = new ImageIcon("getMessage-removebg-preview.png");
		GetMessages.setIcon(GetMessageIcon);
		ImageIcon SendMessageIcon = new ImageIcon("message-removebg-preview.png");
		SendMessage.setIcon(SendMessageIcon);
		News.add(ViewNews);
		menuBar.add(News);
		
		Courses.add(ViewCourses);
		Students.add(InfoAbStudents);
		Send.add(SendMessage);
		Send.add(SendRequests);
		Send.add(SendComplaint);
		Send.add(GetMessages);
		Marks.add(PutMarks);
		menuBar.add(Courses);
		menuBar.add(Students);
		menuBar.add(Marks);
		menuBar.add(Send);
		backgroundLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
        this.setContentPane(backgroundLabel);
        this.setJMenuBar(menuBar);
        this.setResizable(false);
		this.setVisible(true);
		SendMessage.addActionListener(e -> {
            SendMessageFrame sendMessageTo= new SendMessageFrame(ID,FirstName);
        });
        GetMessages.addActionListener(e -> {
            GetMessageFrame getMessages= new GetMessageFrame(ID);
        });
        ViewNews.addActionListener(e -> {
			NewsFrame frame = new NewsFrame();
        });
        PutMarks.addActionListener(e -> {
        	PutMarksFrame putMarks = new PutMarksFrame(login);
        });
        SendRequests.addActionListener(e -> {
        	SendRequestFrame sendFrame = new SendRequestFrame(login);
        });
        InfoAbStudents.addActionListener(e -> {
        	new ViewAllStudentsFrame();
        });
        ViewCourses.addActionListener(e -> {
        	ViewTeacherCoursesFrame viewMyCourses = new ViewTeacherCoursesFrame(login);
        });
        SendComplaint.addActionListener(e -> {
        	SendComplaint sendComplaint = new SendComplaint();
        });
	}
}
