import kotlin.math.min

class ATM2241() {

    private val banknotes = intArrayOf(0, 0, 0, 0, 0)
    private val banknotesValues = intArrayOf(20, 50, 100, 200, 500)

    fun deposit(banknotesCount: IntArray) {
        banknotesCount.forEachIndexed { i, value ->
            banknotes[i] += value
        }
    }

    fun withdraw(amount: Int): IntArray {
        val result = intArrayOf(0, 0, 0, 0, 0)
        var remainingAmount = amount
        for (i in banknotes.size - 1 downTo 0) {
            val count = min(banknotes[i], remainingAmount / banknotesValues[i])
            result[i] = count
            remainingAmount -= count * banknotesValues[i]
        }
        return if (remainingAmount == 0) {
            result.forEachIndexed { i, v ->
                banknotes[i] -= v
            }
            result
        } else {
            intArrayOf(-1)
        }
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * var obj = ATM()
 * obj.deposit(banknotesCount)
 * var param_2 = obj.withdraw(amount)
 */