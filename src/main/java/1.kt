private class Solution1 {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val h = mutableMapOf<Int, Int>()
        for (i in nums.indices) {
            val n = nums[i]
            h[n]?.let {
                return intArrayOf(i, it)
            }
            h[target - n] = i
        }
        return intArrayOf()
    }
}