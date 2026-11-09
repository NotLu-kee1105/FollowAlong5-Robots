package part21;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 4–9
//
// SECTION A — FOLLOW ALONG: type the main method from the guide in this class.
//    It makes a Rover and drives it until it is close to the wall.
//    Leave the package, import, @MBotLab and class lines alone. Type everything else.
//
// SECTION B — COMMENTS: put a // comment ABOVE every line of code, in YOUR OWN WORDS.

// This annotation tells the MBot simulator
// to load the world called "wall-ahead"
@MBotLab(world = "wall-ahead")

// Create a class called FollowAlong
public class FollowAlong {

    // Main method - program execution starts here
    public static void main(String[] args) {

        // Create a Rover object named scout
        // Pass "Scout" into the Rover constructor
        Rover scout = new Rover("Scout");

        // Print a message that the rover is ready
        // scout is automatically converted to text using scout.toString()
        System.out.println(scout + " is ready");

        // Tell the rover to drive forward until
        // something is detected within 20 cm
        scout.driveUntilBlocked();

        // Print a message after the rover stops
        // Again, scout.toString() is called automatically
        System.out.println(scout +
                " stopped. Something is less than 20 cm ahead.");

    } // End of main method

} // End of FollowAlong class