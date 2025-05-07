import java.util.concurrent.*;

public class ParallelMath {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        Callable<Double> task1 = () -> Math.sqrt(123456);
        Callable<Double> task2 = () -> Math.pow(123, 4);
        Callable<Double> task3 = () -> Math.log(123456);
        Callable<Double> task4 = () -> Math.sin(Math.PI / 4);

        Future<Double> future1 = executor.submit(task1);
        Future<Double> future2 = executor.submit(task2);
        Future<Double> future3 = executor.submit(task3);
        Future<Double> future4 = executor.submit(task4);

        System.out.println("Results:");
        System.out.println(future1.get());
        System.out.println(future2.get());
        System.out.println(future3.get());
        System.out.println(future4.get());

        executor.shutdown();
    }
}
