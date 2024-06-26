package org.klim405;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.klim405.task2.BTree;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BTreeTest {
    @Test
    @DisplayName("Проверка вставки")
    public void checkInsert() {
        BTree btree = new BTree(4);
        btree.insert(10);
        btree.insert(12);
        btree.insert(5);
        btree.insert(7);
        btree.insert(8);
        assertTrue(btree.contains(10));
        assertTrue(btree.contains(12));
        assertTrue(btree.contains(5));
        assertTrue(btree.contains(7));
        assertTrue(btree.contains(8));
    }

    @Test
    @DisplayName("Проверка находится ли элемент в дереве")
    public void checkContain() {
        BTree btree = new BTree(4);
        btree.insert(1);
        btree.insert(12);
        btree.insert(5);
        btree.insert(4);
        btree.insert(8);
        assertTrue(btree.contains(12));
        assertFalse(btree.contains(0));
        assertFalse(btree.contains(100));
    }
}
