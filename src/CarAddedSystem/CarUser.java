package CarAddedSystem;

public class CarUser {
    private String name;
    private String password;
    private int age;
    private String contact;
    private String email;


    CarUser(String name, String password, int age, String contact, String email){
        this.name=name;
        this.password=password;
        this.age=age;
        this.contact=contact;
        this.email=email;

    }



    public String getName(){

        return name;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public int getAge() {

        return age;
    }

    public void setName(String name){

        this.name=name;
    }
    public void setAge(int age) {

        this.age = age;
    }

    public String getContact() {

        return contact;
    }

    public void setContact(String contact) {

        this.contact = contact;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }



    @Override
    public String toString(){
        return "Car Owner name: "+name+" | "+" age: "+age+" | "+ "Contact: "+contact+ " | "+"emial: "+email;
    }
}
