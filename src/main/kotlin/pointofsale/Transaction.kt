package pointofsale

import products.Product

data class Transaction(
    val products: List<Product>,
) {
    val total = products.sumOf { it.price.cents }
}
