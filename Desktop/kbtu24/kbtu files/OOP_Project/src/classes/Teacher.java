package classes;

import java.util.ArrayList;
import java.util.List;

import enums.TeacherType;

public class Teacher extends Employee{
	
	protected TeacherType type;
	
	private ArrayList<Integer> ratings;
	private List<Course> courses;
	
	public Teacher(String login, String password, String name, String lastName, String id, String email, int age,int salary , TeacherType lector) {
		super(login, password, name, lastName, id, email, age, salary);
		this.type = lector;
		this.ratings = new ArrayList<>();
		this.courses = new ArrayList<>();
	}
	
	public String getName() {
		return super.get_name();
	}
	public String getLastName() {
		return super.getLastName();
	}
	public TeacherType getTeacherType() {
		return type; 
	}

	
	public void addCourse(Course course) {
		if(!courses.contains(course)) {
            courses.add(course);
		}
		else {
			System.out.println("Course " + course.getName() + " is already assigned to the teacher.");
		}
	}
	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}

	public int getSalary() {
		// TODO Auto-generated method stub
		return salary;
	}
}
