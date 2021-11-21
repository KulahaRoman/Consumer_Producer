public class Consumer implements Runnable {
    private Queue<Integer> queue;
    private int numberOfElements;

    public Consumer(Queue<Integer> queue, int numberOfElements) {
        this.queue = queue;
        this.numberOfElements = numberOfElements;

        new Thread(this).start();
    }

    public void run() {
        for(int i = 0; i < numberOfElements; i++) {
            queue.Get();
        }
    }
}
