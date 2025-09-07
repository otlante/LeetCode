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

private class TreeNode98(var `val`: Int) {
    var left: TreeNode98? = null
    var right: TreeNode98? = null
}
private class Solution98 {
    fun isValidBST(root: TreeNode98?): Boolean {

        fun isValid(root: TreeNode98?, largest: Long, smallest: Long): Boolean {
            if (root == null) return true
            return root.`val` in (smallest + 1) until largest &&
                    isValid(root.left, root.`val`.toLong(), smallest) &&
                    isValid(root.right, largest, root.`val`.toLong())
        }

        return isValid(root, Long.MAX_VALUE, Long.MIN_VALUE)
    }
}