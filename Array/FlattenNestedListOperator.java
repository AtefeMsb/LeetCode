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
/**
 * Approach 1: Make a Flat List with Recursion in constructor
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
// --------------------------------------------------------------------------
/**
 * Stack
 */
public class NestedIterator implements Iterator<Integer> {
    
    Deque<NestedInteger> stack = new ArrayDeque<>();
    // In the constructor, we push all the nestedList into the stack from back to front, so when we pop the stack, it returns the very first element.
    public NestedIterator(List<NestedInteger> nestedList) {
        prepareStack(nestedList);
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            return null;
        }
        return stack.pop().getInteger();
    }

    // in the hasNext() function, we peek the first element in stack currently, and if it is an Integer,
    // we will return true and pop the element. If it is a list, we will further flatten it.
    // This is iterative version of flatting the nested list. Again, we need to iterate from the back to front of the list.
    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            List<NestedInteger> list = stack.pop().getList();
            prepareStack(list);
        }
        return !stack.isEmpty();
    }
    
    private void prepareStack(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }
}