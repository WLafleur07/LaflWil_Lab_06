package Lab_06;

import java.util.Iterator;

public class Orchestra<T> implements Iterable<T> {

    Instruments[] instrumentsArray = new Instruments[5];
    int size = instrumentsArray.length;
    int currentIndex = 0;
    int counter = 0;
    int newSize;


    /**
     * Add an instrument to the array
     * Increase array's size by 50% when array is full
     *
     * @param instrument
     */
    public void addInstruments(Instruments instrument) {

        int i;
        // Execute when array is full
        if (counter >= size) {
            newSize = (int) (size + (size * 0.5));
            // Create a new array with newSize and add instrument into new array
            Instruments[] newInstrumentsArray = new Instruments[newSize];
            if (size >= 0) System.arraycopy(instrumentsArray, 0, newInstrumentsArray, 0, size);

            // Assign new array into instrumentArray and resize
            instrumentsArray = newInstrumentsArray;
            size = newSize;
        }

        // for loop to add instrument into array
        for (i = counter; i < counter + 1; i++) {
            instrumentsArray[i] = instrument;
        }
        // increase counter to represent array index
        counter++;

        currentIndex++; // currentIndex is used for hasNext method in iterator
    }

    /**
     * Override iterator
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
                return (T) instrumentsArray[currentIndexIterator++];
            }

            // Check for null value in the array
            // resize by n null value if null values are found
            @Override
            public void remove() {
                System.out.println("Size before remove: " + size);
                for (int i = 0; i < size; i++) {
                    if (instrumentsArray[i] == null) {
                        newSize = size - 1;
                        Instruments[] newInstruments = new Instruments[newSize];
                        System.arraycopy(instrumentsArray, 0, newInstruments, 0, newSize);
                        instrumentsArray = newInstruments;
                        size = newSize;
                    }
                }
                System.out.println("Current size is: " + size);
            }
        };
    }

    /**
     * This method plays all the instruments songs in the orchestra
     *
     * @param orchestra
     */
    public void playAll(Orchestra orchestra) {
        for (Instruments instruments : (Iterable<Instruments>) orchestra) {
            instruments.play();
        }
    }

    /**
     * This method tunes all the instruments notes in the orchestra
     *
     * @param note
     */
    public void tuneAll(char note, Orchestra orchestra) {
        for (Instruments instruments : (Iterable<Instruments>) orchestra) {
            instruments.tune(note);
        }
    }
}
