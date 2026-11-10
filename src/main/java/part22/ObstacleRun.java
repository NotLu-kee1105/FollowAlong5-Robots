package part22;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 3–6
//
// SECTION A — FOLLOW ALONG: type the main method from the guide in this class.
//    It makes a Rover and sends it round the box to the goal.
//    Leave the package, import, @MBotLab and class lines alone. Type everything else.
//
// SECTION B — COMMENTS: put a // comment ABOVE every line of code, in YOUR OWN WORDS.

// Load the MBot world called "obstacles"
// The robot will run in this simulation environment
@MBotLab(world = "obstacles")

// Create a class called ObstacleRun
public class ObstacleRun {

    // Main method - the program starts running here
    public static void main(String[] args) {

        // Create a Rover object named rover
        // Pass the name "Dash" into the Rover constructor
        Rover rover = new Rover("Dash");

        // Print a message that the rover is ready
        // Java automatically calls rover.toString()
        System.out.println(rover + " is ready");

        // Tell the rover to navigate through the obstacle course
        // until it reaches its goal
        rover.reachGoal();

        // Print a success message after the rover reaches the goal
        // rover.toString() is called automatically again
        System.out.println(rover + " reached the goal");
    }

} // End of class
