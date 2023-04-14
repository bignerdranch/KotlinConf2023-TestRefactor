package pointofsale

import money.USD
import org.junit.jupiter.api.Test
import products.NetworkProductsManager
import products.Product
import products.ProductsManager
import receipts.ReceiptDisplay

class PointOfSaleTest {
    private fun pointOfSale(
        productsManager: ProductsManager = NetworkProductsManager(),
        receiptDisplay: ReceiptDisplay = ReceiptDisplay(),
        output: ScreenOutput = TerminalOutput(),
        presenter: PointOfSaleOutputPresenter = PointOfSaleOutputPresenterImpl(),
    ): PointOfSale {
        return PointOfSale(
            productsManager = productsManager,
            receiptDisplay = receiptDisplay,
            screenOutput = output,
            presenter = presenter,
        )
    }

    @Test
    fun `addItemToTransaction should print transaction`() {
        val screenOutput = screenOutputMock()
        val productsManager = ProductsManagerStub(
            getProductByIdStub = { id -> Product("", "", USD(0)) }
        )
        val pointOfSale = pointOfSale(
            output = screenOutput,
            productsManager = productsManager
        )

        pointOfSale.addItemToTransaction("")

        assert(screenOutput.wasPrintCalled)
    }

    @Test
    fun `showAvailableItems prints a line for each item containing uid, name, and price`() {
        val screenOutput = screenOutputMock()
        val pointOfSale = pointOfSale(
            output = screenOutput
        )

        pointOfSale.showAvailableItems()

        assert(screenOutput.wasPrintCalled)
        assert(screenOutput.printCallContents == )
    }

    interface ScreenOutputMock : ScreenOutput {
        var wasPrintCalled: Boolean
        var printCallContents: String?
    }

    private fun screenOutputMock(): ScreenOutputMock {
        return object : ScreenOutputMock {
            override var wasPrintCalled: Boolean = false
            override var printCallContents: String? = null

            override fun print(output: String) {
                wasPrintCalled = true
                printCallContents = output
            }
        }
    }

    class ProductsManagerStub(
        val getAllProductsStub: () -> List<Product> = { emptyList() },
        val getProductByIdStub: (id: String) -> Product? = { null },
    ) : ProductsManager {
        override fun getAllProducts(): List<Product> {
            return getAllProductsStub()
        }

        override fun getProductById(id: String): Product? {
            return getProductByIdStub(id)
        }
    }

    class PresenterStub(
        val formatProductsForOutput: (List<Product>) -> String = {}
    ) : PointOfSaleOutputPresenter by PointOfSaleOutputPresenterImpl
}
