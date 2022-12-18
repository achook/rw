package pl.edu.agh.kis.pz1;

public class Writer extends Thread {
    private final String name;

    private final int writingTime;
    private final int turnaroundTime;

    private final Library library;

    public Writer(String name, int writingTime, int turnaroundTime, Library library) {
        this.name = name;
        this.writingTime = writingTime;
        this.turnaroundTime = turnaroundTime;
        this.library = library;
    }

    public void run() {
        while(true) {
            try {
                library.startWriting();
                System.out.println("Writer " + name + " started writing");

                library.incrementWriteCount();
                var writeCount = library.getWriteCount();
                System.out.println("Writer " + name + " write count: " + writeCount);

                Thread.sleep(writingTime);
                System.out.println("Writer " + name + " stopped writing");
                library.stopWriting();

                Thread.sleep(turnaroundTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
