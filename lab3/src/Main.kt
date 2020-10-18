fun main(args: Array<String>) {

    val phoneBook = PhoneBook()
    val contact = Contact("Ivan", "Ivanov", listOf(
        PhoneNumber("+71000000002", PhoneNumber.PhoneType.WORK),
        PhoneNumber("+71000000003", PhoneNumber.PhoneType.MOBILE)
    ))
    phoneBook.add(contact)
    phoneBook.add(Contact("Dmitry", "Sidorov", listOf(
        PhoneNumber("+71000000005", PhoneNumber.PhoneType.HOME),
        PhoneNumber("+71000000006", PhoneNumber.PhoneType.MOBILE)
    )))
    println("Initial: ")
    println(phoneBook)
    println("Find Ivan: ")
    println(phoneBook.find("Ivan"))
    println("Find 101: ")
    println(phoneBook.find("101"))
    println("Find 1000: ")
    println(phoneBook.find("1000"))
    phoneBook.remove(contact)
    println("Remove Ivan: ")
    println(phoneBook)
    println("Get Dmitry: ")
    println(phoneBook[0])
}