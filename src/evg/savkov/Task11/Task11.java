package evg.savkov.Task11;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task11 {
    public static void main(String[] args) {
        //ЗАДАНИЕ 01. Написать метод, который читает текстовый файл и возвращает его в виде списка строк.
        readFiletxt();
        //ЗАДАНИЕ 02. Написать метод, который записывает в файл строку, переданную параметром.
        writeFiletxt();

        //ЗАДАНИЕ 03. Используя решение 1 и 2, напишите метод, который склеивает два текстовых файла один.
        mergeTwoFilestxt();

        //ЗАДАНИЕ 04. Написать метод для копирования файла (побайтно, или массивами байт).
        copyFiletxt();

        //ЗАДАНИЕ 05. Написать метод, который в каталоге ищет файлы, в имени которых содержится
        //  определенная строка, и который возвращает список имен таких файлов.
        findFileNameText();

        //ЗАДАНИЕ 06. Написать метод, который в каталоге ищет текстовые файлы,содержавшие определенную строку.
        // Возвращает список имен таких файлов. (FilenameFilter)
        findFileText();
    }

    public static void readFiletxt(){
        //ЗАДАНИЕ 01. Написать метод, который читает текстовый файл и возвращает его в виде списка строк.
        String readText = readFileStr("src/evg/savkov/Task11/TXT/text.txt");
        System.out.println("Текст: \n"+ readText);
    }
    public static void writeFiletxt(){
        //ЗАДАНИЕ 02. Написать метод, который записывает в файл строку, переданную параметром.
        if(writeFileStr("src/evg/savkov/Task11/TXT/textnew.txt","Привет, Студент!")){
            System.out.println("Строка записана в файл!");
        }
    }
    public static boolean writeFileStr(String nameFile,String text){
        try(FileWriter writer = new FileWriter(nameFile, false))
        {
            writer.write(text);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }
    public static String readFileStr(String nameFile){
        String textRead = "";
        try(FileReader reader = new FileReader(nameFile))
        {
            int c;
            while((c=reader.read())!=-1){
                textRead += (char)c;
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return textRead;
    }

    public static void mergeTwoFilestxt(){
        //ЗАДАНИЕ 03. Используя решение 1 и 2, напишите метод, который склеивает два текстовых файла один.
        mergeTwoFiles("src/evg/savkov/Task11/TXT/mergeFile.txt",
                "src/evg/savkov/Task11/TXT/text.txt", "src/evg/savkov/Task11/TXT/text1.txt");
        String readText = readFileStr("src/evg/savkov/Task11/TXT/mergeFile.txt");
        System.out.println("Текст: \n"+ readText);

    }
    public static boolean mergeTwoFiles(String nameNewFile,
                                        String nameFile1,
                                        String nameFile2){
        String newText = readFileStr(nameFile1) + "\n"  + readFileStr(nameFile2);
        if(writeFileStr(nameNewFile,
                newText)){
            System.out.println("Склеили удачно!");
            return true;
        }
        else {
            return false;
        }
    }

    public static void copyFiletxt(){
        //ЗАДАНИЕ 04. Написать метод для копирования файла (побайтно, или массивами байт).
        String nameOldFile = "src/evg/savkov/Task11/TXT/text.txt";
        String nameNewFile = "src/evg/savkov/Task11/TXT/newText.txt";
        copyFiletxt(nameOldFile,nameNewFile);
    }
    public static void copyFiletxt(String nameOldFile, String nameNewFile){
            try(FileInputStream fin=new FileInputStream(nameOldFile);
            FileOutputStream fos=new FileOutputStream(nameNewFile))
        {
            byte[] buffer = new byte[fin.available()];
            fin.read(buffer, 0, buffer.length);
            fos.write(buffer, 0, buffer.length);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void findFileNameText(){
        //ЗАДАНИЕ 05. Написать метод, который в каталоге ищет файлы, в имени которых содержится определенная
        //  строка, и который возвращает список имен таких файлов.
        String nameFind = "text";
        String nameCatalog = "TXT";
        List<String> findFiles= findFileNameText(nameCatalog, nameFind);

        System.out.println("В папке " + nameCatalog + " есть " + "\""+nameFind+"\"");
        for (String file : findFiles) {
            System.out.println("\t> "+ file + ";");
        }
    }
    public static List<String> findFileNameText(String nameCatalog,String nameFindFile){
        File dir = new File(nameCatalog);
        List<String> files = new ArrayList<>();
        if(dir.isDirectory())
        {
            for(File item : dir.listFiles()){
                if(!item.isDirectory()){
                    if(item.getName().toLowerCase().contains(nameFindFile.toLowerCase())) {
                        files.add(item.getName());
                    }
                }
            }
        }
        return files;
    }

    public static void findFileText(){
        //ЗАДАНИЕ 06. Написать метод, который в каталоге ищет текстовые файлы,содержавшие определенную строку.
        // Возвращает список имен таких файлов.(FilenameFilter)
        String nameCatalog = "TXT";
        String findText = "Привет, Студент!";
        List<String> findFiles = findFileText(nameCatalog,findText);

        System.out.println("Такой вот текст: \"" + findText+"\"");
        for (String file : findFiles) {
            System.out.println("\t> "+ file + ";");
        }

    }
    public static List<String>  findFileText(String nameCatalog, String findText){

        List<String> files = findFileNameText(nameCatalog,"");
        List<String> filesOnlyFind = new ArrayList<>();
        for (int i = 0; i < files.size(); i++) {
            String readText = readFileStr(nameCatalog + "//" + files.get(i));
            if(readText.toLowerCase().contains(findText.toLowerCase())) {
                filesOnlyFind.add(files.get(i));
            }
        }
        return filesOnlyFind;
    }
}
