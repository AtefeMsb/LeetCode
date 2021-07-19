/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

import java.util.NoSuchElementException;

public class NestedIterator implements Iterator<Integer> {

    List<Integer> flat = new ArrayList<>();
    int pos = 0;
    
    // flattens the array and save it in "flat" list
    private void flatten(List<NestedInteger> nestedList) {
        for (NestedInteger item : nestedList) {
            if (item.isInteger()) {
                flat.add(item.getInteger());
            } else {
                flatten(item.getList());
            }
        }
    }
    
    public NestedIterator(List<NestedInteger> nestedList) {
        flatten(nestedList);
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return flat.get(pos++);
    }

    @Override
    public boolean hasNext() {
        return pos < flat.size();
        
    }
}
