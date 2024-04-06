package org.klim405.task2;

public class BTree {

    private final int t;

    // Создаем узел
    public class Node {
        int n;
        int[] key = new int[2 * t - 1];
        Node[] child = new Node[2 * t];
        boolean leaf = true;

        public int find(int k) {
            for (int i = 0; i < this.n; i++) {
                if (this.key[i] == k) {
                    return i;
                }
            }
            return -1;
        }
    }

    public BTree(int t) {
        this.t = t;
        root = new Node();
        root.n = 0;
        root.leaf = true;
    }

    private Node root;

    // Поиск ключа
    private Node search(Node x, int key) {
        int i = 0;
        if (x == null)
            return x;
        for (i = 0; i < x.n; i++) {
            if (key < x.key[i]) {
                break;
            }
            if (key == x.key[i]) {
                return x;
            }
        }
        if (x.leaf) {
            return null;
        } else {
            return search(x.child[i], key);
        }
    }

    // Разбиение узла
    private void split(Node x, int pos, Node y) {
        Node z = new Node();
        z.leaf = y.leaf;
        z.n = t - 1;
        if (!y.leaf) {
            for (int j = 0; j < t; j++) {
                z.child[j] = y.child[j + t];
            }
        }
        y.n = t - 1;
        for (int j = x.n; j >= pos + 1; j--) {
            x.child[j + 1] = x.child[j];
        }
        x.child[pos + 1] = z;

        for (int j = x.n - 1; j >= pos; j--) {
            x.key[j + 1] = x.key[j];
        }
        x.key[pos] = y.key[t - 1];
        x.n = x.n + 1;
    }

    // Вставка значения
    public void insert(final int key) {
        Node r = root;
        if (r.n == 2 * t - 1) {
            Node s = new Node();
            root = s;
            s.leaf = false;
            s.n = 0;
            s.child[0] = r;
            split(s, 0, r);
            insertValue(s, key);
        } else {
            insertValue(r, key);
        }
    }

    // Вставка узла
    private void insertValue(Node x, int k) {
        if (x.leaf) {
            int i = 0;
            for (i = x.n - 1; i >= 0 && k < x.key[i]; i--) {
                x.key[i + 1] = x.key[i];
            }
            x.key[i + 1] = k;
            x.n = x.n + 1;
        } else {
            int i = 0;
            for (i = x.n - 1; i >= 0 && k < x.key[i]; i--) {
            }
            i++;
            Node tmp = x.child[i];
            if (tmp.n == 2 * t - 1) {
                split(x, i, tmp);
                if (k > x.key[i]) {
                    i++;
                }
            }
            insertValue(x.child[i], k);
        }

    }

    public void show() {
        show(root);
    }

    // Вывод на экран
    private void show(Node x) {
        if (x == null) return;
        for (int i = 0; i < x.n; i++) {
            System.out.print(x.key[i] + " ");
        }
        if (!x.leaf) {
            for (int i = 0; i < x.n + 1; i++) {
                show(x.child[i]);
            }
        }
    }

    // Проверка, содержится ли ключ
    public boolean contain(int k) {
        return this.search(root, k) != null;
    }

    public static void main(String[] args) {
        BTree b = new BTree(3);
        b.insert(8);
        b.insert(9);
        b.insert(10);
        b.insert(11);
        b.insert(12);
        b.insert(13);
        b.insert(14);

        b.show();

        if (b.contain(12)) {
            System.out.println("\nнайдено");
        } else {
            System.out.println("\nне найдено");
        }
        ;
    }
}