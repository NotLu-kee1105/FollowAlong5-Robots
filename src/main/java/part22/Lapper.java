package part22;

class Lapper {

    // The rover this Lapper controls
    Rover rover;

    // Number of laps completed
    int done;

    // Constructor
    Lapper(Rover rover) {
        this.rover = rover;
    }

    // Drive n laps
    void laps(int n) {

        for (int i = 0; i < n; i++) {

            rover.followLine(725);

            done++;

            System.out.println("Lap " + done + " done");
        }
    }
}