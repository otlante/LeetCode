class Solution {
    fun solveSudoku(board: Array<CharArray>): Unit {

        data class Point(val row: Int, val col: Int)

        fun getAvailableValues(point: Point): List<Char> {
            val res = ('1'..'9').toMutableList()
            for (i in 0 until 9) {
                res.remove(board[point.row][i])
                res.remove(board[i][point.col])
            }
            val boxRowStart = point.row / 3 * 3
            val boxColStart = point.col / 3 * 3
            for (i in 0 until 3) {
                for (j in 0 until 3) {
                    res.remove(board[boxRowStart + i][boxColStart + j])
                }
            }
            return res
        }

        fun getFreePoints(): List<Point> {
            val res = mutableListOf<Point>()
            for (i in 0 until 9) {
                for (j in 0 until 9) {
                    if (board[i][j] == '.') {
                        res.add(Point(i, j))
                    }
                }
            }
            return res
        }

        val freePoints = getFreePoints().toMutableList()

        fun solve(): Boolean {
            // We use MRV - Minimum Remaining Values heuristic
            val point = freePoints.minByOrNull { getAvailableValues(it).size } ?: return true
            val availableValues = getAvailableValues(point)
            for (value in availableValues) {
                board[point.row][point.col] = value
                freePoints.remove(point)

                if (solve()) return true

                board[point.row][point.col] = '.'
                freePoints.add(point)
            }
            return false
        }

        solve()
    }
}


//class Solution {
//    fun solveSudoku(board: Array<CharArray>): Unit {
//
//        data class Point(val row: Int, val col: Int)
//
//        fun getAvailableValues(point: Point): List<Char> {
//            val res = ('1'..'9').toMutableList()
//            for (i in 0 until 9) {
//                res.remove(board[point.row][i])
//                res.remove(board[i][point.col])
//            }
//            val boxRowStart = point.row / 3 * 3
//            val boxColStart = point.col / 3 * 3
//            for (i in 0 until 3) {
//                for (j in 0 until 3) {
//                    res.remove(board[boxRowStart + i][boxColStart + j])
//                }
//            }
//            return res
//        }
//
//        fun getFreePoints(): List<Point> {
//            val res = mutableListOf<Point>()
//            for (i in 0 until 9) {
//                for (j in 0 until 9) {
//                    if (board[i][j] == '.') {
//                        res.add(Point(i, j))
//                    }
//                }
//            }
//            return res
//        }
//
//        val freePoints = getFreePoints()
//        var isSolved = false
//
//        fun solve(index: Int) {
//            if (index > freePoints.lastIndex) isSolved = true
//            if (isSolved) return
//            val point = freePoints[index]
//            var availableValues = getAvailableValues(point)
//            for (number in availableValues) {
//                if (!isSolved) {
//                    board[point.row][point.col] = number
//                    solve(index + 1)
//                    if (!isSolved) {
//                        board[point.row][point.col] = '.'
//                    }
//                }
//            }
//        }
//
//        solve(0)
//    }
//}