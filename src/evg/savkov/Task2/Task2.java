package evg.savkov.Task2;

import java.util.Arrays;
import java.util.Scanner;


public class Task2 {
    public static void main(String[] args)
    {
        //1.Напишите программу, которая выводит на консоль нечетные числа от 1 до 99.
        // Каждое число печатается с новой строки
        counterOdd();

        //2.Напишите программу, которая выводит числа от 1 до 100, которые делятся на 3, 5 и на то и другое (то есть и на 3 и на 5). Пример вывода:
        //
        //	Делится на 3: ….
        //	Делится на 5: ….
        //	Делится на 3 и на 5: ….
        deliatsy3and5();

        //3.Напишите программу, чтобы вычислить сумму двух целых чисел и вернуть true, если сумма равна третьему целому числу. Пример вывода:
        //
        //Введите первое число: 5
        //Введите второе число: 10
        //Введите третье число: 15
        //Результат: true
        sumTwoInt();

        //4.Напишите программу, которая принимает от пользователя три целых числа и возвращает true, если второе число больше первого числа, а третье число больше второго числа. Пример вывода:
        //Введите первое число: 5
        //Введите второе число: 10
        //Введите третье число: 15
        //Результат: true
        comparisonThreeNumbers();

        //5.Напишите программу, чтобы проверить, является ли число 3 как первый или последний элемент массива целых чисел. Длина массива должна быть больше или равна двум. Пример вывода:

        int[] array = { 3, -3, 7, 4, 5, 3 };
        System.out.println("5.Есть массив:  " + Arrays.toString(array));
        System.out.println("\tПроверяем: " + isNumber(array, 3));
        System.out.println();

        //6.Напишите программу, чтобы проверить, что массив содержит число 1 или 3.
        checkMass1and3();
        checkMass1and3();
        checkMass1and3();

    }

    public static void counterOdd()
    {
        //1.выводит на консоль нечетные числа от 1 до 99
        System.out.println("1.Выводим нечетные числа");
        for (int i = 1; i < 100; i++){
            if(i%2 != 0)
            {
                System.out.println(i);
            }
        }
        System.out.println();
    }

    public static void deliatsy3and5()
    {
        //2. числа от 1 до 100, которые делятся на 3, 5 и на то и другое
        System.out.println("2. Делятся на 3, на 5, на оба:");
        String del3 = "";
        String del5 = "";
        String del3and5 = "";
        for (int i = 1; i < 100; i++){
            if(i%3 == 0 && i%5 == 0 )
            {
                del3and5 += i + " ";
            }
            else if(i%3 == 0)
            {
                del3 += i + " ";
            }
            else if(i%5 == 0 )
            {
                del5 += i + " ";
            }
        }
        System.out.println("Делятся на 3:  " + del3);
        System.out.println("Делятся на 5:  " + del5);
        System.out.println("Делятся на 3 и 5:  " + del3and5);
        System.out.println();
    }
    public static void sumTwoInt()
    {
        //3.вычислить сумму двух целых чисел и вернуть true, если сумма равна третьему целому числу
        System.out.println("3. Сумма двух равна третьему:");
        Scanner scanner = new Scanner(System.in);
        System.out.print("а: ");
        int a = scanner.nextInt();
        System.out.print("b: ");
        int b = scanner.nextInt();
        System.out.print("а + b: ");
        int c = scanner.nextInt();
        System.out.println("Итого: " + ((a+b) == c));
    }
    public static void comparisonThreeNumbers()
    {
        //4.три целых числа и возвращает true, если второе число больше первого числа, а третье число больше второго числа
        System.out.println("4.Введите три числа:");
        Scanner scanner = new Scanner(System.in);
        System.out.print("а: ");
        int a = scanner.nextInt();
        System.out.print("b: ");
        int b = scanner.nextInt();
        System.out.print("с: ");
        int c = scanner.nextInt();

        String str = c + ">" + b + ">" +a + ":";
        System.out.println("Итого " + str + (b>a && c>b));
        System.out.println();
    }


    public static boolean isNumber(int[] array, int val) {

        return (array[0] == val || array[array.length-1] == val);
    }


    public static void checkMass1and3()
    {
        //6.проверить, что массив содержит число 1 или 3
        System.out.print("6. Есть массив:  ");
        int size = 5;
        int[] Array = new int[size];
        for (int i = 0; i < Array.length; i++) {
            Array[i] = ((int)(Math.random() * 20)+1);
            System.out.print(Array[i] + " ");
        }
        System.out.println();

        boolean estliNumbers = false;
        for (int j : Array) {
            if (j == 1 || j == 3) {
                estliNumbers = true;
                break;
            }
        }
        System.out.println("\tЕсть ли 1 или 3: " + estliNumbers);
    }
}
