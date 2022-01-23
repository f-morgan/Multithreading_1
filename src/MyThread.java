class MyThread extends Thread {

    @Override
    public void run() {
        String nameThread = Thread.currentThread().getName();
        try {
            while(!isInterrupted()) {
                Thread.sleep(2500);
                System.out.println("Я - " + nameThread + "! Всем привет!");
            }
        } catch (InterruptedException err) {

        } finally{
            System.out.printf("Поток %s вышел из чата\n", nameThread);
        }
    }
}