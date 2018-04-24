public class FireStation {

    private boolean isAlarm=true;

    public void fireStationStatus() {
        Thread administrator = new Thread(new Administrator());
        Thread officer = new Thread(new Officer(isAlarm,new FireStation()));
        Thread fireman = new Thread(new Fireman(isAlarm,new FireStation()));
        administrator.start();
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
