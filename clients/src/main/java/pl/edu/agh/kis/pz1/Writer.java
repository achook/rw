package pl.edu.agh.kis.pz1;

public class Writer extends Thread {
    private String name;
    private int writingTime;
    private int turnaroundTime;
    private Library library;

    public Writer(String name, int writingTime, int turnaroundTime, Library library) {
        this.name = name;
        this.writingTime = writingTime;
        this.turnaroundTime = turnaroundTime;
        this.library = library;
    }

    public void run() {
        System.out.println("Writer " + name + " started writing");
        while(true) {
            try {
                library.startWriting();
                System.out.println("Writing");
                Thread.sleep(writingTime);
                library.stopWriting();
                System.out.println("Stopped writing");
                Thread.sleep(turnaroundTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
