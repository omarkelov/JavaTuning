public class TransactionProcessor {

    public void processTransaction(int txNum) throws Exception {
        System.err.println("Processing tx: " + txNum);
        int sleep = (int) (Math.random() * 1000);
        Thread.sleep(sleep);
        System.err.printf("tx: %d completed%n", txNum);
    }

    public static void main(String[] args) throws Exception {
        TransactionProcessor tp = new TransactionProcessor();
        for (int i = 0; i < 10; ++i) {
            tp.processTransaction(i);
        }
    }
}
