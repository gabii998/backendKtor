package elchelomotos.com.ar.config

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import elchelomotos.com.ar.core.CustomResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.response.*

fun Application.configureSecurity() {

    install(Authentication){
        jwt("auth-jwt") {
            verifier(
                JWT
                    .require(Algorithm.HMAC256("SECRETO"))
                    .withAudience("audience")
                    .withIssuer("issuer").build()
            )
            //
            validate { jwtCredential ->
                if (jwtCredential.payload.getClaim("username").asString() != ""){
                    JWTPrincipal(jwtCredential.payload)
                }else {
                    null
                }
            }
            //
            challenge{defaultScheme, realm ->
                call.respond(HttpStatusCode.Unauthorized,CustomResponse(null,"No autorizado"))
            }
        }
    }

}
