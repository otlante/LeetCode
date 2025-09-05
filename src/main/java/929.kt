private class Solution929 {
    fun numUniqueEmails(emails: Array<String>): Int {
        val res = mutableSetOf<String>()

        for (email in emails) {
            val realEmail = StringBuilder()
            var isDomainPart = false
            var isAfterPlus = false
            for (ch in email) {
                if (isDomainPart) {
                    realEmail.append(ch)
                    continue
                }
                if (ch == '.' || isAfterPlus) {
                    continue
                }
                if (ch == '+') {
                    isAfterPlus = true
                    continue
                }
                if (ch == '@') {
                    realEmail.append(ch)
                    isDomainPart = true
                    continue
                }
            }
            res.add(realEmail.toString())
        }
        return res.size
    }
}