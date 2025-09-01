import java.util.PriorityQueue

private class Solution1792 {
    fun maxAverageRatio(classes: Array<IntArray>, extraStudents: Int): Double {
        val pq = PriorityQueue<IntArray>(classes.size) { a, b ->
            (
                    (b[0] + 1).toDouble() / (b[1] + 1).toDouble() - (b[0].toDouble() / b[1].toDouble())
                    ).compareTo(
                    (a[0] + 1).toDouble() / (a[1] + 1).toDouble() - (a[0].toDouble() / a[1].toDouble())
                )
        }

        for (el in classes) {
            pq.add(el)
        }

        for (i in 0 until extraStudents) {
            val el = pq.poll()
            el[0]++
            el[1]++
            pq.add(el)
        }

        var ratiosSum = 0.0
        for (el in pq) {
            ratiosSum += el[0].toDouble() / el[1].toDouble()
        }
        return ratiosSum / classes.size
    }
}