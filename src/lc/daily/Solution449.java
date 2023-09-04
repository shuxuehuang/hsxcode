package lc.daily;

public class Solution449 {
    StringBuilder sb = new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null){
            return null;
        }
        traver(root);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    public void traver(TreeNode root){
        if (root == null) return;
        sb.append(root.val + ",");
        traver(root.left);
        traver(root.right);
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0){
            return null;
        }
        String[] nodes= data.split(",");
        TreeNode root = null;
        for (int i = 0; i < nodes.length; i++) {
            int val = Integer.valueOf(nodes[i]);
            root = insert(root, val);
        }
        return root;
    }
    public TreeNode insert(TreeNode root, int val){
        if (root == null){
            return new TreeNode(val);
        }
        if (val > root.val){
            root.right = insert(root.right, val);
        }else {
            root.left = insert(root.left, val);
        }
        return root;
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
