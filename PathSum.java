import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class PathSum {
    /*
    112.Path Sum
    다시 풀어보기
     */

    public static void main(String[] args) {

//        TreeNode node1 = new TreeNode(2, null, null);
//        TreeNode root = new TreeNode(1, node1, null);
        TreeNode node8 = new TreeNode(1, null, null);
        TreeNode node7 = new TreeNode(4, null, node8);
        TreeNode node6 = new TreeNode(13, null, null);
        TreeNode node5 = new TreeNode(8, node6, node7);
        TreeNode node4 = new TreeNode(2, null, null);
        TreeNode node3 = new TreeNode(7, null, null);
        TreeNode node2 = new TreeNode(11, node3, node4);
        TreeNode node1 = new TreeNode(4, node2, null);
        TreeNode root = new TreeNode(5, node1, node5);

        System.out.println(hasPathSum(root, 22));

    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        Map<TreeNode, Integer> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> candidates = new ArrayList<>();

        if(root == null) return false;

        map.put(root, root.val);
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if(current.left != null) {
                stack.push(current.left);
                map.put(current.left, map.get(current) + current.left.val);
            }
            if(current.right != null) {
                stack.push(current.right);

                map.put(current.right, map.get(current) + current.right.val);
            }
            if(current.left == null && current.right == null) {
                candidates.add(map.get(current));
            }
        }

        for(int val : candidates) {
            if(val == targetSum) return true;
        }
        return false;
    }

    
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
    }



}
