package subtask5

class HighestPalindrome {

    // TODO: Complete the following function
    fun highestValuePalindrome(n: Int, k: Int, digitString: String): String {
        var count = 0
        val digits = digitString.toCharArray()
        for (i in digits.indices){
            if (digits[i] != digits[digits.size - i - 1]){
                digits[i] = getHighestNumber(digitString)
                digits[digits.size - i - 1] = getHighestNumber(digitString)
                count++
            }
            if (count > k){
                return "-1"
            }
        }
        return String(digits)
    }

    fun getHighestNumber(digitString: String): Char{
        var max = 0
        for (i in digitString.indices){
            if (digitString[i].toInt() > max){
                max = digitString[i].toInt()
            }
        }
        return max.toChar()
    }
}
