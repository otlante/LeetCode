private class Solution205 {
    fun isIsomorphic(s: String, t: String): Boolean {
        val mapS = IntArray(256) { -1 }
        val mapT = IntArray(256) { -1 }

        for (i in s.indices) {
            val sc = s[i].code
            val tc = t[i].code

            if (mapS[sc] == -1) mapS[sc] = tc
            if (mapT[tc] == -1) mapT[tc] = sc

            if (mapS[sc] != tc || mapT[tc] != sc) return false
        }
        return true
    }
}

//class Solution {
//    fun isIsomorphic(s: String, t: String): Boolean {
//        val replacing1 = mutableMapOf<Char, Char>()
//        val replacing2 = mutableMapOf<Char, Char>()
//        for (i in s.indices) {
//            if (replacing1[s[i]] == null) {
//                replacing1[s[i]] = t[i]
//            }
//            if (replacing2[t[i]] == null) {
//                replacing2[t[i]] = s[i]
//            }
//            if (replacing1[s[i]] != t[i] || replacing2[t[i]] != s[i]) {
//                return false
//            }
//        }
//        return true
//    }
//}