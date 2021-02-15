import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=589 lang=java
 *
 * [589] N叉树的前序遍历
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

// class Solution {
//     public List<Integer> preorder(Node root) {
//         List<Integer> result = new ArrayList<>();
//         preorder(root, result);
//         return result;
//     }

//     private void preorder(Node root, List<Integer> result){
//         if(root == null){
//             return;
//         }
//         result.add(root.val);
//         List<Node> children = root.children;
//         for(Node child : children){
//             preorder(child, result);
//         }
//     }
// }


// class Solution {
//     public List<Integer> preorder(Node root) {
//         List<Integer> result = new ArrayList<>();
//         if(root == null){
//             return result;
//         }
//         Queue<Node> queue = new LinkedList<>();
//         queue.offer(root);
//         while(!queue.isEmpty()){
//             Node node = queue.poll();
//             result.add(node.val);
//             List<Node> children = node.children;
//             for(Node child : children){
//                 if(child != null){
//                     queue.offer(child);
//                 }
//             }
//         }
//         return result;
//     }
// }


class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Stack<Node> queue = new Stack();
        queue.push(root);
        while(!queue.isEmpty()){
            Node node = queue.pop();
            result.add(node.val);
            List<Node> children = node.children;
            for(int i = children.size() - 1; i >= 0; i--){
                queue.push(children.get(i));
            }
        }
        return result;
    }
}
// @lc code=end

