public class FireStation {

    public static boolean isAlarm = true;

    public void fireStationStatus() {
        Thread administrator = new Thread(new Administrator());
        Thread officer = new Thread(new Officer());
        Thread fireman = new Thread(new Fireman());
        administrator.start();
        officer.start();
        fireman.start();
        synchronized (this) {
            if (!isAlarm) {
                notifyAll();
            }
        }
    }
}
