
public class QueueA {
      static int[] arr;
       static int size;
       static int rear;
       static int front;

    public QueueA( int n) {
        arr = new int[ n ];
        size = n;
        rear = -1;
        front = -1;
    }

    public boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public boolean isFull() {
            return ( rear + 1 ) % size == front;
        }

        public void add( int data ) {
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }
            if(front == -1){
                front =0;
            }
            rear = ( rear + 1 ) % size;
            arr[ rear ] = data;
        }

        public int remove() {
            if (isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            int result = arr[ front ];

            if (rear == front) {
                rear = front = -1;
            } else {
                front = ( front + 1 ) % size;
            }
            return result;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            return arr[ front ];
        }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        int i = front;
        while (i != rear) {
            System.out.print(arr[i] + " ");
            i = (i + 1) % size;
        }
        System.out.print(arr[rear] + " ");
    }

    public static void main(String[] args) {
        QueueA q = new QueueA(3);
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove());
        q.add(4);
        while (!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
