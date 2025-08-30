class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val isCharSeen = mutableSetOf<String>()
        for (i in 0 until 9) {
            for (j in 0 until 9) {
                val el = board[i][j]
                if (el == '.') continue
                if (
                    !isCharSeen.add("$el row $i") ||
                    !isCharSeen.add("$el col $j") ||
                    !isCharSeen.add("$el cube ${i/3}-${j/3}")
                ) {
                    return false
                }
            }
        }
        return true
    }
}

//class Solution {
//    fun isValidSudoku(board: Array<CharArray>): Boolean {
//
//        fun isValidArray(arr: CharArray): Boolean {
//            return arr.toSet().size == (arr.size - arr.count {it == '.'} + if ('.' in arr) 1 else 0)
//        }
//
//        for (row in board) {
//            if (!isValidArray(row)) {
//                return false
//            }
//        }
//
//        for (col in 0 until 9) {
//            val column = CharArray(9) { '.' }
//            for (i in 0 until 9) {
//                column[i] = board[i][col]
//            }
//            if (!isValidArray(column)) {
//                return false
//            }
//        }
//
//        for (startX in 0 until 9 step 3) {
//            for (startY in 0 until 9 step 3) {
//                val arr = CharArray(9) { '.' }
//                var index = 0
//                for (x in startX until startX + 3) {
//                    for (y in startY until startY + 3) {
//                        arr[index++] = board[x][y]
//                    }
//                }
//                if (!isValidArray(arr)) {
//                    return false
//                }
//            }
//        }
//        return true
//    }
//}