import java.util.Scanner;

/** 
 * @author Joshua Rogers
 * Console application for running interactive
 * towers of Hanoi Simulations.
 */

public class TowersOfHanoi
{
    public static void main(String[] args) 
    {
       Scanner keyboard = new Scanner(System.in);
        System.out.println("Welcome to Joshua Rogers's Hanoi tower simulation!");
        
        while (true) {
            System.out.print("How many discs do you wish to simulate? ");
            int numDiscs = keyboard.nextInt();
            HanoiSimulation simulation = new HanoiSimulation(numDiscs);
            simulation.runSim();
            
            System.out.print("Would you like to run another simulation? (Y/N) ");
            System.out.println();
            String response = keyboard.next();
            if (!response.equalsIgnoreCase("Y")) {
                break;
            }
        }
        
        System.out.println("Thank you for using Joshua Rogers's Hanoi tower simulation."); 
    }
}
