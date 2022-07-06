package elchelomotos.com.ar.repositories

import elchelomotos.com.ar.data.entities.Usuario

interface UserRepository {
    fun getUser(usuario:String):Usuario?
}