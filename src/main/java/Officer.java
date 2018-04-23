public class Officer implements Runnable {

    private boolean isOk;

    Officer(boolean isOk) {
        this.isOk = isOk;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        try {
            if (isOk) {
                this.wait();
            } else {
                Thread.sleep(900);
                System.out.println(name + " Officer alarm");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
