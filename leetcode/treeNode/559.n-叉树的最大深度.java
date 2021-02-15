import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=559 lang=java
 *
 * [559] N 叉树的最大深度
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
//     public int maxDepth(Node root) {
//         return dfs(root, 0);
//     }

//     private int dfs(Node node, int depth){
//         if(node == null){
//             return depth;
//         }
//         List<Node> children = node.children;
//         int maxDepth = depth + 1;
//         for(Node child : children){
//             maxDepth = Math.max(maxDepth, dfs(child, depth + 1));
//         }
//         return maxDepth;
//     }
// }

class Solution {
    public int maxDepth(Node root) {
        int maxDepth = 0;
        if (root == null) {
            return maxDepth;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            maxDepth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                List<Node> children = node.children;
                for (Node child : children) {
                    if (child != null) {
                        queue.offer(child);
                    }
                }
            }

        }
        return maxDepth;
    }
}
// @lc code=end
