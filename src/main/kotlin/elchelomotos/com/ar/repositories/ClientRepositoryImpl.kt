package elchelomotos.com.ar.repositories

import elchelomotos.com.ar.AppDatabase
import elchelomotos.com.ar.core.DatabaseResult
import elchelomotos.com.ar.data.entities.Cliente
import elchelomotos.com.ar.data.tables.Clientes
import org.ktorm.dsl.from
import org.ktorm.dsl.insert
import org.ktorm.dsl.map
import org.ktorm.dsl.select

class ClientRepositoryImpl:ClientRepository {

    override fun getClientList(): List<Cliente> {
        val result:List<Cliente> = AppDatabase.getDatabase().from(Clientes).select().map {
            Cliente(it[Clientes.id],it[Clientes.nombre],it[Clientes.apellido],it[Clientes.telefono],it[Clientes.mail])
        }
        return result
    }

    override fun insertClient(cliente: Cliente): DatabaseResult<Cliente> {
        return try {
            val result = AppDatabase.getDatabase().insert(Clientes){
                set(it.mail,cliente.mail)
                set(it.apellido,cliente.apellido)
                set(it.nombre,cliente.nombre)
                set(it.telefono,cliente.telefono )
            }
            DatabaseResult(cliente,null,result > 0)
        }catch (e:Exception){
            DatabaseResult(null,e.localizedMessage,false)
        }
    }

}