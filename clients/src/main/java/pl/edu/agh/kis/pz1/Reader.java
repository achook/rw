package pl.edu.agh.kis.pz1;

public class Reader extends Thread{
    private final String name;

    private final int minReadingTime;
    private final int maxReadingTime;

    private final Library library;

    public Reader(String name, int minReadingTime, int maxReadingTime, Library library) {
        this.name = name;
        this.minReadingTime = minReadingTime;
        this.maxReadingTime = maxReadingTime;
        this.library = library;
    }

    public void run() {
        while(true) {
            try {
                library.startReading();
                System.out.println(name + " started reading");

                var writeCount = library.getWriteCount();
                System.out.println(name + " read that the write count equals " + writeCount);

                var readingTime = (int) (Math.random() * (maxReadingTime - minReadingTime) + minReadingTime);
                Thread.sleep(readingTime);
                System.out.println(name + " stopped reading");

                library.stopReading();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
