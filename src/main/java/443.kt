private class Solution443 {
    fun compress(chars: CharArray): Int {
        var n = chars.size
        var r = 0
        var res = 0
        while (r < n) {
            var prevChar = chars[r]
            var count = 1
            while (r < n - 1 && prevChar == chars[r + 1]) {
                r++
                count++
            }
            r++
            chars[res++] = prevChar
            if (count == 1) continue
            for (letter in count.toString()) {
                chars[res++] = letter
            }
        }
        return res
    }
}

//class Solution443 {
//    fun compress(chars: CharArray): Int {
//        var count = 1
//        var compressed = ""
//        for (i in 0 until chars.lastIndex) {
//            if (chars[i] == chars[i + 1]) {
//                count++
//            } else {
//                if (count == 1) {
//                    compressed += chars[i].toString()
//                } else {
//                    compressed += chars[i].toString() + count.toString()
//                }
//                count = 1
//            }
//        }
//        if (count == 1) {
//            compressed += chars.last().toString()
//        } else {
//            compressed += chars.last().toString() + count.toString()
//        }
//        compressed.forEachIndexed { i, value ->
//            chars[i] = value
//        }
//        return compressed.length
//    }
//}