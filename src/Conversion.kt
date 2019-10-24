/**
 * Code by Kujaku
 * En Kotlin ❤
 * Created at 23/10/2019
 */
class Conversion {
    fun decimalToHeure(decimal: Float): String{

        val h = decimal.toString().split('.')
        val m = h[1].toInt() * 60
        val j = m.toString()[0]
        val t = m.toString()[1]
        if(m < 1000){
            return "${h[0]}:0${j}"
        }else{
            return "${h[0]}:${j}${t}"
        }
    }
}