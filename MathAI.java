import java.util.Scanner;
import java.util.concurrent.*;

public class MathAI {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your math problem:");
        String input = scanner.nextLine();

        String problemType = ProblemDetector.detectProblemType(input);
        System.out.println("Detected problem type: " + problemType);

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<String> solverTask = () -> {
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
        };

        Future<String> future = executor.submit(solverTask);
        System.out.println("Result: " + future.get());

        executor.shutdown();
        scanner.close();
    }
}
