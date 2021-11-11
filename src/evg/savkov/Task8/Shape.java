package evg.savkov.Task8;

import java.util.ArrayList;

abstract class Shape {
    private double volume;
    public abstract double getVolume();

    public void setVolume(double volume) {
        this.volume = volume;
    }
}
class Pyramid extends evg.savkov.Task8.Shape {
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
abstract class SolidOfRevolution extends evg.savkov.Task8.Shape {
    private double radius;
    public abstract double getRadius();
}
class Cylinder extends evg.savkov.Task8.SolidOfRevolution {
    private double height;

    @Override
    public double getVolume() {
        return 0;
    }

    @Override
    public double getRadius() {
        return 0;
    }
}
class Ball extends evg.savkov.Task8.SolidOfRevolution {
    @Override
    public double getVolume() {
        return 0;
    }

    @Override
    public double getRadius() {
        return 0;
    }
}

class Box extends evg.savkov.Task8.Shape {

    public void Box(double volume) {
        this.setVolume(volume);
    }

    private ArrayList<evg.savkov.Task8.Shape> addedShapes = new ArrayList<>();
    public boolean add(evg.savkov.Task8.Shape newShape) {
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

    @Override
    public double getVolume() {
        return 0;
    }
}
