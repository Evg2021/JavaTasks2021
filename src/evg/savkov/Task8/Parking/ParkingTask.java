package evg.savkov.Task8.Parking;

public class ParkingTask {
    public static void main(String[] args) {
        System.out.println("\nНа парковке: ");
        parkingPlace();
    }
    public static void parkingPlace(){
        Parking parking = new Parking(10);
        parking.addCar(new Car("Lexus", 100));
        parking.addCar(new Car("Toyota", 150));
        parking.addCar(new Bike("Yamaha", 75));
        parking.addCar(new Bike("Harley", 80));
        parking.addCar(new Bus("Mercedes", 180));
        parking.addCar(new Bus("ISUZU", 200));
        parking.addCar(new Bus("NEOPLAN", 220));

        parking.printParkingCar();

    }
}
