import java.util.LinkedList;

public class Queue<T> {
    private LinkedList<T> queue;
    private int putCount;
    private int getCount;

    public Queue() {
        this.queue = new LinkedList<>();
        this.putCount = 0;
        this.getCount = 0;
    }

    synchronized public void Put(T object) {
        while(getCount < putCount) {
            try {
                wait();
            }
            catch(InterruptedException ex) {

            }
        }

        try {
            queue.addLast(object);
        } catch(IllegalStateException ex) {

        }
        putCount++;
        System.out.println("Produced the object: " + object);
        notify();
    }

    synchronized public T Get() {
        while(getCount >= putCount) {
            try {
                wait();
            } catch(InterruptedException ex) {

            }
        }

        T value = queue.pollFirst();
        getCount++;
        System.out.println("Consumed the object: " + value);

        notify();
        return value;
    }
}
