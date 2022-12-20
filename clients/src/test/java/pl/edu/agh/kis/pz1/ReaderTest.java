package pl.edu.agh.kis.pz1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReaderTest {

    @Test
    void constructor() {
        Library library = new Library();
        Reader reader = new Reader("Reader 1", 1000, 3000, library);
        assertEquals("Reader 1", reader.getName());
    }

    @Test
    void run() {
        Library library = new Library();
        assertNotNull(library);

        Reader reader = new Reader("Reader 1", 1000, 3000, library);
        assertNotNull(reader);

        reader.start();
    }
}