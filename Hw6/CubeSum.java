/******************************************************************************
 * 
 *  Print out integers of the form a^3 + b^3 in sorted order, where
 *  0 <= a = b = n.
 *
 ******************************************************************************/

/**
 *
 * @author Kyle Diederich
 */
public class CubeSum implements Comparable<CubeSum> {
    private final int sum;
    private final int i;
    private final int j;

    public CubeSum(int i, int j) {
		// You write!!
    }

    public int compareTo(CubeSum other) {
		// You write!!
    }

    public String toString() {
        return sum + " = " + i + "^3" + " + " + j + "^3";
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = 10; // Largest value to check for a,b,c,d < N

        // initialize priority queue
        MinPQ<CubeSum> pq = new MinPQ<CubeSum>();
        
		// You write!!
    }
    
}
