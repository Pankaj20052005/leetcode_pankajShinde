class MyLinkedList {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }

    ListNode dummy;
    int size;

    public MyLinkedList() {
        dummy = new ListNode(0);
        size = 0;
    }

    public int get(int index) {
        if(index < 0 || index >= size) return -1;

        ListNode curr = dummy.next;
        for(int i=0;i<index;i++){
            curr = curr.next;
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    public void addAtIndex(int index, int val) {
        if(index > size) return;
        if(index < 0) index = 0;

        ListNode prev = dummy;
        for(int i=0;i<index;i++){
            prev = prev.next;
        }

        ListNode node = new ListNode(val);
        node.next = prev.next;
        prev.next = node;
        size++;
    }

    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size) return;

        ListNode prev = dummy;
        for(int i=0;i<index;i++){
            prev = prev.next;
        }

        prev.next = prev.next.next;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */