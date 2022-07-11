package elchelomotos.com.ar.routes

import elchelomotos.com.ar.repositories.ProductRepository
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.productRoutes() {

    val repository by inject<ProductRepository>()


    authenticate("auth-jwt") {
        get("/productos") {
            val limit = call.request.queryParameters.get("limit")
            val offset = call.request.queryParameters.get("offset")
            call.respond(repository.getProductos(limit,offset))
        }
    }


}