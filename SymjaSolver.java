import org.matheclipse.core.eval.ExprEvaluator;
import org.matheclipse.core.interfaces.IExpr;

public class SymjaSolver {
    public static String solve(String input) {
        ExprEvaluator util = new ExprEvaluator();

        try {
            IExpr result = util.evaluate(input);
            return result.toString();
        } catch (Exception e) {
            return "Error solving with Symja: " + e.getMessage();
        }
    }
}
