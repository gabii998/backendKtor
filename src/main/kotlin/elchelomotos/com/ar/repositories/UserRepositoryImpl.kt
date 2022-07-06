package elchelomotos.com.ar.repositories

import elchelomotos.com.ar.AppDatabase
import elchelomotos.com.ar.data.entities.Usuario
import elchelomotos.com.ar.data.tables.Usuarios
import org.ktorm.dsl.*

class UserRepositoryImpl:UserRepository {


    override fun getUser(usuario:String): Usuario? {
        val result = AppDatabase.getDatabase().from(Usuarios).select().where{Usuarios.usuario eq  usuario}.map {
            Usuario(it[Usuarios.idUsuario],it[Usuarios.usuario],it[Usuarios.password])
        }.firstOrNull()
        return  result
    }
}