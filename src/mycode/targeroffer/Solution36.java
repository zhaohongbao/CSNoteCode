package mycode.targeroffer;

//题解引用出处：https://cyc2018.github.io/CS-Notes/#/
//题目描述
//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
//

/**
 public class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;

 public TreeNode(int val) {
 this.val = val;

 }

 }
 */

public class Solution36 {

    private TreeNode pre = null;
    private TreeNode head = null;

    public TreeNode Convert(TreeNode root) {
        inOrder(root);
        return head;
    }

    private void inOrder(TreeNode node) {
        if (node == null)
            return;
        inOrder(node.left);
        node.left = pre;
        if (pre != null)
            pre.right = node;
        pre = node;
        if (head == null)
            head = node;
        inOrder(node.right);
    }

    public static void main(String[] args) {

        Solution36 instance = new Solution36();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node2.left=node1;
        node2.right=node3;

        TreeNode head=null;
        head = instance.Convert(node2);
        TreeNode cur = head;

        while(cur!=null){
            System.out.print(cur.val +" ");
            cur=cur.right;
        }

        System.out.println();
        cur = head;
        while(cur.right!=null){
            cur=cur.right;
        }
        while(cur!=null){
            System.out.print(cur.val +" ");
            cur=cur.left;
        }
    }

}
