import kotlin.math.min

class Solution350 {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val seen = ShortArray(1001)
        val result = IntArray(1001)
        var i = 0
        for (el in nums1) seen[el]++
        for (el in nums2) {
            if (seen[el] > 0){
                result[i++] = el
                seen[el]--
            }
        }
        return result.copyOf(i)
    }
}

//class Solution350 {
//    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
//        val frequency1 = mutableMapOf<Int, Int>()
//        val frequency2 = mutableMapOf<Int, Int>()
//        val res = mutableListOf<Int>()
//        for (num in nums1) {
//            frequency1[num] = (frequency1[num] ?: 0) + 1
//        }
//        for (num in nums2) {
//            frequency2[num] = (frequency2[num] ?: 0) + 1
//        }
//        for ((key, value1) in frequency1) {
//            frequency2[key]?.let { value2 ->
//                repeat(min(value1, value2)) {
//                    res.add(key)
//                }
//            }
//        }
//        return res.toIntArray()
//    }
//}