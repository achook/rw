package pl.edu.agh.kis.pz1;

import java.util.concurrent.*;

public class Library {
    private final Semaphore queue;
    private final Semaphore readersNumberLock;
    private final Semaphore writeCountLock;

    // Number of readers currently reading
    private int currentReadersNumber;

    // Number of writes to the library
    private int writeCount;


    public Library() {
        // Acts as a queue, preserves order of readers and writers
        queue = new Semaphore(1, true);

        // Locks access to currentReadersNumber
        readersNumberLock = new Semaphore(1);

        // Locks access to writeCount
        writeCountLock = new Semaphore(1);

        currentReadersNumber = 0;
        writeCount = 0;
    }

    public void startReading() throws InterruptedException {
        System.out.println("A new person has entered the queue, which now consists of "
                + queue.getQueueLength() + " people");

        // Get in the line to be serviced
        queue.acquire();

        // If there are 5 readers already, wait for one to finish
        while (currentReadersNumber == 5) {
            Thread.sleep(100);
        }

        // Lock access to currentReadersNumber
        readersNumberLock.acquire(1);

        // If I am the first reader
        if (++currentReadersNumber == 1) {
            // Prevent writers from entering
            writeCountLock.acquire(1);
        }
        System.out.println("A new reader says that there are currently " + currentReadersNumber + " readers inside");

        // Unlock access to currentReadersNumber
        readersNumberLock.release(1);

        // Leave the line
        queue.release();
    }

    public void stopReading() throws InterruptedException {
        // Lock access to currentReadersNumber
        readersNumberLock.acquire(1);
        // If I am the last reader
        if (--currentReadersNumber == 0) {
            // Allow writers to enter
            writeCountLock.release(1);
        }

        System.out.println("A reader is leaving the library and there are now " + currentReadersNumber + " readers inside");
        // Unlock access to currentReadersNumber
        readersNumberLock.release(1);
    }

    public void startWriting() throws InterruptedException {
        System.out.println("A new person has entered the queue, which now consists of "
                + queue.getQueueLength() + " people");

        // Get in the line to be serviced
        queue.acquire();

        // Prevent readers and other writers from entering
        writeCountLock.acquire(1);
    }

    public void stopWriting() {
        // Allow readers and other writers to enter
        writeCountLock.release(1);

        // Leave the line
        queue.release();
    }

    public int getWriteCount() {
        return writeCount;
    }

    public void incrementWriteCount() {
        writeCount++;
    }
}
