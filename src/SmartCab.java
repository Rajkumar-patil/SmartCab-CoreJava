import CarAddedSystem.Authentication;
import CarAddedSystem.CarAddSystem;
import CarBookingSystem.AuthenticationUser;
import CarBookingSystem.BookingMain;


import java.util.Scanner;

public class SmartCab {

    Scanner sc = new Scanner(System.in);

    Authentication ownerAuth = new Authentication();
    AuthenticationUser userAuth = new AuthenticationUser();
    CarAddSystem carAddSystem = new CarAddSystem();
    BookingMain bookingMain = new BookingMain(carAddSystem);

    public static void main(String[] args) {

        SmartCab app = new SmartCab();
        app.start();

    }

    public void start() {

        while (true) {

            System.out.println("------------Welcome to SmartCab App------------");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            System.out.print("please Enter your choice: ");
            int ch = ownerAuth.getvalidInput();

            switch (ch) {

                case 1:
                    register();
                    break;

                case 2:
                    login();
                    break;

                case 3:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice");

            }

        }

    }

    // ---------------- REGISTER ----------------

    public void register() {



        System.out.println("\n===== SmartCab Registration =====");
        System.out.println("1.  Car Owner  (Provide cars for rent)");
        System.out.println("2. Traveller  (Rent a car)");
        System.out.println("==================================");

        System.out.print("please Enter your choice: ");
        int ch1 = ownerAuth.getvalidInput();

        switch (ch1) {

            case 1:
                carOwnerRegister();
                break;

            case 2:
                travellerRegister();
                break;

            default:
                System.out.println("Invalid option");

        }

    }

    public void carOwnerRegister() {

        System.out.println("Enter username:");
        String username = sc.next();

        System.out.println("Enter password:");
        String password = sc.next();

        ownerAuth.register(username, password);

    }

    public void travellerRegister() {

        System.out.println("Enter username:");
        String username = sc.next();

        System.out.println("Enter password:");
        String password = sc.next();

        userAuth.register(username, password);

    }

    // ---------------- LOGIN ----------------

    public void login() {

        System.out.println("Login your Account:");

        System.out.println("------------- Login ---------------");
        System.out.println("1. Login as Car Owner");
        System.out.println("2. Login as Traveller");
        System.out.println("-----------------------------------");

        System.out.print("please Enter your choice: ");
        int ch2 = ownerAuth.getvalidInput();

        switch (ch2) {

            case 1:
                carOwnerLogin();
                break;

            case 2:
                travellerLogin();
                break;

            default:
                System.out.println("Invalid option");

        }

    }

    public void carOwnerLogin() {

        System.out.println("Enter username:");
        String username = sc.next();

        System.out.println("Enter password:");
        String password = sc.next();

        if (ownerAuth.login(username, password)) {

            System.out.println("Car Owner Login Successful");
            carOwnerMenu();

        } else {

            System.out.println("Invalid credentials");

        }

    }

    public void travellerLogin() {

        System.out.println("Enter username:");
        String username = sc.next();

        System.out.println("Enter password:");
        String password = sc.next();

        if (userAuth.login(username, password)) {

            System.out.println("Traveller Login Successful");
            carUserMenu();

        } else {

            System.out.println("Invalid credentials");

        }

    }


    public void carOwnerMenu() {

        while (true) {

            System.out.println("------ Car Owner Dashboard ------");

            System.out.println("1. Add Car");
            System.out.println("2. Delete Car");
            System.out.println("3. Update Car");
            System.out.println("4. Show Cars");
            System.out.println("5. Logout");

            System.out.print("please Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Enter car name:");
                    String name = sc.next();
                    System.out.println("Enter car number:");
                    int number = ownerAuth.getvalidInput();


                    carAddSystem.addCar(name, number);
                    break;

                case 2:
                    System.out.println("Enter car name:");
                    String delName = sc.next();

                    System.out.println("Enter car number:");
                    int delNumber =  ownerAuth.getvalidInput();

                    carAddSystem.deleteCar(delName, delNumber);
                    break;

                case 3:
                    System.out.println("Enter car number:");
                    int carNumber = ownerAuth.getvalidInput();

                    System.out.println("Enter new car name:");
                    String newName = sc.next();

                    carAddSystem.updateCar(carNumber, newName);
                    break;

                case 4:
                    carAddSystem.showCar();
                    break;

                case 5:
                    System.out.println("Logout successful");
                    return;

                default:
                    System.out.println("Invalid choice");

            }

        }

    }

    public void carUserMenu() {

        while (true) {

            System.out.println("------ Car User Dashboard ------");

            System.out.println("1. Search All Cars");
            System.out.println("2. Book Car");
            System.out.println("3. Show Book Cars");
            System.out.println("4. logout");

            System.out.print("please Enter your choice: ");
            int choice = ownerAuth.getvalidInput();

            switch (choice) {

                case 1:
                    bookingMain.showAllCars();
                    break;

                case 2:
                    System.out.println("Enter car name:");
                    String carname = sc.next();

                    System.out.println("Enter car number:");
                    int carnumber = ownerAuth.getvalidInput();

                    new Thread(() -> {

                        bookingMain.bookCar(carname, carnumber);


                        new Thread(() -> {
                            try {
                                Thread.sleep(1000); // simulate delay
                                System.out.println("Notification: Car " + carname + " booked successfully!");
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }).start();
                    }).start();

                    break;

                case 3:
                    bookingMain.showAllBookedCars();
                    break;

                case 4:
                    System.out.println("Logout successful");
                    return;


                default:
                    System.out.println("Invalid choice");

            }

        }

    }

}