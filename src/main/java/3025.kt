private class Solution3025 {

    fun numberOfPairs(points: Array<IntArray>): Int {
        points.sortWith(compareBy ({ it[0] }, {-it[1]}))
        var res = 0
        val n = points.size
        for (i in points.indices) {
            val top = points[i][1]
            var bot = Int.MIN_VALUE
            for (j in i + 1 until n) {
                val y = points[j][1]
                if (y in bot + 1 .. top) {
                    res++
                    bot = y
                    if (bot == top) break
                }
            }
        }
        return res
    }
}



//private class Solution3025 {
//
//    fun numberOfPairs(points: Array<IntArray>): Int {
//
//        var ans = 0
//
//        for (i in points.indices) {
//            val pointA = points[i]
//            val (xA, yA) = pointA
//            for (j in points.indices) {
//                if (i == j) continue
//                val pointB = points[j]
//                val (xB, yB) = pointB
//
//                if (
//                    xB < xA && yB > yA ||
//                    xB < xA && yB == yA ||
//                    xB == xA && yB > yA
//                ) {
//                    var isOk = true
//                    for (k in points.indices) {
//                        if (k == i || k == j) continue
//                        val pointC = points[k]
//                        val (xC, yC) = pointC
//                        if (
//                            xA == xB && xB == xC && yC in yA..yB ||
//                            yA == yB && yB == yC && xC in xB..xA
//                        ) {
//                            isOk = false
//                            break
//                        } else if (
//                            xC in xB..xA &&
//                            yC in yA..yB
//                        ) {
//                            isOk = false
//                            break
//                        }
//                    }
//                    if (isOk) {
//                        ans++
//                    }
//                }
//
//            }
//        }
//        return ans
//    }
//}
