package pl.edu.agh.kis.pz1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WriterTest {

    @Test
    void constructor() {
        Library library = new Library();
        Writer writer = new Writer("Writer 1", 10000, 12000, library);
        assertEquals("Writer 1", writer.getName());
    }

    @Test
    void run() {
        Library library = new Library();
        assertNotNull(library);

        Writer writer = new Writer("Writer 1", 10000, 12000, library);
        assertNotNull(writer);

        writer.start();
    }

}