package LinkedList;

public class ListNode {
    int val;
    ListNode next;
    ListNode prev;
    ListNode(int x) { val = x; }
  }
  
  class DoublyLinkedList {
    int size;
    // sentinel nodes as pseudo-head and pseudo-tail
    ListNode head, tail;
    public DoublyLinkedList() {
      size = 0;
      head = new ListNode(0);
      tail = new ListNode(0);
      head.next = tail;
      tail.prev = head;
    }
  
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
      // if index is invalid
      if (index < 0 || index >= size) return -1;
  
      // choose the fastest way: to move from the head
      // or to move from the tail
      ListNode curr = head;
      if (index + 1 < size - index)
        for(int i = 0; i < index + 1; ++i) curr = curr.next;
      else {
        curr = tail;
        for(int i = 0; i < size - index; ++i) curr = curr.prev;
      }
  
      return curr.val;
    }
  
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
      ListNode pred = head, succ = head.next;
  
      ++size;
      ListNode toAdd = new ListNode(val);
      toAdd.prev = pred;
      toAdd.next = succ;
      pred.next = toAdd;
      succ.prev = toAdd;
    }
  
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
      ListNode succ = tail, pred = tail.prev;
  
      ++size;
      ListNode toAdd = new ListNode(val);
      toAdd.prev = pred;
      toAdd.next = succ;
      pred.next = toAdd;
      succ.prev = toAdd;
    }
  
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
      // If index is greater than the length, 
      // the node will not be inserted.
      if (index > size) return;
  
      // [so weird] If index is negative, 
      // the node will be inserted at the head of the list.
      if (index < 0) index = 0;
  
      // find predecessor and successor of the node to be added
      ListNode pred, succ;
      if (index < size - index) {
        pred = head;
        for(int i = 0; i < index; ++i) pred = pred.next;
        succ = pred.next;
      }
      else {
        succ = tail;
        for (int i = 0; i < size - index; ++i) succ = succ.prev;
        pred = succ.prev;
      }
  
      // insertion itself
      ++size;
      ListNode toAdd = new ListNode(val);
      toAdd.prev = pred;
      toAdd.next = succ;
      pred.next = toAdd;
      succ.prev = toAdd;
    }
  
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
      // if the index is invalid, do nothing
      if (index < 0 || index >= size) return;
  
      // find predecessor and successor of the node to be deleted
      ListNode pred, succ;
      if (index < size - index) {
        pred = head;
        for(int i = 0; i < index; ++i) pred = pred.next;
        succ = pred.next.next;
      }
      else {
        succ = tail;
        for (int i = 0; i < size - index - 1; ++i) succ = succ.prev;
        pred = succ.prev.prev;
      }
  
      // delete pred.next 
      --size;
      pred.next = succ;
      succ.prev = pred;
    }
  }
  ////////////////////////////////////////////////////////////////////////////////
  // Definition for doubly-linked list.
class DoublyListNode {
  int val;
  DoublyListNode next, prev;
  DoublyListNode(int x) {val = x;}
}

class MyLinkedList {
  private DoublyListNode head;
  /** Initialize your data structure here. */
  public MyLinkedList() {
      head = null;
  }
  
  /** Helper function to return the index-th node in the linked list. */
  private DoublyListNode getNode(int index) {
      DoublyListNode cur = head;
      for (int i = 0; i < index && cur != null; ++i) {
          cur = cur.next;
      }
      return cur;
  }
  /** Helper function to return the last node in the linked list. */
  private DoublyListNode getTail() {
      DoublyListNode cur = head;
      while (cur != null && cur.next != null) {
          cur = cur.next;
      }
      return cur;
  }
  /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
  public int get(int index) {
      DoublyListNode cur = getNode(index);
      return cur == null ? -1 : cur.val;
  }

  /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
public void addAtHead(int val) {
  DoublyListNode cur = new DoublyListNode(val);
  cur.next = head;
  if (head != null) {
      head.prev = cur;
  }
  head = cur;
  return;
}

/** Append a node of value val to the last element of the linked list. */
public void addAtTail(int val) {
  if (head == null) {
      addAtHead(val);
      return;
  }
  DoublyListNode prev = getTail();
  DoublyListNode cur = new DoublyListNode(val);
  prev.next = cur;
  cur.prev = prev;
}

  /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If      index is greater than the length, the node will not be inserted. */
  public void addAtIndex(int index, int val) {
      if (index == 0) {
          addAtHead(val);
          return;
      }
      DoublyListNode prev = getNode(index - 1);
      if (prev == null) {
          return;
      }
      DoublyListNode cur = new DoublyListNode(val);
      DoublyListNode next = prev.next;
      cur.prev = prev;
      cur.next = next;
      prev.next = cur;
      if (next != null) {
          next.prev = cur;
      }
  }
  
  /** Delete the index-th node in the linked list, if the index is valid. */
  public void deleteAtIndex(int index) {
      DoublyListNode cur = getNode(index);
      if (cur == null) {
          return;
      }
      DoublyListNode prev = cur.prev;
      DoublyListNode next = cur.next;
      if (prev != null) {
          prev.next = next;
      } else {
          // modify head when deleting the first node.
          head = next;
      }
      if (next != null) {
          next.prev = prev;
      }
  }
  
}