package pl.edu.agh.kis.pz1;

import java.util.concurrent.ThreadLocalRandom;

public class Reader extends Thread{
    private final int minReadingTime;
    private final int maxReadingTime;

    private final Library library;

    public Reader(String name, int minReadingTime, int maxReadingTime, Library library) {
        this.setName(name);
        this.minReadingTime = minReadingTime;
        this.maxReadingTime = maxReadingTime;
        this.library = library;
    }

    /**
     * Runs the thread.
     */
    @Override
    public void run() {
        var logger = new Log();

        while(true) {
            try {
                var name = this.getName();

                library.startReading();
                logger.logln(name + " started reading");

                var writeCount = library.getWriteCount();
                logger.logln(name + " read that the write count equals " + writeCount);

                var readingTime = ThreadLocalRandom.current().nextInt(minReadingTime, maxReadingTime);
                Thread.sleep(readingTime);
                logger.logln(name + " stopped reading");

                library.stopReading();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
}
