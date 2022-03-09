package Lab_06;

public class Cello implements Instruments {
    String song;
    String name;

    public Cello(String song) {
        this.song = song;
        this.name = "Cello";
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
    public void tune(char note) {
        System.out.println("Tuning Cello to note: " + note);
    }

    /**
     * Override Instrument play() method
     */
    @Override
    public void play() {
        System.out.println(this.name + " playing... " + song);
    }
}