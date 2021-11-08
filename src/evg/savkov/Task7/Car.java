package evg.savkov.Task7;

public class Car {
    public int weight;
    public String model;
    public char color;
    public float speed;

    public void outPut() {
        System.out.println("Вес " + model + " составляет " + weight + "кг.");
        System.out.println("Цвет машины - " + color + " и ее скорость - " + speed);
    }

    public Car(int w, String m, char c, float s) {
        weight = w;
        model = m;
        color = c;
        speed = s;
    }

    public Car() {}
}
class Truck extends Car {
    public int wheelsCount;
    public int maxWeight;

    public void newWheels(int n) {
        this.wheelsCount = n;
        System.out.println(this.model + " имеет " + wheelsCount + " колес.");
    }

    public Truck(int w, String m, char c, float s, int wheelsCount, int maxWeight) {
        super(w, m, c, s);
        this.wheelsCount = wheelsCount;
        this.maxWeight = maxWeight;
    }
}
