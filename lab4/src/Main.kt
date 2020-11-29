import shapes.*

fun main() {
    val shapes = listOf<Shape>(Triangle(3.0, 3.0, 3.0), Rectangle(2.0, 3.0), Circle(3.0))
    val circles = listOf<Shape>(Circle(5.0), Circle(3.0), Circle(4.0))

    val accumulator = ShapeAccumulator()
    accumulator.addAll(shapes)
    accumulator.addAll(circles)


    println("Max area: ${accumulator.getMaxArea()}")
    println("Min area: ${accumulator.getMinArea()}")
    println("Max perimeter: ${accumulator.getMaxPerimeter()}")
    println("Min perimeter: ${accumulator.getMinPerimeter()}")
    println("Total area: ${accumulator.getTotalArea()}")
    println("Total perimeter: ${accumulator.getTotalPerimeter()}")
}