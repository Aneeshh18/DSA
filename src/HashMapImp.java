/*
import java.util.ArrayList;
import java.util.*;
public class HashMapImp {
    static class HashMap<K, V> {         //this class consist of internal implementation
        private class Node {            //Type of LL Node inside Bucket
            K key;
            V value;

            public Node( K key, V value ) {
                this.key = key;
                this.value = value;
            }
        }

        private int n;//Contains total number of nodes exists in hashmap    (n)
        private int N;
        private LinkedList<Node>[] buckets;  //is hashmap - array of linked list (N)

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key){
            int hc =  key.hashCode();
            return Math.abs(hc) % N;
        }
        private int SearchInll(K key, int bi){
            LinkedList<Node> ll = buckets[ bi ];

            int di = 0;
            for (int i =0; i< ll.size; i++){
                Node node = ll.get(i);
                if(node.key == key){
                    return di;
                }
                di++;
            }
            return -1;
        }

        private void rehash(){
            LinkedList<Node> oldbuck[] = buckets;
            buckets = new LinkedList[N*2];
            for (int i = 0 ; i< buckets.length; i++){
                buckets[i] = new LinkedList<>();
            }

            for (int i = 0 ; i< oldbuck.length; i++) {
                LinkedList<Node>ll = oldbuck[i];
                for (int j = 0 ; j< ll.size; j++){
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value){
            int bi = hashFunction(key);     //index in buckets arr (0 - size -1)
            int di = SearchInll(key, bi);       //index of linked list in the bucket arr  (Valid , -1)

            if(di != -1){
                Node node = buckets[bi].get(di);
                node.value = value;
            } else {
                buckets[bi].add(new Node(key, value));
                n++;
            }

            double lambda = (double) n/N;
            if(lambda > 2.0){
                rehash();
            }
        }

        public boolean containsKey(K key){
            return false;
        }

        public V remove (K key){
            return null;
        }
    }

    public void main(String[] args){
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 200);
    }

}*/
