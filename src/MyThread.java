import java.util.concurrent.Callable;

class MyThread implements Callable<Integer> {

    @Override
    public Integer call() {
        var nameThread = Thread.currentThread().getName();
        var count =  (int)(Math.random() * 5 + 1);
        for (int i = 0; i < count; i++) {
            System.out.println("Я - " + nameThread + "! Всем привет!");
        }
        return count;
    }


}