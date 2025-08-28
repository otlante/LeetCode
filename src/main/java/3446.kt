private class Solution3446 {
    fun sortMatrix(grid: Array<IntArray>): Array<IntArray> {
        val n = grid.size
        val result = grid.copyOf()

        for (j in 1 until n) {
            val elements = mutableListOf<Int>()
            for (i in 0..n - j - 1) {
                elements.add(grid[i][i + j])
            }
            elements.sort()
            for (i in 0..n - j - 1) {
                result[i][i + j] = elements[i]
            }
        }

        for (i in 0 until n) {
            val elements = mutableListOf<Int>()
            for (j in 0..n - i - 1) {
                elements.add(grid[i + j][j])
            }
            elements.sortDescending()
            for (j in 0..n - i - 1) {
                result[i + j][j] = elements[j]
            }
        }

        return result
    }
}