import shapes.Circle
import shapes.Rectangle
import shapes.Square

fun main() {
    ShapeSource().apply {
        save(listOf(Circle(4.0), Rectangle(2.0, 2.0), Square(3.0)))
        println(get())
    }
}