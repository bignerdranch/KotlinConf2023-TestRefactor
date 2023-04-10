package receipts

import products.Product
import java.text.DecimalFormat

class ReceiptDisplay {
    private val decimalFormat = DecimalFormat.getInstance().apply {
        maximumFractionDigits = 2
        minimumFractionDigits = 2
    }

    fun renderReceipt(products: List<Product>) {
        var total = 0L

        for (product in products) {
            println("${product.name} | ${renderPrice(product)}")

            total += product.price.cents
        }

        println("Total | ${renderPrice(total)}")
    }

    fun renderPrice(product: Product): String {
        return decimalFormat.format(product.price.cents.toDouble() / 100)
    }

    fun renderPrice(cents: Long): String {
        return decimalFormat.format(cents.toDouble() / 100)
    }
}
