private class Solution557 {
    fun reverseWords(s: String): String {
        return s.split(" ").map { it.reversed() }.joinToString(" ")
    }
}