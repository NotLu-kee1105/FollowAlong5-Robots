package part24;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 2, 5 and 7
//
// SECTION A — FOLLOW ALONG: type the mission method and the main method from the guide.
//    Leave the package, import, @MBotLab and class lines alone. Type everything else.
//
// SECTION B — COMMENTS: put a // comment ABOVE every line of code, in YOUR OWN WORDS.

// Load the MBot world called "wall-ahead"
@MBotLab(world = "wall-ahead")

// Create a class called Mission
public class Mission {

    // A method that can run a mission with ANY object
    // that is an MBot2 (including subclasses)
    public static void mission(MBot2 bot) {

        // Print a starting message
        System.out.println("Mission start");

        // Run the robot's run() method
        // Which version runs depends on the actual object
        bot.run();

        // Print a completion message
        System.out.println("Mission done");
    }

    // Main method - program starts here
    public static void main(String[] args) {

        // Choose which robot to create
        int pick = 1;

        // Declare a variable that can hold any MBot2 object
        MBot2 bot;

        // If pick is 1, create a CarefulBot
        if (pick == 1) {

            bot = new CarefulBot();

            // If pick is 2, create a FlashyBot
        } else if (pick == 2) {

            bot = new FlashyBot();

            // Otherwise create a regular MBot2
        } else {

            bot = new MBot2();
        }

        // Pass the robot into the mission method
        mission(bot);
    }

}

