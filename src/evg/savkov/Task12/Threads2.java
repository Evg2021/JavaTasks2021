package evg.savkov.Task12;

public class Threads2 {
    public static void main(String[] args) {
        StatThread();
    }
        public static void StatThread(){
            for (int i = 1; i <= 10; i++) {
                new StatThread("Поток " + i, 150 - i*10).start();
            }
        }
    public static class StatThread extends Thread {
        int interval;

        StatThread(String name, int interval){
            super(name);
            this.interval = interval;
        }

        public void run(){
            System.out.println("Поток " + Thread.currentThread().getName() + " запущен!");
            for (int i = 1; i <= 100 ; i++) {
                try {
                    Thread.sleep(interval);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Поток " + Thread.currentThread().getName() + " завершен!");
        }
    }
}
