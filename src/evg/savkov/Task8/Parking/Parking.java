package evg.savkov.Task8.Parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    List<Avto> avtos;
    int countLots;
    public Parking(int countLots){
        this.countLots = countLots;
        avtos = new ArrayList<>();
    }
    public void addCar(Avto transport){
        if(avtos.size()>countLots-1){
            System.out.println("Парковка занята!");
            return;
        }
        avtos.add(transport);
    }
    public void printParkingCar(){
        System.out.println("Находится " + avtos.size() + " из " +
                countLots +  " авто");
        for(Avto avto : avtos){
            System.out.println("\t--> " + avto);
        }
    }
}
