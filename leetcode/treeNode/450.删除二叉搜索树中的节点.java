import javax.swing.text.html.HTMLDocument.HTMLReader.ParagraphAction;

/*
 * @lc app=leetcode.cn id=450 lang=java
 *
 * [450] 删除二叉搜索树中的节点
 */

// @lc code=start
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
// class Solution {
//     public TreeNode deleteNode(TreeNode root, int key) {
//         TreeNode parent = null;
//         TreeNode cur = root;
//         while(cur!= null){
//             if(cur.val == key){
//                 break;
//             }
//             parent = cur;
//             if(cur.val > key){
//                 cur = cur.left;
//             }else if(cur.val < key){
//                 cur = cur.right;
//             }
//         }
//         if(parent == null){
//             return deleteOneNode(cur);
//         }
//         if(parent.left != null && parent.left.val == key){
//             parent.left = deleteOneNode(parent.left);
//         }else if(parent.right != null && parent.right.val == key){
//             parent.right = deleteOneNode(parent.right);
//         }
//         return root;
        
//     }

//     private TreeNode deleteOneNode(TreeNode target){
//         if(target == null){
//             return target;
//         }else if(target.right == null){
//             return target.left;
//         }
//         TreeNode cur = target.right;
//         while(cur.left != null){
//             cur = cur.left;
//         }
//         cur.left = target.left;
//         return target.right;
//     }
// }



class Solution{
    public TreeNode deleteNode(TreeNode root, int key){
        if(root == null){
            return root;
        }
        if(root.val == key){
            if(root.right == null){
                return root.left;
            }
            TreeNode cur = root.right;
            while(cur.left != null){
                cur = cur.left;
            }
            cur.left = root.left;
            return root.right;
        }else if(root.val > key){
            root.left = deleteNode(root.left, key);
        }else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
}
// @lc code=end

