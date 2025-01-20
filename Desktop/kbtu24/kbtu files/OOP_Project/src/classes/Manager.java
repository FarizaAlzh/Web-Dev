package classes;

import java.util.Date;


import enums.ManagerType;
import enums.TeacherType;
import kbtuSystem.Course;

public class Manager extends Employee {

    private ManagerType managerType;
    

    public Manager(String login, String password, String name, String lastName, String id, String email, int age, int salary, ManagerType selectedManagerType) {
        super(login, password, name, lastName, id, email, age, salary);
      
        this.managerType = selectedManagerType;
        // Здесь, возможно, нужно задать значение
    }

    
    
    public void createCourse(String name, int credits, Date startDate) {
        Course.createCourse(name, credits, startDate);
    }

    public void assignTeacherToCourse(Course course, Teacher teacher) {
        Course.assignTeacher(course, teacher);
    }

    public void listCourses() {
        Course.listCourses();
    }
    

	   public void manageSchedule() {
	        System.out.println("Выберите действие:");
	        System.out.println("1. Просмотреть расписание");
	        System.out.println("2. Добавить занятие");
	        System.out.println("3. Удалить занятие");
	        // Реализуйте ввод пользователя и соответствующую логику
	    }
	    
	    
	    public void manageTeacher() {
	        System.out.println("Выберите действие:");
	        System.out.println("1. Добавить преподавателя");
	        System.out.println("3. Обновить информацию о преподавателе");
	        // Логика взаимодействия с DataManager для изменения данных преподавателей
	    }
	    
    
    
    
}
