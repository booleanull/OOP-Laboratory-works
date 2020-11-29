import com.google.gson.*
import shapes.Shape
import java.lang.reflect.Type

class InterfaceAdapter : JsonSerializer<Shape?>, JsonDeserializer<Shape?> {

    override fun serialize(o: Shape?, type: Type?, jsonSerializationContext: JsonSerializationContext): JsonElement {
        val jsonObject = JsonObject()
        jsonObject.addProperty(NAME, o?.javaClass?.name)
        jsonObject.add(OBJECT, jsonSerializationContext.serialize(o))
        return jsonObject
    }

    override fun deserialize(json: JsonElement, type: Type?, context: JsonDeserializationContext): Shape {
        val jsonObject = json.asJsonObject
        val prim = jsonObject[NAME] as JsonPrimitive
        val className = prim.asString
        val clazz = getObjectClass(className)
        return context.deserialize(jsonObject[OBJECT], clazz)
    }

    private fun getObjectClass(className: String?): Class<*> {
        return try {
            Class.forName(className)
        } catch (e: ClassNotFoundException) {
            throw JsonParseException(e.message)
        }
    }

    companion object {
        private const val NAME = "name"
        private const val OBJECT = "item"
    }
}