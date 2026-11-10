package part22;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 7–9
//
// SECTION A — FOLLOW ALONG: type the main method from the guide in this class.
//    It makes a Rover and follows the loop of tape all the way round.
//    Leave the package, import, @MBotLab and class lines alone. Type everything else.
//
// SECTION B — COMMENTS: put a // comment ABOVE every line of code, in YOUR OWN WORDS.

// Load the MBot simulation world called "line-track"
// The rover will drive on a taped track
@MBotLab(world = "line-track")

// Create a class called LineRun
public class LineRun {

    // Main method - execution starts here
    public static void main(String[] args) {

        // Create a Rover object named rover
        // Pass "Tracker" into the constructor
        Rover rover = new Rover("Tracker");

        // Tell the rover to follow the line for 400 steps
        rover.followLine(400);

        // Print a message after the first section is complete
        System.out.println("Halfway round");

        // Continue following the line for another 325 steps
        rover.followLine(325);

        // Print a completion message
        // Java automatically calls rover.toString()
        System.out.println(rover + " finished a lap");
    }

} // End of class