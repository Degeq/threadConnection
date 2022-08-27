import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Integer i = 0;
        final Collection<Callable<Integer>> taskList = new ArrayList<>();
        final Callable<Integer> myTask1 = new MyCallable(i);
        final Callable<Integer> myTask2 = new MyCallable(i);

        taskList.add(myTask1);
        taskList.add(myTask2);

        final ExecutorService threadPool = Executors.newFixedThreadPool(4, new MyThreadFactory());
        List<Future<Integer>> result = threadPool.invokeAll(taskList);
        for (Future<Integer> answer : result) {
            i = i + answer.get();
        }
        System.out.println("За время работы потока было выведно: " + i + " сообщений");
        threadPool.shutdown();


//        ThreadGroup threadGroup = new ThreadGroup("main group");
//
//        Thread myThread1 = new MyThread(threadGroup, "Поток 1");
//        Thread myThread2 = new MyThread(threadGroup, "Поток 2");
//        Thread myThread3 = new MyThread(threadGroup, "Поток 3");
//        Thread myThread4 = new MyThread(threadGroup, "Поток 4");
//
//        myThread1.start();
//        myThread2.start();
//        myThread3.start();
//        myThread4.start();
//
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException ine) {
//
//        }
//
//        threadGroup.interrupt();
    }
}
