package pl.edu.agh.kis.pz1;

public class Reader extends Thread{
    private String name;
    private int readingTime;
    private int turnaroundTime;
    private Library library;

    public Reader(String name, int readingTime, int turnaroundTime, Library library) {
        this.name = name;
        this.readingTime = readingTime;
        this.turnaroundTime = turnaroundTime;
        this.library = library;
    }

    public void run() {
        while(true) {
            try {
                library.startReading();
                System.out.println("Reader " + name + " started reading");

                var writeCount = library.getWriteCount();
                System.out.println("Reader " + name + " write count: " + writeCount);

                Thread.sleep(readingTime);
                System.out.println("Reader " + name + " stopped reading");

                library.stopReading();

                Thread.sleep(turnaroundTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
