import pointofsale.PointOfSale
import products.ProductsManager
import receipts.ReceiptDisplay


fun main() {
    val productsManager = ProductsManager()
    val receiptDisplay = ReceiptDisplay()

    val pos = PointOfSale(productsManager, receiptDisplay)

    do {
        pos.showAvailableItems()

        println("Input id of item being purchased or type 'ring' to finalize transaction: ")
        val input = readln()

        if (input.isBlank()) continue
        if (input.lowercase() == "ring") break

        clearConsole()

        try {
            pos.addItemToTransaction(input)
        } catch (e: IllegalArgumentException) {
            println("$input is not associated with an item in the catalog")
        }
    } while (true)

    clearConsole()
    pos.printReceipt()
}

fun clearConsole() {
    repeat(50) { println("\n") }
}
