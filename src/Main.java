import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        var tasks = new ArrayList<Callable<Integer>>();

        tasks.add(new MyThread());
        tasks.add(new MyThread());
        tasks.add(new MyThread());

        //Вариант "Танцуют все"

        var executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        var results = executor.invokeAll(tasks);

        var total = 0;

        for (Future<Integer> result : results) {
            total += result.get();
        }
        System.out.println("Общее количество сообщений от потоков: " + total);

        executor.shutdown();

        //Вариант для определия "Кто первый"

        var service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        var result = service.invokeAny(tasks);

        System.out.println("Количество сообщений от потока, выполневшего первым задачу: " + result);

        service.shutdown();


    }
}
