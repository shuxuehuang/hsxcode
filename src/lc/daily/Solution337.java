package lc.daily;

import java.text.DateFormatSymbols;
import java.util.HashMap;
import java.util.Map;

public class Solution337 {
    Map<TreeNode, Integer> memo;
    public int rob(TreeNode root) {
        memo = new HashMap<>();
        return dfs(root);
    }
    public int dfs(TreeNode root){
        if (root == null){
            return 0;
        }
        if (memo.containsKey(root)){
            return memo.get(root);
        }
        int did = root.val;
        if (root.left != null){
            did += dfs(root.left.left) + dfs(root.left.right);
        }
        if (root.right != null){
            did += dfs(root.right.left) + dfs(root.right.right);
        }
        int notDid = dfs(root.right) + dfs(root.left);
        memo.put(root, Math.max(did, notDid));
        return Math.max(did, notDid);
    }
}
