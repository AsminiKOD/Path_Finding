public class QueueImplementation {
    private final int[][] array;
    private int front;
    private int rear;
    private int size;
    private final int capacity;

    public QueueImplementation(int capacity) {    //making custom queue
        this.capacity = capacity;
        array = new int[capacity][2];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int[] point) {     //add 1 element into queue
        if (isFull())
            throw new IllegalStateException("Queue is full");
        rear = (rear + 1) % capacity;
        array[rear] = point;
        size++;
    }

    public int[] dequeue() {     //deleting 1 element from queue
        if (isEmpty())
            throw new IllegalStateException("Queue is empty");
        int[] temp = array[front];
        front = (front + 1) % capacity;
        size--;
        return temp;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}

