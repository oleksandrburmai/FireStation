public class Officer implements Runnable {

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        try {
            if (FireStation.getIsAlarm()) {
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
