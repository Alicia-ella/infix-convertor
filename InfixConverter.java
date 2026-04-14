import java.util.Stack;

public class InfixConverter {

    // Returns operator precedence
    static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        if (op == '^')              return 3;
        return 0;
    }

    static boolean isOperand(char c) {
        return Character.isLetterOrDigit(c);
    }

    // ─── INFIX → POSTFIX ───────────────────────────────────────────────
    static String toPostfix(String infix) {
        StringBuilder output = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char token : infix.toCharArray()) {
            if (token == ' ') continue;

            if (isOperand(token)) {
                output.append(token);

            } else if (token == '(') {
                stack.push(token);

            } else if (token == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    output.append(stack.pop());
                if (!stack.isEmpty()) stack.pop(); // remove '('

            } else { // operator
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(token))
                    output.append(stack.pop());
                stack.push(token);
            }
        }

        while (!stack.isEmpty())
            output.append(stack.pop());

        return output.toString();
    }

    // ─── INFIX → PREFIX ────────────────────────────────────────────────
    static String toPrefix(String infix) {
        // Step 1: reverse the infix expression
        StringBuilder reversed = new StringBuilder(infix).reverse();

        // Step 2: swap parentheses
        for (int i = 0; i < reversed.length(); i++) {
            char c = reversed.charAt(i);
            if      (c == '(') reversed.setCharAt(i, ')');
            else if (c == ')') reversed.setCharAt(i, '(');
        }

        // Step 3: apply postfix on the modified string
        String postfixOfReversed = toPostfix(reversed.toString());

        // Step 4: reverse the result
        return new StringBuilder(postfixOfReversed).reverse().toString();
    }

    // ─── MAIN ──────────────────────────────────────────────────────────
    public static void main(String[] args) {
        String[] expressions = {
            "A+B*C",
            "(A+B)*C",
            "A+B*C-D/E",
            "A*(B+C)-D^E"
        };

        System.out.printf("%-20s %-20s %-20s%n", "Infix", "Postfix", "Prefix");
        System.out.println("-".repeat(62));

        for (String expr : expressions) {
            String postfix = toPostfix(expr);
            String prefix  = toPrefix(expr);
            System.out.printf("%-20s %-20s %-20s%n", expr, postfix, prefix);
        }
    }
}