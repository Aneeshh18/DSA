import java.util.Stack;
//Queue using 2 stack
public class QueueStack {

        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public boolean isEmpty(){
            return s1.isEmpty();
        }

        public void add( int data){         //2 while loop 1 after other => O(n)
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s1.push(data);
            while (!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        public void remove(){
            if(isEmpty()){
                System.out.println("is empty");
                return;
            }
            s1.pop();
        }

        public int peek(){
            if(isEmpty()){
                System.out.println("is empty");
                return -1;
            }
            return s1.peek();
        }
    public static void main(String[] args){
        QueueStack q = new QueueStack();
        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
