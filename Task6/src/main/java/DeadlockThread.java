public class DeadlockThread extends Thread {

    private final Object lock;
    private final CountDownLatch countDownLatch;

    public DeadlockThread(Object lock, CountDownLatch countDownLatch) {
        this.lock = lock;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started");

        synchronized(lock) {
            countDownLatch.countDown();
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() + " finished");
    }
}
