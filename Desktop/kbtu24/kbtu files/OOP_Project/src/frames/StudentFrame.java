package frames;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import classes.Courses;
import classes.Student;


public class StudentFrame extends JFrame {
	RegistrationFrame registerFrame;
	ScheduleFrame viewLessons;
	public StudentFrame(String FirstName, String LastName,String ID, String Login) {
		JLabel FirstNameLabel = new JLabel("Hello "+FirstName+" "+LastName+"!"+ID);
		FirstNameLabel.setBounds(500, 50, 200, 30);
		ScheduleFrame viewLessons = new ScheduleFrame();
		RateFrame RateTeachersFrame = new RateFrame();
		this.setBounds(20,10,1200,700);
		Student student1 = new Student("hz","hz","hz","hz","23B030301",18,"HZ","IT","IT",2);
		ImageIcon backgroundIcon = new ImageIcon("zaeb.jpg");
		JLabel backgroundLabel = new JLabel(backgroundIcon);
		JMenuBar menuBar = new JMenuBar();
		JMenu transcript = new JMenu("Transcript");
		JMenuItem view_transcript = new JMenuItem("View Transcript");
		JMenuItem register_for_courses = new JMenuItem("Course Registration");
	    JMenu fileMenu = new JMenu("Education");
	    JMenu Teachers = new JMenu("Teachers");
	    JMenu Lessons = new JMenu("Lessons");
	    ImageIcon Lessons_Icon = new ImageIcon("file (7) (1).png");
	    JPanel hiddenPanel = new JPanel();
	    JLabel label = new JLabel(student1.view_courses());
	    JMenu Send = new JMenu("Send");
	    JMenu Organization = new JMenu("Organizations");
	    JMenuItem JoinOrganizations = new JMenuItem("Join Organizations");
	    ImageIcon organize = new ImageIcon("organization-removebg-preview.png");
	    JoinOrganizations.setIcon(organize);
	    
	    JMenuItem MyOrganizations = new JMenuItem("My Organizations");
	    JMenuItem MyCourses = new JMenuItem("My Courses");
	    ImageIcon MyCoursesIcon = new ImageIcon("my_course-removebg-preview.png");
	    MyCourses.setIcon(MyCoursesIcon);
	    fileMenu.add(MyCourses);
	    Organization.add(JoinOrganizations);
	    
	    JMenuItem SendMessage = new JMenuItem("Message");
		JMenuItem GetMessages = new JMenuItem("Get Messages");
		Send.add(SendMessage);
		Send.add(GetMessages);
	    
	    JMenuItem ScheduleItem = new JMenuItem("All Courses");
	    JMenuItem RateTeachers = new JMenuItem("Rates");
	    ImageIcon ScheduleIcon = new ImageIcon("file (1).png");
	    ImageIcon TeacherIcon = new ImageIcon("file (4) (1).png");
	    ImageIcon TransriptIcon = new ImageIcon("Remove background project.png");
	    ImageIcon RegistrationIcon = new ImageIcon("registration_icon.png");
	    JMenuItem ViewLessons = new JMenuItem("Lessons Schedule");
	    JMenuItem ViewMarks = new JMenuItem("Lessons Marks");
	    ImageIcon ViewMYmarks = new ImageIcon("viewMarks-removebg-preview.png");
	    ViewMarks.setIcon(ViewMYmarks);
	    ScheduleItem.setMnemonic(KeyEvent.VK_1);
        ScheduleItem.setIcon(ScheduleIcon);
        RateTeachers.setIcon(TeacherIcon);
        view_transcript.setIcon(TransriptIcon);
        register_for_courses.setIcon(RegistrationIcon);
        ViewLessons.setIcon(Lessons_Icon);
        Lessons.add(ViewLessons);
        Lessons.add(ViewMarks);

        fileMenu.add(ScheduleItem);
        fileMenu.add(register_for_courses);
        Teachers.add(RateTeachers);
        transcript.add(view_transcript);
        JMenu News = new JMenu("News");
		JMenuItem ViewNews = new JMenuItem("View News");
		ImageIcon NewsIcon = new ImageIcon("news-removebg-preview.png");
		ImageIcon GetMessageIcon = new ImageIcon("getMessage-removebg-preview.png");
		GetMessages.setIcon(GetMessageIcon);
		ImageIcon SendMessageIcon = new ImageIcon("message-removebg-preview.png");
		SendMessage.setIcon(SendMessageIcon);
		ViewNews.setIcon(NewsIcon);
		News.add(ViewNews);
		menuBar.add(News);

        menuBar.add(fileMenu);
        menuBar.add(Teachers);
        menuBar.add(transcript);
        menuBar.add(Lessons);
        menuBar.add(Send);
        menuBar.add(Organization);
		backgroundLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
        this.setContentPane(backgroundLabel);
        this.setJMenuBar(menuBar);
        this.add(FirstNameLabel);
		this.setVisible(true);
		
		this.setResizable(false);
		
		Courses course = new Courses("Physical Education", 10, "Site");
		JFrame courses_table_frame = new JFrame();
		courses_table_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		courses_table_frame.setBounds(300,300,800,500);
		
		ScheduleItem.addActionListener(e -> {
        	JTable table = new JTable(course.getData(),course.getColumns());
    		JScrollPane pane = new JScrollPane(table);
    		courses_table_frame.add(pane);
    		courses_table_frame.setVisible(true);
        });
	    JButton ru_button = new JButton("RU");
	    ru_button.setFocusable(false);
		ru_button.setBounds(1000,20,80,40);	
		JButton eng_button = new JButton("ENG");
		eng_button.setFocusable(false);
		eng_button.setBounds(1100,20,80,40);
		this.add(eng_button);
        this.add(ru_button);
		
		ru_button.addActionListener(e -> {
            fileMenu.setText("Образование");
            transcript.setText("Транскрипт");
            Teachers.setText("Учителя");
            RateTeachers.setText("Рейтинги");
            ScheduleItem.setText("Курсы");
            view_transcript.setText("Посмотреть транскрипт");
            Lessons.setText("Расписание Обучающегося");
    		FirstNameLabel.setText("Привет "+FirstName+" "+LastName+"!");
        });
        eng_button.addActionListener(e -> {
            fileMenu.setText("Education");
            transcript.setText("Transcript");
            Teachers.setText("Employees");
            RateTeachers.setText("Rate Teachers");
            ScheduleItem.setText("Courses");
            view_transcript.setText("View Courses");
            Lessons.setText("Lessons");
            FirstNameLabel.setText("Hello "+FirstName+" "+LastName+"!");
        });
        view_transcript.addActionListener(e -> {
			TranscriptFrame frame = new TranscriptFrame();
        });
        register_for_courses.addActionListener(e -> {
        	CourseRegistrationFrame Registration = new CourseRegistrationFrame(ID);
        });
        ViewLessons.addActionListener(e -> {
        	viewLessons.setVisible(true);
        });
        RateTeachers.addActionListener(e -> {
        	RateTeachersFrame.setVisible(true);
        });
        SendMessage.addActionListener(e -> {
            SendMessageFrame sendMessageTo= new SendMessageFrame(ID,FirstName);
        });
        GetMessages.addActionListener(e -> {
            GetMessageFrame getMessages= new GetMessageFrame(ID);
        });
        ViewNews.addActionListener(e -> {
			NewsFrame frame = new NewsFrame();
        });
        JoinOrganizations.addActionListener(e -> {
        	RegisterForOrganizationFrame RegistrationForOrg = new RegisterForOrganizationFrame(ID);
        });
        MyCourses.addActionListener(e -> {
        	MyCoursesFrame ViewMyCourses = new MyCoursesFrame(ID);
        });
        ViewMarks.addActionListener(e -> {
        	ViewMarksFrame viewMarks = new ViewMarksFrame(Login);
        });
	}
}
