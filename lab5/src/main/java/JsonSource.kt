import com.google.gson.Gson
import java.io.FileReader
import java.io.FileWriter
import java.lang.reflect.Type

abstract class JsonSource<T> {

    abstract val path: String

    abstract val gson: Gson

    abstract val type: Type

    abstract val handler: ErrorHandler

    fun get(): List<T> {
        try {
            FileReader(path).use { reader ->
                return gson.fromJson(reader, type)
            }
        } catch (e: Exception) {
            handler.handle(e)
            return listOf()
        }
    }

    fun save(data: List<T>) {
        try {
            FileWriter(path, false).use { writer ->
                gson.toJson(data, type, writer)
            }
        } catch (e: java.lang.Exception) {
            handler.handle(e)
        }
    }
}