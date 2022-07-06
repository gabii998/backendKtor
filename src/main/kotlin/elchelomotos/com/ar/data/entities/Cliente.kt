package elchelomotos.com.ar.data.entities

import elchelomotos.com.ar.data.tables.Clientes
import org.ktorm.dsl.QueryRowSet


data class Cliente (
    var id :Int?,
    val nombre:String?,
    val apellido:String?,
    val telefono:String?,
    val mail:String?): Entity<Cliente>() {


    override fun mapFromDB(it: QueryRowSet): Cliente {
        return Cliente(it[Clientes.id],it[Clientes.nombre],it[Clientes.apellido],it[Clientes.telefono],it[Clientes.mail])
    }
}