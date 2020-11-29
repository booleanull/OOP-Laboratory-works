package data.shapes

import java.lang.IllegalArgumentException

data class Square(val a: Double) : Shape {

    init {
        if (a <= 0) throw IllegalArgumentException("Can not create square")
    }

    override fun getPerimeter() = a * 4

    override fun getArea() = a * a

    override fun toString() = "Square(a = $a, P = ${getPerimeter()}, S = ${getArea()})"
}