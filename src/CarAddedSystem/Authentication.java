package CarAddedSystem;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Authentication {

    Scanner sc= new Scanner(System.in);
    Map<String,String > users= new HashMap<>();
    public void register(String username,String password){
        if(users.containsKey(username)){
            System.out.println("username is already exit");
            return;
        }
        users.put(username,password);
        System.out.println("User register Successfully");
    }

    public boolean login(String username,String password){
        if(users.containsKey(username)&& users.get(username).equals(password)){
            return true;
        }
        return false;
    }

    public int getvalidInput(){
            while (true){
                try{
                    int value=sc.nextInt();
                    return value;
                }catch (InputMismatchException e){
                    System.out.println("Invalid input! please enter numbers only.");
                    sc.next();
                }
            }
    }
}
