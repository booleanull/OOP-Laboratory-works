class PhoneBook(list: List<Contact>) {

    constructor(): this(listOf())

    private val contacts: MutableList<Contact> = list.toMutableList()

    fun getValue(id: Int): Contact = contacts[id]

    operator fun get(id: Int): Contact = getValue(id)

    fun update(id: Int, contact: Contact) {
        contacts[id] = contact
    }

    operator fun set(id: Int, contact: Contact) = update(id, contact)

    fun add(contact: Contact) = contacts.add(contact)

    fun remove(contact: Contact) = contacts.remove(contact)

    fun find(search: String): PhoneBook = PhoneBook(contacts.filter { contact ->
        contact.firstName.contains(search) || contact.lastName.contains(search) || contact.numbers.any { it.number.contains(search) }
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