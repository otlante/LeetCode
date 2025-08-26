import kotlin.math.max
import kotlin.math.sqrt

private class Solution3000 {
    fun areaOfMaxDiagonal(dimensions: Array<IntArray>): Int {
        var maxDiagonal = 0f
        var maxArea = 0f

        for (i in dimensions.indices) {
            val h = dimensions[i][0].toFloat()
            val w = dimensions[i][1].toFloat()
            val diagonal = sqrt(h*h + w*w)
            if (diagonal > maxDiagonal) {
                maxDiagonal = diagonal
                maxArea = h * w
            } else if (diagonal == maxDiagonal) {
                maxArea = max(maxArea, h * w)
            }
        }

        return maxArea.toInt()
    }
}