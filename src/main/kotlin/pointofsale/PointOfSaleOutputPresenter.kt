package pointofsale

import products.Product

interface PointOfSaleOutputPresenter {
    fun formatProductsForOutput(products: List<Product>): String
}

class PointOfSaleOutputPresenterImpl() : PointOfSaleOutputPresenter {
    override fun formatProductsForOutput(products: List<Product>): String {
        return products.joinToString("\n") { "${it.uid} - ${it.name} | ${it.price}" }
    }
}
