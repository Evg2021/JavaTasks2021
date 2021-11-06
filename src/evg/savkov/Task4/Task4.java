package evg.savkov.Task4;

import java.util.Arrays;
import java.util.Locale;

public class Task4 {
    public static void main(String[] args) {
      //  1.	Написать метод для поиска самой длинной строки.
      //  String[] fewStrings = { "One", "Three", "Thirteen" };
      // System.out.println(getLongest(fewStrings));

      //  2.	Написать метод, который проверяет является ли слово палиндромом.
      //   «night»
      //   «level»
       /* String srcString21 = "level";
        String srcString22 = "night";
        System.out.println(checkPolindromism(srcString21));
        System.out.println(checkPolindromism(srcString22));

        */

        //3.	Напишите метод, заменяющий в тексте все вхождения слова «бяка» на «[вырезано цензурой]».
        //String toCensor = "какая бяка, бяка на улице, по телеку в новостях бяка";
        //System.out.println(strReplace(toCensor));

        //4.	Имеются две строки. Найти количество вхождений одной (являющейся подстрокой) в другую.
        /*
        String str1 = "how do you do?";
        String str2 = "two beer or not two beer?";
        System.out.println(countSubsOccur(str1, "do"));
        System.out.println(countSubsOccur(str2, "two"));
        System.out.println(countSubsOccur(str2, "beer"));
         */

//       5.	Напишите метод, который инвертирует слова в строке. Предполагается, что в
//       строке нет знаков препинания, и слова разделены пробелами.
//       Sample Output:
//       The given string is:
//       This is a test string
//       The string reversed word by word is:
//       sihT si a tset gnirts

        String src = "This is a test string";

        splitReverseConcatenate(src);

    }

    //1. Написать метод для поиска самой длинной строки.
    public static String getLongest(String[] strings) {
        String longest = "";
        for (String string : strings) {
            if (string.length() > longest.length()) {
                longest = string;
            }
        }
        return longest;
    }
    // 2
    public static String checkPolindromism(String srcString) {
        String polindrom1 = "- это слово является полиндромом.";
        String polindrom2 = "- это слово не является полиндромом.";

        StringBuilder modifiedSb = new StringBuilder(srcString.toUpperCase()
                .replace(",", "")
                .replace(" ", "")
                .replace("-", "")
                .replace(".", "")
                .replace("’", "")
                .trim());

        String s1 = modifiedSb.toString();
        System.out.println(s1);

        StringBuilder mirroredSb = modifiedSb.reverse();
        String s2 = mirroredSb.toString();
        System.out.println(s2);

        return s1.equals(s2) ? polindrom1 : polindrom2;
    }

    //3.	Напишите метод, заменяющий в тексте все вхождения слова «бяка» на «[вырезано цензурой]».
    public static String strReplace (String str) {

        return str.replaceAll("бяка", "[вырезано цензурой]");
    }

    //4.	Имеются две строки. Найти количество вхождений одной (являющейся подстрокой) в другую.
    public static int countSubsOccur (String target, String sub) {

        int nextInd = 0;
        int counter = 0;

        while (target.length() >= sub.length() + nextInd) {
            String tail = target.substring(nextInd);
            if (tail.contains(sub)) {
                counter++;
                int slide = tail.indexOf(sub);
                nextInd += sub.length() + slide;
            } else { break; }
        }
        return counter;
    }

    // 5. Напишите метод, который инвертирует слова в строке. Предполагается, что в
    // строке нет знаков препинания, и слова разделены пробелами.
    public static void splitReverseConcatenate(String str){
        System.out.println("The given string is:\n\t\t" + str);
        String [] temp = str.split(" ");
        //System.out.println(Arrays.toString(temp));
        String output="";
        for (int i = 0; i < temp.length; i++) {
            StringBuilder sb = new StringBuilder(temp[i]);
            temp[i] = sb.reverse().toString();
            output = output.concat(temp[i]).concat(" ");
            //System.out.println(output);
        }
        output.trim();
        System.out.println("The string reversed word by word is:\n\t\t" + output);

    }


}
