private class Solution771 {
    fun numJewelsInStones(jewels: String, stones: String): Int {
        val j = BooleanArray(256) { false }
        var ans = 0
        for (ch in jewels) j[ch.code] = true
        for (ch in stones) ans += if (j[ch.code]) 1 else 0
        return ans
    }
}