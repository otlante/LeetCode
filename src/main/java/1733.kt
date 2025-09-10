import kotlin.math.min

private class Solution1733 {
    fun minimumTeachings(n: Int, languages: Array<IntArray>, friendships: Array<IntArray>): Int {
        val problems = mutableListOf<Pair<Int, Int>>()
        val languages = languages.map { it.toSet() }
        for ((first, second) in friendships) {
            if (languages[first - 1].intersect(languages[second - 1]).isEmpty()) {
                problems.add((first - 1) to (second - 1))
            }
        }

        var ans = Int.MAX_VALUE
        for (lang in 1..n) {
            val teachedPersons = mutableSetOf<Int>()
            var current = 0
            for ((first, second) in problems) {
                if (lang !in languages[first] && first !in teachedPersons) {
                    teachedPersons.add(first)
                    current++
                }
                if (lang !in languages[second] && second !in teachedPersons) {
                    teachedPersons.add(second)
                    current++
                }
            }
            ans = min(ans, current)
        }
        return ans
    }
}
