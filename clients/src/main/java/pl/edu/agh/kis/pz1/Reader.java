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
        System.out.println("Reader " + name + " started reading");
        while(true) {
            try {
                library.startReading();
                System.out.println("Reading");
                Thread.sleep(readingTime);
                library.stopReading();
                System.out.println("Stopped reading");
                Thread.sleep(turnaroundTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
