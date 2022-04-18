/**
 * Definition for polynomial singly-linked list.
 * class PolyNode {
 *     int coefficient, power;
 *     PolyNode next = null;
 
 *     PolyNode() {}
 *     PolyNode(int x, int y) { this.coefficient = x; this.power = y; }
 *     PolyNode(int x, int y, PolyNode next) { this.coefficient = x; this.power = y; this.next = next; }
 * }
 */

class Solution {
    public PolyNode addPoly(PolyNode p1, PolyNode p2) {
        
        PolyNode dummy = new PolyNode();
        PolyNode curr = dummy;
        
        while(p1 != null || p2 != null){
            
            int e1 = (p1 == null) ? -1: p1.power;
            int e2 = (p2 == null) ? -1: p2.power;
            
            if(e1 > e2) {
                
                curr.next = new PolyNode(p1.coefficient, p1.power);
                p1 = p1.next;
                curr = curr.next;
                
            }else if(e1 < e2){
                
                curr.next = new PolyNode(p2.coefficient, p2.power);
                p2 = p2.next;
                curr = curr.next;
                
            }else{
                
                if(p1.coefficient + p2.coefficient != 0){
                    curr.next = new PolyNode(p1.coefficient + p2.coefficient, p1.power);
                    curr = curr.next;
                }
                
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        
        return dummy.next;
    }
}

// ------------------------------------------------------
// better way
/**
 * Definition for polynomial singly-linked list.
 * class PolyNode {
 *     int coefficient, power;
 *     PolyNode next = null;
 
 *     PolyNode() {}
 *     PolyNode(int x, int y) { this.coefficient = x; this.power = y; }
 *     PolyNode(int x, int y, PolyNode next) { this.coefficient = x; this.power = y; this.next = next; }
 * }
 */

class Solution {
    public PolyNode addPoly(PolyNode p1, PolyNode p2) {
        
        PolyNode dummy = new PolyNode();
        PolyNode head = dummy;
        
        while(p1 != null && p2 != null){
            
            int e1 = p1.power;
            int e2 = p2.power;
            
            if (e1 > e2) {
                
                head.next = new PolyNode(p1.coefficient, p1.power);
                p1 = p1.next;
                head = head.next;
                
            } else if (e1 < e2){
                
                head.next = new PolyNode(p2.coefficient, p2.power);
                p2 = p2.next;
                head = head.next;
                
            } else{
                
                if (p1.coefficient + p2.coefficient != 0){
                    head.next = new PolyNode(p1.coefficient + p2.coefficient, p1.power);
                    head = head.next;
                }
                
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        
        if (p1 != null) head.next = p1;
        if (p2 != null) head.next = p2;
        
        return dummy.next;
    }
}