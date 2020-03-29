package subtask2

class MiniMaxSum {

    fun getResult(input: IntArray): IntArray {
        val sumList = mutableListOf<Int>()
        for (i in input.indices) {
            var sum = 0;
            for (k in input.indices) {
                if (k == i) {
                    continue
                }
                sum += input[k]
            }
            sumList.add(sum)
        }
        val smallest: Int? = sumList.min()
        val biggest: Int? = sumList.max()
        return if (smallest == null || biggest == null) {
            intArrayOf()
        } else {
            intArrayOf(smallest, biggest)
        }
    }
}
