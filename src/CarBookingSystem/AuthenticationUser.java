package CarBookingSystem;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationUser {
    Map<String,String > users1= new HashMap<>();

    public void register(String username,String password){
        if(users1.containsKey(username)){
            System.out.println("username is already exit");
            return;
        }
        users1.put(username,password);
        System.out.println("User register Successfully");
    }

    public boolean login(String username,String password){
        if(users1.containsKey(username)&& users1.get(username).equals(password)){
            return true;
        }
        return false;
    }
}