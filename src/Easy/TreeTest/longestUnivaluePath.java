package Easy.TreeTest;



/**
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 *
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 *
 * 示例 1:
 *
 * 输入:
 *
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           1   1   5
 * 输出:
 *
 * 2
 * 示例 2:
 *
 * 输入:
 *
 *               1
 *              / \
 *             4   5
 *            / \   \
 *           4   4   5
 * 输出:
 *
 * 2
 * 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。
 **/

/**
 * @author 马世臣 
 * @// TODO: 2020/1/22 687. 最长同值路径 */
public class longestUnivaluePath {

    public int longestUnivaluePath(TreeNode root) {
            if(root==null){
                return 0;
            }else if(root.left==null&&root.right==null){
                return 0;
            }else if(root.left!=null&&root.left.val==root.val&&(root.right==null||root.right.val!=root.val)){
                return longestUnivaluePath(root.left)+1;
            }else if(root.right!=null&&root.right.val==root.val&&(root.left==null||root.left.val!=root.val)){
                return longestUnivaluePath(root.right)+1;
            }else if((root.left.val==root.val)&&(root.right.val==root.val)){
                return search(root.left)+search(root.right)+2;
            }else {
                return Math.max(longestUnivaluePath(root.left),longestUnivaluePath(root.right));
            }
        }

        public int search(TreeNode root){
            if(root==null){
                return 0;
            }else if(root.left==null&&root.right==null){
                return 0;
            }else if(root.left!=null&&root.left.val==root.val&&(root.right==null||root.right.val!=root.val)){
                return longestUnivaluePath(root.left)+1;
            }else if(root.right!=null&&root.right.val==root.val&&(root.left==null||root.left.val!=root.val)){
                return longestUnivaluePath(root.right)+1;
            }else if((root.left.val==root.val)&&(root.right.val==root.val)){
                return Math.max(longestUnivaluePath(root.left),longestUnivaluePath(root.right))+1;
            }else {
                return Math.max(longestUnivaluePath(root.left),longestUnivaluePath(root.right));
            }
    }

    /**
     * int ans;
     *     public int longestUnivaluePath(TreeNode root) {
     *         ans = 0;
     *         arrowLength(root);
     *         return ans;
     *     }
     *     public int arrowLength(TreeNode node) {
     *         if (node == null) return 0;
     *         int left = arrowLength(node.left);
     *         int right = arrowLength(node.right);
     *         int arrowLeft = 0, arrowRight = 0;
     *         if (node.left != null && node.left.val == node.val) {
     *             arrowLeft += left + 1;
     *         }
     *         if (node.right != null && node.right.val == node.val) {
     *             arrowRight += right + 1;
     *         }
     *         ans = Math.max(ans, arrowLeft + arrowRight);
     *         return Math.max(arrowLeft, arrowRight);
     *     }
     **/
    public static void main(String[] args) {
        TreeNode t1=new TreeNode(5);
        TreeNode t2=new TreeNode(5);
        TreeNode t3=new TreeNode(5);
        TreeNode t4=new TreeNode(5);
        TreeNode t5=new TreeNode(5);
        TreeNode t6=new TreeNode(5);
        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t2.right=t5;
        t3.right=t6;
        System.out.println(new longestUnivaluePath().longestUnivaluePath(t1));
    }
}
