
public class LinkedList {

    public static Node head;
    public static Node tail;
    int size;
    public static class Node {    //class node
        int data;
        Node next;

        public Node( int data ) {        //constructor
            this.data = data;
            this.next = null;
        }
    }


        public void addFirst(int data ){     //add cons  O(n)
            Node newNode = new Node(data);
            size++;
            if(head == null ){
                head = tail = newNode;
             return;
            }
            newNode.next = head;
            head = newNode;
        }


        public void last(int data ){               //add in last cons O(n)
            Node newNode = new Node(data);
            size++;
            if(head == null ){
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        public void between(int idx, int data){
        if(idx == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while(i < idx-1){
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        }

        public int removeFirst(){
        if (size == 0){
            System.out.println("Empty List");
            return Integer.MAX_VALUE;
        }
        else if(size == 1){
            int value = head.data;
            head = tail = null;
            size = 0;
            return value;
            }
        int value = head.data;
        head = head.next;
        size--;
        return value;
        }

        public int removeLast(){
        if (size == 0){
            System.out.println("Empty List");
            return Integer.MAX_VALUE;
        }
        else if(size == 1){
            int value = head.data;
            head = tail = null;
            size = 0;
            return value;
        }
        Node prev = head;
        for (int i = 0; i < size -2; i++){
            prev = prev.next;
        }
        int value = prev.next.data;
        prev.next = null;
        size--;
        return value;
    }
        public void print(){
            Node temp = head;
            while (temp != null){
                System.out.print(temp.data + "->");
                temp = temp.next;
            }
            System.out.println("Null");
        }


        public int helper(Node head , int key) {        //O(n)
            if (head == null) {
                return -1;
            }
            if (head.data == key) {
                return 0;
            }
            int idx = helper(head.next, key);
            if (idx == -1) {
                return -1;
            }
            return idx + 1;
        }

            public int recSearch(int key){
                return helper(head, key);
            } // searching tho rec


        public void delFromEnd(int n){
        int sz = 0;
        Node temp = head;
        while(temp == null){
            temp = temp.next;
            sz++;
        }

        if(n ==sz){
            head = head.next;
            return;
        }
        int i = 1;
        int toFind = sz - n;
        Node prev = head;
        while (i < toFind){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
        }


         // TO CHECK PALINDROME IMP --
        public Node findMid(Node head){        //helper
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;  //+1 ==mid
            fast = fast.next.next;  //+2 end
        }
        return slow;
        }


        public boolean checkPalin() {                      //step1
            if (head == null || head.next == null) {
                return true;
            }


            Node midNode = findMid(head);                  //step 2
            Node prev = null;
            Node curr = midNode;
            Node next;
            while (curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            Node right = prev;
            Node left = head;


            while (right != null) {
                if (left.data != right.data) {
                    return false;
                }
                left = left.next;
                right = right.next;
            }
            return true;
        }


        //detecting and removing cycle in a linked list
        public static void removeCycle(){
        Node slow = head;
        Node fast = head;
        boolean Cycle = false;
        while (fast !=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                Cycle = true;
                break;
            }
        }
        if (Cycle = true){
            return;
        }
        slow = head;
        Node prev = null;
        while(slow != fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = null;
    }

    // Merge sort in a linked list

    private Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Node merge(Node head1, Node head2) {
        Node mergeLL = new Node (-1);
        Node temp = mergeLL;
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while (head1!= null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2!= null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergeLL.next;
    }
    public Node mergeSort(Node head) {
        if (head == null || head.next == null){
            return head;
        }
        //find mid
        Node mid = getMid(head);

        //left & right MS
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        //merge
        return merge(newLeft, newRight);
    }



    //Zig Zag ll
    public void zikZag(){
        //find mid
        Node slow = head;
        Node fast = head.next;
        while(fast != null  && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        //reverse second half 3var&4 step
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while (curr !=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
             curr = next;
        }

        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        //alternate merge
        while(left != null && right != null) {
                nextL = left.next;
                left.next = right;
                nextR = right.next;
                right.next = nextL;

                left = nextL;
                right = nextR;
        }
    }

        public static void main( String[] args ) {
        LinkedList list = new LinkedList();
       /* list.addFirst(3);
        list.addFirst(4);
        list.addFirst(6);
        list.last(2);
        list.between(1, 5);

        list.print();
        System.out.println(list.size);
        System.out.println(list.recSearch(22));*/
//            list.last(1);
//            list.last(6);
//            list.last(2);
//            list.last(1);
//        System.out.println(list.checkPalin());


            // for merge list
            list.addFirst(1);
            list.addFirst(2);
            list.addFirst(3);
            list.addFirst(4);
            list.addFirst(5);

            list.print();
            list.head = list.mergeSort(list.head);
            list.print();


          /*  // zig zag
            list.addFirst(1);
            list.addFirst(2);
            list.addFirst(3);
            list.addFirst(4);
            list.addFirst(5);
            list.print();
            list.zikZag();
            list.print();*/

    }
}

