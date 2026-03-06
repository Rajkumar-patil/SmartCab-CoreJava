package CarAddedSystem;

public class Car {
    private String CarName;
    private int CarNumber;
    private boolean isbooked=false;

    Car(String CarName,int CarNumber){
        this.CarName=CarName;
        this.CarNumber=CarNumber;

    }

    public String getCarName() {

        return CarName;
    }

    public int getCarNumber() {

        return CarNumber;
    }

    public void setCarName(String carName) {
        if(carName != null && !carName.isEmpty()){
            this.CarName = carName;
        } else {
            System.out.println("Invalid car name!");
        }
    }

    public void setCarNumber(int carNumber){
        if(carNumber>0 && carNumber<=9999){
           this.CarNumber=carNumber;
        }else {
            System.out.println("Invalid car number! It must be between 1 and 9999.");
        }
    }

    public boolean isIsbooked(){

        return isbooked;
    }

    public  void setIsbooked(boolean booked){

        this.isbooked=booked;
    }
    // CarAddedSystem.Car.java

    @Override
    public String toString() {
        return "Car name: "+CarName + " | "+"Car number: " +CarNumber+ " | ";
    }


}
