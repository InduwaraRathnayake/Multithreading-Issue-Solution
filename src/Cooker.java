public class Cooker implements Runnable{
    private int cookerID;
    private OutputBin bin;

    public Cooker(int cookerID, OutputBin bin){
        this.cookerID = cookerID;
        this.bin = bin;
    }
    
    @Override
    public void run(){
        int i =1;
        while(true){
            try {
                PopcornBag popcornBag = makePopcornBag(i);
                bin.addBags(popcornBag);
                System.out.printf("Successfully placed \"popcorn bag - %d\" in the bin (Made by Cooker-%d)\n", popcornBag.getBagNumber(), cookerID);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            i++;
        }

    }

    private PopcornBag makePopcornBag(int bagNumber) throws InterruptedException{
        System.out.printf("Making a popcorn bag by Cooker %d\n" , cookerID);
        PopcornBag popcornBag = new PopcornBag(bagNumber);
        Thread.sleep(500);
        return popcornBag;
    }
}
