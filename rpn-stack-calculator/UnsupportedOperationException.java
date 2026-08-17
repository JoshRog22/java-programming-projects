/**
 * 
 * @author Joshua Rogers
 * Custom excpetion thrown when an unsupported Mathmatical 
 * operation is requested.
 */

//exception constructor with message.
public class UnsupportedOperationException extends Exception 
{
    public UnsupportedOperationException(String message) 
    {
        super(message);
    }
}