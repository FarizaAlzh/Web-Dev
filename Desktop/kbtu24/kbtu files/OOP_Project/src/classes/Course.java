package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Course {
    private String name;
    private int credits;
    //  список все курсов
    private static List<Course> courses = new ArrayList<>();
    //for student 
    private List<Student> students; 
    private List<Teacher> teachers;
    private Map<Student, Integer> studentMarks;
    private Map<Teacher, Integer> teacherRatings;
    
    //for manager
    private ArrayList<Teacher> assignedTeachers;


    public Course(String name, int credits) {
        this.name = name;
        this.credits = credits;
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.assignedTeachers = new ArrayList<>();
        this.studentMarks = new HashMap<>();
        this.teacherRatings = new HashMap<>();
        courses.add(this);
       
        
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }
    
    //method 2 in studentInterface
    public void addStudent(Student student) {
    	if(!students.contains(student)) {
    		students.add(student);
    	}
    	else {
    		System.out.println("Student is already registered for this course.");
    	}
    }
    public List<Student> getStudent(){
    	return students;
    }
    
    // method 3 in studentInterface
    public void addTeacher(Teacher teacher) {
    	if(!teachers.contains(teacher)) {
    		teachers.add(teacher);
    	}
    	else {
    		System.out.println("Teacher is already assigned to this course.");	
    	}
    		
    }
    
    public List<Teacher> getTeachers(){
    	return teachers;
    }

	public static List<Course> getCourses() {
		return courses;
	}
	
	// method 4 in studentInterface 
	public Integer getMarks(Student student) {
		return studentMarks.get(student);
	}
	// Добавление оценки студенту
	public void setMarks(Student student,int mark) {
		studentMarks.put(student, mark);
	}
	
	public Map<Student, Integer> getAllMarks(){
		return studentMarks;
	}
	
	// method 6 in studentInterface
	public void setTeacherRating(Teacher teacher, int rating) {
		if(rating >=1 && rating<=10) {
			teacherRatings.put(teacher, rating);
		}
		else {
			System.out.println("Rating must be between 1 and 10.");
		}
	}
	
	public Integer getTeacherRating(Teacher teacher) {
		return teacherRatings.get(teacher);
	}

	public void viewMarks() {
		if(studentMarks.isEmpty()) {
	        System.out.println("No marks available for this course.");
	    } 
		else {
	        System.out.println("Marks for course: " + name);
	        for (Map.Entry<Student, Integer> entry : studentMarks.entrySet()) {
	            System.out.println("Student: " + entry.getKey().get_name() + " - Mark: " + entry.getValue());
	        }
	    }
		
	}
	
	  
}