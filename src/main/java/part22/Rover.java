package part22;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 1–9
//
// Part 22 — behaviors: methods that use the sensors to decide what the robot does.
//
// SECTION A — FOLLOW ALONG: type the Rover class from the guide in this class.
//    Leave the "package part22;" line, the "import mbot.*;" line and the class line alone.
//    Type everything else yourself.
//
// SECTION B — COMMENTS: when you finish, put a // comment ABOVE every line of code,
//    saying in YOUR OWN WORDS what that line does.

// Create a class called Rover
public class Rover {

    // Store the rover's name
    private String name;

    // Chassis object that controls movement
    private Chassis base;

    // Ultrasonic sensor used to detect obstacles
    private Ultrasonic eyes;

    // Line sensor used to detect tape on the floor
    private LineSensor floor;

    // Remembers which side the line was last seen on
    private boolean lineWasLeft;

    // Constructor
    // Runs when a new Rover object is created
    public Rover(String name) {

        // Store the rover's name
        this.name = name;

        // Create a chassis object
        this.base = new Chassis();

        // Create an ultrasonic sensor and attach it to the chassis
        this.eyes = new Ultrasonic(base);

        // Create a line sensor and attach it to the chassis
        this.floor = new LineSensor(base);
    }

    // Drive forward until an obstacle is closer than cm
    // Return the number of 5 cm moves made
    public int driveUntilBlocked(double cm) {

        // Count how many moves were made
        int moves = 0;

        // Keep moving while the obstacle is farther away than cm
        while (eyes.distance() > cm) {

            // Move forward 5 cm
            base.straight(5);

            // Increase move count
            moves++;
        }

        // Return the total number of moves
        return moves;
    }

    // Drive around an obstacle by moving left
    public void goAroundLeft(double sideways) {

        // Turn left 90 degrees
        base.turnLeft(90);

        // Move sideways
        base.straight(sideways);

        // Face forward again
        base.turnRight(90);
    }

    // Navigate through the obstacle course
    public void reachGoal() {

        // Drive until the first wall is reached
        int first = driveUntilBlocked(15);

        // Report how many moves it took
        System.out.println(
                "Blocked after " + first + " moves. Going round.");

        // Go around the obstacle
        goAroundLeft(60);

        // Drive until the next wall
        int second = driveUntilBlocked(15);

        // Report how many moves it took
        System.out.println(
                "Blocked after " + second +
                        " moves. That is the far wall.");

        // Turn toward the goal area
        base.turnRight(90);

        // Drive into the goal
        base.straight(50);
    }

    // Follow a tape line for a specified number of steps
    public void followLine(int steps) {

        // Repeat the line-following logic steps times
        for (int i = 0; i < steps; i++) {

            // Read the line sensor status
            int s = floor.status();

            // Line is on the left side
            if (s == 4 || s == 8 || s == 12) {

                // Turn slightly left
                base.turnLeft(4);

                // Remember that the line was last seen on the left
                lineWasLeft = true;

            }
            // Line is on the right side
            else if (s == 1 || s == 2 || s == 3) {

                // Turn slightly right
                base.turnRight(4);

                // Remember that the line was last seen on the right
                lineWasLeft = false;
            }

            // Line is completely lost
            else if (s == 0) {

                // Search left if the line was last seen there
                if (lineWasLeft) {

                    base.turnLeft(4);

                } else {

                    // Search right otherwise
                    base.turnRight(4);
                }
            }

            // Sensor is centered on the line
            else {

                // Move forward
                base.straight(1);
            }
        }
    }

    // Controls what prints when a Rover object is displayed
    public String toString() {

        // Return a description of the rover
        return name + " the rover";
    }

}
