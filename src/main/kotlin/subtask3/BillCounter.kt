package subtask3

class BillCounter {

    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        var halfPriceWithoutAllergic = 0
        for (i in bill.withIndex()){
            if(k != i.index){
                halfPriceWithoutAllergic += i.value;
            }
        }
        halfPriceWithoutAllergic /= 2
        return if (halfPriceWithoutAllergic == b){
            "Bon Appetit"
        } else {
            (b - halfPriceWithoutAllergic).toString()
        }
    }
}
