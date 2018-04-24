public class Fireman implements Runnable {
    private boolean isAlarm;

    Fireman(boolean isAlarm) {
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
                Thread.sleep(1000);
                System.out.println(name + " Fireman alarm");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
