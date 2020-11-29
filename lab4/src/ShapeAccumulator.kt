import shapes.Shape

class ShapeAccumulator {

    private val shapes = mutableListOf<Shape>()

    fun <T : Shape> add(shape: T) {
        shapes.add(shape)
    }

    fun <T : Shape> addAll(collection: Collection<T>) {
        shapes.addAll(collection)
    }

    fun getMaxArea(): Shape? {
        return shapes.maxBy { it.getArea() }
    }

    fun getMinArea(): Shape? {
        return shapes.minBy { it.getArea() }
    }

    fun getMaxPerimeter(): Shape? {
        return shapes.maxBy { it.getPerimeter() }
    }

    fun getMinPerimeter(): Shape? {
        return shapes.minBy { it.getPerimeter() }
    }

    fun getTotalArea(): Double {
        return shapes.sumByDouble { it.getArea() }
    }

    fun getTotalPerimeter(): Double {
        return shapes.sumByDouble { it.getPerimeter() }
    }
}