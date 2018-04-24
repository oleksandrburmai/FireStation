public class FireStation {

    private boolean isAlarm;

    public void fireStationStatus() {
        Thread administrator = new Thread(new Administrator());
        Thread officer = new Thread(new Officer(isAlarm));
        Thread fireman = new Thread(new Fireman(isAlarm));
        administrator.start();
        try {
            administrator.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        officer.start();
        fireman.start();
        synchronized (this){
            if (!isAlarm) {
                notifyAll();
            }
        }

    }


    public void setStatus(boolean isAlarm) {
        this.isAlarm = isAlarm;
    }
}
