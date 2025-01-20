package classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student extends User {
 private String faculty ;
 private String speciality;
 private int yearOfStudy ;
 public String course; 
 public List<String> registeredOrganizations = new ArrayList<>(Arrays.asList("OSIT"));
 public Student(String login, String password, String firstName, String lastName, String id, int age, String email, String faculty, String speciality, int yearOfStudy) {
 super(login, password, firstName, lastName, id, age, email);
 this.faculty = faculty ;
 this.speciality = speciality;
 this.yearOfStudy = yearOfStudy;
 }
 public String view_courses() {
     return course;
    }
 public String get_id() {
	 return id;
 }
 public String getEmail() {
	return email;
}
public String getDepartment() {
	return faculty;
}
public String getSpecialization() {
	return speciality;
}
public int getYear() {
	return yearOfStudy;
}
}


