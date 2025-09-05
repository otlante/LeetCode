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

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun averageOfLevels(root: TreeNode?): DoubleArray {
        val res = mutableListOf<Double>()
        if (root == null) return doubleArrayOf()

        val queue = ArrayDeque<TreeNode>()
        queue.add(root)

        while (queue.isNotEmpty()) {
            var s = 0L
            val size = queue.size
            repeat(size) {
                val node = queue.removeFirst()
                s += node.`val`.toLong()
                node.left?.let {
                    queue.add(it)
                }
                node.right?.let {
                    queue.add(it)
                }
            }
            res.add(s / size.toDouble())
        }
        return res.toDoubleArray()
    }
}

//class Solution {
//    fun averageOfLevels(root: TreeNode?): DoubleArray {
//        val res = mutableListOf<Double>()
//
//        var currentLevel = mutableListOf(root!!)
//        while (true) {
//            var s = 0L
//            val newLevel = mutableListOf<TreeNode>()
//            for (child in currentLevel) {
//                s += child.`val`.toLong()
//                child.left?.let {
//                    newLevel.add(it)
//                }
//                child.right?.let {
//                    newLevel.add(it)
//                }
//            }
//            res.add(s / currentLevel.size.toDouble())
//            if (newLevel.isEmpty()) break
//            currentLevel = newLevel
//        }
//        return res.toDoubleArray()
//    }
//}