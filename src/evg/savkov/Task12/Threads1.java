package evg.savkov.Task12;

public class Threads1 {
    public static void main(String[] args) {
        startThreads();
    }

    public static void startThreads() {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j <= 100; j++) {
                    System.out.print(j + " ");
                }
                System.out.println();
            });
            thread.start();
        }
    }
}
