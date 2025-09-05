private class Solution2749 {
    fun makeTheIntegerZero(num1: Int, num2: Int): Int {
        var k = 0
        while (true) {
            val x = num1.toLong() - k * num2.toLong()
            if (k in x.countOneBits()..x) {
                return k
            }
            if (k > x) {
                return -1
            }
            k++
        }
    }
}