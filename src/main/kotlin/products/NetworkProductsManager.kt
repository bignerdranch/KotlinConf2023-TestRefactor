package products

import money.USD
import kotlin.random.Random

class NetworkProductsManager : ProductsManager {
    private val products = listOf(
        Product(
            uid = nextUid(),
            name = "Bubble Gum",
            price = USD(125),
        ),
        Product(
            uid = nextUid(),
            name = "T-Shirt",
            price = USD(4567),
        ),
        Product(
            uid = nextUid(),
            name = "Diamond Ring",
            price = USD(987399),
        ),
        Product(
            uid = nextUid(),
            name = "Frozen Pizza",
            price = USD(1199),
        ),
        Product(
            uid = nextUid(),
            name = "Eggs",
            price = USD(598),
        ),
        Product(
            uid = nextUid(),
            name = "1lb Apples",
            price = USD(383),
        ),
        Product(
            uid = nextUid(),
            name = "Lotion Sample",
            price = USD(0),
        ),
    )

    override fun getAllProducts(): List<Product> {
        return products
    }

    override fun getProductById(id: String): Product? {
        return getAllProducts().firstOrNull { it.uid == id }
    }
}

private fun nextUid() = Random.nextLong(until = 999).toString()
