private class Solution1304 {
    fun sumZero(n: Int): IntArray {
        val res = IntArray(n) { 0 }
        var insertIndex = 0
        for (i in 0 until n / 2) {
            res[insertIndex++] = - i - 1
            res[insertIndex++] = i + 1
        }

        return res
    }
}
