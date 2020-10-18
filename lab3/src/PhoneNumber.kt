data class PhoneNumber(val number: String, val type: PhoneType) {

    enum class PhoneType {
        MOBILE,
        WORK,
        HOME
    }

    override fun toString() = "$number ($type)"
}