/**
 * Name: William Lafleur
 * Date: 3/8/2022
 * Description: Program to create a mini extra, tune, and play instruments.
 */
package Lab_06;

import java.util.Iterator;

public class Main extends Orchestra {

    public static void main(String[] args) {

        // Create anonymous class Trumpet
        Instruments Trumpet = new Instruments() {
            @Override
            public void play() { // overriding the Instrument play method
                System.out.println("Buuup Buuup Buuup"); // print trumpet sounds
            }

            @Override
            public void tune(char note) { // overriding the Instrument tune method
                System.out.println("Tuning Trumpet to note: " + note);
            }
        };

        Trumpet.tune('B');
        Trumpet.play();

        // Create Orchestra
        Orchestra<Instruments> orchestra = new Orchestra<>();

        orchestra.addInstruments(new Cello("Sonata no 1"));
        orchestra.addInstruments(new Viola("Suite no 1"));
        orchestra.addInstruments(new Cello("River Flows in you"));
        orchestra.addInstruments(new Tuba("The Great Square of Pegasus", 4));
        orchestra.addInstruments(new Viola("Love me"));
        orchestra.addInstruments(new Viola("Never gonna give you up"));

        // Create Gen Orchestra
        GenOrchestra<Instruments> genOrchestra = new GenOrchestra<>();

        genOrchestra.addInstruments(new Cello("Suite no 1"));
        genOrchestra.addInstruments(new Cello("Sonata no 1"));
        genOrchestra.addInstruments(new Tuba("The Great Square of Pegasus", 4));
        genOrchestra.addInstruments(new Viola("River Flows in you"));
        genOrchestra.addInstruments(new Viola("Love me"));
        genOrchestra.addInstruments(new Tuba("Never gonna give you up", 4));

        Iterator<Instruments> instrumentsIterator = orchestra.iterator();

        // Size was 5 and then increased to 7 with the 6th instrument
        // removing the last null value
        instrumentsIterator.remove();

        while (instrumentsIterator.hasNext()) {
            System.out.print(instrumentsIterator.next() + ", ");
        }

        System.out.println("\nTuning all instruments: ");
        orchestra.tuneAll('D', orchestra);

        System.out.println("\nAll instruments playing songs: ");
        orchestra.playAll(orchestra);

        Iterator<Instruments> instrumentsIterator2 = genOrchestra.iterator();

        System.out.println("\nList of instruments in the General Orchestra: ");
        while (instrumentsIterator2.hasNext()) {
            System.out.print(instrumentsIterator2.next() + ", ");
        }

        System.out.println("\nTuning all instruments: ");
        genOrchestra.tuneAll('F', genOrchestra);
        System.out.println("\nAll instruments play songs: ");
        genOrchestra.playAll(genOrchestra);

        System.out.println("\nTuning and play some Instruments:");
        Tuba tuba = new Tuba("Symphony no 1", 2);
        Viola viola = new Viola("Winter Sonata");
        tuba.tune('E');
        tuba.play();
        viola.tune('B');
        viola.play();
    }
}