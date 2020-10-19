fun main() {
    val matrixA = Matrix(arrayOf(arrayOf(0, 2, 4), arrayOf(6, 8, 10), arrayOf(12, 14, 16)))
    val matrixB = Matrix(arrayOf(arrayOf(0, 1, 2), arrayOf(3, 4, 5), arrayOf(6, 7, 8)))

    println("A: $matrixA")
    println("B: $matrixB")
    println("A + B: ${matrixA + matrixB}")
    println("A - B: ${matrixA - matrixB}")
    println("A * 2: ${matrixA * 2}")
    println("A * B: ${matrixA * matrixB}")
    println("D(A): ${matrixA.getDeterminant()}")
    println("A == B: ${matrixA == matrixB}")
    println("A == (B * 2): ${matrixA == (matrixB * 2)}")
}