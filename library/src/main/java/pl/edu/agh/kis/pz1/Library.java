package pl.edu.agh.kis.pz1;

import java.util.concurrent.*;

public class Library {
    private int maxReaders;
    private Semaphore readers;

    public Library(int maxReaders) {
        this.maxReaders = maxReaders;
        readers = new Semaphore(maxReaders);
    }

    public void startReading() throws InterruptedException {
        System.out.println("Waiting for reader");
        readers.acquire();
    }

    public void stopReading() {
        readers.release();
    }

    public void startWriting() throws InterruptedException {
        readers.acquire(maxReaders);
    }

    public void stopWriting() {
        readers.release(maxReaders);
    }
}
