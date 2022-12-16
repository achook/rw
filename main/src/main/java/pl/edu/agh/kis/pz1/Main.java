package pl.edu.agh.kis.pz1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        System.out.println("Hello World!");

        Library library = new Library(5);

        executorService.execute(new Reader("Reader 1", 1000, 1000, library));
        executorService.execute(new Reader("Reader 2", 1000, 1000, library));
        executorService.execute(new Reader("Reader 3", 1000, 1000, library));
        executorService.execute(new Writer("Writer 1", 1000, 1000, library));
        executorService.execute(new Reader("Reader 4", 1000, 1000, library));
        executorService.execute(new Reader("Reader 5", 1000, 1000, library));

    }
}
