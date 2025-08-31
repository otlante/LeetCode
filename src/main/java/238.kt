private class Solution238 {
    fun productExceptSelf(nums: IntArray): IntArray {
        val ans = IntArray(nums.size) { 1 }
        var key = 1
        for (i in 0 until nums.size) {
            ans[i] *= key
            key *= nums[i]
        }
        key = 1
        for (i in nums.size - 1 downTo 0) {
            ans[i] *= key
            key *= nums[i]
        }
        return ans
    }
}