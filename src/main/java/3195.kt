import kotlin.math.max
import kotlin.math.min

private class Solution {
    fun minimumArea(grid: Array<IntArray>): Int {
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
