import java.util.ArrayList;
import java.util.List;

public class RobotArm implements Runnable{
    private List<Observers> observers = new ArrayList<>();
    private PopcornBag popcorn;
    private OutputBin bin;

    public RobotArm(OutputBin bin){
        this.bin = bin;
        observers.add(new Light());
        observers.add(new Bell());
    }

    @Override
    public void run() {
        while (true) {
            try {
                popcorn = bin.releseABag();
                doOperation();
                notifyObservers();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private void doOperation() throws InterruptedException{
        System.out.printf("Pick up the popcorn bag %d from the output bin and place on the table\n" , popcorn.getBagNumber());
        Thread.sleep(500);
    }

    private void notifyObservers(){
        for(Observers observer : observers){
            observer.update();
        }
    }
    
}
