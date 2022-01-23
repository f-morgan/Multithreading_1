public class Main {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup mainGroup = new ThreadGroup("main group");

        final Thread thread1 = new Thread(mainGroup, new MyThread());
        final Thread thread2 = new Thread(mainGroup, new MyThread());
        final Thread thread3 = new Thread(mainGroup, new MyThread());

        thread1.setName("Красавчик");
        thread2.setName("Милашка");
        thread3.setName("Роднулькин");

        thread1.start();
        thread2.start();
        thread3.start();

        Thread.sleep(15_000);

        mainGroup.interrupt();

    }
}
