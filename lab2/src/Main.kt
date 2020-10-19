import shapes.*

fun main() {
    val shapes = listOf(
        Circle(2.0),
        Circle(3.0),
        Rectangle(4.0, 2.0),
        Rectangle(6.0, 3.0),
        Square(6.0),
        Square(3.0),
        Triangle(3.0, 4.0, 5.0),
        Triangle(5.0, 3.0, 5.0)
    )

    println("Total S: ${shapes.sumByDouble { it.getArea() }}")
    println("Max P: ${shapes.maxBy { it.getPerimeter() }}")
    println("Min P: ${shapes.minBy { it.getPerimeter() }}")
    println("Max S: ${shapes.maxBy { it.getArea() }}")
    println("Min S: ${shapes.minBy { it.getArea() }}")
}