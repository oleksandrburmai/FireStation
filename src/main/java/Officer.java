public class Officer implements Runnable {

    private boolean isAlarm;

    Officer(boolean isAlarm) {
        this.isAlarm = isAlarm;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
            try {
                if (isAlarm) {
                    synchronized (this) {
                        this.wait();
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
