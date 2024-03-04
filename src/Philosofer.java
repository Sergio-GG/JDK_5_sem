import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class Philosofer implements Runnable{

    String name;
    int[] forks;
    Semaphore semaphore;

    int id;
    private static int plus = 1;
    int num = 0;

    Philosofer(String name, int[] forks, Semaphore semaphore){
        this.name = name;
        this.forks = forks;
        this.semaphore = semaphore;
        id += plus;
        ++plus;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        try {
            while (num < 3) {
                semaphore.acquire();
                eat();
                Thread.sleep(1000);
                breakDown();
                Thread.sleep(5000);
                num++;
                semaphore.release();
            }
            enough();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }

    }

    private void eat(){
        System.out.println("Философ " + id + " по имени " + this.getName() + " Приступил к трапезе");
    }

    private void breakDown(){
        System.out.println("Философ " + id + " по имени " + this.getName() + " Покушал, можно и поразмышлять");
    }

    private void enough(){
        System.out.println("Философ " + id + " по имени " + this.getName() +" Окончательно сыт");
    }
//    private void takeForks(){
//        switch (id){
//            case 1:
//
//        }
//    }
}
