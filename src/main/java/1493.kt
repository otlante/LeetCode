import kotlin.math.max

private class Solution1493 {
    fun longestSubarray(nums: IntArray): Int {
        var l = 0
        var zerosCount = 0
        var res = 0
        for (r in nums.indices) {
            if (nums[r] == 0) {
                zerosCount++
            }
            while (zerosCount == 2) {
                if (nums[l] == 0) {
                    zerosCount--
                }
                l++
            }
            res = max(r - l, res)
        }
        return res
    }
}