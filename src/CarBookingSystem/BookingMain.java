package CarBookingSystem;

import CarAddedSystem.Car;
import CarAddedSystem.CarAddSystem;

public class BookingMain extends BookingSystem {

    private CarAddSystem carAddSystem;

    public BookingMain(CarAddSystem carAddSystem){
        this.carAddSystem = carAddSystem;
    }

    @Override
    public void showAllCars(){
        carAddSystem.showCar();
    }

    @Override
    public void bookCar(String name,int number){
        boolean found=false;
        for(Car car:carAddSystem.carList){
            if(car.getCarName().equals(name) && car.getCarNumber()==number){
                car.setIsbooked(true);
                System.out.println("Car Booked Successfully!");
                found=true;
                break;
            }
        }
        if(!found){
            System.out.println("Car name and number invalid");
        }
    }

    @Override
    public void showAllBookedCars(){
        boolean anyBooked=false;
        for(Car car:carAddSystem.carList){
            if(car.isIsbooked()){
                System.out.println(car);
                anyBooked=true;
            }
        }
        if(!anyBooked){
            System.out.println("No cars booked");
        }
    }
}