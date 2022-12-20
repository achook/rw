package pl.edu.agh.kis.pz1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @Test
    void constructor() {
        Library library = new Library();
        assertNotNull(library);
    }

    @Test
    void getWriteCount() {
        Library library = new Library();
        assertEquals(0, library.getWriteCount());
    }

    @Test
    void incrementWriteCount() {
        Library library = new Library();
        library.incrementWriteCount();
        assertEquals(1, library.getWriteCount());
    }
}