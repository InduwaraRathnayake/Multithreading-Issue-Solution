public class Machine {
    public static void main(String[] args) {

        OutputBin bin = new OutputBin(3);
        Thread cooker1 = new Thread(new Cooker(1, bin));
        Thread cooker2 = new Thread (new Cooker(2, bin));
        Thread robotArm = new Thread(new RobotArm(bin));

        robotArm.start();
        cooker1.start();
        cooker2.start();

        try {
            cooker1.join();
            cooker2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
} 
