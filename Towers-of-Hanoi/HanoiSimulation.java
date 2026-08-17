/**
 * @author Joshua Rogers
 * Runs a Towers of hanoi simulation using recursive
 * algorithm to move discs between towers.
 */
public class HanoiSimulation 
{
    private int numDiscs;
    private HanoiTower rodA;
    private HanoiTower rodB;
    private HanoiTower rodC;

    //constructor to initialize the simulator the the number of disks
    public HanoiSimulation(int numDiscs) {
        this.numDiscs = numDiscs;
        rodA = new HanoiTower(numDiscs, "Rod A");
        rodB = new HanoiTower(numDiscs, "Rod B");
        rodC = new HanoiTower(numDiscs, "Rod C");

        // Pushes discs onto rod 
        try {
            for (int i = numDiscs; i >= 1; i--) {
                rodA.push(i);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error initializing rod A: " + e.getMessage());
        }
    }

    //Runs the simulator
    public void runSim() {
        displayTowers();
        moveDiscs(numDiscs, rodA, rodB, rodC);
    }

    //recursive method to move discs from source to destination 
    private void moveDiscs(int numDiscs, HanoiTower source, HanoiTower destination, HanoiTower auxiliary) {
        if (numDiscs == 1) {
            try {
                int disc = source.pop();
                destination.push(disc);
                displayTowers();
            } catch (Exception e) {
                throw new RuntimeException("Error during move: " + e.getMessage());
            }
        } else {
            moveDiscs(numDiscs - 1, source, auxiliary, destination);
            try {
                int disc = source.pop();
                destination.push(disc);
                displayTowers();
            } catch (Exception e) {
                throw new RuntimeException("Error during move: " + e.getMessage());
            }
            moveDiscs(numDiscs - 1, auxiliary, destination, source);
        }
    }

    //displays the current state of the towers
    private void displayTowers() {
        System.out.println(rodA);
        System.out.println(rodB);
        System.out.println(rodC);
        System.out.println();
    }
}