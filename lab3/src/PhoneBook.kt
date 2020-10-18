class PhoneBook(list: List<Contact>) {

    constructor(): this(listOf())

    private val contacts: MutableList<Contact> = list.toMutableList()

    operator fun get(id: Int): Contact = contacts[id]

    operator fun set(id: Int, contact: Contact) {
        contacts[id] = contact
    }

    fun add(contact: Contact) = contacts.add(contact)

    fun remove(contact: Contact) = contacts.remove(contact)

    fun find(search: String): PhoneBook = PhoneBook(contacts.filter { contact ->
        contact.firstName.contains(search) || contact.lastName.contains(search) || contact.numbers.map { it.number.contains(search) }.find { it } ?: false
    })

    override fun toString() = StringBuilder().apply {
        if (contacts.isEmpty()) append("Phone book is empty")
        else {
            contacts.forEachIndexed { index, contact ->
                append(contact)
                if (index != contacts.size - 1) append("\n")
            }
        }
    }.toString()
}