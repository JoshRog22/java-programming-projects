/**
 * @author Joshua Rogers
 * Implements a numeric stack using a linked-node structure.
 */
public class LinkedNumberStack implements NumberStack 
{
    //represents node in linkedlist
    private class Node 
    {
        double value;
        Node next;

        //constructor
        Node(double value, Node next) 
        {
            this.value = value;
            this.next = next;
        }
    }

    private Node head; //top of node stack
    private int count; //number of items in stack

    //constructor
    public LinkedNumberStack() 
    {
        head = null;
        count = 0;
    }

    //pushes a value onto the top of the stack
    @Override
    public void push(double value) 
    {
        head = new Node(value, head);
        count++;
    }

    //pops and returns the top value from the stack
    @Override
    public double pop() throws EmptyStackException 
    {
        if (head == null) 
        {
            throw new EmptyStackException("Stack is empty.");
        }
        double value = head.value;
        head = head.next;
        count--;
        return value;
    }

    //returns true if stack is empty
    @Override
    public boolean isEmpty() 
    {
        return count == 0;
    }

    //returns number of items in the stack
    @Override
    public int size() 
    {
        return count;
    }

    //clears the stack
    @Override
    public void clear() 
    {
        head = null;
        count = 0;
    }
}
