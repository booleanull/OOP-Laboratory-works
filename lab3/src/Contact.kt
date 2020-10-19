data class Contact(val firstName: String, val lastName: String, val numbers: List<PhoneNumber>) {

    override fun toString() = StringBuilder().apply {
        append("$firstName $lastName: ")
        if (numbers.isEmpty()) {
            append("No numbers")
        }
        else {
            numbers.forEachIndexed { index, phoneNumber ->
                append(phoneNumber)
                if (index != numbers.size - 1) append(", ")
            }
        }
    }.toString()
}