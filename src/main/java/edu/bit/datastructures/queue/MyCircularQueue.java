package edu.bit.datastructures.queue;

/**
 * It is also called "Ring Buffer".
 * <p>
 * One of the benefits of the circular queue is that we can make use of the spaces in front of the queue. In a normal queue,
 * once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue.
 * But using the circular queue, we can use the space to store new values.
 * <p>
 * Implement the MyCircularQueue class:
 * <p>
 * MyCircularQueue(k) Initializes the object with the size of the queue to be k.
 * int Front() Gets the front item from the queue. If the queue is empty, return -1.
 * int Rear() Gets the last item from the queue. If the queue is empty, return -1.
 * boolean enQueue(int value) Inserts an element into the circular queue. Return true if the operation is successful.
 * boolean deQueue() Deletes an element from the circular queue. Return true if the operation is successful.
 * boolean isEmpty() Checks whether the circular queue is empty or not.
 * boolean isFull() Checks whether the circular queue is full or not.
 */
public class MyCircularQueue {

    // a better structure would possibly be circular linked list to implement this

    private int front;
    private int rear;
    private final int limit;
    private final int[] data;


    public MyCircularQueue(int k) {
        data = new int[k];
        front = -1;
        rear = -1;
        limit = k;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        if (front == -1) { // first element
            front = 0;
        }
        rear = next(rear);
        data[rear] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        if (front == rear) { // only element
            front = -1;
            rear = -1;
            return true;
        }
        front = next(front);
        return true;
    }

    public int front() {
        if (isEmpty()) return -1;
        return data[front];
    }

    public int rear() {
        if (isEmpty()) return -1;
        return data[rear];
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return front != -1 && next(rear) == front;
    }

    private int next(int i) { // to get next idx after i in circular queue
        return (i + 1) % limit;
    }
}