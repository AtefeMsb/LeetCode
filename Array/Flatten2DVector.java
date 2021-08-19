/** Approach 1: Flatten List in Constructor
 * time: O(n)
 * space: O(n)
 */
import java.util.NoSuchElementException;

class Vector2D {
    // Constructor will put all the nums into this list.
    List<Integer> nums = new ArrayList<>();
    
    // Keep track of where the Iterator is up to.
    int position = 0;

    public Vector2D(int[][] vec) {
        // We need to iterate over the 2D vector, getting all the integers
        // out of it and putting them into nums (a field).
        for (int[] inner : vec) {
            for (int num : inner) {
                nums.add(num);
            }
        }
    }
    
    public int next() {
        // In Java, we throw a NoSuchElementException when next() is called
        // on an exhausted Iterator.
        if (!hasNext()) throw new NoSuchElementException();
        
        // Store the number we need to return, as we still need to move position forward.
        int result = nums.get(position);
        
        // Move the position pointer forward by 1, so that it's ready for
        // the next call to next, and gives a correct hasNext result.
        position++;
        return result;
    }
    
    public boolean hasNext() {
        // There's nums left as long as position is a valid index of the list.
        return position < nums.size();
    }
}
// -----------------------------------------------------------
/** Approach 2: Two Pointers
 * time: O(n)
 * space: O(1)
 */
import java.util.NoSuchElementException;

class Vector2D {

    private int[][] vector;
    private int inner = 0;
    private int outer = 0;

    public Vector2D(int[][] v) {
        // We need to store a *reference* to the input vector.
        vector = v;
    }

    // If the current outer and inner point to an integer, this method does nothing.
    // Otherwise, inner and outer are advanced until they point to an integer.
    // If there are no more integers, then outer will be equal to vector.length
    // when this method terminates.
    private void advanceToNext() {
        // While outer is still within the vector, but inner is over the
        // end of the inner list pointed to by outer, we want to move
        // forward to the start of the next inner vector.
        while (outer < vector.length && inner == vector[outer].length) {
            inner = 0;
            outer++;
        }
    }

    public int next() {
        // As per Java specs, throw an exception if there's no next.
        // This will also ensure the pointers point to an integer otherwise.
        if (!hasNext()) throw new NoSuchElementException();
        // Return current element and move inner so that is after the current
        // element.
        return vector[outer][inner++];
    }

    public boolean hasNext() {
        // Ensure the position pointers are moved such they point to an integer,
        // or put outer = vector.length.
        advanceToNext();
        // If outer = vector.length then there are no integers left, otherwise
        // we've stopped at an integer and so there's an integer left.
        return outer < vector.length;
    }
}