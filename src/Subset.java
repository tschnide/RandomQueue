import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Subset {

    private int subsetSize;

    public Subset(int subsetSize) {
        this.subsetSize = subsetSize;
    }


    public void getRandom(RandomQueue rq) {
        for (int n = 0; n < subsetSize; n++) {
            System.out.println(rq.sample());
        }
    }

    public static void main(String[] args) {
        RandomQueue<String> randomQueue = new RandomQueue<>();

        Subset subset = new Subset(StdIn.readInt());
        System.out.println("go");
        while (!StdIn.isEmpty()) {
            randomQueue.enqueue(StdIn.readString());
            System.out.println("go");
        }
        subset.getRandom(randomQueue);
    }
}
