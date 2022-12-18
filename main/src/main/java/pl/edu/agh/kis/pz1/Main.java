package pl.edu.agh.kis.pz1;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        final int NUMBER_OF_READERS = 10;
        final int NUMBER_OF_WRITERS = 3;
        final int MIN_READING_TIME = 1000;
        final int MAX_READING_TIME = 3000;
        final int MIN_WRITING_TIME = 1000;
        final int MAX_WRITING_TIME = 3000;

        for (int i = 0; i < NUMBER_OF_READERS; i++) {
            Reader reader = new Reader("Reader " + i, MIN_READING_TIME, MAX_READING_TIME, library);
            reader.start();
        }

        for (int i = 0; i < NUMBER_OF_WRITERS; i++) {
            Writer writer = new Writer("Writer " + i, MIN_WRITING_TIME, MAX_WRITING_TIME, library);
            writer.start();
        }
    }
}
