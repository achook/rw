package pl.edu.agh.kis.pz1;

public class Writer extends Thread {
    private final String name;

    private final int minWritingTime;
    private final int maxWritingTime;

    private final Library library;

    public Writer(String name, int minWritingTime, int maxWritingTime, Library library) {
        this.name = name;
        this.minWritingTime = minWritingTime;
        this.maxWritingTime = maxWritingTime;
        this.library = library;
    }

    public void run() {
        while(true) {
            try {
                library.startWriting();
                System.out.println(name + " started writing");

                library.incrementWriteCount();
                var writeCount = library.getWriteCount();
                System.out.println(name + " wrote and now the write count equals " + writeCount);

                var writingTime = (int) (Math.random() * (maxWritingTime - minWritingTime) + minWritingTime);
                Thread.sleep(writingTime);

                System.out.println(name + " stopped writing");
                library.stopWriting();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
