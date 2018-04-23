public class Fireman implements Runnable {
    private boolean isOk;

    Fireman(boolean isOk) {
        this.isOk = isOk;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        try {
            if (isOk) {
                this.wait();
            } else {
                Thread.sleep(1000);
                System.out.println(name + " Fireman alarm");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
