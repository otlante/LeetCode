private class Solution498 {
    fun findDiagonalOrder(mat: Array<IntArray>): IntArray {
        val m = mat.size
        val n = mat[0].size
        var x = 0
        var y = 0
        val result = IntArray(m * n)

        for (i in 0 until m * n) {
            result[i] = mat[x][y]

            if ((x + y) % 2 == 0) { // up
                if (y == (n - 1)) {
                    x++
                } else {
                    x = (x - 1).coerceIn(0, m - 1)
                    y = (y + 1).coerceIn(0, n - 1)
                }
            } else { // down
                if (x == (m - 1)) {
                    y++
                } else {
                    x = (x + 1).coerceIn(0, m - 1)
                    y = (y - 1).coerceIn(0, n - 1)
                }
            }
        }

        return result
    }
}
