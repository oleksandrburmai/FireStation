import java.util.Random;

public class Administrator implements Runnable {

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        while (FireStation.getIsAlarm()) {
            FireStation.setAlarm(new Random().nextBoolean());
            if (FireStation.getIsAlarm()) {
                System.out.println(name + " Admin all good");
            } else {
                System.out.println(name + " Admin alarm");
            }
        }
    }
}
