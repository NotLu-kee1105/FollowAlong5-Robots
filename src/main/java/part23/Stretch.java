package part23;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 1–4 (extends, super(), and a sensor field)
//
// SECTION C — Stretch. Do Stretch A, then Stretch B. The README says what each one should print.
// Stretch B adds a new class, Painter, at the bottom of this file.
//
// There is no main method here yet. Typing it is part of the stretch.

@MBotLab(world = "color-zones")
public class Stretch {
/*My Guess:
Super calls the parent class
eycolor calls the method
Calls the Mbot
Calls Painter
 */
public static void main(String[] args) {
    Painter p = new Painter();
    System.out.println(p instanceof Painter);
    System.out.println(p instanceof MBot2);
    System.out.println(p instanceof Chassis);
    p.driveToRed();
}
    static class Painter extends MBot2 {
        private ColorSensor eye;

        Painter() {
            super();
            eye = new ColorSensor(this);
        }

        void showColor() {
            String c = eye.color();
            if (c.equals("red")) {
                turnLedOn(1, 255, 0, 0);
            } else if (c.equals("green")) {
                turnLedOn(1, 0, 255, 0);
            } else if (c.equals("blue")) {
                turnLedOn(1, 0, 0, 255);
            } else if (c.equals("yellow")) {
                turnLedOn(1, 255, 200, 0);
            } else {
                turnLedOff(1);
            }
        }

        void driveToRed() {
            String last = "";
            while (!eye.color().equals("red")) {
                String c = eye.color();
                if (!c.equals(last)) {
                    System.out.println("Now on " + c);
                    last = c;
                }
                showColor();
                straight(5);
            }
            showColor();
            System.out.println("Stopped on red");
        }
    }
}
/*
The Scout and Painter have different fields because they do different jobs.

The Scout needs a Scanner because its job is to explore and find the most open path.
It uses the Scanner to look in different directions and decide where to go.

The Painter needs a ColorSensor because its job is to detect colors on the ground.
It uses the ColorSensor to change the LED color and stop when it reaches red.

Both extend MBot2 because both are robots and need the basic robot abilities,
such as moving, turning, reading sensors, and controlling LEDs. They have
different extra fields because they need different tools to do their specific jobs.
*/
