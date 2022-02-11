package HW2;

import java.util.*;

/**
 * author: Chaya Haor
 * implements RPN (reverse polish notation) on the imputed numbers
 */
public class RPN {
    private boolean error = false;
    private String output;
    private final String expressionInput;

    public RPN(String input) {
        expressionInput = input;
    }

    public void evaluate() {

        try
        {
            error = false;
            Stack<Double> stack = new Stack<>();
            String[] item = expressionInput.trim().split("\\s+");
            double total;

            for (int i = 0; i < item.length; i++)
            {
                String s = item[i];
                switch (s)
                {
                    case "+":
                        if (checkIfTwo(stack))
                        {
                            total = stack.pop() + stack.pop();
                            stack.push(total);
                        }
                        break;
                    case "-":
                        if (checkIfTwo(stack))
                        {
                            double holder = stack.pop();
                            total = stack.pop() - holder;
                            stack.push(total);
                        }
                        break;
                    case "*":
                        if (checkIfTwo(stack))
                        {
                            total = stack.pop() * stack.pop();
                            stack.push(total);
                        }
                        break;
                    case "/":
                        if (checkIfTwo(stack))
                        {
                            double holder = stack.pop();
                            total = stack.pop() / holder;
                            stack.push(total);
                        }
                        break;
                    default:
                        try
                        {
                            stack.push(Double.parseDouble(s));
                        } catch (Exception e)
                        {
                            System.out.println("Illegal Input");
                            error = true;
                            i = item.length;
                        }
                        break;
                }
            }
            if (!error)
            {
                double finalTotal = stack.pop();
                if (!stack.empty())
                    output = "Extra junk ignored";
                else
                {
                    output = "The total is " + finalTotal; //********* FORMAT ********************
                }
            }
        } catch (Exception e)
        {
            output = "Please check your input. Something went wrong.";
        }

    }


    public boolean checkIfTwo(Stack<Double> stack) {
        if (stack.peek() == null && stack.peek() == null)
        {
            output = "Syntax Error";
            error = true;
        }
        return !error;
    }

    @Override
    public String toString() {
        return output;
    }
}
