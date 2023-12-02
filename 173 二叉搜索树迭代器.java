import java.util.ArrayList;
import java.util.List;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
}

class Main173 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        TreeNode cur = root;
        cur.left = new TreeNode(3);
        cur.right = new TreeNode(15);
        cur = cur.right;
        cur.left = new TreeNode(9);
        cur.right = new TreeNode(20);
        BSTIterator iterator = new BSTIterator(root);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

class BSTIterator {
    private int[] BSTArray;
    private int curIndex;

    public BSTIterator(TreeNode root) {
        List<Integer> valList = new ArrayList<>();
        BSTTraveler(root, valList);
        BSTArray = new int[valList.size()];
        curIndex = 0;
        for (int n: valList) {
            BSTArray[curIndex] = n;
            curIndex++;
        }
        curIndex = 0;
    }

    private void BSTTraveler(TreeNode curNode, List<Integer> valList) {
        if (curNode.left != null) {
            BSTTraveler(curNode.left, valList);
        }
        valList.add(curNode.val);
        if (curNode.right != null) {
            BSTTraveler(curNode.right, valList);
        }
    }

    public int next() {
        return BSTArray[curIndex++];
    }

    public boolean hasNext() {
        // System.out.println(curIndex);
        if (curIndex + 1 > BSTArray.length) {
            return false;
        } else {
            return true;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */