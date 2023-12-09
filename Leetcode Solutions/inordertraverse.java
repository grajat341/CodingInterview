class Solution {
    List<Integer> s= new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root ==null){
            return new ArrayList<>();
        }
         inorderTraversal(root.left);
         s.add(root.val);
         inorderTraversal( root.right);
         return s;
    }
}