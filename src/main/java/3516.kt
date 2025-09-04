import kotlin.math.abs

private class Solution3516 {
    fun findClosest(x: Int, y: Int, z: Int): Int {
        val r1 = abs(z - x)
        val r2 = abs(z - y)
        return when {
            r1 < r2 -> 1
            r2 < r1 -> 2
            else -> 0
        }
    }
}