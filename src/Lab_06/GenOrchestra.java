package Lab_06;

import java.util.ArrayList;
import java.util.Iterator;


public class GenOrchestra<T> implements Iterable<T> {
    ArrayList<Instruments> instrumentsList = new ArrayList<>();
    int currentIndex = 0;

    /**
     * Add an instrument into arrayList
     *
     * @param instrument
     */
    public void addInstruments(Instruments instrument) {
        instrumentsList.add(instrument);
        currentIndex++;
    }

    /**
     * Overriding the iterator type
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int currentIndexIterator = 0;

            @Override
            public boolean hasNext() {
                return currentIndexIterator < currentIndex;
            }

            @Override
            public T next() {
                return (T) instrumentsList.get(currentIndexIterator++);
            }

        };
    }

    /**
     * Loops through all instruments and Plays them
     *
     * @param genOrchestra
     */
    public void playAll(GenOrchestra<Instruments> genOrchestra) {
        for (Instruments instruments : genOrchestra) {
            instruments.play();
        }
    }

    /**
     * Loops through all instruments and Tunes them
     *
     * @param note
     */
    public void tuneAll(char note, GenOrchestra<Instruments> genOrchestra) {
        for (Instruments instruments : genOrchestra) {
            instruments.tune(note);
        }
    }
}


