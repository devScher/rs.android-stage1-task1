package subtask4

class StringParser {
    private val keyMap: MutableMap<Char, MutableList<Int>> = mutableMapOf()

    init {
        keyMap['<'] = mutableListOf()
        keyMap['>'] = mutableListOf()
        keyMap['['] = mutableListOf()
        keyMap[']'] = mutableListOf()
        keyMap['('] = mutableListOf()
        keyMap[')'] = mutableListOf()
    }

    fun getResult(inputString: String): Array<String> {
        val result: MutableList<String> = mutableListOf()
        val iter = inputString.iterator().withIndex()
        iter.forEach {
            addToKeyMapIfContains('[', it)
            addToKeyMapIfContains(']', it)
            addToKeyMapIfContains('<', it)
            addToKeyMapIfContains('>', it)
            addToKeyMapIfContains('(', it)
            addToKeyMapIfContains(')', it)
        }
        val seq = sortedSetOf(keyMap['<']?.first(), keyMap['[']?.first(), keyMap['(']?.first())
        for (it in seq){
            if (it == keyMap['<']?.first()){
                result.addAll(parseByTwoChar(inputString, '<', '>'))
            }
            if (it == keyMap['[']?.first()){
                result.addAll(parseByTwoChar(inputString, '[', ']'))
            }
            if (it == keyMap['(']?.first()){
                result.addAll(parseByTwoChar(inputString, '(', ')'))
            }
        }
        return result.toTypedArray()
    }

    private fun addToKeyMapIfContains(char: Char, iter: IndexedValue<Char>) {
        if (iter.value == char) {
            keyMap[char]?.add(iter.index)
        }
    }

    private fun parseByTwoChar(inputString: String, startChar: Char, endChar: Char) :MutableList<String>{
        val result: MutableList<String> = mutableListOf()
        if (keyMap[startChar]?.size == keyMap[endChar]?.size){
            val size = keyMap[startChar]?.size ?: 0
            if (size == 1){
                val firstPosition = keyMap[startChar]?.get(0) ?: 0
                val secondPosition = keyMap[endChar]?.get(0) ?: 0
                result.add(inputString.substring(firstPosition + 1, secondPosition))
            }
            var innerBracketsCount = 0
            var x = 0
            for (i in 0 until size){
                var firstPosition = keyMap[startChar]?.get(i) ?: continue
                var secondPosition = keyMap[endChar]?.get(x) ?: continue
                if (firstPosition < secondPosition){
                    innerBracketsCount++
                    continue
                } else {
                    for (k in i - innerBracketsCount until i){
                        firstPosition = keyMap[startChar]?.get(k) ?: continue
                        secondPosition = keyMap[endChar]?.get(i-k-1) ?: continue
                        result.add(inputString.substring(firstPosition + 1, secondPosition))
                    }
                    innerBracketsCount = 0
                    x = i
                    if (i == size-1){
                        firstPosition = keyMap[startChar]?.get(i) ?: continue
                        secondPosition = keyMap[endChar]?.get(x) ?: continue
                        result.add(inputString.substring(firstPosition + 1, secondPosition))
                    }
                }
            }
        }
        return result
    }
}
