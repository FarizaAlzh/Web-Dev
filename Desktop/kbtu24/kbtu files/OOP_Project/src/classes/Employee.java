package classes;

public abstract class Employee extends User {
	
	protected int salary = 0 ;
	

	public Employee(String login, String password, String name, String lastName, String id, String email, int age, int salary) {
		super(login, password, name , lastName, id,age ,email);
		this.salary = 0;
	}

	
	public void getUserInfo() {
		// TODO Auto-generated method stub
		
	}

}
