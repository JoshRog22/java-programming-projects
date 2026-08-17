/**
 * 
 * @author Joshua Rogers
 * Custom exception thrown when attempting to remove
 * a value from an empty stack
 */

//constructor with custon error message.
public class EmptyStackException extends Exception 
{
    public EmptyStackException(String message) 
    {
        super(message);
    }
}
