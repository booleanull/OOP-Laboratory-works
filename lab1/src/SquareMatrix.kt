import java.lang.IllegalArgumentException
import kotlin.math.pow

class SquareMatrix(private val array: Array<Array<Int>>) : Matrix(array) {

    init {
        if (rows != columns) throw IllegalArgumentException("Can not create square matrix")
    }

    fun getDeterminant(): Int {
        if (rows != columns) throw IllegalStateException("Can not call method in not square matrix")
        return getDeterminant(array)
    }

    private fun getDeterminant(array: Array<Array<Int>>): Int {
        return when (array.size) {
            1 -> array[0][0]
            2 -> array[0][0] * array[1][1] - array[0][1] * array[1][0]
            else -> {
                var result = 0
                for (i in array[0].indices) {
                    val temp = Array(array.size - 1) { Array(array[0].size - 1) { 0 } }
                    for (j in 1 until array.size) {
                        for (k in array[0].indices) {
                            if (k < i) {
                                temp[j - 1][k] = array[j][k]
                            } else if (k > i) {
                                temp[j - 1][k - 1] = array[j][k]
                            }
                        }
                    }
                    result += (array[0][i] * (-1.0).pow(i) * getDeterminant(temp)).toInt()
                }
                result
            }
        }
    }
}