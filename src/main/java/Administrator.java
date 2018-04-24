public class Administrator implements Runnable {

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 2; i++) {
            System.out.println(name + " Admin all good");
            FireStation.isAlarm = true;
        }
        System.out.println(name + " Admin alarm");
        FireStation.isAlarm = false;
    }
}
