package subtask1

class HappyArray {
    fun convertToHappy(sadArray: IntArray): IntArray {
        if (sadArray.isEmpty()) {
            return intArrayOf()
        }
        val tempSadArray = sadArray.toMutableList()
        var isBadExist = true
        while (isBadExist) {
            if (tempSadArray.size == 2) {
                isBadExist = false;
            }
            for (i in 1 until tempSadArray.lastIndex) {
                if (tempSadArray[i - 1] + tempSadArray[i + 1] < tempSadArray[i]) {
                    tempSadArray.removeAt(i)
                    break
                }
                if (i == tempSadArray.lastIndex - 1) {
                    isBadExist = false
                }
            }
        }
        return tempSadArray.toIntArray()
    }
}
