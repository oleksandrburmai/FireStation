public class Administrator implements Runnable {

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        FireStation fireStation = new FireStation();
        for (int i = 0; i < 2; i++) {
            System.out.println(name + " Admin all good");
            fireStation.setStatus(true);
        }
        System.out.println(name + " Admin alarm");
        fireStation.setStatus(false);
    }
}
