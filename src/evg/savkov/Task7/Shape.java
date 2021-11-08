package evg.savkov.Task7;

import java.util.ArrayList;

public class Shape {
    private double volume;
    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
}
class Pyramid extends Shape {
    private double area;
    private double height;

    public double getArea() {
        return area;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double getVolume() {
        return 1/3.0 * Math.pow(area, 2) * height;
    }
}
class SolidOfRevolution extends Shape{
    private double radius;
    public double getRadius() {
        return radius;
    }
}
class Cylinder extends SolidOfRevolution{
    private double height;
}
class Ball extends SolidOfRevolution{
}

class Box extends Shape {

    public void Box(double volume) {
        this.setVolume(volume);
    }

    private ArrayList<Shape> addedShapes = new ArrayList<>();
    public boolean add(Shape newShape) {
        double newVolume = this.getVolume() - newShape.getVolume();
        if(newVolume > 0 ){
            addedShapes.add(newShape);
            System.out.println("Фигура добавлена в контейнер");
            this.setVolume(newVolume);
            return true;
        } else{
            System.out.println("В контейнере больше нет места");
            return false;
        }
    }
}

