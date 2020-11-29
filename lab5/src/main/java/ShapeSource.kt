import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import shapes.Shape
import java.lang.reflect.Type

class ShapeSource : JsonSource<Shape>() {

    override val path: String = "shapes.json"

    override val gson: Gson = GsonBuilder().run {
        registerTypeAdapter(Shape::class.java, InterfaceAdapter())
        return@run create()
    }

    override val type: Type = object : TypeToken<List<Shape?>?>() {}.type

    override val handler: ErrorHandler = object : ErrorHandler {
        override fun handle(e: Throwable) {
            println(e.localizedMessage)
        }
    }
}
