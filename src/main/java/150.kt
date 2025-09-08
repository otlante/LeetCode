private class Solution150 {
    fun evalRPN(tokens: Array<String>): Int {
        val st = ArrayDeque<Int>()

        fun calculate(token: String) {
            val operand2 = st.removeLast()
            val operand1 = st.removeLast()
            st.addLast(
                when (token) {
                    "+" -> operand1 + operand2
                    "-" -> operand1 - operand2
                    "*" -> operand1 * operand2
                    "/" -> operand1 / operand2
                    else -> 0
                }
            )
        }

        for (token in tokens) {
            when (token) {
                "+", "-", "*", "/" -> calculate(token)
                else -> st.addLast(token.toInt())
            }
        }
        return st.removeLast()
    }
}