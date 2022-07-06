package elchelomotos.com.ar.config

import elchelomotos.com.ar.routes.*
import io.ktor.server.routing.*
import io.ktor.server.application.*

fun Application.configureRouting() {
    routing {
        clientRoutes()
        parameterRoutes()
        productRoutes()
        salesRoutes()
        userRoutes()
    }
}
