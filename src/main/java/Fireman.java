public class Fireman implements Runnable {

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        try {
            if (FireStation.isAlarm) {
                synchronized (this) {
                    this.wait();
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
