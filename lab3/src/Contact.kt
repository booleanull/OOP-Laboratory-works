data class Contact(val firstName: String, val lastName: String, val numbers: List<PhoneNumber>) {

    override fun toString() =
        "$firstName $lastName ${if (numbers.isNotEmpty()) numbers.joinToString() else "No numbers"}"
}