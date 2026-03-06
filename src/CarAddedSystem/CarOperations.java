package CarAddedSystem;

public interface CarOperations {

    void addCar(String carName, int carNumber);

    void deleteCar(String carName, int carNumber);

    void updateCar(int carNumber, String newName);

    void showCar();
}