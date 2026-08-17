/**
 * @author Joshua Rogers
 * Defines custom exeptions for invalid Towers of hanoi operations
 */

public class HanoiExceptions 
{

public static class TowerOverflowException extends Exception 
{
    public TowerOverflowException(String message) 
    {
        super(message);
    }
}

public static class IllegalPushException extends Exception 
{
    public IllegalPushException(String message) 
    {
        super(message);
    }
}

public static class EmptyTowerException extends Exception 
{
    public EmptyTowerException(String message) 
    {
        super(message);
    }
}
}