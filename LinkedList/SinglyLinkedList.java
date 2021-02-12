package LinkedList;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }

public class SinglyLinkedList {

  int size;
  ListNode head;  // sentinel node as pseudo-head
  public MyLinkedList() {
    size = 0;
    head = new ListNode(0);
  }

  /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
  public int get(int index) {
    // if index is invalid
    if (index < 0 || index >= size) return -1;

    ListNode curr = head;
    // index steps needed 
    // to move from sentinel node to wanted index
    for(int i = 0; i < index + 1; ++i) curr = curr.next;
    return curr.val;
  }

  /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
  public void addAtHead(int val) {
    addAtIndex(0, val);
  }

  /** Append a node of value val to the last element of the linked list. */
  public void addAtTail(int val) {
    addAtIndex(size, val);
  }

  /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
  public void addAtIndex(int index, int val) {
    // If index is greater than the length, 
    // the node will not be inserted.
    if (index > size) return;

    // [so weird] If index is negative, 
    // the node will be inserted at the head of the list.
    if (index < 0) index = 0;

    ++size;
    // find predecessor of the node to be added
    ListNode pred = head;
    for(int i = 0; i < index; ++i) pred = pred.next;

    // node to be added
    ListNode toAdd = new ListNode(val);
    // insertion itself
    toAdd.next = pred.next;
    pred.next = toAdd;
  }

  /** Delete the index-th node in the linked list, if the index is valid. */
  public void deleteAtIndex(int index) {
    // if the index is invalid, do nothing
    if (index < 0 || index >= size) return;

    size--;
    // find predecessor of the node to be deleted
    ListNode pred = head;
    for(int i = 0; i < index; ++i) pred = pred.next;

    // delete pred.next 
    pred.next = pred.next.next;
  }
    
}

////////////////////////////////////////////////////////
// Definition for singly-linked list.
public class SinglyListNode {
  int val;
  SinglyListNode next;
  SinglyListNode(int x) { val = x; }
}

class MyLinkedList {

  private SinglyListNode head;
  /** Initialize your data structure here. */
  public MyLinkedList() {
      head = null;
  }
  
  /** Helper function to return the index-th node in the linked list. */
  private SinglyListNode getNode(int index) {
      SinglyListNode cur = head;
      // illegal index returns null
      if (index < 0) return null;
      for (int i = 0; i < index && cur != null; ++i) {
          cur = cur.next;
      }
      return cur;
  }
  /** Helper function to return the last node in the linked list. */
  private SinglyListNode getTail() {
      SinglyListNode cur = head;
      while (cur != null && cur.next != null) {
          cur = cur.next;
      }
      return cur;
  }
  /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
  public int get(int index) {
      SinglyListNode cur = getNode(index);
      return cur == null ? -1 : cur.val;
  }

  
  /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
  public void addAtHead(int val) {
      SinglyListNode cur = new SinglyListNode(val);
      cur.next = head;
      head = cur;
      return;
  }

  /** Append a node of value val to the last element of the linked list. */
  public void addAtTail(int val) {
      if (head == null) {
          addAtHead(val);
          return;
      }
      SinglyListNode prev = getTail();
      SinglyListNode cur = new SinglyListNode(val);
      prev.next = cur;
  }

  /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
  public void addAtIndex(int index, int val) {
      if (index == 0) {
          addAtHead(val);
          return;
      }
      SinglyListNode prev = getNode(index - 1);
      if (prev == null) {
          return;
      }
      SinglyListNode cur = new SinglyListNode(val);
      SinglyListNode next = prev.next;
      cur.next = next;
      prev.next = cur;
  }

  
  /** Delete the index-th node in the linked list, if the index is valid. */
  public void deleteAtIndex(int index) {
      SinglyListNode cur = getNode(index);
      if (cur == null) {
          return;
      }
      SinglyListNode prev = getNode(index - 1);
      SinglyListNode next = cur.next;
      if (prev != null) {
          prev.next = next;
      } else {
          // modify head when deleting the first node.
          head = next;
      }
  }
}