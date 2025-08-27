private class Solution59 {
    fun generateMatrix(n: Int): Array<IntArray> {
        val result = Array(n) { IntArray(n) { 0 } }
        var value = 1
        for (layer in 0 until ((n + 1) / 2)) {
            for (i in layer until (n - layer)) {
                result[layer][i] = value++
            }
            for (i in (layer + 1) until (n - layer)) {
                result[i][n - layer - 1] = value++
            }
            for (i in (n - layer - 2) downTo layer) {
                result[n - layer - 1][i] = value++
            }
            for (i in (n - layer - 2) downTo (layer + 1)) {
                result[i][layer] = value++
            }
        }
        return result
    }
}

//private class Solution59 {
//    enum class Direction {
//        RIGHT, BOTTOM, LEFT, UP
//    }
//
//    fun generateMatrix(n: Int): Array<IntArray> {
//        val result = Array(n) { IntArray(n) { 0 } }
//
//        var nextRow = 0
//        var nextCol = 0
//        var direction = Direction.RIGHT
//
//        for (i in 1..n*n) {
//            result[nextRow][nextCol] = i
//            when (direction) {
//                Direction.RIGHT -> {
//                    if (nextCol == n - 1 || result[nextRow][nextCol + 1] != 0) {
//                        direction = Direction.BOTTOM
//                        nextRow++
//                    } else {
//                        nextCol++
//                    }
//                }
//                Direction.BOTTOM -> {
//                    if (nextRow == n - 1 || result[nextRow + 1][nextCol] != 0) {
//                        direction = Direction.LEFT
//                        nextCol--
//                    } else {
//                        nextRow++
//                    }
//                }
//                Direction.LEFT -> {
//                    if (nextCol == 0 || result[nextRow][nextCol - 1] != 0) {
//                        direction = Direction.UP
//                        nextRow--
//                    } else {
//                        nextCol--
//                    }
//                }
//                Direction.UP -> {
//                    if (nextRow == 0 || result[nextRow - 1][nextCol] != 0) {
//                        direction = Direction.RIGHT
//                        nextCol++
//                    } else {
//                        nextRow--
//                    }
//                }
//            }
//        }
//
//        return result
//    }
//}