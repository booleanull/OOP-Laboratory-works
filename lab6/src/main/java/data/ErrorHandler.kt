package data

interface ErrorHandler {
    fun handle(e: Throwable)
}