/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

private class TreeNode100(var `val`: Int) {
    var left: TreeNode100? = null
    var right: TreeNode100? = null
}

private class Solution100 {
    fun isSameTree(p: TreeNode100?, q: TreeNode100?): Boolean {
        return when {
            p == null && q == null -> true
            p == null || q == null -> false
            else -> p.`val` == q.`val` && isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
        }
    }
}