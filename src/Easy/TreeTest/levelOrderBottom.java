package Easy.TreeTest;

import java.util.*;


/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 **/

/**
 * @author 马世臣
 * @// TODO: 2020/1/18  107. 二叉树的层次遍历 II*/
public class levelOrderBottom {
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists=new ArrayList<>();
        Stack<List<Integer>> stack=new Stack<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if(root!=null){
            queue.offer(root);
        }
        while (!queue.isEmpty()){
            List<Integer> list=new ArrayList<>();
            List<TreeNode> treeNodeList=new ArrayList<>();
            while (queue.size()!=0){
                TreeNode treeNode=queue.poll();
                list.add(treeNode.val);
                if(treeNode.left!=null){
                    treeNodeList.add(treeNode.left);
                }
                if(treeNode.right!=null){
                    treeNodeList.add(treeNode.right);
                }
            }
            for (TreeNode treeNode:treeNodeList){
                queue.offer(treeNode);
            }
            stack.push(list);
        }
        while (stack.size()!=0){
            lists.add(stack.pop());
        }
        return lists;
    }

    /**
     * public List<List<Integer>> levelOrderBottom(TreeNode root) {
     *         LinkedList<List<Integer>> result = new LinkedList<>();
     *         if (root == null)
     *             return result;
     *         Queue<TreeNode> queue = new LinkedList<>();
     *         queue.add(root);
     *         while (!queue.isEmpty()) {
     *             List<Integer> oneLevel = new ArrayList<>();
     *             // 每次都取出一层的所有数据
     *             int count = queue.size();
     *             for (int i = 0; i < count; i++) {
     *                 TreeNode node = queue.poll();
     *                 oneLevel.add(node.val);
     *                 if (node.left != null)
     *                     queue.add(node.left);
     *                 if (node.right != null)
     *                     queue.add(node.right);
     *             }
     *             // 每次都往队头塞
     *             result.addFirst(oneLevel);
     *         }
     *         return result;
     *     }*/

    public static void main(String[] args) {
        TreeNode treeNode1=new TreeNode(3);
        TreeNode treeNode2=new TreeNode(9);
        TreeNode treeNode3=new TreeNode(20);
        TreeNode treeNode4=new TreeNode(15);
        TreeNode treeNode5=new TreeNode(1);

        treeNode1.left=treeNode2;
        treeNode1.right=treeNode3;
        treeNode3.left=treeNode4;
        treeNode3.right=treeNode5;
        for (List<Integer> list:levelOrderBottom(treeNode1)){
            for (int i:list){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
