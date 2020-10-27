package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉搜索树
 * 树中不存在相同值的节点
 */
public class BSTree<T extends Comparable> {

    private int size;
    private TreeNode root;
    private TreeVisitor visitor = new DefaultVisitor();

    public class TreeNode {
        T val;
        TreeNode left;
        TreeNode right;
        public TreeNode(T val) { this.val = val; }
    }

    public interface TreeVisitor<T> {
        void visit(T t);
    }

    public class DefaultVisitor implements TreeVisitor<T> {
        @Override
        public void visit(T t) {
           System.out.println(t);
        }
    }

    public BSTree() {

    }

    public void add(T val) {
        if (root == null) {
            root = new TreeNode(val);
            return;
        }

        TreeNode node = root;
        while (true) {
            if (node.val.compareTo(val) < 0) {
                // 右子树
                if (node.right == null) {
                    node.right = new TreeNode(val);
                    break;
                } else {
                    node = node.right;
                }
            } else if (node.val.compareTo(val) > 0) {
                // 左子树
                if (node.left == null) {
                    node.left = new TreeNode(val);
                    break;
                } else {
                    node = node.left;
                }
            }
        }
    }

    public void remove(T val) {

    }

    public void levelTraversal() {
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);
        while (!treeNodeQueue.isEmpty()) {
           TreeNode node = treeNodeQueue.poll();
           if (node.left != null) {
               treeNodeQueue.add(node.left);
           }
           if (node.right != null) {
               treeNodeQueue.add(node.right);
           }
           visitor.visit(node.val);
        }
    }
    // 前序遍历
    public void DLR() {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode node = root;
        treeNodeStack.push(node);
        while(!treeNodeStack.isEmpty()) {
           node = treeNodeStack.pop();
           visitor.visit(node.val);

           if (node.right != null) {
               treeNodeStack.push(node.right);
           }
           if (node.left != null) {
               treeNodeStack.push(node.left);
           }
        }
    }
    // 中序遍历
    public void LDR() {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode node = root;
        while (node != null || !treeNodeStack.isEmpty()) {
            // 左子树走到头
            while(node != null) {
                treeNodeStack.push(node);
                node = node.left;
            }

            if (!treeNodeStack.isEmpty()) {
                node = treeNodeStack.pop();
                visitor.visit(node.val);
                // 访问右子树
                node = node.right;
            }
        }
    }
    // 后续遍历
    public void LRD() {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        Stack<TreeNode> treeNodeStack1 = new Stack<>();
        TreeNode node = root;
        treeNodeStack.push(node);
        while (!treeNodeStack.isEmpty()) {
            node = treeNodeStack.pop();
            treeNodeStack1.push(node);
            if (node.left != null) {
                treeNodeStack.push(node.left);
            }
            if (node.right != null) {
                treeNodeStack.push(node.right);
            }
        }
        while (!treeNodeStack1.isEmpty()) {
            visitor.visit(treeNodeStack1.pop().val);
        }
    }
}