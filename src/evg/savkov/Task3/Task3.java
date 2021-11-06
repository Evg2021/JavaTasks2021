package evg.savkov.Task3;

import evg.savkov.Algorithms.SortMerge;

import java.util.Arrays;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        // 1.	Напишите программу, которая проверяет отсортирован ли массив по возрастанию.
        // Если он отсортирован по возрастанию то выводится “OK”, если нет, то будет выводиться текст
        // “Please, try again”
        System.out.println("1. Отсортирован ли массив? ");

        trySortMassive(new int[] {1,2,3,4,5});
        trySortMassive(new int[] {6,3,5,4,1});


        //2.	Напишите программу, которая считывает с клавиатуры длину массива
        // (например, пользователь вводит цифру 4), затем пользователь вводит 4 числа и на новой строке
        // выводится массив из 4 элементов. Пример вывода:
        //   Array length: 4
        //   Numbers of array:
        //   5
        //   6
        //   7
        //   2
        //   Result: [5, 6, 7, 2]
        System.out.println("2. Создание массива через ручной ввод");
        int[] array = createMassive();
        System.out.println("(Введен массив: " + Arrays.toString(array) + ")");

        //3.	Напишите метод, который меняет местами первый и последний элемент массива. Пример вывода:
        //Array 1: [5, 6, 7, 2]
        //Array 2: [2, 6, 7, 5]

        reversEgeValueMassive(new int[] {1,2,3,4,5});

        //4.	Дан массив чисел. Найдите первое уникальное в этом массиве число.
        //Например, для массива [1, 2, 3, 1, 2, 4] это число 3

        firstUniqueValue(new int[] {8,5,3,7,3});

        //5.	Вычислить N-е число Фибоначчи. Не использовать рекурсию и массивы, только циклы
        fibonacciNumber(9);

        //6.	Заполните массив случайным числами и отсортируйте его. Используйте сортировку слиянием.
        sortMerge();

        //7.	***Дан массив и число K. Найдите первые K самых часто встречающихся
        //элементов
        firstMeetsManyNumber();


    }
    public static void trySortMassive(int[] myArray) {
        //1. Отсортирован ли массив?
        System.out.print("(Массив: " + Arrays.toString(myArray) + ")");
        boolean isSortMassive = true;
        for (int i = 0; i < myArray.length - 1; i++) {
            if (myArray[i] > myArray[i + 1]) {
                isSortMassive = false;
                break;
            }
        }
        System.out.print(" Этот массив отсортирован? ");
        if (!isSortMassive) {
            System.out.println("Please, try again");
        } else {
            System.out.println("OK!");
        }
    }
    public static int[] createMassive() {
        //2. Создания массива ручным вводом
        Scanner scanner = new Scanner(System.in);
        System.out.print("Array length: ");
        int size = scanner.nextInt();

        System.out.print("Numbers of array: ");
        int[] myArray = new int[size];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = scanner.nextInt();
        }
        return myArray;
    }

    public static void reversEgeValueMassive(int[] myArray) {
        // 3. Меняем первый и последний элемент
        System.out.println("3. (Массив: " + Arrays.toString(myArray) + ")");

        int temp = myArray[0];
        myArray[0] = myArray[myArray.length - 1];
        myArray[myArray.length - 1] = temp;

        System.out.print("Крайние элементы массива поменялись местами:  ");
        System.out.println("Массив 2: " + Arrays.toString(myArray) + "");
    }

    public static void firstUniqueValue(int[] myArray) {
        // 4. Найдите первое уникальное в этом массиве число
        System.out.println("4. (Массив: " + Arrays.toString(myArray) + ")");

        boolean ifNotUnique = false;
        int valueUnique = 0;
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray.length; j++) {
                if (i == j) {
                    continue;
                }
                if (myArray[i] == myArray[j]) {
                    ifNotUnique = true;
                    break;
                }
            }
            if (!ifNotUnique) {
                valueUnique = myArray[i];
                break;
            }
            ifNotUnique = false;
        }
        if (!ifNotUnique) {
            System.out.println("Первое уникальное в этом массиве число:  " + valueUnique);
        } else {
            System.out.println("Нет уникальных чисел");
        }
    }
    public static void fibonacciNumber(int value) {
        //5. Вычислить число фибоначчи циклом
        long resalt;
        long temp1 = 1, temp2= 1;
        String str = "1";
        for (int i = 0; i <=value; i++) {
            resalt = temp1 + temp2;
            str += ", " + resalt;

            temp1 = temp2;
            temp2 = resalt;
        }
        System.out.println("5. Число Фибаначи в " + value + " последовательности равно: "+ str);
    }
    public static int[] createMassive(int size, int Begin, int End) {
        //авто-генерация массива
        int[] myArray = new int[size];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = ((int) (Math.random() * End) + Begin);
        }
        return myArray;
    }
    public static void sortMerge() {
        //6. Сортировка слиянием
        int[] array = createMassive(20,1,100);
        System.out.println("6. (Массив: " + Arrays.toString(array) + ")");

        //В папке с алгоритмами!
        int[] newArray = SortMerge.sortArray(array);
        System.out.println("Массив после сортировки слиянием: " + Arrays.toString(newArray) + ")");
    }

    public static void firstMeetsManyNumber() {
        //7. Найдите первые K самых часто встречающихся
        //элементов
        int[] array = createMassive(20,1,10);
        System.out.println("7. (Массив: " + Arrays.toString(array) + ")");

        int findNumber =-1;
        int countTempFindNumber;
        int countFindNumber =0;

        for (int i = 0; i < array.length; i++) {
            countTempFindNumber = 0;
            for (int j = 0; j < array.length; j++) {
                if(array[i] ==  array[j]){
                    countTempFindNumber++;
                }
            }
            if(countFindNumber <countTempFindNumber){
                findNumber = array[i];
                countFindNumber = countTempFindNumber;
            }
        }
        System.out.println("\tПервое самое встречающееся число "+ findNumber +
                " встречает " + countFindNumber + " раз.");
    }
}
