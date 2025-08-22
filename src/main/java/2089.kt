private class Solution {
    fun targetIndices(nums: IntArray, target: Int): List<Int> {
        var resIndex = 0
        var count = 0
        nums.forEach {
            when {
                it < target -> resIndex++
                it == target -> count++
            }
        }
        val result = mutableListOf<Int>()
        repeat(count) {
            result.add(resIndex++)
        }
        return result
    }
}
