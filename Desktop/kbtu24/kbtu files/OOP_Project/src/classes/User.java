package classes;
public  class User {
  private String login;
  private String password;
   private String firstName;
   private String lastName;
   protected String id;
   private int age;
   protected String email;
     
     
    public User(String login , String password, String firstName, String lastName , String id, int age, String email) {
     this.login = login;
     this.password = password;
     this.firstName = firstName;
     this.lastName = lastName;
     this.id = id;
     this.age = age ;
     this.email = email ;
    }

     public String get_password() {
         return password;
     }
     public String get_login() {
         return login;
     }
     public String get_name() {
         return firstName;
     }
     public String getLastName() {
         return lastName;
     }
     public int getAge() {
         return age;
     }
     
}
