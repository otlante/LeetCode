import kotlin.math.max
import kotlin.math.min

private class Solution3197 {
    fun minimumSum(grid: Array<IntArray>): Int {
        val res1 = case1(grid)
        val res2 = case1(rotateMatrix(grid, 1))
        val res3 = case1(rotateMatrix(grid, 2))
        val res4 = case1(rotateMatrix(grid, 3))
        val res5 = case2(grid)
        val res6 = case2(rotateMatrix(grid, 1))
        return listOf(res1, res2, res3, res4, res5, res6).min()
    }

    fun rotateMatrix(grid: Array<IntArray>, count: Int): Array<IntArray> {
        var result = grid
        repeat(count) {
            result = rotateMatrix(result)
        }
        return result
    }

    fun rotateMatrix(grid: Array<IntArray>): Array<IntArray> {
        val result = Array(grid[0].size) { IntArray(grid.size) }
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                result[j][grid.size - i - 1] = grid[i][j]
            }
        }
        return result
    }

    // ________
    //    |
    fun case1(grid: Array<IntArray>): Int {
        if (grid.size == 1 || grid[0].size == 1) return Int.MAX_VALUE
        var res = Int.MAX_VALUE
        for (i in 0 until grid.lastIndex) {
            for (j in 0 until grid[0].lastIndex) {
                val subMatrix1 = subMatrix(0, i, 0, grid[0].lastIndex, grid)
                val subMatrix2 = subMatrix(i + 1, grid.lastIndex, 0, j, grid)
                val subMatrix3 = subMatrix(i + 1, grid.lastIndex, j + 1, grid[0].lastIndex, grid)

                res = min(
                    res,
                    minimumArea(subMatrix1) +
                            minimumArea(subMatrix2) +
                            minimumArea(subMatrix3)
                )
            }
        }
        return res
    }

    //    |    |
    // 1  | 2  |  3
    //    |    |
    fun case2(grid: Array<IntArray>): Int {
        if (grid[0].size < 3) return Int.MAX_VALUE
        var res = Int.MAX_VALUE
        for (i in 0 .. (grid[0].lastIndex - 2)) { // for first line
            for (j in (i + 1) until grid[0].lastIndex) { // for second line
                val subMatrix1 = subMatrix(0, grid.lastIndex, 0, i, grid)
                val subMatrix2 = subMatrix(0, grid.lastIndex, i + 1, j, grid)
                val subMatrix3 = subMatrix(0, grid.lastIndex, j + 1, grid[0].lastIndex, grid)

                res = min(
                    res,
                    minimumArea(subMatrix1) +
                            minimumArea(subMatrix2) +
                            minimumArea(subMatrix3)
                )
            }
        }
        return res
    }

    private fun subMatrix(top: Int, bottom: Int, start: Int, end: Int, matrix: Array<IntArray>): Array<IntArray> {
        return matrix.slice(top..bottom).map { it.sliceArray(start..end) }.toTypedArray()
    }

    private fun minimumArea(grid: Array<IntArray>): Int {
        var top = grid.size
        var start = grid[0].size
        var end = 0
        var bottom = 0

        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == 1) {
                    top = min(top, i)
                    start = min(start, j)
                    bottom = i
                    end = max(end, j)
                }
            }
        }
        return (end - start + 1) * (bottom - top + 1)
    }
}