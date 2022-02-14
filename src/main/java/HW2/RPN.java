package HW2;

import java.util.*;

/**
 * author: Chaya Haor
 * implements RPN (reverse polish notation) on the imputed numbers
 * https://en.wikipedia.org/wiki/Reverse_Polish_notation
 */
public class RPN {
    private final String expressionInput;

    public RPN(String input) {
        expressionInput = input;
    }

    String evaluate() {
         String output = "Please check your input. Something went wrong.";

        try
        {
            boolean error = false;
            Stack<Double> stack = new Stack<>();
            String[] item = expressionInput.trim().split("\\s+");
            double total;

            for (int i = 0; i < item.length; i++)
            {
                String s = item[i];
                switch (s)
                {
                    case "+":
                        total = stack.pop() + stack.pop();
                        stack.push(total);

                        break;
                    case "-":
                        double holder = stack.pop();
                        total = stack.pop() - holder;
                        stack.push(total);
                        break;
                    case "*":
                        total = stack.pop() * stack.pop();
                        stack.push(total);
                        break;
                    case "/":
                        holder = stack.pop();
                        total = stack.pop() / holder;
                        stack.push(total);
                        break;
                    default:
                        try
                        {
                            stack.push(Double.parseDouble(s));
                        } catch (Exception e)
                        {
                            error = true;
                            i = item.length;
                            break;
                        }
                        break;
                }
            }
            if (!error)
            {
                double finalTotal = stack.pop();
                if(stack.empty())
                {
                    output = "The total is " + finalTotal;
                }
            }
        } catch (Exception ignored)
        {

        }
        return output;
    }

}
