package data.shapes

import java.lang.IllegalArgumentException
import kotlin.math.pow

class Circle (val radius: Double): Shape {

    init {
        if (radius <= 0) throw IllegalArgumentException("Can not create circle")
    }

    override fun getPerimeter() = 2 * Math.PI * radius

    override fun getArea() = Math.PI * radius.pow(2)

    override fun toString() = "Circle(R = $radius, P = ${getPerimeter()}, S = ${getArea()})"
}