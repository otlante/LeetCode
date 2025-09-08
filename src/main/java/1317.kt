private class Solution1317 {

    private fun containsZeros(number: Int): Boolean {
        var num = number
        while (num > 0) {
            if (num % 10 == 0) {
                return true
            }
            num /= 10
        }
        return false
    }

    fun getNoZeroIntegers(n: Int): IntArray {
        for (i in 1..n) {
            var a1 = i
            var a2 = n - i
            var isOk = true

            if (!containsZeros(a1) && !containsZeros(a2)) {
                return intArrayOf(a1, a2)
            }
        }

        return intArrayOf(0, 0)
    }
}
