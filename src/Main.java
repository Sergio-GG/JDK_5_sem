import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {

        int[] forks = new int[] {0,1,2,3,4};

        Semaphore semaphore = new Semaphore(2);

        Philosofer philosofer1 = new Philosofer("Aristotle", forks, semaphore);
        Philosofer philosofer2 = new Philosofer("Plato", forks, semaphore);
        Philosofer philosofer3 = new Philosofer("Socrates", forks, semaphore);
        Philosofer philosofer4 = new Philosofer("Descartes",forks, semaphore);
        Philosofer philosofer5 = new Philosofer("Derrida", forks, semaphore);

        Thread thread1 = new Thread(philosofer1);
        Thread thread2 = new Thread(philosofer2);
        Thread thread3 = new Thread(philosofer3);
        Thread thread4 = new Thread(philosofer4);
        Thread thread5 = new Thread(philosofer5);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

    }
}