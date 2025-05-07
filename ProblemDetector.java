public class ProblemDetector {
    public static String detectProblemType(String input) {
        input = input.toLowerCase();

        if (input.contains("d(") || input.contains("dx"))
            return "Calculus - Derivative";
        else if (input.contains("integral") || input.contains("∫"))
            return "Calculus - Integral";
        else if (input.contains("="))
            return "Algebra - Equation";
        else
            return "General Arithmetic";
    }
}
public class ProblemDetector {
    public static String detectProblemType(String input) {
        input = input.toLowerCase();

        if (input.contains("derivative") || input.contains("d(") || input.contains("dx"))
            return "Calculus - Derivative";
        else if (input.contains("integral") || input.contains("∫"))
            return "Calculus - Integral";
        else if (input.contains("="))
            return "Algebra - Equation";
        else
            return "General Arithmetic";
    }

    public static void main(String[] args) {
        System.out.println(detectProblemType("D(x^2+3x, x)"));
        System.out.println(detectProblemType("Integrate x^2 dx"));
        System.out.println(detectProblemType("x^2 - 4 = 0"));
    }
}
