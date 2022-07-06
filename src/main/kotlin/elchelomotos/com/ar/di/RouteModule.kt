package elchelomotos.com.ar.di

import elchelomotos.com.ar.repositories.ClientRepository
import elchelomotos.com.ar.repositories.ClientRepositoryImpl
import elchelomotos.com.ar.repositories.UserRepository
import elchelomotos.com.ar.repositories.UserRepositoryImpl
import io.ktor.server.application.*
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin

fun Application.startKoin(){
    val module = module {
        singleOf(::ClientRepositoryImpl) { bind<ClientRepository>() }
    }
    val userModule = module {
        singleOf(::UserRepositoryImpl) { bind<UserRepository>() }
    }


    install(Koin){
        modules(module,userModule)
    }
}