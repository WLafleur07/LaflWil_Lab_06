package Lab_06;

public class Tuba implements Instruments {
    String song;
    int repeatMelody;
    String name;

    public Tuba(String song, int repeatMelody) {
        this.song = song;
        this.repeatMelody = repeatMelody;
        this.name = "Tuba";
    }

    /**
     * Override toString method to print out name of instrument
     */
    public String toString() {
        return this.name;
    }

    /**
     * Override Instrument play() method
     */
    @Override
    public void play() {
        System.out.print(this.name + " playing... " + song);
        for (int i = 0; i < repeatMelody; i++)
            System.out.print(" oom pa pa ");
        System.out.println();
    }

    /**
     * Override Instrument tune() method
     */
    @Override
    public void tune(char note) {
        System.out.println("Tuning Tuba to note: " + note);
    }
}