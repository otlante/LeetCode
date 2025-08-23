private class Solution1572 {
    fun diagonalSum(mat: Array<IntArray>): Int {
        var res = 0
        mat.lastIndex
        for (i in mat.indices) {
            res += mat[i][i]
            if (i != mat.lastIndex - i) {
                res += mat[mat.lastIndex - i][i]
            }
        }
        return res
    }
}