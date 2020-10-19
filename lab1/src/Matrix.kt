interface Matrix<T> {

    fun getRows(): Int

    fun getColumns(): Int

    fun getValue(x: Int, y: Int): T

    fun setValue(x: Int, y: Int, value: T)

    fun fold(matrix: Matrix<T>): Matrix<T>

    fun deduct(matrix: Matrix<T>): Matrix<T>

    fun multiply(value: T): Matrix<T>

    fun multiply(matrix: Matrix<T>): Matrix<T>

    fun determinant(): T
}