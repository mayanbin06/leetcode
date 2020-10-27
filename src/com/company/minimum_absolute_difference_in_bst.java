package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class minimum_absolute_difference_in_bst {

    // 前序递归实现
    public void getMinimumDifference1(TreeNode root) {
        if (root == null) return ;
        // visit
        getMinimumDifference(root.left);
        getMinimumDifference(root.right);

    }
    // 中序递归实现
    public void getMinimumDifference2(TreeNode root) {
        if (root == null) return ;
        getMinimumDifference(root.left);
        // visit
        getMinimumDifference(root.right);

    }

    public static TreeNode createTree() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(17);
        return root;
    }
    public int getMinimumDifference(TreeNode root) {

        int minVal = Integer.MAX_VALUE;
        int pre = 0;
        boolean tag = false;
        // 中序遍历
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode node = root;
        while (node != null || !treeNodeStack.isEmpty()) {
            while(node != null) {
                treeNodeStack.push(node);
                node = node.left;
            }
            if (!treeNodeStack.isEmpty()) {
                node = treeNodeStack.pop();
                if (!tag) {
                    tag = true;
                } else {
                    if (node.val - pre < minVal) {
                        minVal = node.val - pre;
                    }
                }
                pre = node.val;
                node = node.right;
            }
        }

        return minVal;
    }
}
