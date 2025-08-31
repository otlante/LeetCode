private class Solution125 {
    fun isPalindrome(s: String): Boolean {
        var l = 0
        var r = s.length - 1
        while (l < r) {
            while (l < r && !s[l].isLetterOrDigit()) {
                l++
            }
            while (r > l && !s[r].isLetterOrDigit()) {
                r--
            }
            if (s[l].lowercaseChar() != s[r].lowercaseChar()) return false
            l++
            r--
        }
        return true
    }
}

//private class Solution125 {
//    fun isPalindrome(s: String): Boolean {
//        val clearedS = StringBuilder()
//        for (letter in s) {
//            if (letter.isLetterOrDigit()) {
//                clearedS.append(letter.lowercase())
//            }
//        }
//
//        val n = clearedS.length
//
//        clearedS.toString().forEachIndexed { i, letter ->
//            if (letter != clearedS[n - i - 1]) return false
//        }
//        return true
//    }
//}