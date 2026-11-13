package part24;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 1–3 and 6
//
// Part 24 — overriding: your robot keeps a method's name, but changes what it does.
//
// SECTION A — FOLLOW ALONG: type the CarefulBot class from the guide.
//    Leave the "package part24;" line, the "import mbot.*;" line and the class line alone.
//    Type everything else yourself.
//
// SECTION B — COMMENTS: when you finish, put a // comment ABOVE every line of code,
//    saying in YOUR OWN WORDS what that line does.

// Create a class called CarefulBot
// CarefulBot inherits all MBot2 behavior
public class CarefulBot extends MBot2 {
    private int refused;

    // Constructor
    // Runs when a CarefulBot object is created
    public CarefulBot() {

        // Call the MBot2 constructor
        super();
    }

    // Override MBot2's straight() method
    // This version adds a safety check before driving
    @Override
    public void straight(double cm) {

        // Check if there is enough space ahead
        // The robot needs at least cm + 20 centimeters
        if (readUltrasonic() > cm + 20) {

            // Call the ORIGINAL straight() method
            // from MBot2
            super.straight(cm);

        } else {

            // Turn the LED red
            turnLedOn(1, 255, 0, 0);
            //B1
            refused++;

            // Print a warning message
            System.out.println(

                    "CarefulBot: not driving " +
                            cm +
                            " cm, too close"
            );
        }
    }

    // Override MBot2's run() method
    @Override
    public void run() {

        // Repeat 5 times
        for (int i = 0; i < 5; i++) {

            // Try to drive forward 40 cm
            // This uses CarefulBot's version
            // of straight(), not MBot2's
            straight(40);
        }
    }
    @Override
    public String toString() {
        return "CarefulBot (refused " + refused + " moves)";
    }

}