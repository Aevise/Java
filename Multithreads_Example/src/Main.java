public class Main {
    public static void main(String[] args) {
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.printf("We are now in thread [%s]: %s%n", Thread.currentThread().getId(), Thread.currentThread().getName());
//                System.out.printf("Thread priority: %s: %s%n", Thread.currentThread().getName(), Thread.currentThread().getPriority());
//                throw new RuntimeException("Not hehe");
//            }
//        });
        Thread thread = new Thread(() -> {
            System.out.printf("We are now in thread [%s]: %s%n", Thread.currentThread().getId(), Thread.currentThread().getName());
            System.out.printf("Thread priority: %s: %s%n", Thread.currentThread().getName(), Thread.currentThread().getPriority());
            throw new RuntimeException("Not hehe");
        });


        thread.setName("Cypriankos");
        thread.setPriority(Thread.MAX_PRIORITY); // 1 - 10, gdzie 10 jest najwiekszym prioryteem

        thread.setUncaughtExceptionHandler((currentThread, exception) ->
                System.out.printf("Uncaught exception in thread [%s]: %s - %s%n",
                        currentThread.getId(), currentThread.getName(), exception.getMessage()));


        System.out.printf("We are in thread [%s]: %s%n ", Thread.currentThread().getId(), Thread.currentThread().getName());
        thread.start();
        System.out.printf("We are in thread [%s]: %s%n ", Thread.currentThread().getId(), Thread.currentThread().getName());
    }


}
