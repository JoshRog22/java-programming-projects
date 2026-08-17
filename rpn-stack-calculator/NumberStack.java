/**
 * @author Joshua Rogers
 * Defines the operations supported by a numeric stack
 */
public interface NumberStack 
{
    void push(double value); //puts value onto the stack
    double pop() throws EmptyStackException; //pops and returns top number. Throws exception if stack is empty
    boolean isEmpty(); //returns true if stack is empty
    int size(); //returns number of elements in stack
    void clear(); //clears elements of stack
}
