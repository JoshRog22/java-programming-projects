/**
 * @author Joshua Rogers
 * Custome exception used when no player matches.
 */

public class NoSuchPlayerException extends Exception
{
    public NoSuchPlayerException() 
    {       
        super("No Player matches the parameters given.");
        System.out.println();
    }
    
    public NoSuchPlayerException(String msg) 
    {       
        super(msg);
        System.out.println();
    }
}
