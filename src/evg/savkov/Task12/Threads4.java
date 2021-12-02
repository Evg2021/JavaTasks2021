package evg.savkov.Task12;

public class Threads4 {
    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread4();
        Thread threadB = new Thread4();
        threadA.start();
        threadB.start();
    }
}
class Thread4 extends Thread {
    public final static Object lock = new Object();
    static volatile int counter = 0;

    @Override
    public void run() {
        synchronized (lock) {
            while (counter <= 100) {
                System.out.println(Thread.currentThread().getName() + " выводит " + counter);
                counter++;
                lock.notify();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lock.notifyAll();
        }
    }
}