package evg.savkov.Task9;

import java.util.*;

public class Task9 {
    public static void main(String[] args) {
        Task91();
        Task92();
        Task93();
        Task94();
        Task95();
    }

    private static void Task91() {
        int [][] array = new int[2][3];
        int max = 0;
        try {

            System.out.println("1.Написать метод для поиска наибольшего элемента в двумерном массиве\nДвумерный массив:");
            Random random = new Random();
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    array[i][j] = random.nextInt(100);
                    if (max < array[i][j]) max = array[i][j];
                    System.out.print(array[i][j] + " ");
                }
                System.out.println();
            }
            System.out.printf("Наибольший элемент: %d\n\n", max);
        }
        catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }

    private static void Task92() {


            System.out.print("2 Написать метод, который проверяет, является ли двумерный массив квадратным. \nДан массив: ");
            int[][] array = { { 1, 4, 6, 9 }, { 4, 0, 7, 1 }, { 5, 2, 8, 0 }, { 4, 3, 9, 9 }
            };
            System.out.println(Arrays.deepToString(array));
        try {
            int countRow = array.length;
            int countColumn = array[0].length;

            if (countRow == countColumn) System.out.println("Это двумерный квадратный массив.\n");
            else System.out.println("Это двумерный НЕ квадратный массив.\n");
        }
        catch (Exception error){
            System.out.println(error.getMessage());
        }
    }
    private static void Task93() {
        int [][] array = new int[7][4];
        int maxSummary, result = 0, resMaxSummary = 0;
        try {

            System.out.println("3 Написать метод, который, в двумерном массиве (матрице) ищет строку, сумма\n" +
                    "элементов которой является максимальной среди всех строк матрицы\n.\nДвумерный массив:");
            Random random = new Random();
            for (int i = 0; i < 7; i++) {
                maxSummary = 0;
                for (int j = 0; j < 4; j++) {
                    array[i][j] = random.nextInt((50 - (-50) + 1)) + (-50);
                    maxSummary += array[i][j];
                    System.out.print(array[i][j] + " ");
                }
                System.out.printf(" =%d\n", maxSummary);
                if (resMaxSummary < maxSummary) {
                    resMaxSummary = maxSummary;
                    result = i;
                }
            }
            System.out.printf("Самая большая сумма чисел находится в %d строке : %d\n\n", result + 1, resMaxSummary);
        }
        catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }
    private static void Task94() {
        char [][] array = new char[5][6];
        try {

            System.out.println("4 Двумерный массив MxN заполнить случайными символами алфавита.\nДвумерный массив символов алфавита:");
            Random random = new Random();
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 6; j++) {
                    array[i][j] = (char) (random.nextInt(20) + 'а');
                    System.out.print(array[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }
    private static void Task95() {
        List<Integer> arraySymbol = new ArrayList();
        Random random = new Random();
        try {

            int[] numbers = {5, 4, 0, 7, 9, 6, 8, 32, 14, 10};
            int[] weight = {7, 16, 2, 9, 11, 5, 0, 13, 1, 8};
            System.out.printf("5 Дан массив чисел numbers, и дан массив weight такой же длины. Задача: написать метод, который бы случайно выбирал число из первого массива, которое есть во втором массиве.\nМассив чисел numbers = %s\nМассив weight = %s\n", Arrays.toString(numbers), Arrays.toString(weight));

            for (int number : numbers) {
                for (int i : weight) {
                    if (number == i) {
                        arraySymbol.add(number);
                        break;
                    }
                }
            }
            System.out.printf("Это число первого ряда есть во втором: %d", arraySymbol.get(random.nextInt(arraySymbol.size())));
        }
        catch (Exception error){
            System.out.println(error.getMessage());
        }
    }
}
