package pointofsale

import org.junit.jupiter.api.Test
import products.ProductsManager
import receipts.ReceiptDisplay

class PointOfSaleTest {
    private val pointOfSale: PointOfSale
        get() = PointOfSale(
            productsManager = ProductsManager(),
            receiptDisplay = ReceiptDisplay()
        )

    @Test
    fun `addItemToTransaction should print transaction`() {

    }

    @Test
    fun `showAvailableItems prints a line for each item containing uid, name, and price`() {

    }
}
