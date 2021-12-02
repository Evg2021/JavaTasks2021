package evg.savkov.Task12;

public class Threads3 {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        for (int i = 0; i < 100; i++) {
            Thread tempThread = new Thread3();
            tempThread.start();
            for (int j = 0; j < 1000; j++) {
                counter.increment();
            }
        }
        System.out.println(counter.getCount());
    }
}
class Thread3 extends Thread {
    @Override
    public void run() {
        super.run();
    }
}

class Counter {
    int count = 0;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}