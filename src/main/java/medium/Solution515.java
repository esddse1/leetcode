package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution515 {
    public static void main(String[] args){

    }

    public List<Integer> largestValues(TreeNode root) {
        if (root==null) return new ArrayList<>();
        List<Integer> result=new ArrayList<>();
        Queue<TreeNodeWarpper> queue=new LinkedList<>();
        int currentLevel=0;
        int max = 0;
        queue.add(new TreeNodeWarpper(root,1));
        while (!queue.isEmpty()){
            TreeNodeWarpper treeNodeWarpper=queue.poll();
            if (treeNodeWarpper.level>currentLevel) {
                if (currentLevel>0) result.add(max);
                max=treeNodeWarpper.treeNode.val;
                currentLevel=treeNodeWarpper.level;
            }
            else{
                max=Math.max(treeNodeWarpper.treeNode.val,max);
            }
            if (treeNodeWarpper.treeNode.left!=null)
                queue.add(new TreeNodeWarpper(treeNodeWarpper.treeNode.left,treeNodeWarpper.level+1));
            if (treeNodeWarpper.treeNode.right!=null)
                queue.add(new TreeNodeWarpper(treeNodeWarpper.treeNode.right,treeNodeWarpper.level+1));
        }
        result.add(max);
        return result;
    }


    class TreeNodeWarpper{
        TreeNode treeNode;
        int level;
        public TreeNodeWarpper(TreeNode treeNode,int level){
            this.treeNode=treeNode;this.level=level;
        }
    }
    public class TreeNode {
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
