public class triePrefixProb {
    static class Node {
        Node[] children = new Node[ 26 ];
        boolean eow = false;
        int freq;

        public Node() {
            for (int i = 0; i < 26; i++) {
                children[ i ] = null;
            }
            freq = 1;
        }
    }

    public static Node root = new Node();

    public static void insert( String word ) {       ///O(L)
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[ idx ] == null) {
                curr.children[ idx ] = new Node();
            } else {
                curr.children[ idx ].freq++;
            }
            curr = curr.children[ idx ];
        }
        curr.eow = true;
    }

    public static String findPrefix( String word ) { //O(L)
        StringBuilder prefix = new StringBuilder();
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            prefix.append(word.charAt(level));
            if (curr.children[ idx ].freq == 1) {
                return prefix.toString();
            }
            curr = curr.children[ idx ];
        }
        return prefix.toString();
    }

    public static void main( String[] args ) {
        String[] arr = { "dog", "zebra", "duck", "dove" };
        for (int i = 0; i < arr.length; i++) {
            insert(arr[ i ]);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(findPrefix(arr[ i ]));
        }
    }
}
