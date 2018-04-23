public class FireStation {

    private boolean isOk;

    public synchronized void fireStationStatus() {
        Thread administrator = new Thread(new Administrator());
        Thread officer = new Thread(new Officer(isOk));
        Thread fireman = new Thread(new Fireman(isOk));
        administrator.start();
        officer.start();
        fireman.start();
        if (!isOk) {
                notifyAll();
        }
    }


    public synchronized void setStatus(boolean isOk) {
        this.isOk = isOk;
    }
}
