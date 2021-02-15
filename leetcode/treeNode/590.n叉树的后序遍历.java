import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


/*
 * @lc app=leetcode.cn id=590 lang=java
 *
 * [590] N叉树的后序遍历
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
//     public List<Integer> postorder(Node root) {
//         List<Integer> result = new ArrayList<>();
//         postorder(root, result);
//         return result;
//     }

//     private void postorder(Node root, List<Integer> result){
//         if(root == null){
//             return;
//         }
//         List<Node> children = root.children;
//         for(Node child : children){
//             postorder(child, result);
//         }
//         result.add(root.val);
//     }
// }


// class Solution {
//     public List<Integer> postorder(Node root) {
//         List<Integer> result = new ArrayList<>();
//         if(root == null){
//             return result;
//         }
//         Stack<Node> stack = new Stack();
//         stack.push(root);
//         while(!stack.isEmpty()){
//             Node node = stack.pop();
//             List<Node> children = node.children;
//             result.add(node.val);
//             for(int i = 0; i < children.size(); i++){
//                 stack.push(children.get(i));
//             }
//         }
//         Collections.reverse(result);
//         return result;
//     }
// }


class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Stack<Node> stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            if(node != null){
                stack.push(node);
                stack.push(null);
                List<Node> children = node.children;
                for(int i = children.size() - 1; i >= 0; i--){
                    if(children.get(i) != null){
                        stack.push(children.get(i));
                    }
                }
            }else{
                node = stack.pop();
                result.add(node.val);
            }
        }
        return result;
    }
}
// @lc code=end

