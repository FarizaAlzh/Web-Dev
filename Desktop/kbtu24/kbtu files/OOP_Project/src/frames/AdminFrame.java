package frames;

import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class AdminFrame extends JFrame{
	public AdminFrame() {
		this.setBounds(20,10,1200,700);
		this.setResizable(false);
		ImageIcon backgroundIcon = new ImageIcon("zaeb.jpg");
		JLabel backgroundLabel = new JLabel(backgroundIcon);
		JMenuBar menuBar = new JMenuBar();
		JMenu UsersMenu = new JMenu("Users");
		JMenu News = new JMenu("News");
		JMenuItem ViewNews = new JMenuItem("View News");
		News.add(ViewNews);
		menuBar.add(News);
		JMenuItem ViewAllUsers = new JMenuItem("All Users");
		JMenuItem AddNewUser = new JMenuItem("Add User");
		JMenuItem DeleteUser = new JMenuItem("Delete User");
		ImageIcon UsersIcon = new ImageIcon("ViewAllUsersIcon.png");
		ImageIcon UserIcon = new ImageIcon("AddUserIcon.png");
		ImageIcon NewsIcon = new ImageIcon("news-removebg-preview.png");
		ViewNews.setIcon(NewsIcon);
		ViewAllUsers.setIcon(UsersIcon);
		AddNewUser.setIcon(UserIcon);
		ImageIcon icon = new ImageIcon("ViewAllUsersIcon.png");
		DeleteUser.setIcon(UserIcon);
		UsersMenu.add(ViewAllUsers);
		UsersMenu.add(AddNewUser);
		UsersMenu.add(DeleteUser);
		menuBar.add(UsersMenu);
		backgroundLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
        this.setContentPane(backgroundLabel);
        this.setJMenuBar(menuBar);
		this.setVisible(true);
		AddNewUser.addActionListener(e -> {
			try {
				NewUser addNewUser = new NewUser();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
        });
		ViewAllUsers.addActionListener(e -> {
			ViewAllUsersFrame ViewUsers = new ViewAllUsersFrame();
        });
		DeleteUser.addActionListener(e -> {
			DeleteUserFrame deleteUser = new DeleteUserFrame();
        });
		ViewNews.addActionListener(e -> {
			NewsFrame frame = new NewsFrame();
        });
	}
}
