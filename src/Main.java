
public class Main {
    public static void main(String[] args) {
        int number = 10;
        Queue<Integer> queue = new Queue<>();
        Consumer consumer = new Consumer(queue, number);
        Producer producer = new Producer(queue, number);
    }
}