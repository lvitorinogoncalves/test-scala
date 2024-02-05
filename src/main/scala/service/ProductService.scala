package service

import model.Product
import scala.concurrent.Future

class ProductService {
  val products: List[Product] = List(Product(1, "Samsung Galaxy", 500.50), Product(2, "Apple iPhone 13", 890.50))

  def getAllProducts(): Future[List[Product]] = Future.successful(products)

  def saveProduct(product: Product): Future[Product] = {
    Future.successful(product)
  }
}
