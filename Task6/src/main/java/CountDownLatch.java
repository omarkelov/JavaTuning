public class CountDownLatch {

    private int count;

    public CountDownLatch(int count) {
        this.count = count;
    }

    public void await() throws InterruptedException {
        synchronized(this) {
            if (count > 0) {
                wait();
            }
        }
    }

    public void countDown() {
        synchronized(this) {
            if (--count == 0) {
                notifyAll();
            }
        }
    }
}
