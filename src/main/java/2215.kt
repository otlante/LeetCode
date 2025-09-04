private class Solution2215 {
    fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
        val h1 = nums1.toSet()
        val h2 = nums2.toSet()
        val res1 = mutableListOf<Int>()
        val res2 = mutableListOf<Int>()
        for (num in h1) {
            if (num !in h2) {
                res1.add(num)
            }
        }
        for (num in h2) {
            if (num !in h1) {
                res2.add(num)
            }
        }

        return listOf(res1, res2)
    }
}