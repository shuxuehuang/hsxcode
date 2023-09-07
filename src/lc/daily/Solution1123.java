package lc.daily;

import javafx.util.Pair;

import java.util.PriorityQueue;

public class Solution1123 {
    /*TreeNode ans;
    int maxDepth;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root, 0);
        return ans;
    }
    public int dfs(TreeNode root, int dept){
        if (root == null){
            maxDepth = Math.max(maxDepth, dept);
            return dept;
        }
        int leftDept = dfs(root.left, dept + 1);
        int rightDept = dfs(root.right, dept + 1);
        if (leftDept == rightDept && leftDept == maxDepth){
            ans = root;
        }
        return Math.max(leftDept, rightDept);
    }*/
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).getValue();
    }
    public Pair<Integer, TreeNode> dfs(TreeNode root){
        if (root == null){
            return new Pair<>(0, null);
        }
        Pair<Integer, TreeNode> left = dfs(root.left);
        Pair<Integer, TreeNode> right = dfs(root.right);
        if (left.getKey() > right.getKey()){
            return new Pair<>(left.getKey() + 1, left.getValue());
        }
        if (left.getKey() < right.getKey()){
            return new Pair<>(right.getKey() + 1, right.getValue());
        }
        return new Pair<>(left.getKey(), root);
    }

}
