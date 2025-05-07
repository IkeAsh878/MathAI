import java.util.Scanner;
import java.util.concurrent.*;
import java.util.*;

public class MathAI {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your math problems (type 'Done' to finish): ");

        List<String> problems  = new ArrayList<>();
        String input;

        while(!(input = scanner.nextLine()).equalsIgnoreCase("Done")){
            problems.add(input);
        }

        int numberOfThreads = Math.min(4, problems.size());
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);

        List<Future<String>> futures = new ArrayList<>();

        String input = scanner.nextLine();
        String problemType = ProblemDetector.detectProblemType(input);
        System.out.println("Detected problem type: " + problemType);

        ExecutorService executor = Executors.newSingleThreadExecutor();


        for (String problem: problems){
        Callable<String> solverTask = () -> {
            String problemType = ProblemDetector.detectProblemType(problem);
            String result;

            switch (problemType) {
                case "Calculus - Derivative":
                case "Calculus - Integral":
                case "Algebra - Equation":
                    return SymjaSolver.solve(input);
                case "General Arithmetic":
                    return ArithmeticSolver.solve(input);
                default:
                    return "Unsupported problem type.";
            }
            return "Problem: " + problem + "\nType: " + problemType + "\nResult: " + result + "\n";
        };

        futures.add(executor.submit(task));

        Future<String> future = executor.submit(solverTask);
        System.out.println("Result: " + future.get());

        for (Future<String> future: futures){
            System.out.println(future.get());
        }
        executor.shutdown();
        scanner.close();
    }
    }
}
