package Lab_06;

public class Viola implements Instruments {
    String song;
    String name;

    public Viola(String song) {
        this.song = song;
        this.name = "Viola";
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
        System.out.println(this.name + " playing... " + song);
    }

    /**
     * Override Instrument tune() method
     */
    @Override
    public void tune(char note) {
        System.out.println("Tuning Viola to note: " + note);
    }
}