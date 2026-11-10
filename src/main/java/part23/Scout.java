package part23;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 1–5
//
// Part 23 — inheritance: your own robot class, built on top of MBot2.
//
// SECTION A — FOLLOW ALONG: type the Scout class from the guide.
//    Step 1 changes the class line below: that is the one line you DO change.
//    Leave the "package part23;" line and the "import mbot.*;" line alone.
//    Type everything else yourself.
//
// SECTION B — COMMENTS: when you finish, put a // comment ABOVE every line of code,
//    saying in YOUR OWN WORDS what that line does.

// Create a class called Scout
// Scout inherits from MBot2
public class Scout extends MBot2 {

    // Store the scout's name
    private String name;

    // Scanner object used to scan the environment
    private Scanner scanner;

    // Constructor
    // Runs when a new Scout object is created
    public Scout(String name) {

        // Call the parent class constructor (MBot2)
        super();

        // Store the scout's name
        this.name = name;

        // Create a Scanner object and connect it to this robot
        this.scanner = new Scanner(this);
    }

    // Drive forward until an obstacle is within 25 cm
    // Return the number of 5 cm moves made
    public int driveUntilBlocked() {

        // Counter for moves
        int moves = 0;

        // Keep moving while the obstacle is farther than 25 cm away
        while (readUltrasonic() > 25) {

            // Move forward 5 cm
            straight(5);

            // Increase move count
            moves++;
        }

        // Return total moves made
        return moves;
    }

    // Find the index of the most open direction
    public int openestIndex() {

        // Perform a scan and store all distances
        double[] d = scanner.scan();

        // Assume index 0 is best initially
        int best = 0;

        // Check all other scan positions
        for (int i = 1; i < d.length; i++) {

            // If this distance is larger than the current best
            if (d[i] > d[best]) {

                // Remember its index
                best = i;
            }
        }

        // Return the index of the largest distance
        return best;
    }

    // Turn toward the most open direction
    public void turnTowardOpenSide() {

        // Find the best scan index
        int i = openestIndex();

        // If the angle is positive
        if (Scanner.ANGLES[i] > 0) {

            // Turn left
            turnLeft(90);

        } else {

            // Turn right
            turnRight(90);
        }
    }

    // Controls how the Scout object prints
    public String toString() {

        // Return a description of the scout
        return name + " the scout";
    }

}