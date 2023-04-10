package receipts

import money.USD
import org.junit.jupiter.api.Test
import products.Product
import kotlin.test.assertEquals

class ReceiptDisplayTest {
    private val receiptDisplay get() = ReceiptDisplay()

    @Test
    fun `renderPrice on Product returns stringified Product price in USD dollars-cents format`() {
        val sut = receiptDisplay

        val givenCents = 100L
        val givenProduct = Product(
            uid = "None",
            name = "None",
            price = USD(cents = givenCents),
        )

        val actual = sut.renderPrice(givenProduct)

        assertEquals(expected = "1.00", actual)
    }

    @Test
    fun `renderPrice on cents returns stringified cents in USD dollars-cents format`() {
        val sut = receiptDisplay

        val givenCents = 100L

        val actual = sut.renderPrice(givenCents)

        assertEquals(expected = "1.00", actual)
    }
}