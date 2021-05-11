public class Main {
    public static void main(String[] args) {
        Object lock = new Object();
        CountDownLatch countDownLatch = new CountDownLatch(2);

        new DeadlockThread(lock, countDownLatch).start();
        new DeadlockThread(lock, countDownLatch).start();
    }
}
