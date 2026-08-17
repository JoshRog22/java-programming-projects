import java.util.Scanner;

/**
 * @author Joshua Rogers
 * Evaluates Reverse Polish Notation expressions using 
 * interchangeable stack implementations.
 */
public class RPNCalculator
{
    public static void doOperation(NumberStack stack, String operation) 
        throws EmptyStackException, UnsupportedOperationException 
    {
        double right = stack.pop(); //right operand
        double left = stack.pop(); //left operand
        switch (operation) 
        {
            case "+":
                stack.push(left + right);
                break;
            case "-":
                stack.push(left - right);
                break;
            case "*":
                stack.push(left * right);
                break;
            case "/":
                stack.push(left / right);
                break;
            default: //restore stack and throws exception for unsopported operations
                stack.push(left);
                stack.push(right);
                throw new UnsupportedOperationException("Unsupported operation: " + operation);
        }
    }

    //evaluates an expression
    public static void evaluateRPN(NumberStack stack, String expr) 
    {
        System.out.println("input: " + expr);
        Scanner keyboard = new Scanner(expr);

        try 
        {
            while (keyboard.hasNext()) //process each token in expression
            {
                if (keyboard.hasNextDouble()) 
                {
                    stack.push(keyboard.nextDouble());
                } 
                else 
                {
                    String token = keyboard.next();
                    doOperation(stack, token);
                }
            }

            double result = stack.pop(); //outputs final result
            System.out.println("result: " + result);
        } 
        catch (EmptyStackException e) 
        {
            System.out.println("Too few operands");
        } 
            catch (UnsupportedOperationException e) 
            {
                System.out.println(e.getMessage());
            } 
            finally //clear the stack and print a blank line
        {
            stack.clear();
            System.out.println();
        }
    }

    //main method to test both stack implementation and evaluation
    public static void main(String[] args) 
    {
        // Test ArrayListNumberStack
        System.out.println("Testing ArrayListNumberStack");
        NumberStack arrayStack = new ArrayListNumberStack();
        evaluateRPN(arrayStack, "23 21 +");
        evaluateRPN(arrayStack, "11 78 73 - *");
        evaluateRPN(arrayStack, "8 +");
        evaluateRPN(arrayStack, "7 2 %");

        // Test LinkedNumberStack
        System.out.println("Testing LinkedNumberStack");
        NumberStack linkedStack = new LinkedNumberStack();
        evaluateRPN(linkedStack, "23 21 +");
        evaluateRPN(linkedStack, "11 78 73 - *");
        evaluateRPN(linkedStack, "8 +");
        evaluateRPN(linkedStack, "7 2 %");        
    }
}
