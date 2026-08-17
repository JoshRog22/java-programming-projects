/**
 * @author Joshua Rogers
 * Represents a single tower and enforces valid disc
 * placement during the simulation
 */
public class HanoiTower 
{
    private int[] discs; //an array to hold the disks
    private int numDiscs; //num of disks currently on the rod
    private String name; //name of the rod

    //constructor that creates a tower with number of discs and name
    public HanoiTower(int maxDiscs, String name) {
        this.discs = new int[maxDiscs];
        this.numDiscs = 0;
        this.name = name;
    }

    //pushes a disc onto the tower
    public void push(int disc) throws HanoiExceptions.TowerOverflowException, HanoiExceptions.IllegalPushException {
        if (numDiscs == discs.length) 
        {
            throw new HanoiExceptions.TowerOverflowException("Tower is full.");//exception if tower is full
        }
        if (numDiscs > 0 && discs[numDiscs - 1] < disc) 
        {
            throw new HanoiExceptions.IllegalPushException("Cannot place a larger disc on a smaller one.");//thorws exception if an an illegal move is attempten
        }
        discs[numDiscs++] = disc;
    }
    
    //pop removes a disk from the tower. 
    public int pop() throws HanoiExceptions.EmptyTowerException 
    {
        if (numDiscs == 0) 
        {
            throw new HanoiExceptions.EmptyTowerException("Tower is empty.");//exception if tower is empty
        }
        return discs[--numDiscs];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name + ": ");
        for (int i = 0; i < numDiscs; i++) {
            sb.append(discs[i]).append(" ");
        }
        return sb.toString().trim();
    }
}
