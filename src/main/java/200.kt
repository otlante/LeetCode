private class Solution200 {
    fun numIslands(grid: Array<CharArray>): Int {
        var res = 0

        fun dfs(row: Int, col: Int) {
            if (row < 0 ||
                row > grid.lastIndex ||
                col < 0 ||
                col > grid[0].lastIndex ||
                grid[row][col] != '1'
            ) {
                return
            }

            grid[row][col] = '0'

            dfs(row - 1, col)
            dfs(row + 1, col)
            dfs(row, col - 1)
            dfs(row, col + 1)
        }

        for (row in 0 until grid.size) {
            for (col in 0 until grid[0].size) {
                if (grid[row][col] == '1') {
                    dfs(row, col)
                    res++
                }
            }
        }

        return res
    }
}