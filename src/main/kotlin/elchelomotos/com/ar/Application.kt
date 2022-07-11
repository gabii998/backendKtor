package elchelomotos.com.ar

import elchelomotos.com.ar.di.startKoin
import io.ktor.server.engine.*
import io.ktor.server.tomcat.*
import elchelomotos.com.ar.config.*

fun main() {
    embeddedServer(Tomcat, port = 8000, host = "localhost") {
        configureRouting()
        configureSerialization()
        configureHTTP()
        configureSecurity()
        startKoin()
    }.start(wait = true)
}
