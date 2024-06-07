import java.util.ArrayList;
import java.util.List;

public class OutputBin {
    private List<PopcornBag> bin ;
    private int capacity;
    
    public OutputBin(int capacity){
        this.bin = new ArrayList<>(capacity);
        this.capacity = capacity;
    }

    public synchronized void addBags(PopcornBag popcornbag) throws InterruptedException{
        while(capacity == bin.size()){
            wait();
        }
        bin.add(popcornbag);
        notifyAll();
    }

    public synchronized PopcornBag releseABag() throws InterruptedException{
        while(bin.isEmpty()){
            wait();
        }
        PopcornBag popcornbag = bin.remove(0);
        notifyAll();

        return popcornbag;
    } 
    

}
