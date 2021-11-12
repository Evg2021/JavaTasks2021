package evg.savkov.Task10;

import java.util.*;

public class Task10 {
    public static void main(String[] args) {
        Task101();
        Task102();
        Task103();
        Task104();

    }
    private static void Task101() {
        List<Object> objects = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            for (int j = 5; j < 7; j++) {
                objects.add(j);
            }
            objects.add(i);
        }
        System.out.printf("1.\tНаписать метод, который на входе получает коллекцию объектов, а возвращает коллекцию уже " +
                "без дубликатов. Для решения этой задачи пригодится Set.\nПолучаем коллекцию объектов: %s\n", objects);
        System.out.printf("Возвращаем коллекцию без дубликатов: %s\n", RemoveDuplicate(objects));

    }
    private static void Task102() {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        long start, end, n;

        start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            arrayList.add((int) (Math.random() * 10));
        }
        end = System.currentTimeMillis();
        System.out.printf("\n2.\tНапишите метод, который добавляет 1млн элементов в ArrayList и LinkedList. " +
                "Напишите метод, который выбирает из заполненного списка элемент наугад 100000 раз. " +
                "Замерьте время, которое потрачено на это.\nВремя заполнения ArrayList: %d мс.\n", end - start);

        start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            linkedList.add((int) (Math.random() * 10));
        }
        end = System.currentTimeMillis();
        System.out.printf("Потрачено время LinkedList: %d мс.\n", end - start);

        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            n = arrayList.get((int) (Math.random() * 1000000));
        }
        end = System.currentTimeMillis();
        System.out.printf("Потрачено время ArrayList: %d мс.\n", end - start);

        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            n = linkedList.get((int) (Math.random() * 100000));
        }
        end = System.currentTimeMillis();
        System.out.printf("Потрачено время LinkedList: %d мс.\n", end - start);

    }
    private static void Task103() {
        Scanner scanner = new Scanner(System.in);
        Map<User, Integer> map = new HashMap<>();
        map.put(new User("Витя"), (int)(Math.random() * 100));
        map.put(new User("Коля"), (int)(Math.random() * 100));
        map.put(new User("Петя"), (int)(Math.random() * 100));
        map.put(new User("Дима"), (int)(Math.random() * 100));
        System.out.print("\n3.\tОпишите класс User с одним полем name. Добавьте конструктор, сеттер и геттер." +
                "Создайте Map, в котором для каждого пользователя хранится количество очков, заработанных в " +
                "какой-то игре (Map<User, Integer>).Напишите программу, которая считывает с консоли имя и показывает, " +
                "сколько очков у такого пользователя. Сами данные можно добавить в Map при создании или сгенерировать" +
                " случайно.\nВведите Ваше имя: ");
        String name = scanner.nextLine();

        for (var entry : map.entrySet()) {
                if (entry.getKey().getName().equals(name)) {
                System.out.printf("Результат: %d \n", entry.getValue());
                return;
            }
        }
        System.out.println("нет такого!");
    }

    private static void Task104() {
        Integer[] array = new Integer[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 10);
        }
        System.out.printf("\n4.\tМетод получает на вход массив элементов типа К. " +
                "Вернуть нужно объект Map<K, Integer>, где K — Значение из массива, а Integer\n" +
                "количество вхождений в массив:\n" +
                "\n" + "<K> Map<K, Integer> arrayToMap(K[] ks);\n. Генерируем массив:\n%s\n", Arrays.toString(array));

        for (var element : ArrayToMap(array).entrySet()){
            System.out.printf("Значение из массива %d имеет %d вхождений.\n", element.getKey(), element.getValue());
        }

    }

    private static Set<Object> RemoveDuplicate(List<Object> objects){
        return new HashSet<>(objects);
    }

    public static <K> Map<K, Integer> ArrayToMap(K[] list) {
        Map<K, Integer> map = new HashMap<K, Integer>();
        int count;
        for (int i = 0; i < list.length; i++) {
            count = 0;
            for (int j = 0; j < list.length; j++) {
                if (list[i] == list[j]) count++;
            }
            map.put(list[i], count);
        }
        return map;
    }

    static class User {
        private String name;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

}
