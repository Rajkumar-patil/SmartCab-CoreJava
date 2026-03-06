package CarBookingSystem;

import CarAddedSystem.Car;

public abstract class BookingSystem {
    // Abstract methods (what every booking system should do)
    public abstract void showAllCars();
    public abstract void bookCar(String name, int number);
    public abstract void showAllBookedCars();
}