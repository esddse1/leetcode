package unfinished;

public class Solution {
      public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


    public static void main(String[] args){
        Solution solution=new Solution();
        TreeNode treeNode2=new TreeNode(2);
        TreeNode treeNode3=new TreeNode(1);
        treeNode2.left=treeNode3;
        System.out.println(solution.inorderSuccessor(treeNode2,new TreeNode(2)).val);
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        InnerSearch innerSearch=new InnerSearch();
        return innerSearch.inorderSuccessor(root,p);
    }

    class InnerSearch{
        TreeNode p;
        boolean hasSearch=false;
        TreeNode result=null;

        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            this.p=p;
            this.hasSearch=false;
            this.result=null;
            search(root);
            return result;
        }

        public void search(TreeNode root){
            if (root==null) return ;
            if (result!=null) return ;
            if (root.val == p.val){
                hasSearch=true;
            }

            search(root.left);
            if (hasSearch && result==null && root.val>p.val)
                result=root;
            search(root.right);

        }
    }
}
