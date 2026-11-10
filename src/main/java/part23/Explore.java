package part23;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 3, 5 and 6
//
// SECTION A — FOLLOW ALONG: type the main method from the guide in this class.
//    It makes a Scout and sends it through the junctions to the goal.
//    Leave the package, import, @MBotLab and class lines alone. Type everything else.
//
// SECTION B — COMMENTS: put a // comment ABOVE every line of code, in YOUR OWN WORDS.

// Load the MBot world called "junctions"
// This world contains intersections and multiple paths
@MBotLab(world = "junctions")

// Create a class called Explore
public class Explore {

    // Main method - program starts here
    public static void main(String[] args) {

        // Create a Scout robot named Pathfinder
        Scout scout = new Scout("Pathfinder");

        // Repeat the exploration process 3 times
        // Each repetition is called a "leg" of the journey
        for (int leg = 1; leg <= 3; leg++) {

            // Drive forward until the robot is blocked by a wall
            // Store the number of moves made
            int moves = scout.driveUntilBlocked();

            // Print information about this leg
            System.out.println("Leg " + leg + ": " + moves + " moves");

            // For legs 1 and 2, choose a new direction
            // Don't do this on the last leg because we've reached the goal area
            if (leg < 3) {

                // Scan the surroundings and turn toward the most open path
                scout.turnTowardOpenSide();
            }
        }

        // Print a completion message
        // scout.toString() is called automatically
        System.out.println(scout + " reached the goal");
    }

} // End of class