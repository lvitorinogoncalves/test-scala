package resource

import akka.actor.ActorSystem
import model.Product
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import service.ProductService
import spray.json.DefaultJsonProtocol._
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util._

object ProductServer extends App {

  implicit val system = ActorSystem("ProductServer")

  val productService = new ProductService()

  implicit val productFormat = jsonFormat3(Product)

  val route = path("products" / "heartbeat") {
    get {
      complete("Sucess!")
    }
  } ~ path("products" / "test") {
    get {
      complete("Verified!")
    }
  } ~ path("products") {
    get {
      onComplete(productService.getAllProducts()) {
        case util.Success(res) => complete(res)
        case util.Failure(exception) => complete(StatusCodes.InternalServerError)
      }
    } ~ post {
      entity(as[Product]) { product =>
        onComplete(productService.saveProduct(product)) {
          case Success(res) => complete(res)
          case Failure(exception) => complete(StatusCodes.InternalServerError)
        }
      }
    }
  }

  val server = Http().newServerAt("localhost", 9090).bind(route)
  server.map { _ =>
    println("Sucessfully started on localhost:9090")
  } recover { case ex =>
    println("Failed to start the server due to: " + ex.getMessage)
  }
}
