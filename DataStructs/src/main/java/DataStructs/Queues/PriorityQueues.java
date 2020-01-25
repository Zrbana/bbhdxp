package DataStructs.Queues;

import java.util.PriorityQueue;



class PridrityQueue{
    private int maxSize;
    private int[] queueArray;
    private int nItems;

    public PridrityQueue(int size){
        maxSize = size;
        queueArray = new int[size];
        nItems = 0;
    }


    public void insert(int value) {
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        } else {
            int j = nItems - 1; // index of last element
            while (j >= 0 && queueArray[j] > value) {
                queueArray[j + 1] = queueArray[j]; // Shifts every element up to make room for insertion
                j--;
            }
            queueArray[j + 1] = value; // Once the correct position is found the value is inserted
            nItems++;
        }
    }

    public int remove() {
        return queueArray[--nItems];
    }


    public int peek() {
        return queueArray[nItems - 1];
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }


    public boolean isFull() {
        return (nItems == maxSize);
    }

    public int getSize() {
        return nItems;
    }

}


public class PriorityQueues {
    /**
     * Main method
     *
     * @param args Command Line Arguments
     */
    public static void main(String[] args) {
        PridrityQueue myQueue = new PridrityQueue(4);
        myQueue.insert(10);
        myQueue.insert(2);
        myQueue.insert(5);
        myQueue.insert(3);

        for (int i = 3; i >= 0; i--)
            System.out.print(myQueue.remove() + " ");
    }
}












