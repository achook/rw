package pl.edu.agh.kis.pz1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogTest {

    @Test
    void constructor() {
        Log log = new Log();
        assertNotNull(log);
    }
}