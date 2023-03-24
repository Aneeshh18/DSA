public class QueueLin {

    static class Node {
        int data;
        Node next;

        Node( int data ) {
            this.data = data;
            this.next = null;
        }
    }

    static class queueLin {
        static Node head = null;
        static Node tail = null;

        public boolean isEmpty() {
            return head == null && tail == null;
        }

        public void add( int i ) {
            Node newNode = new Node(i);
            if (head == null) {
                head = tail = newNode;
                return;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        public void remove() {
            if (isEmpty()) {
                System.out.println("que is empty");
                return;
            }
            int front = head.data;
            if (tail == head) {
                tail = head = null;
            } else {
                head = head.next;
            }
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("que empty");
                return -1;
            }
            return head.data;
        }

        public static void main( String[] args ) {
            queueLin q = new queueLin();
            q.add(1);
            q.add(2);
            q.add(3);

            while (!q.isEmpty()){
                System.out.println(q.peek());
                q.remove();
            }
        }
    }
}
