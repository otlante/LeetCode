private class Solution88 {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var i1 = m - 1
        var i2 = n - 1
        for (i in m + n - 1 downTo 0) {
            if (i1 >= 0 && i2 >= 0) {
                if (nums1[i1] > nums2[i2]) {
                    nums1[i] = nums1[i1--]
                } else {
                    nums1[i] = nums2[i2--]
                }
            } else if (i1 >= 0) {
                nums1[i] = nums1[i1--]
            } else {
                nums1[i] = nums2[i2--]
            }
        }
    }
}
