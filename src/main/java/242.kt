private class Solution242 {
    fun isAnagram(s: String, t: String): Boolean {

        fun getFreqMap(m: String): Map<Char, Int> {
            val res = mutableMapOf<Char, Int>()
            for (ch in m) {
                res[ch] = (res[ch] ?: 0) + 1
            }
            return res
        }

        return getFreqMap(s) == getFreqMap(t)
    }
}