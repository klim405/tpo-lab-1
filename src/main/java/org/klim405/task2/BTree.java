package org.klim405.task2;

public class BTree {
    final private int t;
    private Node root;

    public BTree(int t) {
        this.t = t;
        this.root = new Node(true);
    }

    public class Node {
        public int[] key;
        public Node[] child;
        public boolean leaf;
        public int n;

        public Node(boolean leaf) {
            key = new int[2*t-1];
            child = new Node[2*t];
            this.leaf = leaf;
            n = 0;
        }
    }
    public Integer search(Node x, int k) {
        int i = 1;
        while (i <= x.n && k > x.key[i-1]) {
            i = i + 1;
        }
        if (i <= x.n && k == x.key[i-1]) {
            return x.key[i-1];
        } else if (x.leaf) {
            return null;
        } else {
            return search(x.child[i-1], k);
        }
    }

    public Integer search(int k) {
        return search(root, k);
    }

    public boolean contains(int k) {
        return search(k) != null;
    }

    protected void splitChild(Node x, int i) {
        Node y = x.child[i-1];
        Node z = new Node(y.leaf);
        z.n = t - 1;
        for (int j = 1; j <= t-1 ; j++) {
            z.key[j-1] = y.key[j-1+t];
        }
        if (!y.leaf) {
            for (int j = 1; j <= t; j++) {
                z.child[j-1] = y.child[j-1+t];
            }
        }
        y.n = t - 1;
        for (int j = x.n + 1; j >= i + 1; j--) {
            x.child[j] = x.child[j-1];
        }
        x.child[i] = z;
        for (int j = x.n; j >= i; j--) {
            x.key[j] = x.key[j-1];
        }
        x.key[i-1] = y.key[t-1];
        x.n = x.n + 1;
    }

    public void insertNonFull(Node x, int k) {
        int i = x.n;
        if (x.leaf) {
            while (i >= 1 && k < x.key[i-1]) {
                x.key[i] = x.key[i-1];
                i = i - 1;
            }
            x.key[i] = k;
            x.n = x.n + 1;
        } else {
            while (i >= 1 && k < x.key[i-1]) {
                i = i - 1;
            }
            i = i + 1;
            if (x.child[i-1].n == 2*t - 1) {
                splitChild(x, i);
                if (k > x.key[i-1]) {
                    i = i + 1;
                }
            }
            insertNonFull(x.child[i-1], k);
        }
    }

    public void insert(int k) {
        Node r = root;
        if (r.n == 2*t - 1) {
            Node s = new Node(false);
            s.child[0] = r;
            root = s;
            splitChild(s, 1);
            insertNonFull(s, k);
        } else {
            insertNonFull(r, k);
        }
    }
}