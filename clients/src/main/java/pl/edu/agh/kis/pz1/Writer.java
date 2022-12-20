package pl.edu.agh.kis.pz1;

import java.util.concurrent.ThreadLocalRandom;

public class Writer extends Thread {
    private final int minWritingTime;
    private final int maxWritingTime;

    private final Library library;

    public Writer(String name, int minWritingTime, int maxWritingTime, Library library) {
        this.setName(name);
        this.minWritingTime = minWritingTime;
        this.maxWritingTime = maxWritingTime;
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

                library.startWriting();
                logger.logln(name + " started writing");

                library.incrementWriteCount();
                var writeCount = library.getWriteCount();
                logger.logln(name + " wrote and now the write count equals " + writeCount);

                var writingTime = ThreadLocalRandom.current().nextInt(minWritingTime, maxWritingTime);
                Thread.sleep(writingTime);

                logger.logln(name + " stopped writing");
                library.stopWriting();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
}
