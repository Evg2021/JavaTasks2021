package evg.savkov.Task1;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        System.out.println("Я");
        System.out.println("хорошо");
        System.out.println("знаю");
        System.out.println("Java");

        System.out.println((46 + 10)*(10/3));
        System.out.println((29) * (4) * (-15));

        int number = 10500;
        System.out.println("Result: " + ((number / 10) / 10));

        System.out.println();
        float fNum1 = 3.6F;
        float fNum2 = 4.1F;
        float fNum3 = 5.9F;
        float fResNum = fNum1 * fNum2 * fNum3;

        Scanner input = new Scanner(System.in);
        System.out.println("a: ");
        int a = input.nextInt();
        System.out.println("b: ");
        int b = input.nextInt();
        System.out.println("c: ");
        int c = input.nextInt();

        System.out.println("Result: ");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        System.out.println();
        Scanner scanner = new Scanner(System.in);
        int d = scanner.nextInt();

        if( d % 2 > 0){
            System.out.println("Нечетное");
        }
        if( d % 2 == 0){
            System.out.println("Четное");
            if(d > 100){
                System.out.println("Выход за пределы диапазона");
            }
        }


    }
}
