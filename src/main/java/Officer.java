public class Officer implements Runnable {

    private boolean isAlarm;
    private final FireStation fireStation;

    Officer(boolean isAlarm, FireStation fireStation) {
        this.isAlarm = isAlarm;
        this.fireStation=fireStation;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
            try {
                if (isAlarm) {
                   synchronized (fireStation){
                       fireStation.notify();
                       fireStation.wait();
                   }
                } else {
                    Thread.sleep(900);
                    System.out.println(name + " Officer alarm");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}
