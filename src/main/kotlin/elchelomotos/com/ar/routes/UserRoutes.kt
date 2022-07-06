package elchelomotos.com.ar.routes

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import elchelomotos.com.ar.core.CustomResponse
import elchelomotos.com.ar.data.entities.Usuario
import elchelomotos.com.ar.repositories.UserRepository
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject
import java.util.*

fun Route.userRoutes() {

    val repository by inject<UserRepository>()

    post("/login") {
        val user = call.receive<Usuario>()

        //Datos vacios
        if ( user.usuario == null || user.password == null) {
            //Retornar error
            call.respond(CustomResponse(null,"Username o password vacios"))
            return@post
        }

        val result = repository.getUser(user.usuario)
        //El quey no arrojo resultados
        if (result == null) {
            //Retornar error
            call.respond(CustomResponse(null,"No existe un usuario con ese nombre"))
            return@post
        }
        if (user.password == result.password) {
            //Retornar ok

            val token = JWT.create()
                .withAudience("audience")
                .withIssuer("issuer")
                .withClaim("username", user.usuario)
                .withExpiresAt(Date(System.currentTimeMillis() + 600000))
                .sign(Algorithm.HMAC256("SECRETO"))


            call.respond(CustomResponse(hashMapOf("token" to token),"Logueado correctamente"))
            return@post
        }
        call.respond(CustomResponse(null,"Password erronea"))
        //Retornar error


    }
}