import java.util.ArrayList;
/**
 * 
 * @author Joshua Rogers
 * Implements a numeric stack using an ArrayList
 */
public class ArrayListNumberStack implements NumberStack 
{
    private ArrayList<Double> stack;//holds stack values

    //consturctor
    public ArrayListNumberStack() 
    {
        stack = new ArrayList<>();
    }

    //adds value to the top of the stack
    @Override
    public void push(double value) 
    {
        stack.add(value);
    }

    //removes and returns the top value from the stack
    @Override
    public double pop() throws EmptyStackException 
    {
        if (stack.isEmpty()) 
        {
            throw new EmptyStackException("Stack is empty.");
        }
        return stack.remove(stack.size() - 1);
    }

    //checks if stack is empty
    @Override
    public boolean isEmpty() 
    {
        return stack.isEmpty();
    }

    //returns the number of elements in the stack
    @Override
    public int size() 
    {
        return stack.size();
    }

    //clears the stack
    @Override
    public void clear() 
    {
        stack.clear();
    }
}
