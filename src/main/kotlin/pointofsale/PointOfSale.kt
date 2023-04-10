package pointofsale

import products.ProductsManager
import receipts.ReceiptDisplay

class PointOfSale(
    private val productsManager: ProductsManager,
    private val receiptDisplay: ReceiptDisplay,
) {
    private var transaction = Transaction(emptyList())

    fun showAvailableItems() {
        productsManager.getAllProducts().joinToString("\n") { "${it.uid} - ${it.name} | ${it.price}" }
            .also { println(it) }
    }

    fun addItemToTransaction(id: String) {
        val product = productsManager.getProductById(id)
            ?: throw IllegalArgumentException("No product matching id $id")
        transaction = transaction.copy(products = transaction.products + product)

        showTransaction()
    }

    private fun showTransaction() {
        for (product in transaction.products) {
            println("${product.name} | ${product.price}")
        }
        println("Total ${transaction.total}")
    }

    fun printReceipt() {
        receiptDisplay.renderReceipt(transaction.products)
    }
}