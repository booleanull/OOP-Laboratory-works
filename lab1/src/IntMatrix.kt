import kotlin.math.pow

class IntMatrix(private val array: Array<Array<Int>>) : Matrix<Int> {

    private var rows: Int = 0
    private var columns: Int = 0

    init {
        if (array.isEmpty() || array[0].isEmpty()) throw IllegalArgumentException("Array can not be empty")
        rows = array.size
        columns = array[0].size
        array.find { it.size != columns }?.let { throw IllegalArgumentException("Array can not be like this") }
    }

    override fun getRows() = rows

    override fun getColumns() = columns

    override fun getValue(x: Int, y: Int): Int {
        return array.getOrNull(x)?.getOrNull(y) ?: throw ArrayIndexOutOfBoundsException("Incorrect indexes")
    }

    operator fun get(x: Int, y: Int) = getValue(x, y)

    override fun setValue(x: Int, y: Int, value: Int) {
        array.getOrNull(x)?.getOrNull(y) ?: throw ArrayIndexOutOfBoundsException("Incorrect indexes")
        array[x][y] = value
    }

    operator fun set(x: Int, y: Int, value: Int) = setValue(x, y, value)

    override fun fold(matrix: Matrix<Int>): Matrix<Int> {
        if (rows != matrix.getRows() || columns != matrix.getColumns()) throw IllegalArgumentException("Matrix can not plus this matrix")
        return IntMatrix(Array(rows) { x -> Array(columns) { y -> this[x, y] + matrix.getValue(x, y) } })
    }

    operator fun plus(matrix: Matrix<Int>) = fold(matrix)

    override fun deduct(matrix: Matrix<Int>): Matrix<Int> {
        if (rows != matrix.getRows() || columns != matrix.getColumns()) throw IllegalArgumentException("Matrix can not plus this matrix")
        return IntMatrix(Array(rows) { x -> Array(columns) { y -> this[x, y] - matrix.getValue(x, y) } })
    }

    operator fun minus(matrix: IntMatrix) = deduct(matrix)

    override fun multiply(value: Int): Matrix<Int> {
        return IntMatrix(Array(rows) { x -> Array(columns) { y -> this[x, y] * value } })
    }

    operator fun times(value: Int): Matrix<Int> {
        return multiply(value)
    }

    override fun multiply(matrix: Matrix<Int>): Matrix<Int> {
        if (columns != matrix.getRows()) throw IllegalArgumentException("Matrix can not multiply this matrix")
        val resultArray = Array(rows) { Array(matrix.getColumns()) { 0 } }
        for (i in 0 until rows) {
            for (j in 0 until matrix.getColumns()) {
                for (k in 0 until columns) {
                    resultArray[i][j] += this[i, k] * matrix.getValue(k, j)
                }
            }
        }
        return IntMatrix(resultArray)
    }

    operator fun times(matrix: Matrix<Int>): Matrix<Int> {
        return multiply(matrix)
    }

    override fun determinant(): Int {
        if (rows != columns) throw IllegalStateException("Can not get determinant")
        return determinant(array)
    }

    private fun determinant(array: Array<Array<Int>>): Int {
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
                    result += (array[0][i] * (-1.0).pow(i) * determinant(temp)).toInt()
                }
                result
            }
        }
    }

    override fun toString(): String = array.joinToString(
        prefix = "[",
        postfix = "]",
        transform = { array -> array.joinToString(prefix = "[", postfix = "]") }
    )

    override fun hashCode(): Int {
        var result = array.contentDeepHashCode()
        result = 31 * result + rows
        result = 31 * result + columns
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as IntMatrix

        if (!array.contentDeepEquals(other.array)) return false
        if (rows != other.rows) return false
        if (columns != other.columns) return false

        return true
    }
}