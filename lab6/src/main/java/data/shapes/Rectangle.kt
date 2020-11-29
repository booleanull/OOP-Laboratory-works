package data.shapes

import java.lang.IllegalArgumentException

data class Rectangle(val a: Double, val b: Double) : Shape {

    init {
        if (a <= 0 || b <= 0) throw IllegalArgumentException("Can not create rectangle")
    }

    override fun getPerimeter() = (a + b) * 2

    override fun getArea() = a * b

    override fun toString() = "Rectangle(a = $a, b = $b, P = ${getPerimeter()}, S = ${getArea()})"
}