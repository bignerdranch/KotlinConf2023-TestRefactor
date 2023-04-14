package products

interface ProductsManager {
    fun getAllProducts(): List<Product>
    fun getProductById(id: String): Product?
}