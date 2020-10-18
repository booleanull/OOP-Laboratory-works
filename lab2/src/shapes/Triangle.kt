package shapes

import kotlin.math.sqrt

class Triangle(val a: Double, val b: Double, val c: Double) : Shape {

    init {
        if (a <= 0 || b <= 0 || c <= 0)
            throw IllegalArgumentException("Can not create triangle")

        if (a + b <= c || a + c <= b || b + c <= a)
            throw IllegalArgumentException("Can not create triangle")
    }

    override fun getPerimeter() = a + b + c

    override fun getArea(): Double {
        val p = getPerimeter() / 2
        return sqrt(p * (p - a) * (p - b) * (p - c))
    }

    override fun toString() = "Circle(a = $a, b = $b, c = $c, P = ${getPerimeter()}, S = ${getArea()})"
}