public class Fireman implements Runnable {
    private boolean isAlarm;
    private final FireStation fireStation;

    Fireman(boolean isAlarm, FireStation fireStation) {
        this.isAlarm = isAlarm;
        this.fireStation=fireStation;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        try {
            if (isAlarm) {
                 synchronized (fireStation) {
                     fireStation.notify();
                     fireStation.wait();
                 }
            } else {
                Thread.sleep(1000);
                System.out.println(name + " Fireman alarm");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
