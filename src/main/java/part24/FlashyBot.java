package part24;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 4 and 6
//
// SECTION A — FOLLOW ALONG: type the FlashyBot class from the guide.
//    Leave the package, import and class lines alone. Type everything else.
//
// SECTION B — COMMENTS: put a // comment ABOVE every line of code, in YOUR OWN WORDS.

// Create a class called FlashyBot
// FlashyBot inherits all behavior from MBot2
public class FlashyBot extends MBot2 {

    // Constructor
    // Runs when a FlashyBot object is created
    public FlashyBot() {

        // Call the MBot2 constructor
        super();
    }

    // Override MBot2's turnLeft method
    @Override
    public void turnLeft(double degrees) {

        // Print a message before turning
        System.out.println("Flash! Turning left " + degrees);

        // Turn the LED blue
        turnLedOn(1, 0, 0, 255);

        // Call the original MBot2 turnLeft method
        super.turnLeft(degrees);

        // Turn the LED off after the turn
        turnLedOff(1);
    }

    // Override MBot2's turnRight method
    @Override
    public void turnRight(double degrees) {

        // Print a message before turning
        System.out.println("Flash! Turning right " + degrees);

        // Turn the LED green
        turnLedOn(1, 0, 255, 0);

        // Call the original MBot2 turnRight method
        super.turnRight(degrees);

        // Turn the LED off after the turn
        turnLedOff(1);
    }

    // Override the run() method
    @Override
    public void run() {

        // Repeat 4 times
        for (int i = 0; i < 4; i++) {

            // Drive forward 40 cm
            straight(40);

            // Turn left 90 degrees
            turnLeft(90);
        }
    }

}

