package products

import money.USD

data class Product(
    val uid: String,
    val name: String,
    val price: USD,
)
