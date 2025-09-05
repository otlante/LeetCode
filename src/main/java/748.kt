private class Solution748 {
    fun shortestCompletingWord(licensePlate: String, words: Array<String>): String {
        var ans = ""
        val freq = mutableMapOf<Char, Int>()
        for (ch in licensePlate) {
            if (ch.isLetter()) {
                val letter = ch.lowercaseChar()
                freq[letter] = (freq[letter] ?: 0) + 1
            }
        }

        for (word in words) {
            var isOk = true
            for ((key, value) in freq) {
                if (word.count({ it == key }) < value) {
                    isOk = false
                }
            }
            if (isOk) {
                if (word.length < ans.length || ans.isEmpty()) {
                    ans = word
                }
            }
        }
        return ans
    }
}