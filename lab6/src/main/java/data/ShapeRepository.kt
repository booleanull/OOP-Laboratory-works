package data

import data.shapes.Shape

interface ShapeRepository {

    fun get(): List<Shape>

    fun add(shape: Shape): List<Shape>

    fun remove(index: Int): List<Shape>

    fun moveUp(index: Int): List<Shape>

    fun moveDown(index: Int): List<Shape>
}