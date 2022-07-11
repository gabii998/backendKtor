package elchelomotos.com.ar.di

import elchelomotos.com.ar.repositories.*
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
    val productModule = module {
        singleOf(::ProductRepositoryImpl) { bind<ProductRepository>() }
    }


    install(Koin){
        modules(module,userModule,productModule)
    }
}