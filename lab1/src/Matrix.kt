open class Matrix(private val array: Array<Array<Int>>) {

    var rows: Int = 0
        private set
    var columns: Int = 0
        private set

    init {
        if (array.isEmpty() || array[0].isEmpty()) throw IllegalArgumentException("Array can not be empty")
        rows = array.size
        columns = array[0].size
        array.find { it.size != columns }?.let { throw IllegalArgumentException("Array can not be like this") }
    }

    operator fun get(x: Int, y: Int): Int {
        return array.getOrNull(x)?.getOrNull(y) ?: throw ArrayIndexOutOfBoundsException("Incorrect indexes")
    }

    operator fun set(x: Int, y: Int, value: Int) {
        array.getOrNull(x)?.getOrNull(y) ?: throw ArrayIndexOutOfBoundsException("Incorrect indexes")
        array[x][y] = value
    }

    operator fun plus(matrix: Matrix): Matrix {
        return getSimpleOperationResult(matrix, true)
    }

    operator fun minus(matrix: Matrix): Matrix {
        return getSimpleOperationResult(matrix, false)
    }

    operator fun times(value: Int): Matrix {
        val resultArray = Array(rows) { Array(columns) { 0 } }
        for (i in 0 until rows) {
            for (j in 0 until columns) {
                resultArray[i][j] = this[i, j] * value
            }
        }
        return Matrix(resultArray)
    }

    operator fun times(matrix: Matrix): Matrix {
        if (columns != matrix.rows) throw IllegalArgumentException("Matrix can not multiply this matrix")
        val resultArray = Array(rows) { Array(matrix.columns) { 0 } }
        for (i in 0 until rows) {
            for (j in 0 until matrix.columns) {
                for (k in 0 until columns) {
                    resultArray[i][j] += this[i, k] * matrix[k, j]
                }
            }
        }
        return Matrix(resultArray)
    }

    override fun toString() =
        StringBuilder().apply {
            append("[")
            array.forEachIndexed { index, row ->
                append("[")
                row.forEachIndexed { index, value ->
                    if (index != row.size - 1) append("$value, ")
                    else append("$value")
                }
                if (index != array.size - 1) append("], ")
                else append("]")
            }
            append("]")
        }.toString()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null) return false
        if (this::class.java.isInstance(other::class.java)) return false

        other as Matrix

        if (!array.contentDeepEquals(other.array)) return false
        if (rows != other.rows) return false
        if (columns != other.columns) return false

        return true
    }

    override fun hashCode(): Int {
        var result = array.contentDeepHashCode()
        result = 31 * result + rows
        result = 31 * result + columns
        return result
    }

    private fun getSimpleOperationResult(matrix: Matrix, plus: Boolean): Matrix {
        if (rows != matrix.rows || columns != matrix.columns) throw IllegalArgumentException("Matrix can not ${if (plus) "plus" else "minus"} this matrix")
        val resultArray = Array(rows) { Array(columns) { 0 } }
        for (i in 0 until rows) {
            for (j in 0 until columns) {
                resultArray[i][j] = if (plus) this[i, j] + matrix[i, j] else this[i, j] - matrix[i, j]
            }
        }
        return Matrix(resultArray)
    }
}