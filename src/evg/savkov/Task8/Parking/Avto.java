package evg.savkov.Task8.Parking;

public class Avto {
    protected String name;
    protected int minParking;
    public String getName() {
        return name;
    }
    public Avto(String name,int minParking ){
        this.name = name;
        this.minParking = minParking;
    }

    @Override
    public String toString() {
        return name + ": Располагается " + minParking + " мин.";
    }
}
