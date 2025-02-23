import java.util.Stack;

class EvaluateReversePolishNotation {

    private boolean isOperand(String token) {
        if (token.equals("+")
                || token.equals("-")
                || token.equals("*")
                || token.equals("/")) {
            return true;
        }
        return false;
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> rpn = new Stack<>();

        for (String token : tokens) {
            if (!isOperand(token)) {
                rpn.push(Integer.parseInt(token));
            } else {
                int b = rpn.pop();
                int a = rpn.pop();

                if (token.equals("+")) {
                    rpn.push(a + b);
                } else if (token.equals("-")) {
                    rpn.push(a - b);
                } else if (token.equals("*")) {
                    rpn.push(a * b);
                } else if (token.equals("/")) {
                    rpn.push(a / b);
                }
            }
        }

        return rpn.pop();
    }
}
