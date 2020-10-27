package com.company;

import java.util.Random;

public class BSTreeTest {

    public static void test() {
        Random random = new Random();
        BSTree tree = new BSTree<Integer>();
        for (int i = 0; i < 5; i ++) {
            tree.add(random.nextInt(100));
        }
        System.out.println("--- 层序遍历 ---");
        tree.levelTraversal();
        System.out.println("--- 中序遍历 ---");
        tree.LDR();
        System.out.println("--- 前序遍历 ---");
        tree.DLR();
    }
}
