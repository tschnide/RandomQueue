import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;

/*****************************************************
 * Travis Schnider
 * 2420
 * Darrin Hunter
 * March 15th 2018
 * RandomQueue.java
 *
 * @author TSchnider
 *****************************************************/

public class RandomQueue<E> implements Iterable<E> {
    protected E[] array;
    protected int queueSize;

    /*
     *   Constructor
     */
    public RandomQueue() {
        array = (E[]) new Object[1];
        queueSize = 0;
    }

    /*
     *  Check if empty based on the queue size
     */
    public boolean isEmpty() {
        return queueSize == 0;
    }

    /*
     *  Find the size of the queue
     */
    public int size() {
        return queueSize;
    }

    /*
     *  Return a random element without deleting it
     */
    public E sample() {
        int rndmIndex = StdRandom.uniform(queueSize);
        return array[rndmIndex];
    }

    /*
     *  Put a new item on the queue.
     *  If the item is null, throw an exception.
     *  This implements a resizing array.
     */
    public void enqueue(E item) {
        if (item == null) {                                 //  Handle null items.
            throw new NullPointerException();
        }

        array[queueSize] = item;                            //  Add an item to the end and increment the queue.
        queueSize++;

        if (queueSize >= array.length) {                    //  If the array is full, double the size.
            E[] swapArray = array;
            array = (E[]) new Object[array.length * 2];

            // check later
            for (int x = 0; x < swapArray.length; x++) {
                array[x] = swapArray[x];
            }
        }
    }

    /*
     *   Return a random item from the queue and take it off
     *      of the queue.
     *   If the size is 0 throw and exception.
     *   This implements a resizing array.
     */
    public E dequeue() {
        if (this.size() == 0) {                             //  Handle empty arrays.
            throw new NoSuchElementException();
        }

        int rndmIndex = StdRandom.uniform(queueSize);       //  Find a random element from the array.
        E returnItem = array[rndmIndex];

        while (rndmIndex < queueSize) {                     //  Shift the necessary elements left.
            array[rndmIndex] = array[rndmIndex + 1];
            rndmIndex++;
        }

        queueSize--;                                        // Decrement the queue.

        if (queueSize == array.length / 4) {                // If the array has reached 1/4 capacity cut it's size in half.
            E[] swapArray = array;
            array = (E[]) new Object[array.length / 2];

            // check later
            for (int x = 0; x < queueSize; x++) {
                array[x] = swapArray[x];
            }
        }
        return returnItem;
    }

    /*
     *  Return a custom iterator
     */
    public Iterator<E> iterator() {
        return new ArrayIterator();
    }

    /***************************************************
     *
     *  A custom iterator that iterates randomly
     *
     **************************************************/
    private class ArrayIterator implements Iterator<E> {
        int iterationCount = queueSize;

        /*
         *  Iterate through the array returning random elements
         *  upon each itera
         */
        public E next() {
            if (iterationCount == 0) {
                throw new NoSuchElementException();
            }
            int rndmIndex = StdRandom.uniform(iterationCount);
            iterationCount--;
            return array[rndmIndex];
        }

        public boolean hasNext() {
            return iterationCount > 0;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }


    public static void main(String[] args) {

        RandomQueue<Integer> rqOne = new RandomQueue<>();
        assert rqOne.isEmpty() : "isEmpty should return true";

        RandomQueue<Integer> rqTwo = new RandomQueue<>();
        assert rqTwo.size() == 0 : "rqSize() should be zero";

        RandomQueue<Integer> rqThree = new RandomQueue<>();
        rqThree.enqueue(1);
        assert rqThree.sample() == 1 : "sample() should return one";

        RandomQueue<Integer> rqFour = new RandomQueue<>();
        rqFour.enqueue(1);
        int samp = rqFour.sample();
        assert rqFour.size() == 1 : "Size should be 1";
        assert samp == 1 : "Sample should return 1";

        RandomQueue<Integer> rqFive = new RandomQueue<>();
        rqFive.enqueue(1);
        rqFive.enqueue(2);
        int n = rqFive.dequeue();
        assert n == 1 || n == 2 && rqFive.size() == 1 : "dequeue() should return 1 or 2 and the size should decrease by one";

        RandomQueue<Integer> rqSix = new RandomQueue<>();
        assert rqSix.iterator() != rqSix.iterator() : "two iterators of the same instance should not be the same";

    }
}


