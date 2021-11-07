package evg.savkov.Task5;

public class Task5 {
    public static void main(String[] args) {
        // конструктор с параметрами в виде списка координат x,y,z

        Vector vector1 = new Vector(2, 3, 5);
        System.out.println("Вектор: " + vector1.toString());

        System.out.println();

        //метод, вычисляющий длину вектора. Корень посчитаем с помощью Math.sqrt()
        System.out.print("Длина вектора: ");
        System.out.println(vector1.vectorLength(vector1));
        System.out.println();

        //метод, вычисляющий скалярное произведедние
        Vector vector2 = new Vector(7, 3, 18);
        System.out.println("Векторы: ");
        System.out.println("Вектор1: " + vector1.toString());
        System.out.println("Вектор2: " + vector2.toString());
        System.out.print("Скалярное приозведение векторов: ");
        System.out.println(vector1.scalarMultiply(vector2));
        System.out.println();

        //новый вектор как векторное произведение
        System.out.print("Вектроное призведение: ");
        System.out.println(vector1.vectorMultiply(vector2));
        System.out.println();

        //угол между векторами (или косинус угла):косинус удга между векторами равен скалярному произведению
        //векторов, деленному на произведение модулей (длин) векторов
        System.out.print("Угол между векторами: ");
        System.out.println(vector1.angleBetweenVectors(vector2));
        System.out.println();

        //метод для суммы.
        System.out.print("Сумма двух векторов это вектор: ");
        Vector vectorC = vector1.sumVectors(vector2);
        System.out.println(vectorC.toString());
        System.out.println();

        //метод для разницы.
        System.out.print("Разница двух векторов это вектор: ");
        Vector vectorD = vector1.subtractVectors(vector2);
        System.out.println(vectorD.toString());
        System.out.println();

        //статический метод, который принимает целое число N и возвращающий массив случайных векторов размером N.
        System.out.println("Массив случайных векторов: ");
        vector1.print(vector1.randomVectors());

    }
}
