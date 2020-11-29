package data

import data.shapes.Shape

class ShapeRepositoryImpl(private val shapeSource: ShapeSource) : ShapeRepository {

    private val data = shapeSource.get().toMutableList()

    override fun get(): List<Shape> = data

    override fun add(shape: Shape): List<Shape> {
        data.add(shape)
        shapeSource.save(data)
        return data
    }

    override fun remove(index: Int): List<Shape> {
        data.removeAt(index)
        shapeSource.save(data)
        return data
    }

    override fun moveUp(index: Int): List<Shape> {
        if (index != 0) {
            val temp = data[index - 1]
            data[index - 1] = data[index]
            data[index] = temp
        }
        shapeSource.save(data)
        return data
    }

    override fun moveDown(index: Int): List<Shape> {
        if (index + 1 != data.size) {
            val temp = data[index + 1]
            data[index + 1] = data[index]
            data[index] = temp
        }
        shapeSource.save(data)
        return data
    }
}