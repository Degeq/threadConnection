import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {

    Integer i = 0;

    public MyCallable(Integer i) {
        this.i = i;
    }

    @Override
    public Integer call() throws InterruptedException {
        for (int j = 0; j < 4; j++) {
            Thread.currentThread().sleep(2500);
            System.out.println("Я + " + Thread.currentThread().getName() + " Всем привет!");
            i++;
        }
        return i;
    }
}
