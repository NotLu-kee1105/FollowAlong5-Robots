package part21;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 2–8
//
// Part 21 — composition: a Rover HAS-A Chassis and HAS-AN Ultrasonic.
//
// SECTION A — FOLLOW ALONG: type the Rover class from the guide in this class.
//    Leave the "package part21;" line, the "import mbot.*;" line and the class line alone.
//    Type everything else yourself.
//
// SECTION B — COMMENTS: when you finish, put a // comment ABOVE every line of code,
//    saying in YOUR OWN WORDS what that line does.
//
// SECTION C — STRETCH B adds a LineSensor and two methods to this class.

// Create a class called Rover
public class Rover {

    // Private field storing the rover's name
    private String name;

    // Private field storing the rover's chassis
    // The chassis controls movement
    private Chassis base;

    // Private field storing the ultrasonic sensor
    // The sensor detects obstacles
    private Ultrasonic eyes;

    // Constructor
    // Runs when a Rover object is created
    public Rover(String name) {

        // Store the rover's name
        this.name = name;

        // Create a new Chassis object
        // and store it in base
        this.base = new Chassis();

        // Create a new Ultrasonic sensor
        // Pass the chassis into the sensor's constructor
        this.eyes = new Ultrasonic(base);
    }

    // Override the built-in toString() method
    public String toString() {

        // Return a description of the rover
        return name + " the rover";
    }

    // Returns true if an object is closer than cm
    public boolean somethingAhead(double cm) {

        // Ask the ultrasonic sensor for the distance
        // Compare it with cm
        return eyes.distance() < cm;
    }

    // Drive forward until something is detected
    // within 20 centimeters
    public void driveUntilBlocked() {

        // Keep driving while nothing is closer than 20 cm
        while (!somethingAhead(20)) {

            // Move forward 5 units
            base.straight(5);
        }
    }

} // End of Rover class