/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

Hint:

Try to utilize the property of a BST.
What if you could modify the BST node's structure?
The optimal runtime complexity is O(height of BST).
*/
public class _230_KthSmallestElementInBST {
    
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        int rank = 0;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode pop = stack.pop();
                if (++rank == k)
                    return pop.val;
                p = pop.right;
            }        
        }
        return 0;
    }
}