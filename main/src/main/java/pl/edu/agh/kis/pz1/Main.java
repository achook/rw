package pl.edu.agh.kis.pz1;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        final int NUMBER_OF_READERS = 10;
        final int NUMBER_OF_WRITERS = 2;
        final int READING_TIME = 1000;
        final int WRITING_TIME = 2000;
        final int READER_TURNAROUND_TIME = 1000;
        final int WRITER_TURNAROUND_TIME = 2000;

        for (int i = 0; i < NUMBER_OF_READERS; i++) {
            Reader reader = new Reader("Reader " + i, READING_TIME, READER_TURNAROUND_TIME, library);
            reader.start();
        }

        for (int i = 0; i < NUMBER_OF_WRITERS; i++) {
            Writer writer = new Writer("Writer " + i, WRITING_TIME, WRITER_TURNAROUND_TIME, library);
            writer.start();
        }
    }
}
