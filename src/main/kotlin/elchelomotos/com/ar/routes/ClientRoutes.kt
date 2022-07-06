package elchelomotos.com.ar.routes

import elchelomotos.com.ar.core.CustomResponse
import elchelomotos.com.ar.data.entities.Cliente
import elchelomotos.com.ar.repositories.ClientRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.clientRoutes() {
    val repository by inject<ClientRepository>()

    authenticate("auth-jwt") {

        get("/clientes") {
            val result = repository.getClientList()
            call.respond(result)
        }
        //Insertar un cliente
        post("/clientes") {
            val client = call.receive<Cliente>()
            val result = repository.insertClient(client)
            if (result.success){
                call.respond(HttpStatusCode.OK,CustomResponse(client))
            }else{
                call.respond(HttpStatusCode.UnprocessableEntity,CustomResponse(null,result.message))
            }
        }


    }

}