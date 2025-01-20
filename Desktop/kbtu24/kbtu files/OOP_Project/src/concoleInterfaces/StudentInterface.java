package views;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import classes.Student;



public class StudentInterface {

    private Student student;
    private DataManager dataManager;

    public StudentInterface(DataManager dataManager, Student student){
        this.student = student;
        this.dataManager = dataManager;
    }

    public void startStudentPanel() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while(running) {
            System.out.println("---Student Panel---");
            System.out.println("1. View courses");
            System.out.println("2. Register for courses");
            System.out.println("3. Info about teachers");
            System.out.println("4. View Marks");
            System.out.println("5. View transcript");
            System.out.println("6. Rate teachers");
            System.out.println("7. Get transcript");
            System.out.println("8. Register for organization");
            System.out.println("9. Exit student panel");
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch(choice) {
                    case 1:
                        viewCourses();
                        break;
                    case 2:
                        registerForCourse();
                        break;
                    case 3:
                    	infoAboutTeachers();
                        break;
                    case 4:
                    	viewMarks();
                        break;
                    case 5:
                        viewTranscript();
                        break;
                    case 6:
                        rateTeachers();
                        break;
                    case 7:
                        getTranscript(student);
                        break;
                    case 8:
                        registerForOrganizations();
                        break;
                    case 9:
                        System.out.println("Exiting student panel...");
                        running = false;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
            catch(NumberFormatException e){
                System.out.println("Please enter a valid number.");
            }
        }
    }
   
    // 8 registerForOrganizations
	private void registerForOrganizations() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("--- Available Organizations ---");
		
		StudentOrganizations[] organizations = StudentOrganizations.values();
		for(int i = 0; i < organizations.length; i++){
            System.out.println((i + 1) + ". " + organizations[i]);
        }
		System.out.print("Choose an organization by number: ");
		
		try{
            int choice = Integer.parseInt(scanner.nextLine());
            if(choice > 0 && choice <= organizations.length){
                StudentOrganizations selectedOrganization = organizations[choice - 1];
                student.registerOrganization(selectedOrganization);
            } 
            else{
                System.out.println("Invalid choice. Please choose a valid organization.");
            }
        } 
		catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }
	
	

	// 7 getTranscript 
    public void getTranscript(Student student) {
    	List<Course> registeredCourses = student.getRegisteredCourses();
    	
    	if(registeredCourses.isEmpty()) {
    		System.out.println("Student " + student.getName() + " " + student.getLastName() + " is not registered for any courses.");
            return;
    	}
    	
    	String fileName = student.getName() + "_" + student.getLastName() + "_Transcript.txt";
    	
    	try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
    		writer.write("Transcript for: " + student.getName() + " " + student.getLastName());
            writer.newLine();
            writer.write("--------------------------------------");
            writer.newLine();
            
            for(Course course : registeredCourses) {
            	writer.write("Course: " + course.getName());
                writer.newLine();
                writer.write("Credits: " + course.getCredits());
                writer.newLine();
        
            
            Integer mark = course.getMarks(student);
            if (mark != null) {
                writer.write("Grade: " + mark);
            } 
            else {
                writer.write("No grade available.");
            }
            
            writer.newLine();
            writer.write("--------------------------------------");
            writer.newLine();   
    	}
            System.out.println("Transcript has been saved to file: " + fileName);  
    	}
    	catch(IOException e) {
    		System.out.println("An error occurred while writing the transcript to file: " + e.getMessage());
    	}

    }

	// 6 rateTeachers
    private void rateTeachers(){
        Scanner scanner = new Scanner(System.in);
        List<Course> registeredCourses = student.getRegisteredCourses();
        
        if(registeredCourses.isEmpty()){
            System.out.println("You are not registered for any courses. Unable to rate teachers.");
            return;
        }

        System.out.println("--- Rate Teachers ---");
        for(Course course : registeredCourses){
            System.out.println("Course: " + course.getName());
         
            List<Teacher> teachers = course.getTeachers();
            for(Teacher teacher : teachers){
                System.out.println("Teacher: " + teacher.getName() + " " + teacher.getLastName());
                System.out.print("Rate this teacher (1-10): ");
                
                try{
                    int rating = Integer.parseInt(scanner.nextLine());
                    if(rating >= 1 && rating <= 10){
                        course.setTeacherRating(teacher, rating);
                        System.out.println("Successfully rated teacher.");
                    } 
                    else{
                        System.out.println("Invalid rating. Please enter a number between 1 and 10.");
                    }
                } 
                catch(NumberFormatException e){
                    System.out.println("Please enter a valid number.");
                }
            }
        }
    }


	// 5 ViewTransript 
    private void viewTranscript() {
    	List<Course> registeredCourses = student.getRegisteredCourses();
    	System.out.println("--- Your Transcript ---");
    	
    	if(registeredCourses.isEmpty()) {
    		System.out.println("You are not registered for any courses.");
    		return;
    	}
		for(Course course : registeredCourses) {
			System.out.println("Course: " + course.getName());
			System.out.println("Credits: " + course.getCredits());
			System.out.println("Marks: " + course.getMarks(student));
		}
	}

	// 4 viewMarks
    private void viewMarks(){
        List<Course> registeredCourses = student.getRegisteredCourses();
        System.out.println("--- Your Marks ---");

        if(registeredCourses.isEmpty()){
            System.out.println("You are not registered for any courses.");
            return;
        }

        for(Course course : registeredCourses){
            System.out.println("Course: " + course.getName());

            Integer mark = course.getMarks(student); // Получаем оценку для текущего студента

            if(mark == null){
                System.out.println("No marks available for this course.");
            } 
            else {
                System.out.println("Mark: " + mark);
            }
        }
    }


	// 3 Info about teachers
    private void infoAboutTeachers() {
    	List<Course> courses = Course.getCourses();
    	System.out.println("--- Teacher Information ---");
    	
    	if(courses.isEmpty()) {
    		System.out.println("No courses available to show teachers.");
            return;
    	}
    	
    	for(Course course : courses) {
    		System.out.println("Course: " + course.getName());
    		if(course.getTeachers().isEmpty()) {
    			System.out.println("No teachers assigned to this course.");
    		}
    		else {
    			System.out.println("Teachers:");
    			for(Teacher teacher : course.getTeachers()){
                    System.out.println("- " + teacher.getName() + teacher.getLastName());
                }
    		}
    	}	
		
	}

	//1 viewCourses()
    public void viewCourses() {
    	List <Course> courses = Course.getCourses();
    	System.out.println("---Available Courses---");
    	if(courses.isEmpty()) {
    		System.out.println("No courses available.");
    	}
    	else {
    		for(Course course : courses) {
    			System.out.println(course);
    		}
    	}
    	
    }
    
    //2 registerForCourse()
    public void registerForCourse() {
    	Scanner scanner = new Scanner(System.in);
    	List<Course> courses = Course.getCourses();
    	System.out.println("--- Available Courses ---");
    	
    if(courses.isEmpty()) {
    	System.out.println("No courses available to register");
    	return;
    }
    
    for(int i=0 ; i< courses.size() ; i++) {
    	System.out.println((i+1) + ". " + courses.get(i).getName());
    }
    
    System.out.print("Enter the number of the course you want to register for: ");
    try {
    	int courseIndex = Integer.parseInt(scanner.nextLine()) - 1 ;
    	if(courseIndex >= 0 && courseIndex < courses.size()) {
    		student.registerForCourse(courses.get(courseIndex));
    		System.out.println("Successfully registered for the course: " + courses.get(courseIndex).getName());
    	}
    	else {
    		System.out.println("Invalid course number.");
    	}
    }
    catch(NumberFormatException e){
    	 System.out.println("Please enter a valid number.");
    }
       
    
    

  }
}
