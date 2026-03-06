package CarAddedSystem;
import java.util.ArrayList;
import java.util.List;



    public class CarAddSystem implements  CarOperations {

        public List<Car> carList = new ArrayList<>();

        @Override
        public void addCar(String carName, int carNumber) {
            Car newCar = new Car(carName, carNumber);
            carList.add(newCar);
            System.out.println("Car added successfully!");

        }

        @Override
        public void deleteCar(String carName,int carNumber){
          boolean found=false;
          for(Car car:carList){
              if(car.getCarName().equals(carName) && car.getCarNumber()==carNumber){
                  carList.remove(car);
                  System.out.println("Car delete successfully!!");
                  found=true;
                  break;
              }

          }
          if(!found){
              System.out.println("Car is not availbale!");
          }
        }

        @Override
        public void updateCar(int carNumber,String newName){
           boolean found=false;
            for(Car car:carList){
                if(car.getCarNumber()==carNumber){
                    car.setCarName(newName);
                    System.out.println("Car name update successfully");
                    found=true;
                    break;
                }

            }
            if(!found){
                System.out.println("Car is not found");
            }
        }

        @Override
        public void showCar(){
                if (carList.isEmpty()) {
                    System.out.println("Cars not available");
                }else {
                    for(Car car:carList){
                        System.out.println(car);
                    }
                }
        }

    }

