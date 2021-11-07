package evg.savkov.Task5;

import java.util.Random;

public class Vector {
    private int x;
    private int y;
    private int z;

    public Vector() {
    }

    // конструктор с параметрами в виде списка координат x,y,z
    public Vector(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    //метод, вычисляющий длину вектора. Корень посчитаем с помощью Math.sqrt()
    public double vectorLength(Vector vector) {
        double length = Math.sqrt(vector.x * vector.x + vector.y * vector.y + vector.z * vector.z);
        return Math.abs(length);
    }

    //метод, вычисляющий скалярное произведедние
    public double scalarMultiply(Vector vector) {
        return this.x * vector.x + this.y * vector.y + this.z * vector.z;
    }

    //новый вектор как векторное произведение
    public Vector vectorMultiply(Vector vector) {
        return new Vector(this.y * vector.z - this.z * vector.y, this.z * vector.x - this.x * vector.z, this.x * vector.y - this.y * vector.x);
    }


    //угол между векторами (или косинус угла):косинус удга между векторами равен скалярному произведению
    //векторов, деленному на произведение модулей (длин) векторов
    public double angleBetweenVectors(Vector vector) {
        Vector a = this;
        Vector b = vector;
        double lengthA = Math.abs(vectorLength(a));
        double lengthB = Math.abs(vectorLength(b));
        return a.scalarMultiply(b) / (lengthA * lengthB);
    }

    //метод для суммы.
    public Vector sumVectors(Vector vector) {
        return new Vector(this.x + vector.x, this.y + vector.y, this.z + vector.z);
    }

    //метод для разницы.
    public Vector subtractVectors(Vector vector) {
        return new Vector(this.x - vector.x, this.y - vector.y, this.z - vector.z);
    }

    //статический метод, который принимает целое число N и возвращающий массив случайных векторов размером N.
    public final Vector[] randomVectors() {
        Random random = new Random();
        Vector[] vectors = new Vector[random.nextInt(1, 5)];
        for (int i = 0; i <vectors.length; i++) {
            vectors[i] = new Vector(random.nextInt(-50, 50), random.nextInt(-50, 50), random.nextInt(-50, 50));
        }
        return vectors;
    }


    public static void print(Vector[] vectors) {
        for (Vector vector : vectors) {
            System.out.println(vector.toString());
        }
    }
}
