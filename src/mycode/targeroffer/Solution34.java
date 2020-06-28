package mycode.targeroffer;
import java.util.ArrayList;

//题解引用出处：https://cyc2018.github.io/CS-Notes/#/
//34. 二叉树中和为某一值的路径
//题目描述
//输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
// 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
//如下的二叉树有两条和为 22 的路径：10, 5, 7 和 10, 12
//     10
//     /\
//    5 12
//   /\
//  4 7

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

public class Solution34 {
    private ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        backtracking(root, target, new ArrayList<>());
        return ret;
    }

    private void backtracking(TreeNode node, int target, ArrayList<Integer> path) {
        if (node == null)
            return;
        path.add(node.val);
        target -= node.val;
        if (target == 0 && node.left == null && node.right == null) {
            ret.add(new ArrayList<>(path));
        } else {
            backtracking(node.left, target, path);
            backtracking(node.right, target, path);
        }
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        //构造排序二叉树
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(12);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(7);
        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node1.right=node4;

        Solution34 instance = new Solution34();
        int target = 22;
        ArrayList<ArrayList<Integer>> retPath = null;
        retPath = instance.FindPath(root, target);
        for(int i=0;i<retPath.size();i++){
            System.out.print("retPath["+i+"]: ");
            for(Integer val: retPath.get(i)){
                System.out.print(val+" ");
            }
            System.out.println();
        }
    }

}
