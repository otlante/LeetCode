private class Solution13 {

    private fun translate(c: Char): Int {
        return when (c) {
            'I' -> 1
            'V' -> 5
            'X' -> 10
            'L' -> 50
            'C' -> 100
            'D' -> 500
            'M' -> 1000
            else -> 0
        }
    }

    fun romanToInt(s: String): Int {
        var result = 0
        var prev = 0
        for (c in s) {
            val current = translate(c)
            if (current > prev) {
                result = result - prev * 2
            }
            result += current
            prev = current
        }
        return result
    }
}

//class Solution {
//    fun romanToInt(s: String): Int {
//        val dict = mapOf(
//            'I' to 1,
//            'V' to 5,
//            'X' to 10,
//            'L' to 50,
//            'C' to 100,
//            'D' to 500,
//            'M' to 1000,
//        )
//        var result = 0
//        for (i in 0 until s.lastIndex) {
//            if (dict[s[i]]!! < dict[s[i + 1]]!!) {
//                result -= dict[s[i]]!!
//            } else {
//                result += dict[s[i]]!!
//            }
//        }
//        result += dict[s[s.lastIndex]]!!
//        return result
//    }
//}