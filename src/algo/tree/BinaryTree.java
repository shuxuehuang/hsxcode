package algo.tree;

public class BinaryTree {
    private Node tree;

    public Node find(int value){
        if (tree == null){
            return null;
        }
        Node p = tree;
        while (p != null){
            if (p.data > value){
                p = p.left;
            }else if (p.data < value){
                p = p.right;
            }else {
                return p;
            }
        }
        return null;
    }
    public void insert(int value){
        if (tree == null){
            tree = new Node(value);
            return;
        }
        Node p = tree;
        while (p != null){
            if (value > p.data){
                if (p.right == null){
                    p.right = new Node(value);
                    return;
                }
                p = p.right;
            }else {
                if (p.left == null){
                    p.left = new Node(value);
                    return;
                }
                p = p.left;
            }
        }
    }

    public void delete(int value){
        if (tree == null){
            return;
        }
        Node p = tree;
        Node pp = null;
        while (p != null && p.data != value){
            pp = p;
            if(p.data < value){
                p = p.right;
            }else {
                p = p.left;
            }
        }
        if (p == null) return;
        if (p.left != null && p.right != null){
            Node min = p.right;
            Node minP = p;
            while (min != null && min.left != null){
                minP = min;
                min = min.left;
            }
            p.data = min.data;
            minP.left = null;
        } else if (p.left != null && p.right == null){
            p.data = p.left.data;
            p.left = null;
        }else if(p.left == null && p.right != null){
            p.data = p.right.data;
            p.right = null;
        }else {
            if (pp.left == p){
                pp.left = null;
            }else {
                pp.right = null;
            }
        }
    }

    public Node searchBst(Node root, int target){
        if (root == null){
            return null;
        }
        if (root.data == target){
            return root;
        }else if (root.data > target){
            return searchBst(root.left, target);
        }else {
            return searchBst(root.right, target);
        }
    }

    public Node insertBST(Node root, int value){
        if (root == null){
         return new Node(value);
        }
        if (root.data > value){
            root.right = insertBST(root.right, value);
        }else {
            root.left = insertBST(root.left, value);
        }
        return root;
    }

    public Node deleteBST(Node root, int value){
        if (root == null){
            return null;
        }
        if (root.data > value){
            root.left = deleteBST(root.left, value);
        }else if (root.data < value){
            root.right = deleteBST(root.right, value);
        }else {
            if (root.right == null) return root.left;
            if (root.left == null) return root.right;
            if (root.left != null && root.right != null){
                Node tmp = root.right;
                while (tmp != null){
                    tmp = tmp.left;
                }
                root.data = tmp.data;
                root.right = deleteBST(root.right, tmp.data);
            }
        }
        return root;
    }














    class Node{
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
