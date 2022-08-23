public class MyThread extends Thread {

    public MyThread (ThreadGroup tg, String name) {
        super(tg, null, name, 0);
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                Thread.sleep(2500);
                System.out.println("Я " + getName() + "! Всем привет!");
            }
        } catch (InterruptedException ine) {

        } finally {
            System.out.println(getName() + " завершен");
        }
    }
}
