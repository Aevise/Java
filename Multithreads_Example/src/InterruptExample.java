import java.math.BigInteger;

public class InterruptExample {
    public static void main(String[] args) {
        Thread thread = new Thread(new BlockingThread());

        //thread.setDaemon(true); mozna stosowac zamiast if w poniższym for'ze
        thread.start();

        thread.interrupt();
    }


    private static class BlockingThread implements Runnable{
        @Override
        public void run() {
            try{
                System.out.println("Sooo sleepy...");
                Thread.sleep(5000000);
            }catch (InterruptedException e){
                System.out.println("Exiting blocked thread!");
            }
        }
    }

    private static class LongComputationTask implements Runnable {
        private BigInteger base;
        private BigInteger power;

        public LongComputationTask(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            System.out.println(base + "^" + power + " = " + pow(base, power));
        }

        private BigInteger pow(BigInteger base, BigInteger power) {
            BigInteger result = BigInteger.ONE;

            for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Prematurely interrupted computation");
                    return BigInteger.ZERO;
                }
                result = result.multiply(base);
            }

            return result;
        }
    }
}
