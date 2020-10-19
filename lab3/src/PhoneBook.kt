class PhoneBook(list: List<Contact>) {

    private val contacts: MutableList<Contact> = list.toMutableList()

    constructor(): this(listOf())

    fun getValue(id: Int): Contact? = contacts.getOrNull(id)

    operator fun get(id: Int): Contact? = getValue(id)

    fun update(id: Int, contact: Contact): Boolean {
        contacts.getOrNull(id) ?: return false
        contacts[id] = contact
        return true
    }

    fun update(current: Contact, contact: Contact): Boolean {
        val index = contacts.indexOf(current)
        if (index == -1) return false
        contacts[index] = contact
        return true
    }

    operator fun set(id: Int, contact: Contact) = update(id, contact)

    fun add(contact: Contact) = contacts.add(contact)

    fun remove(contact: Contact) = contacts.remove(contact)

    fun find(search: String): PhoneBook = PhoneBook(contacts.filter { contact ->
        contact.firstName.contains(search) || contact.lastName.contains(search) || contact.numbers.any { it.number.contains(search) }
    })

    override fun toString() = if (contacts.isNotEmpty()) contacts.joinToString(separator = "\n") else "Phone book is empty"
}